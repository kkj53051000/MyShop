<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>주문내역</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
	<style>
		.wrap{
			width: 100%;
			display: flex;
			flex-direction: column;
			align-items: center;
			
			min-width: 1600px;
		}
		.order_table{
			width: 1600px;
		}
		.orderinfo_img{
			width: 100px;
			margin-right: 20px;
		}
		.orderinfo{
			display: flex;
			flex-direction: row;
			align-items: center;
		}
	</style>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div class="wrap">
		<div>
			<h1>주문내역</h1>
		</div>
		
		<div class="order_table">
		 	<c:forEach var="orderOne" items="${orderList}">
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">주문번호</th>
				      <th scope="col">상태</th>
				      <th scope="col">주문취소</th>
				    </tr>
				  </thead>
				  <tbody>
				  
				 
					    <tr>
					      <th scope="row">${orderOne.order.id}</th>
					      <td><c:if test="${orderOne.order.orderStatus == 'SUCCESS'}"><a href="/order/cancel?order_id=${orderOne.order.id}">결제완료</a></c:if><c:if test="${orderOne.order.orderStatus != 'SUCCESS'}">취소</c:if></td>
					      <td><c:if test="${orderOne.order.orderStatus == 'SUCCESS'}"><a href="/order/cancel?order_id=${orderOne.order.id}">주문취소</a></c:if><c:if test="${orderOne.order.orderStatus != 'SUCCESS'}">취소완료</c:if></td>
					    </tr>
				  
				  </tbody>
				</table>
				<c:forEach var="orderinfo" items="${orderOne.orderinfos}">
				<div class="orderinfo">
					<div>
						<img class="orderinfo_img" src="${orderinfo.productinfo.product.img_src}">
					</div>
					<div>
						<!-- 추가가격 부분 처리 해줘야함 -->
						상품명 : ${orderinfo.productinfo.product.name} <br>${orderinfo.productinfo.color} / ${orderinfo.productinfo.size} <br> 수량 : ${orderinfo.amount} <br><br>  ${orderinfo.productinfo.product.price}원 <br>
					</div>
				</div>
				</c:forEach>
			</c:forEach>
		</div>
		
	</div>
	<%@ include file="common/footer.jsp" %>
</body>
</html>