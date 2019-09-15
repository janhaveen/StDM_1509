<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
        <link href="<c:url value="/resources/img/favicon.ico " />" rel="shortcut icon">
        </head>

        <body>
     	<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
            <div class="container">
                <div class="container-fluid">
				    <div class="card" id="auditListTableDiv">
				        <div class="card-body table-responsive-md">
				            <h5 class="card-title">Audit List</h5>
				            <hr>
				            <table id="auditListTable" class="table table-hover mb-0 nowrap">
							    <thead>
							        <tr id="headerrow" class="">
							            <th id="thClick">#</th>
						             	<!-- <th class="spret HideThisElement"><input type="checkbox" class="cb"> <label class="form-check-label" for="exampleCheck1"></label></th> -->
						             	<th>Audit ID</th>
							            <th>Audit Reason</th>
							            <th>Audit Start Time</th>
							            <th>Audit End Time</th>
							            <th>Remarks</th>
							            <th>Total AuditItem</th>
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
				      </div>
            </div>
           <jsp:include page="/WEB-INF/JSPs/Footer.jsp" />
	  </body>
 		<script src="<c:url value="/resources/js/Audit/auditList.js" />"></script>
 		<script src="<c:url value="/resources/js/uniqueid/uniqueid.js"/>"></script>
        </html>