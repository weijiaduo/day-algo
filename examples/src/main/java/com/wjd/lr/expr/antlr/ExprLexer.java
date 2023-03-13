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
		NUMERIC_LITERAL=44, STRING_LITERAL=45, IDENTIFIER=46, ID=47, UNICODE_ID=48, 
		SINGLE_LINE_COMMENT=49, MULTILINE_COMMENT=50, SPACES=51;
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
			"IDENTIFIER", "ID", "UNICODE_ID", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", 
			"SPACES", "DIGIT", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
			"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", 
			"Y", "Z"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\65\u01cf\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3"+
		"\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3"+
		"\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3"+
		"\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3$\3$"+
		"\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3"+
		"(\3(\3(\3(\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\6"+
		"-\u0131\n-\r-\16-\u0132\3-\3-\7-\u0137\n-\f-\16-\u013a\13-\5-\u013c\n"+
		"-\3-\3-\6-\u0140\n-\r-\16-\u0141\5-\u0144\n-\3.\3.\3.\3.\7.\u014a\n.\f"+
		".\16.\u014d\13.\3.\3.\3/\3/\3/\3/\7/\u0155\n/\f/\16/\u0158\13/\3/\3/\3"+
		"/\3/\3/\7/\u015f\n/\f/\16/\u0162\13/\3/\3/\3/\5/\u0167\n/\3/\3/\7/\u016b"+
		"\n/\f/\16/\u016e\13/\5/\u0170\n/\3\60\3\60\3\61\3\61\3\62\3\62\3\62\3"+
		"\62\7\62\u017a\n\62\f\62\16\62\u017d\13\62\3\62\5\62\u0180\n\62\3\62\3"+
		"\62\5\62\u0184\n\62\3\62\3\62\3\63\3\63\3\63\3\63\7\63\u018c\n\63\f\63"+
		"\16\63\u018f\13\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\65\3"+
		"\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3"+
		"?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3"+
		"K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3\u018d\2P\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W"+
		"-Y.[/]\60_\61a\62c\63e\64g\65i\2k\2m\2o\2q\2s\2u\2w\2y\2{\2}\2\177\2\u0081"+
		"\2\u0083\2\u0085\2\u0087\2\u0089\2\u008b\2\u008d\2\u008f\2\u0091\2\u0093"+
		"\2\u0095\2\u0097\2\u0099\2\u009b\2\u009d\2\3\2#\3\2))\3\2$$\3\2bb\7\2"+
		"//C\\aac|\u0082\1\4\2\f\f\17\17\5\2\13\r\17\17\"\"\3\2\62;\4\2CCcc\4\2"+
		"DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4"+
		"\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUu"+
		"u\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\3\u02b9\2"+
		"C\2\\\2c\2|\2\u00ac\2\u00ac\2\u00b7\2\u00b7\2\u00bc\2\u00bc\2\u00c2\2"+
		"\u00d8\2\u00da\2\u00f8\2\u00fa\2\u02c3\2\u02c8\2\u02d3\2\u02e2\2\u02e6"+
		"\2\u02ee\2\u02ee\2\u02f0\2\u02f0\2\u0347\2\u0347\2\u0372\2\u0376\2\u0378"+
		"\2\u0379\2\u037c\2\u037f\2\u0381\2\u0381\2\u0388\2\u0388\2\u038a\2\u038c"+
		"\2\u038e\2\u038e\2\u0390\2\u03a3\2\u03a5\2\u03f7\2\u03f9\2\u0483\2\u048c"+
		"\2\u0531\2\u0533\2\u0558\2\u055b\2\u055b\2\u0562\2\u058a\2\u05b2\2\u05bf"+
		"\2\u05c1\2\u05c1\2\u05c3\2\u05c4\2\u05c6\2\u05c7\2\u05c9\2\u05c9\2\u05d2"+
		"\2\u05ec\2\u05f1\2\u05f4\2\u0612\2\u061c\2\u0622\2\u0659\2\u065b\2\u0661"+
		"\2\u0670\2\u06d5\2\u06d7\2\u06de\2\u06e3\2\u06ea\2\u06ef\2\u06f1\2\u06fc"+
		"\2\u06fe\2\u0701\2\u0701\2\u0712\2\u0741\2\u074f\2\u07b3\2\u07cc\2\u07ec"+
		"\2\u07f6\2\u07f7\2\u07fc\2\u07fc\2\u0802\2\u0819\2\u081c\2\u082e\2\u0842"+
		"\2\u085a\2\u0862\2\u086c\2\u08a2\2\u08b6\2\u08b8\2\u08c9\2\u08d6\2\u08e1"+
		"\2\u08e5\2\u08eb\2\u08f2\2\u093d\2\u093f\2\u094e\2\u0950\2\u0952\2\u0957"+
		"\2\u0965\2\u0973\2\u0985\2\u0987\2\u098e\2\u0991\2\u0992\2\u0995\2\u09aa"+
		"\2\u09ac\2\u09b2\2\u09b4\2\u09b4\2\u09b8\2\u09bb\2\u09bf\2\u09c6\2\u09c9"+
		"\2\u09ca\2\u09cd\2\u09ce\2\u09d0\2\u09d0\2\u09d9\2\u09d9\2\u09de\2\u09df"+
		"\2\u09e1\2\u09e5\2\u09f2\2\u09f3\2\u09fe\2\u09fe\2\u0a03\2\u0a05\2\u0a07"+
		"\2\u0a0c\2\u0a11\2\u0a12\2\u0a15\2\u0a2a\2\u0a2c\2\u0a32\2\u0a34\2\u0a35"+
		"\2\u0a37\2\u0a38\2\u0a3a\2\u0a3b\2\u0a40\2\u0a44\2\u0a49\2\u0a4a\2\u0a4d"+
		"\2\u0a4e\2\u0a53\2\u0a53\2\u0a5b\2\u0a5e\2\u0a60\2\u0a60\2\u0a72\2\u0a77"+
		"\2\u0a83\2\u0a85\2\u0a87\2\u0a8f\2\u0a91\2\u0a93\2\u0a95\2\u0aaa\2\u0aac"+
		"\2\u0ab2\2\u0ab4\2\u0ab5\2\u0ab7\2\u0abb\2\u0abf\2\u0ac7\2\u0ac9\2\u0acb"+
		"\2\u0acd\2\u0ace\2\u0ad2\2\u0ad2\2\u0ae2\2\u0ae5\2\u0afb\2\u0afe\2\u0b03"+
		"\2\u0b05\2\u0b07\2\u0b0e\2\u0b11\2\u0b12\2\u0b15\2\u0b2a\2\u0b2c\2\u0b32"+
		"\2\u0b34\2\u0b35\2\u0b37\2\u0b3b\2\u0b3f\2\u0b46\2\u0b49\2\u0b4a\2\u0b4d"+
		"\2\u0b4e\2\u0b58\2\u0b59\2\u0b5e\2\u0b5f\2\u0b61\2\u0b65\2\u0b73\2\u0b73"+
		"\2\u0b84\2\u0b85\2\u0b87\2\u0b8c\2\u0b90\2\u0b92\2\u0b94\2\u0b97\2\u0b9b"+
		"\2\u0b9c\2\u0b9e\2\u0b9e\2\u0ba0\2\u0ba1\2\u0ba5\2\u0ba6\2\u0baa\2\u0bac"+
		"\2\u0bb0\2\u0bbb\2\u0bc0\2\u0bc4\2\u0bc8\2\u0bca\2\u0bcc\2\u0bce\2\u0bd2"+
		"\2\u0bd2\2\u0bd9\2\u0bd9\2\u0c02\2\u0c05\2\u0c07\2\u0c0e\2\u0c10\2\u0c12"+
		"\2\u0c14\2\u0c2a\2\u0c2c\2\u0c3b\2\u0c3f\2\u0c46\2\u0c48\2\u0c4a\2\u0c4c"+
		"\2\u0c4e\2\u0c57\2\u0c58\2\u0c5a\2\u0c5c\2\u0c62\2\u0c65\2\u0c82\2\u0c85"+
		"\2\u0c87\2\u0c8e\2\u0c90\2\u0c92\2\u0c94\2\u0caa\2\u0cac\2\u0cb5\2\u0cb7"+
		"\2\u0cbb\2\u0cbf\2\u0cc6\2\u0cc8\2\u0cca\2\u0ccc\2\u0cce\2\u0cd7\2\u0cd8"+
		"\2\u0ce0\2\u0ce0\2\u0ce2\2\u0ce5\2\u0cf3\2\u0cf4\2\u0d02\2\u0d0e\2\u0d10"+
		"\2\u0d12\2\u0d14\2\u0d3c\2\u0d3f\2\u0d46\2\u0d48\2\u0d4a\2\u0d4c\2\u0d4e"+
		"\2\u0d50\2\u0d50\2\u0d56\2\u0d59\2\u0d61\2\u0d65\2\u0d7c\2\u0d81\2\u0d83"+
		"\2\u0d85\2\u0d87\2\u0d98\2\u0d9c\2\u0db3\2\u0db5\2\u0dbd\2\u0dbf\2\u0dbf"+
		"\2\u0dc2\2\u0dc8\2\u0dd1\2\u0dd6\2\u0dd8\2\u0dd8\2\u0dda\2\u0de1\2\u0df4"+
		"\2\u0df5\2\u0e03\2\u0e3c\2\u0e42\2\u0e48\2\u0e4f\2\u0e4f\2\u0e83\2\u0e84"+
		"\2\u0e86\2\u0e86\2\u0e88\2\u0e8c\2\u0e8e\2\u0ea5\2\u0ea7\2\u0ea7\2\u0ea9"+
		"\2\u0ebb\2\u0ebd\2\u0ebf\2\u0ec2\2\u0ec6\2\u0ec8\2\u0ec8\2\u0ecf\2\u0ecf"+
		"\2\u0ede\2\u0ee1\2\u0f02\2\u0f02\2\u0f42\2\u0f49\2\u0f4b\2\u0f6e\2\u0f73"+
		"\2\u0f83\2\u0f8a\2\u0f99\2\u0f9b\2\u0fbe\2\u1002\2\u1038\2\u103a\2\u103a"+
		"\2\u103d\2\u1041\2\u1052\2\u1091\2\u109c\2\u109f\2\u10a2\2\u10c7\2\u10c9"+
		"\2\u10c9\2\u10cf\2\u10cf\2\u10d2\2\u10fc\2\u10fe\2\u124a\2\u124c\2\u124f"+
		"\2\u1252\2\u1258\2\u125a\2\u125a\2\u125c\2\u125f\2\u1262\2\u128a\2\u128c"+
		"\2\u128f\2\u1292\2\u12b2\2\u12b4\2\u12b7\2\u12ba\2\u12c0\2\u12c2\2\u12c2"+
		"\2\u12c4\2\u12c7\2\u12ca\2\u12d8\2\u12da\2\u1312\2\u1314\2\u1317\2\u131a"+
		"\2\u135c\2\u1382\2\u1391\2\u13a2\2\u13f7\2\u13fa\2\u13ff\2\u1403\2\u166e"+
		"\2\u1671\2\u1681\2\u1683\2\u169c\2\u16a2\2\u16ec\2\u16f0\2\u16fa\2\u1702"+
		"\2\u170e\2\u1710\2\u1715\2\u1722\2\u1735\2\u1742\2\u1755\2\u1762\2\u176e"+
		"\2\u1770\2\u1772\2\u1774\2\u1775\2\u1782\2\u17b5\2\u17b8\2\u17ca\2\u17d9"+
		"\2\u17d9\2\u17de\2\u17de\2\u1822\2\u187a\2\u1882\2\u18ac\2\u18b2\2\u18f7"+
		"\2\u1902\2\u1920\2\u1922\2\u192d\2\u1932\2\u193a\2\u1952\2\u196f\2\u1972"+
		"\2\u1976\2\u1982\2\u19ad\2\u19b2\2\u19cb\2\u1a02\2\u1a1d\2\u1a22\2\u1a60"+
		"\2\u1a63\2\u1a76\2\u1aa9\2\u1aa9\2\u1ac1\2\u1ac2\2\u1b02\2\u1b35\2\u1b37"+
		"\2\u1b45\2\u1b47\2\u1b4d\2\u1b82\2\u1bab\2\u1bae\2\u1bb1\2\u1bbc\2\u1be7"+
		"\2\u1be9\2\u1bf3\2\u1c02\2\u1c38\2\u1c4f\2\u1c51\2\u1c5c\2\u1c7f\2\u1c82"+
		"\2\u1c8a\2\u1c92\2\u1cbc\2\u1cbf\2\u1cc1\2\u1ceb\2\u1cee\2\u1cf0\2\u1cf5"+
		"\2\u1cf7\2\u1cf8\2\u1cfc\2\u1cfc\2\u1d02\2\u1dc1\2\u1de9\2\u1df6\2\u1e02"+
		"\2\u1f17\2\u1f1a\2\u1f1f\2\u1f22\2\u1f47\2\u1f4a\2\u1f4f\2\u1f52\2\u1f59"+
		"\2\u1f5b\2\u1f5b\2\u1f5d\2\u1f5d\2\u1f5f\2\u1f5f\2\u1f61\2\u1f7f\2\u1f82"+
		"\2\u1fb6\2\u1fb8\2\u1fbe\2\u1fc0\2\u1fc0\2\u1fc4\2\u1fc6\2\u1fc8\2\u1fce"+
		"\2\u1fd2\2\u1fd5\2\u1fd8\2\u1fdd\2\u1fe2\2\u1fee\2\u1ff4\2\u1ff6\2\u1ff8"+
		"\2\u1ffe\2\u2073\2\u2073\2\u2081\2\u2081\2\u2092\2\u209e\2\u2104\2\u2104"+
		"\2\u2109\2\u2109\2\u210c\2\u2115\2\u2117\2\u2117\2\u211b\2\u211f\2\u2126"+
		"\2\u2126\2\u2128\2\u2128\2\u212a\2\u212a\2\u212c\2\u212f\2\u2131\2\u213b"+
		"\2\u213e\2\u2141\2\u2147\2\u214b\2\u2150\2\u2150\2\u2162\2\u218a\2\u24b8"+
		"\2\u24eb\2\u2c02\2\u2c30\2\u2c32\2\u2c60\2\u2c62\2\u2ce6\2\u2ced\2\u2cf0"+
		"\2\u2cf4\2\u2cf5\2\u2d02\2\u2d27\2\u2d29\2\u2d29\2\u2d2f\2\u2d2f\2\u2d32"+
		"\2\u2d69\2\u2d71\2\u2d71\2\u2d82\2\u2d98\2\u2da2\2\u2da8\2\u2daa\2\u2db0"+
		"\2\u2db2\2\u2db8\2\u2dba\2\u2dc0\2\u2dc2\2\u2dc8\2\u2dca\2\u2dd0\2\u2dd2"+
		"\2\u2dd8\2\u2dda\2\u2de0\2\u2de2\2\u2e01\2\u2e31\2\u2e31\2\u3007\2\u3009"+
		"\2\u3023\2\u302b\2\u3033\2\u3037\2\u303a\2\u303e\2\u3043\2\u3098\2\u309f"+
		"\2\u30a1\2\u30a3\2\u30fc\2\u30fe\2\u3101\2\u3107\2\u3131\2\u3133\2\u3190"+
		"\2\u31a2\2\u31c1\2\u31f2\2\u3201\2\u3402\2\u4dc1\2\u4e02\2\u9ffe\2\ua002"+
		"\2\ua48e\2\ua4d2\2\ua4ff\2\ua502\2\ua60e\2\ua612\2\ua621\2\ua62c\2\ua62d"+
		"\2\ua642\2\ua670\2\ua676\2\ua67d\2\ua681\2\ua6f1\2\ua719\2\ua721\2\ua724"+
		"\2\ua78a\2\ua78d\2\ua7c1\2\ua7c4\2\ua7cc\2\ua7f7\2\ua807\2\ua809\2\ua829"+
		"\2\ua842\2\ua875\2\ua882\2\ua8c5\2\ua8c7\2\ua8c7\2\ua8f4\2\ua8f9\2\ua8fd"+
		"\2\ua8fd\2\ua8ff\2\ua901\2\ua90c\2\ua92c\2\ua932\2\ua954\2\ua962\2\ua97e"+
		"\2\ua982\2\ua9b4\2\ua9b6\2\ua9c1\2\ua9d1\2\ua9d1\2\ua9e2\2\ua9f1\2\ua9fc"+
		"\2\uaa00\2\uaa02\2\uaa38\2\uaa42\2\uaa4f\2\uaa62\2\uaa78\2\uaa7c\2\uaac0"+
		"\2\uaac2\2\uaac2\2\uaac4\2\uaac4\2\uaadd\2\uaadf\2\uaae2\2\uaaf1\2\uaaf4"+
		"\2\uaaf7\2\uab03\2\uab08\2\uab0b\2\uab10\2\uab13\2\uab18\2\uab22\2\uab28"+
		"\2\uab2a\2\uab30\2\uab32\2\uab5c\2\uab5e\2\uab6b\2\uab72\2\uabec\2\uac02"+
		"\2\ud7a5\2\ud7b2\2\ud7c8\2\ud7cd\2\ud7fd\2\uf902\2\ufa6f\2\ufa72\2\ufadb"+
		"\2\ufb02\2\ufb08\2\ufb15\2\ufb19\2\ufb1f\2\ufb2a\2\ufb2c\2\ufb38\2\ufb3a"+
		"\2\ufb3e\2\ufb40\2\ufb40\2\ufb42\2\ufb43\2\ufb45\2\ufb46\2\ufb48\2\ufbb3"+
		"\2\ufbd5\2\ufd3f\2\ufd52\2\ufd91\2\ufd94\2\ufdc9\2\ufdf2\2\ufdfd\2\ufe72"+
		"\2\ufe76\2\ufe78\2\ufefe\2\uff23\2\uff3c\2\uff43\2\uff5c\2\uff68\2\uffc0"+
		"\2\uffc4\2\uffc9\2\uffcc\2\uffd1\2\uffd4\2\uffd9\2\uffdc\2\uffde\2\2\3"+
		"\r\3\17\3(\3*\3<\3>\3?\3A\3O\3R\3_\3\u0082\3\u00fc\3\u0142\3\u0176\3\u0282"+
		"\3\u029e\3\u02a2\3\u02d2\3\u0302\3\u0321\3\u032f\3\u034c\3\u0352\3\u037c"+
		"\3\u0382\3\u039f\3\u03a2\3\u03c5\3\u03ca\3\u03d1\3\u03d3\3\u03d7\3\u0402"+
		"\3\u049f\3\u04b2\3\u04d5\3\u04da\3\u04fd\3\u0502\3\u0529\3\u0532\3\u0565"+
		"\3\u0602\3\u0738\3\u0742\3\u0757\3\u0762\3\u0769\3\u0802\3\u0807\3\u080a"+
		"\3\u080a\3\u080c\3\u0837\3\u0839\3\u083a\3\u083e\3\u083e\3\u0841\3\u0857"+
		"\3\u0862\3\u0878\3\u0882\3\u08a0\3\u08e2\3\u08f4\3\u08f6\3\u08f7\3\u0902"+
		"\3\u0917\3\u0922\3\u093b\3\u0982\3\u09b9\3\u09c0\3\u09c1\3\u0a02\3\u0a05"+
		"\3\u0a07\3\u0a08\3\u0a0e\3\u0a15\3\u0a17\3\u0a19\3\u0a1b\3\u0a37\3\u0a62"+
		"\3\u0a7e\3\u0a82\3\u0a9e\3\u0ac2\3\u0ac9\3\u0acb\3\u0ae6\3\u0b02\3\u0b37"+
		"\3\u0b42\3\u0b57\3\u0b62\3\u0b74\3\u0b82\3\u0b93\3\u0c02\3\u0c4a\3\u0c82"+
		"\3\u0cb4\3\u0cc2\3\u0cf4\3\u0d02\3\u0d29\3\u0e82\3\u0eab\3\u0ead\3\u0eae"+
		"\3\u0eb2\3\u0eb3\3\u0f02\3\u0f1e\3\u0f29\3\u0f29\3\u0f32\3\u0f47\3\u0fb2"+
		"\3\u0fc6\3\u0fe2\3\u0ff8\3\u1002\3\u1047\3\u1084\3\u10ba\3\u10d2\3\u10ea"+
		"\3\u1102\3\u1134\3\u1146\3\u1149\3\u1152\3\u1174\3\u1178\3\u1178\3\u1182"+
		"\3\u11c1\3\u11c3\3\u11c6\3\u11d0\3\u11d1\3\u11dc\3\u11dc\3\u11de\3\u11de"+
		"\3\u1202\3\u1213\3\u1215\3\u1236\3\u1239\3\u1239\3\u1240\3\u1240\3\u1282"+
		"\3\u1288\3\u128a\3\u128a\3\u128c\3\u128f\3\u1291\3\u129f\3\u12a1\3\u12aa"+
		"\3\u12b2\3\u12ea\3\u1302\3\u1305\3\u1307\3\u130e\3\u1311\3\u1312\3\u1315"+
		"\3\u132a\3\u132c\3\u1332\3\u1334\3\u1335\3\u1337\3\u133b\3\u133f\3\u1346"+
		"\3\u1349\3\u134a\3\u134d\3\u134e\3\u1352\3\u1352\3\u1359\3\u1359\3\u135f"+
		"\3\u1365\3\u1402\3\u1443\3\u1445\3\u1447\3\u1449\3\u144c\3\u1461\3\u1463"+
		"\3\u1482\3\u14c3\3\u14c6\3\u14c7\3\u14c9\3\u14c9\3\u1582\3\u15b7\3\u15ba"+
		"\3\u15c0\3\u15da\3\u15df\3\u1602\3\u1640\3\u1642\3\u1642\3\u1646\3\u1646"+
		"\3\u1682\3\u16b7\3\u16ba\3\u16ba\3\u1702\3\u171c\3\u171f\3\u172c\3\u1802"+
		"\3\u183a\3\u18a2\3\u18e1\3\u1901\3\u1908\3\u190b\3\u190b\3\u190e\3\u1915"+
		"\3\u1917\3\u1918\3\u191a\3\u1937\3\u1939\3\u193a\3\u193d\3\u193e\3\u1941"+
		"\3\u1944\3\u19a2\3\u19a9\3\u19ac\3\u19d9\3\u19dc\3\u19e1\3\u19e3\3\u19e3"+
		"\3\u19e5\3\u19e6\3\u1a02\3\u1a34\3\u1a37\3\u1a40\3\u1a52\3\u1a99\3\u1a9f"+
		"\3\u1a9f\3\u1ac2\3\u1afa\3\u1c02\3\u1c0a\3\u1c0c\3\u1c38\3\u1c3a\3\u1c40"+
		"\3\u1c42\3\u1c42\3\u1c74\3\u1c91\3\u1c94\3\u1ca9\3\u1cab\3\u1cb8\3\u1d02"+
		"\3\u1d08\3\u1d0a\3\u1d0b\3\u1d0d\3\u1d38\3\u1d3c\3\u1d3c\3\u1d3e\3\u1d3f"+
		"\3\u1d41\3\u1d43\3\u1d45\3\u1d45\3\u1d48\3\u1d49\3\u1d62\3\u1d67\3\u1d69"+
		"\3\u1d6a\3\u1d6c\3\u1d90\3\u1d92\3\u1d93\3\u1d95\3\u1d98\3\u1d9a\3\u1d9a"+
		"\3\u1ee2\3\u1ef8\3\u1fb2\3\u1fb2\3\u2002\3\u239b\3\u2402\3\u2470\3\u2482"+
		"\3\u2545\3\u3002\3\u3430\3\u4402\3\u4648\3\u6802\3\u6a3a\3\u6a42\3\u6a60"+
		"\3\u6ad2\3\u6aef\3\u6b02\3\u6b31\3\u6b42\3\u6b45\3\u6b65\3\u6b79\3\u6b7f"+
		"\3\u6b91\3\u6e42\3\u6e81\3\u6f02\3\u6f4c\3\u6f51\3\u6f89\3\u6f91\3\u6fa1"+
		"\3\u6fe2\3\u6fe3\3\u6fe5\3\u6fe5\3\u6ff2\3\u6ff3\3\u7002\3\u87f9\3\u8802"+
		"\3\u8cd7\3\u8d02\3\u8d0a\3\ub002\3\ub120\3\ub152\3\ub154\3\ub166\3\ub169"+
		"\3\ub172\3\ub2fd\3\ubc02\3\ubc6c\3\ubc72\3\ubc7e\3\ubc82\3\ubc8a\3\ubc92"+
		"\3\ubc9b\3\ubca0\3\ubca0\3\ud402\3\ud456\3\ud458\3\ud49e\3\ud4a0\3\ud4a1"+
		"\3\ud4a4\3\ud4a4\3\ud4a7\3\ud4a8\3\ud4ab\3\ud4ae\3\ud4b0\3\ud4bb\3\ud4bd"+
		"\3\ud4bd\3\ud4bf\3\ud4c5\3\ud4c7\3\ud507\3\ud509\3\ud50c\3\ud50f\3\ud516"+
		"\3\ud518\3\ud51e\3\ud520\3\ud53b\3\ud53d\3\ud540\3\ud542\3\ud546\3\ud548"+
		"\3\ud548\3\ud54c\3\ud552\3\ud554\3\ud6a7\3\ud6aa\3\ud6c2\3\ud6c4\3\ud6dc"+
		"\3\ud6de\3\ud6fc\3\ud6fe\3\ud716\3\ud718\3\ud736\3\ud738\3\ud750\3\ud752"+
		"\3\ud770\3\ud772\3\ud78a\3\ud78c\3\ud7aa\3\ud7ac\3\ud7c4\3\ud7c6\3\ud7cd"+
		"\3\ue002\3\ue008\3\ue00a\3\ue01a\3\ue01d\3\ue023\3\ue025\3\ue026\3\ue028"+
		"\3\ue02c\3\ue102\3\ue12e\3\ue139\3\ue13f\3\ue150\3\ue150\3\ue2c2\3\ue2ed"+
		"\3\ue802\3\ue8c6\3\ue902\3\ue945\3\ue949\3\ue949\3\ue94d\3\ue94d\3\uee02"+
		"\3\uee05\3\uee07\3\uee21\3\uee23\3\uee24\3\uee26\3\uee26\3\uee29\3\uee29"+
		"\3\uee2b\3\uee34\3\uee36\3\uee39\3\uee3b\3\uee3b\3\uee3d\3\uee3d\3\uee44"+
		"\3\uee44\3\uee49\3\uee49\3\uee4b\3\uee4b\3\uee4d\3\uee4d\3\uee4f\3\uee51"+
		"\3\uee53\3\uee54\3\uee56\3\uee56\3\uee59\3\uee59\3\uee5b\3\uee5b\3\uee5d"+
		"\3\uee5d\3\uee5f\3\uee5f\3\uee61\3\uee61\3\uee63\3\uee64\3\uee66\3\uee66"+
		"\3\uee69\3\uee6c\3\uee6e\3\uee74\3\uee76\3\uee79\3\uee7b\3\uee7e\3\uee80"+
		"\3\uee80\3\uee82\3\uee8b\3\uee8d\3\uee9d\3\ueea3\3\ueea5\3\ueea7\3\ueeab"+
		"\3\ueead\3\ueebd\3\uf132\3\uf14b\3\uf152\3\uf16b\3\uf172\3\uf18b\3\2\4"+
		"\ua6df\4\ua702\4\ub736\4\ub742\4\ub81f\4\ub822\4\ucea3\4\uceb2\4\uebe2"+
		"\4\uf802\4\ufa1f\4\2\5\u134c\5\u01c7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2"+
		"\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2["+
		"\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2"+
		"\2\2\3\u009f\3\2\2\2\5\u00a2\3\2\2\2\7\u00a4\3\2\2\2\t\u00a6\3\2\2\2\13"+
		"\u00a8\3\2\2\2\r\u00aa\3\2\2\2\17\u00ac\3\2\2\2\21\u00ae\3\2\2\2\23\u00b0"+
		"\3\2\2\2\25\u00b2\3\2\2\2\27\u00b4\3\2\2\2\31\u00b6\3\2\2\2\33\u00b8\3"+
		"\2\2\2\35\u00ba\3\2\2\2\37\u00bc\3\2\2\2!\u00be\3\2\2\2#\u00c0\3\2\2\2"+
		"%\u00c3\3\2\2\2\'\u00c5\3\2\2\2)\u00c7\3\2\2\2+\u00c9\3\2\2\2-\u00cc\3"+
		"\2\2\2/\u00ce\3\2\2\2\61\u00d1\3\2\2\2\63\u00d4\3\2\2\2\65\u00d7\3\2\2"+
		"\2\67\u00da\3\2\2\29\u00de\3\2\2\2;\u00e6\3\2\2\2=\u00eb\3\2\2\2?\u00f0"+
		"\3\2\2\2A\u00f4\3\2\2\2C\u00fa\3\2\2\2E\u00fd\3\2\2\2G\u0100\3\2\2\2I"+
		"\u0107\3\2\2\2K\u010c\3\2\2\2M\u0110\3\2\2\2O\u0118\3\2\2\2Q\u011d\3\2"+
		"\2\2S\u0120\3\2\2\2U\u0125\3\2\2\2W\u012a\3\2\2\2Y\u0143\3\2\2\2[\u0145"+
		"\3\2\2\2]\u016f\3\2\2\2_\u0171\3\2\2\2a\u0173\3\2\2\2c\u0175\3\2\2\2e"+
		"\u0187\3\2\2\2g\u0195\3\2\2\2i\u0199\3\2\2\2k\u019b\3\2\2\2m\u019d\3\2"+
		"\2\2o\u019f\3\2\2\2q\u01a1\3\2\2\2s\u01a3\3\2\2\2u\u01a5\3\2\2\2w\u01a7"+
		"\3\2\2\2y\u01a9\3\2\2\2{\u01ab\3\2\2\2}\u01ad\3\2\2\2\177\u01af\3\2\2"+
		"\2\u0081\u01b1\3\2\2\2\u0083\u01b3\3\2\2\2\u0085\u01b5\3\2\2\2\u0087\u01b7"+
		"\3\2\2\2\u0089\u01b9\3\2\2\2\u008b\u01bb\3\2\2\2\u008d\u01bd\3\2\2\2\u008f"+
		"\u01bf\3\2\2\2\u0091\u01c1\3\2\2\2\u0093\u01c3\3\2\2\2\u0095\u01c5\3\2"+
		"\2\2\u0097\u01c7\3\2\2\2\u0099\u01c9\3\2\2\2\u009b\u01cb\3\2\2\2\u009d"+
		"\u01cd\3\2\2\2\u009f\u00a0\7&\2\2\u00a0\u00a1\7}\2\2\u00a1\4\3\2\2\2\u00a2"+
		"\u00a3\7\60\2\2\u00a3\6\3\2\2\2\u00a4\u00a5\7]\2\2\u00a5\b\3\2\2\2\u00a6"+
		"\u00a7\7_\2\2\u00a7\n\3\2\2\2\u00a8\u00a9\7*\2\2\u00a9\f\3\2\2\2\u00aa"+
		"\u00ab\7+\2\2\u00ab\16\3\2\2\2\u00ac\u00ad\7}\2\2\u00ad\20\3\2\2\2\u00ae"+
		"\u00af\7\177\2\2\u00af\22\3\2\2\2\u00b0\u00b1\7%\2\2\u00b1\24\3\2\2\2"+
		"\u00b2\u00b3\7B\2\2\u00b3\26\3\2\2\2\u00b4\u00b5\7.\2\2\u00b5\30\3\2\2"+
		"\2\u00b6\u00b7\7?\2\2\u00b7\32\3\2\2\2\u00b8\u00b9\7,\2\2\u00b9\34\3\2"+
		"\2\2\u00ba\u00bb\7-\2\2\u00bb\36\3\2\2\2\u00bc\u00bd\7/\2\2\u00bd \3\2"+
		"\2\2\u00be\u00bf\7\u0080\2\2\u00bf\"\3\2\2\2\u00c0\u00c1\7~\2\2\u00c1"+
		"\u00c2\7~\2\2\u00c2$\3\2\2\2\u00c3\u00c4\7\61\2\2\u00c4&\3\2\2\2\u00c5"+
		"\u00c6\7\'\2\2\u00c6(\3\2\2\2\u00c7\u00c8\7>\2\2\u00c8*\3\2\2\2\u00c9"+
		"\u00ca\7>\2\2\u00ca\u00cb\7?\2\2\u00cb,\3\2\2\2\u00cc\u00cd\7@\2\2\u00cd"+
		".\3\2\2\2\u00ce\u00cf\7@\2\2\u00cf\u00d0\7?\2\2\u00d0\60\3\2\2\2\u00d1"+
		"\u00d2\7?\2\2\u00d2\u00d3\7?\2\2\u00d3\62\3\2\2\2\u00d4\u00d5\7#\2\2\u00d5"+
		"\u00d6\7?\2\2\u00d6\64\3\2\2\2\u00d7\u00d8\7>\2\2\u00d8\u00d9\7@\2\2\u00d9"+
		"\66\3\2\2\2\u00da\u00db\5k\66\2\u00db\u00dc\5\u0085C\2\u00dc\u00dd\5q"+
		"9\2\u00dd8\3\2\2\2\u00de\u00df\5m\67\2\u00df\u00e0\5s:\2\u00e0\u00e1\5"+
		"\u0091I\2\u00e1\u00e2\5\u0097L\2\u00e2\u00e3\5s:\2\u00e3\u00e4\5s:\2\u00e4"+
		"\u00e5\5\u0085C\2\u00e5:\3\2\2\2\u00e6\u00e7\5o8\2\u00e7\u00e8\5k\66\2"+
		"\u00e8\u00e9\5\u008fH\2\u00e9\u00ea\5s:\2\u00ea<\3\2\2\2\u00eb\u00ec\5"+
		"s:\2\u00ec\u00ed\5\u0081A\2\u00ed\u00ee\5\u008fH\2\u00ee\u00ef\5s:\2\u00ef"+
		">\3\2\2\2\u00f0\u00f1\5s:\2\u00f1\u00f2\5\u0085C\2\u00f2\u00f3\5q9\2\u00f3"+
		"@\3\2\2\2\u00f4\u00f5\5u;\2\u00f5\u00f6\5k\66\2\u00f6\u00f7\5\u0081A\2"+
		"\u00f7\u00f8\5\u008fH\2\u00f8\u00f9\5s:\2\u00f9B\3\2\2\2\u00fa\u00fb\5"+
		"{>\2\u00fb\u00fc\5\u0085C\2\u00fcD\3\2\2\2\u00fd\u00fe\5{>\2\u00fe\u00ff"+
		"\5\u008fH\2\u00ffF\3\2\2\2\u0100\u0101\5{>\2\u0101\u0102\5\u008fH\2\u0102"+
		"\u0103\5\u0085C\2\u0103\u0104\5\u0093J\2\u0104\u0105\5\u0081A\2\u0105"+
		"\u0106\5\u0081A\2\u0106H\3\2\2\2\u0107\u0108\5\u0081A\2\u0108\u0109\5"+
		"{>\2\u0109\u010a\5\177@\2\u010a\u010b\5s:\2\u010bJ\3\2\2\2\u010c\u010d"+
		"\5\u0085C\2\u010d\u010e\5\u0087D\2\u010e\u010f\5\u0091I\2\u010fL\3\2\2"+
		"\2\u0110\u0111\5\u0085C\2\u0111\u0112\5\u0087D\2\u0112\u0113\5\u0091I"+
		"\2\u0113\u0114\5\u0085C\2\u0114\u0115\5\u0093J\2\u0115\u0116\5\u0081A"+
		"\2\u0116\u0117\5\u0081A\2\u0117N\3\2\2\2\u0118\u0119\5\u0085C\2\u0119"+
		"\u011a\5\u0093J\2\u011a\u011b\5\u0081A\2\u011b\u011c\5\u0081A\2\u011c"+
		"P\3\2\2\2\u011d\u011e\5\u0087D\2\u011e\u011f\5\u008dG\2\u011fR\3\2\2\2"+
		"\u0120\u0121\5\u0091I\2\u0121\u0122\5y=\2\u0122\u0123\5s:\2\u0123\u0124"+
		"\5\u0085C\2\u0124T\3\2\2\2\u0125\u0126\5\u0091I\2\u0126\u0127\5\u008d"+
		"G\2\u0127\u0128\5\u0093J\2\u0128\u0129\5s:\2\u0129V\3\2\2\2\u012a\u012b"+
		"\5\u0097L\2\u012b\u012c\5y=\2\u012c\u012d\5s:\2\u012d\u012e\5\u0085C\2"+
		"\u012eX\3\2\2\2\u012f\u0131\5i\65\2\u0130\u012f\3\2\2\2\u0131\u0132\3"+
		"\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u013b\3\2\2\2\u0134"+
		"\u0138\7\60\2\2\u0135\u0137\5i\65\2\u0136\u0135\3\2\2\2\u0137\u013a\3"+
		"\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013c\3\2\2\2\u013a"+
		"\u0138\3\2\2\2\u013b\u0134\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u0144\3\2"+
		"\2\2\u013d\u013f\7\60\2\2\u013e\u0140\5i\65\2\u013f\u013e\3\2\2\2\u0140"+
		"\u0141\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0144\3\2"+
		"\2\2\u0143\u0130\3\2\2\2\u0143\u013d\3\2\2\2\u0144Z\3\2\2\2\u0145\u014b"+
		"\7)\2\2\u0146\u014a\n\2\2\2\u0147\u0148\7)\2\2\u0148\u014a\7)\2\2\u0149"+
		"\u0146\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149\3\2"+
		"\2\2\u014b\u014c\3\2\2\2\u014c\u014e\3\2\2\2\u014d\u014b\3\2\2\2\u014e"+
		"\u014f\7)\2\2\u014f\\\3\2\2\2\u0150\u0156\7$\2\2\u0151\u0155\n\3\2\2\u0152"+
		"\u0153\7$\2\2\u0153\u0155\7$\2\2\u0154\u0151\3\2\2\2\u0154\u0152\3\2\2"+
		"\2\u0155\u0158\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0159"+
		"\3\2\2\2\u0158\u0156\3\2\2\2\u0159\u0170\7$\2\2\u015a\u0160\7b\2\2\u015b"+
		"\u015f\n\4\2\2\u015c\u015d\7b\2\2\u015d\u015f\7b\2\2\u015e\u015b\3\2\2"+
		"\2\u015e\u015c\3\2\2\2\u015f\u0162\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161"+
		"\3\2\2\2\u0161\u0163\3\2\2\2\u0162\u0160\3\2\2\2\u0163\u0170\7b\2\2\u0164"+
		"\u0167\5_\60\2\u0165\u0167\5a\61\2\u0166\u0164\3\2\2\2\u0166\u0165\3\2"+
		"\2\2\u0167\u016c\3\2\2\2\u0168\u016b\5_\60\2\u0169\u016b\5a\61\2\u016a"+
		"\u0168\3\2\2\2\u016a\u0169\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2"+
		"\2\2\u016c\u016d\3\2\2\2\u016d\u0170\3\2\2\2\u016e\u016c\3\2\2\2\u016f"+
		"\u0150\3\2\2\2\u016f\u015a\3\2\2\2\u016f\u0166\3\2\2\2\u0170^\3\2\2\2"+
		"\u0171\u0172\t\5\2\2\u0172`\3\2\2\2\u0173\u0174\t#\2\2\u0174b\3\2\2\2"+
		"\u0175\u0176\7/\2\2\u0176\u0177\7/\2\2\u0177\u017b\3\2\2\2\u0178\u017a"+
		"\n\6\2\2\u0179\u0178\3\2\2\2\u017a\u017d\3\2\2\2\u017b\u0179\3\2\2\2\u017b"+
		"\u017c\3\2\2\2\u017c\u0183\3\2\2\2\u017d\u017b\3\2\2\2\u017e\u0180\7\17"+
		"\2\2\u017f\u017e\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0181\3\2\2\2\u0181"+
		"\u0184\7\f\2\2\u0182\u0184\7\2\2\3\u0183\u017f\3\2\2\2\u0183\u0182\3\2"+
		"\2\2\u0184\u0185\3\2\2\2\u0185\u0186\b\62\2\2\u0186d\3\2\2\2\u0187\u0188"+
		"\7\61\2\2\u0188\u0189\7,\2\2\u0189\u018d\3\2\2\2\u018a\u018c\13\2\2\2"+
		"\u018b\u018a\3\2\2\2\u018c\u018f\3\2\2\2\u018d\u018e\3\2\2\2\u018d\u018b"+
		"\3\2\2\2\u018e\u0190\3\2\2\2\u018f\u018d\3\2\2\2\u0190\u0191\7,\2\2\u0191"+
		"\u0192\7\61\2\2\u0192\u0193\3\2\2\2\u0193\u0194\b\63\2\2\u0194f\3\2\2"+
		"\2\u0195\u0196\t\7\2\2\u0196\u0197\3\2\2\2\u0197\u0198\b\64\2\2\u0198"+
		"h\3\2\2\2\u0199\u019a\t\b\2\2\u019aj\3\2\2\2\u019b\u019c\t\t\2\2\u019c"+
		"l\3\2\2\2\u019d\u019e\t\n\2\2\u019en\3\2\2\2\u019f\u01a0\t\13\2\2\u01a0"+
		"p\3\2\2\2\u01a1\u01a2\t\f\2\2\u01a2r\3\2\2\2\u01a3\u01a4\t\r\2\2\u01a4"+
		"t\3\2\2\2\u01a5\u01a6\t\16\2\2\u01a6v\3\2\2\2\u01a7\u01a8\t\17\2\2\u01a8"+
		"x\3\2\2\2\u01a9\u01aa\t\20\2\2\u01aaz\3\2\2\2\u01ab\u01ac\t\21\2\2\u01ac"+
		"|\3\2\2\2\u01ad\u01ae\t\22\2\2\u01ae~\3\2\2\2\u01af\u01b0\t\23\2\2\u01b0"+
		"\u0080\3\2\2\2\u01b1\u01b2\t\24\2\2\u01b2\u0082\3\2\2\2\u01b3\u01b4\t"+
		"\25\2\2\u01b4\u0084\3\2\2\2\u01b5\u01b6\t\26\2\2\u01b6\u0086\3\2\2\2\u01b7"+
		"\u01b8\t\27\2\2\u01b8\u0088\3\2\2\2\u01b9\u01ba\t\30\2\2\u01ba\u008a\3"+
		"\2\2\2\u01bb\u01bc\t\31\2\2\u01bc\u008c\3\2\2\2\u01bd\u01be\t\32\2\2\u01be"+
		"\u008e\3\2\2\2\u01bf\u01c0\t\33\2\2\u01c0\u0090\3\2\2\2\u01c1\u01c2\t"+
		"\34\2\2\u01c2\u0092\3\2\2\2\u01c3\u01c4\t\35\2\2\u01c4\u0094\3\2\2\2\u01c5"+
		"\u01c6\t\36\2\2\u01c6\u0096\3\2\2\2\u01c7\u01c8\t\37\2\2\u01c8\u0098\3"+
		"\2\2\2\u01c9\u01ca\t \2\2\u01ca\u009a\3\2\2\2\u01cb\u01cc\t!\2\2\u01cc"+
		"\u009c\3\2\2\2\u01cd\u01ce\t\"\2\2\u01ce\u009e\3\2\2\2\26\2\u0132\u0138"+
		"\u013b\u0141\u0143\u0149\u014b\u0154\u0156\u015e\u0160\u0166\u016a\u016c"+
		"\u016f\u017b\u017f\u0183\u018d\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}