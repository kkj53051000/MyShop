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
	<div>
		<span><a href="/">MAIN</a></span>
		<span><a href="/products?category=ALL">ALL</a></span>
		<span><a href="/products?category=OUTER">OUTER</a></span>
		<span><a href="/products?category=TOP">TOP</a></span>
		<span><a href="/products?category=SHIRT">SHIRT</a></span>
		<span><a href="/products?category=PANTS">PANTS</a></span>
		<br/><br/><br/>
		
		
		
		<c:forEach var="product" items="${products}">
			<a href="/admin/p?id=${product.id}">제품번호 : ${product.id} 제품명 : ${product.name} 카테고리 : ${product.category} 가격 : ${product.price}</a><br/>
		</c:forEach>
		
		
		
		
		
	</div>
</body>
</html>