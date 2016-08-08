package com.icbc.mrm.tools.me.exception;

public class ExprFormatErrorException extends ExprException {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -8460797504732580642L;
	
	private String expr = null;
	
	public ExprFormatErrorException(String expr){
		this.expr = expr;
	}
	
	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("表达式格式错误:"+expr);		
		return sb.toString();
	}
}
