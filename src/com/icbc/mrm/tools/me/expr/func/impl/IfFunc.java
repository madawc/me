package com.icbc.mrm.tools.me.expr.func.impl;

import java.util.List;

import com.icbc.mrm.tools.me.Constant;
import com.icbc.mrm.tools.me.exception.ExprException;
import com.icbc.mrm.tools.me.expr.func.IFunc;
import com.icbc.mrm.tools.me.expr.impl.RawExpr;


/**
 * 类的描述：条件函数 
 * <pre>
 *IF(逻辑表达式,表达式1,表达式2)等价于：
 *  if(逻辑表达式) return 表达式1;
 *  else return 表达式2;
 * </pre>
 *
 * <pre>
 * modify by kfzx-maxj on 2016-6-20
 *    fix->1.初始版本
 * </pre> 
 */
public class IfFunc implements IFunc {
	@Override
	public String execute(List<String> paraList) throws ExprException {
		if(!new RawExpr(paraList.get(0)).evaluate().equals(Constant.BOOL_FALSE)){
			return new RawExpr(paraList.get(1)).evaluate();
		}else{
			return new RawExpr(paraList.get(2)).evaluate();
		}
	}

}
