<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

   /* #barcodeTextView
    {
        font: bold 12px/30px Georgia, serif;
    } */
</style>
</head>
<body>
<div class="card HideThisElement" id="BarcodeViewDiv">
    <div class="card-body">
    	<div class="row">
    		<div class="col-md-6 row"><h5 class="card-title">Barcode Details <button type="button" class="reprint btn btn-sm btn-primary">Reprint</button></h5></div>
    		<!-- <p class="row" style="margin-left: 10px;"> Barcode Details <button type="button" class="reprint btn btn-sm btn-primary" style="margin-right: 10px;">Reprint</button><b> SRT1176814666776 (Porsche Design 23 K 74) Frames </b></p> -->
    		<div class="col-md-6 right" id = "editClickInBarCodeEdit"><u><a id="editClick" href="#">Edit</a></u></div>
    	</div>
    	<hr>
    	<dl class="row">
    	 <input type='hidden' class='barcodePrintVal'>
    	  <dt class="col-sm-2">BarCode</dt>
		  <dt class="col-sm-2" id="barcodeTextView">-</dt>
		  <dt class="col-sm-2">GRN Number</dt>
		  <dd class="col-sm-2" id="GRNNumberTextView">-</dd>
		  <dt class="col-sm-2">StockIn Date</dt>
		  <dd class="col-sm-2" id="stockInDateTextView">-</dd>
		  <dt class="col-sm-2">Status</dt>
		  <dt class="col-sm-2" id="statusTextView">-</dt>
		  <dt class="col-sm-2">SKU Id</dt>
		  <dd class="col-sm-2" id="SKUIdTextView">-</dd>
		  <dt class="col-sm-2">StockOut Date</dt>
		  <dd class="col-sm-2" id="stockOutDateTextView">-</dd>
		  <dt class="col-sm-2">Type</dt>
		  <dt class="col-sm-2" id="typeTextView">-</dt>
		  <dt class="col-sm-2">Product Info</dt>
		  <dt class="col-sm-2" id="productInfoTextView">-</dt>	
		  <dt class="col-sm-2">Location</dt>
		  <dt class="col-sm-2" id="locationTextView">-</dt>
		  <dt class="col-sm-2">Brand</dt>
		  <dd class="col-sm-2" id="BrandTextView">-</dd>
		  <dt class="col-sm-2">Model No</dt>
		  <dd class="col-sm-2" id="ModelNoTextView">-</dd>
		  <dt class="col-sm-2">Color</dt>
		  <dd class="col-sm-2" id="ColorTextView">-</dd>
		  <dt class="col-sm-2">Size</dt>
		  <dd class="col-sm-2" id="SizeTextView">-</dd>	  
		  <dt class="col-sm-2">Updated On</dt>
		  <dd class="col-sm-2" id="UpdatedOnTextView">-</dd>
		  <dt class="col-sm-2">Updated By</dt>
		  <dd class="col-sm-2" id="UpdatedByTextView">-</dd>		  
		</dl><hr>
		<div id="remarksDiv"></div>
		<button type="button" class="btn btn-primary " id="SubmitButtonBackFromView">Back</button>		
    </div>
</div>
</body>
</html>