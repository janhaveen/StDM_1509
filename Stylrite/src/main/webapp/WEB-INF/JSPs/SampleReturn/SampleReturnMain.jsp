 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Sample</title>
<link rel="shortcut icon" href="../../../img/TitleImage.png">
<!-- <link href="https://cdn.jsdelivr.net/sweetalert2/6.4.1/sweetalert2.css" rel="stylesheet"/>
<script src="https://cdn.jsdelivr.net/sweetalert2/6.4.1/sweetalert2.js"></script> -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<!-- <script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.26.28/dist/sweetalert2.all.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/promise-polyfill"></script> -->
<style type="text/css">
	#prHr, .dt-buttons
	{
		display: none !important;
	}
	.red
	{
		color: red !important;
	}
	.green
	{
		color: green !important;
	}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
	<div class="container">
		<div class="container-fluid">
       		<input type="hidden" id="for" name="for" value="<%= request.getParameter("for") %>">
       		 <jsp:include page="/WEB-INF/JSPs/Sample/SampleList.jsp"/>
       	     <jsp:include page="/WEB-INF/JSPs/Sample/SampleView.jsp"/>
       	     <jsp:include page="/WEB-INF/JSPs/SampleReturn/SampleReturn.jsp"/>
			<%-- <%@include file="DeleteClient.jsp"%> --%>
		</div>
	</div>
	<jsp:include page="/WEB-INF/JSPs/Footer.jsp"/>
</body>
    <script src="<c:url value="/resources/js/SampleReturn/SampleReturn1.js" />"></script>
    <script src="<c:url value="/resources/js/General/DropDownForEmployee.js"/>"></script>
    <!-- <script type="text/javascript" src="../../../js/General/DropDownForEmployee.js"></script> -->
    <script src="<c:url value="/resources/js/General/DropDownForInventoryLegend.js"/>"></script>
    <script src="<c:url value="/resources/js/SampleReturn/ShowReturnProductList.js" />"></script>
    <script src="<c:url value="/resources/js/Sample/SampleList.js" />"></script> 
    <script src="<c:url value="/resources/js/uniqueid/uniqueid.js"/>"></script>
    <link href="https://cdn.jsdelivr.net/sweetalert2/6.4.1/sweetalert2.css" rel="stylesheet"/>
    <script src="https://cdn.jsdelivr.net/sweetalert2/6.4.1/sweetalert2.js"></script>
</html>