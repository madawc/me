package com.icbc.mrm.tools.me.compiler;

import com.icbc.mrm.tools.me.exception.ExprException;
import com.icbc.mrm.tools.me.expr.IExpr;

public interface ICompiler {
	public IExpr compile(String expr) throws ExprException;
}
