package com.icbc.mrm.tools.me.compiler.impl.rpn;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;

import org.apache.log4j.Logger;


import com.icbc.mrm.tools.me.compiler.ICompiler;
import com.icbc.mrm.tools.me.exception.ExprException;
import com.icbc.mrm.tools.me.exception.ExprFormatErrorException;
import com.icbc.mrm.tools.me.expr.ExprHelper;
import com.icbc.mrm.tools.me.expr.IExpr;
import com.icbc.mrm.tools.me.expr.impl.OperExpr;
import com.icbc.mrm.tools.me.expr.impl.RPNExpr;
import com.icbc.mrm.tools.me.expr.impl.RawExpr;

/**
 * 逆波兰表达式编译器
 *
 * @author		MAXJ
 * @version		initial
 */
public class RPNCompiler implements ICompiler {
	public static final Logger LOG = Logger.getLogger(RPNCompiler.class);
	
	public static final String END_OP = "0";
	
	
	@Override
	public IExpr compile(String expr) throws ExprException {
		RPNExpr rpn = new RPNExpr();
		Stack<String> opStk = new Stack<String>();
		opStk.push(END_OP);
		int i = 0;
		
		int begPos=0;
		List<String> exprList = tokenized(expr);
		while (i < exprList.size()) {
			String t = exprList.get(i);
			if (ExprHelper.isOperator(t) ) {
				//将操作符前的操作数压入RPN表达式队列：
				String preExpr = exprList.get(i-1);				
				rpn.addExpr(new RawExpr(preExpr));
				
				/*
				 * 如果是操作符，和opStack栈顶操作符比较 如果栈顶操作符优先级大于当前操作符
				 * 依次出栈，直到栈顶操作符优先级小于当前运算符 否则当前操作符入栈
				 */
				boolean flag = true;
				while (flag) {
					String topOp = opStk.peek();
					if(END_OP.equals(topOp) || checkPriority(topOp, t) < 0){						
						opStk.push(t);
						flag = false;
					} else {
						rpn.addExpr(new OperExpr(opStk.pop()));
					}
				}
				begPos = i+1;
			}
			i += 1;
		}
		if(begPos!=exprList.size()){
			rpn.addExpr(new RawExpr(exprList.get(i-1)));
		}
		while (!END_OP.equals(opStk.peek())) {
			rpn.addExpr(new OperExpr(opStk.pop()));
		}
		if(rpn.getRPNSize() == 1){
			IExpr tExpr = rpn.getExpr().get(0);
			if(!ExprHelper.isFunction(tExpr.toString()) && !ExprHelper.isConstant(tExpr.toString())){
				throw new ExprFormatErrorException(expr);
			}
		}
		return rpn;
	}
	
	private int checkPriority(String op1, String op2) throws ExprException {
		int ret = 0;
		int pri1 = 1, pri2 = 1;
		pri1 = ExprHelper.getPriority(op1);
		pri2 = ExprHelper.getPriority(op2);
		ret = pri1 - pri2;
		return ret;
	}
	
	public List<String> tokenized(String expr){
		Matcher m = ExprHelper.OPER_REGEX.matcher(expr);
		List<String> ret = new ArrayList<String>();
		int start=0,end=0;
		String e1="" ,op="",e2;
		while(m.find(end)){
			start = m.start();
			e1 += expr.substring(end,start);
			end = m.end();
			op = expr.substring(start,end);
			if(countBracket(e1) == 0){
				if(!"".equals(e1)){
					ret.add(e1);
					e1="";
				}
				ret.add(op);
			}else{
				e1+=op;
			}
		}
		e2 = expr.substring(end);
		if(!"".equals(e1+e2)){
			ret.add(e1+e2);
		}
		/*
		 * 区分减号和负号
		 * 
		 */
		for(int i = 0 ;i<ret.size();i++){
			if(ret.get(i).equals("-")){
				if(i==0 || ExprHelper.isOperator(ret.get(i-1))){
					ret.set(i, "(0-"+ret.get(i+1)+")");
					ret.remove(i+1);
				}
			}
		}
		LOG.debug("RPCompiler.split:"+ret);
		return ret;
	}
	
	private int countBracket(String s){
		int n = 0;
		for(int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			if(ch=='('){
				n++;
			}else if(ch == ')'){
				n--;
			}
		}
		return n;
	}
	
	public static void main(String[] args) throws Exception{
		String a = "sum(1,2)+sum(1,2)";
		long beg = System.currentTimeMillis();
		for(int i=0;i<100000;i++){
			new RPNCompiler().compile(a);
		}
		long end = System.currentTimeMillis();
		System.out.println((end - beg)/100000.0);
		
		beg = System.currentTimeMillis();
		for(int i=0;i<100000;i++){
			new RawExpr(a).evaluate();
		}
		end = System.currentTimeMillis();
		System.out.println((end - beg)/100000.0);
	}

}
