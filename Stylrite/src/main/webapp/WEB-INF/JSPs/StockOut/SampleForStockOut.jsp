<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stock Out</title>
<style type="text/css">
.bq{
	display: none	!important;
}
</style>
<link href="<c:url value="/resources/img/favicon.ico" />" rel="shortcut icon">
</head>
<body>
<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
	<div class="container">
		<div class="container-fluid">
			<%@include file="SampleList.jsp" %>
			<%@include file="StockOutProduct.jsp" %>
		</div>
	</div>
	<%@include file="SelectChildBarcode.jsp" %>
	<%@include file="TakeFromSample.jsp" %>
</body>
<script src="<c:url value="/resources/js/StockOut/SampleList.js" />"></script>
<script src="<c:url value="/resources/js/StockOut/TakeFromSampleList.js" />"></script>
</html>