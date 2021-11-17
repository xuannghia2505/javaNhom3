<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
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
	<link rel="stylesheet" href="css/n3.css">
    <title>Thanh toán</title>
</head>
<style>
.content-thanhtoan{
	position: absolute;
  	top: 50%;
  	left: 50%;
  	transform: translate(-50%, -50%);
  	background-color:#ffc;
}
p{
color:red;
text-align:center;
font-size:50px;
}
</style>
<body>
     <jsp:include page="header.jsp" />
   <div class="content-thanhtoan">
   		<h2>Vui lòng chuyển khoản:</h2>
   		<h3>Momo:0355535433 Hà Xuân Nghĩa</h3>
   		<h2 style="border:1px solid red; text-align:center; width:300px; margin-left:21%;">Hoặc</h2>
   		<h3>Viettin Bank: 123456789 Hà Xuân Nghĩa</h3>
   		<p>Nội dung chuyển khoản:</p>
   		<p><b>Mã khách hàng: ${sessionScope.kh.getMakh()}</b></p>
   </div>
</body>
</html>