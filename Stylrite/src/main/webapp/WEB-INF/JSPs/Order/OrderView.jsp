 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Order List</title>
<link rel="shortcut icon" href="../../../img/TitleImage.png">
<style type="text/css">
#OrderTableDiv .dt-button{
	display: none	!important;
}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
	<div class="container">
		<div class="container-fluid">
       		<input type="hidden" id="type" name="type" value="<%= request.getParameter("t") %>">
			 <jsp:include page="/WEB-INF/JSPs/Order/OrderList.jsp"/>
		</div>
	</div>
</body>
  <script src="<c:url value="/resources/js/Order/OrderList.js"/>"></script>
</html>