<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <title>Rút tiền</title>
</head>
<body>
    <jsp:include page="header.jsp" />
    <h2 style="text-align:center;" class="alert-danger">Để đảm bảo tính an toàn tiền sẽ được chuyển đến số tài khoản đã nạp!!!!.</h2>
    <div style="text-align:center; background-color:#ff9; margin-top:100px;" class="card">
	  	<div class="card-body">
	    	<form action="ruttienControl" method="post">
	    		<h3 style="color:green; margin-bottom:20px; padding-top:30px;" >Nhập số tiền muốn rút:</h3>
	    		<input name="txtSotienrut" type="number" value="" placeholder="Số tiền" style="color:red;"> <br>
	    		<input type="submit" class="btn btn-success" value="Xác nhận" style="margin:30px;">
	    	</form>
	 	 </div>
	</div>
	<h3 class="alert-warning">
		<% if(request.getAttribute("messengeRuttien")!=null){ %>
		<%= request.getAttribute("messengeRuttien") %>
		<%} %>
		
	</h3>
</body>
</html>