<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="modal fade" id="centralModalWarningDemo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-notify modal-warning" role="document">
        <!--Content-->
        <div class="modal-content">
            <!--Header-->
            <div class="modal-header" style="background:#ffa500;">
                <p class="heading">Reset Password</p>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true" class="white-text">&times;</span>
                </button>
            </div>
            <!--Body-->
            <div class="modal-body">
                <input type="hidden" id="ResetPassEmpId" name="ResetPassEmpId">
                <div class="row">
                    <div class="col-3 text-center">
                        <img src="<c:url value="/resources/img/warningModel.png"/>" alt="Warning" class="img-fluid z-depth-1-half rounded-circle">
                        <div style="height: 10px"></div>
                    </div>
                    <div class="col-9">
                        <p>Password will be reset to default.</p>
                        <p>i.e. "pass123"</p>
                        <p>Click 'Confirm' to proceed, and 'Close' to cancel.</p>
                    </div>
                </div>
            </div>
            <!--Footer-->
            <div class="modal-footer justify-content-center">
                <a type="button" class="btn btn-primary-modal" id="resetPasswordConfirmed" style="background:#ffa500;">Confirm</a>
                <a type="button" class="btn btn-outline-secondary-modal waves-effect" style="border: 1px solid #ffa500;" data-dismiss="modal">Close</a>
            </div>
        </div>
        <!--/.Content-->
    </div>
</div>
</body>
</html>