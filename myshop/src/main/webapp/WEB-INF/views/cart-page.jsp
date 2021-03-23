<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<style>
		.wrap{
			width: 100%;
			display: flex;
			flex-direction: column;
			align-items: center;
			
			min-width: 1600px;
		}
		.cartImg{
			width: 100px;
			margin-right: 20px;
		}
		.cartDiv{
			display: flex;
			flex-direction: row;
			align-items: center;
		}
	</style>
<body>
	<%@ include file="common/header.jsp" %>
	<div class="wrap">
		<div>
			<h1>장바구니</h1><br/><br/>
		</div>
		<c:if test="${cartForms == null}">
			<span>장바구니 비어있음</span>
		</c:if>
		
		
		<c:if test="${cartForms != null}">
			
				<c:forEach var="cartForm" items="${cartForms}">
					<div class="cartDiv">
						<div>
							<img class="cartImg" src="${cartForm.product.img_src}">
						</div>
						<div>
							<span>상품명 : ${cartForm.product.name} </span> <br> <span> ${cartForm.productinfo.color} / 사이즈 : ${cartForm.productinfo.size} <br> 수량 ${cartForm.amount}</span>
						</div>
						<hr/>
					</div>
				</c:forEach>
			
		</c:if>
		
	</div>
	<%@ include file="common/footer.jsp" %>
</body>
</html>