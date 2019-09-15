<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="shortcut icon" href="/resources/img/favicon.ico">
</head>
<body>
 <jsp:include page="/WEB-INF/JSPs/Header.jsp" />
 <main class="center">
	<a href="http://localhost:8087/Stylrite/View/UserHome.jsp" style="padding:  0px;margin-left: 6%;"><img style="width: 50%;" src="http://localhost:8087/Stylrite/img/CompanyLogo.png" class="CompanyLogo"></a>
</main>
<%@include file="Footer.jsp" %>
</body>
</html>