<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="card HideThisElement" id="productViewDiv">
    <div class="card-body">
    	<div class="row">
    		<div class="col-md-6"><h5 class="card-title">Product Details</h5></div>
    		<div class="col-md-6 right"><u><a id="editClick" href="#">Edit</a></u></div>
    	</div>
    	<hr>
    	<dl class="row">
		  <dt class="col-sm-2">Brand</dt>
		  <dd class="col-sm-2" id="BrandText">-</dd>
		   <dt class="col-sm-2">Type</dt>
		  <dd class="col-sm-2" id="typeText">-</dd>
		  <dt class="col-sm-2">Model No </dt>
		  <dd class="col-sm-2" id="ModelNoText">-</dt>
		  <dt class="col-sm-2">Color</dt>
		  <dd class="col-sm-2" id="ColorText">-</dd>
		  <dt class="col-sm-2">Size</dt>
		  <dd class="col-sm-2" id="SizeText">-</dd>
		  <dt class="col-sm-2">HSN ID </dt>
		  <dd class="col-sm-2" id="HSNIDText">-</dd>
		  <dt class="col-sm-2">Cost</dt>
		  <dd class="col-sm-2" id="CostText">-</dd>
		  <dt class="col-sm-2">Tags</dt>
		  <dd class="col-sm-2" id="TagsText">-</dd>
		  <dt class="col-sm-2">Description</dt>
		  <dd class="col-sm-2" id="DescriptionText">-</dd>
		</dl>
    <button type="button" class="btn btn-primary " id="SubmitButtonBackFromView">Back</button></div>
</div>
</body>
</html>