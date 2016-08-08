package com.icbc.mrm.tools.me.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icbc.mrm.tools.me.Context;
import com.icbc.mrm.tools.me.expr.impl.RawExpr;

public class UnitTest {

	
	public static void main(String[] args) {
		Map<String,Object> a = new HashMap<String,Object>();
		List<Object> b = new ArrayList<Object>();
		b.add("abcde");
		Map<String,String> c = new HashMap<String,String>();
		c.put("aaa", "bbb");
		c.put("ccc", "ddd");
		b.add(c);
		List<String> d = new ArrayList<String>();
		d.add("eee");
		d.add("fff");
		b.add(d);
		String[] e = new String[]{"ggg","hhh"};
		b.add(e);
		a.put("data", b);
		Context.getInstance().setValue("p", a);
		
		String[] expr = new String[]{
			"3*-1-1+2",
			"-max(-1,-2)",
			"max(1,3,2)",
			"min(2,1,3)",
			"1+2*3+6/2",
			"sum(1,2)+sum(2,sum(3,4))*sum(sum(1,4),sum(2,1)*2)",
			"sum(1,2)",
			"(1+2)",
			"(1)",
			"((1))",
			"get(p.data[0])",
			"get(p.data[1].aaa)",
			"get(p.data[2][1])",
			"get(p.data[3][1])",
			"if(1>2,sum(1,5),max(7,8))",
			"if(1<2,sum(1,5),max(7,8))",
			"if(1>=2,sum(1,5),max(7,8))",
			"if(1<=2,sum(1,5),max(7,8))",
			"if(1==2,sum(1,5),max(7,8))",
			"if(1!=2,sum(1,5),max(7,8))",
			"if(1<>2,sum(1,5),max(7,8))",
			"round(1.14,1)",
			"round(1.15,1)",
			"round(1.16,1)",
			"1.23456*1.23456",
			"1E3+56"
		};
		
		String[] result = new String[]{
			"-2","1","3","1","10",			"102",			"3",
			"3",			"1",			"1",
			"abcde",			"bbb",			"fff",
			"hhh",
			"8","6","8","6","8","6","6",
			"1.1","1.2","1.2",
			"1.5241383936",
			"1056"
		};
		
		int i=0;
		int intOk=0,intFail=0;
		for(;i<expr.length;i++){
			String r = null;
			try{
				r = new RawExpr(expr[i]).evaluate();
			}catch(Exception ex){
				
			}
			if(check(r,result[i])){
				intOk++;
				System.out.println("OK        "+expr[i]+"="+r);
			}else{
				intFail++;
				System.out.println("FAIL      "+expr[i]+"="+r);
			}
		}
		System.out.println("OK Cases:"+intOk+"        ,FAIL Cases:"+intFail);
	}
	public static boolean check(String a,String b){
		try{
			if(Double.parseDouble(a) == Double.parseDouble(b)){
				return true;
			}else{
				return false;
			}
		}catch(NumberFormatException e){
			if(a.equals(b)){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
}
