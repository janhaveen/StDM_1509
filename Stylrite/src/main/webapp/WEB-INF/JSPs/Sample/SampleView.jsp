 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Client</title>
</head>
<body>
<div class="card HideThisElement" id="SampleViewDiv">
    <div class="card-body">
    	<div class="row">
    		<div class="col-md-6"><h5 class="card-title">Details</h5></div>
    		<!-- <div class="col-md-6 right"><u><a id="editClick" href="#">Edit</a></u></div> -->
    	</div>
    	<hr>
    	<dl class="row">
		  <dt class="col-sm-2">Reason</dt>
		  <dd class="col-sm-2" id="ReasonText"></dd>
		  <dt class="col-sm-2">Expected Receipt Date</dt>
		  <dd class="col-sm-2" id="expectedReceiptDateText"></dd>
		  <dt class="col-sm-2">Mode Of Delivery</dt>
		  <dd class="col-sm-2" id="modeOfDeliveryText"></dd>
		  <dt class="col-sm-2">Dispatched Date</dt>
		  <dd class="col-sm-2" id="dispatchedDateText"></dd>
		  <dt class="col-sm-2">Transport Name</dt>
		  <dd class="col-sm-2" id="transportNameText"></dd>
		  <dt class="col-sm-2">Tracking ID</dt>
		  <dd class="col-sm-2" id="trackingIDText"></dd>
		  <dt class="col-sm-2">E-Bill No</dt>
		  <dd class="col-sm-2" id="eBillNoText"></dd>
		  <dt class="col-sm-2">Receipt Date</dt>
		  <dd class="col-sm-2" id="receiptDateText"></dd>
		</dl>
    	<dl class="row">
		  <dt class="col-sm-2">Remarks</dt>
		  <dd class="col-sm-10" id="remarksDiv"></dd>
		  <!-- <dt class="col-sm-2">Expected Receipt Date</dt>
		  <dd class="col-sm-2" id="expectedReceiptDateText"></dd> -->
		  <!-- <dt class="col-sm-2">Remarks</dt>
		  <dd class="col-sm-2" id="remarksText"></dd>
		  <dt class="col-sm-2">Source</dt>
		  <dd class="col-sm-2" id="sourceText"></dd>
		  <dt class="col-sm-2">Credit Time</dt>
		  <dd class="col-sm-2" id="creditTimeText"></dd>
		  <dt class="col-sm-2">Credit Limit</dt>
		  <dd class="col-sm-2" id="creditLimitText"></dd>
		  <dt class="col-sm-2">Sales Person</dt>
		  <dd class="col-sm-2" id="salesPersonText"></dd> -->
		</dl>
	   	<!-- <div id="remarksDiv"></div> -->
		<!-- <h5 class="card-title">Other Details</h5> -->
		<!-- <dl class="row"> -->
        <!-- <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item">
                <a class="nav-link active" id="AnalyticsDetails-tab" data-toggle="tab" href="#AnalyticsDetails" role="tab" aria-controls="ClientDetails" aria-selected="true">Analytics</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="ContactPersonList-tab" data-toggle="tab" href="#ContactPersonList" role="tab" aria-controls="ContactPersonList" aria-selected="false">Contact Person</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="AddressList-tab" data-toggle="tab" href="#AddressList" role="tab" aria-controls="AddressList" aria-selected="true">Address</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="Inquiry-tab" data-toggle="tab" href="#InquiryDetails" role="tab" aria-controls="InquiryDetails" aria-selected="true">Inquiry</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="Order-tab" data-toggle="tab" href="#OrderDetails" role="tab" aria-controls="OrderDetails" aria-selected="true">Order</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="Invoice-tab" data-toggle="tab" href="#InvoiceDetails" role="tab" aria-controls="InvoiceDetails" aria-selected="true">Invoice</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="Payment-tab" data-toggle="tab" href="#PaymentDetails" role="tab" aria-controls="PaymentDetails" aria-selected="true">Payment</a>
            </li>
        </ul> -->
		<%-- <form action="" id="" name=>
			<!-- <div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
	        <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
	        <div class="alert alert-success HideThisElement" id="successMessage"></div> -->
	        <!-- <input type="hidden" name="selectedClientId" id="selectedClientId">
	        <input type="hidden" name="selectedClientAddressId" id="selectedClientAddressId">
	        <input type="hidden" name="selectedClientContactPersonId" id="selectedClientContactPersonId"> -->
	        <!-- <input type="hidden" name="action" id="action"> -->
	        <div class="tab-content" id="myTabContentView">
	            <div class="tab-pane fade show active" id="AnalyticsDetails" role="tabpanel" aria-labelledby="AnalyticsDetails-tab">
	                <div class="form-row">
	                	Analytic Tab
	                </div>
	            </div>
	            <div class="tab-pane fade" id="ContactPersonList" role="tabpanel" aria-labelledby="ContactPersonList-tab">
	            	<%@include file="ContactPersonList.jsp" %>
	            </div>
	            <div class="tab-pane fade" id="AddressList" role="tabpanel" aria-labelledby="AddressList-tab">
	            	<%@include file="AddressList.jsp" %>
	            </div>
	            <div class="tab-pane fade" id="InquiryDetails" role="tabpanel" aria-labelledby="Inquiry-tab">
	                <div class="form-row">
	                	Inquiry Tab
	                </div>
	            </div>
	            <div class="tab-pane fade" id="OrderDetails" role="tabpanel" aria-labelledby="Order-tab">
	                <div class="form-row">
	                	Order Tab
	                </div>
	            </div>
	            <div class="tab-pane fade" id="InvoiceDetails" role="tabpanel" aria-labelledby="Invoice-tab">
	                <div class="form-row">
	                	Invoice Tab
	                </div>
	            </div>
	            <div class="tab-pane fade" id="PaymentDetails" role="tabpanel" aria-labelledby="Payment-tab">
	                <div class="form-row">
	                	Payment Tab
	                </div>
	            </div>
	        </div>
	        <!-- <div class="left">
		        <button type="button" class="btn btn-primary HideThisElement" id="SubmitButtonRegister">Submit</button>
		        <button type="button" class="btn btn-primary HideThisElement" id="SubmitButtonUpdate">Update</button>
		        <button type="button" class="btn btn-primary " id="SubmitButtonBack">Back</button>
		    </div> -->
        </form> --%>
		<!-- </dl> -->
		<!-- <h5 class="card-title">Salary Details</h5>
		<dl class="row">
		  <dt class="col-sm-2">Joining Date</dt>
		  <dd class="col-sm-2" id="JoiningText">Firstname</dd>
		  <dt class="col-sm-2">Basic Salary</dt>
		  <dd class="col-sm-2" id="BasicSalaryText">Firstname</dd>
		  <dt class="col-sm-2">Travel Allowance (TA)</dt>
		  <dd class="col-sm-2" id="TAText">Firstname</dd>
		  <dt class="col-sm-2">Dearness Allowance (DA)</dt>
		  <dd class="col-sm-2" id="DAText">Firstname</dd>
		  <dt class="col-sm-2">House Rent Allowance (HRA)</dt>
		  <dd class="col-sm-2" id="HRAText">Firstname</dd>
		  <dt class="col-sm-2">Conveyance Allowance</dt>
		  <dd class="col-sm-2" id="CAText">Firstname</dd>
		  <dt class="col-sm-2">Special Allowance</dt>
		  <dd class="col-sm-2" id="SAText">Firstname</dd>
		  <dt class="col-sm-2">Variable Salary</dt>
		  <dd class="col-sm-2" id="VSText">Firstname</dd>
		</dl>
		<h6><li>Deduction</li></h6>
		<dl class="row">
			<dt class="col-sm-2">Employee's Provident Fund (EPF)</dt>
			<dd class="col-sm-2" id="EPFText">Firstname</dd>
			<dt class="col-sm-2">ESIC (Employee Contribution)</dt>
			<dd class="col-sm-2" id="ESICText">Firstname</dd>
			<dt class="col-sm-2">Professional Tax (PT)</dt>
			<dd class="col-sm-2" id="PTText">Firstname</dd>
			<dt class="col-sm-2">Mediclaim</dt>
			<dd class="col-sm-2" id="MediclaimText">Firstname</dd>
			<dt class="col-sm-2">Statutory Bonus</dt>
			<dd class="col-sm-2" id="StatutoryText">Statutory Bonus</dd>
		</dl>
		<hr>
		<h5 class="card-title">Account Details</h5>
		<dl class="row">
		  <dt class="col-sm-2">Account No</dt>
		  <dd class="col-sm-2" id="AccountNoText">Firstname</dd>
		  <dt class="col-sm-2">Bank Name</dt>
		  <dd class="col-sm-2" id=BankNameText">Firstname</dd>
		  <dt class="col-sm-2">Bank Branch</dt>
		  <dd class="col-sm-2" id="BankBranchText">Bank Branch</dd>
		  <dt class="col-sm-2">IFSC COde</dt>
		  <dd class="col-sm-2" id="IFSCText">Firstname</dd>
		</dl> -->
	 	 <!-- <div class="card HideThisElement" id="SampleFormProductListDiv1">
	    <div class="card-body" style="padding-bottom: 0;">
    		<h5 class="card-title">Product Info</h5><hr>
			</div>
	    	<table id="ProductData" class="table table-hover mb-0 nowrap">
			    <thead>
			        <tr id="headerrow" class="" style="text-align: center;">
			            <th class="HideActionClass">Action</th>
			            <th>SKU ID</th>
			            <th>Product Info</th>
			            <th class="HideThisElement">Product Status</th>
			            <th class="HideActionClass">Barcode</th>
			        </tr>
			    </thead>
			    <tbody id="ProductDataBody" style="text-align: center;"></tbody>
			</table><br>
	    </div> -->
    </div> 
    </div>
    <!-- <button type="button" class="btn btn-primary " id="SubmitButtonBackFromView">Back</button> -->
</div>
</body>
</html>