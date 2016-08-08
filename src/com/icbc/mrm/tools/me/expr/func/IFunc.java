package com.icbc.mrm.tools.me.expr.func;

import java.util.List;

import com.icbc.mrm.tools.me.exception.ExprException;

public interface IFunc {
	public String execute(List<String> paraList) throws ExprException ;
}
