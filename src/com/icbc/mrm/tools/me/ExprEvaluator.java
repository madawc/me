package com.icbc.mrm.tools.me;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.log4j.Logger;

import com.icbc.mrm.tools.me.compiler.impl.antlr4.caculator.CalculatorLexer;
import com.icbc.mrm.tools.me.compiler.impl.antlr4.caculator.CalculatorParser;
import com.icbc.mrm.tools.me.compiler.impl.antlr4.caculator.EvalVisitor;
import com.icbc.mrm.tools.me.exception.ExprException;
import com.icbc.mrm.tools.me.expr.impl.RawExpr;

public class ExprEvaluator {
	public static final Logger LOG = Logger.getLogger(ExprEvaluator.class);
	public enum Algorithm{
		RPN,ANTLR4
	}
	public static String evaluate(String expr ,Algorithm algo) throws ExprException{
		String result = null;
		switch(algo){
		case RPN:
			result = new RawExpr(expr).evaluate();
			break;
		case ANTLR4:
			ANTLRInputStream in = new ANTLRInputStream(expr);
			CalculatorLexer lexer = new CalculatorLexer(in);
			CommonTokenStream token = new CommonTokenStream(lexer);
			CalculatorParser paser = new CalculatorParser(token);
			
			ParseTree tree = paser.expression();
			EvalVisitor visitor = new EvalVisitor();
			result = Double.toString(visitor.visit(tree));
			break;
		default:
			throw new UnsupportedAlgorithmException(algo);
		}
		
		
		return result;
	}
}
