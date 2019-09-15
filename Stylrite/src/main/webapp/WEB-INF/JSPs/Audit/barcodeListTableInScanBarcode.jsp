<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">
		<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- <style type="text/css">
			thead, tbody 
			 {
				/*  display: block; */
			 }

			tbody 
			{
			    height: 200px;       /* Just for the demo          */
			    overflow-y: auto;    /* Trigger vertical scroll    */
			    overflow-x: hidden;  /* Hide the horizontal scroll */
			}
			.table td, .table th
			{
				padding: 1.75rem;
			}
		</style> -->
		</head>
		<body>
		 <div class="left HideThisElement" id = "barcodeListTableInScanBarCode">
			 <table class="table table-hover mb-0 nowrap">
			    <thead>
			      <tr>
			        <th>SrNo</th>
			        <th>BarCode</th>
			        <th>Status</th>
			        <th>SKU</th>
			        <th>Location</th>
			      </tr>
			    </thead>
			    <tbody id="addBarcodeInfoInScanBarcode"></tbody>
			  </table>
			  </div>
		</body>
		</html>