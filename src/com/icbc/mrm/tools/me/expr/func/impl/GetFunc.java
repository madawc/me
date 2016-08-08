package com.icbc.mrm.tools.me.expr.func.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icbc.mrm.tools.me.Context;
import com.icbc.mrm.tools.me.exception.ExprException;
import com.icbc.mrm.tools.me.expr.func.IFunc;
import com.icbc.mrm.tools.me.expr.impl.RawExpr;

/**
 * TODO 类的描述：从Context中获取数据
 * <pre>
 *举个例子：
 *Map a =new HashMap();
 *a.put("ccc",new String[]{"111","222"})
 *context.put("aaa",a)
 *那么Get("aaa.ccc[1]")返回"222"
 * </pre>
 *
 * <pre>
 * modify by kfzx-maxj on 2016-6-21
 *    fix->1.初始版本
 *         2.
 * </pre> 
 */
public class GetFunc implements IFunc {

	@Override
	public String execute(List<String> paraList) throws ExprException {
		
		return (String)Context.getInstance().getValue(paraList.get(0));
	}
	
	public static void main(String[] args) throws Exception{
		Map<String,Object> a = new HashMap<String,Object>();
		List<Object> b = new ArrayList<Object>();
		b.add("b111");
		Map<String,String> t= new HashMap<String,String>();
		t.put("ttt", "666");
		b.add(t);
		a.put("aaa",b);
		Context.getInstance().setValue("p1", a);
		System.out.println(new RawExpr("get(p1.aaa[1].ttt)").evaluate());
	}
}
