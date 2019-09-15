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
                    .container-fluid {
                    width: 100%;
                       }
                </style>

            </head>
            <body>
               <!-- <div class="card" id="productFormDiv">
			    <div class="card-body"> -->
			    	<h5 class="card-title" id = "headerName">Product Details</h5><hr id = "hrProduct">
					<form action="" id="insertProductForm" name="insertProductForm">
			        <input type="hidden" name = "rowId" id="productId">
			        <input type="hidden" name="action" id="action" >
			        <div class="form-row">
			              <!--  <div class="form-group col-md-4">
			                 <label id="brand" for="brand" class="">Brand <span class="mandatory-element">*</span></label>
			                 <input type="text" class="form-control" id="brand" name="brand"  placeholder="Brand">
			              </div> -->
			              <div class="form-group col-md-3" id="brandFrm">
			                  <label id="brandLbl" for="brand" class="">Brand <span class="mandatory-element">*</span></label><br>
			                    <select class="selectpicker" data-live-search="true" id="brand"  name="brand" style="width: 50%;">
			                    	<option value="select Brand"></option>
			  					</select>
			              </div>
			              <!-- <div class="form-group-3 HideThisElement">
			              	<select class="selectpicker" data-live-search="true">
							  <option>Mustard</option>
							  <option>Ketchup</option>
							  <option>Barbecue</option>
							</select>              
			              </div> -->
			              <div class="form-group col-md-2">
			                 <label id="modelNoLbl" for="modelNo" class="">Model No <span class="mandatory-element">*</span></label>
			                 <input type="text" class="form-control" id="modelNo" name="modelNo"  placeholder="Model No">
			              </div>
			              <div class="form-group col-md-1">
			                  <label>Color <span class="mandatory-element">*</span></label>
			                  <input type="text" class="form-control" id="color" name="color"  placeholder="Color">				
			              </div>
			              <div class="form-group col-md-1">
			                  <label>Size <span class="mandatory-element">*</span></label>
			                  <input type="text" class="form-control" id="size" name="size"  placeholder="Size" >				
			              </div>
			            <!--   <div class="form-group col-md-3">
			                  <label>HSN ID <span class="mandatory-element">*</span></label>
			                  <select class="form-control" id="hsnId" name="hsnId"></select>				
			              </div> -->
			             
			              <!-- <div class="form-group col-md-3">
			                  <label>Price <span class="mandatory-element">*</span></label>
			                  <input type="number" class="form-control" id="price" name="price"  placeholder="Price">				
			              </div>
			               <div class="form-group col-md-3">
			                  <label>MRP <span class="mandatory-element">*</span></label>
			                  <input type="number" class="form-control" id="MRP" name="MRP"  placeholder="MRP">				
			              </div> -->
			               
			               <div class="form-group col-md-2">
			                  <label>Type <span class="mandatory-element">*</span></label>
			                  <select class="form-control" id="type" name="type" ></select>				
			              </div>
			             <div class="form-group col-md-1">
			                  <label>Quantity<span class="mandatory-element">*</span></label>
			                  <input type="number" class="form-control" id="qty" name="qty"  placeholder="Quantity">				
			              </div>
			              <div class="form-group col-md-1">
			              	<button type="button" class="btn btn-primary btn-sm" style="margin-top: 42%;" id="saveProduct">Add Product</button>	
							</div>
							
							 <div class="form-group col-md-2">
			                  <label>Total qty<span class="mandatory-element">*</span></label>
			                  <span class = "label label-default" id="totalQuantity" ></span>
			                 <!--  <input type="labe" class="form-control" id="totalQuantity" placeholder="total Qty">		 -->		
			              </div>
			             <!--   <div class="form-group col-md-3">
			                  <label>Discount<span class="mandatory-element">*</span></label>
			                  <input type="number" class="form-control" id="discount" name="discount"  placeholder="Discount">				
			              </div> -->
			              <!-- <div class="form-group col-md-12" id="skuDiv">
			                 				
			              </div> -->
			          </div>
				      <!-- <div class="left">
					        <button type="button" class="btn btn-primary HideThisElement" id="GenerateSKU">Generate SKU</button>
					       	<button type="button" class="btn btn-primary " id="saveProduct">Add Product</button>		        
					        <button type="button" class="btn btn-primary HideThisElement" id="UpdateButtonProduct">Update</button>
				        	<button type="button" class="btn btn-primary " id="BackButtonProduct">Back</button>
				      </div> -->
			        </form>
			   <!--  </div>
			    </div> -->
            </body>

            </html>