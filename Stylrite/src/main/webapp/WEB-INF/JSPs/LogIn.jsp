<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link rel="shortcut icon" href="/resources/img/favicon.ico">
    <title>Stylrite</title>
    <!-- Font Awesome -->
    <link href="<c:url value="https://use.fontawesome.com/releases/v5.10.1/js/all.js" />" rel="stylesheet">
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/Bootstrap/login.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/Bootstrap/Style.css" />" rel="stylesheet">           
    <!-- Material Design Bootstrap -->
    <link href="<c:url value="/resources/css/mdb.min.css" />" rel="stylesheet">
    <!-- data table css -->
    <link href="<c:url value="/resources/css/jquery.dataTables.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/buttons.dataTables.min.css" />" rel="stylesheet">
    <!-- Your custom styles (optional) -->
    <link href="<c:url value="/resources/css/lms/lms.css" />" rel="stylesheet">
    <!-- Date time css -->
    <link href="<c:url value="/resources/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
    <style>
        #mydiv {
            position: fixed;
            top: 30%;
            left: 50%;
            width: 30em;
            height: 35em;
            margin-top: -9em;
            /*set to a negative number 1/2 of your height*/
            margin-left: -15em;
            /*set to a negative number 1/2 of your width*/
        }
    </style>
</head>

<body id="LoginForm">
    <div class="container" style="margin-top: 5%;">
        <div class="login-form">
            <div class="main-div" style="padding: 4%;">
                <div class="panel">
                    <img style="width: 76%;margin-bottom:  5%;margin-top: -12%;" src="resources/img/CompanyLogo.png" class="CompanyLogo">
                    <form id="LogInForm">
                        <div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
                        <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
                        <div class="alert alert-success HideThisElement" id="successMessage"></div>
                        <div class="form-group">
                            <i class="fas fa-user prefix"></i>
                            <input type="text" id="userId" placeholder="Username" name="userId" class="form-control">
                            <!-- <label for="userId"></label> -->
                        </div>
                        <div class="form-group">
                            <i class="fas fa-key prefix fa-flip-horizontal"></i>
                            <input type="password" id="password" placeholder="Password" name="password" class="form-control">
                        </div>
                        <div class="text-center">
                            <button class="btn btn-primary" id="SignInButton">Sign in</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- Material form login -->
    <!-- SCRIPTS -->
    <!-- JQuery -->
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js" />"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js " />"></script>
    <!-- data table cdns -->
    <script type="text/javascript" src="<c:url value="/resources/js/vendor/datatables/js/jquery.dataTables.min.js " />"></script>
    <script src="<c:url value="/resources/js/vendor/datatables/js/dataTables.bootstrap4.min.js" />"></script>
    <script src="<c:url value="/resources/js/vendor/datatables/js/dataTables.buttons.min.js " />"></script>
    <!-- Date time Js -->
    <script src="<c:url value="/resources/js/moment.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap-datetimepicker.min.js" />"></script>
    <script src="<c:url value="/resources/js/sweetalert.min.js" />"></script>
    <script src="<c:url value="/resources/js/fun_with_svg_arcs.js" />"></script>
    <script type="text/javascript">
    $(function() {
	    $("#SignInButton").click(function() {
	    	var url = "logInEmployee"; // the script where you handle the form input.
	        $.ajax({
	               type: "POST",
	               url: url,
	               data: $("#LogInForm").serialize(), // serializes the form's elements.
	               success: function(data)
	               {
	            	   // show response from the servlet.
	            	   if (data == 0) {
	            		  // toastr.error('User Name or Password is Incorrect!');
	            		   document.querySelector('#errorMessage').innerHTML = "<strong>Error!</strong> User Name or Password is Incorrect!";
						   $("#errorMessage").removeClass("HideThisElement");
	            		   
						} else {
							location='UserHome';
						}
	               }
	             });
	        return false; // avoid to execute the actual submit of the form.
	    });
	  });
    </script>
</body>

</html>