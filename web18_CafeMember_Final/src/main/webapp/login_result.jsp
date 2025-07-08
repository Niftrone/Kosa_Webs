<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${vo!=null}">
		 <h3>Login Information</h3>
		 ID : ${vo.id}<br>
		 NAME : ${vo.name}<br>
		 ADDRESS : ${vo.address}<br><br>
		 <hr>
		 <h3><a href="logout.jsp"><b>Log Out</b></a></h3>
		 <h3><a href="index.jsp"><b>INDEX</b></a></h3>	
	</c:when>
	<c:otherwise>
		<h3>로그인부터 다시 진행하세요.</h3>
 		<h3><a href="index.jsp">INDEX</a></h3>	
	</c:otherwise>
</c:choose>
</body>
</html>












