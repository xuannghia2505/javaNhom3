<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" href="css/n3.css">
    <title>Đăng ký</title>
</head>
<body>
    <div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">Create Account</h4>
	<p class="text-center">Get started with your free account</p>
	<p>
		<a href="#" class="btn btn-block btn-facebook"> <i class="bi bi-facebook"></i>   Login via facebook</a>
	</p>
	<div id="messenge_error" class="alert-danger">
	<% if(request.getAttribute("messenge")!=null){%>
	<%=request.getAttribute("messenge") %>
	<%} %>
	</div>
	<form action="registerControl" method="post">
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <input name="txtHoten" class="form-control" placeholder="Full name" type="text" 
        value="<%if (request.getAttribute("txtHoten")!=null){%><%=request.getAttribute("txtHoten")%><%}%>">
    </div>
    <div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <input name="txtAddress" class="form-control" placeholder="Address" type="text" 
        value="<%if (request.getAttribute("txtAddress")!=null){%><%=request.getAttribute("txtAddress")%><%}%>">
    </div> <!-- form-group// -->
    
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
		</div>
		<select class="custom-select" style="max-width: 120px;">
		    <option selected="">+84</option>
		    <option value="1">+85</option>
		    <option value="2">+198</option>
		    <option value="3">+701</option>
		</select>
    	<input name="txtSdt" class="form-control" placeholder="Phone number" type="text"
    	value="<%if (request.getAttribute("txtSdt")!=null){%><%=request.getAttribute("txtSdt")%><%}%>">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
        <input name="txtEmail" class="form-control" placeholder="Email address" type="email"
        value="<%if (request.getAttribute("txtEmail")!=null){%><%=request.getAttribute("txtEmail")%><%}%>">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input name="txtUsername" class="form-control" placeholder="Create Username" type="text"
        value="<%if (request.getAttribute("txtUsername")!=null){%><%=request.getAttribute("txtUsername")%><%}%>">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input name="txtPass" class="form-control" placeholder="Create password" type="password">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input  name="txtrePass" class="form-control" placeholder="Repeat password" type="password">
    </div> <!-- form-group// -->                                      
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Create Account  </button>
    </div> <!-- form-group// -->      
   	<div class="form-group">
        <a  class="btn btn-success btn-block" href="loadTrangchu"> Back Home  </a>
    </div> <!-- form-group// -->                                                            
</form>
</article>
</div> 
</body>
</html>