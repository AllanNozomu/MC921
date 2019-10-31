import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.antlr.v4.runtime.tree.TerminalNode;

public class AddVisitor extends GramaticaBaseVisitor < Integer > {

    private static boolean isNumeric(String strNum) {
        try {
            Integer d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    HashSet < String > variables = new HashSet < String > ();
    HashSet < String > functions = new HashSet < String > ();
    HashMap < String, String > functionsIds = new HashMap < String, String > ();
    HashMap < String, ArrayList < String >> params = new HashMap < String, ArrayList < String >> ();
    ArrayList < String > callParams = new ArrayList < String > ();
    StringBuilder resBuilder = new StringBuilder();
    StringBuilder mainBodyBuilder = new StringBuilder();
    

    String currFunc = "";
    String declarations = "";
    int counter = 1;
    int localCounter = 1;

    // Roots
    //---------------------------------------------------------
    @Override
    public Integer visitRootMultiLine(GramaticaParser.RootMultiLineContext ctx) {
        visit(ctx.line());
        visit(ctx.root());
        return 0;
    }

    @Override
    public Integer visitRootNone(GramaticaParser.RootNoneContext ctx) {
        System.out.println(resBuilder);

        System.out.println("\ndefine void @start() {");

        String mainBody = mainBodyBuilder.toString().replaceAll("\n", "\n  ");
        System.out.println("  " + mainBody);
        System.out.println("  ret void\n}");
        
        return 0;
    }

    // Lines
    //---------------------------------------------------------
    @Override
    public Integer visitVarAssign(GramaticaParser.VarAssignContext ctx) {
        String varName = ctx.ID().getText();
        resBuilder.append(AddVisitor.getDeclareVar(varName));
        resBuilder.append("\n");
        if (variables.contains(varName) || functions.contains(varName))
            System.out.println("Symbol already declared: " + varName);
        else
            variables.add(ctx.ID().getText());

        int tempName = visit(ctx.exprE());
        mainBodyBuilder.append(AddVisitor.getAssignVar(tempName + "", varName) + "\n");
        
        return 0;
    }

    @Override
    public Integer visitFuncDefinition(GramaticaParser.FuncDefinitionContext ctx) {
        String funcName = ctx.ID().getText();
        currFunc = funcName;

        if (variables.contains(funcName))
            System.out.println("Symbol already declared: " + funcName);
        else {
            functions.add(currFunc);
        }

        params.put(currFunc, new ArrayList < String > ());
        visit(ctx.params());

        functionsIds.put(funcName, funcName);
        resBuilder.append(AddVisitor.getDeclareFunc(functionsIds.get(funcName), params.get(currFunc)));
        resBuilder.append("\n");
        Integer res = visit(ctx.exprE());

        currFunc = "";
        resBuilder.append(AddVisitor.getFuncReturn(res));
        resBuilder.append("\n");
        return 0;
    }

    // Params
    //---------------------------------------------------------
    @Override
    public Integer visitParamsMulti(GramaticaParser.ParamsMultiContext ctx) {
        String paramName = ctx.ID().getText();
        params.get(currFunc).add(paramName);
        return 1 + visit(ctx.params());
    }

    @Override
    public Integer visitParamsID(GramaticaParser.ParamsIDContext ctx) {
        String paramName = ctx.ID().getText();
        params.get(currFunc).add(paramName);
        return 1;
    }

    @Override
    public Integer visitParamsNone(GramaticaParser.ParamsNoneContext ctx) {
        return 0;
    }

    static String paramsToString(ArrayList < String > parameters) {
        String res = "";
        for (int i = 0; i < parameters.size(); ++i) {
            res += ", i32 %p" + i;
        }
        return res.trim().substring(1);
    }

    // Call
    @Override
    public Integer visitParamsCallMulti(GramaticaParser.ParamsCallMultiContext ctx) {
        visit(ctx.paramValue());
        return 1 + visit(ctx.paramsCall());
    }

    @Override
    public Integer visitParamsCallSingle(GramaticaParser.ParamsCallSingleContext ctx) {
        visit(ctx.paramValue());
        return 1;
    }

    @Override
    public Integer visitParamsCallNone(GramaticaParser.ParamsCallNoneContext ctx) {
        return 0;
    }

    @Override
    public Integer visitParamValueNum(GramaticaParser.ParamValueNumContext ctx) {
        callParams.add(ctx.NUM().getText());

        return 0;
    }

    @Override
    public Integer visitParamValueID(GramaticaParser.ParamValueIDContext ctx) {
        callParams.add(ctx.ID().getText());

        return 0;
    }

    // Expressions
    //---------------------------------------------------------
    @Override
    public Integer visitExprEConversion(GramaticaParser.ExprEConversionContext ctx) {
        return visit(ctx.exprT());
    }
    @Override
    public Integer visitExprESum(GramaticaParser.ExprESumContext ctx) {
        int tempNameE = visit(ctx.exprE());
        int tempNameT = visit(ctx.exprT());
        if (currFunc != "") {
            resBuilder.append(AddVisitor.getAddOperation("  %l" + this.localCounter, " %l" + tempNameE, " %l" + tempNameT));
            resBuilder.append("\n");
            return this.localCounter++;
        } else {
            mainBodyBuilder.append(AddVisitor.getAddOperation("%v" + this.counter, "%v" + tempNameE, "%v" + tempNameT));
            mainBodyBuilder.append("\n");
            return this.counter++;
        }
    }
    @Override
    public Integer visitExprESub(GramaticaParser.ExprESubContext ctx) {
        int tempNameE = visit(ctx.exprE());
        int tempNameT = visit(ctx.exprT());
        if (currFunc != "") {
            resBuilder.append(AddVisitor.getSubOperation("  %l" + this.localCounter, "%l" + tempNameE, "%l" + tempNameT));
            resBuilder.append("\n");
            return this.localCounter++;
        } else {
            mainBodyBuilder.append(AddVisitor.getSubOperation("%v" + this.counter, "%v" + tempNameE, "%v" + tempNameT));
            mainBodyBuilder.append("\n");
            return this.counter++;
        }
    }

    // T
    @Override
    public Integer visitExprTConversion(GramaticaParser.ExprTConversionContext ctx) {
        return visit(ctx.exprF());
    }
    @Override
    public Integer visitExprTMul(GramaticaParser.ExprTMulContext ctx) {
        int tempNameT = visit(ctx.exprT());
        int tempNameF = visit(ctx.exprF());
        if (currFunc != "") {
            resBuilder.append(AddVisitor.getMulOperation("  %l" + this.localCounter, "%l" + tempNameT, "%l" + tempNameF));
            resBuilder.append("\n");
            return this.localCounter++;
        } else {
            mainBodyBuilder.append(AddVisitor.getMulOperation("%v" + this.counter, "%v" + tempNameT, "%v" + tempNameF));
            mainBodyBuilder.append("\n");
            return this.counter++;
        }
    }
    @Override
    public Integer visitExprTDiv(GramaticaParser.ExprTDivContext ctx) {
        int tempNameT = visit(ctx.exprT());
        int tempNameF = visit(ctx.exprF());
        if (currFunc != "") {
            resBuilder.append(AddVisitor.getSdivOperation("  %l" + this.localCounter, "%l" + tempNameT, "%l" + tempNameF));
            resBuilder.append("\n");
            return this.localCounter++;
        } else {
            mainBodyBuilder.append(AddVisitor.getSdivOperation("%v" + this.counter, "%v" + tempNameT, "%v" + tempNameF));
            mainBodyBuilder.append("\n");
            return this.counter++;
        }
    }

    // F
    @Override
    public Integer visitExprFParen(GramaticaParser.ExprFParenContext ctx) {
        return visit(ctx.exprE());
    }
    @Override
    public Integer visitExprFID(GramaticaParser.ExprFIDContext ctx) {
        String varName = ctx.ID().getText();

        if (currFunc != "") {
            Integer localIndex = this.params.get(currFunc).indexOf(varName);
            if (localIndex < 0){
                resBuilder.append(AddVisitor.getLoadOperation("  %l" + this.localCounter, varName));
                resBuilder.append("\n");
            } else {
                resBuilder.append(AddVisitor.getAddOperation("  %l" + this.localCounter, "0", "%p" + localIndex));
                resBuilder.append("\n");
            }

            return this.localCounter++;
        } else {
            mainBodyBuilder.append(AddVisitor.getLoadOperation("%v" + this.counter, varName)).append("\n");
            return this.counter++;
        }
    }

    @Override
    public Integer visitExprFNum(GramaticaParser.ExprFNumContext ctx) {
        if (currFunc != "") {
            resBuilder.append(AddVisitor.getAddOperation("  %l" + this.localCounter, "0", ctx.NUM().getText()));
            resBuilder.append("\n");
            return this.localCounter++;
        } else {
            mainBodyBuilder.append(AddVisitor.getAddOperation("%v" + this.counter, "0", ctx.NUM().getText())).append("\n");
            return this.counter++;
        }
    }

    public String evalParamsToString(ArrayList < String > callParams) {
        String res = "";

        for (String param: callParams) {
            if (isNumeric(param)) {
                res += ", i32 " + param;
            } else {
                Integer localIndex = currFunc == "" ? -1 : this.params.get(currFunc).indexOf(param);
                if (localIndex >= 0) {
                    res += ", i32 %p" + localIndex;
                } else {
                    if (currFunc != ""){
                        resBuilder.append(AddVisitor.getLoadOperation("  %l" + localCounter, param) + "\n");
                        res += ", i32 %l" + localCounter++;
                    } else {
                        mainBodyBuilder.append(AddVisitor.getLoadOperation("%v" + counter, param)).append("\n");
                        res += ", i32 %v" + counter++;
                    }
                }
            }
        }
        return res.trim().substring(1);
    }

    @Override
    public Integer visitExprFFunc(GramaticaParser.ExprFFuncContext ctx) {
        String funcName = ctx.ID().getText();

        callParams = new ArrayList < String > ();

        if (variables.contains(funcName))
            System.out.println("Bad used symbol: " + funcName);
        else if (!functions.contains(funcName))
            System.out.println("Symbol undeclared: " + funcName);

        if (currFunc != "") {
            Integer paramCount = visit(ctx.paramsCall());
            String evaluatedParams = evalParamsToString(callParams);

            resBuilder.append(AddVisitor.getCallFunc("  %l" + this.localCounter, functionsIds.get(funcName)));
            resBuilder.append("(" + evaluatedParams + ")\n");
            if (params.get(funcName) != null && params.get(funcName).size() != paramCount)
                System.out.println("Bad argument count: " + funcName);
            return this.localCounter++;
        } else {
            Integer paramCount = visit(ctx.paramsCall());
            String evaluatedParams = evalParamsToString(callParams);

            mainBodyBuilder.append(AddVisitor.getCallFunc("%v" + this.counter, functionsIds.get(funcName)));
            mainBodyBuilder.append("(" + evaluatedParams + ")\n");
            if (params.get(funcName) != null && params.get(funcName).size() != paramCount)
                System.out.println("Bad argument count: " + funcName);
            return this.counter++;
        }
    }

    private static String getDeclareVar(String varName) {
        return "@" + varName + " = global i32 0;";
    }

    private static String getDeclareFunc(String funcId, ArrayList<String> funcParams) {
        return "define i32 @f_" + funcId + "(" + AddVisitor.paramsToString(funcParams) + ") {";
    }

    private static String getAssignVar(String tempName, String varName) {
        return "store i32 %v" + tempName + ", i32* @" + varName + ";";
    }

    private static String getFuncReturn(int res) {
        return "  ret i32 %l" + res + "\n}";
    }

    private static String getAddOperation(String varName, String firstOperand, String secondOperand) {
        return varName + " = add i32 " + firstOperand + ", " + secondOperand;
    }

    private static String getSubOperation(String varName, String firstOperand, String secondOperand) {
        return varName + " = sub i32 " + firstOperand + ", " + secondOperand;
    }

    private static String getMulOperation(String varName, String firstOperand, String secondOperand) {
        return varName + " = mul i32 " + firstOperand + ", " + secondOperand;
    }

    private static String getSdivOperation(String varName, String firstOperand, String secondOperand) {
        return varName + " = sdiv i32 " + firstOperand + ", " + secondOperand;
    }

    private static String getLoadOperation(String varName, String ptrName) {
        return varName + " = load i32, i32* @" + ptrName;
    }

    private static String getCallFunc(String varName, String funcName) {
        return varName + " = call i32 @f_" + funcName;
    }
}