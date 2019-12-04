<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.myclass.constant.UrlConstants"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>CRM Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<div class="container">
  <div class="row mt-5">
    <div class="col-md-5 m-auto mt-5">
   
      <h3 class="text-center">ĐĂNG NHẬP HỆ THỐNG</h3>
       <h6 class="text-center">${message }</h6>
      <div class="p-4 border mt-4">
        <form method="post" action='<c:url value="${UrlConstants.LOGIN }" />'>
            <div class="form-group">
              <label>Email</label>
              <input type="email" class="form-control" name="email">
            </div>
            <div class="form-group">
              <label>Mật khẩu</label>
              <input type="password" class="form-control" name="password">
            </div>
            <button type="submit" class="btn btn-primary">Đăng nhập</button>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Đăng ký</button>
            
          </form>
          
         
      </div>
      </div>
  </div>
  
</div>
 <!-- FORM ĐĂNG KÝ -->
          <div class="modal fade" id="myModal" role="dialog">
    		<div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
         
          <h4 class="modal-title">Đăng ký</h4>
        </div>
        <div class="modal-body">
          <form action='<c:url value="${UrlConstants.REGISTER }" />' method="post">
       
					<div class="form-group">
						<label for="example-email" class="col-md-12">Email</label>
						<div class="col-md-12">
							<input type="email" placeholder="Ex: johnathan@admin.com"
								class="form-control form-control-line" name="email">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Password</label>
						<div class="col-md-12">
							<input type="password" name="password"
								class="form-control form-control-line">
						</div>
					</div>
					<div class="form-group">
						<label for="example-email" class="col-md-12">Full Name</label>
						<div class="col-md-12">
							<input type="text" placeholder="Full Name"
								class="form-control form-control-line" name="fullName">
						</div>
					</div>
					<div class="form-group">
						<label for="example-email" class="col-md-12">Phone</label>
						<div class="col-md-12">
							<input type="text" placeholder="Phone"
								class="form-control form-control-line" name="phone">
						</div>
					</div>
					<div class="form-group">
						<label for="example-email" class="col-md-12">Address</label>
						<div class="col-md-12">
							<input type="text" placeholder="Address"
								class="form-control form-control-line" name="address">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Role</label>
						<div class="col-md-12">
							
						<select class="form-control form-control-line" name="roleId">
							
							<c:forEach var="role" items="${roleOfRegister }" varStatus="loop">
							
								<option value="${role.id }">${role.description }</option>
							</c:forEach>
						</select> 
							
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<button type="submit" class="btn btn-success">Add User</button>
							
						</div>
					</div>
          
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
