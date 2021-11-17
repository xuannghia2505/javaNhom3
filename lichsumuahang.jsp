<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <title>Lịch sử mua hàng</title>
</head>
<style>
.tt-sach{
	width:180px;
	
}
.card-sach{
	display:flex;
	width:250px;
}
.soluongmua-card{
	color:red;
	margin:auto 0;
	border:1px solid black;
	padding:5px;
}
</style>
<body>
    <jsp:include page="header.jsp" />
    <h2 style="color:red; margin:30px 20px; border:1px solid green; width:300px; box-shadow:3px 5px #888888;">Chi tiết hóa đơn</h2>
    <table class="table table-bordered" style="box-shadow:3px 5px 3px 5px #888888; width:900px; margin-left:50px;">
  <thead>
    <tr>
      <th scope="col">STT</th>
      <th scope="col" style="width:250px;">Mặt hàng</th>
      <th scope="col">Thời gian</th>
      <th scope="col">Thành tiền</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${lsmuahang}" var="o" varStatus="loop">
    <tr>
      <th scope="row">${loop.index+1}</th>
      <td class="card-sach">
	  	<div class="card bg-dark text-white tt-sach">
		  <img src="${o.getImageSach()}" class="card-img" alt="..." width="50px;" height="50px;">
		  <div class="card-img-overlay">
		    <h5 class="card-title"><b>${o.getTenSach() }</b></h5>
		  </div>		 
		</div>
		
		<span class="soluongmua-card">
		  	X ${o.getSoluongMua() }
		</span>
	  </td>
      <td>${o.getNgaymua()}</td>
      <td>${o.getThanhtien() } $</td>
    </tr>
   </c:forEach>
  </tbody>
</table>
</body>
</html>