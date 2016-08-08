package com.icbc.mrm.tools.me.expr.func;


import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

public class FuncManager {
	public static Logger LOG = Logger.getLogger(FuncManager.class);
	private static FuncManager INSTANCE = new FuncManager();
	
	private Map<String,IFunc> handlers;
	
	public static FuncManager getInstance(){
		return FuncManager.INSTANCE;
	}
	private FuncManager(){
		this.handlers = new HashMap<String,IFunc>();
		loadHandlerConfig();
	};
	private void loadHandlerConfig(){
		String[] funcProp = {"/innerfunc.properties","/outerfunc.properties"};
		Properties prop = null;
		
		for(int i=0;i<funcProp.length;i++){
			prop=new Properties();
			try {
				InputStream is = getClass().getResourceAsStream(funcProp[i]);
				if(is!=null){
					prop.load(is);
					Iterator<Object> it = prop.keySet().iterator();
					while(it.hasNext()){
						String key = (String)it.next();
						String clazzName = prop.getProperty(key);
						try {
							Class<?> clazz = Class.forName(clazzName);
							IFunc handler = (IFunc)clazz.newInstance();
							this.registerHandler(key, handler);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else{
					LOG.info("没有outerfunc.properties");
				}
			} catch (Exception e) {
				LOG.error("加载"+funcProp[i]+"异常:"+e.getMessage());
			}
		}
	}
	
	public void registerHandler(String funcName,IFunc handler){
		
		this.handlers.put(funcName.toLowerCase(), handler);
	}
	
	public IFunc getHandler(String handlerName){
		//TODO:增加NULL的处理
		return this.handlers.get(handlerName.toLowerCase());
	}
}
