// Generated from ExprParser.g4 by ANTLR 4.9.3

package com.wjd.lr.expr.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(ExprParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(ExprParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ExprParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ExprParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(ExprParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(ExprParser.UnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(ExprParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(ExprParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#template}.
	 * @param ctx the parse tree
	 */
	void enterTemplate(ExprParser.TemplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#template}.
	 * @param ctx the parse tree
	 */
	void exitTemplate(ExprParser.TemplateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#columnRef}.
	 * @param ctx the parse tree
	 */
	void enterColumnRef(ExprParser.ColumnRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#columnRef}.
	 * @param ctx the parse tree
	 */
	void exitColumnRef(ExprParser.ColumnRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#generalFunc}.
	 * @param ctx the parse tree
	 */
	void enterGeneralFunc(ExprParser.GeneralFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#generalFunc}.
	 * @param ctx the parse tree
	 */
	void exitGeneralFunc(ExprParser.GeneralFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#nativeFunc}.
	 * @param ctx the parse tree
	 */
	void enterNativeFunc(ExprParser.NativeFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#nativeFunc}.
	 * @param ctx the parse tree
	 */
	void exitNativeFunc(ExprParser.NativeFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#funcName}.
	 * @param ctx the parse tree
	 */
	void enterFuncName(ExprParser.FuncNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#funcName}.
	 * @param ctx the parse tree
	 */
	void exitFuncName(ExprParser.FuncNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#schemaName}.
	 * @param ctx the parse tree
	 */
	void enterSchemaName(ExprParser.SchemaNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#schemaName}.
	 * @param ctx the parse tree
	 */
	void exitSchemaName(ExprParser.SchemaNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(ExprParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(ExprParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#columnName}.
	 * @param ctx the parse tree
	 */
	void enterColumnName(ExprParser.ColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#columnName}.
	 * @param ctx the parse tree
	 */
	void exitColumnName(ExprParser.ColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#anyName}.
	 * @param ctx the parse tree
	 */
	void enterAnyName(ExprParser.AnyNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#anyName}.
	 * @param ctx the parse tree
	 */
	void exitAnyName(ExprParser.AnyNameContext ctx);
}