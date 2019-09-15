<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"  rel="stylesheet">
    <link href="<c:url value="/resources/css/Bootstrap/Style.css" />"  rel="stylesheet">
   	<!-- <script src="<c:url value="/resources/js/bootstrap-datepicker.js " />"></script> -->
   	<!-- <link href="<c:url value="/resources/css/bootstrap-datepicker.css" />"  rel="stylesheet"> -->
	<link href="<c:url value="/resources/css/bootstrap-datepicker.min.css" />"  rel="stylesheet">
    <link href="<c:url value="/resources/css/fontawesome-free-5.8.1-web/css/all.css" />"  rel="stylesheet">
    <link href="<c:url value="/resources/css/jquery.dataTables.min.css" />"  rel="stylesheet">
    <link href="<c:url value="/resources/css/buttons.dataTables.min.css" />"  rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/sweetalert2/6.4.1/sweetalert2.css" rel="stylesheet"/>    
<%-- 	<script type="text/javascript" src="<c:url value="/resources/js/General/Header.js " />"></script> --%>
    <style type="text/css">
	   #overlay {
	    position: fixed;
	    display: none;
	    width: 100%;
	    height: 100%;
	    z-index: 2;
	    cursor: pointer;
	}
	
	#casio {
	    margin-left: 40%;
	    margin-top: 13%;
	}
	
	.classForPageLengthMenu {
	    padding: 8px;
	    background: white;
	    border-radius: 5px;
	}
	
	body,
	.form-control {
	    font-size: 90% !important;
	    height: auto !important;
	}
	
	.alert p,
	.navbar p {
	    margin-bottom: 0rem !important;
	}
	
	* .collapse {
	    margin-left: 13%;
	}
	
	.container {
	    max-width: 85%;
	    margin-left: 13%;
	}
    </style>
    <script type="text/javascript">
	function onloadBody() {
		$.ajax({
			url:"http://localhost:8087/Stylrite/CheckIsLogged",
			type:"GET",
			success:function(data){ 
				if(data.indexOf("0")>=0){
					 window.location.replace('http://localhost:8087/Stylrite/LogOut?page=timeout');		
				}
			},
			error:function(data){
				if(data.indexOf("0")>=0){
					 window.location.replace('http://localhost:8087/Stylrite/LogOut?page=timeout');		
				}
			}		
		}); 
	}
	setInterval(function(){ 
		$.ajax({
			url:"http://localhost:8087/Stylrite/CheckIsLogged",
			type:"GET",
			success:function(data){ 
				if(data.indexOf("0")>=0){
					 window.location.replace('http://localhost:8087/Stylrite/LogOut?page=timeout');		
				}
			},
			error:function(data){
				if(data.indexOf("0")>=0){
					 window.location.replace('http://localhost:8087/Stylrite/LogOut?page=timeout');		
				}
			}		
		}); 
	}, 3600001);
</script>
</head>
<%-- <jsp:forward page="../Login.jsp" /> %> --%>

<body onload="onloadBody();">
<%-- <% if(session.getAttribute("departmentTxt") !=null && !session.getAttribute("departmentTxt").equals("IT") && !session.getAttribute("departmentTxt").equals("Management")&& !session.getAttribute("designationTxt").equals("Manager")){%>
<style type="text/css">
.sp{
	display:none	!important;
}
</style>
<%}else if(session.getAttribute("departmentTxt") !=null && !session.getAttribute("departmentTxt").equals("IT")   && session.getAttribute("departmentTxt").equals("Management")){%>
	<style type="text/css">
		.mg{
			display:none	!important;
		}
	</style>
<%}%> --%>
<div  class="main" id="overlay" >
	<div id="casio"></div>
