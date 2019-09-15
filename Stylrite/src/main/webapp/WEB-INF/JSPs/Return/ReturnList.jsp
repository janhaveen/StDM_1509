<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link href="<c:url value="/resources/img/favicon.ico" />" rel="shortcut icon">

<title>Return List</title>
</head>
<body>
<div class="card" id="returnTableDiv" >
    <div class="card-body table-responsive-md">
    	<!-- <h5 class="card-title">Client List</h5><hr> -->
    	<table id="datatablesReturnOrder" class="datatable table table-hover mb-0 nowrap">
		    <thead>
		        <tr id="headerrow" class="">
		             <th>#</th>
                    <th>Return Date</th>
                    <th>Return Id</th>
                    <th>Client Name</th>
                    <th>Contact Person</th>
                    <th>Count</th>
		        </tr>
		    </thead>
		</table>
    </div>
</div>
</body>
</html>