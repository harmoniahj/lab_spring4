<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.easyui.min.js"></script>
<style type="text/css">
 .high-light-0 {	background: pink;	}
 .high-light-1 {	background: yellow;	}
 .high-light-2 {	background: green;	}
 .high-light-3 {	background: cyan;	}
 .high-light-4 {	background: orange;	}
</style>
</head>
<body>
 <script>
  'use strict'
  $(document).ready(function() {
	$('h1').each(function(index, item) {
		$(this).addClass('high-light-' + index);
	})
 });
 </script>
 <h1>item0</h1>
 <h1>item1</h1>
 <h1>item2</h1>
 <h1>item3</h1>
 <h1>item4</h1>
</body>
</html>