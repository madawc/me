package com.icbc.mrm.tools.me.expr.func;

import java.util.List;

import org.apache.log4j.Logger;

import com.icbc.mrm.tools.me.exception.ExprException;

public class FuncProxy  {
	public static Logger LOG = Logger.getLogger(FuncProxy.class);
	private IFunc obj = null;
	public FuncProxy(IFunc obj){
		this.obj = obj;
	}
	
	public String execute(List<String> paraList) throws ExprException{
		String ret = null;
		ret = getCacheValue(paraList);
		if(ret == null){			
			ret = obj.execute(paraList);
			setCacheValue(paraList,ret);
		}else{
			LOG.debug("从缓存中获取结果:"+this.obj.getClass().getSimpleName()+paraList);
		}
		return ret;
	}
	private String getCacheValue(List<String> paraList){
		String ret = null;
		if(isStableFunction()){
			ret = FuncResultCache.getInstance().getValue(
				this.obj.getClass().getSimpleName(), 
				paraList
			);
		}
		return ret;
	}
	private void setCacheValue(List<String> paraList, String value){
		if(isStableFunction()){
			FuncResultCache.getInstance().setValue(
				this.obj.getClass().getSimpleName(),
				paraList,
				value
			);
		}
	}
	
	private boolean isStableFunction(){
		if(this.obj instanceof IStableFunc){
			return true;
		}else{
			return false;
		}
	}
}
