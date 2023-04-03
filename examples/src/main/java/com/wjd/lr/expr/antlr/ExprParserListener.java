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
	 * Enter a parse tree produced by the {@code compare}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompare(ExprParser.CompareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compare}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompare(ExprParser.CompareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code in}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIn(ExprParser.InContext ctx);
	/**
	 * Exit a parse tree produced by the {@code in}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIn(ExprParser.InContext ctx);
	/**
	 * Enter a parse tree produced by the {@code column}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterColumn(ExprParser.ColumnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code column}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitColumn(ExprParser.ColumnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arithmetic}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic(ExprParser.ArithmeticContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arithmetic}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic(ExprParser.ArithmeticContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unary}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary(ExprParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unary}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary(ExprParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code caseWhen}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCaseWhen(ExprParser.CaseWhenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code caseWhen}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCaseWhen(ExprParser.CaseWhenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code script}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterScript(ExprParser.ScriptContext ctx);
	/**
	 * Exit a parse tree produced by the {@code script}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitScript(ExprParser.ScriptContext ctx);
	/**
	 * Enter a parse tree produced by the {@code function}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunction(ExprParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code function}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunction(ExprParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pipe}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPipe(ExprParser.PipeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pipe}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPipe(ExprParser.PipeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logic}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogic(ExprParser.LogicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logic}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogic(ExprParser.LogicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullif}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNullif(ExprParser.NullifContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullif}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNullif(ExprParser.NullifContext ctx);
	/**
	 * Enter a parse tree produced by the {@code value}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterValue(ExprParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code value}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitValue(ExprParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code wrap}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterWrap(ExprParser.WrapContext ctx);
	/**
	 * Exit a parse tree produced by the {@code wrap}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitWrap(ExprParser.WrapContext ctx);
	/**
	 * Enter a parse tree produced by the {@code between}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBetween(ExprParser.BetweenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code between}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBetween(ExprParser.BetweenContext ctx);
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
	 * Enter a parse tree produced by {@link ExprParser#refName}.
	 * @param ctx the parse tree
	 */
	void enterRefName(ExprParser.RefNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#refName}.
	 * @param ctx the parse tree
	 */
	void exitRefName(ExprParser.RefNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(ExprParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(ExprParser.TypeNameContext ctx);
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