<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html lang="en">

            <head>
<meta charset="UTF-8">
<title>Client</title>
<style type="text/css">
    .searchIcon {
        float: left;
        margin-left: 10px;
        margin-top: -23px;
        position: relative;
       /*  z-index: 2; */
    }
</style>
</head>
<body>
    
    
    	<h5 class="card-title">Client Info</h5><hr> 
		<form action="" id="clientInfoForm">
			<div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
	        <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
	        <div class="alert alert-success HideThisElement" id="successMessage"></div>
	        <input type="hidden" name="action" id="action">
	        <div class="" id="myTabContent">
	        <div class="form-group col-md-3">
                            <label for="clientName">Client Id <span class="mandatory-element">*</span></label>
                            <input type="text" class="form-control" name="clientId1" id="clientId" placeholder="client Id ">
                        </div>
                   </div>
	            <!-- <div class="tab-pane fade show active" id="ClientDetails" role="tabpanel" aria-labelledby="ClientDetails-tab"> -->
                <div class="form-row">
                    <div class="col-md-6">
	                    <!-- <div class="form-group"> -->
	       					<input type="hidden" name="clientId" id="selectedClientId">
	                        <label for="reason">Client <span class="mandatory-element">*</span></label>
	                        <input type="text" id="clientName" name="clientName" class="form-control" class="form-control" style="padding-left: 30px;" disabled>
			            	<i class="fa fa-search prefix searchIcon" onclick="$('#SelectClientModal').modal('show');"></i>
	                    <!-- </div> -->
                    </div>
                    <div class="col-md-6">
	                    <!-- <div class="form-group"> -->
	       					<input type="hidden" name="ContactPersonId" id="selectedClientContactPersonId">
	                        <label for="reason">Client Contact Person<span class="mandatory-element">*</span></label>
	                        <input type="text" id="clientContactPersonName" name="clientContactPersonName" class="form-control" class="form-control" style="padding-left: 30px;" disabled>
			            	<i class="fa fa-search prefix searchIcon" onclick="$('#SelectClientContactPersonModal').modal('show');"></i>
	                    <!-- </div> -->
                    </div>
                </div><br>
                <div class="form-row">
                    <div class="col-md-4">
	                    <!-- <div class="form-group"> -->
	       					<input type="hidden" name="billingAddressId" id="selectedBillingAddressId">
	                        <label>Billing Address <span class="mandatory-element">*</span></label>
	                       <!--  <input type="text" id="clientBillingAddress" name="clientBillingAddress" class="form-control" style="padding-left: 30px;" disabled> -->
	                       <tetxtarea id="clientBillingAddress" class="form-control" readonly style="padding-left: 30px;height: 75% !important;"></tetxtarea>
			            	<i class="fa fa-search prefix searchIcon" style="margin-top: -16%;" onclick="showAddressModal('billingAddress');"></i>
	                    <!-- </div> -->
                    </div>
                    <div class="col-md-4">
	                    <!-- <div class="form-group"> -->
	       					<input type="hidden" name="deliveryAddressId" id="selectedDeliveryAddressId">
	                        <label for="reason">Delivery Address <span class="mandatory-element">*</span></label>
	                        <!-- <input type="text" id="clientDeliveryAddress" name="clientDeliveryAddress" class="form-control" class="form-control" style="padding-left: 30px;" disabled> -->
	                        <tetxtarea id="clientDeliveryAddress" class="form-control" readonly style="padding-left: 30px;height: 75% !important;"></tetxtarea>
			            	<i class="fa fa-search prefix searchIcon" style="margin-top: -16%;" onclick="showAddressModal('deliveryAddress');"></i>
	                    <!-- </div> -->
                    </div>
                   	<div class="form-group col-md-4">                   	
	                    <div class="col-md-12">
							<label for="ContactNumber">Contact Number <span class="mandatory-element">*</span></label>
							<input type="text" readonly class="form-control" id="ContactNumber" name="ContactNumber">
	                    </div>
	                	<div class="col-md-12">
							<label for="clientSalesPerson">Sales Person <span class="mandatory-element">*</span></label>
							<select class="form-control" id="clientSalesPerson" name="salesPerson">
							</select>
	                    </div>
                   	</div>
                </div><br>
                <div class="form-row">
                   	<div class="col-md-4 HideThisElement">
	                	<!-- <div class="form-group"> -->
							<label for="invoiceType">Invoice Type <span class="mandatory-element">*</span></label>
							<select class="form-control" id="invoiceType" name="invoiceType">
							</select>
	                    <!-- </div> -->
                   	</div>
                   	<div class="col-md-4 HideThisElement">
	                	<!-- <div class="form-group"> -->
							<label for="modeOfPayment">Mode Of Payment <span class="mandatory-element">*</span></label>
							<select class="form-control" id="modeOfPayment" name="modeOfPayment">
							</select>
	                    <!-- </div> -->
                   	</div>
                   	<div class="col-md-4 ">
	                	<!-- <div class="form-group"> -->
							<label for="expectedDeliveryDate">Expected Delivery Date </label>
	                        <input type="text" id="expectedDeliveryDate" name=expectedDeilvery class="form-control datepicker">
	                    <!-- </div> -->
                   	</div>
                   	<div class="col-md-4 ">
	                	<!-- <div class="form-group"> -->
							<label for="RefNo">Reference No  <span class="mandatory-element">*</span></label>
	                        <input type="text" id="RefNo" name="RefNo" class="form-control">
	                    <!-- </div> -->
                   	</div>
                </div>
                <br>
	      
        	</form>
        	
        	</body>
  

   	<%@include file="SelectClientModal.jsp" %>
   	<%@include file="SelectClientContactPersonModal.jsp" %>
   	<%@include file="SelectClientAddressModal.jsp" %>
</html>