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
#OrderTableDiv .dt-button{
	display: none	!important;
}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
	<div class="container" id="tableDiv">
		<div class="container-fluid">
       		<input type="hidden" id="type" name="type" value="a">
       		<jsp:include page="/WEB-INF/JSPs/Order/OrderList.jsp"/>
		</div>
	</div>
	<div class="container HideThisElement" id="ViewDiv">
		<div class="container-fluid">
			<div class="card" id="OrderTableDiv" >
    			<div class="card-body table-responsive-md">
    				<input type="hidden" id="oid" value="<%=request.getParameter("oid")%>">
    				<input type="hidden" id="type" name="type" value="c">
					<table id="ProductData" class="table table-hover mb-0 nowrap">
					    <thead>
					        <tr id="headerrow" class="">
					            <th>#</th>
					            <!-- <th>Product Info</th> -->
					            <th>Sku ID</th>
					            <th>Quantity</th>
					            <th>Fulfilled</th>
					            <th>Cancelled</th>
					            <th>Status</th>
					        </tr>
					    </thead>
					    <tbody id="ProductDataBody"></tbody>
					 </table>
					 <br>
					 <button id="Backbtn" class="btn btn-sm btn-primary">Back</button>
				</div>
			</div>									
		</div>
	</div>
</body>
 <jsp:include page="/WEB-INF/JSPs/Footer.jsp" />
    <script src="<c:url value="/resources/js/ListOrders/OrderStatus.js"/>"></script>
</html>