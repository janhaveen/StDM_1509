<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <link href="<c:url value="/resources/img/favicon.ico" />" rel="shortcut icon">
             <title>Return Item</title>
			</head>
			<body>
			<jsp:include page="/WEB-INF/JSPs/Header.jsp" />
	            <div class="container">
	                <div class="container-fluid">
			       		<input type="hidden" id="for" name="for">
			       		<input type="hidden" id="returnId">
						<jsp:include page= "/WEB-INF/JSPs/Return/ReturnItemList.jsp"/>
						<jsp:include page= "/WEB-INF/JSPs/Return/ReturnItemForEditView.jsp"/>
					</div>
				</div>
			</body>
			 <jsp:include page="/WEB-INF/JSPs/Footer.jsp" />
			 
			  <script src="<c:url value="/resources/js/Return/ReturnItemList.js" />"></script>
			  
			</html>