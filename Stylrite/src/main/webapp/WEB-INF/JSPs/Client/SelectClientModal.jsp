<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html lang="en">

            <head>
<meta charset="UTF-8">
<title>Client</title>
<style type="text/css">
./* i{
	max-width: 70%;
} */
</style>
</head>
<body>
	<div class="modal fade bd-example-modal-lg" id="SelectClientModal" tabindex="-1" role="dialog" aria-labelledby="SelectProductLabel" aria-hidden="true">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <!-- <div class="modal-header">
	        <h5 class="modal-title" id="SelectProductLabel">Select Client</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div> -->
	      <div class="modal-body">
	      		<%@include file="ClientList.jsp" %>
	      </div>
	      <!-- <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary">Save changes</button>
	      </div> -->
	    </div>
	  </div>
	</div>
</body>
</html>