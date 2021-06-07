<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/commonUIglobal.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>삼항연산자</title>
  <script type="text/javascript">
  function test() {
      let age = prompt('당신의 나이는? ', 0);

      if("안녕") {
        document.write("성인");
      }
      else {
        document.write("미성년자");
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