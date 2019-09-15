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
  <%--  <%if(request.getParameter("for").equals("newSample")){ %>
		<style type="text/css">
			.HideStatusClass, .HideBarcodeClass{
				display: none;
			}
		</style>
    <% }
   	else if(request.getParameter("for").equals("sampleListDispatched") || request.getParameter("for").equals("sampleListRdyToRcv") || request.getParameter("for").equals("sampleListView")){ %>
		<!-- <script type="text/javascript">console.log("In if");</script> -->
		<style type="text/css">
			.HideActionClass{
				display: none;
			}
		</style>
    <% }%> --%>
</head>
<body>
<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
	<div class="container">
		<div class="container-fluid">
       		<input type="hidden" id="for" name="for" value="<%= request.getParameter("for") %>">
       		 <jsp:include page="/WEB-INF/JSPs/Sample/SampleList.jsp"/>
       	     <jsp:include page="/WEB-INF/JSPs/Sample/SampleView.jsp"/>
       	     <jsp:include page="/WEB-INF/JSPs/Sample/SampleForm.jsp"/>
			<%-- <%@include file="DeleteClient.jsp"%> --%>
		</div>
	</div>
	<jsp:include page="/WEB-INF/JSPs/Footer.jsp"/>
</body>

       <script src="<c:url value="/resources/js/Sample/SampleList.js" />"></script> 
       <script src="<c:url value="/resources/js/Sample/Sample1.js" />"></script>
       <script src="<c:url value="/resources/js/Product/ProductListDatatable.js" />"></script> 
       <script src="<c:url value="/resources/js/General/DropDownForHSN.js" />"></script>
       <script src="<c:url value="/resources/js/General/DropDownForEmployee.js"/>"></script>
       <script src="<c:url value="/resources/js/General/DropDownForLegend.js"/>"></script>
     <%--   <script src="<c:url value="/resources/js/general/DropDownForState.js"/>"></script> --%>
        <script src="<c:url value="/resources/js/General/DropDownForProductLegend.js" />"></script>
       <script src="<c:url value="/resources/js/General/DropDownForInventoryLegend.js"/>"></script>
        <script src="<c:url value="/resources/js/uniqueid/uniqueid.js"/>"></script>
<!-- <script type="text/javascript" src="../../Product/JavaScripts/ProductListDatatable.js"></script>
<script type="text/javascript" src="../JavaScripts/Sample.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForHSN.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForEmployee.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForLegend.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForState.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForInventoryLegend.js"></script>
<link href="https://cdn.jsdelivr.net/sweetalert2/6.4.1/sweetalert2.css" rel="stylesheet"/>
<script src="https://cdn.jsdelivr.net/sweetalert2/6.4.1/sweetalert2.js"></script> -->
</html>