 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Available Stock</title>
<link rel="shortcut icon" href="../../../img/TitleImage.png">
</head>
<body>
<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
	<div class="container">
		<div class="container-fluid">
		<div class="card" id="ProductTableDiv">
		    <div class="card-body table-responsive-md">
		    	<table id="ProductDatatables" class="table table-hover mb-0 nowrap">
				    <thead>
				        <tr id="headerrow" class="">
				            <th>#</th>
				            <th>Issue To</th>
				            <th>Product Info</th>
				            <th>Issue Date</th>
				        </tr>				        
				    </thead>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
<script src="<c:url value="/resources/js/Sample/SampleListView.js" />"></script>

</html>