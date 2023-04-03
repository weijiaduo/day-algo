// Generated from ExprParser.g4 by ANTLR 4.9.3

package com.wjd.lr.expr.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(ExprParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compare}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(ExprParser.CompareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code in}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn(ExprParser.InContext ctx);
	/**
	 * Visit a parse tree produced by the {@code column}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn(ExprParser.ColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arithmetic}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmetic(ExprParser.ArithmeticContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unary}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(ExprParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code caseWhen}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseWhen(ExprParser.CaseWhenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code script}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript(ExprParser.ScriptContext ctx);
	/**
	 * Visit a parse tree produced by the {@code function}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(ExprParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pipe}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipe(ExprParser.PipeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logic}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic(ExprParser.LogicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullif}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullif(ExprParser.NullifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code value}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(ExprParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code wrap}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrap(ExprParser.WrapContext ctx);
	/**
	 * Visit a parse tree produced by the {@code between}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetween(ExprParser.BetweenContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(ExprParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#template}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplate(ExprParser.TemplateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#columnRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnRef(ExprParser.ColumnRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#generalFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneralFunc(ExprParser.GeneralFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#nativeFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNativeFunc(ExprParser.NativeFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#funcName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncName(ExprParser.FuncNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(ExprParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#columnName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnName(ExprParser.ColumnNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#refName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefName(ExprParser.RefNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(ExprParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#anyName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyName(ExprParser.AnyNameContext ctx);
}