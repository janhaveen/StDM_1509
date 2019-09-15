 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Vendor</title>
<link href="<c:url value="/resources/img/favicon.ico " />" rel="shortcut icon">
</head>
<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
<body>
	<div class="container">
		<div class="container-fluid">
		<jsp:include page="/WEB-INF/JSPs/vendor/VendorForm.jsp"/>
		<jsp:include page="/WEB-INF/JSPs/vendor/VendorList.jsp"/>
		<jsp:include page="/WEB-INF/JSPs/vendor/VendorView.jsp"/>
		<jsp:include page="/WEB-INF/JSPs/vendor/DeleteVendor.jsp"/>
			<%-- <%@include file="VendorList.jsp"%>
			<%@include file="VendorView.jsp"%>
			<%@include file="VendorForm.jsp"%>
			<%@include file="DeleteVendor.jsp"%>  --%>
		</div>
	</div>
</body>
<jsp:include page="/WEB-INF/JSPs/Footer.jsp" />
<script src="<c:url value="/resources/js/vendor1/vendor1.js"/>"></script>
<script src="<c:url value="/resources/js/vendor1/VendorList.js"/>"></script>
<script src="<c:url value="/resources/js/vendor1/ContactPersonList.js"/>"></script>
<script src="<c:url value="/resources/js/vendor1/VendorAddressList.js"/>"></script>
<script src="<c:url value="/resources/js/General/DropDownForLegend.js"/>"></script>
<script src="<c:url value="/resources/js/uniqueid/uniqueid.js"/>"></script>
<script src="<c:url value="/resources/js/General/DropDownForState.js"/>"></script>

<!-- <script type="text/javascript" src="../JavaScripts/VendorList.js"></script>
<script type="text/javascript" src="../JavaScripts/Vendor.js"></script>
<script type="text/javascript" src="../JavaScripts/ContactPersonList.js"></script>
<script type="text/javascript" src="../JavaScripts/ClientAddressList.js"></script> -->

</html>