 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sample Trs</title>
</head>
<body>
	<div class="form-row">
          <!-- <div class="form-group col-md-3">
              <label id="requisitionIDLbl" for="requisitionID" class="">Requisition ID </label>
              <input type="text" class="form-control" id="requisitionID" name="requisitionID" readOnly>
          </div>  -->
          <div class="form-group col-md-6">
          	<div class="form-group col-md-12" style="padding: 0;">
            <div class="form-group">
                <label for="reason">Reason <span class="mandatory-element">*</span></label>
                <select class="form-control" id="reason" name="reason">
                </select>
            </div>
           </div>
           <div class="row">
           	<div class="form-group col-md-6">
         	<div class="form-group">
                 <label id="expectedReceiptDateLbl" for="expectedReceiptDate">Expected Receipt Date <span class="mandatory-element">*</span></label>
                 <input type="text" id="expectedReceiptDate" name="expectedReceiptDate" class="form-control datepicker">
             </div>
           	</div>
           	<div class="form-group col-md-6" id="noDiv">
	         	 <div class="form-group" id="motDiv">
	                 <label for="modeOfTransport">Mode of Transport <span class="mandatory-element">*</span></label>
	                 <select class="form-control" id="modeOfTransport" name="modeofDelivery">
	                 </select>
	             </div>
	             <div class="form-group HideThisElement" id="SalesPersonDiv">
	                 <label for="modeOfTransport">Sales Person<span class="mandatory-element">*</span></label>
	                 <select class="form-control" id="SalesPerson" name="SalesPerson">
	                 </select>
	             </div>
           	</div>
           	<div class="form-group col-md-6" id="OpoDiv">           	
           		<div class="form-group">
	                 <label for="SalesPersonR">Sales Person<span class="mandatory-element">*</span></label>
	                 <select class="form-control" id="SalesPersonR" name="issuesTo">
	                 </select>
	             </div>
	        </div>
           	<div class="form-group col-md-12  HideThisElement" id="sampleTransferDiv">
           		<div class="form-row">
		         	<div class="form-group col-md-6">
		                 <label for="SalesPersonF">From <span class="mandatory-element">*</span></label>
		                 <select class="form-control" id="SalesPersonF" name="SalesPersonF">
		                 </select>
		             </div>
		             <div class="form-group col-md-6" id="SalesPersonDiv">
		                 <label for="SalesPersonT">To<span class="mandatory-element">*</span></label>
		                 <select class="form-control" id="SalesPersonT" name="SalesPersonT">
		                 </select>
		             </div>
		           </div>
           	</div>
           	
           </div>
          </div>
          <div class="form-group col-md-6">
          	<div class="form-group">
              	<label id="remarksLbl" for="remarks" class="">Remarks</label>
          		<textarea class="form-control" rows="5" id="remarks" name="" placeholder="Enter Remarks"></textarea>
              </div>
          </div>
      </div>
</body>
</html>