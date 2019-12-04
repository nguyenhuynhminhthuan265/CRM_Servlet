<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
   <jsp:include page="/views/layout/header.jsp" />
</head>

<body>
    <!-- Preloader -->
    <div class="preloader">
        <div class="cssload-speeding-wheel"></div>
    </div>
    <div id="wrapper">
        <!-- Navigation -->
         <jsp:include page="/views/layout/navbar.jsp" />
        <!-- Left navbar-header -->
        <jsp:include page="/views/layout/sidebar.jsp" />
        <!-- Left navbar-header end -->
        <!-- Page Content -->
        <div id="page-wrapper">
            <dec:body />
        </div>
        <!-- /#page-wrapper -->
        <!-- /.container-fluid -->
        <footer class="footer text-center"> 2018 &copy; myclass.com </footer>
    </div>
     <!-- /#wrapper -->
    

   
    <jsp:include page="/views/layout/footer.jsp" />
</body>

</html>