</div>
<header>
    <div id="mySidenav" class="sidenav">
    	<input type="hidden" id="designationHeader" value="<%=session.getAttribute("designationTxt")%>"> 
    	<input type="hidden" id="departmentHeader" value="<%=session.getAttribute("departmentTxt")%>"> 
    	<input type="hidden" id="loggedInUserId" value="<%=session.getAttribute("userId")%>"> 
        	<!-- <a href="http://localhost:8087/Stylrite/View/UserHome.jsp" style="padding:  0px;margin-left: 6%;"><img style="width: 90%;margin-top: -5%;" src="http://localhost:8087/Stylrite/img/CompanyLogo.png" class="CompanyLogo"></a> -->
			
			<div class="collapsible"  id="accordion">
			  <li id="100001">
			  	<a class="collapsible-header waves-effect arrow-r" data-toggle="collapse" data-target="#Admin"><i class="fas fa-cogs"></i> Admin <i class="fa fa-angle-down pull-right"  ></i></a>
               	 <div class="collapse" id="Admin"  data-parent="#accordion">
               		<ul>
               			<li id="100002"><a href="http://localhost:8087/Stylrite/showEmployee" class="waves-effect">Employee</a>
                         </li>
               		</ul>
              	  </div>
               </li>
               <li id="200001">
				  	<a class="collapsible-header waves-effect arrow-r" data-toggle="collapse" data-target="#CRM"><i class="fas fa-users"></i> CRM <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="CRM"  data-parent="#accordion">
	               		<ul>
	               			<li id="200002"><a href="showClient" class="waves-effect">Client</a>
	                         </li>
	                          <li id="200003"><a href="showVendor" class="waves-effect">Vendor</a>
	                         </li>
	               		</ul>
	              	  </div>
	               </li>
	            <li id="300001">
				  	<a class="collapsible-header waves-effect arrow-r" data-toggle="collapse" data-target="#Inventory"><i class="fas fa-calendar-alt"></i> Inventory <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="Inventory"  data-parent="#accordion">
	               		<ul>   
	               			<li id="300002"><a href="showProduct" class="waves-effect">Product</a>
	                         </li>   
	                         <li id="300004"><a href="http://localhost:8087/Stylrite/stockOutOrder" class="waves-effect">Stock Out (Order)</a>
	                         </li>
	                         <li id="300005"><a href="http://localhost:8087/Stylrite/stockOutSample" class="waves-effect">Stock Out (Sample)</a>
	                         </li> 
	               		</ul>
	              	  </div>
	             </li>  
	             <li id="500001">
				  	<a class="collapsible-header waves-effect arrow-r" data-toggle="collapse" data-target="#GRN"><i class="fas fa-receipt"></i> GRN  <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="GRN"  data-parent="#accordion">
	               		<ul>
		               		<li id="500002"><a href="showGRN" class="waves-effect">Create GRN</a>
	                         </li>
	                         <li id="500003"><a href="uploadGRN" class="waves-effect">Upload GRN</a>
	                         </li>
	                         <li id="500004"><a href="http://localhost:8084/Stylrite/View/GRN/JSPs/GRNList.jsp?t=g" class="waves-effect HideThisElement">Generate Barcode</a>
	                         </li>
	                         <li id="500005"><a href="viewGRN" class="waves-effect HideThisElement">GRN View</a>
	                         </li>
	                         <li id="500006"><a href="http://localhost:8084/Stylrite/View/GRN/JSPs/AssignLocation.jsp" class="waves-effect HideThisElement">Assign Location</a>
	                         </li>
	                         <li id="500007"><a href="listGRN" class="waves-effect">GRN List</a>
	                         </li>	                         
	               		</ul>
	              	  </div>
	             </li>
	             <li id="600001">
				  	<a class="collapsible-header waves-effect arrow-r" data-toggle="collapse" data-target="#Barcode"><i class="fas fa-barcode"></i> Barcode  <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="Barcode"  data-parent="#accordion">
	               		<ul>
	               			<li id="600002"><a href="showBarcodeList" class="waves-effect">Barcode List</a>
	                         </li>
	                         <li id="600003"><a href="http://localhost:8087/Stylrite/showEmptyLocationList" class="waves-effect">Empty Location</a>
	                         </li>   
	                         <li id="600004"><a href="assignLocation" class="waves-effect">Assign Location</a>
	                         </li>              
	               		</ul>
	              	  </div>
	             </li>
	             <li id="570001">
				  	<a class="collapsible-header waves-effect arrow-r" data-toggle="collapse" data-target="#sample"><i class="fa fa-print"></i>Sample<i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="sample"  data-parent="#accordion">
	               		<ul>
	                         <li id="570001"><a href="showSampleList" class="waves-effect ">Sample List</a>
	                         </li>
	                         <li id="570002"><a href="showNewRequistion" class="waves-effect ">New Requistion</a>
	                         </li>
	                           <li id="570003"><a href="showSampleTransfer" class="waves-effect ">Sample Transfer</a>
	                         </li>
	                           <li id="570004"><a href="showSampleReturn" class="waves-effect ">Sample Return</a>
	                         </li>
	                         <!-- <li id="570003"><a href="showBrandWiseStockList1" class="waves-effect ">Location wise Stock</a>
	                         </li>
	                         <li id="570004"><a href="showBrandWiseStockList1" class="waves-effect ">Sales Person wise Samples</a>
	                         </li>
	                         <li id="570005"><a href="showBrandWiseStockList1" class="waves-effect ">All Samples </a>
	                         </li>
	                         <li id="570006"><a href="showBrandWiseStockList1" class="waves-effect ">Brandwise My Sample </a>
	                         </li>
	                         <li id="5700010"><a href="showBrandWiseStockList1" class="waves-effect ">My Sample </a>
	                         </li> -->
	               		</ul>
	              	  </div>
	             </li>
	             <li id="800001">
				  	<a class="collapsible-header waves-effect arrow-r" data-toggle="collapse" data-target="#Order"><i class="fas fa-shopping-cart"></i> Order <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="Order"  data-parent="#accordion">
	               		<ul>
	               			  <li id="800002"><a href="showOrder" class="waves-effect">New Order</a>
	                         </li>
	                           <li id="800003"><a href="showOrder1" class="waves-effect">Order List</a>
	                         </li>
	                            <li id="800004"><a href="showInprocessOrder" class="waves-effect">In Process Order</a>
	                         </li>
	                         <li id="800005"><a href="showPendingOrder" class="waves-effect">Pending Order</a>
	                         </li>
	                         <li id="800006"><a href="showOrderStatus" class="waves-effect">Closed Orders</a>
	                         </li>


	               		</ul>
	              	  </div>
	             </li>
	             <li id="110001">
				  	<a class="collapsible-header waves-effect arrow-r" data-toggle="collapse" data-target="#Invoice"><i class="fas fa-file-invoice"></i> Invoice and Dispatch <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="Invoice"  data-parent="#accordion">
	               		<ul>
	                        <li id="110005"><a href="http://localhost:8087/Stylrite/showRequisition" class="waves-effect">All Requisition</a>
	                        </li>
	               		</ul>
	              	  </div>
	             </li>	  
	              <li id="1200001">
				  	<a class="collapsible-header waves-effect arrow-r" data-toggle="collapse" data-target="#Product"><i class="fa fa-parking"></i> NPD Product <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="Product"  data-parent="#accordion">
	               		<ul>
	               			<li id="1200002"><a href="showProductNPD" class="waves-effect">NPD Product List</a>
	                         </li>
	                         <li id="1200003"><a href="showRequestForPurchase" class="waves-effect">Request For Purchase</a>
	                         </li>
	                         <li id="1200004"><a href="showRequestForProduction" class="waves-effect">Request For Production</a>
	                         </li>
	               		</ul>
	              	  </div>
	               </li>
	               <li id="1300001">
				  	<a class="collapsible-header waves-effect arrow-r" data-toggle="collapse" data-target="#audit"><i class="fa fa-history"></i> Audit <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="audit"  data-parent="#accordion">
	               		<ul>
	               			<li id="1300002"><a href="showCreateAudit" class="waves-effect">Create Audit</a>
	                         </li>
	                           <li id="1300003"><a href="showAuditList" class="waves-effect">Audit List</a>
	                         </li>
	                         <li id="1300004"><a href="showRequestForProduction" class="waves-effect HideThisElement">Request For Production</a>
	                         </li>
	               		</ul>
	              	  </div>
	               </li>  
	                <li id="140001">
				  	<a class="collapsible-header waves-effect arrow-r" data-toggle="collapse" data-target="#Return"><i class="fas fa-undo"></i> Return <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="Return"  data-parent="#accordion">
	               		<ul>
	               			<li id="140002"><a href="showReturn" class="waves-effect"> Return </a>
	                        </li>
	                        <li id="140003"><a href="showReturnItem" class="waves-effect"> Return Item </a>
	                        </li>
	                        <!-- <li id="130003"><a onclick="DownloadLocationwiseStock('101')" class="waves-effect">Download In Stock</a>
	                        </li>
	                        <li id="130004"><a onclick="DownloadLocationwiseStock('102')" class="waves-effect">Download Sample Stock</a>
	                        </li> -->
	               		</ul>
	              	  </div>
	             </li>       
			</div>
    </div>
    <nav class="navbar navbar-expand-sm navbar-dark sticky-top">
        <div class="float-left">
            <p style="cursor:pointer" onclick="openNav()"><i class="fa fa-bars" style="margin-right: 10px;font-size: 120%;color:white;"></i> </p>
        </div>
        <!-- Breadcrumb-->
        <div class="breadcrumb-dn mr-auto">
        	<div class="row" style="margin-left:0px">
	        	<div class="breadcrumb-dn mr-auto">
	            	<p id="HomeText" style="font-size: 120%;font-weight: 500; color:white;"> Home</p>
	            </div>
	            <!-- <div class="center">
		            <h5 style="padding-left:50px"><i class="fas fa-caret-square-right"></i> Home</h5>
		        </div> -->
	         </div>
        </div>	
        <ul class="navbar-nav">
            <li class="nav-item" id="15000000">
                <a style="font-size: 120% !important; color:  white;" class="nav-link dropdown-toggle waves-effect" href="#" id="userDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fa fa-user" style="color:white;"></i> <span class="clearfix d-none d-sm-inline-block" style="font-size:15px;color:white;"><%=session.getAttribute("userName") %></span>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown" style="margin-right: 1%; color:white;">
                    <a class="dropdown-item" href="http://localhost:8087/Stylrite/LogOut">Log Out</a>
                    <a class="dropdown-item" href="http://localhost:8087/Stylrite/View/Employee/JSPs/ChangePassword.jsp">Change Password</a>
                </div>
            </li>
            <li class="nav-item">

            </li>
        </ul>
    </nav>
    <br>
    </header>
   <%--  <%@include file="Footer.jsp" %>	 --%>
</body>

</html>