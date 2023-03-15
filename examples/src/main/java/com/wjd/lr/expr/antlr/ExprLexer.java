// Generated from ExprLexer.g4 by ANTLR 4.9.3

package com.wjd.lr.expr.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"TEMPLATEBRACE", "SEMI", "COMMA", "DOT", "QUESTION", "COLON", "SHARP", 
			"AT", "BANG", "OPENBRACKET", "CLOSEBRACKET", "OPEN_PAR", "CLOSE_PAR", 
			"OPENBRACE", "CLOSEBRACE", "ASSIGN", "STAR", "PLUS", "MINUS", "TILDE", 
			"PIPE2", "AND", "DIV", "MOD", "LT", "LT_EQ", "GT", "GT_EQ", "EQ", "NOT_EQ1", 
			"NOT_EQ2", "BITOR", "CARET", "BITAND", "AND_", "BETWEEN_", "CASE_", "ELSE_", 
			"END_", "FALSE_", "IN_", "IS_", "ISNULL_", "LIKE_", "NOT_", "NOTNULL_", 
			"NULL_", "OR_", "THEN_", "TRUE_", "WHEN_", "NUMERIC_LITERAL", "STRING_LITERAL", 
			"IDENTIFIER", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "SPACES", "LETTER", 
			"SPECIAL_LETTER", "DIGIT", "A", "B", "C", "D", "E", "F", "G", "H", "I", 
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", 
			"X", "Y", "Z"
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


	public ExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ExprLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2;\u01ee\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34"+
		"\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3\""+
		"\3\"\3#\3#\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'"+
		"\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,"+
		"\3,\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3"+
		"\60\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3"+
		"\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\65\6\65\u0152\n\65\r\65\16\65"+
		"\u0153\3\65\3\65\7\65\u0158\n\65\f\65\16\65\u015b\13\65\5\65\u015d\n\65"+
		"\3\65\3\65\6\65\u0161\n\65\r\65\16\65\u0162\5\65\u0165\n\65\3\66\3\66"+
		"\3\66\3\66\7\66\u016b\n\66\f\66\16\66\u016e\13\66\3\66\3\66\3\67\3\67"+
		"\3\67\3\67\7\67\u0176\n\67\f\67\16\67\u0179\13\67\3\67\3\67\3\67\3\67"+
		"\3\67\7\67\u0180\n\67\f\67\16\67\u0183\13\67\3\67\3\67\3\67\3\67\3\67"+
		"\7\67\u018a\n\67\f\67\16\67\u018d\13\67\5\67\u018f\n\67\38\38\38\38\7"+
		"8\u0195\n8\f8\168\u0198\138\38\58\u019b\n8\38\38\58\u019f\n8\38\38\39"+
		"\39\39\39\79\u01a7\n9\f9\169\u01aa\139\39\39\39\39\39\3:\3:\3:\3:\3;\3"+
		";\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3"+
		"G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3"+
		"R\3S\3S\3T\3T\3U\3U\3V\3V\3W\3W\3\u01a8\2X\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u\2w\2y\2{\2}\2\177\2"+
		"\u0081\2\u0083\2\u0085\2\u0087\2\u0089\2\u008b\2\u008d\2\u008f\2\u0091"+
		"\2\u0093\2\u0095\2\u0097\2\u0099\2\u009b\2\u009d\2\u009f\2\u00a1\2\u00a3"+
		"\2\u00a5\2\u00a7\2\u00a9\2\u00ab\2\u00ad\2\3\2$\3\2))\3\2$$\3\2bb\4\2"+
		"\f\f\17\17\5\2\13\r\17\17\"\"\7\2&&C\\aac|\u0082\1\3\2//\3\2\62;\4\2C"+
		"Ccc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4"+
		"\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTt"+
		"t\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2"+
		"\u01e4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3"+
		"\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2"+
		"\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2"+
		"m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\3\u00af\3\2\2\2\5\u00b2\3\2"+
		"\2\2\7\u00b4\3\2\2\2\t\u00b6\3\2\2\2\13\u00b8\3\2\2\2\r\u00ba\3\2\2\2"+
		"\17\u00bc\3\2\2\2\21\u00be\3\2\2\2\23\u00c0\3\2\2\2\25\u00c2\3\2\2\2\27"+
		"\u00c4\3\2\2\2\31\u00c6\3\2\2\2\33\u00c8\3\2\2\2\35\u00ca\3\2\2\2\37\u00cc"+
		"\3\2\2\2!\u00ce\3\2\2\2#\u00d0\3\2\2\2%\u00d2\3\2\2\2\'\u00d4\3\2\2\2"+
		")\u00d6\3\2\2\2+\u00d8\3\2\2\2-\u00db\3\2\2\2/\u00de\3\2\2\2\61\u00e0"+
		"\3\2\2\2\63\u00e2\3\2\2\2\65\u00e4\3\2\2\2\67\u00e7\3\2\2\29\u00e9\3\2"+
		"\2\2;\u00ec\3\2\2\2=\u00ef\3\2\2\2?\u00f2\3\2\2\2A\u00f5\3\2\2\2C\u00f7"+
		"\3\2\2\2E\u00f9\3\2\2\2G\u00fb\3\2\2\2I\u00ff\3\2\2\2K\u0107\3\2\2\2M"+
		"\u010c\3\2\2\2O\u0111\3\2\2\2Q\u0115\3\2\2\2S\u011b\3\2\2\2U\u011e\3\2"+
		"\2\2W\u0121\3\2\2\2Y\u0128\3\2\2\2[\u012d\3\2\2\2]\u0131\3\2\2\2_\u0139"+
		"\3\2\2\2a\u013e\3\2\2\2c\u0141\3\2\2\2e\u0146\3\2\2\2g\u014b\3\2\2\2i"+
		"\u0164\3\2\2\2k\u0166\3\2\2\2m\u018e\3\2\2\2o\u0190\3\2\2\2q\u01a2\3\2"+
		"\2\2s\u01b0\3\2\2\2u\u01b4\3\2\2\2w\u01b6\3\2\2\2y\u01b8\3\2\2\2{\u01ba"+
		"\3\2\2\2}\u01bc\3\2\2\2\177\u01be\3\2\2\2\u0081\u01c0\3\2\2\2\u0083\u01c2"+
		"\3\2\2\2\u0085\u01c4\3\2\2\2\u0087\u01c6\3\2\2\2\u0089\u01c8\3\2\2\2\u008b"+
		"\u01ca\3\2\2\2\u008d\u01cc\3\2\2\2\u008f\u01ce\3\2\2\2\u0091\u01d0\3\2"+
		"\2\2\u0093\u01d2\3\2\2\2\u0095\u01d4\3\2\2\2\u0097\u01d6\3\2\2\2\u0099"+
		"\u01d8\3\2\2\2\u009b\u01da\3\2\2\2\u009d\u01dc\3\2\2\2\u009f\u01de\3\2"+
		"\2\2\u00a1\u01e0\3\2\2\2\u00a3\u01e2\3\2\2\2\u00a5\u01e4\3\2\2\2\u00a7"+
		"\u01e6\3\2\2\2\u00a9\u01e8\3\2\2\2\u00ab\u01ea\3\2\2\2\u00ad\u01ec\3\2"+
		"\2\2\u00af\u00b0\7&\2\2\u00b0\u00b1\7}\2\2\u00b1\4\3\2\2\2\u00b2\u00b3"+
		"\7=\2\2\u00b3\6\3\2\2\2\u00b4\u00b5\7.\2\2\u00b5\b\3\2\2\2\u00b6\u00b7"+
		"\7\60\2\2\u00b7\n\3\2\2\2\u00b8\u00b9\7A\2\2\u00b9\f\3\2\2\2\u00ba\u00bb"+
		"\7<\2\2\u00bb\16\3\2\2\2\u00bc\u00bd\7%\2\2\u00bd\20\3\2\2\2\u00be\u00bf"+
		"\7B\2\2\u00bf\22\3\2\2\2\u00c0\u00c1\7#\2\2\u00c1\24\3\2\2\2\u00c2\u00c3"+
		"\7]\2\2\u00c3\26\3\2\2\2\u00c4\u00c5\7_\2\2\u00c5\30\3\2\2\2\u00c6\u00c7"+
		"\7*\2\2\u00c7\32\3\2\2\2\u00c8\u00c9\7+\2\2\u00c9\34\3\2\2\2\u00ca\u00cb"+
		"\7}\2\2\u00cb\36\3\2\2\2\u00cc\u00cd\7\177\2\2\u00cd \3\2\2\2\u00ce\u00cf"+
		"\7?\2\2\u00cf\"\3\2\2\2\u00d0\u00d1\7,\2\2\u00d1$\3\2\2\2\u00d2\u00d3"+
		"\7-\2\2\u00d3&\3\2\2\2\u00d4\u00d5\7/\2\2\u00d5(\3\2\2\2\u00d6\u00d7\7"+
		"\u0080\2\2\u00d7*\3\2\2\2\u00d8\u00d9\7~\2\2\u00d9\u00da\7~\2\2\u00da"+
		",\3\2\2\2\u00db\u00dc\7(\2\2\u00dc\u00dd\7(\2\2\u00dd.\3\2\2\2\u00de\u00df"+
		"\7\61\2\2\u00df\60\3\2\2\2\u00e0\u00e1\7\'\2\2\u00e1\62\3\2\2\2\u00e2"+
		"\u00e3\7>\2\2\u00e3\64\3\2\2\2\u00e4\u00e5\7>\2\2\u00e5\u00e6\7?\2\2\u00e6"+
		"\66\3\2\2\2\u00e7\u00e8\7@\2\2\u00e88\3\2\2\2\u00e9\u00ea\7@\2\2\u00ea"+
		"\u00eb\7?\2\2\u00eb:\3\2\2\2\u00ec\u00ed\7?\2\2\u00ed\u00ee\7?\2\2\u00ee"+
		"<\3\2\2\2\u00ef\u00f0\7#\2\2\u00f0\u00f1\7?\2\2\u00f1>\3\2\2\2\u00f2\u00f3"+
		"\7>\2\2\u00f3\u00f4\7@\2\2\u00f4@\3\2\2\2\u00f5\u00f6\7~\2\2\u00f6B\3"+
		"\2\2\2\u00f7\u00f8\7`\2\2\u00f8D\3\2\2\2\u00f9\u00fa\7(\2\2\u00faF\3\2"+
		"\2\2\u00fb\u00fc\5{>\2\u00fc\u00fd\5\u0095K\2\u00fd\u00fe\5\u0081A\2\u00fe"+
		"H\3\2\2\2\u00ff\u0100\5}?\2\u0100\u0101\5\u0083B\2\u0101\u0102\5\u00a1"+
		"Q\2\u0102\u0103\5\u00a7T\2\u0103\u0104\5\u0083B\2\u0104\u0105\5\u0083"+
		"B\2\u0105\u0106\5\u0095K\2\u0106J\3\2\2\2\u0107\u0108\5\177@\2\u0108\u0109"+
		"\5{>\2\u0109\u010a\5\u009fP\2\u010a\u010b\5\u0083B\2\u010bL\3\2\2\2\u010c"+
		"\u010d\5\u0083B\2\u010d\u010e\5\u0091I\2\u010e\u010f\5\u009fP\2\u010f"+
		"\u0110\5\u0083B\2\u0110N\3\2\2\2\u0111\u0112\5\u0083B\2\u0112\u0113\5"+
		"\u0095K\2\u0113\u0114\5\u0081A\2\u0114P\3\2\2\2\u0115\u0116\5\u0085C\2"+
		"\u0116\u0117\5{>\2\u0117\u0118\5\u0091I\2\u0118\u0119\5\u009fP\2\u0119"+
		"\u011a\5\u0083B\2\u011aR\3\2\2\2\u011b\u011c\5\u008bF\2\u011c\u011d\5"+
		"\u0095K\2\u011dT\3\2\2\2\u011e\u011f\5\u008bF\2\u011f\u0120\5\u009fP\2"+
		"\u0120V\3\2\2\2\u0121\u0122\5\u008bF\2\u0122\u0123\5\u009fP\2\u0123\u0124"+
		"\5\u0095K\2\u0124\u0125\5\u00a3R\2\u0125\u0126\5\u0091I\2\u0126\u0127"+
		"\5\u0091I\2\u0127X\3\2\2\2\u0128\u0129\5\u0091I\2\u0129\u012a\5\u008b"+
		"F\2\u012a\u012b\5\u008fH\2\u012b\u012c\5\u0083B\2\u012cZ\3\2\2\2\u012d"+
		"\u012e\5\u0095K\2\u012e\u012f\5\u0097L\2\u012f\u0130\5\u00a1Q\2\u0130"+
		"\\\3\2\2\2\u0131\u0132\5\u0095K\2\u0132\u0133\5\u0097L\2\u0133\u0134\5"+
		"\u00a1Q\2\u0134\u0135\5\u0095K\2\u0135\u0136\5\u00a3R\2\u0136\u0137\5"+
		"\u0091I\2\u0137\u0138\5\u0091I\2\u0138^\3\2\2\2\u0139\u013a\5\u0095K\2"+
		"\u013a\u013b\5\u00a3R\2\u013b\u013c\5\u0091I\2\u013c\u013d\5\u0091I\2"+
		"\u013d`\3\2\2\2\u013e\u013f\5\u0097L\2\u013f\u0140\5\u009dO\2\u0140b\3"+
		"\2\2\2\u0141\u0142\5\u00a1Q\2\u0142\u0143\5\u0089E\2\u0143\u0144\5\u0083"+
		"B\2\u0144\u0145\5\u0095K\2\u0145d\3\2\2\2\u0146\u0147\5\u00a1Q\2\u0147"+
		"\u0148\5\u009dO\2\u0148\u0149\5\u00a3R\2\u0149\u014a\5\u0083B\2\u014a"+
		"f\3\2\2\2\u014b\u014c\5\u00a7T\2\u014c\u014d\5\u0089E\2\u014d\u014e\5"+
		"\u0083B\2\u014e\u014f\5\u0095K\2\u014fh\3\2\2\2\u0150\u0152\5y=\2\u0151"+
		"\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2"+
		"\2\2\u0154\u015c\3\2\2\2\u0155\u0159\7\60\2\2\u0156\u0158\5y=\2\u0157"+
		"\u0156\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2"+
		"\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015c\u0155\3\2\2\2\u015c"+
		"\u015d\3\2\2\2\u015d\u0165\3\2\2\2\u015e\u0160\7\60\2\2\u015f\u0161\5"+
		"y=\2\u0160\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0160\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163\u0165\3\2\2\2\u0164\u0151\3\2\2\2\u0164\u015e\3\2"+
		"\2\2\u0165j\3\2\2\2\u0166\u016c\7)\2\2\u0167\u016b\n\2\2\2\u0168\u0169"+
		"\7)\2\2\u0169\u016b\7)\2\2\u016a\u0167\3\2\2\2\u016a\u0168\3\2\2\2\u016b"+
		"\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016f\3\2"+
		"\2\2\u016e\u016c\3\2\2\2\u016f\u0170\7)\2\2\u0170l\3\2\2\2\u0171\u0177"+
		"\7$\2\2\u0172\u0176\n\3\2\2\u0173\u0174\7$\2\2\u0174\u0176\7$\2\2\u0175"+
		"\u0172\3\2\2\2\u0175\u0173\3\2\2\2\u0176\u0179\3\2\2\2\u0177\u0175\3\2"+
		"\2\2\u0177\u0178\3\2\2\2\u0178\u017a\3\2\2\2\u0179\u0177\3\2\2\2\u017a"+
		"\u018f\7$\2\2\u017b\u0181\7b\2\2\u017c\u0180\n\4\2\2\u017d\u017e\7b\2"+
		"\2\u017e\u0180\7b\2\2\u017f\u017c\3\2\2\2\u017f\u017d\3\2\2\2\u0180\u0183"+
		"\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0184\3\2\2\2\u0183"+
		"\u0181\3\2\2\2\u0184\u018f\7b\2\2\u0185\u018b\5u;\2\u0186\u018a\5u;\2"+
		"\u0187\u018a\5w<\2\u0188\u018a\5y=\2\u0189\u0186\3\2\2\2\u0189\u0187\3"+
		"\2\2\2\u0189\u0188\3\2\2\2\u018a\u018d\3\2\2\2\u018b\u0189\3\2\2\2\u018b"+
		"\u018c\3\2\2\2\u018c\u018f\3\2\2\2\u018d\u018b\3\2\2\2\u018e\u0171\3\2"+
		"\2\2\u018e\u017b\3\2\2\2\u018e\u0185\3\2\2\2\u018fn\3\2\2\2\u0190\u0191"+
		"\7/\2\2\u0191\u0192\7/\2\2\u0192\u0196\3\2\2\2\u0193\u0195\n\5\2\2\u0194"+
		"\u0193\3\2\2\2\u0195\u0198\3\2\2\2\u0196\u0194\3\2\2\2\u0196\u0197\3\2"+
		"\2\2\u0197\u019e\3\2\2\2\u0198\u0196\3\2\2\2\u0199\u019b\7\17\2\2\u019a"+
		"\u0199\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019f\7\f"+
		"\2\2\u019d\u019f\7\2\2\3\u019e\u019a\3\2\2\2\u019e\u019d\3\2\2\2\u019f"+
		"\u01a0\3\2\2\2\u01a0\u01a1\b8\2\2\u01a1p\3\2\2\2\u01a2\u01a3\7\61\2\2"+
		"\u01a3\u01a4\7,\2\2\u01a4\u01a8\3\2\2\2\u01a5\u01a7\13\2\2\2\u01a6\u01a5"+
		"\3\2\2\2\u01a7\u01aa\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a9"+
		"\u01ab\3\2\2\2\u01aa\u01a8\3\2\2\2\u01ab\u01ac\7,\2\2\u01ac\u01ad\7\61"+
		"\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01af\b9\2\2\u01afr\3\2\2\2\u01b0\u01b1"+
		"\t\6\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b3\b:\2\2\u01b3t\3\2\2\2\u01b4\u01b5"+
		"\t\7\2\2\u01b5v\3\2\2\2\u01b6\u01b7\t\b\2\2\u01b7x\3\2\2\2\u01b8\u01b9"+
		"\t\t\2\2\u01b9z\3\2\2\2\u01ba\u01bb\t\n\2\2\u01bb|\3\2\2\2\u01bc\u01bd"+
		"\t\13\2\2\u01bd~\3\2\2\2\u01be\u01bf\t\f\2\2\u01bf\u0080\3\2\2\2\u01c0"+
		"\u01c1\t\r\2\2\u01c1\u0082\3\2\2\2\u01c2\u01c3\t\16\2\2\u01c3\u0084\3"+
		"\2\2\2\u01c4\u01c5\t\17\2\2\u01c5\u0086\3\2\2\2\u01c6\u01c7\t\20\2\2\u01c7"+
		"\u0088\3\2\2\2\u01c8\u01c9\t\21\2\2\u01c9\u008a\3\2\2\2\u01ca\u01cb\t"+
		"\22\2\2\u01cb\u008c\3\2\2\2\u01cc\u01cd\t\23\2\2\u01cd\u008e\3\2\2\2\u01ce"+
		"\u01cf\t\24\2\2\u01cf\u0090\3\2\2\2\u01d0\u01d1\t\25\2\2\u01d1\u0092\3"+
		"\2\2\2\u01d2\u01d3\t\26\2\2\u01d3\u0094\3\2\2\2\u01d4\u01d5\t\27\2\2\u01d5"+
		"\u0096\3\2\2\2\u01d6\u01d7\t\30\2\2\u01d7\u0098\3\2\2\2\u01d8\u01d9\t"+
		"\31\2\2\u01d9\u009a\3\2\2\2\u01da\u01db\t\32\2\2\u01db\u009c\3\2\2\2\u01dc"+
		"\u01dd\t\33\2\2\u01dd\u009e\3\2\2\2\u01de\u01df\t\34\2\2\u01df\u00a0\3"+
		"\2\2\2\u01e0\u01e1\t\35\2\2\u01e1\u00a2\3\2\2\2\u01e2\u01e3\t\36\2\2\u01e3"+
		"\u00a4\3\2\2\2\u01e4\u01e5\t\37\2\2\u01e5\u00a6\3\2\2\2\u01e6\u01e7\t"+
		" \2\2\u01e7\u00a8\3\2\2\2\u01e8\u01e9\t!\2\2\u01e9\u00aa\3\2\2\2\u01ea"+
		"\u01eb\t\"\2\2\u01eb\u00ac\3\2\2\2\u01ec\u01ed\t#\2\2\u01ed\u00ae\3\2"+
		"\2\2\25\2\u0153\u0159\u015c\u0162\u0164\u016a\u016c\u0175\u0177\u017f"+
		"\u0181\u0189\u018b\u018e\u0196\u019a\u019e\u01a8\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}