<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//여기는 자바 땅 
	//확장자가 jsp이면 html과 java 코드가 공존 할 수 있다.
	//이것을 스크립틀릿이라고 한다.
	String insa = "안녕";
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	'use strict'
	let i = "<%=insa+" Hi!!!"%>";
	document.write(i);
</script>
</head>
<body>
<script>
	'use strict'
	let j = "<%=insa%>";
	document.write(j);
</script>
<!-- 여기는 html땅 -->
여기는 <p>html</p>땅 입니다.
</body>
</html>