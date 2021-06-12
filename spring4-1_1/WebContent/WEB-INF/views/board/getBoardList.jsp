<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
	StringBuilder path = new StringBuilder(request.getContextPath());
	path.append("/");
	List<Map<String,Object>> boardList = null;
	boardList = (List<Map<String,Object>>)request.getAttribute("boardList");
	int size = 0;
	
	if(boardList != null){
		size = boardList.size();
	}
	out.print("size:" + size);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록 [WEB-INF]</title>
<!-- jEasyUI 시작 -->
<link rel="stylesheet" type="text/css" href="<%=path.toString() %>themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path.toString() %>themes/icon.css"> 

<!-- jEasyUI JS 시작 -->
<script type="text/javascript" src="<%=path.toString() %>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path.toString() %>js/jquery.easyui.min.js"></script>   

<script type="text/javascript">
 function boardSel() {  
	 $('#dg_board').datagrid({
		 url:'./jsongetBoardList.sp4',
		 onLoadSuccess: function() {
			 alert("조회 호출 성공");
		 }
 	 });
 }
 
 function boardIns() {
		
 }
 
 function boardUpd() {
		
 }
 
 function boardDel() {
		
 }
</script>
</head>
<body>
 <script type="text/javascript">
	$(document).ready(function(){
		$('#dg_board').datagrid({
			columns:[[
				{field:'BM_NO', title:'글번호', width:100, align:'center'},
				{field:'BM_TITLE', title:'제목', width:200, align:'left'},
				{field:'BM_DATE', title:'작성일', width:150, align:'center'},
				{field:'BS_FILE', title:'첨부파일', width:245, align:'center'},
				{field:'BM_HIT', title:'조회수', width:100, align:'center'},
			]]
		});
		
		$('#btn_sel').bind('click', function() {
	        boardSel();
		});
		
		$('#btn_ins').bind('click', function() {
	        boardIns();
		});
		
		$('#btn_upd').bind('click', function() {
	        boardUpd();
		});
		
		$('#btn_del').bind('click', function() {
	        boardDel();
		});
	});
 </script>
	
 <table id="dg_board" class="easyui-datagrid" data-options="title:'게시판', toolbar:'#tb_board'" style="width:800px;height:350px">
  <thead>
   <tr>
	<th>글번호</th>
	<th>제목</th>
	<th>작성일</th>
	<th>첨부파일</th>
	<th>조회수</th>
   </tr>
  </thead>
 
  <tbody>
   <% 
   	if(size == 0) { // 조회결과 없을 때
   %>
   <tr>
    <th colspan="5"> 조회결과가 없습니다. </th>
   </tr>
   
   <%
   	} else { // 조회결과 있을 때
   		for(int i=0; i<size; i++) {
   			Map<String, Object> rmap = boardList.get(i);
   			if(i == size) break;
   %>
   <tr>
    <td><%=rmap.get("BM_NO") %></td>
    <td><a href="getBoardDetail.sp4?bm_no=<%=rmap.get("BM_NO")%>"><%=rmap.get("BM_TITLE") %></a></td>
    <td><%=rmap.get("BM_DATE") %></td>
    <td><%=rmap.get("BS_FILE") %></td>
    <td><%=rmap.get("BM_HIT") %></td>
   </tr>
  </tbody>
  <% }
   }	%>

 </table>
 
 <div id="tb_board" style="padding:2px 5px;">
  <a id="btn_sel" href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true">조회</a>
  <a id="btn_ins" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">입력</a>
  <a id="btn_upd" href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true">수정</a>
  <a id="btn_del" href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">삭제</a>
 </div> 
</body>
</html>