<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Invoice and Dispatch</title>
<link href="<c:url value="/resources/img/favicon.ico"/>" rel="shortcut icon">
</head>
<body>
<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
	<div class="container">
		<div class="container-fluid">
       		<input type="hidden" id="for" name="for" value="<%= request.getParameter("for") %>">
       		<input type="hidden" id="t" name="t" value="<%= request.getParameter("t")==null?"": request.getParameter("t")%>">
			<div class="card" id="RequisitionTableDiv">
			    <div class="card-body table-responsive-md" style="text-align: center;">
			    	<!-- <h5 class="card-title">Sample List</h5><hr> -->
			    	<div class="alert alert-success alert-dismissible fade show HideThisElement successMsg" role="alert">
					 	<p id="successMsg"></p>
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					    	<span aria-hidden="true">&times;</span>
					  	</button>
					</div>
					<div class="alert alert-danger alert-dismissible fade show HideThisElement errorMsg" role="alert">
						<p id="errorMsg"></p>
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					    	<span aria-hidden="true">&times;</span>
						</button>
					</div>
			    	<table id="datatables" class="table table-hover mb-0 nowrap">
					    <thead>
					        <tr id="headerrow" class="">
					            <th>#</th>
			                    <th>Requisition ID</th>
			                    <th>Requisition Date</th>
			                    <th>Order ID</th>
			                    <th>Order Date</th>
			                    <th>Company Name</th>
			                    <th>Sales Person</th>
			                    <th>No of Items</th>
			                    <th>Invoice ID</th>
			                    <th>Invoice Date</th>
					        </tr>
					    </thead>
					</table>
			    </div>
			</div>
			<%@include file="ViewRequisition.jsp" %>
		</div>
	</div>
<jsp:include page="/WEB-INF/JSPs/Footer.jsp" />	
</body>
 <script src="<c:url value="resources/js/InvoiceDispatch/RequisitionList.js" />"></script>
</html>