package com.icbc.mrm.tools.me.compiler.impl.antlr4.caculator;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import com.icbc.mrm.tools.me.expr.func.FuncManager;
import com.icbc.mrm.tools.me.expr.func.FuncProxy;
import com.icbc.mrm.tools.me.expr.func.IFunc;

public class EvalVisitor extends CalculatorBaseVisitor<Double> {

	@Override
	public Double visitFunc(CalculatorParser.FuncContext ctx) {
		String funcName = ctx.funcname().getText();
		/*if("sum".equals(funcName)){
			List<CalculatorParser.ExpressionContext> ec = ctx.expression();
			Double sum = 0d;
			for(int i =0;i<ec.size();i++){
				System.out.println(ec.get(i).getText());
				sum+=Double.valueOf(visit(ec.get(i)));
			}
			
			return sum;
		}*/
		FuncManager fhm = FuncManager.getInstance();
		IFunc function = fhm.getHandler(funcName);
		List<String> paraList = new ArrayList<String>();
		String ret = new FuncProxy(function).execute(this.getParaList())
		return "";
	}

	@Override
	public Double visitNumber(CalculatorParser.NumberContext ctx) {
		// TODO Auto-generated method stub
		return Double.valueOf(ctx.getText());
	}

	@Override
	public Double visitExpression(CalculatorParser.ExpressionContext ctx) {
		double ret = visit(ctx.getChild(0));
		for(int i=1;i<ctx.getChildCount();i+=2){
			TerminalNodeImpl op = (TerminalNodeImpl)ctx.getChild(i);
			double n = visit(ctx.getChild(i+1));
			if(op.getSymbol().getType() == CalculatorParser.MINUS){
				ret -= n;
			}else if(op.getSymbol().getType() == CalculatorParser.PLUS){
				ret += n;
			}
		}
		
		return ret;
	}

	@Override
	public Double visitMultiplyingExpression(CalculatorParser.MultiplyingExpressionContext ctx) {
		double ret = visit(ctx.getChild(0));
		for(int i=1;i<ctx.getChildCount();i+=2){
			TerminalNodeImpl op = (TerminalNodeImpl)ctx.getChild(i);
			double n = visit(ctx.getChild(i+1));
			if(op.getSymbol().getType() == CalculatorParser.DIV){
				ret /= n;
			}else if(op.getSymbol().getType() == CalculatorParser.TIMES){
				ret *= n;
			}
		}
		return ret;
	}

	@Override
	public Double visitPowExpression(CalculatorParser.PowExpressionContext ctx) {
		double ret = visit(ctx.atom());
		if(ctx.POW()!=null){
			ret=Math.pow(ret,visit(ctx.expression()));
		}
		return ret;
	}

	@Override
	public Double visitSci(CalculatorParser.SciContext ctx) {
		// TODO Auto-generated method stub
		return visitScientific(ctx.scientific());
	}

	@Override
	public Double visitScientific(CalculatorParser.ScientificContext ctx) {
		double ret = visit(ctx.number(0));
		if(ctx.E()!=null){
			ret=ret*Math.pow(10, visit(ctx.number(1)));
		}
		return ret;
	}

	@Override
	public Double visitFunction(CalculatorParser.FunctionContext ctx) {
		// TODO Auto-generated method stub
		return this.visitFunc(ctx.func());
	}

	@Override
	public Double visitParents(CalculatorParser.ParentsContext ctx) {
		
		return this.visit(ctx.expression());
	}

	@Override
	public Double visitRelop(CalculatorParser.RelopContext ctx) {
		
		return super.visitRelop(ctx);
	}

	

	

	
	
}
