<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <link href="<c:url value="/resources/img/favicon.ico" />" rel="shortcut icon">
            <link href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.2/css/bootstrap-select.min.css" />" rel="stylesheet">

            <title>Return</title>
        </head>

        <body>
            <jsp:include page="/WEB-INF/JSPs/Header.jsp" />
            <div class="container">
                <div class="container-fluid">
                    <input type="hidden" id="for" name="for">
                    <input type="hidden" id="returnId">
                    <jsp:include page="/WEB-INF/JSPs/Return/ReturnList.jsp" />
                    <jsp:include page="/WEB-INF/JSPs/Return/ReturnForm.jsp" />
                    <%-- <jsp:include page="/WEB-INF/JSPs/Return/ReturnForEditView.jsp" /> --%>
                </div>
            </div>
        </body>
        <jsp:include page="/WEB-INF/JSPs/Footer.jsp" />

        <script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.2/js/bootstrap-select.min.js" />"></script>
        <script src="<c:url value="/resources/js/Return/ReturnList.js" />"></script>
        <script src="<c:url value="/resources/js/Return/Return.js"/>"></script>
        <script src="<c:url value="/resources/js/Client/ClientAddressList.js"/>"></script>
        <script src="<c:url value="/resources/js/Client/ClientList.js"/>"></script>
        <script src="<c:url value="/resources/js/Client/ContactPersonList.js"/>"></script>
        <script src="<c:url value="/resources/js/Client/ClientInfo.js"/>"></script>
        <script src="<c:url value="/resources/js/General/DropDownForProductLegend.js" />"></script>
        <script src="<c:url value="/resources/js/General/DropDownForHSN.js" />"></script>
        <script src="<c:url value="/resources/js/General/DropDownForLegend.js"/>"></script>
        <script src="<c:url value="/resources/js/General/DropDownForState.js"/>"></script>
        <script src="<c:url value="/resources/js/General/DropDownForEmployee.js"/>"></script>

        </html>