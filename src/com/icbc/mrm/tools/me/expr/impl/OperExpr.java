package com.icbc.mrm.tools.me.expr.impl;

import java.util.ArrayList;
import java.util.List;

import com.icbc.mrm.tools.me.exception.ExprException;
import com.icbc.mrm.tools.me.expr.IExpr;
import com.icbc.mrm.tools.me.oper.AbstractOper;
import com.icbc.mrm.tools.me.oper.OperFactory;


/**
 * 操作符表达式
 *
 * @author		MAXJ
 * @version		initial
 */

public class OperExpr implements IExpr {
	private String expr = null;
	private List<IExpr> para = null;
	public OperExpr(String expr) {
		this.expr = expr;
		this.para = new ArrayList<IExpr>();
	}

	@Override
	public String evaluate() throws ExprException {
		
		String opLeft = this.para.get(0).evaluate();
		String opRight = this.para.get(1).evaluate();
		AbstractOper oper = OperFactory.getInstance().build(expr, opLeft, opRight);
		return oper.execute();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.expr;
	}
	public void addPara(IExpr para){
		this.para.add(para);
	}
}
