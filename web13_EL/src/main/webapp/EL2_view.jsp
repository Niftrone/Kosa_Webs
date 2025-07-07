<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 로 폼값 받아오기</title>
</head>
<body>
<b>1. 이전 방식으로 폼값 받아서 출력하기</b>
ID <%= request.getParameter("myId") %> <br>

<%
	String[] menus = request.getParameterValues("menu");
	for(String menu : menus){
%>
		<li><%= menu %> </li>
<%
	}
%>


<b>2. EL 방식으로 폼값 받아오기</b>
1) ID ${param.myId } <br>

2) Menus :
${paramValues.menu[0]}
${paramValues.menu[1]}
${paramValues.menu[2]}
${paramValues.menu[3]}




</body>
</html>