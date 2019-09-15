 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Order</title>
  <link href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.2/css/bootstrap-select.min.css" />" rel="stylesheet">
<style type="text/css">
	#ClientTableDiv .dt-buttons, #prdTblDiv .dt-buttons
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
       		<input type="hidden" id="t" name="t" value="<%= request.getParameter("t") %>">       		
       		<input type="hidden" id="OrderId">
       		 <jsp:include page="/WEB-INF/JSPs/Order/OrderList.jsp"/>
       		 <jsp:include page="/WEB-INF/JSPs/Order/OrderForEditView.jsp"/>
       		 <jsp:include page="/WEB-INF/JSPs/Order/OrderForm.jsp"/>
       		 <jsp:include page="/WEB-INF/JSPs/Order/DeleteOrder.jsp"/>
       		     
		        <%-- 	<%@include file="OrderList.jsp"%> --%>
		     	<%-- <%@include file="OrderForEditView.jsp"%> --%>
			    <%-- <%@include file="OrderForm.jsp"%>
			    <%@include file="DeleteOrder.jsp"%> --%>
		</div>
	</div>
</body>
     <jsp:include page="/WEB-INF/JSPs/Footer.jsp" />
     
    <script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.2/js/bootstrap-select.min.js" />"></script>
      <script src="<c:url value="/resources/js/Client/ClientAddressList.js"/>"></script>  
      <script src="<c:url value="/resources/js/Client/ClientList.js"/>"></script>
      <script src="<c:url value="/resources/js/Client/ContactPersonList.js"/>"></script>
      <script src="<c:url value="/resources/js/Client/ClientInfo.js"/>"></script>
      <script src="<c:url value="/resources/js/General/DropDownForEmployee.js"/>"></script>
      <script src="<c:url value="/resources/js/Order/Order.js"/>"></script>
      <script src="<c:url value="/resources/js/Order/OrderListMain.js"/>"></script> 
      <script src="<c:url value="/resources/js/Product/ProductListDatatable.js" />"></script> 
      <script src="<c:url value="/resources/js/Order/EditOrder.js"/>"></script> 
      <script src="<c:url value="/resources/js/uniqueid/uniqueid.js"/>"></script>
      <script src="<c:url value="/resources/js/General/DropDownForProductLegend.js"/>"></script>
      <script src="<c:url value="/resources/js/General/DropDownForHSN.js" />"></script>
      <script src="<c:url value="/resources/js/General/DropDownForLegend.js"/>"></script>
      <script src="<c:url value="/resources/js/General/DropDownForState.js"/>"></script>
	 <!-- <script type="text/javascript" src="../../Product/JavaScripts/ProductListDatatable.js"></script>
	 <script type="text/javascript" src="../../Client/JavaScripts/ClientAddressList.js"></script>
	 <script type="text/javascript" src="../../Client/JavaScripts/ClientList.js"></script>
	<script type="text/javascript" src="../../Client/JavaScripts/ContactPersonList.js"></script>
	<script type="text/javascript" src="../JavaScripts/Order.js"></script>
	<script type="text/javascript" src="../JavaScripts/OrderListMain.js"></script>	
	<script type="text/javascript" src="../JavaScripts/EditOrder.js"></script>	
	<script type="text/javascript" src="../../Client/JavaScripts/ClientInfo.js"></script>
	<script type="text/javascript" src="../../../js/General/DropDownForEmployee.js"></script>
	<script type="text/javascript" src="../../../js/General/DropDownForLegend.js"></script>
    <script type="text/javascript" src="../../../js/General/DropDownForHSN.js"></script>
    <script type="text/javascript" src="../../../js/General/DropDownForState.js"></script>
    <script type="text/javascript" src="../../../js/General/DropDownForInventoryLegend.js"></script> -->
    </html>