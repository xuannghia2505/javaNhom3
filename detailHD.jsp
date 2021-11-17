<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" ></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
     <link rel="stylesheet" href="css/n3.css">
    <title>Detail</title>
</head>
<body>
<a href="LogoutControl" style="margin-left: 1200px;">Đăng xuất</a>

<h3 style="text-align: center;">Chi tiết hóa đơn</h3>

  <a  href="quantriHoadon" class="btn btn-warning">Back</a>
    <table class="table table-bordered">
        <thead>
          <tr>
            <th scope="col">Mã sách</th>
            <th scope="col" style="width:120px;">Tên sách</th>
            <th scope="col">Số lượng</th>
            <th scope="col">Giá</th>
            <th scope="col">Mã loại</th>
            <th scope="col">Số tập</th>
            <th scope="col">Ảnh</th>
            <th scope="col">Ngày nhập</th>
            <th scope="col">Tác giả</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${listCTHD}" var="o">
          <tr>
            <td>${o.getMasach()}</td>
            <td>${o.getTensach() }</td>
            <td>${o.getSoluong() }</td>
            <td>${o.getGia() }</td>
            <td>${o.getMaloai() }</td>
            <td>${o.getSotap()}</td>
            <td><img src="${o.getAnh()}" style="width:50px; height:50px;"></td>
            <td>${o.getNgayNhap() }</td>
            <td>${o.getTacgia() }</td>           

          </tr>
         </c:forEach>
        </tbody>
      </table>
</body>
</html>