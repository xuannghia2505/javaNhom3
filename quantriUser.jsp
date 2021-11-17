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
    <title>Quản trị user</title>
</head>
<body>
    <a href="LogoutControl" style="margin-left: 1200px;">Đăng xuất</a>
	<section id="header">
	    <a href="quantriUser">Quản lý tài khoản</a>
	    <a href="quantriSach">Quản lý sách</a>
	    <a href="quantriTien">Phê duyệt rút tiền</a>
	    <a href="quantriHoadon">Quản lý đơn hàng</a>
	    
	</section>
	<h3 style="text-align: center;">Quản lý tài khoản</h3>
	<form action="quantriUser" method="get" align="right" class="col-md-2.5 formSearch">
	 	<div class="contentSearch" style="bottom:385px; position:absolute; right:10px;">
			<input type="text" name="txtTim" class="form-control searchInput" style="width:200px;" placeholder="Nhập vào đây">
			<button type="submit"  class="btn btn-info ">Search</button>
		</div>
  	</form>

    <table class="table table-bordered">
        <thead>
          <tr>
            <th scope="col">Mã khách hàng</th>
            <th scope="col">Họ tên</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">SDT</th>
            <th scope="col">Email</th>
            <th scope="col">Tên đăng nhập</th>
            <th scope="col">Mật khẩu</th>
            <th scope="col">Tiền còn lại</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${listKhachhang}" var="o">
          <tr>
            <td>${o.getMakh()}</td>
            <td>${o.getHoten()}</td>
            <td>${o.getDiachi()}</td>
            <td>${o.getSodt()}</td>
            <td>${o.getEmail()}</td>
            <td>${o.getTendn() }</td>
            <td>${o.getPass() }</td>
            <td>${o.getTienconlai() }</td>
            <td>
            <c:if test="${o.getMakh()!=sessionScope.kh.getMakh()}">
            <a href="suaUser?maUser=${o.getMakh()}" type="button" class="btn btn-success">Sửa</a>
            <a href="xoaUser?maUser=${o.getMakh()}" type="button" class="btn btn-danger">Xóa</a>
            </c:if>
            <c:if test="${o.getMakh()==sessionScope.kh.getMakh()}">
            	<p class="alert-primary">Tài khoản của bạn</p>
            </c:if>
            </td>
          </tr>
        </c:forEach>  
        </tbody>
      </table>
</body>
</html>