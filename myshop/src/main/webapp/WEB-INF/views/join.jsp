<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		.wrap{
			width: 100%;
			display: flex;
			flex-direction: column;
			align-items: center;
			
			min-width: 1600px;
		}
		input{
			margin: 20px;
			border-radius: 10px;
		}
		.joinBtn{
			margin-top: 10px;
		
			width: 175px;
			height: 50px;
			border: 0px;
			border-radius: 15px;
			color: white;
			background-color: black;
		}
	</style>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<br/>
	<div class="wrap">
		<div>
			<h1><b>Join</b></h1>
		</div>
		<div class="input">
			<form action="/user/join" method="POST">
				<input name="userid" placeholder="아이디"/><br>
				<input name="userpw" placeholder="비밀번호" type="password"/><br>
				<input name="nickname" placeholder="닉네임"/><br>
				<input name="email" placeholder="이메일"/><br>
				<button class="joinBtn">회원가입</button>
			</form>
		</div>
	</div><br/>
	<%@ include file="common/footer.jsp" %>
</body>
</html>