<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
 .searchIcon {
        float: left;
        margin-left: 10px;
        margin-top: -23px;
        position: relative;
/*         z-index: 2;
 */    }
</style>
</head>
<body>
<div class="form-row">
	<div class="col-md-4">
		<div class="col-md-12">
			<label>GRN Number <span class="mandatory-element">*</span></label>
			<input type="text" id="gRNnumber" class="form-control">
		</div>
		<div class="col-md-12">
			<label>Purchase Date <span class="mandatory-element">*</span></label>
			<input type="text" id="purchaseDate" class="form-control datepicker">
		</div>
	</div>
		<div class="col-md-4">
			<div class="col-md-12">
				<label>Vendor  <span class="mandatory-element">*</span></label>
				<input type="hidden" id="selectedVendorId">
				<input type="hidden" name="vendorId" id="vendorId">
				<input type="text" id="VendorText" class="form-control" disabled="disabled" style="padding-left: 30px;">
				<i class="fa fa-search prefix searchIcon" onclick="$('#SelectVendorModal').modal('show');"></i>
			</div>
			<div class="col-md-12">
				<label>Contact Person  <span class="mandatory-element">*</span></label>
				<input type="hidden" name="vendorCpId" id="vendorCpId">
				<input type="text" id="VendorCPText" class="form-control" disabled style="padding-left: 30px;">
				<i class="fa fa-search prefix searchIcon" onclick="$('#SelectVendorCpModal').modal('show');"></i>
			</div>
		</div>
		<div class="col-md-4">
			<label>Address <span class="mandatory-element">*</span></label>
			<input type="hidden" name="vendorAddrId" id="vendorAddrId">
			<tetxtarea id="VendorAddrText" class="form-control" readonly style="padding-left: 30px;height: 75% !important;"></tetxtarea>
			<i class="fa fa-search prefix searchIcon" style="margin-top: -16%	!important;" onclick="$('#SelectVendorAddrModal').modal('show');"></i>
		</div>
</div>
<!-- <div class="form-row">
	<div class="col-md-4">
		
	</div>
	<div class="col-md-4">
		<div class="form-group">
			
		</div>
	</div>	
</div> -->

<jsp:include page="/WEB-INF/JSPs/vendor/SelectVendorModal.jsp" />
<jsp:include page="/WEB-INF/JSPs/vendor/SelectVendorContactPersonModal.jsp" />
<jsp:include page="/WEB-INF/JSPs/vendor/SelectVendorAddressModal.jsp" />
</body>
</html>