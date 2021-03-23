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
		<h1>주문 상세</h1>
		<c:forEach var="info" items="${orderinfos}">
			
			주문번호 : ${info.order.id} 상품명 : ${info.productinfo.product.name} 사이즈 : ${info.productinfo.size} 색상 : ${info.productinfo.color} 주문수량 : ${info.amount}<br>
		</c:forEach>
	</div>
	<%@ include file="common/footer.jsp" %>
</body>
</html>