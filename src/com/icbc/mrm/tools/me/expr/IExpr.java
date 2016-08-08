package com.icbc.mrm.tools.me.expr;

import com.icbc.mrm.tools.me.exception.ExprException;



public interface IExpr {
	public String evaluate() throws ExprException;
}
