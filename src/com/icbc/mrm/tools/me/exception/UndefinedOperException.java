package com.icbc.mrm.tools.me.exception;

public class UndefinedOperException extends ExprException {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -8103369968246620380L;
	private String op = null;

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public UndefinedOperException(String op) {
		super();
		this.op = op;
	}

	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("未定义的运算符:" + op);
		return sb.toString();
	}
}
