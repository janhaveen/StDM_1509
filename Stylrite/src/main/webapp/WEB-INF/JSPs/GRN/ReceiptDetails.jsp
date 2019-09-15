<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="../../../img/TitleImage.png">
<title></title>
</head>
<body>
<p style="font-size: 120%;margin-bottom: 1%;"> Receipt Details</p>
<hr>
<form name="receiptAndCourierDetailsForm" id="receiptAndCourierDetailsForm">
<div class="col-md-12">
<div class="form-row">
	<div class="col-md-4">
		<label>Received By <span class="mandatory-element">*</span></label>
		<input type="text" id="receivedBy" name="receivedBy" class="form-control">
	</div>
	<div class="col-md-4">
		<label>Receipt Date <span class="mandatory-element">*</span></label>
		<input type="text" id="receiptDate" name="receiptDate" class="form-control datepicker">
	</div>
</div>
<hr>
</div>
      
<p style="font-size: 120%;margin-bottom: 1%;"> Courier Details</p>
<hr>
<div class="col-md-12">
<div class="form-row">
	<div class="col-md-4">
		<label>Name</label>
		<input type="text" id="courierName" name="courierName" class="form-control">
	</div>
	<div class="col-md-4">
		<label>LR/Tracking Details</label>
		<input type="text" id="LRNumber" name="LRNumber" class="form-control">
	</div>
	<div class="col-md-4">
		<label>Courier Charges</label>
		<input type="number" id="otherCharges" name="otherCharges" class="form-control">
	</div>
</div>
</div>
</form>
</body>
</html>