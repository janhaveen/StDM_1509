<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<!--Footer-->
  <footer class="page-footer pt-0 mt-5">
    <div class="footer-copyright py-3 text-center">
      <div class="container-fluid">
        <!-- © 2019 Copyright: -->
        Designed and Developed by <a href="https://www.effexway.com/"> Effex Business Solutions Pvt. Ltd.</a>
      </div>
    </div>
  </footer>
    <script src="<c:url value="/resources/js/jquery-3.3.1.min.js " />"></script>
    <script src="<c:url value="/resources/js/popper.min.js " />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js " />"></script>   	
   	<script src="<c:url value="/resources/js/bootstrap-datepicker.min.js " />"></script>
    <script src="<c:url value="/resources/js/jquery.dataTables.min.js " />"></script>
    <script src="<c:url value="/resources/js/vendor/datatables/js/jquery.dataTables.min.js" />"></script>
	<script src="<c:url value="/resources/js/vendor/datatables/js/dataTables.buttons.min.js" />"></script>
	<script src="<c:url value="/resources/js/vendor/datatables/js/buttons.flash.min.js" />"></script>
	 <script src="<c:url value="/resources/js/main/main.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/General/IDGenerator.js " />"></script> 
    <script type="text/javascript" src="<c:url value="/resources/js/General/DataExport.js " />"></script> 
	<script src="https://cdn.jsdelivr.net/sweetalert2/6.4.1/sweetalert2.js " /></script>   
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js " /></script>
	<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.html5.min.js " /></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js " /></script>
	<script type="text/javascript" src="<c:url value="/resources/js/Spinner/Spinner.js " />"></script>
	
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js " /></script>
  <script type="text/javascript">
function openNav() {
	if(!$("#mySidenav").hasClass("viewDiv")){
	    document.getElementById("mySidenav").style.width = "230px";
	    $("#mySidenav").addClass("viewDiv");
	}else{
		document.getElementById("mySidenav").style.width = "0px";
		$("#mySidenav").removeClass("viewDiv");
	}
}

/* function closeNav() {
    document.getElementById("mySidenav").style.width = "0px";
} */
$( function() {
	var p = [];
	var ourRequest1 = new XMLHttpRequest();
	var data1 = [];
	ourRequest1.open('GET', 'GetEmployeeList');
	ourRequest1.onload = function() {
	    if (ourRequest1.status >= 200 && ourRequest1.status < 400) {
	        data1 = JSON.parse(ourRequest1.responseText);
	        createHTML1(data1);
	    } else {
	        console.log("We connected to the server, but it returned an error.");
	    }
	};
	ourRequest1.onerror = function() {
	    console.log("Connection error");
	};
	ourRequest1.send();

	function createHTML1(data) {
	    if (data.data[0].permissions != "") {
	        p.push(data.data[0].permissions.split(","));
	    }
	    if (p.length > 0) {console.log("sdc");
	        $('header li').each(function(i) {
	            if ($($('header li')[i]).attr('id') != "15000000") {
	                if ($.inArray($($('li')[i]).attr('id'), p[0]) < 0) {
	                    $($('header li')[i]).css('display', 'none');
	                }
	           }
	        });
	        //p.pop(0);
	    }
	}
	
   $( ".datepicker" ).datepicker({
	   format: "dd MM, yyyy",
	   orientation:"bottom"
   });
   $('.datepicker').datepicker()
   .on('change', function(e) { 
   		$('.datepicker').datepicker('hide');
   });
   $('body').on('click', function (e) { 
	    //did not click a popover toggle or popover
	    if ($(e.target).data('toggle') !== 'popover'
	        && $(e.target).parents('.popover.in').length === 0) { 
	        $('[data-toggle="popover"]').popover('hide');
	    }	    
	});
	casio = 0;
	$.d('casioInt',setInterval(function(){
		casio++;
		var a={pathStrokeWidth:5};
		if (casio==361) casio = 1;
		a.startAng = casio;
		a.endAng = casio + 90;
		$('#casio').drawCircle(a);
	},1));
   $('.container').on('click', function (e) {  
	   if($("#mySidenav").hasClass("viewDiv")){
		   document.getElementById("mySidenav").style.width = "0px";
			$("#mySidenav").removeClass("viewDiv");
		}
	});
 });
 

function SwalWarningHeader(msg)
{
	swal({
		  text: msg,
		  type: "warning",
		  confirmButtonText: "Ok!",
		  closeOnConfirm: false
		});
}
function SwalErrorHeader(msg)
{
	swal({
		  text: msg,
		  type: "error",
		  confirmButtonText: "Ok!",
		  closeOnConfirm: false
		});
}

function SwalSuccessHeader(msg)
{
	swal({
		  text: msg,
		  type: "success",
		  confirmButtonText: "Ok!",
		  closeOnConfirm: false
		});
}

function spinnerOn() {
    document.getElementById("overlay").style.display = "block";
}

function spinnerOff() {
  document.getElementById("overlay").style.display = "none";
}
</script>
</body>
</html>