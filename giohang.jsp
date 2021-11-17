<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
    <title>Giỏ hàng</title>
</head>
<body>
<jsp:include page="header.jsp" />
<table align="center" cellspacing="0" width="1000">
  <tr>
  	<td valign="top" width="200">
  		<table class="table table-hover">
  			
  			<tr>
  				<td>
  					<a href="menu.jsp?ml=">
  					
  					</a>
  				</td>
  			</tr>
  	
  		</table>
  	</td>
  	<td valign="top" width="1200px">
  		<table class="table table-hover" >
  					<tr>
  						<td colspan="2"><h6>GIỎ HÀNG CỦA BẠN</h6></td>
  					</tr>
  					<tbody id="giohangContent">
  						<c:forEach items="${listCart}" var="o">
  						<tr id="cardP${o.getMaSP()}">
  							<td style="display:flex;flex-direction:row">
  								<div><img src="${o.getImg() }" width="100px" height="120px">
  								</div>
  								
  								<div style="margin-left:10px">
  									<p><strong>${o.getTenSP()}</strong></p><br>				
  										<p>Giá: ${o.getGia() }$ x 
  										<input id ="soluongP${o.getMaSP()}" type="text" name="txtsl" value=${o.getSoluong() } style="width:40px">
  										<input  class= "btn-link" type="button" name="btncn" value="Cập nhật" onclick="updateP('${o.getMaSP()}')">
  										   | <span><a class= "btn-link" onclick="deleteP('${o.getMaSP()}')">Trả lại</a></span>
										</p>
  								</div>
  							</td>			
  						</tr>
  						</c:forEach>
  					</tbody>
  					<tr>
  						<td><h4><strong id="tongtienP">Tổng cộng:${sessionScope.tongtien}$</strong></h4></td>
  					</tr>
  					<tr>
  						<td align="center">
  							<span><a class = "btn btn-info" onclick="deleteAll()" >Trả lại toàn bộ</a></span>
  							<span><a class = "btn btn-info" href="loadTrangchu" >Tiếp tục mua hàng</a></span>  							
  							<span><a class = "btn btn-danger" href=dathangControl >Đặt hàng</a></span>
  							<span><a class = "btn btn-success" onclick="datHang()" >Thêm địa chỉ mới</a></span>					
  						</td>
  					</tr>
  					<div>
  					<%if(request.getAttribute("loiDathang")!=null){%>
  					<p class="alert-danger"><%=request.getAttribute("loiDathang") %></p>
  					<%} %>
  					</div>
  					<div id="formDathang">
  					</div>
			
  		</table>
  	</td>
  </tr>
  </table>
  
  <!-- End -->


	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	function updateP(maSp){
		
		var row = document.getElementById("soluongP"+maSp);		
		var rowTt = document.getElementById("tongtienP");	
		var soP= row.value;
		changeTongTien(maSp,soP);
		$.ajax({
			url : "/nhom3-servlet/changeSoluongP",
			type : "get", //send it through get method
			data : {
				soP :soP,
				maSp : maSp
				
			},
			success : function(data) {
				
				row.innerHTML = data;
			},
			error : function(xhr) {
				//Do Something to handle error
			}
		});
		}
	function deleteP(maSp){
		
		var row = document.getElementById("cardP"+maSp);	
		changeTongTien(maSp,0);
		$.ajax({
			url : "/nhom3-servlet/changeSoluongP",
			type : "get", //send it through get method
			data : {
				soP :"0",
				maSp : maSp
				
			},
			success : function(data) {
				
				row.innerHTML = data;
			},
			error : function(xhr) {
				//Do Something to handle error
			}
		});
		}
	function changeTongTien(maSp,soP){
		var row = document.getElementById("tongtienP");	
		$.ajax({
			url : "/nhom3-servlet/changeTongTien",
			type : "get", //send it through get method
			data : {
				soP :soP,
				maSp : maSp
				
			},
			success : function(data) {

				row.innerHTML = data;
			},
			error : function(xhr) {
				//Do Something to handle error
			}
		});
		}
	function deleteAll(){
		var table = document.getElementById("giohangContent");	
		var row = document.getElementById("tongtienP");	
		$.ajax({
			url : "/nhom3-servlet/deleteAll",
			type : "get", //send it through get method
			data : {
				
			},
			success : function(data) {

				table.innerText = "";
				row.innerHTML=data;
			},
			error : function(xhr) {
				//Do Something to handle error
			}
		});
		}
	 function datHang(){
		var row = document.getElementById("formDathang");
		$.ajax({
			url : "/nhom3-servlet/datHang",
			type : "get", //send it through get method
			data : {
				
			},
			success : function(data) {

				row.innerHTML=data;
			},
			error : function(xhr) {
				//Do Something to handle error
			}
		});
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