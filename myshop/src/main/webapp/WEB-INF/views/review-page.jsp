<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	img{
		height: 100px;
		width: 100px;
	}
</style>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div>
		<h1>리뷰</h1>
		제품명 : ${review.productinfo.product.name}<br/>
		<c:forEach var="img" items="${reviewimgs}">
			<img src="${img.img_src}">
		</c:forEach>
		<br/>내용 : ${review.content}<br/>
	</div>
	<%@ include file="common/footer.jsp" %>
</body>
</html>