 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Client</title>
<link href="<c:url value="/resources/img/favicon.ico " />" rel="shortcut icon">
</head>
<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
<body>

	<div class="container">
		<div class="container-fluid">
		   <jsp:include page="/WEB-INF/JSPs/Client/ClientList.jsp"/>
		     <jsp:include page="/WEB-INF/JSPs/Client/ClientView.jsp"/>
		  <%--    <%@include file="ClientList.jsp"%> --%>
			  <%-- <%@include file="ClientView.jsp"%> --%>
			    <jsp:include page="/WEB-INF/JSPs/Client/ClientForm.jsp"/>
			     <jsp:include page="/WEB-INF/JSPs/Client/DeleteClient.jsp"/>
			    <%-- <jsp:include page="/WEB-INF/jsp/client/ClientView.jsp"/> --%>
			<%-- <%@include file="ClientForm.jsp"%> --%>
			<%-- <%@include file="DeleteClient.jsp"%>  --%>
		</div>
	</div>
</body>
<jsp:include page="/WEB-INF/JSPs/Footer.jsp" />

 <script src="<c:url value="/resources/js/Client/Client1.js"/>"></script> 
<%-- <script src="<c:url value="/resources/js/client/.js"/>"></script> --%>
<script src="<c:url value="/resources/js/Client/ClientList.js"/>"></script>
<script src="<c:url value="/resources/js/Client/ContactPersonList.js"/>"></script>
<script src="<c:url value="/resources/js/Client/ClientAddressList.js"/>"></script>
<script src="<c:url value="/resources/js/General/DropDownForEmployee.js"/>"></script>
<script src="<c:url value="/resources/js/General/DropDownForLegend.js"/>"></script>
<script src="<c:url value="/resources/js/uniqueid/uniqueid.js"/>"></script>
<script src="<c:url value="/resources/js/General/DropDownForState.js"/>"></script>
<!-- <script type="text/javascript" src="../JavaScripts/ClientList.js"></script>
<script type="text/javascript" src="../JavaScripts/Client.js"></script>
<script type="text/javascript" src="../JavaScripts/ContactPersonList.js"></script>
<script type="text/javascript" src="../JavaScripts/ClientAddressList.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForEmployee.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForLegend.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForState.js"></script>  -->
</html>