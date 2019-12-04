<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.myclass.constant.UrlConstants"%>
 <div class="container-fluid">
              
    
     
				        <div class="modal-header">
				         
				          <h4 style="font-weight: bold" class="modal-title">Cập nhật task</h4>
				          <h4 class="text-center">${message }</h4>
				        </div>
				        <div class="modal-body">
				          <form action='<c:url value="${UrlConstants.TASK_EDIT }" />' method="post">
				          			<input type="hidden" class="form-control form-control-line" name="idTask" value="${taskEdit.id }">
				         		 <div class="form-group">
										<label class="col-md-12">Tên đầu việc</label>
										<div class="col-md-12">
											<input type="text" 
												class="form-control form-control-line" name="taskName" value="${taskEdit.name }">
									</div>
										
									</div>
									<div class="form-group">
										<label class="col-md-12">Ngày kết thúc</label>
										<div class="col-md-12">
											<input type="date"
												class="form-control form-control-line" name="endDate" value="${taskEdit.endDate }">
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
				       	 <button type="submit" class="btn btn-success">Edit</button>
				          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				        </div>
				          </form>
				        </div>
				       
			
	</div>
            <!-- /.container-fluid -->      