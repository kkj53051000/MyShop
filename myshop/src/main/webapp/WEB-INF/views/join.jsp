<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		.join_wrap{
			
			
		}
	</style>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<br>
	<div class="join_wrap">
		<h1>회원가입</h1>
		<form action="/user/join" method="POST">
			아이디 : <input name="userid"/><br>
			비밀번호 : <input name="userpw" type="password"/><br>
			닉네임 : <input name="nickname"/><br>
			이메일 : <input name="email"/><br>
			<button>회원가입</button>
		</form>
	</div>
	<br>
	<%@ include file="common/footer.jsp" %>
</body>
</html>