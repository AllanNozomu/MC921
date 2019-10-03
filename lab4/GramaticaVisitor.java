// Generated from Gramatica.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GramaticaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GramaticaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code RootMultiLine}
	 * labeled alternative in {@link GramaticaParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRootMultiLine(GramaticaParser.RootMultiLineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RootNone}
	 * labeled alternative in {@link GramaticaParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRootNone(GramaticaParser.RootNoneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarAssign}
	 * labeled alternative in {@link GramaticaParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAssign(GramaticaParser.VarAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncDefinition}
	 * labeled alternative in {@link GramaticaParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDefinition(GramaticaParser.FuncDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParamsMulti}
	 * labeled alternative in {@link GramaticaParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamsMulti(GramaticaParser.ParamsMultiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParamsID}
	 * labeled alternative in {@link GramaticaParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamsID(GramaticaParser.ParamsIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParamsNone}
	 * labeled alternative in {@link GramaticaParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamsNone(GramaticaParser.ParamsNoneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParamsCallMulti}
	 * labeled alternative in {@link GramaticaParser#paramsCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamsCallMulti(GramaticaParser.ParamsCallMultiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParamsCallID}
	 * labeled alternative in {@link GramaticaParser#paramsCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamsCallID(GramaticaParser.ParamsCallIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParamsCallNone}
	 * labeled alternative in {@link GramaticaParser#paramsCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamsCallNone(GramaticaParser.ParamsCallNoneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprEConversion}
	 * labeled alternative in {@link GramaticaParser#exprE}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprEConversion(GramaticaParser.ExprEConversionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprESub}
	 * labeled alternative in {@link GramaticaParser#exprE}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprESub(GramaticaParser.ExprESubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprESum}
	 * labeled alternative in {@link GramaticaParser#exprE}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprESum(GramaticaParser.ExprESumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprTConversion}
	 * labeled alternative in {@link GramaticaParser#exprT}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprTConversion(GramaticaParser.ExprTConversionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprTDiv}
	 * labeled alternative in {@link GramaticaParser#exprT}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprTDiv(GramaticaParser.ExprTDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprTMul}
	 * labeled alternative in {@link GramaticaParser#exprT}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprTMul(GramaticaParser.ExprTMulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprFParen}
	 * labeled alternative in {@link GramaticaParser#exprF}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFParen(GramaticaParser.ExprFParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprFFunc}
	 * labeled alternative in {@link GramaticaParser#exprF}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFFunc(GramaticaParser.ExprFFuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprFVal}
	 * labeled alternative in {@link GramaticaParser#exprF}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFVal(GramaticaParser.ExprFValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueNum}
	 * labeled alternative in {@link GramaticaParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueNum(GramaticaParser.ValueNumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueID}
	 * labeled alternative in {@link GramaticaParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueID(GramaticaParser.ValueIDContext ctx);
}