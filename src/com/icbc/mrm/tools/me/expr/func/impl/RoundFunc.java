package com.icbc.mrm.tools.me.expr.func.impl;

import java.math.BigDecimal;
import java.util.List;

import com.icbc.mrm.tools.me.exception.ExprException;
import com.icbc.mrm.tools.me.exception.InvalidOprandException;
import com.icbc.mrm.tools.me.expr.ExprHelper;
import com.icbc.mrm.tools.me.expr.func.IStableFunc;

public class RoundFunc implements IStableFunc {

	@Override
	public String execute(List<String> paraList) throws ExprException {
		BigDecimal bg = null;
		try{
			bg = new BigDecimal(paraList.get(0));
		}catch (NumberFormatException re) {
			throw new InvalidOprandException(
				paraList.get(0),InvalidOprandException.TYPE_DOUBLE
			);
		}
		try{
			bg = bg.setScale(Integer.parseInt(paraList.get(1)),
				BigDecimal.ROUND_HALF_UP);
		}catch (NumberFormatException re) {
			throw new InvalidOprandException(
				paraList.get(1),InvalidOprandException.TYPE_INT
			);
		}
		return ExprHelper.double2String(bg.doubleValue());
	}
}
