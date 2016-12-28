<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<h1>VIEW PAGE</h1>

<style>

body {
    background-color: gray;
}

h1 {
	color: navy;
	text-align: center;
}

h2 {
	color: purple;
	text-align: center;
}
</style>

<body>
	<h1><img src="show?name=${read.fileupload}"></h1>
	<h1>회원번호 : ${read.mno}</h1>
	<h1>아이디 : ${read.userid}</h1>
	<h1>이름 : ${read.username}</h1>
	<h1>이메일 : ${read.email}</h1>
	<h2>가입날짜</h2>
	<p>
	<h2>
		<fmt:formatDate value="${read.joindate}" pattern="yyyy-MM-dd HH:mm:ss" />
	</h2>


	<button id="listBtn">목록가기</button>
	<button id="modBtn">수정</button>
	<button id="delBtn">삭제</button>

	<form action="read" id="f1" method="post">
		<input type="hidden" name="page" value="${param.page}"> <input
			type="hidden" name="mno" value="${read.mno}">

	</form>
	<script src="https://code.jquery.com/jquery-2.2.4.js"
		integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
		crossorigin="anonymous"></script>



	<script>
		$(document).ready(
				function() {

					var obj = $("#f1");

					$("#listBtn").on(
							"click",
							function() {

								obj.attr("action", "Page?page=1").submit()
										.attr("method", "get").submit();

							});//목록가기버튼

					$("#modBtn").on(
							"click",
							function() {

								obj.attr("action", "update").attr("method",
										"get").submit();

							});//수정버튼

					$("#delBtn").on(
							"click",
							function() {
								obj.attr("action", "delete").attr("method",
										"post").submit();
							});//삭제버튼

				});//목록부분 end
	</script>
</body>
</html>