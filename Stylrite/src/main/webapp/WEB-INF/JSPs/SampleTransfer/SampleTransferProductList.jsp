<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
        
        </head>

        <body>
		    <div class="card" id="productListTableDiv">
		        <div class="card-body table-responsive-md">
		            <h5 class="card-title">Product List</h5>
		            <hr>
		            <table id="SampleTransferproductListTable" class="table table-hover mb-0 nowrap">
					    <thead>
					        <tr id="headerrow" class="">
					       <th id="thClick">#</th> 
				              <th class=""><input type="checkbox" class="cb" id="thClick"> <label class="form-check-label" for="exampleCheck1"></label></th> 
				             	<th>SKU ID</th>
					            <th>Brand</th>
					            <th>Type</th>
					            <th>Model Number</th>
					            <th>Color</th>
					            <th>Size</th>
					            <th>Cost</th>
					        </tr>
					        <!-- <tr id="filterrow">
					            <td></td>
					            <th>Productloyee Name</th>
					            <th>Department</th>
					            <th>Designation</th>
					            <th>User ID</th>
					            <th>Mobile No</th>
					            <th>Email ID</th>
					            <th>Report To</th>
					            <th>Status</th>
					        </tr> -->
					    </thead>
				</table>
		        </div>
		    </div>
	  </body>

        </html>