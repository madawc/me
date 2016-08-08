package com.icbc.mrm.tools.me.exception;

public class InvalidOprandException extends ExprException {
	public static final String TYPE_STRING = "文本";
	public static final String TYPE_DOUBLE = "数字";
	public static final String TYPE_INT = "整数";
	
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -3513251232296681620L;

	private String oprand;
	private String type;
	public String getOprand() {
		return oprand;
	}
	public void setOprand(String oprand) {
		this.oprand = oprand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public InvalidOprandException(String oprand, String type) {
		super();
		this.oprand = oprand;
		this.type = type;
	}
	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("操作数不是"+type+"类型:"+oprand);
		
		return sb.toString();
	}
}
