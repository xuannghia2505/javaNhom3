<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/n3.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Trang chủ</title>

</head>

<body>	
	
	<jsp:include page="header.jsp" />
	<div class="contain">

	
	<div class="col-md-2.5" >
           <p class="alert-success titleLoaisach tam">Loại sách</p>
           <c:forEach items="${loaiSach}" var="o" >
               <div>
                  <div class="loaisach">
                      <a href="searchMaloai?ml=${o.getMaloai()}">
                         ${o.getTenloai()}
                      </a>
                  </div>
               </div>
  			</c:forEach>
     </div>
	
	<div class="tableSach col-md-7 ">
		<div id="SachContent" class="row" >
				<c:forEach items="${listSHome}" var="o">
                <div class="col-12 col-sm-6 col-md-6 aBook">
                    <img  src="${o.getAnh()}" class="imageSach"><br>
					<div class="descriptionSach">
						<button class="btn btnBuy">
						<a href="addCartControl?maSach=${o.getMasach()}">
						<img src="image_sach/buynow.jpg">
						</a>
						</button><br>
			  			${o.getTensach()} <br>
						Giá bán: ${o.getGia()} $
					
					</div>
                </div>
                </c:forEach> 
        </div>
        <nav aria-label="..." class="text-center">
		  <ul class="pagination" id="paginationNumber">
		  <li class="page-item disabled" id="prePage">
		      <a class="page-link " onclick="prePage('${index}')" >Previous</a>
		   </li>
		  <c:forEach  begin="${trangDau}" end="${trangCuoi}" var="index">
		    
		    <li class="page-item ${index==1 ? "active" : "" }" id="page${index}"><a class="page-link" onclick="loadPageSach('${index}')">${index}</a></li>
		    
		    </c:forEach>
		   	<li class="page-item" id="nextPage">
		      <a class="page-link" onclick="nextPage('1')">Next</a>
		    </li>
		  </ul>
		</nav>
	</div>
	 <form action="searchSach" method="get" align="right" class="col-md-2.5 formSearch">
	 	<div class="contentSearch">
			<input type="text" name="txtTim" class="form-control searchInput" placeholder="Nhập vào đây" >
			<button type="submit"  class="btn btn-danger ">Search</button>
		</div>
      </form>
     </div>
     <% if(request.getParameter("txtuser")!=null && request.getParameter("txtpass")!=null && session.getAttribute("kh")==null) {%>
     	<script>alert("Tài khoản hoặc mật khẩu sai!")</script>
     <%} %>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	
	function loadPageSach(index){
		var table = document.getElementById("SachContent");
		var preIndex= "#prePage";
		var nextIndex="#nextPage";
		if(index==='1'){		
			$(preIndex).addClass("disabled");
		}else{
			$(preIndex).removeClass("disabled");
			
		}
		if(index==='32'){
			$(nextIndex).addClass("disabled");
		}else{
			$(nextIndex).removeClass("disabled");
		}
		loadPage(index); 
		$.ajax({
			url : "/nhom3-servlet/loadPageSach",
			type : "get", //send it through get method
			data : {
				soPage : index
			},
			success : function(data) {
				
				
				table.innerHTML = data;
				
			},
			error : function(xhr) {
				//Do Something to handle error
			}
		});
		}
	function loadPage(index){
		var row = document.getElementById("paginationNumber");
		
		$.ajax({
			url : "/nhom3-servlet/loadPage",
			type : "get", //send it through get method
			data : {
				soPage : index
			},
			success : function(data) {

				
				row.innerHTML = data;
				
			},
			error : function(xhr) {
				//Do Something to handle error
			}
		});
		}
	function nextPage(index){
		loadPageSach(index-(-1));
	}
	function prePage(index){
		loadPageSach(index-1);
	}
	</script>
	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>