<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Employee</title>
</head>
<body>
<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
<div class="container">
	<div class="container-fluid">
		<%@include file="EmployeeList.jsp" %>
		<%@include file="EmployeeView.jsp" %>
		<%@include file="EmployeeForm.jsp" %>
		<%@include file="ResetPassword.jsp" %>
		<%@include file="DeleteEmployee.jsp" %>
	</div>
</div>
</body>
<jsp:include page="/WEB-INF/JSPs/Footer.jsp" />
<script type="text/javascript" src="<c:url value="/resources/js/Employee/EmployeeList.js " />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/Employee/Employee.js " />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/Employee/AccessControl.js " />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/General/DropDownForLegend.js " />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/General/SelectForManager.js " />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/General/DropDownForState.js " />"></script>
</html>