<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<br/>
	<div>
		<h1>로그인</h1>
		<form action="/user/login" method="POST">
			아이디 : <input name="userid"/><br/>
			비밀번호 : <input name="userpw" type="password"/><br/>
			<button>로그인</button>
		</form>
	</div>
	<br/>
	<%@ include file="common/footer.jsp" %>
</body>
</html>