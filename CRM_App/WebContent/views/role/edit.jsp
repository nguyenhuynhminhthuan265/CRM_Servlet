<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.myclass.constant.UrlConstants"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid">
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Cập nhật quyền</h4>
		</div>
	</div>
	<!-- /.row -->
	<!-- .row -->
	<div class="row">
		<div class="col-md-2 col-12"></div>
		<div class="col-md-8 col-xs-12">
			<div class="white-box">
				<form class="form-horizontal form-material" method="POST" action='<c:url value="${UrlConstants.ROLE_EDIT }" />'>
					<%-- <div class="form-group">
						<label class="col-md-12">ID</label>
						<div class="col-md-12">
							
						</div>
					</div> --%>
					<input name="id" value="${role.id }" type="hidden" placeholder="ID" readonly
								class="form-control form-control-line" />
					
					<div class="form-group">
						<label class="col-md-12">Tên quyền</label>
						<div class="col-md-12">
							<input name="nameEdit" value="${role.name }" type="text" placeholder="Tên quyền"
								class="form-control form-control-line" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Mô tả</label>
						<div class="col-md-12">
							<input name="descriptionEdit" value="${role.description }" type="text" placeholder="Mô tả"
								class="form-control form-control-line" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<button type="submit" class="btn btn-success">Update Role</button>
							<a href="<c:url value="${UrlConstants.ROLE_LIST }" />" class="btn btn-primary">Quay lại</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-2 col-12"></div>
	</div>
	<!-- /.row -->
</div>