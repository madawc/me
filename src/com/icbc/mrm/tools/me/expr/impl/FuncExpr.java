package com.icbc.mrm.tools.me.expr.impl;

import java.util.ArrayList;
import java.util.List;

import com.icbc.mrm.tools.me.exception.ExprException;
import com.icbc.mrm.tools.me.expr.IExpr;
import com.icbc.mrm.tools.me.expr.func.FuncManager;
import com.icbc.mrm.tools.me.expr.func.FuncProxy;
import com.icbc.mrm.tools.me.expr.func.IFunc;


/**
 * 函数表达式
 *
 * @author		MAXJ
 * @version		initial
 */
public class FuncExpr implements IExpr {
	private String expr = null;
	public FuncExpr(String expr){
		this.expr = expr;
	}
	
	@Override
	public String evaluate() throws ExprException {
		
		String funcName = this.getFuncName();
		String ret = null;
		if("".equals(funcName)){
			String e = this.expr.substring(1,this.expr.length()-1);
			ret = new RawExpr(e).evaluate();
		}else{
			FuncManager fhm = FuncManager.getInstance();
			IFunc function = fhm.getHandler(funcName);
			ret = new FuncProxy(function).execute(this.getParaList());
		}
		
		return ret;
	}

	private String getFuncName(){
		int p = this.expr.indexOf("(");
		return this.expr.substring(0,p);
	}
	
	public List<String> getParaList() throws ExprException{
		List<String> para = new ArrayList<String>();
		int bracketCount = 0;
		int i=0;
		String parastr = this.expr.substring(
				this.expr.indexOf("(")+1,
				this.expr.length()-1);//去掉首尾括号,取出参数字符串
		//开始解析各个参数
		int begPos = 0;
		while(i<parastr.length()){
			char ch = parastr.charAt(i);
			switch(ch){
			case '(':
				bracketCount++;
				break;
			case ')':
				bracketCount--;
				break;
			case ',':
				if(bracketCount==0){
					String tmpExpr = parastr.substring(begPos,i);
					para.add(new RawExpr(tmpExpr).evaluate());
					begPos = i+1;
				}
				break;
			default:
				break;
			}
			i++;
		}
		para.add(new RawExpr(parastr.substring(begPos)).evaluate());
		return para;
	}
	
	@Override
	public String toString() {
		return this.expr;
	}
	
}
