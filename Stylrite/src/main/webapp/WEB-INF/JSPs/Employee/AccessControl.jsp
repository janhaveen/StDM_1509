<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section id="CheckBoxForm" class="">
    <div class="row">
        <div class="col-md-12">
           <!--  <div class="card">
                <div class="card-body">
                    <h4 class="card-title"><i class="fa fa-info mr-2" aria-hidden="true"></i> User Access Control</h4>
                    <hr> -->
                    <form action="" id="assignPermissionForm" name="assignPermissionForm">
                    	<table class="table table-hover mb-0 nowrap table-sm">
                    		<thead>
                    			<tr>
                    				<th>Module</th>
                    				<th>Submodule</th>
                    				<th  class="center">Create</th>
                    				<th  class="center">View</th>
                    				<th class="center">Edit</th>
                    				<th class="center">Delete</th>
                    			</tr>
                    		</thead>
                    		<tbody>
                    			<tr>
                    				<td>Admin</td>
                    				<td>Employees</td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    			</tr>
                    			<tr>
                    				<td></td>
                    				<td>Access Control</td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    			</tr>
                    			<tr>
                    				<td></td>
                    				<td>Task Management</td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    			</tr>
                    			<tr>
                    				<td>CRM</td>
                    				<td>Clients</td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    			</tr>
                    			<tr>
                    				<td></td>
                    				<td>Vendors</td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    			</tr>
                    			<tr>
                    				<td>Inventory</td>
                    				<td>Products</td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    			</tr>
                    			<tr>
                    				<td></td>
                    				<td>GRN</td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    			</tr>
                    			<tr>
                    				<td></td>
                    				<td>Stock In</td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    			</tr>
                    			<tr>
                    				<td></td>
                    				<td>Stock out</td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    			</tr>
                    			<tr>
                    				<td></td>
                    				<td>Stock Transfer</td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    			</tr>
                    			<tr>
                    				<td></td>
                    				<td>QC</td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    			</tr>
                    			<tr>
                    				<td></td>
                    				<td>Samples</td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    			</tr>
                    			<tr>
                    				<td></td>
                    				<td>Stock List</td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    			</tr>
                    			<tr>
                    				<td></td>
                    				<td>Barcode</td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    			</tr>
                    			<tr>
                    				<td>Sale Order</td>
                    				<td>Sale Order</td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    			</tr>
                    			<tr>
                    				<td>LMS</td>
                    				<td>Leads</td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    			</tr>
                    			<tr>
                    				<td>Accounts</td>
                    				<td>Cheque/Payments</td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    			</tr>
                    			<tr>
                    				<td></td>
                    				<td>Invoice</td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    			</tr>
                    			<tr>
                    				<td></td>
                    				<td>Requisition</td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    			</tr>
                    			<tr>
                    				<td>Purchase Order</td>
                    				<td>Purchase Order</td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    			</tr>
                    			<tr>
                    				<td></td>
                    				<td>Requisition</td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    				<td class="center"><input type="checkbox" class="form-check-input" id="exampleCheck1"></td>
                    			</tr>
                    		</tbody>
                    	</table>    
		            </form>
                <!-- </div>
            </div> -->
        </div>
    </div>
</section>
</body>
</html>