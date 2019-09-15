<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Insert title here</title>
        </head>

        <body>
            <form action="">
                <div id="retrunFormDiv" class="HideThisElement">
                    <div class="card">
                        <div class="card-body">
                       	 <input type="hidden" id="returnId">
                            <jsp:include page="/WEB-INF/JSPs/Client/ClientInfo.jsp" />
							<br>
							 <p style="font-size: 120%;margin-bottom: 1%;"> Product Details</p>
							 <hr>
                            <div class="col-md-12" id="prdTblDiv">
	                           	  <div class="form-row">
	                                  <div class="form-group col-md-12">
			                                <jsp:include page="/WEB-INF/JSPs/GRN/productFormGRN.jsp" />
			                                <br>
			                                <button type="button" id="addProduct" class="btn btn-sm btn-primary">Add</button> &nbsp;
			                           </div>
			                       </div>
                            </div>
                            <div class="col-md-12" id="addProductTable">			        
					        	<table id="ProductData" class="table table-hover mb-0 nowrap">
								    <thead>
								        <tr id="headerrow" class="">
								            <th>#</th>
								            <th>Brand</th>
								            <th>Model No</th>
								            <th>Color</th>
								            <th>Size</th>
								            <th>Type</th>
								            <th>Quantity</th>
								            <th>Cost/Unit</th>
								        </tr>
								    </thead>
								    <tbody id="ProductDataBody"></tbody>
								 </table>
				        	</div>
				        	<br>
							 <div class="left" id="submitBtnDiv">
						        <button type="button" class="btn btn-sm btn-outline-primary HideThisElement" id="SubmitButtonCancel">Cancel</button>
						        <button type="button" class="btn btn-sm btn-outline-primary" id="DeleteProduct">Delete</button>
						        <button type="button" class="btn btn-sm btn-primary" id="SubmitButtonReturn">Submit</button>
						        <!-- <button type="button" class="btn btn-primary" id="BackButtonSubmit">Back</button> -->
						    </div>
                        </div>
                    </div>
                </div>
            </form>
        </body>
        </html>