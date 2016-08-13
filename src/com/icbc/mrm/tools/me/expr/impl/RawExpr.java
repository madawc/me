package com.icbc.mrm.tools.me.expr.impl;

import com.icbc.mrm.tools.me.compiler.impl.rpn.RPNCompiler;
import com.icbc.mrm.tools.me.exception.ExprException;
import com.icbc.mrm.tools.me.expr.ExprHelper;
import com.icbc.mrm.tools.me.expr.IExpr;
import com.icbc.mrm.tools.me.expr.func.FuncResultCache;


/**
 * 未经过分析的原始表达式
 *
 * @author		MAXJ
 * @version		initial
 */
public class RawExpr implements IExpr {
	private String expr = null;
	
	
	public RawExpr(String expr){
		//过滤掉白字符
		this.expr = expr.replaceAll("\\s", "");
	}
	@Override
	public String evaluate() throws ExprException {
		IExpr t = null;
		if(ExprHelper.isFunction(expr)){
			t = new FuncExpr(expr);
		}else if(ExprHelper.isConstant(expr)){
			t = new ConstExpr(this.expr);			
		}else{
			t = new RPNCompiler().compile(this.expr);
			
		}
		return t.evaluate();
	}
	
	
	
	@Override
	public String toString(){
		return this.expr;
	}
	public static void main(String[] args) throws Exception{
		
		String[] expr = new String[]{
				
				"sum(1,max(3,2))+3*9",
				"sum(1,max(3,2))",
				"max(1,max(max(5,6),3))",
				"(1+2)*(3+4)/(1+(2+3)+4)",
				"sum(1,sum(1,sum(1,sum(1,sum(1,sum(1,1))))))",
				"sum(1,2)",
				"sum(1,2)+sum(1,2)",
				"sum(1,2)+sum(1,2)+sum(1,2)",
				"sum(1,2)+sum(1,2)+sum(1,2)+sum(1,2)",
				"sum(1,2)+sum(1,2)+sum(1,2)+sum(1,2)+sum(1,2)"
		}; 
		for(int i=0;i<expr.length;i++){
			long starttime = System.currentTimeMillis();
			long j=0;
			String result = null;
			long max=10000;
			while(j<max){
				RawExpr re = new RawExpr(expr[i]);
				result = re.evaluate();
				j+=1;
			}
			System.out.println(expr[i]+"="+result+"    耗时:"+((System.currentTimeMillis()-starttime)/(double)max)+"ms");
		}
		System.out.println(FuncResultCache.getInstance().getCurCacheSize());
		
	}
}
