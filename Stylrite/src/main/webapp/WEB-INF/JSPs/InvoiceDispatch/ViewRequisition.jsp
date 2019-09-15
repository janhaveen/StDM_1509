<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <style type="text/css">
.col-sm-1, .col-sm-2{
	padding: 0px;
}
</style>
 -->
 </head>
<body>
<div class="card HideThisElement" id="RequisitionViewDiv">
    <div class="card-body">
    	<!-- div class="row">
    		<div class="col-md-6"><h5 class="card-title">Requisition Details</h5></div>
    		<div class="col-md-6 right"><u><a id="editClick" href="#">Edit</a></u></div>
    	</div> -->
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
    	
    	<div class="row">
    	    <div class="col-md-6"><h5 class="card-title">Basic Requisition Details</h5></div>
    	</div>
    	<hr>
    	<dl class="row">
    		<input type="hidden" id="stockOutId">
		  <dt class="col-sm-2">Requisition ID</dt>
		  <dd class="col-sm-2" id="RequisitionIDText">-</dd>
		   <dt class="col-sm-2">Requisition Date</dt>
		  <dd class="col-sm-2" id="RequisitionDateText">-</dd>
		   <dt class="col-sm-2">Requisition Status</dt>
		  <dd class="col-sm-2" id="RequisitionStatusText">-</dd>
		  <dt class="col-sm-2">Client Name</dt>
		  <dd class="col-sm-2" id="ClientnameText">-</dt>
		  <dt class="col-sm-2">Client Contact Person</dt>
		  <dd class="col-sm-2" id="ClientCpText">-</dd>
		   <dt class="col-sm-2">Contact Number</dt>
		  <dd class="col-sm-2" id="ContactNumberText">-</dd>
		  <dt class="col-sm-2">Billing Address</dt>
		  <dd class="col-sm-2" id="BillingAddressText">-</dd>
		  <dt class="col-sm-2">Delivery Address</dt>
		  <dd class="col-sm-2" id="DeliveryAddressText">-</dd>
		  <dt class="col-sm-2">Sales Person</dt>
		  <dd class="col-sm-2" id="SalesPersonText">-</dd>		 
		  <dt class="col-sm-2 HideThisElement">Invoice Type</dt>
		  <dd class="col-sm-2 HideThisElement" id="InvoiceTypeText">-</dd>
		  <dt class="col-sm-2 HideThisElement">Mode Of Payment</dt>
		  <dd class="col-sm-2 HideThisElement" id="ModeOfPaymentText">-</dd>
		  <dt class="col-sm-2">Order ID</dt>
		  <dd class="col-sm-2" id="OrderIDText">-</dd>
		  <dt class="col-sm-2">Order Date</dt>
		  <dd class="col-sm-2" id="OrderDateText">-</dd>
		  <dt class="col-sm-2">Expected Delivery Date</dt>
		  <dd class="col-sm-2" id="ExpDDText">-</dd>
		  <dt class="col-sm-2">Created By</dt>
		  <dd class="col-sm-2" id="ReqCreatedByText">-</dd>
		  <dt class="col-sm-2">GST Number</dt>
		  <dd class="col-sm-2" id="GSTText">-</dd>
		</dl>
		<hr>
		<div class="row">
    	    <div class="col-md-6"><h5 class="card-title">Requisition Details</h5></div>
    	</div>
		<table id="ProductData1" class="table table-hover mb-0 nowrap">
		    <thead>
		        <tr id="headerrow" class="">
		            <th>#</th>
		            <th>Sku ID</th>
		            <th>Product Info</th>
		            <th>Status</th>
		            <th>Quantity</th>
		            <th>Rate</th>
		            <th>Tax</th>
		            <th>Discount</th>
		            <!-- <th>Amount</th> -->
		        </tr>
		    </thead>
		    <tbody id="ProductDataBody1"></tbody>
		</table><hr>
		<div class="row">
    	    <div class="col-md-12"><h5 class="card-title">Dispatch Details  <i class="fa fa-pencil-alt  editDispatch pull-right"></i></h5></div>
    	    <div class="card-body">
    	    	<dl class="row" id="dispatchView">
					<dt class="col-sm-2">Dispatch Date</dt>
					<dd class="col-sm-2" id="DispatchDateText">-</dd>
					<dt class="col-sm-2">LR No</dt>
					<dd class="col-sm-2" id="LRNoText">-</dd>
					<dt class="col-sm-2">Courier Name</dt>
					<dd class="col-sm-2" id="CourierNameText">-</dd>
					<dt class="col-sm-2">Charges</dt>
					<dd class="col-sm-2" id="ChargesText">-</dt>
					<dt class="col-sm-2">Dispatched By</dt>
					<dd class="col-sm-2" id="DispatchedByText">-</dt>
					<dt class="col-sm-2"></dt>
					<dd class="col-sm-2"></dt>
					<dt class="col-sm-2">Remarks</dt>
					<dd class="col-sm-6" id="DRemarksText">-</dt>
    	    	</dl>
    	    	<form id="formForDispatch" class="HideThisElement">
	    	    	<div class="form-row">
	                    <div class="form-group col-md-4">
	                    	<input type="hidden" id="DispatchId">
	                        <label id="firstNameLbl" for="firstName" class="">Dispatch Date <span class="mandatory-element">*</span></label>
	                        <input type="text" class="form-control datepicker" id="dispatchDate" name="dispatchDate" placeholder="Dispatch Date">
	                    </div>
	                    <div class="form-group col-md-4">
	                       <label id="lastNameLbl" for="lastName" class="">LR No <span class="mandatory-element">*</span></label>
	                       <input type="text" class="form-control" id="LRNO" name="LRNO"  placeholder="LR No">
	                    </div>
	                    <div class="form-group col-md-4">
	                       <label id="lastNameLbl" for="lastName" class="">Courier Name <span class="mandatory-element">*</span></label>
	                       <input type="text" class="form-control" id="CourierName" name="CourierName"  placeholder="Courier Name">
	                    </div>
	                    <div class="form-group col-md-4">
	                       <label id="lastNameLbl" for="charges" class="">Charges <span class="mandatory-element">*</span></label>
	                       <input type="text" class="form-control" id="Charges" name="Charges"  placeholder="Charges">
	                    </div>
	                    <div class="form-group col-md-4">
	                       <label id="DispatchedByLbl" for="DispatchedBy" class="">Dispatched By <span class="mandatory-element">*</span></label>
	                       <input type="text" class="form-control" id="DispatchedBy" name="DispatchedBy"  placeholder="Dispatched By">
	                    </div>
	                    <div class="form-group col-md-12">
	                       <label id="DRemarksLbl" for="DRemarks" class="">Remarks <span class="mandatory-element">*</span></label>
	                       <textarea class="form-control capitalizeText" id="DRemarks" name="DRemarks"  placeholder="Remarks"></textarea>
	                    </div>
	                    <div class="form-group col-md-12">
	                    	<button type="button" id="submitDispatch" class="btn btn-primary">Submit</button>
	                    	<button type="button" id="cancelDispatch" class="btn btn-outline-primary">Cancel</button>	                    	
	                    </div>
	                </div>
    	    	</form>
    	    	<hr>
    	    </div>
    	</div>
    	<div class="row">
    	    <div class="col-md-12"><h5 class="card-title">Invoice Details <i class="fa fa-pencil-alt  editInvoice pull-right"></i></h5></div>
    	    <div class="card-body">
    	    	<dl class="row"  id="invoiceView">
					<dt class="col-sm-2">Invoice Date</dt>
					<dd class="col-sm-2" id="InvoiceDateText">-</dd>
					<dt class="col-sm-2">Invoice No</dt>
					<dd class="col-sm-2" id="InvoiceNoText">-</dd>
					<dt class="col-sm-2">Invoice Amt</dt>
					<dd class="col-sm-2" id="InvoiceAmountText">-</dd>
					<dt class="col-sm-2">Tax Amt</dt>
					<dd class="col-sm-2" id="TaxAmountText">-</dt>
					<dt class="col-sm-2">Accountant</dt>
					<dd class="col-sm-2" id="AccountantText">-</dt>
					<dt class="col-sm-2"></dt>
					<dd class="col-sm-2"></dt>
					<dt class="col-sm-2">Remarks</dt>
					<dd class="col-sm-10" id="IRemarksText">-</dt>
    	    	</dl>
    	    	<form id="formForInvoice" class="HideThisElement">
	    	    	<div class="form-row">
	                    <div class="form-group col-md-4">
	                        <label id="InvoiceDateLbl" for="InvoiceDate" class="">Invoice Date <span class="mandatory-element">*</span></label>
	                        <input type="text" class="form-control datepicker" id="InvoiceDate" name="InvoiceDate" placeholder="Invoice Date">
	                    </div>
	                    <div class="form-group col-md-4">
	                       <label id="InvoiceNoLbl" for="InvoiceNo" class="">Invoice No <span class="mandatory-element">*</span></label>
	                       <input type="text" class="form-control" id="InvoiceNo" name="InvoiceNO"  placeholder="Invoice No">
	                    </div>
	                    <div class="form-group col-md-4">
	                       <label id="InvoiceAmtLbl" for="InvoiceAmt" class="">Invoice Amt<span class="mandatory-element">*</span></label>
	                       <input type="text" class="form-control capitalizeText" id="InvoiceAmt" name="InvoiceAmt"  placeholder="Invoice Amt">
	                    </div>
	                    <div class="form-group col-md-4">
	                       <label id="TaxAmountLbl" for="TaxAmount" class="">Tax Amount <span class="mandatory-element">*</span></label>
	                       <input type="text" class="form-control capitalizeText" id="TaxAmount" name="TaxAmount"  placeholder="Tax Amount">
	                    </div>
	                    <div class="form-group col-md-4">
	                       <label id="AccountantLbl" for="Accountant" class="">Accountant <span class="mandatory-element">*</span></label>
	                       <input type="text" class="form-control capitalizeText" id="Accountant" name="Accountant"  placeholder="Accountant">
	                    </div>
	                    <div class="form-group col-md-12">
	                       <label id="IRemarksLbl" for="IRemarks" class="">Remarks <span class="mandatory-element">*</span></label>
	                       <textarea class="form-control capitalizeText" id="IRemarks" name="IRemarks"  placeholder="Remarks"></textarea>
	                    </div>
	                    <div class="form-group col-md-12">
	                    	<button type="button" id="submitInvoice" class="btn btn-primary">Submit</button>
	                    	<button type="button" id="cancelInvoice" class="btn btn-outline-primary">Cancel</button>
	                    </div>
	                </div>
    	    	</form><hr>
    	    </div>
    	</div>
		<button type="button" class="btn btn-primary " id="SubmitButtonBackFromView">Back</button>	
    </div>    
</div>
</body>
</html>