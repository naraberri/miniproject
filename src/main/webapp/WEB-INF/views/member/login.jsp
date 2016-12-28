<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>LOGIN PAGE</h1>
	<form id="f1" method="POST">
		<p>
			아이디: <input type='text' name='userid' id='userid'>
		</p>
		<p>
			패스워드: <input type='text' name='userpw' id='userpw'>
		</p>

	</form>

	<p>
		<button id="lBtn" type="submit">로그인</button>
	</p>

	<script src="https://code.jquery.com/jquery-2.2.4.js"
		integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
		crossorigin="anonymous"></script>
	<script>
		$(document).ready(function() {

			/* 	var moveSuccess = function(){ 
				self.locations = "list?page=1";
			}; */

			$('#lBtn').on("click", function() {

				$("#f1").attr("action", "login").submit();

			});

		});
	</script>

</body>
</html>