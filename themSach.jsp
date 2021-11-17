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
    <article class="card-body mx-auto" style="max-width: 400px;">
	<form action="addSach" method="post" enctype="multipart/form-data">
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> Mã Sách </span>
		 </div>
        <input name="txtMasach" class="form-control" type="text" 
        value="" >
    </div>
	<div class="form-group input-group">	
		<div class="input-group-prepend">
		    <span class="input-group-text"> Tên sách </span>
		 </div>
        <input name="txtTensach" class="form-control"  type="text" 
        value="">
    </div>
    <div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> Số lượng </span>
		 </div>
        <input name="txtSoluong" class="form-control"  type="number" 
        value="">
    </div> <!-- form-group// -->
    
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> Giá</span>
		 </div>
        <input name="txtGia" class="form-control" type="number"
        value="">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> Mã loại </span>
		</div>
        <select class="custom-select" name="maloai" style="max-width: 120px;">
        <c:forEach items="${loaiSach}" var="o">       	
		    <option  value="${o.getMaloai()}">${o.getTenloai() }</option>   
		</c:forEach>
		</select>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> Số tập </span>
		</div>
        <input name="txtSotap" class="form-control"  type="number" value="" >
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> Ảnh </span>
		</div>
        <input style="margin:5px 0 0 5px;"  class="form-group" type="file" id="myfile" name="txtAnh" multiple>
    </div> <!-- form-group// -->   
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> Tác giả </span>
		</div>
        <input  name="txtTacgia" class="form-control" value=""  type="text">
    </div> <!-- form-group// -->                               
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Submit  </button>
    </div> <!-- form-group// -->      
   	<div class="form-group">
        <a  class="btn btn-success btn-block" href="quantriSach"> Back </a>
    </div> <!-- form-group// -->                                                            
</form>
</article>
   
</body>
</html>