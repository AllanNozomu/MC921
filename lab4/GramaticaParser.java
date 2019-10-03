// Generated from Gramatica.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GramaticaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, NUM=11, ID=12, ADD=13, WS=14;
	public static final int
		RULE_root = 0, RULE_line = 1, RULE_params = 2, RULE_paramsCall = 3, RULE_exprE = 4, 
		RULE_exprT = 5, RULE_exprF = 6, RULE_value = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "line", "params", "paramsCall", "exprE", "exprT", "exprF", "value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'='", "';'", "'func'", "'('", "')'", "','", "'-'", "'*'", 
			"'/'", null, null, "'+'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "NUM", 
			"ID", "ADD", "WS"
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
	public String getGrammarFileName() { return "Gramatica.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GramaticaParser(TokenStream input) {
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
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public RootContext root() {
			return getRuleContext(RootContext.class,0);
		}
		public RootMultiLineContext(RootContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitRootMultiLine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RootNoneContext extends RootContext {
		public TerminalNode EOF() { return getToken(GramaticaParser.EOF, 0); }
		public RootNoneContext(RootContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitRootNone(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		try {
			setState(20);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__3:
				_localctx = new RootMultiLineContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				line();
				setState(17);
				root();
				}
				break;
			case EOF:
				_localctx = new RootNoneContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
				match(EOF);
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
		public TerminalNode ID() { return getToken(GramaticaParser.ID, 0); }
		public ExprEContext exprE() {
			return getRuleContext(ExprEContext.class,0);
		}
		public VarAssignContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitVarAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncDefinitionContext extends LineContext {
		public TerminalNode ID() { return getToken(GramaticaParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public ExprEContext exprE() {
			return getRuleContext(ExprEContext.class,0);
		}
		public FuncDefinitionContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitFuncDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		try {
			setState(36);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new VarAssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				match(T__0);
				setState(23);
				match(ID);
				setState(24);
				match(T__1);
				setState(25);
				exprE(0);
				setState(26);
				match(T__2);
				}
				break;
			case T__3:
				_localctx = new FuncDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				match(T__3);
				setState(29);
				match(ID);
				setState(30);
				match(T__4);
				setState(31);
				params();
				setState(32);
				match(T__5);
				setState(33);
				exprE(0);
				setState(34);
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

	public static class ParamsContext extends ParserRuleContext {
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	 
		public ParamsContext() { }
		public void copyFrom(ParamsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParamsNoneContext extends ParamsContext {
		public ParamsNoneContext(ParamsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitParamsNone(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParamsMultiContext extends ParamsContext {
		public TerminalNode ID() { return getToken(GramaticaParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public ParamsMultiContext(ParamsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitParamsMulti(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParamsIDContext extends ParamsContext {
		public TerminalNode ID() { return getToken(GramaticaParser.ID, 0); }
		public ParamsIDContext(ParamsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitParamsID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_params);
		try {
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new ParamsMultiContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				match(ID);
				setState(39);
				match(T__6);
				setState(40);
				params();
				}
				break;
			case 2:
				_localctx = new ParamsIDContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				match(ID);
				}
				break;
			case 3:
				_localctx = new ParamsNoneContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
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

	public static class ParamsCallContext extends ParserRuleContext {
		public ParamsCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramsCall; }
	 
		public ParamsCallContext() { }
		public void copyFrom(ParamsCallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParamsCallNoneContext extends ParamsCallContext {
		public ParamsCallNoneContext(ParamsCallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitParamsCallNone(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParamsCallIDContext extends ParamsCallContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ParamsCallIDContext(ParamsCallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitParamsCallID(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParamsCallMultiContext extends ParamsCallContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ParamsCallContext paramsCall() {
			return getRuleContext(ParamsCallContext.class,0);
		}
		public ParamsCallMultiContext(ParamsCallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitParamsCallMulti(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsCallContext paramsCall() throws RecognitionException {
		ParamsCallContext _localctx = new ParamsCallContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_paramsCall);
		try {
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new ParamsCallMultiContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				value();
				setState(46);
				match(T__6);
				setState(47);
				paramsCall();
				}
				break;
			case 2:
				_localctx = new ParamsCallIDContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				value();
				}
				break;
			case 3:
				_localctx = new ParamsCallNoneContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
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

	public static class ExprEContext extends ParserRuleContext {
		public ExprEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprE; }
	 
		public ExprEContext() { }
		public void copyFrom(ExprEContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprEConversionContext extends ExprEContext {
		public ExprTContext exprT() {
			return getRuleContext(ExprTContext.class,0);
		}
		public ExprEConversionContext(ExprEContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExprEConversion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprESubContext extends ExprEContext {
		public ExprEContext exprE() {
			return getRuleContext(ExprEContext.class,0);
		}
		public ExprTContext exprT() {
			return getRuleContext(ExprTContext.class,0);
		}
		public ExprESubContext(ExprEContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExprESub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprESumContext extends ExprEContext {
		public ExprEContext exprE() {
			return getRuleContext(ExprEContext.class,0);
		}
		public TerminalNode ADD() { return getToken(GramaticaParser.ADD, 0); }
		public ExprTContext exprT() {
			return getRuleContext(ExprTContext.class,0);
		}
		public ExprESumContext(ExprEContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExprESum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprEContext exprE() throws RecognitionException {
		return exprE(0);
	}

	private ExprEContext exprE(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprEContext _localctx = new ExprEContext(_ctx, _parentState);
		ExprEContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_exprE, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ExprEConversionContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(54);
			exprT(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(64);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(62);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new ExprESumContext(new ExprEContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exprE);
						setState(56);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(57);
						match(ADD);
						setState(58);
						exprT(0);
						}
						break;
					case 2:
						{
						_localctx = new ExprESubContext(new ExprEContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exprE);
						setState(59);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(60);
						match(T__7);
						setState(61);
						exprT(0);
						}
						break;
					}
					} 
				}
				setState(66);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class ExprTContext extends ParserRuleContext {
		public ExprTContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprT; }
	 
		public ExprTContext() { }
		public void copyFrom(ExprTContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprTConversionContext extends ExprTContext {
		public ExprFContext exprF() {
			return getRuleContext(ExprFContext.class,0);
		}
		public ExprTConversionContext(ExprTContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExprTConversion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprTDivContext extends ExprTContext {
		public ExprTContext exprT() {
			return getRuleContext(ExprTContext.class,0);
		}
		public ExprFContext exprF() {
			return getRuleContext(ExprFContext.class,0);
		}
		public ExprTDivContext(ExprTContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExprTDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprTMulContext extends ExprTContext {
		public ExprTContext exprT() {
			return getRuleContext(ExprTContext.class,0);
		}
		public ExprFContext exprF() {
			return getRuleContext(ExprFContext.class,0);
		}
		public ExprTMulContext(ExprTContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExprTMul(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprTContext exprT() throws RecognitionException {
		return exprT(0);
	}

	private ExprTContext exprT(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprTContext _localctx = new ExprTContext(_ctx, _parentState);
		ExprTContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_exprT, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ExprTConversionContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(68);
			exprF();
			}
			_ctx.stop = _input.LT(-1);
			setState(78);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(76);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExprTMulContext(new ExprTContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exprT);
						setState(70);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(71);
						match(T__8);
						setState(72);
						exprF();
						}
						break;
					case 2:
						{
						_localctx = new ExprTDivContext(new ExprTContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exprT);
						setState(73);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(74);
						match(T__9);
						setState(75);
						exprF();
						}
						break;
					}
					} 
				}
				setState(80);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class ExprFContext extends ParserRuleContext {
		public ExprFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprF; }
	 
		public ExprFContext() { }
		public void copyFrom(ExprFContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprFValContext extends ExprFContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ExprFValContext(ExprFContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExprFVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprFParenContext extends ExprFContext {
		public ExprEContext exprE() {
			return getRuleContext(ExprEContext.class,0);
		}
		public ExprFParenContext(ExprFContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExprFParen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprFFuncContext extends ExprFContext {
		public TerminalNode ID() { return getToken(GramaticaParser.ID, 0); }
		public ParamsCallContext paramsCall() {
			return getRuleContext(ParamsCallContext.class,0);
		}
		public ExprFFuncContext(ExprFContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExprFFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprFContext exprF() throws RecognitionException {
		ExprFContext _localctx = new ExprFContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_exprF);
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new ExprFParenContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				match(T__4);
				setState(82);
				exprE(0);
				setState(83);
				match(T__5);
				}
				break;
			case 2:
				_localctx = new ExprFFuncContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				match(ID);
				setState(86);
				match(T__4);
				setState(87);
				paramsCall();
				setState(88);
				match(T__5);
				}
				break;
			case 3:
				_localctx = new ExprFValContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				value();
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
		public TerminalNode NUM() { return getToken(GramaticaParser.NUM, 0); }
		public ValueNumContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitValueNum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueIDContext extends ValueContext {
		public TerminalNode ID() { return getToken(GramaticaParser.ID, 0); }
		public ValueIDContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitValueID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_value);
		try {
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				_localctx = new ValueNumContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				match(NUM);
				}
				break;
			case ID:
				_localctx = new ValueIDContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
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
		case 4:
			return exprE_sempred((ExprEContext)_localctx, predIndex);
		case 5:
			return exprT_sempred((ExprTContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exprE_sempred(ExprEContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean exprT_sempred(ExprTContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20d\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\5\2"+
		"\27\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\'"+
		"\n\3\3\4\3\4\3\4\3\4\3\4\5\4.\n\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5\66\n\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6A\n\6\f\6\16\6D\13\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\7\7O\n\7\f\7\16\7R\13\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\5\b^\n\b\3\t\3\t\5\tb\n\t\3\t\2\4\n\f\n\2\4\6\b\n\f"+
		"\16\20\2\2\2h\2\26\3\2\2\2\4&\3\2\2\2\6-\3\2\2\2\b\65\3\2\2\2\n\67\3\2"+
		"\2\2\fE\3\2\2\2\16]\3\2\2\2\20a\3\2\2\2\22\23\5\4\3\2\23\24\5\2\2\2\24"+
		"\27\3\2\2\2\25\27\7\2\2\3\26\22\3\2\2\2\26\25\3\2\2\2\27\3\3\2\2\2\30"+
		"\31\7\3\2\2\31\32\7\16\2\2\32\33\7\4\2\2\33\34\5\n\6\2\34\35\7\5\2\2\35"+
		"\'\3\2\2\2\36\37\7\6\2\2\37 \7\16\2\2 !\7\7\2\2!\"\5\6\4\2\"#\7\b\2\2"+
		"#$\5\n\6\2$%\7\5\2\2%\'\3\2\2\2&\30\3\2\2\2&\36\3\2\2\2\'\5\3\2\2\2()"+
		"\7\16\2\2)*\7\t\2\2*.\5\6\4\2+.\7\16\2\2,.\3\2\2\2-(\3\2\2\2-+\3\2\2\2"+
		"-,\3\2\2\2.\7\3\2\2\2/\60\5\20\t\2\60\61\7\t\2\2\61\62\5\b\5\2\62\66\3"+
		"\2\2\2\63\66\5\20\t\2\64\66\3\2\2\2\65/\3\2\2\2\65\63\3\2\2\2\65\64\3"+
		"\2\2\2\66\t\3\2\2\2\678\b\6\1\289\5\f\7\29B\3\2\2\2:;\f\4\2\2;<\7\17\2"+
		"\2<A\5\f\7\2=>\f\3\2\2>?\7\n\2\2?A\5\f\7\2@:\3\2\2\2@=\3\2\2\2AD\3\2\2"+
		"\2B@\3\2\2\2BC\3\2\2\2C\13\3\2\2\2DB\3\2\2\2EF\b\7\1\2FG\5\16\b\2GP\3"+
		"\2\2\2HI\f\4\2\2IJ\7\13\2\2JO\5\16\b\2KL\f\3\2\2LM\7\f\2\2MO\5\16\b\2"+
		"NH\3\2\2\2NK\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\r\3\2\2\2RP\3\2\2"+
		"\2ST\7\7\2\2TU\5\n\6\2UV\7\b\2\2V^\3\2\2\2WX\7\16\2\2XY\7\7\2\2YZ\5\b"+
		"\5\2Z[\7\b\2\2[^\3\2\2\2\\^\5\20\t\2]S\3\2\2\2]W\3\2\2\2]\\\3\2\2\2^\17"+
		"\3\2\2\2_b\7\r\2\2`b\7\16\2\2a_\3\2\2\2a`\3\2\2\2b\21\3\2\2\2\f\26&-\65"+
		"@BNP]a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}