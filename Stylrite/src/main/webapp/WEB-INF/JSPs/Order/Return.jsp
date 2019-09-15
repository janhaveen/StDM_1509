<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>
<link rel="shortcut icon" href="../../../img/TitleImage.png">
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
       		<input type="hidden" id="OrderId">
			<%@include file="OrderList.jsp"%>
			<%@include file="OrderForEditView.jsp"%>
			<%@include file="OrderForm.jsp"%>
			<%@include file="DeleteOrder.jsp"%>
		</div>
	</div>
</body>
	<script type="text/javascript" src="../JavaScripts/OrderList.js"></script>
	<script type="text/javascript" src="../JavaScripts/EditOrder.js"></script>
	<script type="text/javascript" src="../../Product/JavaScripts/ProductListDatatable.js"></script>
	<script type="text/javascript" src="../../Client/JavaScripts/ClientAddressList.js"></script>
	<script type="text/javascript" src="../../Client/JavaScripts/ClientList.js"></script>
	<script type="text/javascript" src="../../Client/JavaScripts/ContactPersonList.js"></script>
	<script type="text/javascript" src="../JavaScripts/Order.js"></script>
	<script type="text/javascript" src="../../Client/JavaScripts/ClientInfo.js"></script>
	<script type="text/javascript" src="../../../js/General/DropDownForEmployee.js"></script>
	<script type="text/javascript" src="../../../js/General/DropDownForLegend.js"></script>
	
<script type="text/javascript" src="../../../js/General/DropDownForHSN.js"></script>
	
<script type="text/javascript" src="../../../js/General/DropDownForState.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForInventoryLegend.js"></script>
</html>