// Generated from Summer.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SummerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SummerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code RootMultiLine}
	 * labeled alternative in {@link SummerParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRootMultiLine(SummerParser.RootMultiLineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RootSingleLine}
	 * labeled alternative in {@link SummerParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRootSingleLine(SummerParser.RootSingleLineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarAssign}
	 * labeled alternative in {@link SummerParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAssign(SummerParser.VarAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncDefinition}
	 * labeled alternative in {@link SummerParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDefinition(SummerParser.FuncDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SummerParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(SummerParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SummerParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(SummerParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueNum}
	 * labeled alternative in {@link SummerParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueNum(SummerParser.ValueNumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueID}
	 * labeled alternative in {@link SummerParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueID(SummerParser.ValueIDContext ctx);
}