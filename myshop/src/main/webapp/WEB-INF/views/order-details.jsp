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
		<h1>주문내역</h1>
		<c:forEach var="order" items="${orders}">
			주문번호 : ${order.id} <a href="/orderinfo?order_id=${order.id}">상세정보</a>
			<br/>
			
		</c:forEach>
		<!-- 
		<form action="/order/cancel" method="POST" style="display: inline-block;">
			<input type="hidden" name="productinfo_id" value="${order.product.id}"/>
			<input type="hidden" name="order_id" value="${order.id}"/>
			<button>주문 취소</button><br/>
		</form>
		 -->
			
		
	</div>
	<%@ include file="common/footer.jsp" %>
</body>
</html>