<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>회원 검색(단순검색)</h2>
<form action="Front" method="post">
	<input type="hidden" name="command" value="find">
	조회ID <input type="text" name="id" required="required">
	<input type="submit" value="회원검색">
</form>
</body>
</html>