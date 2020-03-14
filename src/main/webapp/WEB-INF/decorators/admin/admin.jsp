<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
     <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta content="" name="description" />
    <meta content="webthemez" name="author" />
	<!-- Bootstrap Styles-->
    <link href="<c:url value="/resources/assets/css/bootstrap.css"/>" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="<c:url value="/resources/assets/css/font-awesome.css"/>" rel="stylesheet" />
     <!-- Morris Chart Styles-->
   
     <!-- Custom Styles-->
    <link href="<c:url value="/resources/assets/css/custom-styles.css"/>" rel="stylesheet" />
     <!-- Google Fonts-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
     <!-- TABLE STYLES-->
    <link href="<c:url value="/resources/assets/js/dataTables/dataTables.bootstrap.css"/>" rel="stylesheet" />
    <!-- ICON -->
    <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.3.1/css/all.css'>
<title>
	<dec:title default="Quản lý đồ chơi ô tô"/>
</title>
<!-- Add link css here -->
<%-- <link rel="stylesheet" href='<c:url value="/resources/css/style-custom.css/>" /> --%>
 <style type="text/css">
 .btn{
     width: 70px;
     margin-right:20px;
}
.btn-frame{
	margin-left:20px;
}
#modal{
     width:100%; height:100%; background-color:rgba(0,0,0,0.1); position: absolute; top:0; z-index: 1; margin:0 auto; text-align: center; display: none;
}
#frame{
      width:300px; height:200px; margin-top: 200px; display: inline-block; background-color:white; border-radius:5px;
      padding:0px; box-shadow:1px 1px 5px grey;
}
.frame-content{
	width:100%; height:90px; line-height: 90px;
}
.frame-title{
	width:100%; line-height:30px;height:30px; margin: 0;border-radius:5px 5px 0 0;	
}
 </style>
 <dec:head/>
</head>
<body>
	<jsp:include page="header.jsp"/>
	
	<dec:body/>
	
	<%-- <jsp:include page="footer.jsp"/> --%>
	
	  <!-- JS Scripts-->

    <!-- jQuery Js -->
    <script src="<c:url value="/resources/assets/js/jquery-1.10.2.js"/>"></script>
      <!-- Bootstrap Js -->
    <script src="<c:url value="/resources/assets/js/bootstrap.min.js"/>"></script>
    <!-- Metis Menu Js -->
    <script src="<c:url value="/resources/assets/js/jquery.metisMenu.js"/>"></script>
     <!-- DATA TABLE SCRIPTS -->
    <script src="<c:url value="/resources/assets/js/dataTables/jquery.dataTables.js"/>"></script>
    <script src="<c:url value="/resources/assets/js/dataTables/dataTables.bootstrap.js"/>"></script>
        <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
    	</script>
         <!-- Custom Js -->
   	<script src="<c:url value="/resources/assets/js/custom-scripts.js"/>"></script>
    <script src="<c:url value="/resources/assets/js/admin-custom.js"/>"></script>
</body>
</html>