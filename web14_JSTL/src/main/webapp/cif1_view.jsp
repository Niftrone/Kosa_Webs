<!-- 
JSTL
1) jar파일 2개를 lib에 넣는다
2) taglib에 선언문이 필요

core 문법 중에서
if, for

if
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL if 사용 예</title>
</head>
<body>
<h2>jstl if 사용법</h2>

<c:if test="${param.NUM == '100'}">
	<h4>100만원이 입금되었습니다.</h4>
</c:if>

<c:if test="${param.NUM == '200'}">
	<h4>200만원이 입금되었습니다.</h4>
</c:if>

</body>
</html>