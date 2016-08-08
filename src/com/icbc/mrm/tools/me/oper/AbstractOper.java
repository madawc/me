package com.icbc.mrm.tools.me.oper;



import com.icbc.mrm.tools.me.exception.ExprException;

public abstract class AbstractOper {
	private String opLeft;
	private String opRight;
	
	public String getOpLeft() {
		return opLeft;
	}
	public void setOpLeft(String opLeft) {
		this.opLeft = opLeft;
	}
	public String getOpRight() {
		return opRight;
	}
	public void setOpRight(String opRight) {
		this.opRight = opRight;
	}
	
	
	public abstract String execute() throws ExprException;
	
}
