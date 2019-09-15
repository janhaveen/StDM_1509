<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link href="<c:url value="/resources/img/favicon.ico " />" rel="shortcut icon">
<title>Barcode</title>
</head>
<body>
<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
	<div class="container">
		<div class="container-fluid">
			<jsp:include page="/WEB-INF/JSPs/Barcode/BarcodeList.jsp" />
			<jsp:include page="/WEB-INF/JSPs/Barcode/BarcodeView.jsp" />
			<jsp:include page="/WEB-INF/JSPs/Barcode/BarcodeForm.jsp" />
		</div>
	</div>
 </body>
<jsp:include page="/WEB-INF/JSPs/Footer.jsp" />
<script src="<c:url value="/resources/js/Barcode/BarcodeList.js"/>"></script> 
</html>