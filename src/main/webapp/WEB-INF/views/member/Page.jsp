<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<h1>MEMBER PAGE</h1>
<style>

body {
    background-color: lightblue;
}

h1 {
    color: navy;
    text-align: center;
}
.page {
	list-style: none;
}

.paging li {
	list-style: none;
	float: left;
	margin: 0.5em;
	border: 1px solid black;
}

.paging .prev {
	background-color: red;
}

.paging .next {
	background-color: red;
}
</style>

<body>

	<form method="get" id="f1">
		<input id="pageHidden" type="hidden" name="page" value="${param.page}">
		<input id="mnoHidden" type="hidden" name="mno"> <select
			id="sType" name="sType">
			<option value="o" ${param.sType =="o"?"selected":"" }>--</option>
			<option value="i" ${param.sType =="i"?"selected":"" }>아이디</option>
			<option value="n" ${param.sType =="n"?"selected":"" }>이름</option>
			<option value="e" ${param.sType =="e"?"selected":"" }>이메일</option>
			<option value="j" ${param.sType =="j"?"selected":"" }>가입일</option>
			<option value="m" ${param.sType =="m"?"selected":"" }>회원번호</option>

		</select> <input type="text" name="keyword" id="keyword"
			value="${param.keyword }">
		<button id="sBtn">검색</button>
		<button id="jBtn">정렬하기</button>

	</form>

	<%-- <form method="get" id="f3">
		<input id="pageHidden" type="hidden" name="page" value="${param.page}">
		<input id="mnoHidden" type="hidden" name="mno"> <select
			id="sortType" name="sortType">
			<option value="o" ${param.sortType =="o"?"selected":"" }>--</option>
			<option value="i" ${param.sortType =="i"?"selected":"" }>아이디</option>
			<option value="n" ${param.sortType =="n"?"selected":"" }>이름</option>
			<option value="e" ${param.sortType =="e"?"selected":"" }>이메일</option>
			<option value="j" ${param.sortType =="j"?"selected":"" }>가입일</option>
			<option value="m" ${param.sortType =="m"?"selected":"" }>회원번호</option>
		</select>  <input type="hidden" name="keyword" id="keyword" value="${param.keyword }">
		<button id="jBtn">정렬하기</button>

	</form> --%>

	<ul class=page>
		<c:forEach items="${Page}" var="MemberVO">
			<li><a
				href="view?page=${param.page}&mno=${MemberVO.mno }
			&sType=${param.sType}&keyword=${param.keyword}">${MemberVO.mno}</a>&nbsp;&nbsp;&nbsp;
				<img src="show?name=${MemberVO.fileupload}">&nbsp;&nbsp;&nbsp;&nbsp;${MemberVO.userid}&nbsp;&nbsp;&nbsp;
				${MemberVO.username}&nbsp;&nbsp;&nbsp;
				${MemberVO.email}&nbsp;&nbsp;&nbsp;<fmt:formatDate value="${MemberVO.joindate}" 
				pattern="yyyy-MM-dd HH:mm:ss"/></li>
		</c:forEach>
	</ul>

	<ul class="paging">


		<c:if test="${pageMaker.prev}">
			<li class="prev">${ pageMaker.prev == true? pageMaker.start -1 :""}</li>
		</c:if>

		<c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="idx">
			<li>${idx}</li>
		</c:forEach>

		<c:if test="${pageMaker.next && pageMaker.end >0}">
			<li class="next">${ pageMaker.next == true? pageMaker.end + 1 :""}</li>
		</c:if>


	</ul>

	<form id="f2" action="pageSearch" method="get">
		<input type="hidden" name="page" value="1">
	</form>

	<form id="f3" method="post"></form>

	<button id="listBtn">목록가기</button>
	<button id="cBtn">회원추가</button>
	<button class="outBtn">로그 아웃</button>
	<script src="https://code.jquery.com/jquery-2.2.4.js"
		integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
		crossorigin="anonymous"></script>

	<script>
		var result = '${msg}';

		if (result == 'success') {
			alert("성공");
		}
	</script>

<!-- 	<script>
		var msg = '${param.msg}'
		if (msg == 's') {
			alert("성공");
		}
	</script> -->


	<script>
		$(document).ready(function() {

			$("#sBtn").on("click", function(event) {

				event.preventDefault();
				$("#pageHidden").val(1);
				$("#f1").attr("action", "pageSearch").submit();

			});

			$("#jBtn").on("click", function(event) {

				event.preventDefault();
				$("#pageHidden").val(1);
				$("#f1").attr("action", "sortCondition").submit();

			});

			$("#listBtn").on("click", function() {
				$("#f2").attr("action", "Page").submit();
			});

			$("#cBtn").on("click", function() {
				$("#f1").attr("action", "create").submit();
			});

			$('.outBtn').on("click", function(event) {

				$('#f3').attr("action", "logout").submit();

			});

			$(".paging li").on("click", function(event) {

				var obj = $(event.target);

				$("#pageHidden").val(obj.html());

				$("#f1").submit();

			});

			$(".list li a").on("click", function(event) {
				event.preventDefault();
				var mno = $(this).attr("href");
				console.log(mno);
				$("#mnoHidden").val(mno);
				$("#f1").attr("action", "view").submit();

			});

		});
	</script>

</body>
</html>