package com.xjtu.web.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
//将已经是乱码的参数,重新编码回中文
public class MyRequest extends  HttpServletRequestWrapper{
	
	private Map<String,String[]> params =new HashMap<String, String[]>();
	
	public MyRequest(HttpServletRequest request) {
		super(request);
	// 在构造中获得封装参数的map, 将map中所有乱码解决
	//-----------------------------------------------
		//1 获得map
		Map<String,String[]> map = super.getParameterMap();
		//2 遍历map
		if(map!=null && map.size()>0){
			for(Entry<String, String[]> en : map.entrySet()){
				//3 取出每个键值对,并解决值得乱码(逆推法)
				String[] values = en.getValue();
				if(values!=null){
				String[] newValues = new String[values.length];
					for(int i = 0; i < values.length ;i++){
						try {
							newValues[i] = new String(values[i].getBytes("ISO-8859-1"),"UTF-8");
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}
					//4 将解决的键值对 放入新的map
					params.put(en.getKey(), newValues);
					}
			}
		}
		
	}

	@Override
	public String getParameter(String name) {
		String[] values = params.get(name);
		
		if(values==null){//获得的参数键不存在
			return null;
		}
		
		return values[0];
	}
	@Override
	public Map<String,String[]> getParameterMap() {
		
		return params;
	}
	
	@Override
	public String[] getParameterValues(String name) {
		return params.get(name);
	}

	

}
