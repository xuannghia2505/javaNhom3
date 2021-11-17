<%@page import="entity.khachhang"%>
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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" ></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
    <title>Edit User</title>
</head>
<body>
    <a href="LogoutControl" style="margin-left: 1200px;">Đăng xuất</a>
    <c:set var="kh" value='${requestScope["userEdit"]}' />
    <article class="card-body mx-auto" style="max-width: 400px;">
	<form action="saveUser" method="post">
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> Mã khách hàng </span>
		 </div>
        <input name="txtMauser" class="form-control" type="text" 
        value="${kh.getMakh()}" readonly="readonly">
    </div>
	<div class="form-group input-group">	
		<div class="input-group-prepend">
		    <span class="input-group-text"> Họ tên </span>
		 </div>
        <input name="txtHoten" class="form-control"  type="text" 
        value="${kh.getHoten()}">
    </div>
    <div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> Địa chỉ </span>
		 </div>
        <input name="txtAddress" class="form-control"  type="text" 
        value="${kh.getDiachi()}">
    </div> <!-- form-group// -->
    
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> SĐT</span>
		 </div>
        <input name="txtSDT" class="form-control" type="number"
        value="${kh.getSodt()}">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> Email </span>
		</div>
        <input name="txtEmail" class="form-control"  type="email"
        value="${kh.getEmail()}" >
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> Tên đăng nhập </span>
		</div>
        <input name="txtUsername" class="form-control"  type="text" value="${kh.getTendn()}" readonly="readonly">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> Mật khẩu </span>
		</div>
        <input  name="txtPass" class="form-control" value="${kh.getPass()}" type="text">
    </div> <!-- form-group// -->   
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> Tiền còn lại </span>
		</div>
        <input  name="txtTienconlai" class="form-control" value="${kh.getTienconlai()}"  type="text">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> Admin </span>
		</div>
        <input  name="txtAdmin" class="form-control" value="setAdmin" type="checkbox" style="margin-top:8px;" >
    </div> <!-- form-group// -->                                     
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Submit  </button>
    </div> <!-- form-group// -->      
   	<div class="form-group">
        <a  class="btn btn-success btn-block" href="quantriUser"> Back </a>
    </div> <!-- form-group// -->                                                            
</form>
</article>
   
</body>
</html>