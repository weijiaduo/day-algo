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
		TEMPLATEBRACE=1, DOT=2, OPENBRACKET=3, CLOSEBRACKET=4, OPEN_PAR=5, CLOSE_PAR=6, 
		OPENBRACE=7, CLOSEBRACE=8, SHARP=9, AT=10, COMMA=11, ASSIGN=12, STAR=13, 
		PLUS=14, MINUS=15, TILDE=16, PIPE2=17, DIV=18, MOD=19, LT=20, LT_EQ=21, 
		GT=22, GT_EQ=23, EQ=24, NOT_EQ1=25, NOT_EQ2=26, AND_=27, BETWEEN_=28, 
		CASE_=29, ELSE_=30, END_=31, FALSE_=32, IN_=33, IS_=34, ISNULL_=35, LIKE_=36, 
		NOT_=37, NOTNULL_=38, NULL_=39, OR_=40, THEN_=41, TRUE_=42, WHEN_=43, 
		NUMERIC_LITERAL=44, STRING_LITERAL=45, IDENTIFIER=46, ID=47, UNICODE_ID=48, 
		SINGLE_LINE_COMMENT=49, MULTILINE_COMMENT=50, SPACES=51;
	public static final int
		RULE_parse = 0, RULE_expr = 1, RULE_unaryOperator = 2, RULE_literal = 3, 
		RULE_template = 4, RULE_columnRef = 5, RULE_generalFunc = 6, RULE_nativeFunc = 7, 
		RULE_funcName = 8, RULE_schemaName = 9, RULE_tableName = 10, RULE_columnName = 11, 
		RULE_anyName = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "expr", "unaryOperator", "literal", "template", "columnRef", 
			"generalFunc", "nativeFunc", "funcName", "schemaName", "tableName", "columnName", 
			"anyName"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'${'", "'.'", "'['", "']'", "'('", "')'", "'{'", "'}'", "'#'", 
			"'@'", "','", "'='", "'*'", "'+'", "'-'", "'~'", "'||'", "'/'", "'%'", 
			"'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'<>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TEMPLATEBRACE", "DOT", "OPENBRACKET", "CLOSEBRACKET", "OPEN_PAR", 
			"CLOSE_PAR", "OPENBRACE", "CLOSEBRACE", "SHARP", "AT", "COMMA", "ASSIGN", 
			"STAR", "PLUS", "MINUS", "TILDE", "PIPE2", "DIV", "MOD", "LT", "LT_EQ", 
			"GT", "GT_EQ", "EQ", "NOT_EQ1", "NOT_EQ2", "AND_", "BETWEEN_", "CASE_", 
			"ELSE_", "END_", "FALSE_", "IN_", "IS_", "ISNULL_", "LIKE_", "NOT_", 
			"NOTNULL_", "NULL_", "OR_", "THEN_", "TRUE_", "WHEN_", "NUMERIC_LITERAL", 
			"STRING_LITERAL", "IDENTIFIER", "ID", "UNICODE_ID", "SINGLE_LINE_COMMENT", 
			"MULTILINE_COMMENT", "SPACES"
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
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ColumnRefContext columnRef() {
			return getRuleContext(ColumnRefContext.class,0);
		}
		public TemplateContext template() {
			return getRuleContext(TemplateContext.class,0);
		}
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public GeneralFuncContext generalFunc() {
			return getRuleContext(GeneralFuncContext.class,0);
		}
		public NativeFuncContext nativeFunc() {
			return getRuleContext(NativeFuncContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(ExprParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(ExprParser.CLOSE_PAR, 0); }
		public TerminalNode CASE_() { return getToken(ExprParser.CASE_, 0); }
		public TerminalNode END_() { return getToken(ExprParser.END_, 0); }
		public List<TerminalNode> WHEN_() { return getTokens(ExprParser.WHEN_); }
		public TerminalNode WHEN_(int i) {
			return getToken(ExprParser.WHEN_, i);
		}
		public List<TerminalNode> THEN_() { return getTokens(ExprParser.THEN_); }
		public TerminalNode THEN_(int i) {
			return getToken(ExprParser.THEN_, i);
		}
		public TerminalNode ELSE_() { return getToken(ExprParser.ELSE_, 0); }
		public TerminalNode STAR() { return getToken(ExprParser.STAR, 0); }
		public TerminalNode DIV() { return getToken(ExprParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(ExprParser.MOD, 0); }
		public TerminalNode PLUS() { return getToken(ExprParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ExprParser.MINUS, 0); }
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
		public TerminalNode AND_() { return getToken(ExprParser.AND_, 0); }
		public TerminalNode OR_() { return getToken(ExprParser.OR_, 0); }
		public TerminalNode BETWEEN_() { return getToken(ExprParser.BETWEEN_, 0); }
		public TerminalNode ISNULL_() { return getToken(ExprParser.ISNULL_, 0); }
		public TerminalNode NOTNULL_() { return getToken(ExprParser.NOTNULL_, 0); }
		public TerminalNode NULL_() { return getToken(ExprParser.NULL_, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitExpr(this);
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
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(30);
				literal();
				}
				break;
			case 2:
				{
				setState(31);
				columnRef();
				}
				break;
			case 3:
				{
				setState(32);
				template();
				}
				break;
			case 4:
				{
				setState(33);
				unaryOperator();
				setState(34);
				expr(14);
				}
				break;
			case 5:
				{
				setState(36);
				generalFunc();
				}
				break;
			case 6:
				{
				setState(37);
				nativeFunc();
				}
				break;
			case 7:
				{
				setState(38);
				match(OPEN_PAR);
				setState(39);
				expr(0);
				setState(40);
				match(CLOSE_PAR);
				}
				break;
			case 8:
				{
				setState(42);
				match(CASE_);
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEMPLATEBRACE) | (1L << OPENBRACKET) | (1L << OPEN_PAR) | (1L << AT) | (1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << CASE_) | (1L << FALSE_) | (1L << NOT_) | (1L << NULL_) | (1L << TRUE_) | (1L << NUMERIC_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(43);
					expr(0);
					}
				}

				setState(51); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(46);
					match(WHEN_);
					setState(47);
					expr(0);
					setState(48);
					match(THEN_);
					setState(49);
					expr(0);
					}
					}
					setState(53); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN_ );
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE_) {
					{
					setState(55);
					match(ELSE_);
					setState(56);
					expr(0);
					}
				}

				setState(59);
				match(END_);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(114);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(112);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(63);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(64);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(65);
						expr(14);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(66);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(67);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(68);
						expr(13);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(69);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(70);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << LT_EQ) | (1L << GT) | (1L << GT_EQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(71);
						expr(12);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(72);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(81);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
						case 1:
							{
							setState(73);
							match(EQ);
							}
							break;
						case 2:
							{
							setState(74);
							match(NOT_EQ1);
							}
							break;
						case 3:
							{
							setState(75);
							match(NOT_EQ2);
							}
							break;
						case 4:
							{
							setState(76);
							match(IS_);
							}
							break;
						case 5:
							{
							setState(77);
							match(IS_);
							setState(78);
							match(NOT_);
							}
							break;
						case 6:
							{
							setState(79);
							match(IN_);
							}
							break;
						case 7:
							{
							setState(80);
							match(LIKE_);
							}
							break;
						}
						setState(83);
						expr(11);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(84);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(85);
						match(AND_);
						setState(86);
						expr(10);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(87);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(88);
						match(OR_);
						setState(89);
						expr(9);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(90);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(91);
						match(IS_);
						setState(93);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
						case 1:
							{
							setState(92);
							match(NOT_);
							}
							break;
						}
						setState(95);
						expr(5);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(96);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(98);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT_) {
							{
							setState(97);
							match(NOT_);
							}
						}

						setState(100);
						match(BETWEEN_);
						setState(101);
						expr(0);
						setState(102);
						match(AND_);
						setState(103);
						expr(4);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(105);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(110);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case ISNULL_:
							{
							setState(106);
							match(ISNULL_);
							}
							break;
						case NOTNULL_:
							{
							setState(107);
							match(NOTNULL_);
							}
							break;
						case NOT_:
							{
							setState(108);
							match(NOT_);
							setState(109);
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
				setState(116);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public static class UnaryOperatorContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(ExprParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(ExprParser.PLUS, 0); }
		public TerminalNode TILDE() { return getToken(ExprParser.TILDE, 0); }
		public TerminalNode NOT_() { return getToken(ExprParser.NOT_, 0); }
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterUnaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitUnaryOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitUnaryOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_unaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << NOT_))) != 0)) ) {
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
		enterRule(_localctx, 6, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
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
		enterRule(_localctx, 8, RULE_template);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(TEMPLATEBRACE);
			setState(125);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(122);
					matchWildcard();
					}
					} 
				}
				setState(127);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(128);
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
		public List<TerminalNode> OPENBRACKET() { return getTokens(ExprParser.OPENBRACKET); }
		public TerminalNode OPENBRACKET(int i) {
			return getToken(ExprParser.OPENBRACKET, i);
		}
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public List<TerminalNode> CLOSEBRACKET() { return getTokens(ExprParser.CLOSEBRACKET); }
		public TerminalNode CLOSEBRACKET(int i) {
			return getToken(ExprParser.CLOSEBRACKET, i);
		}
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(ExprParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ExprParser.DOT, i);
		}
		public SchemaNameContext schemaName() {
			return getRuleContext(SchemaNameContext.class,0);
		}
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
		enterRule(_localctx, 10, RULE_columnRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(135);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(130);
					match(OPENBRACKET);
					setState(131);
					schemaName();
					setState(132);
					match(CLOSEBRACKET);
					setState(133);
					match(DOT);
					}
					break;
				}
				setState(137);
				match(OPENBRACKET);
				setState(138);
				tableName();
				setState(139);
				match(CLOSEBRACKET);
				setState(140);
				match(DOT);
				}
				break;
			}
			setState(144);
			match(OPENBRACKET);
			setState(145);
			columnName();
			setState(146);
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
		enterRule(_localctx, 12, RULE_generalFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			funcName();
			setState(149);
			match(OPEN_PAR);
			setState(159);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEMPLATEBRACE:
			case OPENBRACKET:
			case OPEN_PAR:
			case AT:
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
				setState(150);
				expr(0);
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(151);
					match(COMMA);
					setState(152);
					expr(0);
					}
					}
					setState(157);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case STAR:
				{
				setState(158);
				match(STAR);
				}
				break;
			case CLOSE_PAR:
				break;
			default:
				break;
			}
			setState(161);
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
		enterRule(_localctx, 14, RULE_nativeFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(AT);
			setState(164);
			funcName();
			setState(165);
			match(OPEN_PAR);
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEMPLATEBRACE:
			case OPENBRACKET:
			case OPEN_PAR:
			case AT:
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
				setState(166);
				expr(0);
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(167);
					match(COMMA);
					setState(168);
					expr(0);
					}
					}
					setState(173);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case STAR:
				{
				setState(174);
				match(STAR);
				}
				break;
			case CLOSE_PAR:
				break;
			default:
				break;
			}
			setState(177);
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
		enterRule(_localctx, 16, RULE_funcName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
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

	public static class SchemaNameContext extends ParserRuleContext {
		public AnyNameContext anyName() {
			return getRuleContext(AnyNameContext.class,0);
		}
		public SchemaNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schemaName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).enterSchemaName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprParserListener ) ((ExprParserListener)listener).exitSchemaName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprParserVisitor ) return ((ExprParserVisitor<? extends T>)visitor).visitSchemaName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SchemaNameContext schemaName() throws RecognitionException {
		SchemaNameContext _localctx = new SchemaNameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_schemaName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
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
		public AnyNameContext anyName() {
			return getRuleContext(AnyNameContext.class,0);
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
		enterRule(_localctx, 20, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
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

	public static class ColumnNameContext extends ParserRuleContext {
		public AnyNameContext anyName() {
			return getRuleContext(AnyNameContext.class,0);
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
		enterRule(_localctx, 22, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
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

	public static class AnyNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ExprParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(ExprParser.STRING_LITERAL, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_la = _input.LA(1);
			if ( !(_la==STRING_LITERAL || _la==IDENTIFIER) ) {
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
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 4);
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\65\u00c0\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3/\n\3\3\3\3\3\3\3\3\3\3\3\6\3\66"+
		"\n\3\r\3\16\3\67\3\3\3\3\5\3<\n\3\3\3\3\3\5\3@\n\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3T\n\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3`\n\3\3\3\3\3\3\3\5\3e\n\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3q\n\3\7\3s\n\3\f\3\16\3v\13\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\7\6~\n\6\f\6\16\6\u0081\13\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\5\7\u008a\n\7\3\7\3\7\3\7\3\7\3\7\5\7\u0091\n\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\7\b\u009c\n\b\f\b\16\b\u009f\13\b\3\b\5\b\u00a2"+
		"\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00ac\n\t\f\t\16\t\u00af\13\t"+
		"\3\t\5\t\u00b2\n\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\16\3\177\3\4\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\b\4\2\17\17\24\25"+
		"\3\2\20\21\3\2\26\31\4\2\20\22\'\'\6\2\"\")),,./\3\2/\60\2\u00d8\2\34"+
		"\3\2\2\2\4?\3\2\2\2\6w\3\2\2\2\by\3\2\2\2\n{\3\2\2\2\f\u0090\3\2\2\2\16"+
		"\u0096\3\2\2\2\20\u00a5\3\2\2\2\22\u00b5\3\2\2\2\24\u00b7\3\2\2\2\26\u00b9"+
		"\3\2\2\2\30\u00bb\3\2\2\2\32\u00bd\3\2\2\2\34\35\5\4\3\2\35\36\7\2\2\3"+
		"\36\3\3\2\2\2\37 \b\3\1\2 @\5\b\5\2!@\5\f\7\2\"@\5\n\6\2#$\5\6\4\2$%\5"+
		"\4\3\20%@\3\2\2\2&@\5\16\b\2\'@\5\20\t\2()\7\7\2\2)*\5\4\3\2*+\7\b\2\2"+
		"+@\3\2\2\2,.\7\37\2\2-/\5\4\3\2.-\3\2\2\2./\3\2\2\2/\65\3\2\2\2\60\61"+
		"\7-\2\2\61\62\5\4\3\2\62\63\7+\2\2\63\64\5\4\3\2\64\66\3\2\2\2\65\60\3"+
		"\2\2\2\66\67\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28;\3\2\2\29:\7 \2\2:<\5"+
		"\4\3\2;9\3\2\2\2;<\3\2\2\2<=\3\2\2\2=>\7!\2\2>@\3\2\2\2?\37\3\2\2\2?!"+
		"\3\2\2\2?\"\3\2\2\2?#\3\2\2\2?&\3\2\2\2?\'\3\2\2\2?(\3\2\2\2?,\3\2\2\2"+
		"@t\3\2\2\2AB\f\17\2\2BC\t\2\2\2Cs\5\4\3\20DE\f\16\2\2EF\t\3\2\2Fs\5\4"+
		"\3\17GH\f\r\2\2HI\t\4\2\2Is\5\4\3\16JS\f\f\2\2KT\7\32\2\2LT\7\33\2\2M"+
		"T\7\34\2\2NT\7$\2\2OP\7$\2\2PT\7\'\2\2QT\7#\2\2RT\7&\2\2SK\3\2\2\2SL\3"+
		"\2\2\2SM\3\2\2\2SN\3\2\2\2SO\3\2\2\2SQ\3\2\2\2SR\3\2\2\2TU\3\2\2\2Us\5"+
		"\4\3\rVW\f\13\2\2WX\7\35\2\2Xs\5\4\3\fYZ\f\n\2\2Z[\7*\2\2[s\5\4\3\13\\"+
		"]\f\6\2\2]_\7$\2\2^`\7\'\2\2_^\3\2\2\2_`\3\2\2\2`a\3\2\2\2as\5\4\3\7b"+
		"d\f\5\2\2ce\7\'\2\2dc\3\2\2\2de\3\2\2\2ef\3\2\2\2fg\7\36\2\2gh\5\4\3\2"+
		"hi\7\35\2\2ij\5\4\3\6js\3\2\2\2kp\f\7\2\2lq\7%\2\2mq\7(\2\2no\7\'\2\2"+
		"oq\7)\2\2pl\3\2\2\2pm\3\2\2\2pn\3\2\2\2qs\3\2\2\2rA\3\2\2\2rD\3\2\2\2"+
		"rG\3\2\2\2rJ\3\2\2\2rV\3\2\2\2rY\3\2\2\2r\\\3\2\2\2rb\3\2\2\2rk\3\2\2"+
		"\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2u\5\3\2\2\2vt\3\2\2\2wx\t\5\2\2x\7\3\2"+
		"\2\2yz\t\6\2\2z\t\3\2\2\2{\177\7\3\2\2|~\13\2\2\2}|\3\2\2\2~\u0081\3\2"+
		"\2\2\177\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0082\3\2\2\2\u0081\177\3\2"+
		"\2\2\u0082\u0083\7\n\2\2\u0083\13\3\2\2\2\u0084\u0085\7\5\2\2\u0085\u0086"+
		"\5\24\13\2\u0086\u0087\7\6\2\2\u0087\u0088\7\4\2\2\u0088\u008a\3\2\2\2"+
		"\u0089\u0084\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c"+
		"\7\5\2\2\u008c\u008d\5\26\f\2\u008d\u008e\7\6\2\2\u008e\u008f\7\4\2\2"+
		"\u008f\u0091\3\2\2\2\u0090\u0089\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092"+
		"\3\2\2\2\u0092\u0093\7\5\2\2\u0093\u0094\5\30\r\2\u0094\u0095\7\6\2\2"+
		"\u0095\r\3\2\2\2\u0096\u0097\5\22\n\2\u0097\u00a1\7\7\2\2\u0098\u009d"+
		"\5\4\3\2\u0099\u009a\7\r\2\2\u009a\u009c\5\4\3\2\u009b\u0099\3\2\2\2\u009c"+
		"\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a2\3\2"+
		"\2\2\u009f\u009d\3\2\2\2\u00a0\u00a2\7\17\2\2\u00a1\u0098\3\2\2\2\u00a1"+
		"\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\7\b"+
		"\2\2\u00a4\17\3\2\2\2\u00a5\u00a6\7\f\2\2\u00a6\u00a7\5\22\n\2\u00a7\u00b1"+
		"\7\7\2\2\u00a8\u00ad\5\4\3\2\u00a9\u00aa\7\r\2\2\u00aa\u00ac\5\4\3\2\u00ab"+
		"\u00a9\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2"+
		"\2\2\u00ae\u00b2\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b2\7\17\2\2\u00b1"+
		"\u00a8\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2"+
		"\2\2\u00b3\u00b4\7\b\2\2\u00b4\21\3\2\2\2\u00b5\u00b6\5\32\16\2\u00b6"+
		"\23\3\2\2\2\u00b7\u00b8\5\32\16\2\u00b8\25\3\2\2\2\u00b9\u00ba\5\32\16"+
		"\2\u00ba\27\3\2\2\2\u00bb\u00bc\5\32\16\2\u00bc\31\3\2\2\2\u00bd\u00be"+
		"\t\7\2\2\u00be\33\3\2\2\2\23.\67;?S_dprt\177\u0089\u0090\u009d\u00a1\u00ad"+
		"\u00b1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}