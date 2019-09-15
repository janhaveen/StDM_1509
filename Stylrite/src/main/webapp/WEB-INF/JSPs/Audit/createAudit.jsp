<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html lang="en">

            <head>

                <style>
                    .mandatory-element 
                    {
                        color: red;
                    }
                </style>

            </head>

            <body>
               <div class="card" id="createAuditFormDiv">
			    <div class="card-body">
			    	<h5 class="card-title" id = "headerName"></h5><hr id = "hrProduct">
					<form action="" id="insertCreateAuditForm" name="insertCreateAuditForm">
					<input type="hidden" id="auditId">
			        <div class="form-row">
			                <div class="form-group col-md-2">
			                  <label>Audit Reason <span class="mandatory-element">*</span></label>
			                  <select class="form-control" id="auditReason" name="auditReason" ></select>				
			              </div>
			              
			              <div class="form-group col-md-2">
			                  <label>Section <span class="mandatory-element">*</span></label>
			                   <input type="text" id="section" name="section" class="form-control">				
			              </div>
			              
			              <div class="form-group col-md-6">
			                  <label>Description</label>
			                  <textarea class="form-control capitalizeText" id="remarks" rows="3" name="remarks"  placeholder="Description"></textarea>				
			              </div>
			             <div class="form-group col-md-2"  id = "descriptionProduct">
					       	<button type="button" class="btn btn-sm btn-primary" id="ContinueButtonCreateAudit" style="margin-top: 27%;">Continue</button>		        
				        	<button type="button" class="btn btn-primary  HideThisElement" id="BackButtonProduct">Back</button>
				      	</div>
			          </div>
				      
			        </form>
			    </div>
			    </div>
            </body>

            </html>