<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.myclass.constant.UrlConstants"%>
 <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Chi tiết công việc ${groupName } </h4>
                    </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        <ol class="breadcrumb">
                            <li><a href="#">Dashboard</a></li>
                            <li class="active">Blank Page</li>
                        </ol>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- BEGIN THỐNG KÊ -->
                <div class="row">
                    <!--col -->
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="white-box">
                            <div class="col-in row">
                                <div class="col-md-6 col-sm-6 col-xs-6"> <i data-icon="E"
                                        class="linea-icon linea-basic"></i>
                                    <h5 class="text-muted vb">CHƯA BẮT ĐẦU</h5>
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-6">
                                    <h3 class="counter text-right m-t-15 text-danger">20%</h3>
                                </div>
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-danger" role="progressbar"
                                            aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.col -->
                    <!--col -->
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="white-box">
                            <div class="col-in row">
                                <div class="col-md-6 col-sm-6 col-xs-6"> <i class="linea-icon linea-basic"
                                        data-icon="&#xe01b;"></i>
                                    <h5 class="text-muted vb">ĐANG THỰC HIỆN</h5>
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-6">
                                    <h3 class="counter text-right m-t-15 text-megna">50%</h3>
                                </div>
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-megna" role="progressbar"
                                            aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 50%">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.col -->
                    <!--col -->
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="white-box">
                            <div class="col-in row">
                                <div class="col-md-6 col-sm-6 col-xs-6"> <i class="linea-icon linea-basic"
                                        data-icon="&#xe00b;"></i>
                                    <h5 class="text-muted vb">HOÀN THÀNH</h5>
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-6">
                                    <h3 class="counter text-right m-t-15 text-primary">30%</h3>
                                </div>
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-primary" role="progressbar"
                                            aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 30%">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.col -->
                </div>
                <!-- END THỐNG KÊ -->

                <!-- BEGIN DANH SÁCH CÔNG VIỆC -->
                <c:forEach var="account" items="${listAccountOfGroup }" varStatus="loop">
                <div class="row">
                    <div class="col-xs-12">
                        <a href="#" class="group-title">
                            <img width="30" src='<c:url value="/assets/plugins/images/users/pawandeep.jpg" />' class="img-circle" />
                            <span style=" font-weight:bold;">${account.account_name }</span>
                        </a>
                    </div>
                    <div class="col-md-4">
                        <div class="white-box">
                           <div style="background-color: #337ab7"> <h3 style="color: white" class="box-title">${statusName_notDone }</h3></div>
                            <div class="message-center">
                            
                            	<c:if test="${account.status_name==statusName_notDone }">
                                <a href="#">
                                    <div class="mail-contnet">
                                        <h5>${account.name }</h5> <span class="mail-desc">${account.account_name }</span> 
                                        <span class="time">${account.endDate }</span>
                                    </div>
                                </a>
                              </c:if>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="white-box">
                            <div style="background-color: #82e15b"> <h3 style="color: white" class="box-title">${statusName_Doing }</h3></div>
                            <div class="message-center">
                                <c:if test="${account.status_name==statusName_Doing }">
                                <a href="#">
                                    <div class="mail-contnet">
                                         <h5>${account.name }</h5> <span class="mail-desc">${account.account_name }</span> 
                                        <span class="time">${account.endDate }</span>
                                    </div>
                                </a>
                              </c:if>
                               
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="white-box">
                            <div style="background-color: #ffae6d"><h3 style="color: white" class="box-title">${statusName_Done }</h3></div>
                            <div class="message-center">
                               <c:if test="${account.status_name==statusName_Done }">
                                <a href="#">
                                    <div class="mail-contnet">
                                         <h5>${account.name }</h5> <span class="mail-desc">${account.account_name }</span> 
                                        <span class="time">${account.endDate }</span>
                                    </div>
                                </a>
                              </c:if>
                               
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
                <!-- END DANH SÁCH CÔNG VIỆC -->
            </div>
            <!-- /.container-fluid -->