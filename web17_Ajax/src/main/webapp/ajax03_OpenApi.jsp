<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script>
	$(function() {

		var printedIds = new Set(); //중복을 제거하기 위해 Set()을 사용한다.

		$("#serverSend").on('click', function() {
			//비동기 통신 연결
			$.ajax({
				//요청
				type : 'get',
				url : 'http://localhost:8080/weather.xml', //Root
				dataType : 'xml', //응답되는 데이터의 타입을 미리 지정
				//응답
				success : function(data) {
					let str = '';
					$(data).find('list').each(function(index, item) {
						let region = $(this).find('region').text();
						let wind = $(this).find('wind').text();
						let temp = $(this).find('temp').text();
						let rain = $(this).find('rain').text();
						
						if (!printedIds.has(region)) {
							printedIds.add(region);
							str += '<tr>';
							str += `<td> \${wind} </td>`;
							str += `<td> \${temp} </td>`;
							str += `<td> \${rain} </td>`;
							str += `<td> \${region} </td>`;
							str += '</tr>';
						}

					});
					$('tbody').append(str);
				}//callback
			});

		});
	});
</script>
</head>

<body>
	<div calss="container">
		<div class="jumbotron text-center">
			<h2>====== Open API Weather 데이터 가져오기 ======</h2>
		</div>

		<p>
			<a href="#" id="serverSend"><b>XML 데이터 요청하기</b></a>
		</p>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>wind</th>
					<th>temp</th>
					<th>rain</th>
					<th>region</th>
				</tr>
			</thead>
			<tbody>
				<!-- 이부분에 공공데이터 받아온 것을 삽입 -->
			</tbody>
		</table>
	</div>
</body>

</html>