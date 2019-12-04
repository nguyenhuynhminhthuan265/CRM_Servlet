<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.myclass.constant.UrlConstants"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Thêm mới thành viên</h4>
                        <h6 style="color: red; text-align: center">${message }</h6>
                    </div>
                </div>
                <!-- /.row -->
                <!-- .row -->
                <div class="row">
                    <div class="col-md-2 col-12"></div>
                    <div class="col-md-8 col-xs-12">
                        <div class="white-box">
                            <form class="form-horizontal form-material" method="post" action='<c:url value="${UrlConstants.ACCOUNT_ADD }" />'>
                                <div class="form-group">
                                    <label class="col-md-12">Full Name</label>
                                    <div class="col-md-12">
                                        <input type="text" placeholder="Johnathan Doe" name="fullName"
                                            class="form-control form-control-line"> </div>
                                </div>
                                <div class="form-group">
                                    <label for="example-email" class="col-md-12">Email</label>
                                    <div class="col-md-12">
                                        <input type="email" placeholder="johnathan@admin.com"
                                            class="form-control form-control-line" name="email"
                                            id="example-email"> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Password</label>
                                    <div class="col-md-12">
                                        <input type="password" value="password" class="form-control form-control-line" name="password">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Phone</label>
                                    <div class="col-md-12">
                                        <input type="text" placeholder="123 456 7890" name="phone"
                                            class="form-control form-control-line"> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-12">Address</label>
                                 <div class="col-md-12">
                                        <input type="text" placeholder="Address" name="address"
                                            class="form-control form-control-line"> </div>
                                </div>
                                <div class="form-group">
									<label class="col-md-12">Role</label>
									<div class="col-md-12">
							
									<select class="form-control form-control-line" name="roleId">
							
										<c:forEach var="role" items="${roles }" varStatus="loop">
							
											<option value="${role.id }">${role.name }</option>
										</c:forEach>
									</select> 
							
									</div>
								</div>
                                
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <button type="submit" class="btn btn-success">Add User</button>
                                        <a href='<c:url value="${UrlConstants.ACCOUNT_LIST }" />' class="btn btn-primary">Quay lại</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-2 col-12"></div>
                </div>
                <!-- /.row -->
            </div>