<%@page import="servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Member vo = (Member)session.getAttribute("vo");
    String productName = (String)session.getAttribute("pvo");
    
    if(vo==null){
%>
	<h3>로그인부터 다시...</h3>
	<a href="login.html">LOGIN PAGE</a>
<%
    }
%>
<h2>결과를 출력합니다.</h2>
<h4>
ID <%= vo.getId() %><br>
NAME <%= vo.getName() %><br>
ProductName <%= productName  %>
</h4>
</body>
</html>














