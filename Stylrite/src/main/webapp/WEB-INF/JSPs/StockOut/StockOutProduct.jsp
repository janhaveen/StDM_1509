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
<div class="card HideThisElement" id="StockOutDiv">
 	<div class="card-body">
 		<dl class="row HideThisElement" id="odDetails">
			  <dt class="col-sm-1">Order ID</dt>
			  <dd class="col-sm-2" id="oidText">-</dd>		
			  <dt class="col-sm-2">Company Name</dt>
			  <dd class="col-sm-2" id="cmpnText">-</dd>			
			  <dt class="col-sm-2">Sales Person</dt>
			  <dd class="col-sm-2" id="spText">-</dd>				
 		</dl>
 		<div class="form-row">
	       	<div class="col-md-4">
				<label>Scan Barcode</label>
				<input type="hidden" id="childbarcodeId" name="childbarcodeId">
				<input id="childbarcodeIdText" class="form-control">
			</div>
			<div class="col-md-4">
	       		<button type="button" id="searchbtn" onclick="$('#SelectChildModal').modal('show');" style="margin-top: 7%;" class="btn btn-info">Search</button>
	       		<button type="button" id="takeFromSamplebtn" onclick="$('#TakeFromSample').modal('show');" style="margin-top: 7%;" class="btn btn-info">Take from Sample</button>	       		
	       	</div>
	       	<div class="col-md-4">
	       	</div>
	    </div>
		<div id="hiddenChildBarcodeDiv">
		
		</div>
	      	<hr>
	    <div class="alert alert-success alert-dismissible fade show HideThisElement successMsg" role="alert">
			 <p id="successMsg"></p>
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
		</div>
		<div class="alert alert-warning alert-dismissible fade show HideThisElement warningMsg" role="alert">
			 <p id="warningMsg"></p>
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
	      	<table id="ProductData" class="table table-hover mb-0 nowrap">
		    <thead>
		        <tr id="headerrow" class="">
		            <th>#</th>
		            <th>SKU ID</th>
		            <th>Product Info</th>
		            <th>Ordered Quantity</th>
		            <th class="bq">Balance Quantity</th>
		            <th>Ready</th>
		            <th>Inventory</th>
		            <th>Sample</th>
		            <th>Location</th>
		        </tr>
		    </thead>
		    <tbody id="ProductDataBody"></tbody>
		 </table>
		 <button type="button" id="BackProduct" class="btn btn-sm btn-outline-primary">Back</button>
		 <button type="button" id="submitStockOut" class="btn btn-sm btn-primary">Stock Out</button>
 	</div>
</div>
</body>
</html>