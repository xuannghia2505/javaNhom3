<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Document</title>
</head>
<style>
#sotiencon{
	background-color:#ffc;
	color:red;
	position: absolute;
	left:1060px;
	top:42px;
}
.hideSotien{
	display:none;
}
.user-login:hover{
	cursor:pointer;	
}

</style>
<body>
    <nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a  class="navbar-brand" href="#" style="color:red;">Nhà Sách</a>
			</div>
			<ul class="nav navbar-nav">
				<li class=""><a href="loadTrangchu">Trang chủ</a></li>
				<li><a href="loadCart">Giỏ hàng</a></li>
				<c:if test="${sessionScope.kh!=null }">
				<li><a href="loadThanhtoan">Nạp tiền</a></li>
				<li><a href="ruttien.jsp">Rút tiền</a></li>
				<li><a href="lsmuahangControl">Lịch sử mua hàng</a></li>
				
				</c:if>	
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${sessionScope.kh==null }">			
				<li><a href="register.jsp"><span class="glyphicon glyphicon-user"></span>Đăng
						ký</a></li>
				<li><a href="#" data-toggle="modal" data-target="#myModal"><span
						class="glyphicon glyphicon-log-in"></span> Đăng nhập</a></li>
				
				</c:if>
				<c:if test="${sessionScope.kh!=null }">
				<li><a onclick="showMoney()" class="user-login"><span
						class="glyphicon glyphicon-user "></span> Xin chào, ${sessionScope.kh.hoten} </a>
					</li>
				<li><a href="LogoutControl"><span
						class="glyphicon glyphicon-log-in"></span> Đăng Xuất</a></li>
				</c:if>				
			</ul>
		</div>
	</nav>
	<span id="sotiencon" class="hideSotien">Số tiền đang có: ${sessionScope.kh.getTienconlai()} $</span>
	<div class="modal fade" id="myModal">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Thông tin đăng nhập</h4>
				
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div id="dangNhapsai" class="alert-danger"></div>
			
				<div class="modal-body">
					<form action="LoginControl" method="post">
						Mã khách hàng: <input type="text" name="txtuser"
							class="form-control" required> <br> Mật khẩu: <input
							type="password" name="txtpass" class="form-control" required> <br>
						<input type="submit" name="btn-dangnhap" value="Đăng nhập"
							class="btn-primary">
					</form>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>
<script>
function showMoney(){
	$("#sotiencon").toggleClass("hideSotien");
}
</script>
</body>

</html>