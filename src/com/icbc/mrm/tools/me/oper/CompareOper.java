package com.icbc.mrm.tools.me.oper;

import com.icbc.mrm.tools.me.exception.ExprException;
import com.icbc.mrm.tools.me.expr.ExprHelper;

public abstract class CompareOper extends AbstractOper {
	
	@Override
	public String execute() throws ExprException {
		String opLeft = this.getOpLeft();
		String opRight = this.getOpRight();
		int c=0;
		if(ExprHelper.isNumber(opLeft) && ExprHelper.isNumber(opRight)){
			c = Double.valueOf(opLeft).compareTo(Double.valueOf(opRight));
		}else{
			c = opLeft.compareTo(opRight);
		}
		return compare(c);
	}
	
	public abstract String compare(int c) throws ExprException ;
}
