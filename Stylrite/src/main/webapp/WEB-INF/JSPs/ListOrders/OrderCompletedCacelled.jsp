 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order List</title>
<link rel="shortcut icon" href="../../../img/TitleImage.png">
<style type="text/css">
#OrderTableDiv .dt-button, #btnPrint{
	display: none	!important;
}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/JSPs/Header.jsp" />>
	<div class="container" id="tableDiv">
		<div class="container-fluid">
       		<input type="hidden" id="type1" name="type1" value="<%=request.getParameter("t1") %>">
       		<jsp:include page="/WEB-INF/JSPs/Order/OrderList.jsp"/>
       		<jsp:include page="/WEB-INF/JSPs/Order/OrderForEditView.jsp"/>
			<%-- <%@include file="../../Order/JSPs/OrderList.jsp"%>
			<%@include file="../../Order/JSPs/OrderForEditView.jsp"%> --%>
		</div>
	</div>
	<%-- <div class="container HideThisElement" id="ViewDiv">
		<div class="container-fluid">
			<div class="card" id="OrderTableDiv" >
    			<div class="card-body table-responsive-md">
    				<input type="hidden" id="oid" value="<%=request.getParameter("oid")%>">
    				<input type="hidden" id="type" name="type" value="p">
					<table id="ProductData" class="table table-hover mb-0 nowrap">
					    <thead>
					        <tr id="headerrow" class="">
					            <th>#</th>
					            <th>Sku ID</th>
					            <th>Product Info</th>				            
					            <th>Order Quantity</th>
					            <th>Balance Quantity</th>
					            <!-- <th>Blocked Quantity</th> -->
					            <th>Status</th>
					        </tr>
					    </thead>
					    <tbody id="ProductDataBody"></tbody>
					 </table>
					 <br>
					 <div class="form-group col-md-12">
                       <label id="RemarksLbl" for="Remarks" class="">Remarks <span class="mandatory-element">*</span></label>
                       <textarea class="form-control capitalizeText" id="Remarks" name="Remarks"  placeholder="Remarks"></textarea>
                     </div>
					 <button id="Cancelbtn" class="btn btn-sm btn-primary">Cancel</button>
					 <button id="Backbtn" class="btn btn-sm btn-outline-primary">Back</button>
				</div>
			</div>									
		</div>
	</div> --%>
</body>
 <jsp:include page="/WEB-INF/JSPs/Footer.jsp" />
    <script src="<c:url value="/resources/js/ListOrders/OrderCompletedCacelled.js"/>"></script>
</html>