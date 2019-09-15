<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>View GRN</title>
<link href="<c:url value="/resources/img/favicon.ico" />" rel="shortcut icon">
</head>
<body>
<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
	<div class="container">
		<div class="container-fluid">
			<div class="card" id="StockInDiv">
    			<div class="card-body">
    			 	<p style="font-size: 120%;margin-bottom: 1%;"> Purchase Details</p>
    			 	 <hr>
    			 	<input type="hidden" id="grnId" name = "grnId" value ="${grnId}">
    			 	<jsp:include page="/WEB-INF/JSPs/GRN/VendorDetailsView.jsp" />
          			 <hr>
          			 <div id="productDiv" class="HideThisElement">
						 <p style="font-size: 120%;margin-bottom: 1%;"> Product Data</p>
						 <div class="col-md-12" style="text-align: right;margin-top: -3%;">
							 <button type="button" id="deleteBarCodeInGRN" class="btn btn-sm btn-danger">Delete BarCode</button>
							<button type="button" id="ExportasCSV" class="btn btn-sm btn-primary">Export as CSV</button>
						 </div>
						  <br>
						 <table id="ProductViewData" class="table table-hover mb-0 nowrap">
						    <thead>
						        <tr id="headerrow" class="">
						            <th>#</th>
						            <th>Sku ID</th>
						            <th>Product Info</th>
						            <th>Barcode</th>
						            <th>Quantity</th>
						            <th>Cost/Unit</th>
						        </tr>
						    </thead>
						    <tbody id="ProductViewDataBody"></tbody>
						 </table>
						 <button type="button" id="GenerateBarcode" class="btn btn-sm btn-primary HideThisElement">Generate Barcode</button>
						 <a type="button" class="btn btn-sm btn-primary" href="listGRN">Back</a>
					 </div>
    			</div>
    		</div>
    	</div>
    </div>
 <jsp:include page="/WEB-INF/JSPs/Footer.jsp" />
</body>
 <script src="<c:url value="/resources/js/GRN/ViewGRN.js" />"></script>
</html>