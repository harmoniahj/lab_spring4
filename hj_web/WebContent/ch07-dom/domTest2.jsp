<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOM조작[img] 실습 - 2</title>
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
		let img = document.createElement("img");//inline
		img.setAttribute('src','../images/lion.jpg');//상대경로, 절대경로
		img.setAttribute('width',500);//상대경로, 절대경로
		img.setAttribute('height',350);//상대경로, 절대경로
		
		document.body.appendChild(img);
	}
</script>
</body>
</html>