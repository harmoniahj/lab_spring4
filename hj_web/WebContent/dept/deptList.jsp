<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 목록 페이지 입니다.</title>
<script type="text/javascript" src="/hj_web/js/jquery.min.js"></script>
</head>
<body>
내용
<script type="text/javascript">
	$( document ).ready(function() {
		console.log('ready호출:');
		$.ajax({
			  url: "http://localhost:9000/hj_web/dept/deptList.nhn?mode=json",
			  success: function( data ) {
			    console.log("data:"+data);
				let result = JSON.stringify(data);
				alert("result ==> "+result);
				let jsonDoc = JSON.parse(result);
				console.log(jsonDoc);
				for(let i=0;i<jsonDoc.length;i++){
					console.log(jsonDoc[i].deptno+", "+jsonDoc[i].dname+", "+jsonDoc[i].loc);
				}//////end of for
			  }////////end of success
		})/////////////end of ajax		
	});////////////////end of ready
</script>
</body>
</html>