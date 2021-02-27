<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		.product_wrap{
			height: 1000px;
			width: 100%;
			
			display: flex;
			flex-direction: row;
			
			min-width: 1600px;
		}
		.product_top{
			width: 100%;
			margin-top: 50px;
			
			display: flex;
			flex-direction: row;
			justify-content: center;
		}
		.prdout_img{
			height: 700px;
			width: 600px;
		}
		.product_data{
			margin-left: 100px;
		}
		.cancel_button{
			
		}
		.pdom{
			display: inline-block;
			margin-right: 10px;
		}
	</style>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div class="product_wrap">
		<div class="product_top">
			<div>
				<img class="prdout_img" src="${product.img_src}"/>
			</div>
			<div class="product_data">
				<div class="product_name">
					<h1>${product.name}</h1>
				</div>
				<div class="product_info">
					<p>제품 설명</p>
					<p>${product.info}</p>
					<b>가격</b> <p>${product.price}</p>
				</div>
				<div class="product_order" data-price="${product.price}">
				<!-- <form action="/order" method="GET"> -->
					<select name="productinfo_id" id="info">
						<option class="choice" value="none">[필수]색상 사이즈 선택</option>
						<c:forEach var="info" items="${productinfo}">
							<c:if test="${info.add_price < 1}">
								<option class="choice" value="${info.id}" data-productid="${product.id}" data-addprice="${info.add_price}">색상 : ${info.color} 사이즈 : ${info.size}</option>
							</c:if>
				       		<c:if test="${info.add_price >= 1}">
								<option class="choice" value="${info.id}" data-productid="${product.id}" data-addprice="${info.add_price}">색상 : ${info.color} 사이즈 : ${info.size} (+ ${info.add_price} 원)</option>
							</c:if>
				        </c:forEach>
			    	</select>
			    	수량 : <input class="amount" name="amount" value="1"/>
					<br/><br/>
					<div class='result'></div>
					<div class='price'></div>
					<button class="orderBtn">구매하기</button>
				<!-- </form> -->
				</div>
			</div>
		</div>
		
		
	</div>
	<div>
		<h1>리뷰</h1>
		<%@ include file="review-upload.jsp" %>
	</div>
	
	<%@ include file="common/footer.jsp" %>
	
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>	
	<script>
	  	const myList = [];
	  	var price = 0
	  	
	  	const priceDOM = document.createElement('h1')
		priceDOM.innerText = price + "원"
		document.querySelector('.price').appendChild(priceDOM)
		
		
	  	function update() {	  
	  	}
	  	
	  	document.querySelector("#info").addEventListener('change', function() {
	  		
	  		
	  		
	  		const check = 0
	  		
	  		var productOrderDIV = document.querySelector(".product_order")
	  		var product_price = Number(productOrderDIV.getAttribute('data-price'))
	  		
	  		
	  		var product_id = document.querySelector("#info").value;
	  		var product = document.querySelector("#info")
	  		var pr_id = product.options[product.selectedIndex].getAttribute('data-productid');
	  		var pr_addPrice = Number(product.options[product.selectedIndex].getAttribute('data-addprice'));
	  		var product_text = product.options[product.selectedIndex].text
	  		var amount = document.querySelector(".amount").value;
	  		

	  		var priceDIV = document.querySelector(".price")
	  		
	  		
	  		
	  		if(myList.length >= 1){
	  			for(var i in myList){
		  			
		  			//alert('키 값 : ' + i + ', 속성 값 :'  + myList[i].productId)
		  			
		  			if(myList[i].productId  == product_id){
		  				alert("이미 선택된 상품 입니다.")
		  				check = 1
		  			}
		  			
		  		}
	  			
	  		}
	  		
	  		
	  		if(product_id !== 'none' && check == 0){
	  			const tempList = {};
	  			
	  			tempList.productId = product_id
	  			tempList.amount = amount
	  			
	  			myList.push(tempList)
	  			
	  			console.log(myList)
	  			
	  			
	  			
	  			const brDOM = document.createElement('br')
	  			
	  			const pDOM = document.createElement('p')
	  			pDOM.innerText = product_text + " | 수량 : " + amount;
	  			pDOM.className = 'pdom'
	  			
	  			const cancelDOM = document.createElement('button')
			   
	  			cancelDOM.innerText = "삭제"
	  			cancelDOM.className = 'cancel_button'
	  			cancelDOM.id = myList.length - 1
	  			
	  			
	  			
	  			price = price + product_price
	  			console.log(price)
	  			//추가 가격 부분
		  		if(pr_addPrice >= 1){
		  			price += pr_addPrice
		  		}
	  			
	  			priceDOM.innerText = price + "원"
	  			
	            document.querySelector('.result').appendChild(pDOM)
	            document.querySelector('.result').appendChild(cancelDOM)
	            document.querySelector('.result').appendChild(brDOM)
	            
	           	$(".price").empty();
	            document.querySelector('.price').appendChild(priceDOM)
	            
	            
	  			cancelDOM.addEventListener('click', function() {
	  				var resultDIV = document.querySelector(".result")
	  				var cancelID = Number(cancelDOM.getAttribute('id'))
	  				
	  				resultDIV.removeChild(cancelDOM)
	  				resultDIV.removeChild(pDOM)
	  				resultDIV.removeChild(brDOM)
	  				
	  				myList.splice(cancelID, 1)
	  				console.log(myList)
	  				
	  				price = price - product_price
	  				//추가 가격 부분
			  		if(pr_addPrice >= 1){
			  			price -= pr_addPrice
			  		}
	  				priceDOM.innerText = price + "원"
	  				$(".price").empty();
	           		document.querySelector('.price').appendChild(priceDOM)
	  				
	  			})
	  		}
	  	})
	  	
	  	
	  	document.querySelector(".orderBtn").addEventListener('click', function() {
	  		console.log(myList)
	  		
	  		$.ajax({
	  	        url: "http://localhost:8080/order",
	  	        type: "POST",
	  	        dataType: "json",
	  	        contentType: "application/json",
	  	        data: JSON.stringify(myList),
	  	        success: function(data) {
	  	        	 window.location.href("/product?id=" + pr_id);
	  	        },
	  	        error: function(jqXHR, textStatus, errorThrown) {
	  	            // 에러 로그는 아래처럼 확인해볼 수 있다. 
	  	            //alert("업로드 에러\ncode : " + jqXHR.status + "\nerror message : " + jqXHR.responseText);
	  	        }
		  	});
	  	
	  	})
		
	  	</script>
</body>
</html>