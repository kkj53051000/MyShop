<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Header</title>
	<style>
		.header{
			margin: 10px;
			
			min-width: 1600px;
		}
		.header_top{
			display: flex;
			flex-direction: row;
			justify-content: space-between;
			
			color: #3c3c3c;
		}
		.header_center{
			display: flex;
			justify-content: center;
			margin-bottom: 5px;
			border-bottom: 1px solid black;
		}
		.header_center_img{
			height: 100px;
		}
		.header_left{
			
		}
		.header_right{
			
		}
		.header_footer{
		
			width: 100%;
			display: flex;
			justify-content: center;
			
			<!-- position: fixed; -->
 			
			
			color: #828282;
		}
		.header_footer > span{
			margin: 10px;
		}
		img{
			margin-bottom: 10px;
		}
		
		a:link {text-decoration:none; color: #828282;}
		a:visited {text-decoration:none; color: #828282;}
		a:hover {text-decoration:none; color: #828282;}
	</style>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
	<div class="header">
		<div class="header_top">
			<div class="header_left">
				<span><a href="/notice/list">공지</a></span>
				<span>큐엔에이</span>
			</div>
			<div class="header_right">
				<c:if test="${user.role == 'USER'}">
					<!-- user, admin Check -->
				</c:if>
				
				<c:if test="${user == null}">
					<span><a href="/join">회원가입</a></span>
					<span><a href="/login">로그인</a></span>
				</c:if>
				<c:if test="${user != null}">
					<strong>관리자</strong>
					<span><a href="/admin/product-list">제품상세등록</a></span>
					<span><a href="/product-upload">제품등록</a></span>
					<span><a href="/order/list">주문내역</a></span>
					<span><a href="##">카트</a></span>
					<span><a href="##">마이페이지</a></span>
					<span><a href="/user/logout">로그아웃</a></span>
				</c:if>
			</div>
		</div>
		<div class="header_center">
			<a href="/"><img class="header_center_img" src="/public/upload/logo.jpg"/></a>
		</div>
		<div class="header_footer">
			<span><a href="####" style="color: #ffc0cb;">BEST 100</a></span>
			<span><a href="/product/list?category=ALL">ALL</a></span>
			<span><a href="/product/list?category=OUTER">OUTER</a></span>
			<span><a href="/product/list?category=TOP">TOP</a></span>
			<span><a href="/product/list?category=SHIRT">SHIRT</a></span>
			<span><a href="/product/list?category=PANTS">PANTS</a></span>
		</div>
	</div>
</body>
</html>