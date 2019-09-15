 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Order</title>
</head>
<body>
<div class="card" id="OrderTableDiv" >
    <div class="card-body table-responsive-md">
    	<!-- <h5 class="card-title">Client List</h5><hr> -->
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
    	<table id="datatablesOrder" class="table table-hover mb-0 nowrap">
		    <thead>
		        <tr id="headerrow" class="">
		             <th>#</th>
                    <th>Order Date</th>
                    <th>Order Id</th>
                    <th>Client Name</th>
                     <th>Client Location</th>
                    <th>Contact Person</th>
                    <th>Contact Number</th>
                     <th>Sales Person</th>
                    <th>Count</th>
		        </tr>
		        <tr id="filterrow">
                    <th>#</th>
                    <th>Order Date</th>
                    <th>Order Id</th>
                    <th>Client Name</th>
                    <th>Client Location</th>
                    <th>Contact Person</th>
                    <th>Contact Number</th>
                    <th>Sales Person</th>
                    <th>(#Items) Quantity</th>
               </tr>
		    </thead>
		</table>
    </div>
</div>
</body>
</html>