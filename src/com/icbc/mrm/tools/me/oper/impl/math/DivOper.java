package com.icbc.mrm.tools.me.oper.impl.math;

import com.icbc.mrm.tools.me.exception.ExprException;
import com.icbc.mrm.tools.me.oper.MathOper;

public class DivOper extends MathOper {

	
	@Override
	public double caculate() throws ExprException {
		String opLeft = this.getOpLeft();
		String opRight = this.getOpRight();
		return Double.parseDouble(opLeft) / Double.parseDouble(opRight);
	}

}
