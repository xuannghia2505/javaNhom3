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
    <title>Quản trị tiền</title>
</head>
<body>
   <a href="LogoutControl" style="margin-left: 1200px;">Đăng xuất</a>
	<section id="header">
	    <a href="quantriUser">Quản lý tài khoản</a>
	    <a href="quantriSach">Quản lý sách</a>
	    <a href="quantriTien">Phê duyệt rút tiền</a>
	    <a href="quantriHoadon">Quản lý đơn hàng</a>
	    
	</section>
	<h3 style="text-align: center;">Phê duyệt rút tiền</h3>
	<form action="quantriTien" method="get" align="right" class="col-md-2.5 formSearch">
	 	<div class="contentSearch" style="bottom:365px; position:absolute; right:10px;">
			<input type="text" name="txtTim" class="form-control searchInput" style="width:200px;" placeholder="Nhập vào đây">
			<button type="submit"  class="btn btn-info">Search</button>
		</div>
  	</form>
	<table class="table table-bordered table-ql">
    <thead>
      <tr>
      	<th scope="col">Mã Lịch sử</th>
        <th scope="col">Mã khách hàng</th>
        <th scope="col">Số tài khoản</th>
        <th scope="col">Tên tài khoản</th>
        <th scope="col">Số tiền rút</th>         
        <th></th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${listLS }" var="o">
      <tr>
      	<td>${o.getMals() }</td>
        <td>${o.getMakh() }</td>
        <td>${o.getStk() }</td>
        <td>${o.getTentk() }</td>
        <td>${o.getSotienrut() }</td>    
        <td>
          <a href="pheduyetruttienControl?maLs=${o.getMals()}" type="button" class="btn btn-success">Đã hoàn thành</a>
        </td>
      </tr>
     </c:forEach>
    </tbody>
 	</table> 
</body>
</html>