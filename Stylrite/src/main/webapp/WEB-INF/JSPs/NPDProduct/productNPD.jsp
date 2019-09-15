 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>NPD Product</title>
<link href="<c:url value="/resources/img/favicon.ico" />" rel="shortcut icon">
</head>
<body>
<div id = "productHeader">
<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
</div>
   <div class="container" id ="productContainer">
		<div class="container-fluid" id ="productContainer-fluid">            		
                   <jsp:include page="/WEB-INF/JSPs/NPDProduct/productNPDList.jsp"/>
                </div>
            </div>
<div id = "productFooter">
<jsp:include page="/WEB-INF/JSPs/Footer.jsp" />
</div>
</body>

 <script src="<c:url value="/resources/js/NPDProduct/productNPDList.js" />"></script>
 <script src="<c:url value="/resources/js/uniqueid/uniqueid.js"/>"></script>
</html>
 