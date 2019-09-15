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
<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
	 <div class="container">
		<div class="container-fluid">
			<div class="card" id="StockInDiv">
	    		<div class="card-body">
	    			<form>
	    				<div class="form-row">
				              <div class="form-group col-md-3" id="brandFrm">
				                  <label id="brandLbl" for="brand" class="">Brand <span class="mandatory-element">*</span></label><br>
				                    <select class="selectpicker" data-live-search="true" id="brand"  name="brand" style="width: 100%;">
				                    	<option value="select Brand"></option>
				  					</select>
				              </div>
						</div>
					</form>
			        <br>
			        <div class="form-row">
						<div class="col-md-12">
							<table class="table table-sm" border="1">
								<tr>
									<td>SRT1-0101A-06</td>
									<td>SRT1-0101A-05</td>
									<td>SRT1-0101A-04</td>
									<td>SRT1-0101A-03</td>
									<td>SRT1-0101A-02</td>
									<td>SRT1-0101A-01</td>
								</tr>
								<tr>
									<td>SRT1-0102A-05</td>
									<td>SRT1-0102A-06</td>
									<td>SRT1-0102A-02</td>
									<td>SRT1-0102A-01</td>
									<td>SRT1-0102A-04</td>
									<td>SRT1-0102A-01</td>
								</tr>
								<tr>
									<td>SRT1-0103A-06</td>
									<td>SRT1-0103A-05</td>
									<td>SRT1-0103A-04</td>
									<td>SRT1-0103A-03</td>
									<td>SRT1-0103A-02</td>
									<td>SRT1-0103A-01</td>
								</tr>
								<tr>
									<td>SRT1-0104A-05</td>
									<td>SRT1-0104A-06</td>
									<td>SRT1-0104A-02</td>
									<td>SRT1-0104A-01</td>
									<td>SRT1-0104A-04</td>
									<td>SRT1-0104A-01</td>
								</tr>
							</table>
						</div><br>
						<div class="col-md-4">
							<label>Select Box</label>
							<input type="hidden" id="barcodeId" name="barcodeId">
							<input id="barcodeText" class="form-control" value="SRT1-0104A-05">
							<p id="errorForBarcode" class="mandatory-element HideThisElement"></p>
						</div><br>
						<div class="col-md-12" id="boxInfoDiv" style="margin-top:20px;">
			        	<div class="card card-body"><h6>Box Info</h6> 
			        	<dl class="row">
		  					<dt class="col-sm-2">Location:</dt>
		  					<dt class="col-sm-2" id="LocationText">SRT1-0104A-05</dt>
		  					<dt class="col-sm-2">Capacity:</dt>
		  					<dt class="col-sm-2" id="CapacityText">12</dt>
		  					<dt class="col-sm-2">Available Space:</dt>
		  					<dt class="col-sm-2" id="SpaceText">12</dt>
			        	</dl></div><br>
			        	<div class="form-row">
				        	<div class="col-md-4">
								<label>Scan Barcode</label>
								<input type="hidden" id="childbarcodeId" name="childbarcodeId">
								<input id="childbarcodeIdText" class="form-control">
							</div>
							<div class="col-md-4">
								<!-- <label for="barcodeValTxt" is="barcodeValTxtLbl"></label> -->
				        		<button type="button" name="searchbtn" onclick="$('#SelectChildModal').modal('show');" style="margin-top: 7%;" class="btn btn-info">Search</button>
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
						            <th>Product Info</th>
						            <th>Quantity</th>
						            <th>Cost/Unit</th>
						        </tr>
						    </thead>
						    <tbody id="ProductDataBody"></tbody>
						 </table>
						 <button type="button" id="DeleteProduct" class="btn btn-sm btn-outline-primary">Delete</button>
						 <button type="button" id="submitStockIn" class="btn btn-sm btn-primary">Stock In</button>
		        	</div>
			        </div>
	    		</div>
	    	</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/JSPs/Footer.jsp" />
 </body>
<script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.2/js/bootstrap-select.min.js" />"></script>  
 <script src="<c:url value="/resources/js/General/DropDownForProductLegend.js" />"></script>
 <script type="text/javascript">
	DropDownForProductLegend();
 </script>
</html>