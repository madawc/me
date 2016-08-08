package com.icbc.mrm.tools.me.oper;

import com.icbc.mrm.tools.me.exception.UndefinedOperException;
import com.icbc.mrm.tools.me.oper.impl.compare.EQOper;
import com.icbc.mrm.tools.me.oper.impl.compare.GEOper;
import com.icbc.mrm.tools.me.oper.impl.compare.GTOper;
import com.icbc.mrm.tools.me.oper.impl.compare.LEOper;
import com.icbc.mrm.tools.me.oper.impl.compare.LTOper;
import com.icbc.mrm.tools.me.oper.impl.compare.NEOper;
import com.icbc.mrm.tools.me.oper.impl.math.AddOper;
import com.icbc.mrm.tools.me.oper.impl.math.DivOper;
import com.icbc.mrm.tools.me.oper.impl.math.MulOper;
import com.icbc.mrm.tools.me.oper.impl.math.SubOper;

public class OperFactory {
	private static OperFactory INSTANCE = new OperFactory();
	private OperFactory(){
		
	};
	
	public static OperFactory getInstance(){
		return INSTANCE;
	}
	
	
	public AbstractOper build(String operType,String opLeft,String opRight) throws UndefinedOperException{
		AbstractOper oper = null;
		if("+".equals(operType)){
			oper = new AddOper();
		}else if("-".equals(operType)){
			oper = new SubOper();
		}else if("*".equals(operType)){
			oper = new MulOper();
		}else if("/".equals(operType)){
			oper = new DivOper();
		}else if("==".equals(operType)){
			oper = new EQOper();
		}else if(">=".equals(operType)){
			oper = new GEOper();
		}else if("<=".equals(operType)){
			oper = new LEOper();
		}else if(">".equals(operType)){
			oper = new GTOper();
		}else if("<".equals(operType)){
			oper = new LTOper();
		}else if("!=".equals(operType) || "<>".equals(operType)){
			oper = new NEOper();
		}else {
			throw new UndefinedOperException(operType);
		}
		
		oper.setOpLeft(opLeft);
		oper.setOpRight(opRight);
		return oper;
	}
}
