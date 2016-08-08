package com.icbc.mrm.tools.me.expr;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.icbc.mrm.tools.me.exception.ExprException;
import com.icbc.mrm.tools.me.exception.UndefinedOperException;

public class ExprHelper {
	//运算符
	public static final String[] OPER = new String[]{
		"==",">=","<=","<>","!=","+","-","*","/",">","<"
	};
	//运算符优先级
	public static final int[] OPER_PRI = new int[]{
		1,1,1,1,1,2,2,3,3,1,1
	};
	public static final Pattern OPER_REGEX = Pattern.compile("!=|<>|>=|<=|==|>|<|\\+|-|\\*|\\/");
	public static final Pattern NUMBER_REGEX = Pattern.compile("^(-?\\d+)(\\.\\d+)?([Ee][+-]?[0-9]{0,2})?$");
	public static final Pattern STRING_REGEX = Pattern.compile(OPER_REGEX + "|\\(|\\)");
	public static final Pattern FUNC_REGEX = Pattern.compile("[a-zA-Z0-9]*\\(.*\\)");
	
	public static boolean isFunction(String expr){
		if(FUNC_REGEX.matcher(expr).matches()){
			//判断括号匹配
			int pos = expr.indexOf("(")+1;
			int bracketCount = 1;
			while(pos <expr.length()){
				char ch = expr.charAt(pos);
				switch(ch){
				case '(':
					bracketCount ++;
					break;
				case ')':
					bracketCount --;
					break;
				default:
					break;
				}
				if(bracketCount == 0 && pos != expr.length()-1){
					return false;
				}
				pos++;
			}
			return true;
		}else{
			return false;
		}
	}
	public static boolean isConstant(String expr){
		if(isNumber(expr)){
			return true;
		}else{
			Matcher m = STRING_REGEX.matcher(expr);
			return !m.find();
		}
	}
	
	
	
	public static boolean isOperator(String op) {
		Matcher m = OPER_REGEX.matcher(op);
		return m.matches();
	}
	
	public static int getPriority(String op) throws ExprException {		
		for(int i =0;i<ExprHelper.OPER.length;i++){
			if(ExprHelper.OPER[i].equals(op)){
				return ExprHelper.OPER_PRI[i];
			}
		}
		throw new UndefinedOperException(op);
	}
	public static boolean isNumber(String s){		
		Matcher m = NUMBER_REGEX.matcher(s);
		return m.matches();
	}
	
	public static String double2String(double d){
		DecimalFormat df = new DecimalFormat("#.###############");
		return df.format(d);
	}
}
