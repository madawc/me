package com.icbc.mrm.tools.me.expr.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


import com.icbc.mrm.tools.me.exception.ExprException;
import com.icbc.mrm.tools.me.expr.IExpr;


/**
 * 逆波兰表达式
 *
 * @author		MAXJ
 * @version		initial
 */
public class RPNExpr implements IExpr {
	
	private List<IExpr> expr = null;
	
	public RPNExpr(){
		expr = new ArrayList<IExpr>();
	}
	
	@Override
	public String evaluate() throws ExprException{
		
		Stack<String> result = new Stack<String>();
		int i=0;
		IExpr tmpExpr = null;
		
		while(i<expr.size()){
			tmpExpr = this.expr.get(i);
			if(tmpExpr instanceof FuncExpr){
				result.push(tmpExpr.evaluate());
			}else if(tmpExpr instanceof OperExpr){
				String op2 = result.pop();
				String op1 = result.pop();
				((OperExpr) tmpExpr).addPara(new ConstExpr(op1));
				((OperExpr) tmpExpr).addPara(new ConstExpr(op2));
				result.push(tmpExpr.evaluate());
			}else{
				result.push(tmpExpr.evaluate());
			}
			i++;
		}
		return result.pop();
	}
	
	public void addExpr(IExpr expression){
		this.expr.add(expression);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<this.expr.size();i++){
			sb.append("|").append(this.expr.get(i));
		}		
		return sb.toString().substring(1);
	}
	
	public int getRPNSize(){
		return this.expr.size();
	}
	
	public List<IExpr> getExpr(){
		return this.expr;
	}
}
