<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align:center;">
<h1><%= request.getParameter("id") %> 님이 로그인 되었습니다!!!</h1>
<p><a href="#">도서 등록</a></p>
<p><a href="#">로그아웃</a></p>
</body>
</html>