<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.myclass.constant.UrlConstants"%>

<div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Danh sách công việc</h4>
                    </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                        <a href='<c:url value="${UrlConstants.GROUP_ADD }" />' class="btn btn-sm btn-success">Thêm mới</a>
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
                                            <th>Group Name</th>
                                            <th>Description </th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="groupwork" items="${groupworks }" varStatus="loop">
                                        <tr>
                                            <td>${loop.index+1 }</td>
                                            <td><a href='<c:url value="${UrlConstants.TASK_LIST }?id=${groupwork.id }" />'>${groupwork.groupName }</a></td>
                                          
                                            <td>${groupwork.groupDescription }</td>
                                            
                                            <td>
                                                <a href='<c:url value="${UrlConstants.GROUP_EDIT }?id=${groupwork.id }" />' class="btn btn-sm btn-primary">Sửa</a>
                                                <a href='<c:url value="${UrlConstants.GROUP_DELETE }?id=${groupwork.id }" />' class="btn btn-sm btn-danger">Xóa</a>
                                                <a href='<c:url value="${UrlConstants.GROUP_DETAILS }?id=${groupwork.id }" />' class="btn btn-sm btn-info">Xem</a>
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