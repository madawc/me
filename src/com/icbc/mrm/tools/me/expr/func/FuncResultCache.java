package com.icbc.mrm.tools.me.expr.func;


import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

public class FuncResultCache {
	public static Logger LOG = Logger.getLogger(FuncResultCache.class);
	private static FuncResultCache INSTANCE = new FuncResultCache();
	
	private Map<String,String> cache = new ConcurrentHashMap<String,String>();
	private boolean cacheEnable = true;
	private int maxCacheSize = 200;
	
	public int getMaxCacheSize() {
		return maxCacheSize;
	}
	public void setMaxCacheSize(int maxCacheSize) {
		this.maxCacheSize = maxCacheSize;
	}
	public int getCurCacheSize() {
		return this.cache.size();
	}
	
	
	public boolean isCacheEnable() {
		return cacheEnable;
	}
	public void setCacheEnable(boolean cacheEnable) {
		this.cacheEnable = cacheEnable;
	}
	public static FuncResultCache getInstance(){
		return INSTANCE;
	}
	private FuncResultCache(){
	}
	
	private String creKey(String funcName,List<String> para){
		StringBuilder sb = new StringBuilder();
		sb.append(funcName);
		for(int i=0;i<para.size();i++){
			sb.append("&").append(para.get(i));
		}		
		return sb.toString();
	}
	
	public String getValue(String funcName,List<String> para){
		String ret = null;
		if(cacheEnable){
			String key = creKey(funcName,para);
			ret = cache.get(key);
		}
		return ret;
	}
	public void setValue(String funcName,List<String> para,String value){
		if(cacheEnable ){
			if(isFull()){
				//TODO:增加cache满后的清理机制,目前先清空,后续再实现LRU算法
				this.cache.clear();
				System.out.println("cache is full");
			}
			String key = creKey(funcName,para);
			this.cache.put(key,value);
		}
	}
	
	public boolean isFull(){
		return this.getCurCacheSize() == this.getMaxCacheSize();
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("当前ResultCache:");
		Iterator<String> it = this.cache.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			String value = this.cache.get(key);
			sb.append(key).append(":").append(value).append(",");
		}
		
		return sb.toString();
	}
	
}
