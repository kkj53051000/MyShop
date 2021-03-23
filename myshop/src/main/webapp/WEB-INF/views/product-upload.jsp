<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상품 등록</title>
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
	<style>
		.wrap{
			width: 100%;
			display: flex;
			flex-direction: column;
			align-items: center;
			
			min-width: 1600px;
		}
	</style>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<br>
	<div class="wrap">
		<div>
			<h1>상품 등록</h1>
		</div>
		<div>
			<form action="/product/upload" method="POST" enctype="multipart/form-data">
				<div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">제품명</label>
				  <input class="form-control" name="name" placeholder="ex) 맨투맨">
				</div>
				카테고리
				<SELECT name="category" size=1 class="form-select" aria-label="Default select example">
			        <OPTION VALUE="OUTER" SELECTED>OUTER</OPTION>
			        <OPTION VALUE="TOP">TOP</OPTION>
			        <OPTION VALUE="SHIRT">SHIRT</OPTION>
			        <OPTION VALUE="PANTS">PANTS</OPTION>
			    </SELECT><br/>
			   	<div class="mb-3">
				  <label for="exampleFormControlTextarea1" class="form-label">상품 설명</label>
				  <textarea class="form-control" name="info" rows="7"></textarea>
				</div>
				<div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">가격</label>
				  <input class="form-control" name="price" placeholder="ex) 2000000">
				</div>
				<!-- 제품 이미지 : <input name="img" type="file"/><br/>  -->
				<div class="mb-3">
				  <input class="form-control form-control-sm" name="img" type="file">
				</div>
				<button type="button" class="btn btn-dark">등록</button>
			</form>
		</div>
	</div>
	<br>
	<%@ include file="common/footer.jsp" %>
</body>
</html>