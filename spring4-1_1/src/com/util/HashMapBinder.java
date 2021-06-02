package com.util;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class HashMapBinder {
	HttpServletRequest request = null;
	
	public HashMapBinder() {}
	
	public HashMapBinder(HttpServletRequest request) {
		this.request = request;
	}
	
	public void bind(Map<String, Object> target) {
		Enumeration en = request.getParameterNames();
	 // <input type="text" name="mem_id" />
		while(en.hasMoreElements()) { // true이면 무한루프!!
			String key = (String)en.nextElement();
			target.put("key", request.getParameter(key));
		}
	} // end of bind
}