<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<style>
.fileDrop {
	width: 150px;
	height: 160px;
	border: 3px dotted blue;
}

li {
	list-style: none;
}
</style>

	<form class="join" action="create" method="post"
		enctype="multipart/form-data">
		<input id="pageHidden" type="hidden" name="page" value="${param.page}">
		프로필 사진
		<li><input type="hidden" name="fileupload" id="fileupload"></li>
		<div class='fileDrop'>
			Drop Here
			<div class="uploadedList"></div>
		</div>
		아이디
		<li><input type="text" name="userid" id="userid"></li>
		패스워드
		<li><input type="text" name="userpw" id="userpw"></li>
		이름
		<li><input type="text" name="username" id="username"></li>
		이메일
		<li><input type="text" name="email" id="email"></li>

	</form>



	<button id="cBtn">등록</button>

	<script src="https://code.jquery.com/jquery-2.2.4.js"
		integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
		crossorigin="anonymous"></script>

	<script>
		$(document).ready(function() {
			$('#cBtn').on("click", function() {
				$('.join').submit();
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
