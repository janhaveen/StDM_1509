<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html lang="en">

            <head>
    <meta charset="UTF-8">
    <title>Client</title>
    <style type="text/css">
		.switch {
		  position: relative;
		  display: inline-block;
		  width: 42px;
		  height: 22px;
		}
		
		.switch input {display:none;}
		
		.slider {
		  position: absolute;
		  cursor: pointer;
		  top: 0;
		  left: 0;
		  right: 0;
		  bottom: 0;
		  background-color: #ccc;
		  -webkit-transition: .4s;
		  transition: .4s;
		}
		
		.slider:before {
		  position: absolute;
		  content: "";
		  height: 15px;
		  width: 15px;
		  left: 4px;
		  bottom: 4px;
		  background-color: white;
		  -webkit-transition: .4s;
		  transition: .4s;
		}
		
		input:checked + .slider {
		  background-color: #2196F3;
		}
		
		input:focus + .slider {
		  box-shadow: 0 0 1px #2196F3;
		}
		
		input:checked + .slider:before {
		  -webkit-transform: translateX(20px);
		  -ms-transform: translateX(20px);
		  transform: translateX(20px);
		}
		
		/* Rounded sliders */
		.slider.round {
		  border-radius: 34px;
		}
		
		.slider.round:before {
		  border-radius: 50%;
		}
    </style>
