<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="../../../img/TitleImage.png">
<title>Empty Location</title>
</head>
<body>
<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
	<div class="container">
		<div class="container-fluid">
			<div class="card" id="BarcodeTableDiv">
			    <div class="card-body table-responsive-md">
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
			    	<table id="BoxDatatables" class="table table-hover mb-0 nowrap">
					    <thead>
					        <tr id="headerrow" class="">
					            <th>#</th>
			                    <th>Floor</th>
			                    <th>Aisle</th>
			                    <th>Rack</th>
			                    <th>Section</th>
			                    <th>Location</th>
					        </tr>
					    </thead>
					</table>
			    </div>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/JSPs/Footer.jsp" />
</body>
<script src="<c:url value="/resources/js/Barcode/EmptyLocation.js"/>"></script> 
</html>