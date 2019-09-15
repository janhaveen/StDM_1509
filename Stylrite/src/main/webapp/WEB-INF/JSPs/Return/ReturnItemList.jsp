<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <link href="<c:url value="/resources/img/favicon.ico" />" rel="shortcut icon">
				<title>Insert title here</title>
				</head>
				<body>
					<div class="card" id="returnItemListTableDiv">
					    <div class="card-body table-responsive-md">
					    	<table id="datatablesReturnItem" class="table table-hover mb-0 nowrap">
							    <thead>
							        <tr id="headerrow" class="">
							             <th>#</th>
							            <!-- <th>ReturnItem Date</th> -->
					                    <th>ReturnDate</th>
					                    <th>ReturnItemID</th>
					                    <th>Brand</th>
					                    <th>SKUId</th>
					                    <th>ProductName</th>
					                    <th>ClientName</th>
					                    <th>SalesPerson</th>
					                    <!-- <th>Status</th>
					                    <th>CloserDate</th> -->
							        </tr>
							    </thead>
							</table>
					    </div>
					</div>
				</body>
				</html>