<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
			<meta charset="UTF-8">
			<title>Request For Production List</title>
			<link href="<c:url value="/resources/img/favicon.ico" />" rel="shortcut icon">
		</head>

        <body>
            <jsp:include page="/WEB-INF/JSPs/Header.jsp" />
            <div class="container" id="productContainer">
                <div class="container-fluid" id="productContainer-fluid">
                    <div class="card" id="requestForProductionListTableDiv">
                        <div class="card-body table-responsive-md">
                            <h5 class="card-title">Request For Production List</h5>
                            <hr>
                            <table id="requestForProductionListTable" class="table table-hover mb-0 nowrap">
                                <thead>
                                    <tr id="headerrow" class="">
                                        <th id="thClick">#</th>
                                        <th>NPD ID</th>
                                        <th>Product Info</th>
                                        <th>Sku</th>
                                        <th>Status</th>
                                        <th>Created By</th>
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
        <script src="<c:url value="/resources/js/NPDProduct/requestForProductionList.js" />"></script>
 		<script src="<c:url value="/resources/js/uniqueid/uniqueid.js"/>"></script>
        </html>