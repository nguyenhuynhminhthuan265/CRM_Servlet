<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.myclass.constant.UrlConstants"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRM</title>
</head>
<body>
<!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top m-b-0">
            <div style="background:#00a0ff" class="navbar-header"> <a class="navbar-toggle hidden-sm hidden-md hidden-lg "
                    href="javascript:void(0)" data-toggle="collapse" data-target=".navbar-collapse"><i
                        class="fa fa-bars"></i></a>
                <div class="top-left-part"><a class="logo" href='<c:url value="${UrlConstants.HOME }" />'><b><img
                                src='<c:url value="/assets/plugins/images/pixeladmin-logo.png" />' alt="home" /></b><span style="font-weight:bold;font-size: 150%;" class="hidden-xs">C-R-M</span></a>
                </div>
                <ul class="nav navbar-top-links navbar-left m-l-20 hidden-xs">
                    <li>
                        <form role="search" class="app-search hidden-xs">
                            <input type="text" placeholder="Search..." class="form-control"> <a href=""><i
                                    class="fa fa-search"></i></a>
                        </form>
                    </li>
                </ul>
                <ul class="nav navbar-top-links navbar-right pull-right">
                    <li>
                        <%-- <a class="profile-pic" href="#"> <img src='<c:url value="/assets/plugins/images/users/varun.jpg" />' alt="user-img"
                                width="36" class="img-circle"><b class="hidden-xs">${ACCOUNT_LOGIN.fullName }</b> </a> --%>
                   			  <div class="dropdown">
						  <a href="javascript:void(0)" class="dropdown-toggle profile-pic" data-toggle="dropdown">
						  	<img src='<c:url value="/assets/plugins/images/users/varun.jpg"/>' alt="user-img"
                                width="36" class="img-circle">
                                <b class="hidden-xs">
                                	<%-- <%Cookie[] cookies = request.getCookies();%>
                                	<%for(int i = 0; i < cookies.length; i++){%>
                                		/* String name = cookies[i].getName(); // Lấy tên cookie */
                                		
                                		<%=cookies[i].getValue() %>
                                		<% } %> --%>
                                	
						  			${ACCOUNT_LOGIN.fullName }
						  		</b>
						  	<span class="caret"></span>
						  </a>
						  <ul class="dropdown-menu">
						    <li><a href='<c:url value="${UrlConstants.ACCOUNT_LIST }" />'>Thông tin cá nhân</a></li>
						    <li><a href='<c:url value="/logout" />'>Đăng xuất</a></li>
						  </ul>
						</div>
                   
                    </li>
                </ul>
            </div>
            <!-- /.navbar-header -->
            <!-- /.navbar-top-links -->
            <!-- /.navbar-static-side -->
        </nav>
</body>
</html>