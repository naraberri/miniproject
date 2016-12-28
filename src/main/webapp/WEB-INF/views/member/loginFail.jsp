<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>LOGIN FAIL</h1><br>
<h2>다시 로그인 해주세요</h2>
<h2>3초뒤에 로그인페이지로 이동합니다</h2>


	<script>
	setTimeout(function(){
		self.location="login";
	},3000);

	
	</script>

</body>
</html>