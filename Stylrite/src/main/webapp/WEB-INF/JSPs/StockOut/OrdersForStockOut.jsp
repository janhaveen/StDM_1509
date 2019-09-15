<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link href="<c:url value="/resources/img/favicon.ico"/>" rel="shortcut icon">
<title>Stock Out Order</title>
</head>
<body>
<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
	<div class="container">
		<div class="container-fluid">
			<%@include file="OrderList.jsp" %>
			<%@include file="StockOutProduct.jsp" %>
		</div>
	</div>
	<%@include file="SelectChildBarcode.jsp" %>
	<%@include file="TakeFromSample.jsp" %>
</body>
<jsp:include page="/WEB-INF/JSPs/Footer.jsp" />
<script src="<c:url value="/resources/js/StockOut/OrderList.js" />"></script>
<script src="<c:url value="/resources/js/StockOut/TakeFromSampleList.js" />"></script>
</html>