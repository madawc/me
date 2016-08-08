package com.icbc.mrm.tools.me;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class Context {
	public static Logger LOG = Logger.getLogger(Context.class);
	public static Pattern INT_REG = Pattern.compile("\\[\\d+\\]");
	private static Context INSTANCE = new Context();
	public static Context getInstance(){
		return INSTANCE;
	}
	private ThreadLocal<Map<String,Object>> ctx;
	
	public ThreadLocal<Map<String, Object>> getCtx() {
		return ctx;
	}

	public void setCtx(ThreadLocal<Map<String, Object>> ctx) {
		this.ctx = ctx;
	}

	private Context(){
		ctx = new ThreadLocal<Map<String,Object>>();
	}
	
	public Object getValue(String key){
		return g(key,ctx.get());
	}
	public void setValue(String key,Object value){
		if(this.ctx.get() == null){
			this.ctx.set(new HashMap<String,Object>());
		}
		this.ctx.get().put(key, value);
	}
	
	private Object g(String key,Map<String,Object> ctx){
		int p1 = key.lastIndexOf(".");
		int p2 = -1;
		if(p1==-1){
			p2 = key.indexOf("[");
			if(p2 == -1){
				return ctx.get(key);
			}else{
				String k = key.substring(0,p2);
				Matcher m = INT_REG.matcher(key);
				Object t = null;
				if(ctx instanceof Map){
					t = ((Map<String,Object>)ctx).get(k);
				}else{
					LOG.error("非Map对象");
					return null;
				}
				while(m.find()){
					int start = m.start();
					int end = m.end();
					int p = Integer.parseInt(key.substring(start+1,end-1));
					if(t instanceof List<?>){
						t=((List<?>)t).get(p);
					}else if(t instanceof Object[]){
						t=((Object[])t)[p];
					}else{
						LOG.error("非Array和List对象");
						return null;
					}
				}
				return t;
			}
		}else{
			String newKey = key.substring(p1+1);
			@SuppressWarnings("unchecked")
			Map<String,Object> newCtx = (Map<String,Object>)this.g(key.substring(0,p1),ctx);
			return this.g(newKey,newCtx);
		}
	}
	public void clear(){
		this.getCtx().get().clear();
	}
	
	public static void main(String[] args){
		
		Thread t = new Thread(){
			public void run(){
				Context ctx = Context.getInstance();
				System.out.println("1:"+ctx.getCtx().get());
				
				Context.getInstance().setValue("123", "444");
				
				System.out.println("2:"+ctx.getCtx().get());
				
				Context.getInstance().setValue("123", "444");
				
				System.out.println("3:"+ctx.getCtx().get());
				
			}
		};
		t.start();
	}
	
}
