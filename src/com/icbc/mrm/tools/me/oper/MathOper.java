package com.icbc.mrm.tools.me.oper;

import java.util.Arrays;
import java.util.List;

import com.icbc.mrm.tools.me.exception.ExprException;
import com.icbc.mrm.tools.me.exception.InvalidOprandException;
import com.icbc.mrm.tools.me.expr.ExprHelper;

public abstract class MathOper extends AbstractOper {

	@Override
	public String execute() throws ExprException{
		List<String> oprands = Arrays.asList(
			new String[]{this.getOpLeft(),this.getOpRight()}
		);
		for(String oprand : oprands){
			if(!ExprHelper.isNumber(oprand)){
				throw new InvalidOprandException(
					oprand,InvalidOprandException.TYPE_DOUBLE);
			}
		}
		return ExprHelper.double2String(caculate());
	}
	public abstract double caculate() throws ExprException;
}
