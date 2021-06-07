<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/commonUIglobal.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>switch문</title>
  <script type="text/javascript">
    function test() {
      let site = prompt('당신이 즐겨찾는 사이트는 ? ', 0);
      let url;
      
      switch (site) {
        case "네이버":
          url= "www.naver.com"; 
          break;
        case "다음":
            url= "www.daum.net"; 
          break;
        case "구글":
            url= "www.google.com"; 
          break;
        } // end of switch문
      
      if(url) {
    	  location.href = "http://" + url; //  switch문에서 지정해둔 url로 이동
      }
    }
  </script>
</head>
<body>
  여기
  <br>
  <script type="text/javascript">test();</script>
  저기
</body>
</html>