<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">
<head>
<meta charset="UTF-8">
<title>Edit Barcode</title>
</head>
            <body>
             <hr>
                
                                    <form id="insertOrderData" name="insertOrderData">
	                                    <input type="hidden" name="rowId" id="orderId">
	                                    <input type="hidden" id="oldSkuId">
	                                    <input type="hidden" id="oldGrnNumber">
	                                    <input type="hidden" id="oldType">
	                                    <input type="hidden" id="oldLocation">
	                                    <input type="hidden" id="oldStatus">
	                                    <input type="hidden" id="currentSkuId">
	                                    <input type="hidden" id="currentLocation">
	                                    <input type="hidden" id="currentStatusText">
	                                    <input type="hidden" id="currentRate">
	                                    <input type="hidden" id="currentSection">
	                                    <input type="hidden" id="auditItemId">
                                    <div class="card-body" id="productDetalisOrderDiv">
                                        <div class="form-row">
                                            <div class="form-group col-md-4">
                                                <label>Scan Barcode <span class="mandatory-element">*</span></label>
                                                <input type="text" id="barcode" name="barcode" class="form-control">
                                            </div>

                                            <div class="form-group col-md-4">
                                               <button type="button" id="nextBarCode" class="btn btn-sm btn-primary HideThisElement" style="margin-top: 6%;">Next</button>
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-md-7">
                                            	 <jsp:include page="/WEB-INF/JSPs/Barcode/BarcodeView.jsp" />
                                            	 <br>
                                            	 <jsp:include page="/WEB-INF/JSPs/Barcode/BarcodeForm.jsp" />
                                            </div>
                                             <div class="form-group col-md-5">
                                          	     <jsp:include page="/WEB-INF/JSPs/Audit/barcodeListTableInScanBarcode.jsp" />
                                            </div>

                                        </div>
                                        <div class="col-md-12 HideThisElement">
                                            <div class="form-row">
                                                <div class="form-group col-md-12">
                                                    <label id="remarksLbl" for="remarks" class="">Remarks</label>
                                                    <textarea class="form-control" rows="5" id="remarks" name="remarks" placeholder="Enter Remarks"></textarea>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <br>

                                    <div>
                                        <button type="button" id="SubmitButtonCompleteAudit" class=" btn btn-sm btn-primary HideThisElement">
                                            Complete Audit <i class="fa fa-chcek ml-1"></i>
                                        </button>
                                        <button type="button" id="UpdateButtonOrder" class="btn btn-primary HideThisElement">Update</button>
                                        <button type="button" class="btn btn-outline-info waves-effect HideThisElement" id="closeBtn">Close</button>
                                    </div>
                             </form>
            </body>
            </html>