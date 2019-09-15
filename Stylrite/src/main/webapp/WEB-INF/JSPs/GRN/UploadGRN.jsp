<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link href="<c:url value="/resources/img/favicon.ico" />" rel="shortcut icon">
<link href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.2/css/bootstrap-select.min.css" />" rel="stylesheet">
<style type="text/css">
#prHr, .dt-buttons{
	display: none	!important;
}
</style>
<title>Upload GRN</title>
</head>
<body>
<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
	<div class="container">
		<div class="container-fluid">
			<div class="card" id="uploadGRNDiv">
    			<div class="card-body">
    				<!-- <h5 class="card-title">Stock In</h5><hr> -->
    				<form name="purchaseDetailsForm" id="purchaseDetailsForm">
    				<input type="hidden" id="grnId">
				        <p style="font-size: 120%;margin-bottom: 1%;"> Purchase Details</p>
				        <hr>
						<jsp:include page="/WEB-INF/JSPs/GRN/VendorDetails.jsp" /><hr>
						 <br>
						 <p style="font-size: 120%;margin-bottom: 1%;"> Product Details</p>
						 <hr>
						  <div class="col-md-12" id="productInfoDiv">
                              <div class="form-row">
                                  <div class="form-group col-md-12">
                                  
                                  <section>
										 <input type="file" id="fileUpload" accept=".csv "/>
										<input class="btn btn-sm btn-primary" type="button" id="upload" value="Upload" onclick="Upload()" />
										<hr />
										<div id="dvCSV">
										</div>
										<hr/>
										   <input type="button" class="btn btn-sm btn-primary HideThisElement" id="import" value="Import" onclick="importajex()"/>
									    </section>
                                         <br>
                                  </div>
                              </div>
                          </div>
					        <div class="col-md-12 HideThisElement" id="productListDiv">			        
					        	<table id="ProductData" class="table table-hover mb-0 nowrap">
								    <thead>
								        <tr id="headerrow" class="">
								            <th>#</th>
								            <th>Brand</th>
								            <th>Model No</th>
								            <th>Color</th>
								            <th>Size</th>
								            <th>Type</th>
								            <th>Quantity</th>
								            <th>Cost/Unit</th>
								        </tr>
								    </thead>
								    <tbody id="ProductDataBody"></tbody>
								 </table>
				        	</div>
				        	<hr>
				        <jsp:include page="/WEB-INF/JSPs/GRN/ReceiptDetails.jsp" />
				        <br>
						 <button type="button" id="clear" class="btn btn-sm btn-outline-primary">Clear</button>
						 <button type="button" id="submitProductGRN" class="btn btn-sm btn-primary">Receive</button>
						 <button type="button" id="GenerateBarcode" class="btn btn-sm btn-primary HideThisElement">Generate Barcode</button>
			        </form>
			        <br>
			    </div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/JSPs/Footer.jsp" />
</body>
<script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.2/js/bootstrap-select.min.js" />"></script>

  <script src="<c:url value="/resources/js/GRN/UploadGRN.js" />"></script>
  <script src="<c:url value="/resources/js/vendor1/VendorAddressList.js" />"></script>
  <script src="<c:url value="/resources/js/vendor1/VendorList.js" />"></script>
  <script src="<c:url value="/resources/js/vendor1/ContactPersonList.js" />"></script>
  <script src="<c:url value="/resources/js/vendor1/VendorInfo.js" />"></script>
  <script src="<c:url value="/resources/js/general/DropDownForProductLegend.js" />"></script>
  <script src="<c:url value="/resources/js/general/DropDownForHSN.js" />"></script>
  <script src="<c:url value="/resources/js/uniqueid/uniqueid.js"/>"></script>
</html>