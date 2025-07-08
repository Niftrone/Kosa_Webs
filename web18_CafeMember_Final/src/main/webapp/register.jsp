<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h2{
		text-align: center;
		color: purple;
	}
	#wrap{
		margin-left: 220px;		
	}
</style>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(function(){
	$('#id').on('keyup', function(){
		let userId = $('#id').val();

		if(userId.length >= 4 && userId.length <= 8){
			// 길이 조건 충족: 메시지 초기화
			$('#resultView').html(""); // 이전 메시지 지우기

			$.ajax({
				type: 'post',
				url: 'idExist.do',
				data: { 'id': userId },
				success: function(data) {
					if (data.trim() == 'true') {
						$('#resultView').html("<h5><font color='crimson'>중복된 아이디</font></h5>");
					} else if (data == 'false') {
						$('#resultView').html("<h5><font color='blue'>사용가능</font></h5>");
					}
				},
				error: function() {
					$('#resultView').html("<h5><font color='crimson'>서버 오류</font></h5>");
				}
			});
		} else {
			// 길이 조건 미달 시 즉시 표시
			$('#resultView').html("<h5><font color='crimson'>4~8자리만 가능</font></h5>");
		}
	});
});
</script>
</head>
<body>
<h2>REGISTER MEMBER FORM</h2>
<div id="wrap">
	<form action="register.do" method="post">
	
		ID <input type="text" id="id" name="id" required="required">
		<span id="resultView"></span><br><br>
		PASS <input type="password" name="password" required="required"><br><br>
		NAME <input type="text" name="name"><br><br>
		ADDR <input type="text" name="address"><br><br>
		<input type="submit" value="REGISTER">		
	</form>
</div>
</body>
</html>