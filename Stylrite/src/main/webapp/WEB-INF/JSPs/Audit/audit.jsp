<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">
<head>
<meta charset="UTF-8">
<link href="<c:url value="/resources/img/favicon.ico " />" rel="shortcut icon">
<title>Audit</title>
</head>
<body>
<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
	<div class="container">
		<div class="container-fluid">
			<jsp:include page="/WEB-INF/JSPs/Audit/createAudit.jsp" />
		</div>
	</div>
<jsp:include page="/WEB-INF/JSPs/Footer.jsp" />
 </body>
<script src="<c:url value="/resources/js/General/DropDownForAudit.js" />"></script>
<script src="<c:url value="/resources/js/Audit/createAudit.js" />"></script>
<script src="<c:url value="/resources/js/uniqueid/uniqueid.js"/>"></script>
</html>