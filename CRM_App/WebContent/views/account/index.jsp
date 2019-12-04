<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.myclass.constant.UrlConstants"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Danh sách thành viên</h4>
                        <h6 style="color: red; text-align: center">${message }</h6>
                    </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                        <a href='<c:url value="${UrlConstants.ACCOUNT_ADD }" />' class="btn btn-sm btn-success">Thêm mới</a>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /row -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <div class="table-responsive">
                                <table class="table" id="example">
                                    <thead>
                                        <tr>
                                            <th>STT</th>
                                            <th>Full Name</th>
                                            <th>Email</th>
                                            <th>Phone</th>
                                            <th>Address</th>
                                            <th>Role</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="account" items="${accounts }" varStatus="loop">
                                        <tr>
                                            <td>${loop.index+1 }</td>
                                            <td>${account.fullName }</td>
                                            <td>${account.email }</td>
                                            <td>${account.phone }</td>
                                            <td>${account.address }</td>
                                            <td>${account.roleName }</td>
                                            <td>
                                                <a href='<c:url value="${UrlConstants.ACCOUNT_EDIT }?id=${account.id }" />' class="btn btn-sm btn-primary">Sửa</a>
                                                <a href='<c:url value="${UrlConstants.ACCOUNT_DELETE }?id=${account.id }" />' class="btn btn-sm btn-danger">Xóa</a>
                                                <a href='<c:url value="${UrlConstants.ACCOUNT_DETAILS }?id=${account.id }" />' class="btn btn-sm btn-info">Xem</a>
                                            </td>
                                        </tr>
                                      </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->