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
	 * Visit a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ExprParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#unaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(ExprParser.UnaryOperatorContext ctx);
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
	 * Visit a parse tree produced by {@link ExprParser#schemaName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchemaName(ExprParser.SchemaNameContext ctx);
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
	 * Visit a parse tree produced by {@link ExprParser#anyName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyName(ExprParser.AnyNameContext ctx);
}