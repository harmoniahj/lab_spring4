<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<% // 서블릿에서 EmpLogic.java -> EmpDao.java -> List<Map>
  // mav.addObject("empList", empList);
  // request.setAttribute("empList", empList); => forward방식
	List<Map<String, Object>> empList = (List<Map<String, Object>>)request.getAttribute("empList");
	out.print(empList);
	int size = 0;
	if(empList != null) {
		size = empList.size();
	}
	out.print("size : " + size);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 getEmpList
</body>
</html>