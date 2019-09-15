<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">
<head>
<meta charset="UTF-8">
<link href="<c:url value="/resources/img/favicon.ico " />" rel="shortcut icon">
<title>GRN List</title>
</head>
<body>
<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
	<div class="container">
		<div class="container-fluid">
			<div class="card" id="GRNTableDiv">
			    <div class="card-body table-responsive-md">
			    	<input type="hidden" id="grnId">
			    	<table id="grnDatatables" class="table table-hover mb-0 nowrap">
					    <thead>
					        <tr id="headerrow" class="">
					            <th>#</th>
			                    <th>GRN Date</th>
			                    <th>GRN No</th>
			                    <th>Vendor Name</th>
			                     <th>Location</th>
			                    <!-- <th>Contact Person</th> -->
			                    <th>Product Count</th>
			                    <th>Total Qty</th>
					        </tr>
					    </thead>
					</table>
			    </div>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/JSPs/Footer.jsp" />
</body>
<script src="<c:url value="/resources/js/GRN/GRNList.js" />"></script>

</html>