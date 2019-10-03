import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.antlr.v4.runtime.tree.TerminalNode;

public class AddVisitor extends SummerBaseVisitor<Integer> {
    
    HashSet<String> variables = new HashSet<String>(); 
    HashSet<String> functions = new HashSet<String>(); 
    HashMap<String, HashSet<String>> params = new HashMap<String, HashSet<String>>();
    String currFunc = "";

    // Roots
    //---------------------------------------------------------
    @Override
    public Integer visitRootMultiLine(SummerParser.RootMultiLineContext ctx)
    {
        visit(ctx.line());
        visit(ctx.root());
        return 0;
    }

    @Override
    public Integer visitRootNone(SummerParser.RootNoneContext ctx)
    {
        return 0;
    }

    // Lines
    //---------------------------------------------------------
    @Override
    public Integer visitVarAssign(SummerParser.VarAssignContext ctx)
    {
        String varName = ctx.ID().getText();
        if (variables.contains(varName))
            System.out.println("Symbol already declared: " + varName);
        else if (functions.contains(varName))
            System.out.println("Symbol already declared: " + varName);
        else
            variables.add(ctx.ID().getText());

        visit(ctx.exprE());
        
        return 0;
    }

    @Override
    public Integer visitFuncDefinition(SummerParser.FuncDefinitionContext ctx)
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
     public Integer visitParamsMulti(SummerParser.ParamsMultiContext ctx)
     {
         String paramName = ctx.ID().getText();
         params.get(currFunc).add(paramName);
         return 1 + visit(ctx.params());
     }

     @Override
     public Integer visitParamsID(SummerParser.ParamsIDContext ctx)
     {
         String paramName = ctx.ID().getText();
         params.get(currFunc).add(paramName);
         return 1;
     }
     
     @Override
     public Integer visitParamsNone(SummerParser.ParamsNoneContext ctx)
     {
         return 0;
     }

    // Call
     @Override
     public Integer visitParamsCallMulti(SummerParser.ParamsCallMultiContext ctx)
     {
         return 1 + visit(ctx.paramsCall());
     }

     @Override
     public Integer visitParamsCallID(SummerParser.ParamsCallIDContext ctx)
     {
         return 1;
     }
     
     @Override
     public Integer visitParamsCallNone(SummerParser.ParamsCallNoneContext ctx)
     {
         return 0;
     }

    // Expressions
    //---------------------------------------------------------
    @Override
    public Integer visitExprEConversion(SummerParser.ExprEConversionContext ctx){
        return visit(ctx.exprT());
    }
    @Override
    public Integer visitExprESum(SummerParser.ExprESumContext ctx){
        return visit(ctx.exprE()) + visit(ctx.exprT());
    }
    @Override
    public Integer visitExprESub(SummerParser.ExprESubContext ctx){
        return visit(ctx.exprE()) + visit(ctx.exprT());
    }

    // T
    @Override
    public Integer visitExprTConversion(SummerParser.ExprTConversionContext ctx){
        return visit(ctx.exprF());
    }
    @Override
    public Integer visitExprTMul(SummerParser.ExprTMulContext ctx){
        return visit(ctx.exprT()) + visit(ctx.exprF());
    }
    @Override
    public Integer visitExprTDiv(SummerParser.ExprTDivContext ctx){
        return visit(ctx.exprT()) + visit(ctx.exprF());
    }

    // F
    @Override
    public Integer visitExprFParen(SummerParser.ExprFParenContext ctx){
        return visit(ctx.exprE());
    }
    @Override
    public Integer visitExprFVal(SummerParser.ExprFValContext ctx){
        return visit(ctx.value());
    }

    @Override
    public Integer visitExprFFunc(SummerParser.ExprFFuncContext ctx){
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
    public Integer visitValueID(SummerParser.ValueIDContext ctx)
    {
        String varName = ctx.ID().getText(); 

        if (currFunc == "" || !params.get(currFunc).contains(varName)){
          if (functions.contains(varName))
              System.out.println("Bad used symbol: " + varName);
          else if (!variables.contains(varName))
              System.out.println("Symbol undeclared: " + varName);
        }
 
        return 0;
    }

    @Override
    public Integer visitValueNum(SummerParser.ValueNumContext ctx)
    {
        return Integer.valueOf(ctx.NUM().getText());
    }
}
