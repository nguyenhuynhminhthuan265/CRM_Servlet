<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.myclass.constant.UrlConstants"%>
 <div class="container-fluid">
              
  <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                       <h4>${groupName }</h4> 
                       <h2 class="text-center">${message }</h2>
                    </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                        <%-- <a href='<c:url value="${UrlConstants.TASK_ADD }" />' class="btn btn-sm btn-success">Thêm mới đầu việc</a> --%>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Thêm mới đầu việc</button>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>

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
                           <div style="background-color: #337ab7"> 
                           			
                           
                           
                           <h3 style="color: white" class="box-title">${statusName_notDone }</h3></div>
                            <div class="message-center">
                            
                            	<c:if test="${account.status_name==statusName_notDone }">
                            	<a href='<c:url value="${UrlConstants.TASK_DELETE }?id=${account.id }" />' class="close btn btn-muted" aria-label="Close">
  										<span aria-hidden="true">&times;</span>
									</a>
                                <a href='<c:url value="${UrlConstants.TASK_EDIT }?id=${account.id }" />'>
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
                            <div style="background-color: #82e15b"> 
                            		
                            
                            
                            <h3 style="color: white" class="box-title">${statusName_Doing }</h3></div>
                            <div class="message-center">
                                <c:if test="${account.status_name==statusName_Doing }">
                                <a href='<c:url value="${UrlConstants.TASK_DELETE }?id=${account.id }" />' class="close btn btn-muted" aria-label="Close">
  										<span aria-hidden="true">&times;</span>
									</a>
                                <a href='<c:url value="${UrlConstants.TASK_EDIT }?id=${account.id }" />'>
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
                            <div style="background-color: #ffae6d">
                            
                            	
                            		
                            
                            <h3 style="color: white" class="box-title">${statusName_Done }</h3></div>
                            <div class="message-center">
                               <c:if test="${account.status_name==statusName_Done }">
                               		
                               		<a href='<c:url value="${UrlConstants.TASK_DELETE }?id=${account.id }" />' class="close btn btn-muted" aria-label="Close">
  										<span aria-hidden="true">&times;</span>
									</a>
                               		
                                <a href='<c:url value="${UrlConstants.TASK_EDIT }?id=${account.id }" />'>
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
                
                <!-- FORM THÊM MỚI ĐẦU VIỆC -->
				                <div class="modal fade" id="myModal" role="dialog">
				    		<div class="modal-dialog modal-lg">
				      <div class="modal-content">
				        <div class="modal-header">
				         
				          <h4 style="font-weight: bold" class="modal-title">Đăng ký</h4>
				        </div>
				        <div class="modal-body">
				          <form action='<c:url value="${UrlConstants.TASK_ADD }" />' method="post">
				          			<input type="hidden" class="form-control form-control-line" name="idGroup" value="${idGroup }">
				         		 <div class="form-group">
										<label class="col-md-12">Tên đầu việc</label>
										<div class="col-md-12">
											<input type="text" 
												class="form-control form-control-line" name="taskName">
									</div>
										
									</div>
									<div class="form-group">
										<label class="col-md-12">Ngày kết thúc</label>
										<div class="col-md-12">
											<input type="date"
												class="form-control form-control-line" name="endDate">
										</div>
										
									</div>
									<div class="form-group">
										<label class="col-md-12">Người phụ trách</label>
										<div class="col-md-12">
											
										<select class="form-control form-control-line" name="accountName">
											
											 <c:forEach var="account" items="${accounts }" varStatus="loop">
											
												<option value="${account.id }">${account.fullName }(${account.email })</option>
											</c:forEach> 
										</select> 
											
										</div>
									</div>
									
								
									<div class="form-group">
										<label class="col-md-12">Trạng thái</label>
										<div class="col-md-12">
											
										<select class="form-control form-control-line" name="status">
											
											 <c:forEach var="statusName" items="${statusNames }" varStatus="loop">
											
												<option value="${statusName.id }">${statusName.name }</option>
											</c:forEach>
										</select> 
											
										</div>
									</div>
								
				           <div class="modal-footer">
				       	 <button type="submit" class="btn btn-success">Add</button>
				          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				        </div>
				          </form>
				        </div>
				       
				      </div>
				    </div>
				  </div>        
                
            </div>
            <!-- /.container-fluid -->