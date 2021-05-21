<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>    
<%
	List<Map<String,Object>> empList = 
	(List<Map<String,Object>>)request.getAttribute("empList");
	int size = 0;
	if(empList!=null){
		size = empList.size();
	}
	out.print("전체 레코드 수는 "+size);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getEmpList.jsp[webapp]</title>
</head>
<body>
getEmpList.jsp 페이지 입니다.
</body>
</html>