package com.icbc.mrm.tools.me.oper.impl.compare;

import com.icbc.mrm.tools.me.Constant;
import com.icbc.mrm.tools.me.exception.ExprException;
import com.icbc.mrm.tools.me.oper.CompareOper;

public class LEOper extends CompareOper {

	@Override
	public String compare(int c) throws ExprException {
		return c<=0?Constant.BOOL_TRUE:Constant.BOOL_FALSE;
	}

}
