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
               <div class="card HideThisElement" id="barcodeFormDiv">
			    <div class="card-body">
				    <div class="col-md-6 row"><h5 class="card-title">Barcode Details Update</h5></div>
			    	<h5 class="card-title" id = "headerName"></h5><hr id = "hrBarcode">
					<form action="" id="insertBarcodeForm" name="insertBarcodeForm">
			        <input type="hidden"  id="barcodeId">
			        <input type="hidden" id="productId">
			         <input type="hidden" id="oldProductId">
			        <input type="hidden" name="action" id="action" >
			         <div class="form-row">
			              <div class="form-group col-md-3" id="brandFrm">
			                  <label id="brandLbl" for="brand" class="">Brand <span class="mandatory-element">*</span></label><br>
			                    <select class="selectpicker" data-live-search="true" id="brand"  name="brand" style="width: 100%;">
			                    	<option value="select Brand"></option>
			  					</select>
			              </div>
			              <div class="form-group col-md-3">
			                 <label id="modelNoLbl" for="modelNo" class="">Model No <span class="mandatory-element">*</span></label>
			                 <input type="text" class="form-control" id="modelNo" name="modelNo"  placeholder="Model No">
			              </div>
			              <div class="form-group col-md-3">
			                  <label>Color <span class="mandatory-element">*</span></label>
			                  <input type="text" class="form-control" id="color" name="color"  placeholder="Color">				
			              </div>
			              <div class="form-group col-md-3">
			                  <label>Size <span class="mandatory-element">*</span></label>
			                  <input type="text" class="form-control" id="size" name="size"  placeholder="Size" >				
			              </div>
			               <div class="form-group col-md-3">
			                  <label>Type <span class="mandatory-element">*</span></label>
			                  <select class="form-control" id="type" name="type" ></select>				
			              </div>
			               <div class="form-group col-md-3">
			                  <label>Location <span class="mandatory-element">*</span></label>
			                  <input type="text" class="form-control" id="location" name="location"  placeholder="Location">				
			              </div>
			               <div class="form-group col-md-3">
			                  <label>Cost <span class="mandatory-element">*</span></label>
			                  <input type="number" class="form-control" id="cost" name="cost"  placeholder="Cost">				
			              </div>
			              <div class="form-group col-md-3">
                              <label for="status">Status <span class="mandatory-element">*</span></label>
                              <select class="form-control" id="status" name="status">
                              </select>
                          </div>
			              <div class="form-group col-md-12 HideThisElement" id = "descriptionProduct">
			                  <label>Remarks</label>
			                  <textarea class="form-control capitalizeText" id="remarks" rows="3" name="remarks"  placeholder="Remarks"></textarea>				
			              </div>
			              <div class="form-group col-md-12" id="skuDiv">
			                 				
			              </div>
			          </div>
				      <div class="left">
					        <button type="button" class="btn btn-sm btn-primary" id="UpdateButtonBarcode">Update</button>
				        	<button type="button" class="btn btn-sm btn-primary HideThisElement" id="BackButtonBarcode">Back</button>
				      </div>
			        </form>
			    </div>
			    </div>
            </body>

            </html>