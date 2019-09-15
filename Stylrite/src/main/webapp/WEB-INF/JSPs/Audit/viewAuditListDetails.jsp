<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html lang="en">

            <head>
				<meta charset="UTF-8">
				<link href="<c:url value="/resources/img/favicon.ico " />" rel="shortcut icon">
				<link href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.2/css/bootstrap-select.min.css" />" rel="stylesheet">
				<title>View Audit</title>
                <style>
                    .mandatory-element {
                        color: red;
                    }
                </style>

            </head>

            <body>
            <jsp:include page="/WEB-INF/JSPs/Header.jsp" />
                <div class="container">
                    <div class="container-fluid">
                        <div class="card" id="viewAuditFormDiv">
                            <div class="card-body">
                                <h5 class="card-title" id="headerName"></h5>
                                 <div class="col-md-12" style="text-align: right;margin-top: -3%;">
									<button type="button" id="ExportasCSV" class="btn btn-sm btn-primary">Export as CSV</button>
						 		</div>
                                <hr id="hrProduct">
                                <input type="hidden" id="auditId" value ="${auditId}">
                                <input type="hidden" id="itemsAuditedValue">
                                <input type="hidden" id="itemsCorrectedValue">
                                <input type="hidden" id="itemsDuplicatedValue">
                                <dl class="row">
                                    <dl class="col-sm-12">
                                        <dl class="row">
                                            <dt class="col-sm-2">Audit Id</dt>
                                            <dd class="col-sm-2" id="auditIdTextView">-</dd>
                                            <dt class="col-sm-2">Audit Date</dt>
                                            <dd class="col-sm-2" id="auditDateTextView">-</dd>
                                            <dt class="col-sm-2">Audit By</dt>
                                            <dd class="col-sm-2" id="auditByTextView">-</dd>
                                        </dl>
                                        <dl class="row">
                                            <dt class="col-sm-2">Audit Start Time</dt>
                                            <dd class="col-sm-2" id="auditStartTimeTextView">-</dd>
                                            <dt class="col-sm-2">Audit End Time</dt>
                                            <dd class="col-sm-2" id="auditeEndTimeTextView">-</dd>
                                            <dt class="col-sm-2">Audit Reason</dt>
                                            <dd class="col-sm-2" id="auditReasonTextView">-</dd>
                                        </dl>
                                         <dl class="row">
                                        	 <dt class="col-sm-2">Remarks</dt>
                                             <dd class="col-sm-2" id="remarksTextView">-</dd>
                                        </dl>
                                        
                                         <dl class="row">
                                            <dt class="col-sm-2">Items Audited</dt>
                                            <dd class="col-sm-2" id="itemsAuditedTextView">-</dd>
                                            <dt class="col-sm-2">Items Corrected</dt>
                                            <dd class="col-sm-2" id="itemsCorrectedTextView">-</dd>
                                            <dt class="col-sm-2">Items Duplicated</dt>
                                            <dd class="col-sm-2" id="itemsDuplicatedTextView">-</dd>
                                        </dl>
                                    </dl>
                                </dl>
                                
                               	 <table id="auditItemWithBarCodeData" class="table table-hover mb-0 nowrap HideThisElement">
								    <thead>
								        <tr id="headerrow" class="">
								            <th>#</th>
								            <th>Audit Item ID</th>
								            <th>Audit ID</th>
								            <th>Audit Reason</th>
								            <th>BarCode</th>
								            <th>isEdited</th>
								            <th>Sku</th>
								            <th>Audit Start Time</th>
								            <th>Audit End Time</th>
								            <th>GRN Number</th>
								            <th>Remarks</th>
								        </tr>
								    </thead>
								    <tbody id="auditItemWithBarCodeBody"></tbody>
								 </table>
                                
                            </div>

                        </div>
                    </div>
                </div>
               <jsp:include page="/WEB-INF/JSPs/Footer.jsp" />
            </body>
             <script src="<c:url value="/resources/js/Audit/editBarcodeInAuditItem.js" />"></script>
			<script src="<c:url value="/resources/js/Audit/viewAudit.js" />"></script>
			<script src="<c:url value="/resources/js/uniqueid/uniqueid.js"/>"></script>
			<script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.2/js/bootstrap-select.min.js" />"></script>
			<script src="<c:url value="/resources/js/General/DropDownForProductLegend.js" />"></script>
            </html>