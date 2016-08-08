package com.icbc.mrm.tools.me.expr.impl;


import com.icbc.mrm.tools.me.exception.ExprException;
import com.icbc.mrm.tools.me.expr.IExpr;

/**
 * 常量表达式
 *
 * @author		MAXJ
 * @version		initial
 */
public class ConstExpr implements IExpr {

	private String expr = null;
	
	public ConstExpr(String expr){
		this.expr = expr;
	}
	@Override
	public String evaluate() throws ExprException {
		
		return this.expr;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.expr;
	}

}
