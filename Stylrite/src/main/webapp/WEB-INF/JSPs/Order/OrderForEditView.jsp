 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="card HideThisElement" id="OrderViewDiv">
<input type="hidden" id="orderId"> 
    <div class="card-body">
    	<!-- div class="row">
    		<div class="col-md-6"><h5 class="card-title">Order Details</h5></div>
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
    	    <div class="col-md-6"><h5 class="card-title">Basic Order Details</h5></div>
    	    <div class="col-md-6 " id="btnPrint"><a style="margin-left: 5px;" class="btn btn-sm btn-primary pull-right" id="printOrderDetails">Order PDF</a>
    	    <a class="btn btn-sm btn-primary pull-right" id="printLocationDetails">Location PDF</a>
    	    </div>
    	</div>
    	<hr>
    	<dl class="row">
		  <dt class="col-sm-2">Order ID</dt>
		  <dd class="col-sm-2" id="OrderIDText">-</dd>
		   <dt class="col-sm-2">Order Date</dt>
		  <dd class="col-sm-2" id="OrderDateText">-</dd>
		   <dt class="col-sm-2">Order Status</dt>
		  <dd class="col-sm-2" id="OrderStatusText">-</dd>
		  <dt class="col-sm-2">Client Name</dt>
		  <dd class="col-sm-2" id="ClientnameText">-</dt>
		  <dt class="col-sm-2"> Contact Person</dt>
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
		  <dt class="col-sm-2">Exp del Date.</dt>
		  <dd class="col-sm-2" id="ExpDDText">-</dd>
		  <dt class="col-sm-2">Ref Number</dt>
		  <dd class="col-sm-2" id="RefNumberText">-</dd>
		  <dt class="col-sm-2">Total Quantity</dt>
		  <dd class="col-sm-2" id="TotalQtyText"></dd>
		  <dt class="col-sm-2">Remarks</dt>
		  <dd class="col-sm-10" id="RemarksText">-</dd>
		</dl>
		<hr>
		<div class="row">
			<div class="col-md-6">
				<h5 class="card-title">Order Details</h5>
			</div>
    	</div>
    	<div id="downloadPdf1">	  
    	    <label class="HideThisElement" style="text-align: center; font-weight: 600;font-size: 25px;margin-bottom: 15px;">STYLRITE OPTICAL INDUSTRIES</label>    	  	
	    	<table class="HideThisElement " style="width:710px;margin-top: 10px;margin-bottom: 15px;">
				<tr>
					<td>Order ID</td>
					<td id="OrderIDText2">-</td>
					<td>Order Date</td>
					<td id="OrderDateText2">-</td>
				</tr>
				<tr>
			          <td>Client Name</td>
			          <td colspan="3" id="ClientnameText2">-</td>			          
				</tr>
				<tr>
					<td>Contact Person</td>
			        <td id="ClientCpText2">-</td>
			        <td>Contact Number</td>
			        <td id="ContactNumberText2">-</td>
				</tr>
				<tr>
			          <td>Billing Address</td>
			          <td colspan="3" id="BillingAddressText2">-</td>
				</tr>
				<tr>
					 <td>Delivery Address</td>
			          <td colspan="3" id="DeliveryAddressText2">-</td>			        				
				</tr>
				<tr>
				  	<td>Sales Person</td>
			         <td id="SalesPersonText2">-</td>				
			          <td>Ref Number</td>
			          <td id="RefNumberText2">-</td>
				 </tr>	
				 <tr>
				  	<td>Expected Delivery Date</td>
			         <td id="ExpDDText2">-</td>
				 </tr>		
			</table>
			<table id="ProductData1" class="table table-hover mb-0 nowrap">
			    <thead>
			        <tr id="headerrow" class="">
			            <th>#</th>
			            <th>Sku ID</th>
			            <th>Product Info</th>
			            <th>Quantity</th>
			            <th>Rate</th>
			            <th>Tax</th>
			            <th>Discount</th>
			           	<th>Status</th>		           
			        </tr>
			    </thead>
			    <tbody id="ProductDataBody1"></tbody>	   
			</table>
		</div>
		<hr>
		<button type="button" class="btn btn-primary btn-sm" id="SubmitButtonBackFromView">Back</button>	
    </div> 
    <div id="DownloadPdf" class="HideThisElement">
    	<label style="text-align: center; font-weight: 600;font-size: 25px;">STYLRITE OPTICAL INDUSTRIES</label>
    	<table style="width:650px;margin-top: 10px;">
            <tr>
                <td class="col-sm-3"><b>Order ID</b></td>
                <td class="col-sm-3" id="OrderIDText1">-</td>
                <td class="col-sm-3"><b>Order Date</b></td>
                <td class="col-sm-3" id="OrderDateText1">-</td>
            </tr>
            <tr>
                <td class="col-sm-3"><b>Client Name</b></td>
                <td class="col-sm-3" id="ClientnameText1">-</td>
                <td class="col-sm-3"><b>Sales Person</b></td>
                <td class="col-sm-3" id="SalesPersonText1">-</td>
            </tr>
        </table><br>
		<table id="ProductData2" class="table table-hover mb-0 nowrap"  style="width:650px;margin-top: 10px;">
		    <thead>
		        <tr id="headerrow" class="">
		            <th>#</th>
		            <th>Sku ID</th>
		            <th>Product Info</th>
		            <th>Quantity</th> 
		            <th>Status</th>		           		            
		            <th>Stock</th> 
		            <th>Sample</th>           
		            <th>Location</th>
		        </tr>
		    </thead>
		    <tbody id="ProductDataBody2"></tbody>	
		 </table>        
    </div>   
</div>
</body>
</html>