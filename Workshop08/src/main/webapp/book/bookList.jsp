<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
        h1 {
            text-align: center;
        }
        form {
            text-align: right;
            margin-right: 438px;
        }
        table {
            width: 800px;
            margin: 20px auto;
            text-align:center;
        }
        tr {
            height: 43px;
        }
        th{
            background: #ddd;
        }
        .center{
        	margin-left: 740px;
        	padding-top: 30px;
        }
        body{
        	text-align: center;
        }
    </style>
    <script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
    	$(function(){
    		$(".detail-link").on('mouseenter', function(e){
    	        const $this = $(this);
    	        const isbn = $this.data('isbn');

    	        // 이미 데이터가 로드된 경우 중복 요청 방지
    	        if ($this.data('loaded')) return;
    			
                $.ajax({
                    type:"get",
                    url:"${pageContext.request.contextPath}/front.do",
                    data: {
                        command: "detail",
                        isbn: isbn,
                    },
                    dataType: "Json",
                    success:function(book){
                            const html = `
                                <font color=crimson>
                                    Book 상세보기 출력 - 제목 : \${book.title}, 출판사 : \${book.publisher}, 저자 : \${book.author}
                                </font>
                            `
                            $('#detailResult').html(html);

                    },
                    error:function(){
                        alert("실패");
                    }
                })
    		})
    	})
    </script>
</head>
<body>
	<h1>도서 목록 화면</h1>
    <form action="${pageContext.request.contextPath}/front.do">
    	<input type="hidden" name="command" value="search">
        <select name="searchSelect">
            <option disabled selected>전체</option>
            <option value="title">도서명</option>
            <option value="catalogue">도서분류</option>
            <option value="author">저자</option>
        </select>
        <input type="text" name="searchText">
        <input type="submit" value="검색">
    </form>
    <c:choose>
        <c:when test="${empty list}">
            <h2>등록된 도서가 없습니다.</h2>
        </c:when>
        <c:otherwise>
            <table border="1">
                <tr>
                    <th>도서번호</th>
                    <th>도서명</th>
                    <th>도서분류</th>
                    <th>저자</th>
                </tr>
            
                <c:forEach items="${list}" var="book">
                    <tr>
                        <td>${book.isbn}</td>
                        <td><a href="#" class="detail-link" data-isbn="${book.isbn}">${book.title}</a></td>
                        <td>${book.catalogue}</td>
                        <td>${book.author}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>


    <div id="detailResult"></div>
    <div>
    <a href="./book/Book.html">도서 등록</a>
    <a href="${pageContext.request.contextPath}/front.do?command=bookList">도서 목록</a>
	</div>
</body>
</html>