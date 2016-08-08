package com.icbc.mrm.tools.me.expr.func.impl;

import java.util.List;

import com.icbc.mrm.tools.me.exception.ExprException;
import com.icbc.mrm.tools.me.exception.InvalidOprandException;
import com.icbc.mrm.tools.me.expr.ExprHelper;
import com.icbc.mrm.tools.me.expr.func.IStableFunc;

/**
 * TODO 类的描述：求和函数
 * <pre>
 *计算所有参数之和
 * </pre>
 *
 * <pre>
 * modify by kfzx-maxj on 2016-6-20
 *    fix->1.初始版本
 * </pre> 
 */
public class SumFunc implements IStableFunc {
	
	@Override
	public String execute(List<String> paraList) throws ExprException {
		double s = 0;
		int i=0;
		while(i <paraList.size()){
			try{
				s += Double.parseDouble(paraList.get(i));
			}catch(NumberFormatException re){
				throw new InvalidOprandException(
					paraList.get(i),InvalidOprandException.TYPE_DOUBLE
				);
			}
			i++;
		}
		return ExprHelper.double2String(s);
	}

}
