<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<h1>UPDATE PAGE</h1>
<body>

	<style>
body {
	background-color: gray;
}

h1 {
	color: navy;
}

.fileDrop {
	width: 150px;
	height: 160px;
	border: 3px dotted blue;
}
</style>

	<form method="post">
		<input id='mnoHidden' type='hidden' name='mno' value="${vo.usermno}">
		<h1>사진</h1>
		<input type="hidden" name="fileupload" id="fileupload">
		<div class='fileDrop'>
			Drop Here
			<div class="uploadedList"></div>
		</div>
		<h1>이름</h1>
		<input type='text' name='username' value="${vo.username}"><br>
		<h1>패스워드</h1>
		<input type='text' name='userpw' value="${vo.userpw}">
		<h1>이메일</h1>
		<input type='text' name='email' value="${vo.email}">
		<button type="submit">완료</button>
		<br>
	</form>


	<script src="https://code.jquery.com/jquery-2.2.4.js"
		integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
		crossorigin="anonymous"></script>


	<script>
		$(document).ready(function() {
			var obj = $("#f1");

			$("#upBtn").on("click", function() {
				obj.attr("method", "post").submit();

			});

			var uploadedList = $(".uploadedList");
			$(".fileDrop").on("dragenter dragover", function(event) {
				event.preventDefault();
			});
			$(".fileDrop").on("drop", function(event) {
				event.preventDefault();
				var files = event.originalEvent.dataTransfer.files;
				var file = files[0];
				var formData = new FormData();
				$('.uploadedList').empty();
				formData.append("file", file);
				console.log(formData);

				$.ajax({
					url : "uploadFile",

					data : formData,
					dataType : 'text',
					type : "post",

					contentType : false,
					processData : false,
					success : function(data) {
						console.log(data);
						uploadedList.html("<img src=show?name=" + data + ">");

						$("#fileupload").val(data);

					}
				});
			});
		});
	</script>
</body>
</html>