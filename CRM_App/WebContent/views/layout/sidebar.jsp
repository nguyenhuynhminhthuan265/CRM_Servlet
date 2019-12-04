<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.myclass.constant.UrlConstants"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Left navbar-header -->
        <div style="background: #000000" class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse slimscrollsidebar">
                <ul class="nav" id="side-menu">
                    <li style="padding: 10px 0 0;">
                        <a href='<c:url value="${UrlConstants.HOME }" />' class="waves-effect"><i class="fa fa-clock-o fa-fw"
                                aria-hidden="true"></i><span  style="font-weight:bold" class="hide-menu">Dashboard</span></a>
                    </li>
                    <li>
                        <a href='<c:url value="${UrlConstants.ACCOUNT_LIST }" />' class="waves-effect"><i class="fa fa-user fa-fw"
                                aria-hidden="true"></i><span  style="font-weight:bold" class="hide-menu">Thành viên</span></a>
                    </li>
                    <li>
                        <a href='<c:url value="${UrlConstants.ROLE_LIST }" />' class="waves-effect"><i class="fa fa-modx fa-fw"
                                aria-hidden="true"></i><span style="font-weight:bold"  class="hide-menu">Quyền</span></a>
                    </li>
                    <li>
                        <a href='<c:url value="${UrlConstants.GROUP_LIST }" />' class="waves-effect"><i class="fa fa-table fa-fw"
                                aria-hidden="true"></i><span  style="font-weight:bold" class="hide-menu">Nhóm việc</span></a>
                    </li>
                   
                </ul>
            </div>
        </div>
        <!-- Left navbar-header end -->
</body>
</html>