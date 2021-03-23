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
			border: 0px;
			background-color: white;
			
			font-weight: bold;
		}
		.pdom{
			display: inline-block;
			margin-right: 10px;
		}
		
		
		
		.addImg{
	        width: 100px;
	        height: 100px;
	        margin-right: 10px;
	
	        display: flex;
	        box-sizing: border-box;
	    }
	    #cancelBtn{
	        width: 100px;
	        height: 100px;
	
	        display: flex;
	        box-sizing: border-box;
	    }
	    .buttons{
	    	display: flex;
			flex-direction: row;
			
			
	    }
	    .orderBtn{
	    	border: 0px;
			background-color: white;
	    }
	    .cartBtn{
	    	border: 0px;
			background-color: white;
	    }
	    .review{
	    	width: 100%;
	    	display: flex;
			flex-direction: column;
			align-items: center;
	    }
	    .review_img{
	    	width: 100px;
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
					<h1>${product.name}</h1><br/>
				</div>
				<div class="product_info">
					<b>제품 설명</b>
					<p>${product.info}</p>
					<b>가격</b> <p>${product.price}</p>
				</div>
				<div class="product_order" data-price="${product.price}">
				<!-- <form action="/order" method="GET"> -->
					<select name="productinfo_id" id="info">
						<option class="choice" value="none">[필수]색상 사이즈 선택</option>
						<c:forEach var="info" items="${productinfo}">
							<!-- 추가가격 있을때 -->
							<c:if test="${info.add_price < 1}">
								<option class="choice" value="${info.id}" data-productid="${product.id}" data-addprice="${info.add_price}">${info.color} ${info.size}</option>
							</c:if>
							<!-- 추가가격 없을때 -->
				       		<c:if test="${info.add_price >= 1}">
								<option class="choice" value="${info.id}" data-productid="${product.id}" data-addprice="${info.add_price}">${info.color} ${info.size} (+ ${info.add_price} 원)</option>
							</c:if>
				        </c:forEach>
			    	</select>
			    	수량 : <input class="amount" name="amount" value="1"/>
					<br/><br/>
					<div class='result'></div>
					<div class='price'></div>
					<hr/>
					<div class="buttons">
						<button class="orderBtn"><img src="/public/upload/order.png" alt="."></button><br/>
						<!-- 장바구니 버튼 -->
						<button class="cartBtn"><img src="/public/upload/cart.png" alt="."></button>
						
					</div>
					
				<!-- </form> -->
				</div>
			</div>
		</div>
		
		
	</div>
	
	
	
	<div class="review">
		<div class="review_write">
			<h1>리뷰</h1>
			<div>
				<div class="imgList"></div>
				
				내용 : <input class="reviewcontent" name="content"/><br/>
				<input class = "imgUpload" name="img" type="file" multiple="multiple"/><br/>
				<input name="productid" type="hidden" value="${product.id}"/><br/>
				<button class="reviewBtn">작성</button>
				
			</div>
			<div>
				<h1>리뷰 목록</h1>
				<c:forEach var="review" items="${reviews}">
					<hr>
					<span>닉네임 : ${review.review.user.nickname} <br>내용 : ${review.review.content}</span><br>
					<c:forEach var="img" items="${review.reviewimgs}">
						<img class="review_img" src="${img.img_src}"/>
					</c:forEach>
					<br>
				</c:forEach>
				<hr>
			</div>
		</div>
	</div>
	
	<%@ include file="common/footer.jsp" %>
	
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>	
	<script>
		let pk = 0;
	
	  	let myList = [];
	  	let cartList = []
	  	let price = 0
	  	let count_pk = 0
	  	
	  	const priceDOM = document.createElement('h1')
		priceDOM.innerText = price + "원"
		document.querySelector('.price').appendChild(priceDOM)
		
		
	  	function update() {	  
	  	}
	  	
	  	document.querySelector("#info").addEventListener('change', function() {
	  		console.log("추가할때 pk", pk)
	  		pk++;
	  		
	  		
	  		const check = 0
	  		
	  		var productOrderDIV = document.querySelector(".product_order")
	  		var product_price = Number(productOrderDIV.getAttribute('data-price'))
	  		
	  		
	  		var product_id = document.querySelector("#info").value;
	  		var product = document.querySelector("#info")
	  		var pr_id = Number(product.options[product.selectedIndex].getAttribute('data-productid'));
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
	  			
	  			const cartTempList = {}
	  			
	  			cartTempList.productId = product_id
	  			cartTempList.amount = amount
	  			
	  			count_pk = count_pk + 1
	  			tempList.primary = count_pk
	  			
	  			
	  			myList.push(tempList)
	  			cartList.push(cartTempList)
	  			
	  			//alert(myList[0].primary)
	  			
	  			console.log(myList)
	  			
	  			
	  			let divDom = document.createElement('div')
	  			divDom.className = "domDiv" + count_pk
	  			divDom.id = myList[(myList.length-1)].primary
	  			
	  			//alert(pkID)
	  			
	  			document.querySelector('.result').appendChild(divDom)
	  			
	  			
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
	  			
	            document.querySelector('.domDiv' + count_pk).appendChild(pDOM)
	            document.querySelector('.domDiv' + count_pk).appendChild(cancelDOM)
	            document.querySelector('.domDiv' + count_pk).appendChild(brDOM)
	            
	            
	           	$(".price").empty();
	            document.querySelector('.price').appendChild(priceDOM)
	            
	            //삭제
	  			cancelDOM.addEventListener('click', function() {
	  				let resultDIV = document.querySelector(".result")
	  				let pkID = Number(divDom.getAttribute('id'))	  				
	  				
	  				resultDIV.removeChild(divDom)
	  				
	  				for (var i = 0; i < myList.length; i++){
	  					if(myList[i].primary === pkID){
	  						myList.splice(i, 1)
	  					}
	  				}
	  				
	  				
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
		
	  	
	  	// 카트 버튼
	  	document.querySelector(".cartBtn").addEventListener('click', function() {
	  		console.log(myList)
	  		
	  		$.ajax({
	  	        url: "http://localhost:8080/cart",
	  	        type: "POST",
	  	        dataType: "json",
	  	        contentType: "application/json",
	  	        data: JSON.stringify(cartList),
	  	        success: function(data) {
	  	        	alert("카트에 담았습니다.")
	  	        	location.href="/product?id=" + pr_id
	  	        },
	  	        error: function(jqXHR, textStatus, errorThrown) {
	  	            // 에러 로그는 아래처럼 확인해볼 수 있다. 
	  	            //alert("업로드 에러\ncode : " + jqXHR.status + "\nerror message : " + jqXHR.responseText);
	  	        }
		  	});
	  	
	  	})
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	const inputEl = document.querySelector('.imgUpload')
	
	    const fileList = []
	    //const imgList = []
	  	let imgList = new FormData();
	    let count = 0;
	
	    inputEl.addEventListener('change', (e) => {
	
	        for(let i = 0; i<e.target.files.length; i++){
	            const fileObject = {}
	            
	            
	            
	            //imgList.push(e.target.files[i])
	            imgList.append('files', e.target.files[i])
	            
	            fileObject.file = e.target.files[i]
	            fileObject.number = count
	
	            fileList.push(fileObject)
	            
	            var blobUrl = URL.createObjectURL(e.target.files[i])
	            
	            const buttonDOM = document.createElement('button')
	            buttonDOM.className = "cancel" + count
	            buttonDOM.dataset.number = count
	            
	            buttonDOM.id = "btnDOM"
	
	            document.querySelector('.imgList').appendChild(buttonDOM)
	
	            const imgDOM = document.createElement('img')
	            imgDOM.className = "addImg"
	            imgDOM.src = blobUrl
	
	            document.querySelector('.cancel' + count).appendChild(imgDOM)
	            
	            const imgListEl = document.querySelector(".imgList")
	
	
	
	            buttonDOM.addEventListener('click', (e) => {
	
	                console.log('.candel' + count, "삭제")
	                imgListEl.removeChild(buttonDOM)
	                
	                let buttonDomNumber = buttonDOM.dataset.number
	
	                console.log(buttonDomNumber)
	
	                for(let j=0; j < fileList.length; j++){
	                    
	                    if(fileList[j].number == buttonDomNumber){
	                        fileList.splice(j, 1)
	                    }
	                }
	                console.log(fileList)
	
	            })            
	
	            count++
	        }
	
	       
	       console.log("count : ", count)
	    })
	   	
	    
	    // 리뷰 ajax
	    document.querySelector(".reviewBtn").addEventListener('click', function() {
	    	
	    	const reviewContent = JSON.stringify(document.querySelector(".reviewcontent").value)
	    	
	    	console.log(imgList)
	    		  		
	  		$.ajax({
	  	        url: "http://localhost:8080/review/uplaod?id=" + ${product.id} + "&content=" + reviewContent,
	  	        type: "POST",
	  	     	enctype: 'multipart/form-data',
	  	     	processData : false,
	  	     	contentType: false,
	  	        data: imgList,
	  	        success: function(data) {
	  	        	location.href="/product?id=" + pr_id
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