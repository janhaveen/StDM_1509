<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html lang="en">

            <head>
<meta charset="UTF-8">
<title>VendorContactPersonList List</title>
</head>
<body>
<div class="card" id="ClientContactPersonTableDiv">
    <div class="card-body table-responsive-md">
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
    	<table id="contactPersonDatatables" class="table table-hover mb-0 nowrap">
		    <thead>
		        <tr id="headerrow" class="">
		            <th>#</th>
                    <th>Contact Person Name</th>
                    <th>Designation</th>
                    <th>Contact No</th>
                    <th>Alt Contact No</th>
                    <th>Email Id</th>
                    <th>Location</th>
		        </tr>
		    </thead>
		</table>
    </div>
</div>
</body>
</html>