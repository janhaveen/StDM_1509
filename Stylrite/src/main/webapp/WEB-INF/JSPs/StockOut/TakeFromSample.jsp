<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="modal fade" id="TakeFromSample" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
 	  <div class="modal-dialog modal-lg" style="max-width: 80%;" role="document">
	    <div class="modal-content">
	      <div class="modal-body">
	      		<table class="table-sm table" id="SalesPersonSampleTable">
	      			<thead>
	      				<tr id="headerrow">
							<th>#</th>
							<th>SKU ID</th>
				            <th>Brand</th>
				            <th>Model</th>
				            <th>Color</th>
				            <th>Size</th>	   
							<th>Sales Person</th>								      				
	      				</tr>
	      				 <tr id="filterrow">
				            <td></td>
				            <th>SKU ID</th>
				            <th>Brand</th>
				            <th>Model</th>
				            <th>Color</th>
				            <th>Size</th>
							<th>Sales Person</th>
				        </tr> 
	      			</thead>
	      		</table>
	      </div>
	    </div>
  	</div>
</div>	
</body>
</html>