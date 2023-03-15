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
		NUMERIC_LITERAL=52, STRING_LITERAL=53, IDENTIFIER=54, SINGLE_LINE_COMMENT=55, 
		MULTILINE_COMMENT=56, SPACES=57;
	public static final int
		RULE_parse = 0, RULE_expr = 1, RULE_literal = 2, RULE_template = 3, RULE_columnRef = 4, 
		RULE_generalFunc = 5, RULE_nativeFunc = 6, RULE_funcName = 7, RULE_tableName = 8, 
		RULE_columnName = 9, RULE_refName = 10, RULE_anyName = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "expr", "literal", "template", "columnRef", "generalFunc", "nativeFunc", 
			"funcName", "tableName", "columnName", "refName", "anyName"
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
			"IDENTIFIER", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "SPACES"
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
			setState(24);
			expr(0);
			setState(25);
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
		public TerminalNode EQ() { return getToken(ExprParser.EQ, 0); }
		public TerminalNode NOT_EQ1() { return getToken(ExprParser.NOT_EQ1, 0); }
		public TerminalNode NOT_EQ2() { return getToken(ExprParser.NOT_EQ2, 0); }
		public TerminalNode IS_() { return getToken(ExprParser.IS_, 0); }
		public TerminalNode NOT_() { return getToken(ExprParser.NOT_, 0); }
		public TerminalNode IN_() { return getToken(ExprParser.IN_, 0); }
		public TerminalNode LIKE_() { return getToken(ExprParser.LIKE_, 0); }
		public TerminalNode ISNULL_() { return getToken(ExprParser.ISNULL_, 0); }
		public TerminalNode NOTNULL_() { return getToken(ExprParser.NOTNULL_, 0); }
		public TerminalNode NULL_() { return getToken(ExprParser.NULL_, 0); }
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(ExprParser.CLOSE_PAR, 0); }
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
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new ValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(28);
				literal();
				}
				break;
			case 2:
				{
				_localctx = new ColumnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(29);
				columnRef();
				}
				break;
			case 3:
				{
				_localctx = new ScriptContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(30);
				template();
				}
				break;
			case 4:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(31);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << NOT_))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(32);
				expr(13);
				}
				break;
			case 5:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(33);
				generalFunc();
				}
				break;
			case 6:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(34);
				nativeFunc();
				}
				break;
			case 7:
				{
				_localctx = new WrapContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(35);
				match(OPEN_PAR);
				setState(36);
				expr(0);
				setState(37);
				match(CLOSE_PAR);
				}
				break;
			case 8:
				{
				_localctx = new CaseWhenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(39);
				match(CASE_);
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEMPLATEBRACE) | (1L << AT) | (1L << OPENBRACKET) | (1L << OPEN_PAR) | (1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << CASE_) | (1L << FALSE_) | (1L << NOT_) | (1L << NULL_) | (1L << TRUE_) | (1L << NUMERIC_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(40);
					expr(0);
					}
				}

				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(43);
					match(WHEN_);
					setState(44);
					expr(0);
					setState(45);
					match(THEN_);
					setState(46);
					expr(0);
					}
					}
					setState(50); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN_ );
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE_) {
					{
					setState(52);
					match(ELSE_);
					setState(53);
					expr(0);
					}
				}

				setState(56);
				match(END_);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(105);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(103);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(60);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(61);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(62);
						expr(13);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(63);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(64);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(65);
						expr(12);
						}
						break;
					case 3:
						{
						_localctx = new CompareContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(66);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(67);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << LT_EQ) | (1L << GT) | (1L << GT_EQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(68);
						expr(11);
						}
						break;
					case 4:
						{
						_localctx = new CompareContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(69);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(78);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
						case 1:
							{
							setState(70);
							match(EQ);
							}
							break;
						case 2:
							{
							setState(71);
							match(NOT_EQ1);
							}
							break;
						case 3:
							{
							setState(72);
							match(NOT_EQ2);
							}
							break;
						case 4:
							{
							setState(73);
							match(IS_);
							}
							break;
						case 5:
							{
							setState(74);
							match(IS_);
							setState(75);
							match(NOT_);
							}
							break;
						case 6:
							{
							setState(76);
							match(IN_);
							}
							break;
						case 7:
							{
							setState(77);
							match(LIKE_);
							}
							break;
						}
						setState(80);
						expr(10);
						}
						break;
					case 5:
						{
						_localctx = new LogicContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(81);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(82);
						match(AND_);
						setState(83);
						expr(9);
						}
						break;
					case 6:
						{
						_localctx = new LogicContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(84);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(85);
						match(OR_);
						setState(86);
						expr(8);
						}
						break;
					case 7:
						{
						_localctx = new BetweenContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(87);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(89);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT_) {
							{
							setState(88);
							match(NOT_);
							}
						}

						setState(91);
						match(BETWEEN_);
						setState(92);
						expr(0);
						setState(93);
						match(AND_);
						setState(94);
						expr(4);
						}
						break;
					case 8:
						{
						_localctx = new CompareContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(96);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(101);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case ISNULL_:
							{
							setState(97);
							match(ISNULL_);
							}
							break;
						case NOTNULL_:
							{
							setState(98);
							match(NOTNULL_);
							}
							break;
						case NOT_:
							{
							setState(99);
							match(NOT_);
							setState(100);
							match(NULL_);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					}
					} 
				}
				setState(107);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
			setState(108);
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
			setState(110);
			match(TEMPLATEBRACE);
			setState(114);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(111);
					matchWildcard();
					}
					} 
				}
				setState(116);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(117);
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
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(119);
				tableName();
				setState(120);
				match(DOT);
				}
				break;
			}
			setState(124);
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
			setState(126);
			funcName();
			setState(127);
			match(OPEN_PAR);
			setState(137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEMPLATEBRACE:
			case AT:
			case OPENBRACKET:
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
			case IDENTIFIER:
				{
				{
				setState(128);
				expr(0);
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(129);
					match(COMMA);
					setState(130);
					expr(0);
					}
					}
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case STAR:
				{
				setState(136);
				match(STAR);
				}
				break;
			case CLOSE_PAR:
				break;
			default:
				break;
			}
			setState(139);
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
			setState(141);
			match(AT);
			setState(142);
			funcName();
			setState(143);
			match(OPEN_PAR);
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEMPLATEBRACE:
			case AT:
			case OPENBRACKET:
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
			case IDENTIFIER:
				{
				{
				setState(144);
				expr(0);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(145);
					match(COMMA);
					setState(146);
					expr(0);
					}
					}
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case STAR:
				{
				setState(152);
				match(STAR);
				}
				break;
			case CLOSE_PAR:
				break;
			default:
				break;
			}
			setState(155);
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
			setState(157);
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
			setState(159);
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
			setState(161);
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
		public TerminalNode OPENBRACKET() { return getToken(ExprParser.OPENBRACKET, 0); }
		public TerminalNode CLOSEBRACKET() { return getToken(ExprParser.CLOSEBRACKET, 0); }
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(OPENBRACKET);
			setState(167);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(164);
					matchWildcard();
					}
					} 
				}
				setState(169);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(170);
			match(CLOSEBRACKET);
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
		public TerminalNode IDENTIFIER() { return getToken(ExprParser.IDENTIFIER, 0); }
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
		enterRule(_localctx, 22, RULE_anyName);
		try {
			setState(177);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				match(IDENTIFIER);
				}
				break;
			case OPEN_PAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				match(OPEN_PAR);
				setState(174);
				anyName();
				setState(175);
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
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3;\u00b6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\5\3,\n\3\3\3\3\3\3\3\3\3\3\3\6\3\63\n\3\r\3\16\3\64"+
		"\3\3\3\3\5\39\n\3\3\3\3\3\5\3=\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3Q\n\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\5\3\\\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3h\n"+
		"\3\7\3j\n\3\f\3\16\3m\13\3\3\4\3\4\3\5\3\5\7\5s\n\5\f\5\16\5v\13\5\3\5"+
		"\3\5\3\6\3\6\3\6\5\6}\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7\u0086\n\7\f"+
		"\7\16\7\u0089\13\7\3\7\5\7\u008c\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7"+
		"\b\u0096\n\b\f\b\16\b\u0099\13\b\3\b\5\b\u009c\n\b\3\b\3\b\3\t\3\t\3\n"+
		"\3\n\3\13\3\13\3\f\3\f\7\f\u00a8\n\f\f\f\16\f\u00ab\13\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u00b4\n\r\3\r\4t\u00a9\3\4\16\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\2\7\4\2\24\26//\4\2\23\23\31\32\3\2\24\25\3\2\33\36\6\2**\61"+
		"\61\64\64\66\67\2\u00ce\2\32\3\2\2\2\4<\3\2\2\2\6n\3\2\2\2\bp\3\2\2\2"+
		"\n|\3\2\2\2\f\u0080\3\2\2\2\16\u008f\3\2\2\2\20\u009f\3\2\2\2\22\u00a1"+
		"\3\2\2\2\24\u00a3\3\2\2\2\26\u00a5\3\2\2\2\30\u00b3\3\2\2\2\32\33\5\4"+
		"\3\2\33\34\7\2\2\3\34\3\3\2\2\2\35\36\b\3\1\2\36=\5\6\4\2\37=\5\n\6\2"+
		" =\5\b\5\2!\"\t\2\2\2\"=\5\4\3\17#=\5\f\7\2$=\5\16\b\2%&\7\16\2\2&\'\5"+
		"\4\3\2\'(\7\17\2\2(=\3\2\2\2)+\7\'\2\2*,\5\4\3\2+*\3\2\2\2+,\3\2\2\2,"+
		"\62\3\2\2\2-.\7\65\2\2./\5\4\3\2/\60\7\63\2\2\60\61\5\4\3\2\61\63\3\2"+
		"\2\2\62-\3\2\2\2\63\64\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\658\3\2\2\2"+
		"\66\67\7(\2\2\679\5\4\3\28\66\3\2\2\289\3\2\2\29:\3\2\2\2:;\7)\2\2;=\3"+
		"\2\2\2<\35\3\2\2\2<\37\3\2\2\2< \3\2\2\2<!\3\2\2\2<#\3\2\2\2<$\3\2\2\2"+
		"<%\3\2\2\2<)\3\2\2\2=k\3\2\2\2>?\f\16\2\2?@\t\3\2\2@j\5\4\3\17AB\f\r\2"+
		"\2BC\t\4\2\2Cj\5\4\3\16DE\f\f\2\2EF\t\5\2\2Fj\5\4\3\rGP\f\13\2\2HQ\7\37"+
		"\2\2IQ\7 \2\2JQ\7!\2\2KQ\7,\2\2LM\7,\2\2MQ\7/\2\2NQ\7+\2\2OQ\7.\2\2PH"+
		"\3\2\2\2PI\3\2\2\2PJ\3\2\2\2PK\3\2\2\2PL\3\2\2\2PN\3\2\2\2PO\3\2\2\2Q"+
		"R\3\2\2\2Rj\5\4\3\fST\f\n\2\2TU\7%\2\2Uj\5\4\3\13VW\f\t\2\2WX\7\62\2\2"+
		"Xj\5\4\3\nY[\f\5\2\2Z\\\7/\2\2[Z\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]^\7&\2"+
		"\2^_\5\4\3\2_`\7%\2\2`a\5\4\3\6aj\3\2\2\2bg\f\6\2\2ch\7-\2\2dh\7\60\2"+
		"\2ef\7/\2\2fh\7\61\2\2gc\3\2\2\2gd\3\2\2\2ge\3\2\2\2hj\3\2\2\2i>\3\2\2"+
		"\2iA\3\2\2\2iD\3\2\2\2iG\3\2\2\2iS\3\2\2\2iV\3\2\2\2iY\3\2\2\2ib\3\2\2"+
		"\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\5\3\2\2\2mk\3\2\2\2no\t\6\2\2o\7\3\2"+
		"\2\2pt\7\3\2\2qs\13\2\2\2rq\3\2\2\2sv\3\2\2\2tu\3\2\2\2tr\3\2\2\2uw\3"+
		"\2\2\2vt\3\2\2\2wx\7\21\2\2x\t\3\2\2\2yz\5\22\n\2z{\7\6\2\2{}\3\2\2\2"+
		"|y\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\177\5\24\13\2\177\13\3\2\2\2\u0080\u0081"+
		"\5\20\t\2\u0081\u008b\7\16\2\2\u0082\u0087\5\4\3\2\u0083\u0084\7\5\2\2"+
		"\u0084\u0086\5\4\3\2\u0085\u0083\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008c\3\2\2\2\u0089\u0087\3\2\2\2\u008a"+
		"\u008c\7\23\2\2\u008b\u0082\3\2\2\2\u008b\u008a\3\2\2\2\u008b\u008c\3"+
		"\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\7\17\2\2\u008e\r\3\2\2\2\u008f"+
		"\u0090\7\n\2\2\u0090\u0091\5\20\t\2\u0091\u009b\7\16\2\2\u0092\u0097\5"+
		"\4\3\2\u0093\u0094\7\5\2\2\u0094\u0096\5\4\3\2\u0095\u0093\3\2\2\2\u0096"+
		"\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009c\3\2"+
		"\2\2\u0099\u0097\3\2\2\2\u009a\u009c\7\23\2\2\u009b\u0092\3\2\2\2\u009b"+
		"\u009a\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\7\17"+
		"\2\2\u009e\17\3\2\2\2\u009f\u00a0\5\30\r\2\u00a0\21\3\2\2\2\u00a1\u00a2"+
		"\5\26\f\2\u00a2\23\3\2\2\2\u00a3\u00a4\5\26\f\2\u00a4\25\3\2\2\2\u00a5"+
		"\u00a9\7\f\2\2\u00a6\u00a8\13\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3"+
		"\2\2\2\u00a9\u00aa\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ac\u00ad\7\r\2\2\u00ad\27\3\2\2\2\u00ae\u00b4\78\2\2"+
		"\u00af\u00b0\7\16\2\2\u00b0\u00b1\5\30\r\2\u00b1\u00b2\7\17\2\2\u00b2"+
		"\u00b4\3\2\2\2\u00b3\u00ae\3\2\2\2\u00b3\u00af\3\2\2\2\u00b4\31\3\2\2"+
		"\2\23+\648<P[gikt|\u0087\u008b\u0097\u009b\u00a9\u00b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}