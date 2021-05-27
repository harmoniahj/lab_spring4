<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOM조작 실습 - 1</title>
</head>
<body>
<script>
/* 
 ajax - XXX.sp
 fetch - XXX.sp
 react - XXX.sp
 easyui - XXX.sp, XXX.json예시
  */
	window.onload = function(){
		let header = document.createElement("h1");
		let textNode = document.createTextNode("Hello DOM!!!");
		header.appendChild(textNode);
		document.body.appendChild(header);
	}
</script>
</body>
</html>