import java.util.HashMap;
import java.util.ArrayList;
import org.antlr.v4.runtime.tree.TerminalNode;

public class AddVisitor extends SummerBaseVisitor<Integer> {
    
    HashMap<String, Object> variables = new HashMap<String, Object>(); 

    // Roots
    //---------------------------------------------------------
    @Override
    public Integer visitRootMultiLine(SummerParser.RootMultiLineContext ctx)
    {
        visit(ctx.line());
        return 0;
    }

    @Override
    public Integer visitRootSingleLine(SummerParser.RootSingleLineContext ctx)
    {
        visit(ctx.line());
        return 0;
    }

    // Lines
    //---------------------------------------------------------
    @Override
    public Integer visitVarAssign(SummerParser.VarAssignContext ctx)
    {
        variables.put(ctx.ID().getText(), visit(ctx.value()));
        return 0;
    }

    @Override
    public Integer visitFuncDefinition(SummerParser.FuncDefinitionContext ctx)
    {
        System.out.println("Function " + ctx.ID().getText());
        ArrayList<Object> numbers = new ArrayList<>();
        if (ctx.params() != null) {
            for (SummerParser.ValueContext expr : ctx.params().value()) {
                numbers.add(super.visit(expr));
            }
        }
        return null;
    }

    // Params
    //---------------------------------------------------------
    // @Override
    // public Integer visitParamsMulti(SummerParser.ParamsMultiContext ctx)
    // {
    //     ArrayList<Object> numbers = new ArrayList<>();
    //     if (ctx.value() != null) {
    //         for (TerminalNode tokenNode : ctx.value) {
    //             numbers.add(Integer.valueOf(tokenNode.getText()));
    //         }
    //     }
    //     System.out.println(numbers);
    //     return 0;
    // }

    // @Override
    // public Integer visitParamsSingle(SummerParser.ParamsSingleContext ctx)
    // {
    //     ArrayList<Object> params =  new ArrayList<Object>();
    //     params.add(visit(ctx.value()));
    //     return 0;
    // }

    // Expressions
    //---------------------------------------------------------
    @Override
    public Integer visitValueID(SummerParser.ValueIDContext ctx)
    {
        return Integer.valueOf(ctx.ID().getText());
    }

    @Override
    public Integer visitValueNum(SummerParser.ValueNumContext ctx)
    {
        return Integer.valueOf(ctx.NUM().getText());
    }
}
