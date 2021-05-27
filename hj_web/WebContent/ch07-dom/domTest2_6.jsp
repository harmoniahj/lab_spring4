<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOM조작[img] 실습 - 2-2</title>
<!-- 	<script type="text/javascript" src="/js/jquery.min.js" defer></script> -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js?1"></script>
	<script type="text/javascript" src="/js/jquery.easyui.min.js?23"></script>
	<style type="text/css">
		.high-light {
			background: yellow;
		}
	</style>
</head>
<body>
<script>
	'use strict'
	$.noConflict();
	const jq = jQuery;
	jq(document).ready(function(){
		jq('h1').removeClass('high-light');
	});
</script>
<h1>item - 0</h1>
<h1 class="high-light">item - 1</h1>
<h1>item - 2</h1>
<h1 class="high-light">item - 3</h1>
<h1>item - 4</h1>
</body>
</html>