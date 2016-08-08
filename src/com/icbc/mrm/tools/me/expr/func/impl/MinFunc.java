package com.icbc.mrm.tools.me.expr.func.impl;

import java.util.List;

import com.icbc.mrm.tools.me.exception.ExprException;
import com.icbc.mrm.tools.me.exception.InvalidOprandException;
import com.icbc.mrm.tools.me.expr.ExprHelper;
import com.icbc.mrm.tools.me.expr.func.IFunc;

public class MinFunc implements IFunc {

	@Override
	public String execute(List<String> paraList) throws ExprException {
		double d = Double.POSITIVE_INFINITY;
		int i =0;
		while(i<paraList.size()){
			double t;
			try{
				t = Double.parseDouble(paraList.get(i));
			}catch(NumberFormatException re){
				throw new InvalidOprandException(
					paraList.get(i),InvalidOprandException.TYPE_DOUBLE
				);
			}
			d=Math.min(d, t);
			i++;
		}
		return ExprHelper.double2String(d);
	}

}
