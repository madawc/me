package com.icbc.mrm.tools.me.compiler.impl.antlr4.caculator;
// Generated from Calculator.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculatorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, SUM=2, LPAREN=3, RPAREN=4, PLUS=5, MINUS=6, TIMES=7, DIV=8, GT=9, 
		LT=10, EQ=11, POINT=12, E=13, POW=14, DIGIT=15, WS=16;
	public static final String[] tokenNames = {
		"<INVALID>", "','", "'sum'", "'('", "')'", "'+'", "'-'", "'*'", "'/'", 
		"'>'", "'<'", "'='", "'.'", "E", "'^'", "DIGIT", "WS"
	};
	public static final int
		RULE_expression = 0, RULE_multiplyingExpression = 1, RULE_powExpression = 2, 
		RULE_atom = 3, RULE_scientific = 4, RULE_func = 5, RULE_funcname = 6, 
		RULE_relop = 7, RULE_number = 8;
	public static final String[] ruleNames = {
		"expression", "multiplyingExpression", "powExpression", "atom", "scientific", 
		"func", "funcname", "relop", "number"
	};

	@Override
	public String getGrammarFileName() { return "Calculator.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CalculatorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode MINUS(int i) {
			return getToken(CalculatorParser.MINUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(CalculatorParser.MINUS); }
		public MultiplyingExpressionContext multiplyingExpression(int i) {
			return getRuleContext(MultiplyingExpressionContext.class,i);
		}
		public List<MultiplyingExpressionContext> multiplyingExpression() {
			return getRuleContexts(MultiplyingExpressionContext.class);
		}
		public List<TerminalNode> PLUS() { return getTokens(CalculatorParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(CalculatorParser.PLUS, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(18); multiplyingExpression();
			setState(23);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(19);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(20); multiplyingExpression();
					}
					} 
				}
				setState(25);
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
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplyingExpressionContext extends ParserRuleContext {
		public TerminalNode TIMES(int i) {
			return getToken(CalculatorParser.TIMES, i);
		}
		public List<TerminalNode> TIMES() { return getTokens(CalculatorParser.TIMES); }
		public List<TerminalNode> DIV() { return getTokens(CalculatorParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(CalculatorParser.DIV, i);
		}
		public PowExpressionContext powExpression(int i) {
			return getRuleContext(PowExpressionContext.class,i);
		}
		public List<PowExpressionContext> powExpression() {
			return getRuleContexts(PowExpressionContext.class);
		}
		public MultiplyingExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplyingExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitMultiplyingExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplyingExpressionContext multiplyingExpression() throws RecognitionException {
		MultiplyingExpressionContext _localctx = new MultiplyingExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_multiplyingExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(26); powExpression();
			setState(31);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(27);
					_la = _input.LA(1);
					if ( !(_la==TIMES || _la==DIV) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(28); powExpression();
					}
					} 
				}
				setState(33);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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

	public static class PowExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode POW() { return getToken(CalculatorParser.POW, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public PowExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_powExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitPowExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PowExpressionContext powExpression() throws RecognitionException {
		PowExpressionContext _localctx = new PowExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_powExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); atom();
			setState(37);
			_la = _input.LA(1);
			if (_la==POW) {
				{
				setState(35); match(POW);
				setState(36); expression();
				}
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

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParentsContext extends AtomContext {
		public TerminalNode RPAREN() { return getToken(CalculatorParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(CalculatorParser.LPAREN, 0); }
		public ParentsContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitParents(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SciContext extends AtomContext {
		public ScientificContext scientific() {
			return getRuleContext(ScientificContext.class,0);
		}
		public SciContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitSci(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionContext extends AtomContext {
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public FunctionContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_atom);
		try {
			setState(45);
			switch (_input.LA(1)) {
			case MINUS:
			case DIGIT:
				_localctx = new SciContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(39); scientific();
				}
				break;
			case LPAREN:
				_localctx = new ParentsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(40); match(LPAREN);
				setState(41); expression();
				setState(42); match(RPAREN);
				}
				break;
			case SUM:
				_localctx = new FunctionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(44); func();
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

	public static class ScientificContext extends ParserRuleContext {
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public TerminalNode E() { return getToken(CalculatorParser.E, 0); }
		public ScientificContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scientific; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitScientific(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScientificContext scientific() throws RecognitionException {
		ScientificContext _localctx = new ScientificContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_scientific);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47); number();
			setState(50);
			_la = _input.LA(1);
			if (_la==E) {
				{
				setState(48); match(E);
				setState(49); number();
				}
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

	public static class FuncContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(CalculatorParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode LPAREN() { return getToken(CalculatorParser.LPAREN, 0); }
		public FuncnameContext funcname() {
			return getRuleContext(FuncnameContext.class,0);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52); funcname();
			setState(53); match(LPAREN);
			setState(54); expression();
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(55); match(T__0);
				setState(56); expression();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62); match(RPAREN);
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

	public static class FuncnameContext extends ParserRuleContext {
		public TerminalNode SUM() { return getToken(CalculatorParser.SUM, 0); }
		public FuncnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcname; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitFuncname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncnameContext funcname() throws RecognitionException {
		FuncnameContext _localctx = new FuncnameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64); match(SUM);
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

	public static class RelopContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(CalculatorParser.LT, 0); }
		public TerminalNode GT() { return getToken(CalculatorParser.GT, 0); }
		public TerminalNode EQ() { return getToken(CalculatorParser.EQ, 0); }
		public RelopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitRelop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelopContext relop() throws RecognitionException {
		RelopContext _localctx = new RelopContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_relop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << EQ))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode DIGIT(int i) {
			return getToken(CalculatorParser.DIGIT, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(CalculatorParser.DIGIT); }
		public TerminalNode MINUS() { return getToken(CalculatorParser.MINUS, 0); }
		public TerminalNode POINT() { return getToken(CalculatorParser.POINT, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(68); match(MINUS);
				}
			}

			setState(72); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(71); match(DIGIT);
				}
				}
				setState(74); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGIT );
			setState(82);
			_la = _input.LA(1);
			if (_la==POINT) {
				{
				setState(76); match(POINT);
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(77); match(DIGIT);
					}
					}
					setState(80); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DIGIT );
				}
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\22W\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2"+
		"\7\2\30\n\2\f\2\16\2\33\13\2\3\3\3\3\3\3\7\3 \n\3\f\3\16\3#\13\3\3\4\3"+
		"\4\3\4\5\4(\n\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5\60\n\5\3\6\3\6\3\6\5\6\65"+
		"\n\6\3\7\3\7\3\7\3\7\3\7\7\7<\n\7\f\7\16\7?\13\7\3\7\3\7\3\b\3\b\3\t\3"+
		"\t\3\n\5\nH\n\n\3\n\6\nK\n\n\r\n\16\nL\3\n\3\n\6\nQ\n\n\r\n\16\nR\5\n"+
		"U\n\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\5\3\2\7\b\3\2\t\n\3\2\13\rX\2"+
		"\24\3\2\2\2\4\34\3\2\2\2\6$\3\2\2\2\b/\3\2\2\2\n\61\3\2\2\2\f\66\3\2\2"+
		"\2\16B\3\2\2\2\20D\3\2\2\2\22G\3\2\2\2\24\31\5\4\3\2\25\26\t\2\2\2\26"+
		"\30\5\4\3\2\27\25\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32"+
		"\3\3\2\2\2\33\31\3\2\2\2\34!\5\6\4\2\35\36\t\3\2\2\36 \5\6\4\2\37\35\3"+
		"\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\5\3\2\2\2#!\3\2\2\2$\'\5\b\5"+
		"\2%&\7\20\2\2&(\5\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\7\3\2\2\2)\60\5\n\6\2*"+
		"+\7\5\2\2+,\5\2\2\2,-\7\6\2\2-\60\3\2\2\2.\60\5\f\7\2/)\3\2\2\2/*\3\2"+
		"\2\2/.\3\2\2\2\60\t\3\2\2\2\61\64\5\22\n\2\62\63\7\17\2\2\63\65\5\22\n"+
		"\2\64\62\3\2\2\2\64\65\3\2\2\2\65\13\3\2\2\2\66\67\5\16\b\2\678\7\5\2"+
		"\28=\5\2\2\29:\7\3\2\2:<\5\2\2\2;9\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2"+
		"\2>@\3\2\2\2?=\3\2\2\2@A\7\6\2\2A\r\3\2\2\2BC\7\4\2\2C\17\3\2\2\2DE\t"+
		"\4\2\2E\21\3\2\2\2FH\7\b\2\2GF\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IK\7\21\2\2"+
		"JI\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MT\3\2\2\2NP\7\16\2\2OQ\7\21\2"+
		"\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2SU\3\2\2\2TN\3\2\2\2TU\3\2\2"+
		"\2U\23\3\2\2\2\f\31!\'/\64=GLRT";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}