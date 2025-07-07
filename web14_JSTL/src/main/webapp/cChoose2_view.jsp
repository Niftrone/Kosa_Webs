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
<h2>Choose문법 사용하기 :: 1) 나머지 모든 조건을 충족 | 2) 양자택일 (로그인 | 로그인 안한 경우)</h2>

<c:choose>
	<c:when test="${param.NUM == '100'}">
		<h4>100만원이 입금되었습니다.</h4>
	</c:when>
	<c:when test="${param.NUM == '200'}">
		<h4>200만원이 입금되었습니다.</h4>
	</c:when>
	
	<c:otherwise>
		<h4>입금액을 확인하십시오.</h4>
	</c:otherwise>
</c:choose>
</body>
</html>