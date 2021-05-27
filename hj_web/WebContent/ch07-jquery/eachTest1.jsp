<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
 <script type="text/javascript">
  $(document).ready(function() {
	const array = [
		{name: 'Hanbit Media', link:'http://hanb.co.kr'},
		{name: 'naver', link:'http://naver.com'},
		{name: 'daum', link:'http://daum.net'}
	];
	$.each(array, function(index, item){
		let output = '';
		output += '<a href="'+ item.link + '">';
		output += '<h1>'+ item.name + '<h1>';
		output += '</a>';
		
		document.body.innerHTML += output;
	});
 });
 </script>
</body>
</html>