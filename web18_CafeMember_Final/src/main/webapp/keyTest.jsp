<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
$(function(){
	$("#id").on("keyup",function(){
		let id = $("#id").val();
		console.log(id);
	})
});

</script>
</head>
<body>
<h2>Key Event</h2>
ID <input type="text" id="id"><br>
</body>
</html>