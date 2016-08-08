package com.icbc.mrm.tools.me.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icbc.mrm.tools.me.Context;
import com.icbc.mrm.tools.me.expr.impl.RawExpr;

public class TestGetFunc {

	/**
	 * TODO 方法的描述：。 
	 * <pre>
	 *
	 * </pre>
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		String expr = "get(T01[14][0].value)+get(T01[14][1].value)+"+
		"get(T01[14][2].value)+(get(T01[14][3].value)+get(T01[14][4]."+
		"value)+get(T01[14][5].value))*get(param.L5)+get(T01[15][0].value)"+
		"+get(T01[15][1].value)+get(T01[15][2].value)+(get(T01[15][3].value)"+
		"+get(T01[15][4].value)+get(T01[15][5].value))*get(param.L7)+get(T01[17][0].value)+get(T01[17][1].value)+get(T01[17][2].value)";
		
		Context ctx = Context.getInstance();
		
		List<List<Map<String,String>>> s = new ArrayList<List<Map<String,String>>>();
		Map<String,String> m = null;
		for(int i=0;i<50;i++){
			List<Map<String,String>> l = new ArrayList<Map<String,String>>();
			for(int j=0;j<50;j++){
				m=new HashMap<String,String>();
				m.put("value","123.3435e8");
				l.add(m);
			}
			s.add(l);
		}
		ctx.setValue("T01", s);
		m = new HashMap<String,String>();
		m.put("L5", "5");
		m.put("L7", "7");
		ctx.setValue("param", m);
		
		System.out.println(new RawExpr("get(T01[14][2].value)").evaluate());
		System.out.println(new RawExpr("get(param.L7)").evaluate());
		
		long start = System.currentTimeMillis();
		String r="";
		int cc=10000;
		for(int c =0;c<cc;c++){
			r = new RawExpr(expr).evaluate();
		}
		System.out.println(r);
		System.out.println((System.currentTimeMillis()-start)/1.0/cc);
		
		
		
	}

}
