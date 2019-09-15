 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Sample Transfer</title>
<link rel="shortcut icon" href="../../../img/TitleImage.png">
<style type="text/css">
#motDiv, .ret{
	display: none 	!important;
}
#prHr, .dt-buttons
{
	display: none !important;
}
</style>
</head>
<body>
<%-- <jsp:include page="/WEB-INF/JSPs/Header.jsp" />
	<div class="container">
		<div class="container-fluid"> --%>
		<div class="card" id="SampleTransferFormDiv">
			  <div class="card" >
   				 <div class="card-body" style="padding-bottom: 0px;">
   				  <jsp:include page="/WEB-INF/JSPs/Sample/SampleTransferDetails.jsp"/>
   				 </div>
   			  </div>
   			  <div class="card">
   				 <div class="card-body" style="padding-bottom: 0px;">
   				    <jsp:include page="/WEB-INF/JSPs/SampleTransfer/SampleTransferProductList.jsp"/>
   				  <%--  <jsp:include page="/WEB-INF/JSPs/SampleTransfer/SampleTransferProductList.jsp"/> --%>
   				 </div>
   				 	<br>
   				 	<!-- <button type="button" id="BackProduct" class="btn btn-sm btn-outline-primary">Back</button> -->
					<button type="button" id="submitReturn" class="btn btn-sm btn-primary">Transfer</button>
   				 </div>
   			  </div>
   			  <div class="card HideThisElement"  id="ViewBarcodeDiv">
    			<div class="card-body">
					<div class="row">
						<div class="col-md-12" style="text-align: right;">
						<button type="button" id="ExportasCSV" class="btn btn-sm btn-primary">Export as CSV</button>
						</div>
						<div class="col-md-12">
						    <div class="alert alert-success alert-dismissible fade show  successMsg" role="alert">
								 <p id="successMsg"></p>
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
								    <span aria-hidden="true">×</span>
								  </button>
							</div>
					    </div>
					</div><br>
					<div class="row">
						<div class="col-md-12">
							<div id="GeneratedChildBarcodeDiv"></div>
						</div>
					</div>
    			</div>
    		</div>
    		    <div class="card HideThisElement" id="SampleFormProductListDiv">
	    <div class="card-body" style="padding-bottom: 0;">
    		<h5 class="card-title">Product Info</h5><!-- <hr> -->
			<div class="alert alert-warning HideThisElement row" id="alertMessage" style="background-color: #ffbb33">
                <!-- <div class="col-md-10">
					<p id="alertPTag"></p>
                </div>
                <div class="col-md-2">
					<button type="button" class="btn btn-primary btn-sm" id="alertConfirmBtn">Confirm</button>
					<button type="button" class="btn btn-primary btn-sm" id="alertCloseBtn">Close</button>
				</div> -->
			</div>
	    	<table id="ProductData" class="table table-hover mb-0 nowrap">
			    <thead>
			        <tr id="headerrow" class="" style="text-align: center;">
			            <th class="HideActionClass">Action</th>
			            <th>SKU ID</th>
			            <th>Product Info</th>
			            <th class="HideThisElement">Product Status</th>
			            <!-- <th class="HideActionClass">Barcode</th> -->
			        </tr>
			    </thead>
			    <tbody id="ProductDataBody" style="text-align: center;"></tbody>
			</table><br>
	       <!--  <div class="row HideThisElement" id="updateBtnDiv">
                <div class="form-group col-md-6" style="margin: 0;">
                	<div class="form-group">
                    	<label id="updateRemarksLbl" for="updateRemarks" class="">Remarks</label>
                		<textarea class="form-control" rows="5" id="updateRemarks" placeholder="Enter Remarks"></textarea>
                    </div>
                </div>
                <div class="form-group col-md-6" style="margin: 0;padding-top: 28px;">
			        <div class="row">
                		<div class="form-group col-md-12">
			        		<button type="button" class="btn btn-primary HideThisElement" id="SubmitButtonUpdate">Update</button>
                		</div>
			        </div>
			        <div class="row">
                		<div class="form-group col-md-12">
			        		<button type="button" class="btn btn-primary" id="BackButtonUpdate">Back</button>
                		</div>
			        </div>
                </div>
	        </div> -->
	       
	    </div>
    </div>
	<!-- 	</div>
	</div> -->
	<%-- <jsp:include page="/WEB-INF/JSPs/Footer.jsp"/> --%>
</body>
  
</html>