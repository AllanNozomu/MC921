// Generated from /home/allan/Documents/Programming/Unicamp/MC921/labs/lab3/src/Summer.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SummerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, NUM=9, 
		ID=10, ADD=11, WS=12;
	public static final int
		RULE_root = 0, RULE_line = 1, RULE_expr = 2, RULE_params = 3, RULE_value = 4;
	public static final String[] ruleNames = {
		"root", "line", "expr", "params", "value"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'var'", "'='", "';'", "'func'", "'('", "')'", "'*'", "','", null, 
		null, "'+'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "NUM", "ID", "ADD", 
		"WS"
	};
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
	public String getGrammarFileName() { return "Summer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SummerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RootContext extends ParserRuleContext {
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
	 
		public RootContext() { }
		public void copyFrom(RootContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RootMultiLineContext extends RootContext {
		public RootContext root() {
			return getRuleContext(RootContext.class,0);
		}
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public RootMultiLineContext(RootContext ctx) { copyFrom(ctx); }
	}
	public static class RootSingleLineContext extends RootContext {
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public RootSingleLineContext(RootContext ctx) { copyFrom(ctx); }
	}

	public final RootContext root() throws RecognitionException {
		return root(0);
	}

	private RootContext root(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RootContext _localctx = new RootContext(_ctx, _parentState);
		RootContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_root, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new RootSingleLineContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(11);
			line();
			}
			_ctx.stop = _input.LT(-1);
			setState(17);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RootMultiLineContext(new RootContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_root);
					setState(13);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(14);
					line();
					}
					} 
				}
				setState(19);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
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

	public static class LineContext extends ParserRuleContext {
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
	 
		public LineContext() { }
		public void copyFrom(LineContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarAssignContext extends LineContext {
		public TerminalNode ID() { return getToken(SummerParser.ID, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public VarAssignContext(LineContext ctx) { copyFrom(ctx); }
	}
	public static class FuncDefinitionContext extends LineContext {
		public TerminalNode ID() { return getToken(SummerParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FuncDefinitionContext(LineContext ctx) { copyFrom(ctx); }
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		try {
			setState(34);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new VarAssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				match(T__0);
				setState(21);
				match(ID);
				setState(22);
				match(T__1);
				setState(23);
				value();
				setState(24);
				match(T__2);
				}
				break;
			case T__3:
				_localctx = new FuncDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(26);
				match(T__3);
				setState(27);
				match(ID);
				setState(28);
				match(T__4);
				setState(29);
				params();
				setState(30);
				match(T__5);
				setState(31);
				expr();
				setState(32);
				match(T__2);
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

	public static class ExprContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			value();
			setState(37);
			match(ADD);
			setState(38);
			value();
			setState(39);
			match(T__6);
			setState(40);
			value();
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

	public static class ParamsContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_params);
		int _la;
		try {
			setState(52);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				value();
				setState(45); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(43);
					match(T__7);
					setState(44);
					value();
					}
					}
					setState(47); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__7 );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUM || _la==ID) {
					{
					setState(49);
					value();
					}
				}

				}
				break;
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

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValueNumContext extends ValueContext {
		public TerminalNode NUM() { return getToken(SummerParser.NUM, 0); }
		public ValueNumContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class ValueIDContext extends ValueContext {
		public TerminalNode ID() { return getToken(SummerParser.ID, 0); }
		public ValueIDContext(ValueContext ctx) { copyFrom(ctx); }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_value);
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				_localctx = new ValueNumContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(NUM);
				}
				break;
			case ID:
				_localctx = new ValueIDContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				match(ID);
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
		case 0:
			return root_sempred((RootContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean root_sempred(RootContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\16=\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\7\2\22\n\2\f\2\16\2\25"+
		"\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3%\n\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\6\5\60\n\5\r\5\16\5\61\3\5\5\5\65"+
		"\n\5\5\5\67\n\5\3\6\3\6\5\6;\n\6\3\6\2\3\2\7\2\4\6\b\n\2\2\2=\2\f\3\2"+
		"\2\2\4$\3\2\2\2\6&\3\2\2\2\b\66\3\2\2\2\n:\3\2\2\2\f\r\b\2\1\2\r\16\5"+
		"\4\3\2\16\23\3\2\2\2\17\20\f\4\2\2\20\22\5\4\3\2\21\17\3\2\2\2\22\25\3"+
		"\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\3\3\2\2\2\25\23\3\2\2\2\26\27\7"+
		"\3\2\2\27\30\7\f\2\2\30\31\7\4\2\2\31\32\5\n\6\2\32\33\7\5\2\2\33%\3\2"+
		"\2\2\34\35\7\6\2\2\35\36\7\f\2\2\36\37\7\7\2\2\37 \5\b\5\2 !\7\b\2\2!"+
		"\"\5\6\4\2\"#\7\5\2\2#%\3\2\2\2$\26\3\2\2\2$\34\3\2\2\2%\5\3\2\2\2&\'"+
		"\5\n\6\2\'(\7\r\2\2()\5\n\6\2)*\7\t\2\2*+\5\n\6\2+\7\3\2\2\2,/\5\n\6\2"+
		"-.\7\n\2\2.\60\5\n\6\2/-\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2"+
		"\2\62\67\3\2\2\2\63\65\5\n\6\2\64\63\3\2\2\2\64\65\3\2\2\2\65\67\3\2\2"+
		"\2\66,\3\2\2\2\66\64\3\2\2\2\67\t\3\2\2\28;\7\13\2\29;\7\f\2\2:8\3\2\2"+
		"\2:9\3\2\2\2;\13\3\2\2\2\b\23$\61\64\66:";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}