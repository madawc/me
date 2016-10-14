package com.icbc.mrm.tools.me;

import com.icbc.mrm.tools.me.ExprEvaluator.Algorithm;
import com.icbc.mrm.tools.me.exception.ExprException;

public class UnsupportedAlgorithmException extends ExprException {
	
	private static final long serialVersionUID = -2631312334021280725L;
	private Algorithm algo;
	public UnsupportedAlgorithmException(Algorithm algo){
		this.algo = algo;
	}
	@Override
	public String getMessage() {
		return "Unsupported Algorithm:"+algo;
	}
	
	
}
