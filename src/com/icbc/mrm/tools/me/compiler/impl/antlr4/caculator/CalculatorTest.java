package com.icbc.mrm.tools.me.compiler.impl.antlr4.caculator;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class CalculatorTest {

	public static void main(String[] args) throws Exception{
		String expr = "(1+2)";
		ANTLRInputStream in = new ANTLRInputStream(expr);
		CalculatorLexer lexer = new CalculatorLexer(in);
		CommonTokenStream token = new CommonTokenStream(lexer);
		CalculatorParser paser = new CalculatorParser(token);
		
		ParseTree tree = paser.expression();
		EvalVisitor visitor = new EvalVisitor();
		Double result = visitor.visit(tree);
		
		System.out.println(result);
	}

}
