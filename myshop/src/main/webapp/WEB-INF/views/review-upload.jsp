<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
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
</style>
</head>
<body>
	
	<div>
		<div>
			<div class="imgList"></div>
			<!-- <form action="/review/uplaod" method="POST" enctype="multipart/form-data"></form> -->
			
			내용 : <input name="content"/><br/>
			<input class = "imgUpload" name="img" type="file" multiple="multiple"/><br/>
			<input name="productid" type="hidden" value="${product.id}"/><br/>
			<button class="reviewBtn">작성</button>
			
		</div>
	</div>
	
	
	
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>	
	<script>
	    const inputEl = document.querySelector('.imgUpload')
	
	    const fileList = []
	    const imgList = []
	    let count = 0;
	
	    inputEl.addEventListener('change', (e) => {
	
	        for(let i = 0; i<e.target.files.length; i++){
	            const fileObject = {}
	            
	            imgList.push(e.target.files[i])
	            
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
	   	
	    
	    // 주문 ajax
	    document.querySelector(".reviewBtn").addEventListener('click', function() {
	  		
	  		$.ajax({
	  	        url: "http://localhost:8080/review/uplaod",
	  	        type: "POST",
	  	        dataType: "json",
	  	     	processData : false,
	  	     	contentType: 'application/json',
	  	        data: JSON.stringify(imgList),
	  	        success: function(data) {
	  	        	 window.location.href("/product?id=" + ${product.id});
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