<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="modal fade" id="SelectChildModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
 	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-body">
	      		<div class="col-md-12">
	      			<div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
			        <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
			        <div class="alert alert-success HideThisElement" id="successMessage"></div>
					<label>Enter Barcode</label>
					<input id="childbarcodeIdTextA" class="form-control"><br>
					<button type="button" id="findbtn" class="btn btn-sm btn-info">Search</button>					
				</div>
	      </div>
	    </div>
  	</div>
</div>		
</body>
</html>