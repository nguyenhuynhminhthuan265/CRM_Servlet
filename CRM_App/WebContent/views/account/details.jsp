<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Chi tiết thành viên</h4>
                    </div>
                </div>
                <!-- /.row -->
                <!-- .row -->
                <div class="row">
                    <div class="col-md-4 col-xs-12">
                        <div class="white-box">
                            <div class="user-bg"> <img width="100%" alt="user" src='<c:url value="/assets/plugins/images/large/img1.jpg"></c:url>'>
                                <div class="overlay-box">
                                    <div class="user-content">
                                        <a href="javascript:void(0)"><img src='<c:url value="/assets/plugins/images/users/genu.jpg"></c:url>'
                                                class="thumb-lg img-circle" alt="img"></a>
                                        <h4 class="text-white">${account.fullName }</h4>
                                        <h5 class="text-white">${account.email }</h5>
                                    </div>
                                </div>
                            </div>
                            <div class="user-btm-box">
                                <div class="col-md-4 col-sm-4 text-center">
                                    <p class="text-purple"><i class="ti-facebook"></i></p>
                                    <h4>20%</h4>
                                    <h6>Chưa thực hiện</h6>
                                </div>
                                <div class="col-md-4 col-sm-4 text-center">
                                    <p class="text-blue"><i class="ti-twitter"></i></p>
                                    <h4>50%</h4>
                                    <h6>Đang thực hiện</h6>
                                </div>
                                <div class="col-md-4 col-sm-4 text-center">
                                    <p class="text-danger"><i class="ti-dribbble"></i></p>
                                    <h4>30%</h4>
                                    <h6>Hoàn thành</h6>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-8 col-xs-12">
                        <div class="white-box">
                            <form class="form-horizontal form-material">
                                <div class="form-group">
                                    <label class="col-md-12">Full Name:${account.fullName } </label>
                                </div>
                                <div class="form-group">
                                    <label for="example-email" class="col-md-12">Email: ${account.email } </label>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Password: ${account.password }</label>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Phone No: ${account.phone }</label>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-12">Address: ${account.address }</label>
                                </div>
                                
                            </form>
                        </div>
                    </div>
                </div><br />
                <!-- /.row -->
                <!-- BEGIN DANH SÁCH CÔNG VIỆC -->
                <h4>DANH SÁCH CÔNG VIỆC</h4>
                <c:forEach var="group" items="${listGroupWorkOfAccount }" varStatus="loop">
                <h4 class="page-title"> ${group.group_name } </h4>
                <div class="row">
                    <div class="col-xs-12">
                        <a href="#" class="group-title">
                            <img width="30" src='<c:url value="/assets/plugins/images/users/pawandeep.jpg" />' class="img-circle" />
                            <span style=" font-weight:bold;">${group.account_name }</span>
                        </a>
                    </div>
                    <div class="col-md-4">
                        <div class="white-box">
                           <div style="background-color: #337ab7"> <h3 style="color: white" class="box-title">${statusName_notDone }</h3></div>
                            <div class="message-center">
                            
                            	<c:if test="${group.status_name==statusName_notDone }">
                                <a href="#">
                                    <div class="mail-contnet">
                                        <h5>${group.name }</h5> <span class="mail-desc">${group.account_name }</span> 
                                        <span class="time">${group.endDate }</span>
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
                                <c:if test="${group.status_name==statusName_Doing }">
                                <a href="#">
                                    <div class="mail-contnet">
                                         <h5>${group.name }</h5> <span class="mail-desc">${group.account_name }</span> 
                                        <span class="time">${group.endDate }</span>
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
                               <c:if test="${group.status_name==statusName_Done }">
                                <a href="#">
                                    <div class="mail-contnet">
                                         <h5>${group.name }</h5> <span class="mail-desc">${group.account_name }</span> 
                                        <span class="time">${group.endDate }</span>
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