<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title><dec:title default="Home"/></title>
<link rel="stylesheet"
	href="<c:url value="/resources/web/assets/bootstrap/css/bootstrap.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/web/assets/fonts/font-awesome.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/web/assets/fonts/ionicons.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/web/assets/css/Footer-Clean.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/web/assets/css/Login-Form-Dark.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/web/assets/css/Navigation-with-Search.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/web/assets/css/styles.css"/>" />
<style type="text/css">
body>.container{
	min-height:800px;
}
.btnDetail {
	bottom: 10px;
	position: absolute;
	right: 10px;
}
.product-name{
	height: 40px;
}
.product-price{
	height:30px;
}
#navcol-1{
	max-width:40%;
}
</style>

<dec:head/>
</head>

<body>
	<jsp:include page="header.jsp"/>
	
	<dec:body/>
	
	<jsp:include page="footer.jsp"/>
	<script src="<c:url value="/resources/web/assets/js/jquery.min.js"/>"></script>
	<script
		src="<c:url value="/resources/web/assets/bootstrap/js/bootstrap.min.js"/>"></script>
</body>

</html>