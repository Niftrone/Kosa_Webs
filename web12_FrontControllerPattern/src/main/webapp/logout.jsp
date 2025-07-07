<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function logout() {
		alert("로그아웃 되었습니다");
	}
</script>
</head>
<!-- 
로그아웃 로직
1) user 를 찾아와서
2) user 가 있다면
3) 세션을 죽인다
 -->
<body onload="return logout()"><!-- 페이지 들어가자마자 팝업창 뜨게 -->
<%
	Member user = (Member) session.getAttribute("vo");
	if(user != null){ // 로그인 된 상태라면
		session.invalidate();
	}
%>
<h3><b>로그아웃 되었습니다.</b><br>
<a href="login.jsp">HOME</a></h3>
</body>
</html>