// Generated from ExprParser.g4 by ANTLR 4.9.3

package com.wjd.lr.expr.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TEMPLATEBRACE=1, SEMI=2, COMMA=3, DOT=4, QUESTION=5, COLON=6, SHARP=7, 
		AT=8, BANG=9, OPENBRACKET=10, CLOSEBRACKET=11, OPEN_PAR=12, CLOSE_PAR=13, 
		OPENBRACE=14, CLOSEBRACE=15, ASSIGN=16, STAR=17, PLUS=18, MINUS=19, TILDE=20, 
		PIPE2=21, AND=22, DIV=23, MOD=24, LT=25, LT_EQ=26, GT=27, GT_EQ=28, EQ=29, 
		NOT_EQ1=30, NOT_EQ2=31, BITOR=32, CARET=33, BITAND=34, AND_=35, BETWEEN_=36, 
		CASE_=37, ELSE_=38, END_=39, FALSE_=40, IN_=41, IS_=42, ISNULL_=43, LIKE_=44, 
		NOT_=45, NOTNULL_=46, NULL_=47, OR_=48, THEN_=49, TRUE_=50, WHEN_=51, 
		NUMERIC_LITERAL=52, STRING_LITERAL=53, REF_ID=54, KEY_ID=55, SINGLE_LINE_COMMENT=56, 
		MULTILINE_COMMENT=57, SPACES=58;
	public static final int
		RULE_parse = 0, RULE_expr = 1, RULE_literal = 2, RULE_template = 3, RULE_columnRef = 4, 
		RULE_generalFunc = 5, RULE_nativeFunc = 6, RULE_funcName = 7, RULE_tableName = 8, 
		RULE_columnName = 9, RULE_refName = 10, RULE_typeName = 11, RULE_anyName = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "expr", "literal", "template", "columnRef", "generalFunc", "nativeFunc", 
			"funcName", "tableName", "columnName", "refName", "typeName", "anyName"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'${'", "';'", "','", "'.'", "'?'", "':'", "'#'", "'@'", "'!'", 
			"'['", "']'", "'('", "')'", "'{'", "'}'", "'='", "'*'", "'+'", "'-'", 
			"'~'", "'||'", "'&&'", "'/'", "'%'", "'<'", "'<='", "'>'", "'>='", "'=='", 
			"'!='", "'<>'", "'|'", "'^'", "'&'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TEMPLATEBRACE", "SEMI", "COMMA", "DOT", "QUESTION", "COLON", "SHARP", 
			"AT", "BANG", "OPENBRACKET", "CLOSEBRACKET", "OPEN_PAR", "CLOSE_PAR", 
			"OPENBRACE", "CLOSEBRACE", "ASSIGN", "STAR", "PLUS", "MINUS", "TILDE", 
			"PIPE2", "AND", "DIV", "MOD", "LT", "LT_EQ", "GT", "GT_EQ", "EQ", "NOT_EQ1", 
			"NOT_EQ2", "BITOR", "CARET", "BITAND", "AND_", "BETWEEN_", "CASE_", "ELSE_", 
			"END_", "FALSE_", "IN_", "IS_", "ISNULL_", "LIKE_", "NOT_", "NOTNULL_", 
			"NULL_", "OR_", "THEN_", "TRUE_", "WHEN_", "NUMERIC_LITERAL", "STRING_LITERAL", 
			"REF_ID", "KEY_ID", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "SPACES"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ExprParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ParseContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ExprParser.EOF, 0); }
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			expr(0);
			setState(27);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CompareContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LT() { return getToken(ExprParser.LT, 0); }
		public TerminalNode LT_EQ() { return getToken(ExprParser.LT_EQ, 0); }
		public TerminalNode GT() { return getToken(ExprParser.GT, 0); }
		public TerminalNode GT_EQ() { return getToken(ExprParser.GT_EQ, 0); }
		public TerminalNode ASSIGN() { return getToken(ExprParser.ASSIGN, 0); }
		public TerminalNode EQ() { return getToken(ExprParser.EQ, 0); }
		public TerminalNode NOT_EQ1() { return getToken(ExprParser.NOT_EQ1, 0); }
		public TerminalNode NOT_EQ2() { return getToken(ExprParser.NOT_EQ2, 0); }
		public TerminalNode IS_() { return getToken(ExprParser.IS_, 0); }
		public TerminalNode NOT_() { return getToken(ExprParser.NOT_, 0); }
		public TerminalNode IN_() { return getToken(ExprParser.IN_, 0); }
		public TerminalNode LIKE_() { return getToken(ExprParser.LIKE_, 0); }
		public CompareContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterCompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitCompare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitCompare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IN_() { return getToken(ExprParser.IN_, 0); }
		public TerminalNode OPEN_PAR() { return getToken(ExprParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(ExprParser.CLOSE_PAR, 0); }
		public TerminalNode NOT_() { return getToken(ExprParser.NOT_, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ExprParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExprParser.COMMA, i);
		}
		public InContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitIn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitIn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ColumnContext extends ExprContext {
		public ColumnRefContext columnRef() {
			return getRuleContext(ColumnRefContext.class,0);
		}
		public ColumnContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitColumn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitColumn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode STAR() { return getToken(ExprParser.STAR, 0); }
		public TerminalNode DIV() { return getToken(ExprParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(ExprParser.MOD, 0); }
		public TerminalNode PLUS() { return getToken(ExprParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ExprParser.MINUS, 0); }
		public ArithmeticContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterArithmetic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitArithmetic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitArithmetic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(ExprParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(ExprParser.PLUS, 0); }
		public TerminalNode TILDE() { return getToken(ExprParser.TILDE, 0); }
		public TerminalNode NOT_() { return getToken(ExprParser.NOT_, 0); }
		public UnaryContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitUnary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CaseWhenContext extends ExprContext {
		public TerminalNode CASE_() { return getToken(ExprParser.CASE_, 0); }
		public TerminalNode END_() { return getToken(ExprParser.END_, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> WHEN_() { return getTokens(ExprParser.WHEN_); }
		public TerminalNode WHEN_(int i) {
			return getToken(ExprParser.WHEN_, i);
		}
		public List<TerminalNode> THEN_() { return getTokens(ExprParser.THEN_); }
		public TerminalNode THEN_(int i) {
			return getToken(ExprParser.THEN_, i);
		}
		public TerminalNode ELSE_() { return getToken(ExprParser.ELSE_, 0); }
		public CaseWhenContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterCaseWhen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitCaseWhen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitCaseWhen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ScriptContext extends ExprContext {
		public TemplateContext template() {
			return getRuleContext(TemplateContext.class,0);
		}
		public ScriptContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterScript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitScript(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitScript(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionContext extends ExprContext {
		public GeneralFuncContext generalFunc() {
			return getRuleContext(GeneralFuncContext.class,0);
		}
		public NativeFuncContext nativeFunc() {
			return getRuleContext(NativeFuncContext.class,0);
		}
		public FunctionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PipeContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PIPE2() { return getToken(ExprParser.PIPE2, 0); }
		public PipeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterPipe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitPipe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitPipe(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND_() { return getToken(ExprParser.AND_, 0); }
		public TerminalNode OR_() { return getToken(ExprParser.OR_, 0); }
		public LogicContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterLogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitLogic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitLogic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullifContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ISNULL_() { return getToken(ExprParser.ISNULL_, 0); }
		public TerminalNode NOTNULL_() { return getToken(ExprParser.NOTNULL_, 0); }
		public TerminalNode NOT_() { return getToken(ExprParser.NOT_, 0); }
		public TerminalNode NULL_() { return getToken(ExprParser.NULL_, 0); }
		public NullifContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterNullif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitNullif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitNullif(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueContext extends ExprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ValueContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WrapContext extends ExprContext {
		public TerminalNode OPEN_PAR() { return getToken(ExprParser.OPEN_PAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(ExprParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ExprParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExprParser.COMMA, i);
		}
		public WrapContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterWrap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitWrap(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitWrap(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BetweenContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BETWEEN_() { return getToken(ExprParser.BETWEEN_, 0); }
		public TerminalNode AND_() { return getToken(ExprParser.AND_, 0); }
		public TerminalNode NOT_() { return getToken(ExprParser.NOT_, 0); }
		public BetweenContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterBetween(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitBetween(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitBetween(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new ValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(30);
				literal();
				}
				break;
			case 2:
				{
				_localctx = new ColumnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(31);
				columnRef();
				}
				break;
			case 3:
				{
				_localctx = new ScriptContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(32);
				template();
				}
				break;
			case 4:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(33);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << NOT_))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(34);
				expr(15);
				}
				break;
			case 5:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(35);
				generalFunc();
				}
				break;
			case 6:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(36);
				nativeFunc();
				}
				break;
			case 7:
				{
				_localctx = new WrapContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(37);
				match(OPEN_PAR);
				setState(38);
				expr(0);
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(39);
					match(COMMA);
					setState(40);
					expr(0);
					}
					}
					setState(45);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(46);
				match(CLOSE_PAR);
				}
				break;
			case 8:
				{
				_localctx = new CaseWhenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(48);
				match(CASE_);
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEMPLATEBRACE) | (1L << AT) | (1L << OPEN_PAR) | (1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << CASE_) | (1L << FALSE_) | (1L << NOT_) | (1L << NULL_) | (1L << TRUE_) | (1L << NUMERIC_LITERAL) | (1L << STRING_LITERAL) | (1L << REF_ID) | (1L << KEY_ID))) != 0)) {
					{
					setState(49);
					expr(0);
					}
				}

				setState(57); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(52);
					match(WHEN_);
					setState(53);
					expr(0);
					setState(54);
					match(THEN_);
					setState(55);
					expr(0);
					}
					}
					setState(59); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN_ );
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE_) {
					{
					setState(61);
					match(ELSE_);
					setState(62);
					expr(0);
					}
				}

				setState(65);
				match(END_);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(135);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(133);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new PipeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(69);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(70);
						match(PIPE2);
						setState(71);
						expr(15);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(72);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(73);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(74);
						expr(14);
						}
						break;
					case 3:
						{
						_localctx = new ArithmeticContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(75);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(76);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(77);
						expr(13);
						}
						break;
					case 4:
						{
						_localctx = new CompareContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(78);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(79);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << LT_EQ) | (1L << GT) | (1L << GT_EQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(80);
						expr(12);
						}
						break;
					case 5:
						{
						_localctx = new CompareContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(81);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(91);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
						case 1:
							{
							setState(82);
							match(ASSIGN);
							}
							break;
						case 2:
							{
							setState(83);
							match(EQ);
							}
							break;
						case 3:
							{
							setState(84);
							match(NOT_EQ1);
							}
							break;
						case 4:
							{
							setState(85);
							match(NOT_EQ2);
							}
							break;
						case 5:
							{
							setState(86);
							match(IS_);
							}
							break;
						case 6:
							{
							setState(87);
							match(IS_);
							setState(88);
							match(NOT_);
							}
							break;
						case 7:
							{
							setState(89);
							match(IN_);
							}
							break;
						case 8:
							{
							setState(90);
							match(LIKE_);
							}
							break;
						}
						setState(93);
						expr(11);
						}
						break;
					case 6:
						{
						_localctx = new LogicContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(94);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(95);
						match(AND_);
						setState(96);
						expr(10);
						}
						break;
					case 7:
						{
						_localctx = new LogicContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(97);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(98);
						match(OR_);
						setState(99);
						expr(9);
						}
						break;
					case 8:
						{
						_localctx = new BetweenContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(100);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(102);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT_) {
							{
							setState(101);
							match(NOT_);
							}
						}

						setState(104);
						match(BETWEEN_);
						setState(105);
						expr(0);
						setState(106);
						match(AND_);
						setState(107);
						expr(4);
						}
						break;
					case 9:
						{
						_localctx = new NullifContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(109);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(114);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case ISNULL_:
							{
							setState(110);
							match(ISNULL_);
							}
							break;
						case NOTNULL_:
							{
							setState(111);
							match(NOTNULL_);
							}
							break;
						case NOT_:
							{
							setState(112);
							match(NOT_);
							setState(113);
							match(NULL_);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					case 10:
						{
						_localctx = new InContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(116);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(118);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT_) {
							{
							setState(117);
							match(NOT_);
							}
						}

						setState(120);
						match(IN_);
						setState(121);
						match(OPEN_PAR);
						setState(130);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEMPLATEBRACE) | (1L << AT) | (1L << OPEN_PAR) | (1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << CASE_) | (1L << FALSE_) | (1L << NOT_) | (1L << NULL_) | (1L << TRUE_) | (1L << NUMERIC_LITERAL) | (1L << STRING_LITERAL) | (1L << REF_ID) | (1L << KEY_ID))) != 0)) {
							{
							setState(122);
							expr(0);
							setState(127);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(123);
								match(COMMA);
								setState(124);
								expr(0);
								}
								}
								setState(129);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(132);
						match(CLOSE_PAR);
						}
						break;
					}
					} 
				}
				setState(137);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(ExprParser.NUMERIC_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(ExprParser.STRING_LITERAL, 0); }
		public TerminalNode NULL_() { return getToken(ExprParser.NULL_, 0); }
		public TerminalNode TRUE_() { return getToken(ExprParser.TRUE_, 0); }
		public TerminalNode FALSE_() { return getToken(ExprParser.FALSE_, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FALSE_) | (1L << NULL_) | (1L << TRUE_) | (1L << NUMERIC_LITERAL) | (1L << STRING_LITERAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemplateContext extends ParserRuleContext {
		public TerminalNode TEMPLATEBRACE() { return getToken(ExprParser.TEMPLATEBRACE, 0); }
		public TerminalNode CLOSEBRACE() { return getToken(ExprParser.CLOSEBRACE, 0); }
		public TemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitTemplate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitTemplate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateContext template() throws RecognitionException {
		TemplateContext _localctx = new TemplateContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_template);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(TEMPLATEBRACE);
			setState(144);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(141);
					matchWildcard();
					}
					} 
				}
				setState(146);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(147);
			match(CLOSEBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnRefContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ExprParser.DOT, 0); }
		public ColumnRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterColumnRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitColumnRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitColumnRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnRefContext columnRef() throws RecognitionException {
		ColumnRefContext _localctx = new ColumnRefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_columnRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(149);
				tableName();
				setState(150);
				match(DOT);
				}
				break;
			}
			setState(154);
			columnName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GeneralFuncContext extends ParserRuleContext {
		public FuncNameContext funcName() {
			return getRuleContext(FuncNameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(ExprParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(ExprParser.CLOSE_PAR, 0); }
		public TerminalNode STAR() { return getToken(ExprParser.STAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TypeNameContext> typeName() {
			return getRuleContexts(TypeNameContext.class);
		}
		public TypeNameContext typeName(int i) {
			return getRuleContext(TypeNameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExprParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExprParser.COMMA, i);
		}
		public GeneralFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generalFunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterGeneralFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitGeneralFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitGeneralFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GeneralFuncContext generalFunc() throws RecognitionException {
		GeneralFuncContext _localctx = new GeneralFuncContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_generalFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			funcName();
			setState(157);
			match(OPEN_PAR);
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEMPLATEBRACE:
			case AT:
			case OPEN_PAR:
			case PLUS:
			case MINUS:
			case TILDE:
			case CASE_:
			case FALSE_:
			case NOT_:
			case NULL_:
			case TRUE_:
			case NUMERIC_LITERAL:
			case STRING_LITERAL:
			case REF_ID:
			case KEY_ID:
				{
				{
				setState(160);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(158);
					expr(0);
					}
					break;
				case 2:
					{
					setState(159);
					typeName();
					}
					break;
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(162);
					match(COMMA);
					setState(165);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						setState(163);
						expr(0);
						}
						break;
					case 2:
						{
						setState(164);
						typeName();
						}
						break;
					}
					}
					}
					setState(171);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case STAR:
				{
				setState(172);
				match(STAR);
				}
				break;
			case CLOSE_PAR:
				break;
			default:
				break;
			}
			setState(175);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NativeFuncContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(ExprParser.AT, 0); }
		public FuncNameContext funcName() {
			return getRuleContext(FuncNameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(ExprParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(ExprParser.CLOSE_PAR, 0); }
		public TerminalNode STAR() { return getToken(ExprParser.STAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TypeNameContext> typeName() {
			return getRuleContexts(TypeNameContext.class);
		}
		public TypeNameContext typeName(int i) {
			return getRuleContext(TypeNameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExprParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExprParser.COMMA, i);
		}
		public NativeFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nativeFunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterNativeFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitNativeFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitNativeFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NativeFuncContext nativeFunc() throws RecognitionException {
		NativeFuncContext _localctx = new NativeFuncContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_nativeFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(AT);
			setState(178);
			funcName();
			setState(179);
			match(OPEN_PAR);
			setState(195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEMPLATEBRACE:
			case AT:
			case OPEN_PAR:
			case PLUS:
			case MINUS:
			case TILDE:
			case CASE_:
			case FALSE_:
			case NOT_:
			case NULL_:
			case TRUE_:
			case NUMERIC_LITERAL:
			case STRING_LITERAL:
			case REF_ID:
			case KEY_ID:
				{
				{
				setState(182);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(180);
					expr(0);
					}
					break;
				case 2:
					{
					setState(181);
					typeName();
					}
					break;
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(184);
					match(COMMA);
					setState(187);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						setState(185);
						expr(0);
						}
						break;
					case 2:
						{
						setState(186);
						typeName();
						}
						break;
					}
					}
					}
					setState(193);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case STAR:
				{
				setState(194);
				match(STAR);
				}
				break;
			case CLOSE_PAR:
				break;
			default:
				break;
			}
			setState(197);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncNameContext extends ParserRuleContext {
		public AnyNameContext anyName() {
			return getRuleContext(AnyNameContext.class,0);
		}
		public FuncNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterFuncName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitFuncName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitFuncName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncNameContext funcName() throws RecognitionException {
		FuncNameContext _localctx = new FuncNameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_funcName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			anyName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableNameContext extends ParserRuleContext {
		public RefNameContext refName() {
			return getRuleContext(RefNameContext.class,0);
		}
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitTableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			refName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnNameContext extends ParserRuleContext {
		public RefNameContext refName() {
			return getRuleContext(RefNameContext.class,0);
		}
		public ColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterColumnName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitColumnName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitColumnName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			refName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RefNameContext extends ParserRuleContext {
		public TerminalNode REF_ID() { return getToken(ExprParser.REF_ID, 0); }
		public RefNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterRefName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitRefName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitRefName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RefNameContext refName() throws RecognitionException {
		RefNameContext _localctx = new RefNameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_refName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(REF_ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeNameContext extends ParserRuleContext {
		public TerminalNode KEY_ID() { return getToken(ExprParser.KEY_ID, 0); }
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_typeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(KEY_ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnyNameContext extends ParserRuleContext {
		public TerminalNode KEY_ID() { return getToken(ExprParser.KEY_ID, 0); }
		public TerminalNode OPEN_PAR() { return getToken(ExprParser.OPEN_PAR, 0); }
		public AnyNameContext anyName() {
			return getRuleContext(AnyNameContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(ExprParser.CLOSE_PAR, 0); }
		public AnyNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterAnyName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitAnyName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitAnyName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnyNameContext anyName() throws RecognitionException {
		AnyNameContext _localctx = new AnyNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_anyName);
		try {
			setState(214);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEY_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				match(KEY_ID);
				}
				break;
			case OPEN_PAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
				match(OPEN_PAR);
				setState(211);
				anyName();
				setState(212);
				match(CLOSE_PAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3<\u00db\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\7\3,\n\3\f\3\16\3/\13\3\3\3\3\3\3\3\3\3\5\3\65\n"+
		"\3\3\3\3\3\3\3\3\3\3\3\6\3<\n\3\r\3\16\3=\3\3\3\3\5\3B\n\3\3\3\3\3\5\3"+
		"F\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3^\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\5\3i\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3u\n\3\3\3\3\3\5\3"+
		"y\n\3\3\3\3\3\3\3\3\3\3\3\7\3\u0080\n\3\f\3\16\3\u0083\13\3\5\3\u0085"+
		"\n\3\3\3\7\3\u0088\n\3\f\3\16\3\u008b\13\3\3\4\3\4\3\5\3\5\7\5\u0091\n"+
		"\5\f\5\16\5\u0094\13\5\3\5\3\5\3\6\3\6\3\6\5\6\u009b\n\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\5\7\u00a3\n\7\3\7\3\7\3\7\5\7\u00a8\n\7\7\7\u00aa\n\7\f\7\16"+
		"\7\u00ad\13\7\3\7\5\7\u00b0\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5\b\u00b9"+
		"\n\b\3\b\3\b\3\b\5\b\u00be\n\b\7\b\u00c0\n\b\f\b\16\b\u00c3\13\b\3\b\5"+
		"\b\u00c6\n\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\5\16\u00d9\n\16\3\16\3\u0092\3\4\17\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\2\7\4\2\24\26//\4\2\23\23\31\32\3\2\24\25\3\2\33\36"+
		"\6\2**\61\61\64\64\66\67\2\u00fc\2\34\3\2\2\2\4E\3\2\2\2\6\u008c\3\2\2"+
		"\2\b\u008e\3\2\2\2\n\u009a\3\2\2\2\f\u009e\3\2\2\2\16\u00b3\3\2\2\2\20"+
		"\u00c9\3\2\2\2\22\u00cb\3\2\2\2\24\u00cd\3\2\2\2\26\u00cf\3\2\2\2\30\u00d1"+
		"\3\2\2\2\32\u00d8\3\2\2\2\34\35\5\4\3\2\35\36\7\2\2\3\36\3\3\2\2\2\37"+
		" \b\3\1\2 F\5\6\4\2!F\5\n\6\2\"F\5\b\5\2#$\t\2\2\2$F\5\4\3\21%F\5\f\7"+
		"\2&F\5\16\b\2\'(\7\16\2\2(-\5\4\3\2)*\7\5\2\2*,\5\4\3\2+)\3\2\2\2,/\3"+
		"\2\2\2-+\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/-\3\2\2\2\60\61\7\17\2\2\61F\3"+
		"\2\2\2\62\64\7\'\2\2\63\65\5\4\3\2\64\63\3\2\2\2\64\65\3\2\2\2\65;\3\2"+
		"\2\2\66\67\7\65\2\2\678\5\4\3\289\7\63\2\29:\5\4\3\2:<\3\2\2\2;\66\3\2"+
		"\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2\2>A\3\2\2\2?@\7(\2\2@B\5\4\3\2A?\3\2"+
		"\2\2AB\3\2\2\2BC\3\2\2\2CD\7)\2\2DF\3\2\2\2E\37\3\2\2\2E!\3\2\2\2E\"\3"+
		"\2\2\2E#\3\2\2\2E%\3\2\2\2E&\3\2\2\2E\'\3\2\2\2E\62\3\2\2\2F\u0089\3\2"+
		"\2\2GH\f\20\2\2HI\7\27\2\2I\u0088\5\4\3\21JK\f\17\2\2KL\t\3\2\2L\u0088"+
		"\5\4\3\20MN\f\16\2\2NO\t\4\2\2O\u0088\5\4\3\17PQ\f\r\2\2QR\t\5\2\2R\u0088"+
		"\5\4\3\16S]\f\f\2\2T^\7\22\2\2U^\7\37\2\2V^\7 \2\2W^\7!\2\2X^\7,\2\2Y"+
		"Z\7,\2\2Z^\7/\2\2[^\7+\2\2\\^\7.\2\2]T\3\2\2\2]U\3\2\2\2]V\3\2\2\2]W\3"+
		"\2\2\2]X\3\2\2\2]Y\3\2\2\2][\3\2\2\2]\\\3\2\2\2^_\3\2\2\2_\u0088\5\4\3"+
		"\r`a\f\13\2\2ab\7%\2\2b\u0088\5\4\3\fcd\f\n\2\2de\7\62\2\2e\u0088\5\4"+
		"\3\13fh\f\5\2\2gi\7/\2\2hg\3\2\2\2hi\3\2\2\2ij\3\2\2\2jk\7&\2\2kl\5\4"+
		"\3\2lm\7%\2\2mn\5\4\3\6n\u0088\3\2\2\2ot\f\6\2\2pu\7-\2\2qu\7\60\2\2r"+
		"s\7/\2\2su\7\61\2\2tp\3\2\2\2tq\3\2\2\2tr\3\2\2\2u\u0088\3\2\2\2vx\f\4"+
		"\2\2wy\7/\2\2xw\3\2\2\2xy\3\2\2\2yz\3\2\2\2z{\7+\2\2{\u0084\7\16\2\2|"+
		"\u0081\5\4\3\2}~\7\5\2\2~\u0080\5\4\3\2\177}\3\2\2\2\u0080\u0083\3\2\2"+
		"\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0084|\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\u0088\7\17\2\2\u0087G\3\2\2\2\u0087J\3\2\2\2\u0087M\3\2\2\2\u0087P\3"+
		"\2\2\2\u0087S\3\2\2\2\u0087`\3\2\2\2\u0087c\3\2\2\2\u0087f\3\2\2\2\u0087"+
		"o\3\2\2\2\u0087v\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\5\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d\t\6\2\2"+
		"\u008d\7\3\2\2\2\u008e\u0092\7\3\2\2\u008f\u0091\13\2\2\2\u0090\u008f"+
		"\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093"+
		"\u0095\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0096\7\21\2\2\u0096\t\3\2\2"+
		"\2\u0097\u0098\5\22\n\2\u0098\u0099\7\6\2\2\u0099\u009b\3\2\2\2\u009a"+
		"\u0097\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\5\24"+
		"\13\2\u009d\13\3\2\2\2\u009e\u009f\5\20\t\2\u009f\u00af\7\16\2\2\u00a0"+
		"\u00a3\5\4\3\2\u00a1\u00a3\5\30\r\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3"+
		"\2\2\2\u00a3\u00ab\3\2\2\2\u00a4\u00a7\7\5\2\2\u00a5\u00a8\5\4\3\2\u00a6"+
		"\u00a8\5\30\r\2\u00a7\u00a5\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00aa\3"+
		"\2\2\2\u00a9\u00a4\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab"+
		"\u00ac\3\2\2\2\u00ac\u00b0\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00b0\7\23"+
		"\2\2\u00af\u00a2\3\2\2\2\u00af\u00ae\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b2\7\17\2\2\u00b2\r\3\2\2\2\u00b3\u00b4\7\n\2"+
		"\2\u00b4\u00b5\5\20\t\2\u00b5\u00c5\7\16\2\2\u00b6\u00b9\5\4\3\2\u00b7"+
		"\u00b9\5\30\r\2\u00b8\u00b6\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00c1\3"+
		"\2\2\2\u00ba\u00bd\7\5\2\2\u00bb\u00be\5\4\3\2\u00bc\u00be\5\30\r\2\u00bd"+
		"\u00bb\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00ba\3\2"+
		"\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"\u00c6\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c6\7\23\2\2\u00c5\u00b8\3"+
		"\2\2\2\u00c5\u00c4\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7"+
		"\u00c8\7\17\2\2\u00c8\17\3\2\2\2\u00c9\u00ca\5\32\16\2\u00ca\21\3\2\2"+
		"\2\u00cb\u00cc\5\26\f\2\u00cc\23\3\2\2\2\u00cd\u00ce\5\26\f\2\u00ce\25"+
		"\3\2\2\2\u00cf\u00d0\78\2\2\u00d0\27\3\2\2\2\u00d1\u00d2\79\2\2\u00d2"+
		"\31\3\2\2\2\u00d3\u00d9\79\2\2\u00d4\u00d5\7\16\2\2\u00d5\u00d6\5\32\16"+
		"\2\u00d6\u00d7\7\17\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d3\3\2\2\2\u00d8"+
		"\u00d4\3\2\2\2\u00d9\33\3\2\2\2\32-\64=AE]htx\u0081\u0084\u0087\u0089"+
		"\u0092\u009a\u00a2\u00a7\u00ab\u00af\u00b8\u00bd\u00c1\u00c5\u00d8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}