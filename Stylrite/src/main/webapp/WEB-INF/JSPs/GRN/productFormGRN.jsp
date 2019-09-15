<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html lang="en">

            <head>

                <style>
                    .mandatory-element {
                        color: red;
                    }
                </style>

            </head>

            <body>
               <div class="card" id="productFormGRNDiv">
			    <div class="card-body">
			    	<h5 class="card-title" id = "headerName"></h5><!-- <hr id = "hrProduct"> -->
					<form action="" id="insertProductFormGRN" name="insertProductFormGRN">
			        <input type="hidden" id="productId">
			        <input type="hidden" name="action" id="action" >
			        <div class="form-row">
			              <!--  <div class="form-group col-md-4">
			                 <label id="brand" for="brand" class="">Brand <span class="mandatory-element">*</span></label>
			                 <input type="text" class="form-control" id="brand" name="brand"  placeholder="Brand">
			              </div> -->
			              <div class="form-group col-md-3" id="brandFrm">
			                  <label id="brandLbl" for="brand" class="">Brand <span class="mandatory-element">*</span></label><br>
			                    <select class="selectpicker" data-live-search="true" id="brand"  name="brand" style="width: 100%;">
			                    	<option value="select Brand"></option>
			  					</select>
			              </div>
			              <div class="form-group col-md-2">
			                 <label id="modelNoLbl" for="modelNo" class="">Model No <span class="mandatory-element">*</span></label>
			                 <input type="text" class="form-control" id="modelNo" name="modelNo"  placeholder="Model No">
			              </div>
			              <div class="form-group col-md-2">
			                  <label>Color <span class="mandatory-element">*</span></label>
			                  <input type="text" class="form-control" id="color" name="color"  placeholder="Color">				
			              </div>
			              <div class="form-group col-md-2">
			                  <label>Size <span class="mandatory-element">*</span></label>
			                  <input type="text" class="form-control" id="size" name="size"  placeholder="Size" >				
			              </div>
			              <div class="form-group col-md-3">
			                  <label>Type <span class="mandatory-element">*</span></label>
			                  <select class="form-control" id="type" name="type" ></select>				
			              </div>
			               <div class="form-group col-md-2">
			                  <label>Quantity <span class="mandatory-element">*</span></label>
			                  <input type="number" class="form-control" id="quantity" name="quantity"  placeholder="Quantity">	
			              </div>
			              <div class="form-group col-md-2">
			                  <label>Cost <span class="mandatory-element">*</span></label>
			                  <input type="number" class="form-control" id="cost" name="cost"  placeholder="Cost">				
			              </div>
			              <div class="form-group col-md-3" id = "MRPProduct">
			                  <label>MRP <span class="mandatory-element">*</span></label>
			                  <input type="number" class="form-control" id="MRP" name="MRP"  placeholder="MRP">				
			              </div>
			              <div class="form-group col-md-12" id="skuDiv">
			                 				
			              </div>
			          </div>
				      <div class="left">
					        <button type="button" class="btn btn-primary HideThisElement" id="GenerateSKU">Generate SKU</button>
					       	<button type="button" class="btn btn-primary HideThisElement" id="SubmitButtonProduct">Submit</button>		        
					        <button type="button" class="btn btn-primary HideThisElement" id="UpdateButtonProduct">Update</button>
				        	<button type="button" class="btn btn-primary HideThisElement" id="BackButtonProduct">Back</button>
				      </div>
			        </form>
			    </div>
			    </div>
            </body>

            </html>