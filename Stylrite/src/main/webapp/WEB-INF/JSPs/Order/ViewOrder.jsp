 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<body>
<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
	<div class="container">
		<div class="container-fluid">
			<div class="card" id="OrderTableDiv" >
    			<div class="card-body table-responsive-md">
    				<input type="hidden" id="oid" value="<%=request.getParameter("oid")%>">
    				<input type="hidden" id="type" name="type" value="<%= request.getParameter("t") %>">
					<table id="ProductData" class="table table-hover mb-0 nowrap">
					    <thead>
					        <tr id="headerrow" class="">
					            <th>#</th>
					            <th>Product Info</th>
					            <th>Sku ID</th>
					            <th>Quantity</th>
					            <th>Status</th>
					        </tr>
					    </thead>
					    <tbody id="ProductDataBody"></tbody>
					 </table>
					 <br>
					 <a href="OrderView.jsp?t=<%= request.getParameter("t") %>" id="Backbtn" class="btn btn-sm btn-primary">Back</a>
				</div>
			</div>									
		</div>
	</div>
</body>
<script src="<c:url value="/resources/js/order/ViewOrder.js"/>"></script>s
</html>