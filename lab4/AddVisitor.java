import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.antlr.v4.runtime.tree.TerminalNode;

public class AddVisitor extends GramaticaBaseVisitor<Integer> {
    
    HashSet<String> variables = new HashSet<String>(); 
    HashSet<String> functions = new HashSet<String>(); 
    HashMap<String, HashSet<String>> params = new HashMap<String, HashSet<String>>();
    String currFunc = "";
    String declarations = "";
    String mainBody = "";
    int counter = 1;

    // public String assignSimpleValue(String key, int value) {
    //     System.out.println();
    // }

    // public String assignVariableValue(String key, String value) {

    // }

    // public String assignVariableFunction(String key, String value){

    // }

    // @Override
    // public Integer visitCode(GramaticaParser.CodeContext ctx)
    // {
    //     visit(ctx.root());
    //     System.out.println(declarations);

    //     System.out.println("define i32 @start(i32){");
    //     System.out.println(mainBody);
    //     System.out.println("}");
    //     return 0;
    // }

    // Roots
    //---------------------------------------------------------
    @Override
    public Integer visitRootMultiLine(GramaticaParser.RootMultiLineContext ctx)
    {
        visit(ctx.line());
        visit(ctx.root());
        return 0;
    }

    @Override
    public Integer visitRootNone(GramaticaParser.RootNoneContext ctx)
    {
        return 0;
    }

    // Lines
    //---------------------------------------------------------
    @Override
    public Integer visitVarAssign(GramaticaParser.VarAssignContext ctx)
    {
        String varName = ctx.ID().getText();
        System.out.print("@" + varName + "= global i32 ");

        if (variables.contains(varName))
            System.out.println("Symbol already declared: " + varName);
        else if (functions.contains(varName))
            System.out.println("Symbol already declared: " + varName);
        else
            variables.add(ctx.ID().getText());

        visit(ctx.exprE());
        System.out.println(";");
        
        return 0;
    }

    @Override
    public Integer visitFuncDefinition(GramaticaParser.FuncDefinitionContext ctx)
    {
        String funcName = ctx.ID().getText();
        currFunc = funcName;
        
        if (variables.contains(funcName))
            System.out.println("Symbol already declared: " + funcName);
        else if (functions.contains(funcName))
            System.out.println("Symbol already declared: " + funcName);
        else{
            functions.add(currFunc);
        }

        params.put(currFunc, new HashSet<String>());
        visit(ctx.params());

        visit(ctx.exprE());
        currFunc = "";

        return 0;
    }

    // Params
    //---------------------------------------------------------
     @Override
     public Integer visitParamsMulti(GramaticaParser.ParamsMultiContext ctx)
     {
         String paramName = ctx.ID().getText();
         params.get(currFunc).add(paramName);
         return 1 + visit(ctx.params());
     }

     @Override
     public Integer visitParamsID(GramaticaParser.ParamsIDContext ctx)
     {
         String paramName = ctx.ID().getText();
         params.get(currFunc).add(paramName);
         return 1;
     }
     
     @Override
     public Integer visitParamsNone(GramaticaParser.ParamsNoneContext ctx)
     {
         return 0;
     }

    // Call
     @Override
     public Integer visitParamsCallMulti(GramaticaParser.ParamsCallMultiContext ctx)
     {
         return 1 + visit(ctx.paramsCall());
     }

     @Override
     public Integer visitParamsCallID(GramaticaParser.ParamsCallIDContext ctx)
     {
         return 1;
     }
     
     @Override
     public Integer visitParamsCallNone(GramaticaParser.ParamsCallNoneContext ctx)
     {
         return 0;
     }

    // Expressions
    //---------------------------------------------------------
    @Override
    public Integer visitExprEConversion(GramaticaParser.ExprEConversionContext ctx){
        return visit(ctx.exprT());
    }
    @Override
    public Integer visitExprESum(GramaticaParser.ExprESumContext ctx){
        return visit(ctx.exprE()) + visit(ctx.exprT());
    }
    @Override
    public Integer visitExprESub(GramaticaParser.ExprESubContext ctx){
        return visit(ctx.exprE()) + visit(ctx.exprT());
    }

    // T
    @Override
    public Integer visitExprTConversion(GramaticaParser.ExprTConversionContext ctx){
        return visit(ctx.exprF());
    }
    @Override
    public Integer visitExprTMul(GramaticaParser.ExprTMulContext ctx){
        return visit(ctx.exprT()) + visit(ctx.exprF());
    }
    @Override
    public Integer visitExprTDiv(GramaticaParser.ExprTDivContext ctx){
        return visit(ctx.exprT()) + visit(ctx.exprF());
    }

    // F
    @Override
    public Integer visitExprFParen(GramaticaParser.ExprFParenContext ctx){
        return visit(ctx.exprE());
    }
    @Override
    public Integer visitExprFVal(GramaticaParser.ExprFValContext ctx){
        return visit(ctx.value());
    }

    @Override
    public Integer visitExprFFunc(GramaticaParser.ExprFFuncContext ctx){
        String funcName = ctx.ID().getText();

        if (variables.contains(funcName))
          System.out.println("Bad used symbol: " + funcName);
        else if (!functions.contains(funcName))
            System.out.println("Symbol undeclared: " + funcName);

        Integer paramCount = visit(ctx.paramsCall());
        if (params.get(funcName) != null && params.get(funcName).size() != paramCount)
            System.out.println("Bad argument count: " + funcName);

        return 0; 
    }

    // Values
    //---------------------------------------------------------
    @Override
    public Integer visitValueID(GramaticaParser.ValueIDContext ctx)
    {
        String varName = ctx.ID().getText(); 

        if (currFunc == "" || !params.get(currFunc).contains(varName)){
          if (functions.contains(varName))
              System.out.println("Bad used symbol: " + varName);
          else if (!variables.contains(varName))
              System.out.println("Symbol undeclared: " + varName);
        }
        System.out.println(ctx.ID().getText());
        return 0;
    }

    @Override
    public Integer visitValueNum(GramaticaParser.ValueNumContext ctx)
    {
        System.out.println(ctx.NUM().getText());
        return Integer.valueOf(ctx.NUM().getText());
    }
}
