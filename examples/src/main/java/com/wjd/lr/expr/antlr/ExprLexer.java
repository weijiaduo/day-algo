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
		TEMPLATEBRACE=1, DOT=2, OPENBRACKET=3, CLOSEBRACKET=4, OPEN_PAR=5, CLOSE_PAR=6, 
		OPENBRACE=7, CLOSEBRACE=8, SHARP=9, AT=10, COMMA=11, ASSIGN=12, STAR=13, 
		PLUS=14, MINUS=15, TILDE=16, PIPE2=17, DIV=18, MOD=19, LT=20, LT_EQ=21, 
		GT=22, GT_EQ=23, EQ=24, NOT_EQ1=25, NOT_EQ2=26, AND_=27, BETWEEN_=28, 
		CASE_=29, ELSE_=30, END_=31, FALSE_=32, IN_=33, IS_=34, ISNULL_=35, LIKE_=36, 
		NOT_=37, NOTNULL_=38, NULL_=39, OR_=40, THEN_=41, TRUE_=42, WHEN_=43, 
		NUMERIC_LITERAL=44, STRING_LITERAL=45, IDENTIFIER=46, ID=47, SINGLE_LINE_COMMENT=48, 
		MULTILINE_COMMENT=49, SPACES=50;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"TEMPLATEBRACE", "DOT", "OPENBRACKET", "CLOSEBRACKET", "OPEN_PAR", "CLOSE_PAR", 
			"OPENBRACE", "CLOSEBRACE", "SHARP", "AT", "COMMA", "ASSIGN", "STAR", 
			"PLUS", "MINUS", "TILDE", "PIPE2", "DIV", "MOD", "LT", "LT_EQ", "GT", 
			"GT_EQ", "EQ", "NOT_EQ1", "NOT_EQ2", "AND_", "BETWEEN_", "CASE_", "ELSE_", 
			"END_", "FALSE_", "IN_", "IS_", "ISNULL_", "LIKE_", "NOT_", "NOTNULL_", 
			"NULL_", "OR_", "THEN_", "TRUE_", "WHEN_", "NUMERIC_LITERAL", "STRING_LITERAL", 
			"IDENTIFIER", "ID", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "SPACES", 
			"DIGIT", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", 
			"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
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
			"STRING_LITERAL", "IDENTIFIER", "ID", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", 
			"SPACES"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u01c9\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5"+
		"\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3"+
		" \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3"+
		"%\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3("+
		"\3(\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\6-\u012f"+
		"\n-\r-\16-\u0130\3-\3-\7-\u0135\n-\f-\16-\u0138\13-\5-\u013a\n-\3-\3-"+
		"\6-\u013e\n-\r-\16-\u013f\5-\u0142\n-\3.\3.\3.\3.\7.\u0148\n.\f.\16.\u014b"+
		"\13.\3.\3.\3/\3/\3/\3/\7/\u0153\n/\f/\16/\u0156\13/\3/\3/\3/\3/\3/\7/"+
		"\u015d\n/\f/\16/\u0160\13/\3/\3/\3/\3/\3/\7/\u0167\n/\f/\16/\u016a\13"+
		"/\5/\u016c\n/\3\60\3\60\3\61\3\61\3\61\3\61\7\61\u0174\n\61\f\61\16\61"+
		"\u0177\13\61\3\61\5\61\u017a\n\61\3\61\3\61\5\61\u017e\n\61\3\61\3\61"+
		"\3\62\3\62\3\62\3\62\7\62\u0186\n\62\f\62\16\62\u0189\13\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67"+
		"\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3"+
		"B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3"+
		"N\3N\3\u0187\2O\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64"+
		"g\2i\2k\2m\2o\2q\2s\2u\2w\2y\2{\2}\2\177\2\u0081\2\u0083\2\u0085\2\u0087"+
		"\2\u0089\2\u008b\2\u008d\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097\2\u0099"+
		"\2\u009b\2\3\2$\3\2))\3\2$$\3\2bb\3\2//\6\2C\\aac|\u0082\1\4\2\f\f\17"+
		"\17\5\2\13\r\17\17\"\"\3\2\62;\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGg"+
		"g\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2"+
		"PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4"+
		"\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u01c1\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2"+
		"\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\3"+
		"\u009d\3\2\2\2\5\u00a0\3\2\2\2\7\u00a2\3\2\2\2\t\u00a4\3\2\2\2\13\u00a6"+
		"\3\2\2\2\r\u00a8\3\2\2\2\17\u00aa\3\2\2\2\21\u00ac\3\2\2\2\23\u00ae\3"+
		"\2\2\2\25\u00b0\3\2\2\2\27\u00b2\3\2\2\2\31\u00b4\3\2\2\2\33\u00b6\3\2"+
		"\2\2\35\u00b8\3\2\2\2\37\u00ba\3\2\2\2!\u00bc\3\2\2\2#\u00be\3\2\2\2%"+
		"\u00c1\3\2\2\2\'\u00c3\3\2\2\2)\u00c5\3\2\2\2+\u00c7\3\2\2\2-\u00ca\3"+
		"\2\2\2/\u00cc\3\2\2\2\61\u00cf\3\2\2\2\63\u00d2\3\2\2\2\65\u00d5\3\2\2"+
		"\2\67\u00d8\3\2\2\29\u00dc\3\2\2\2;\u00e4\3\2\2\2=\u00e9\3\2\2\2?\u00ee"+
		"\3\2\2\2A\u00f2\3\2\2\2C\u00f8\3\2\2\2E\u00fb\3\2\2\2G\u00fe\3\2\2\2I"+
		"\u0105\3\2\2\2K\u010a\3\2\2\2M\u010e\3\2\2\2O\u0116\3\2\2\2Q\u011b\3\2"+
		"\2\2S\u011e\3\2\2\2U\u0123\3\2\2\2W\u0128\3\2\2\2Y\u0141\3\2\2\2[\u0143"+
		"\3\2\2\2]\u016b\3\2\2\2_\u016d\3\2\2\2a\u016f\3\2\2\2c\u0181\3\2\2\2e"+
		"\u018f\3\2\2\2g\u0193\3\2\2\2i\u0195\3\2\2\2k\u0197\3\2\2\2m\u0199\3\2"+
		"\2\2o\u019b\3\2\2\2q\u019d\3\2\2\2s\u019f\3\2\2\2u\u01a1\3\2\2\2w\u01a3"+
		"\3\2\2\2y\u01a5\3\2\2\2{\u01a7\3\2\2\2}\u01a9\3\2\2\2\177\u01ab\3\2\2"+
		"\2\u0081\u01ad\3\2\2\2\u0083\u01af\3\2\2\2\u0085\u01b1\3\2\2\2\u0087\u01b3"+
		"\3\2\2\2\u0089\u01b5\3\2\2\2\u008b\u01b7\3\2\2\2\u008d\u01b9\3\2\2\2\u008f"+
		"\u01bb\3\2\2\2\u0091\u01bd\3\2\2\2\u0093\u01bf\3\2\2\2\u0095\u01c1\3\2"+
		"\2\2\u0097\u01c3\3\2\2\2\u0099\u01c5\3\2\2\2\u009b\u01c7\3\2\2\2\u009d"+
		"\u009e\7&\2\2\u009e\u009f\7}\2\2\u009f\4\3\2\2\2\u00a0\u00a1\7\60\2\2"+
		"\u00a1\6\3\2\2\2\u00a2\u00a3\7]\2\2\u00a3\b\3\2\2\2\u00a4\u00a5\7_\2\2"+
		"\u00a5\n\3\2\2\2\u00a6\u00a7\7*\2\2\u00a7\f\3\2\2\2\u00a8\u00a9\7+\2\2"+
		"\u00a9\16\3\2\2\2\u00aa\u00ab\7}\2\2\u00ab\20\3\2\2\2\u00ac\u00ad\7\177"+
		"\2\2\u00ad\22\3\2\2\2\u00ae\u00af\7%\2\2\u00af\24\3\2\2\2\u00b0\u00b1"+
		"\7B\2\2\u00b1\26\3\2\2\2\u00b2\u00b3\7.\2\2\u00b3\30\3\2\2\2\u00b4\u00b5"+
		"\7?\2\2\u00b5\32\3\2\2\2\u00b6\u00b7\7,\2\2\u00b7\34\3\2\2\2\u00b8\u00b9"+
		"\7-\2\2\u00b9\36\3\2\2\2\u00ba\u00bb\7/\2\2\u00bb \3\2\2\2\u00bc\u00bd"+
		"\7\u0080\2\2\u00bd\"\3\2\2\2\u00be\u00bf\7~\2\2\u00bf\u00c0\7~\2\2\u00c0"+
		"$\3\2\2\2\u00c1\u00c2\7\61\2\2\u00c2&\3\2\2\2\u00c3\u00c4\7\'\2\2\u00c4"+
		"(\3\2\2\2\u00c5\u00c6\7>\2\2\u00c6*\3\2\2\2\u00c7\u00c8\7>\2\2\u00c8\u00c9"+
		"\7?\2\2\u00c9,\3\2\2\2\u00ca\u00cb\7@\2\2\u00cb.\3\2\2\2\u00cc\u00cd\7"+
		"@\2\2\u00cd\u00ce\7?\2\2\u00ce\60\3\2\2\2\u00cf\u00d0\7?\2\2\u00d0\u00d1"+
		"\7?\2\2\u00d1\62\3\2\2\2\u00d2\u00d3\7#\2\2\u00d3\u00d4\7?\2\2\u00d4\64"+
		"\3\2\2\2\u00d5\u00d6\7>\2\2\u00d6\u00d7\7@\2\2\u00d7\66\3\2\2\2\u00d8"+
		"\u00d9\5i\65\2\u00d9\u00da\5\u0083B\2\u00da\u00db\5o8\2\u00db8\3\2\2\2"+
		"\u00dc\u00dd\5k\66\2\u00dd\u00de\5q9\2\u00de\u00df\5\u008fH\2\u00df\u00e0"+
		"\5\u0095K\2\u00e0\u00e1\5q9\2\u00e1\u00e2\5q9\2\u00e2\u00e3\5\u0083B\2"+
		"\u00e3:\3\2\2\2\u00e4\u00e5\5m\67\2\u00e5\u00e6\5i\65\2\u00e6\u00e7\5"+
		"\u008dG\2\u00e7\u00e8\5q9\2\u00e8<\3\2\2\2\u00e9\u00ea\5q9\2\u00ea\u00eb"+
		"\5\177@\2\u00eb\u00ec\5\u008dG\2\u00ec\u00ed\5q9\2\u00ed>\3\2\2\2\u00ee"+
		"\u00ef\5q9\2\u00ef\u00f0\5\u0083B\2\u00f0\u00f1\5o8\2\u00f1@\3\2\2\2\u00f2"+
		"\u00f3\5s:\2\u00f3\u00f4\5i\65\2\u00f4\u00f5\5\177@\2\u00f5\u00f6\5\u008d"+
		"G\2\u00f6\u00f7\5q9\2\u00f7B\3\2\2\2\u00f8\u00f9\5y=\2\u00f9\u00fa\5\u0083"+
		"B\2\u00faD\3\2\2\2\u00fb\u00fc\5y=\2\u00fc\u00fd\5\u008dG\2\u00fdF\3\2"+
		"\2\2\u00fe\u00ff\5y=\2\u00ff\u0100\5\u008dG\2\u0100\u0101\5\u0083B\2\u0101"+
		"\u0102\5\u0091I\2\u0102\u0103\5\177@\2\u0103\u0104\5\177@\2\u0104H\3\2"+
		"\2\2\u0105\u0106\5\177@\2\u0106\u0107\5y=\2\u0107\u0108\5}?\2\u0108\u0109"+
		"\5q9\2\u0109J\3\2\2\2\u010a\u010b\5\u0083B\2\u010b\u010c\5\u0085C\2\u010c"+
		"\u010d\5\u008fH\2\u010dL\3\2\2\2\u010e\u010f\5\u0083B\2\u010f\u0110\5"+
		"\u0085C\2\u0110\u0111\5\u008fH\2\u0111\u0112\5\u0083B\2\u0112\u0113\5"+
		"\u0091I\2\u0113\u0114\5\177@\2\u0114\u0115\5\177@\2\u0115N\3\2\2\2\u0116"+
		"\u0117\5\u0083B\2\u0117\u0118\5\u0091I\2\u0118\u0119\5\177@\2\u0119\u011a"+
		"\5\177@\2\u011aP\3\2\2\2\u011b\u011c\5\u0085C\2\u011c\u011d\5\u008bF\2"+
		"\u011dR\3\2\2\2\u011e\u011f\5\u008fH\2\u011f\u0120\5w<\2\u0120\u0121\5"+
		"q9\2\u0121\u0122\5\u0083B\2\u0122T\3\2\2\2\u0123\u0124\5\u008fH\2\u0124"+
		"\u0125\5\u008bF\2\u0125\u0126\5\u0091I\2\u0126\u0127\5q9\2\u0127V\3\2"+
		"\2\2\u0128\u0129\5\u0095K\2\u0129\u012a\5w<\2\u012a\u012b\5q9\2\u012b"+
		"\u012c\5\u0083B\2\u012cX\3\2\2\2\u012d\u012f\5g\64\2\u012e\u012d\3\2\2"+
		"\2\u012f\u0130\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0139"+
		"\3\2\2\2\u0132\u0136\7\60\2\2\u0133\u0135\5g\64\2\u0134\u0133\3\2\2\2"+
		"\u0135\u0138\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u013a"+
		"\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u0132\3\2\2\2\u0139\u013a\3\2\2\2\u013a"+
		"\u0142\3\2\2\2\u013b\u013d\7\60\2\2\u013c\u013e\5g\64\2\u013d\u013c\3"+
		"\2\2\2\u013e\u013f\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140"+
		"\u0142\3\2\2\2\u0141\u012e\3\2\2\2\u0141\u013b\3\2\2\2\u0142Z\3\2\2\2"+
		"\u0143\u0149\7)\2\2\u0144\u0148\n\2\2\2\u0145\u0146\7)\2\2\u0146\u0148"+
		"\7)\2\2\u0147\u0144\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u014b\3\2\2\2\u0149"+
		"\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014c\3\2\2\2\u014b\u0149\3\2"+
		"\2\2\u014c\u014d\7)\2\2\u014d\\\3\2\2\2\u014e\u0154\7$\2\2\u014f\u0153"+
		"\n\3\2\2\u0150\u0151\7$\2\2\u0151\u0153\7$\2\2\u0152\u014f\3\2\2\2\u0152"+
		"\u0150\3\2\2\2\u0153\u0156\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2"+
		"\2\2\u0155\u0157\3\2\2\2\u0156\u0154\3\2\2\2\u0157\u016c\7$\2\2\u0158"+
		"\u015e\7b\2\2\u0159\u015d\n\4\2\2\u015a\u015b\7b\2\2\u015b\u015d\7b\2"+
		"\2\u015c\u0159\3\2\2\2\u015c\u015a\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c"+
		"\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0161\3\2\2\2\u0160\u015e\3\2\2\2\u0161"+
		"\u016c\7b\2\2\u0162\u0168\5_\60\2\u0163\u0167\5_\60\2\u0164\u0167\5g\64"+
		"\2\u0165\u0167\t\5\2\2\u0166\u0163\3\2\2\2\u0166\u0164\3\2\2\2\u0166\u0165"+
		"\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169"+
		"\u016c\3\2\2\2\u016a\u0168\3\2\2\2\u016b\u014e\3\2\2\2\u016b\u0158\3\2"+
		"\2\2\u016b\u0162\3\2\2\2\u016c^\3\2\2\2\u016d\u016e\t\6\2\2\u016e`\3\2"+
		"\2\2\u016f\u0170\7/\2\2\u0170\u0171\7/\2\2\u0171\u0175\3\2\2\2\u0172\u0174"+
		"\n\7\2\2\u0173\u0172\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0173\3\2\2\2\u0175"+
		"\u0176\3\2\2\2\u0176\u017d\3\2\2\2\u0177\u0175\3\2\2\2\u0178\u017a\7\17"+
		"\2\2\u0179\u0178\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017b\3\2\2\2\u017b"+
		"\u017e\7\f\2\2\u017c\u017e\7\2\2\3\u017d\u0179\3\2\2\2\u017d\u017c\3\2"+
		"\2\2\u017e\u017f\3\2\2\2\u017f\u0180\b\61\2\2\u0180b\3\2\2\2\u0181\u0182"+
		"\7\61\2\2\u0182\u0183\7,\2\2\u0183\u0187\3\2\2\2\u0184\u0186\13\2\2\2"+
		"\u0185\u0184\3\2\2\2\u0186\u0189\3\2\2\2\u0187\u0188\3\2\2\2\u0187\u0185"+
		"\3\2\2\2\u0188\u018a\3\2\2\2\u0189\u0187\3\2\2\2\u018a\u018b\7,\2\2\u018b"+
		"\u018c\7\61\2\2\u018c\u018d\3\2\2\2\u018d\u018e\b\62\2\2\u018ed\3\2\2"+
		"\2\u018f\u0190\t\b\2\2\u0190\u0191\3\2\2\2\u0191\u0192\b\63\2\2\u0192"+
		"f\3\2\2\2\u0193\u0194\t\t\2\2\u0194h\3\2\2\2\u0195\u0196\t\n\2\2\u0196"+
		"j\3\2\2\2\u0197\u0198\t\13\2\2\u0198l\3\2\2\2\u0199\u019a\t\f\2\2\u019a"+
		"n\3\2\2\2\u019b\u019c\t\r\2\2\u019cp\3\2\2\2\u019d\u019e\t\16\2\2\u019e"+
		"r\3\2\2\2\u019f\u01a0\t\17\2\2\u01a0t\3\2\2\2\u01a1\u01a2\t\20\2\2\u01a2"+
		"v\3\2\2\2\u01a3\u01a4\t\21\2\2\u01a4x\3\2\2\2\u01a5\u01a6\t\22\2\2\u01a6"+
		"z\3\2\2\2\u01a7\u01a8\t\23\2\2\u01a8|\3\2\2\2\u01a9\u01aa\t\24\2\2\u01aa"+
		"~\3\2\2\2\u01ab\u01ac\t\25\2\2\u01ac\u0080\3\2\2\2\u01ad\u01ae\t\26\2"+
		"\2\u01ae\u0082\3\2\2\2\u01af\u01b0\t\27\2\2\u01b0\u0084\3\2\2\2\u01b1"+
		"\u01b2\t\30\2\2\u01b2\u0086\3\2\2\2\u01b3\u01b4\t\31\2\2\u01b4\u0088\3"+
		"\2\2\2\u01b5\u01b6\t\32\2\2\u01b6\u008a\3\2\2\2\u01b7\u01b8\t\33\2\2\u01b8"+
		"\u008c\3\2\2\2\u01b9\u01ba\t\34\2\2\u01ba\u008e\3\2\2\2\u01bb\u01bc\t"+
		"\35\2\2\u01bc\u0090\3\2\2\2\u01bd\u01be\t\36\2\2\u01be\u0092\3\2\2\2\u01bf"+
		"\u01c0\t\37\2\2\u01c0\u0094\3\2\2\2\u01c1\u01c2\t \2\2\u01c2\u0096\3\2"+
		"\2\2\u01c3\u01c4\t!\2\2\u01c4\u0098\3\2\2\2\u01c5\u01c6\t\"\2\2\u01c6"+
		"\u009a\3\2\2\2\u01c7\u01c8\t#\2\2\u01c8\u009c\3\2\2\2\25\2\u0130\u0136"+
		"\u0139\u013f\u0141\u0147\u0149\u0152\u0154\u015c\u015e\u0166\u0168\u016b"+
		"\u0175\u0179\u017d\u0187\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}