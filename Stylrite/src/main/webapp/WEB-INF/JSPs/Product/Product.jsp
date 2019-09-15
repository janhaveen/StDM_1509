 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Product</title>
<link href="<c:url value="/resources/img/favicon.ico" />" rel="shortcut icon">
<link href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.2/css/bootstrap-select.min.css" />" rel="stylesheet">
</head>
<body>
<div id = "productHeader">
<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
</div>
   <div class="container" id ="productContainer">
		<div class="container-fluid" id ="productContainer-fluid">            		
           <jsp:include page="ProductList.jsp"/>
           <jsp:include page="ProductForm.jsp"/>
           <jsp:include page="ProductView.jsp"/>
        </div>
    </div>
<div id = "productFooter">
<jsp:include page="/WEB-INF/JSPs/Footer.jsp" />
</div>
</body>
<script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.2/js/bootstrap-select.min.js" />"></script>
 <script src="<c:url value="/resources/js/Product/ProductList.js" />"></script>
 <script src="<c:url value="/resources/js/Product/ProductForm.js" />"></script>
 <script src="<c:url value="/resources/js/General/DropDownForProductLegend.js" />"></script>
 <script src="<c:url value="/resources/js/General/DropDownForHSN.js" />"></script>
 <script src="<c:url value="/resources/js/uniqueid/uniqueid.js"/>"></script>
</html>
 