</head>
<body>	
    <div class="card HideThisElement" id="VendorFormDiv">
    <div class="card-body">
    	<h5 class="card-title">New Vendor</h5><hr>
        <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item">
                <a class="nav-link active" id="VendorDetails-tab" data-toggle="tab" href="#VendorDetails" role="tab" aria-controls="VendorDetails" aria-selected="true">Vendor Details</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="ContactPersonDetails-tab" data-toggle="tab" href="#ContactPersonDetails" role="tab" aria-controls="ContactPersonDetails" aria-selected="false">Contact Persons Details</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="Address-tab" data-toggle="tab" href="#AddressDetails" role="tab" aria-controls="AddressDetails" aria-selected="true">Address Details</a>
            </li>
        </ul>
		
			<div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
	        <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
	        <div class="alert alert-success HideThisElement" id="successMessage"></div>
	    
	      
	      
	     
	        <div class="tab-content" id="myTabContent">
	            <div class="tab-pane fade show active" id="VendorDetails" role="tabpanel" aria-labelledby="VendorDetails-tab">
	                 <form action="" id="newVendorElementForm" name="newVendorElementForm">
	                     <input type="hidden" name="rowId" id="selectedVendorId">
	                    <input type="hidden" name="action" id="action">
	                <div class="form-row">
	               
	                    <div class="form-group col-md-4">
	                        <label id="companyNameLbl" for="companyName" class="">Company Name <span class="mandatory-element">*</span></label>
	                        <input type="text" class="form-control capitalizeText" id="companyName" name="companyName" placeholder="Company name">
	                    </div>
	                    <div class="form-group col-md-4">
	                       <label id="locationLbl" for="location" class="">Location <span class="mandatory-element">*</span></label>
	                       <input type="text" class="form-control capitalizeText" id="location" name="location"  placeholder="Location">
	                    </div>
	                    <!-- <div class="form-group col-md-4">
	                        <label>Gender</label><br>
	                        <div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="Gender" id="Male" value="801" checked="checked">
								  <label class="form-check-label" for="Male">Male</label>
							</div>
							<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="Gender" id="Female" value="802">
								  <label class="form-check-label" for="Female">Female</label>
							</div>
	                    </div> -->
	                	<div class="form-group col-md-4">
	                        <label for="customerType">Customer Type <span class="mandatory-element">*</span></label>
	                        <select class="form-control" id="customerType" name="customerType">
	                        </select>
	                    </div>
	                </div>
	                <div class="form-row">
	                    <div class="form-group col-md-4">
	                        <label id="creditTimeLbl" for="creditTime" class="">Credit Time <span class="mandatory-element">*</span></label>
	                        <input type="number" class="form-control validate" id="creditTime" name="creditTime"  placeholder="Credit Time">
	                    </div>
	                    <div class="form-group col-md-4">
	                        <label id="creditLimitLbl" for="creditLimit" class="">Credit Limit</label>
	                        <input type="number" class="form-control validate" id="creditLimit" name="creditLimit"  placeholder="Credit Limit">
	                    </div>
	                	<!-- <div class="form-group col-md-4">
	                        <label for="customerType">Sales Person <span class="mandatory-element">*</span></label>
	                        <select class="form-control" id="salesPerson" name="salesPerson">
	                        </select>
	                    </div> -->
	                </div>
	                <div class="form-row">
	                	<div class="form-group col-md-4">
	                        <label for="source">Source <span class="mandatory-element">*</span></label>
	                        <select class="form-control" id="source" name="source">
	                            <option value="" selected>Select Source</option>
	                        </select>
	                    </div>
	                    <div class="form-group col-md-4 HideThisElement" id="referenceDiv">
	                        <label id="referenceLbl" for="reference" class="">Reference</label>
	                        <input type="text" class="form-control validate" id="reference" name="reference" placeholder="Reference By">
	                    </div>
	                </div>
	                </form>
	            </div>
	            <div class="tab-pane fade" id="AddressDetails" role="tabpanel" aria-labelledby="AddressDetails-tab">
	                           
		               <form action="" id="insertVendorAddressDetails" name="insertVendorAddressDetails">
		                 <input type="hidden" name="rowId" id="selectedVendorAddressId">
		                  <input type="hidden" name="action" id="action">
		             <div class="form-row">
	                    <div class="form-group col-md-3">
	                        <label for="branchName">Branch Name <span class="mandatory-element">*</span></label>
	                        <input type="text" class="form-control" name="branchName" id="branchName" placeholder="Branch Name">
	                    </div>
	                    <div class="form-group col-md-3">
	                        <label for="ledgerName">Ledger Name</label>
	                        <input type="text" class="form-control" name="ledgerName" id="ledgerName" placeholder="Ledger Name">
	                    </div>
	                    <div class="form-group col-md-3">
	                        <label for="GSTNo">GST No</label>
	                        <input type="text" class="form-control" name="gstNo" id="GSTNo" placeholder="GST No">
	                    </div>
	                    <div class="form-group col-md-3">
	                        <label for="contactNoAdd">Contact No</label>
	                        <input type="number" class="form-control" name="contactNo" id="contactNoAdd" placeholder="Contact No">
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="inputAddress">Address Line 1</label>
	                    <input type="text" class="form-control" name="addressLine1" id="inputAddress" placeholder="Address Line 1">
	                </div>
		            <div class="form-group">
	                    <label for="inputAddress2">Address Line 2</label>
	                    <input type="text" class="form-control" name="addressLine2" id="inputAddress2" placeholder="Address Line 2">
		             </div>
		             <div class="form-row">
	                    <div class="form-group col-md-3">
	                        <label for="locationAdd">Location</label>
	                        <input type="text" class="form-control" name="location" id="locationAdd" placeholder="Location">
	                    </div>
	                    <div class="form-group col-md-3">
	                        <label for="inputCity">City</label>
	                        <input type="text" class="form-control" name="city" id="inputCity" placeholder="City">
	                    </div>
	                    <div class="form-group col-md-3">
	                        <label for="inputState">State <span class="mandatory-element">*</span></label>
	                        <select id="inputState" name="state" class="form-control">
	                        </select>
	                    </div>
	                    <div class="form-group col-md-3">
		                    <div class="row">
			                    <div class="form-group col-md-6">
			                        <label for="inputZip">Pin</label>
			                        <input type="number" class="form-control" name="pincode" id="inputZip" placeholder="Pin">
			                    </div>
			                    <div class="form-group col-md-6">
			                        <label id="isdefaultLbl" for="isDefaultAdd">Is Default?</label><br>
				                    <label class="switch">
									  <input type="checkbox" name="isDefault" id="isDefaultAdd">
									  <span class="slider"></span>
									</label>
			                    </div>
		                    </div>
	                    </div>
	                </div>
	                </form>
	            </div>
	            <div class="tab-pane fade" id="ContactPersonDetails" role="tabpanel" aria-labelledby="ContactPersonDetails-tab">
	                  <form action="" id="insertVendorContactDetails" name="insertVendorContactDetails">
	                    <input type="hidden" name="rowId" id="selectedVendorContactPersonId">
	                 <input type="hidden" name="action" id="action">
	                <div class="form-row">
	                    <div class="form-group col-md-4">
	                        <label id="firstNameLbl" for="firstName" class="">First name <span class="mandatory-element">*</span></label>
	                        <input type="text" class="form-control capitalizeText" id="firstName" name="firstName" placeholder="First name">
	                    </div>
	                    <div class="form-group col-md-4">
	                       <label id="lastNameLbl" for="lastName" class="">Last name</label>
	                       <input type="text" class="form-control capitalizeText" id="lastName" name="lastName"  placeholder="Last name">
	                    </div>
	                    <div class="form-group col-md-4">
	                       <label id="locationCPLbl" for="locationCP" class="">Location <span class="mandatory-element">*</span></label>
	                       <input type="text" class="form-control capitalizeText" id="locationCP" name="location" placeholder="Location">
	                    </div>
	                </div>
	                <div class="form-row">
	                    <div class="form-group col-md-4">
	                        <label id="mobilenoLbl" for="mobileno" class="">Contact No <span class="mandatory-element">*</span></label>
	                        <input type="number" maxlength="10" min="1000000000" max="9999999999" class="form-control validate" id="mobileno" name="contactNo"  placeholder="Contact No">
	                    </div>
	                    <div class="form-group col-md-4">
	                        <label id="altContactNoLbl" for="altContactNo" class="">Alt Contact No</label>
	                        <input type="number" class="form-control validate" id="altContactNo" name="altContactNo"  placeholder="Alt Contact No">
	                    </div>
	                    <div class="form-group col-md-4">
	                        <label id="emailIdLbl" for="emailId"  class="">Email ID <span class="mandatory-element">*</span></label>
	                    	<input type="email" class="form-control validate" id="emailId"  pattern=".+@.+..+" name="emailId"  placeholder="name@example.com">
	                    </div>
	                </div>
	                <div class="form-row">
	                	<div class="form-group col-md-3">
	                        <label for="department">Department <span class="mandatory-element">*</span></label>
	                        <select class="form-control" id="department" name="department">
	                            <option value=""  selected>Select Department</option>
	                        </select>
	                    </div>
	                    <div class="form-group col-md-3">
	                        <label>Designation <span class="mandatory-element">*</span></label>
	                        <select class="form-control" id="designation" name="designation">
	                            <option value=""  selected>Select Designation</option>
	                        </select>
	                    </div>
	                	<div class="form-group col-md-3">
	                        <label id="birthDateLbl" for="birthDate">BirthDate <span class="mandatory-element">*</span></label>
	                        <input placeholder="BirthDate" type="text" id="birthDate" data-value="27 November, 2017" name="birthdate" class="form-control datepicker">
	                    </div>
	                    <div class="form-group col-md-3" >
	                        <label id="isdefaultLbl" for="isDefaultCP">Is Default?</label><br>
		                    <label class="switch">
							  <input type="checkbox" name="isDefault" id="isDefaultCP">
							  <span class="slider"></span>
							</label>
	                    </div>
	                </div>
	                </form>
	            </div>
	        </div>
	        <div class="left">
		        <button type="button" class="btn btn-primary HideThisElement" id="SubmitButtonRegister">Submit</button>
                <button type="button" class="btn btn-primary HideThisElement" id="SubmitButtonVendorContactPerson">Submit</button>
                <button type="button" class="btn btn-primary HideThisElement" id="SubmitButtonVendorAddressDetails">Submit</button>
                <button type="button" class="btn btn-primary HideThisElement" id="SubmitButtonUpdate">Update</button>
                <button type="button" class="btn btn-primary HideThisElement" id="SubmitButtonUpdateVContactPerson">Update</button>
                <button type="button" class="btn btn-primary HideThisElement" id="SubmitButtonUpdateVAddress">Update</button>
                <button type="button" class="btn btn-primary " id="SubmitButtonBack">Back</button>
		    </div>
  
    </div>
    </div>
</body>

<script>
	 
</script>
</html>