<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.List" %>    
<%@ page import="com.google.gson.Gson" %>    
<%
	List<Map<String,Object>> deptList = (List<Map<String,Object>>)request.getAttribute("dname");

	Gson g = new Gson();
	String imsi = g.toJson(deptList);
	out.println(imsi);		
%>    