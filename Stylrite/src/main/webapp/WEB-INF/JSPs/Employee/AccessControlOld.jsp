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
<section id="CheckBoxForm" class="">
    <div class="row">
        <div class="col-md-12">
           <!--  <div class="card">
                <div class="card-body">
                    <h4 class="card-title"><i class="fa fa-info mr-2" aria-hidden="true"></i> User Access Control</h4>
                    <hr> -->
                    <form action="" id="assignPermissionForm" name="assignPermissionForm">                        
                        <div id="divcontainingallval" style="padding-left: 2%;">
                            <!-- <div id="apppendDiv">
                            </div> -->
                            <div class="row" id="apppendDiv">
                                <!-- <div class="col-lg-3 col-md-12 mb-r">
                                    <div class="form-group">
                                        <input type="checkbox" id="adminDiv" value="100001" disabled>
                                        <label for="adminDiv" id="adminDivLbl" style="font-size: large;">Admin</label>
                                    </div>
                                    <div id="adminGrp" style="padding-left: 4%;">
                                        <div class="form-group">
                                            <input type="checkbox" id="employeeDiv" name="adminDiv" value="100002">
                                            <label for="employeeDiv" id="employeeDivLbl">Employee</label>
                                        </div>
                                        <div class="form-group">
                                            <input type="checkbox" id="taskDiv" name="adminDiv" value="100003">
                                            <label for="hsnidDiv">Task Management</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-12 mb-r">
                                    <div class="form-group">
                                        <input type="checkbox" id="CRMDiv" value="20001" disabled>
                                        <label for="CRMDiv" style="font-size: large;">CRM</label>
                                    </div>
                                    <div id="CRMGrp" style="padding-left: 4%;">
                                        <div class="form-group">
                                            <input type="checkbox" id="CustomerDiv" name="CRMDiv" value="20002">
                                            <label for="CustomerDiv" id="CustomerDivLbl">Client</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-12 mb-r">
                                    <div class="form-group">
                                        <input type="checkbox" id="InventoryDiv" value="300001" disabled>
                                        <label for="InventoryDiv" style="font-size: large;">Inventory</label>
                                    </div>
                                    <div id="InventoryGrp" style="padding-left: 4%;">
                                        <div class="form-group">
                                            <input type="checkbox" id="ProductsDiv" name="InventoryDiv" value="300002">
                                            <label for="ProductsDiv" id="ProductsDivLbl">Products</label>
                                        </div>
                                        <div class="form-group">
                                            <input type="checkbox" id="StockInDiv" name="InventoryDiv" value="300003">
                                            <label for="StockInDiv">Stock In</label>
                                        </div>
                                        <div class="form-group">
                                            <input type="checkbox" id="StockOutDivO" name="InventoryDiv" value="300004">
                                            <label for="StockOutDivO" id="StockOutDivOLbl">Stock Out (Order)</label>
                                        </div>
                                        <div class="form-group">
                                            <input type="checkbox" id="StockOutDivS" name="InventoryDiv" value="300005">
                                            <label for="StockOutDivS">Stock Out (Sample)</label>
                                        </div>
                                        <div class="form-group">
                                            <input type="checkbox" id="StockTransferDiv" name="InventoryDiv" value="300006">
                                            <label for="StockTransferDiv">Stock Transfer</label>
                                        </div>
                                        
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-12 mb-r">
                                    <div class="form-group">
                                        <input type="checkbox" id="StockListDiv" value="400001" disabled>
                                        <label for="QuotationDiv" style="font-size: large;">Stock List</label>
                                    </div>
                                    <div id="QuotationGrp" style="padding-left: 4%;">
                                        <div class="form-group">
                                            <input type="checkbox" id="AvailableStockDiv" name="StockListDiv" value="400002">
                                            <label for="AvailableStockDiv" id="AvailableStockDivLbl">Available Stock</label>
                                        </div>
                                        <div class="form-group">
                                            <input type="checkbox" id="BrandAvailableStockDiv" name="StockListDiv" value="400003">
                                            <label for="BrandAvailableStockDiv" id="BrandAvailableStockDivLbl">Brand wise Stock</label>
                                        </div>
                                        <div class="form-group">
                                            <input type="checkbox" id="LocationAvailableStockDiv" name="StockListDiv" value="400004">
                                            <label for="LocationAvailableStockDiv" id="LocationAvailableStockDivLbl">Location wise Stock</label>
                                        </div>
                                        <div class="form-group">
                                            <input type="checkbox" id="SPStockListDiv" name="StockListDiv" value="400005">
                                            <label for="SPStockListDiv" id="SPStockListDivLbl">Sales Person wise Stock</label>
                                        </div>
                                        <div class="form-group">
                                            <input type="checkbox" id="AllSampleListDiv" name="StockListDiv" value="400006">
                                            <label for="AllSampleListDiv" id="AllSampleListDivLbl">All Sample</label>
                                        </div>
                                        <div class="form-group">
                                            <input type="checkbox" id="MySampleListDiv" name="StockListDiv" value="400007">
                                            <label for="MySampleListDiv" id="MySampleListDivLbl">My Sample</label>
                                        </div>
                                        <div class="form-group">
                                            <input type="checkbox" id="StockMovementDiv" name="StockListDiv" value="400008">
                                            <label for="StockMovementDiv" id="StockMovementDivLbl">Brand wise Stock Movement</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-12 mb-r">
                                    <div class="form-group">
                                        <input type="checkbox" id="GRNDiv" value="500001" disabled>
                                        <label for="QuotationDiv" style="font-size: large;">GRN</label>
                                    </div>
                                    <div id="QuotationGrp" style="padding-left: 4%;">
                                        <div class="form-group">
                                            <input type="checkbox" id="QuotationNDiv" name="QuotationDiv" value="500002">
                                            <label for="QuotationNDiv" id="QuotationNDivLbl">Create GRN</label>
                                        </div>
                                        <div class="form-group">
                                            <input type="checkbox" id="QuotationNCDiv" name="QuotationDiv" value="500003">
                                            <label for="QuotationNCDiv" id="QuotationNCDivLbl">Generate Barcode</label>
                                        </div>
                                        <div class="form-group">
                                            <input type="checkbox" id="QuotationNDiv" name="QuotationDiv" value="500004">
                                            <label for="QuotationNDiv" id="QuotationNDivLbl">GRN List</label>
                                        </div>
                                        <div class="form-group">
                                            <input type="checkbox" id="QuotationNCDiv" name="QuotationDiv" value="500005">
                                            <label for="QuotationNCDiv" id="QuotationNCDivLbl">Assign Location</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-12 mb-r">
                                    <div class="form-group">
                                        <input type="checkbox" id="QuotationDiv" value="600001" disabled>
                                        <label for="QuotationDiv" style="font-size: large;">Barcode</label>
                                    </div>
                                    <div id="QuotationGrp" style="padding-left: 4%;">
                                        <div class="form-group">
                                            <input type="checkbox" id="QuotationNDiv" name="QuotationDiv" value="600002">
                                            <label for="QuotationNDiv" id="QuotationNDivLbl">Barcode List</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-12 mb-r">
                                    <div class="form-group">
                                        <input type="checkbox" id="QuotationDiv" value="700001" disabled>
                                        <label for="QuotationDiv" style="font-size: large;">Samples</label>
                                    </div>
                                    <div id="QuotationGrp" style="padding-left: 4%;">
                                        <div class="form-group">
                                            <input type="checkbox" id="QuotationNDiv" name="QuotationDiv" value="700002">
                                            <label for="QuotationNDiv" id="QuotationNDivLbl">New Requisition</label>
                                        </div>
                                    </div>
                                    <div id="QuotationGrp" style="padding-left: 4%;">
                                        <div class="form-group">
                                            <input type="checkbox" id="QuotationNDiv" name="QuotationDiv" value="700003">
                                            <label for="QuotationNDiv" id="QuotationNDivLbl">Ready to dispatch</label>
                                        </div>
                                    </div>
                                    <div id="QuotationGrp" style="padding-left: 4%;">
                                        <div class="form-group">
                                            <input type="checkbox" id="QuotationNDiv" name="QuotationDiv" value="700004">
                                            <label for="QuotationNDiv" id="QuotationNDivLbl">Dispatched</label>
                                        </div>
                                    </div>
                                    <div id="QuotationGrp" style="padding-left: 4%;">
                                        <div class="form-group">
                                            <input type="checkbox" id="QuotationNDiv" name="QuotationDiv" value="700005">
                                            <label for="QuotationNDiv" id="QuotationNDivLbl">Dispatched/ Confirm Receipt</label>
                                        </div>
                                    </div>
                                    <div id="QuotationGrp" style="padding-left: 4%;">
                                        <div class="form-group">
                                            <input type="checkbox" id="QuotationNDiv" name="QuotationDiv" value="700006">
                                            <label for="QuotationNDiv" id="QuotationNDivLbl">Requisition List</label>
                                        </div>
                                    </div>
                                    <div id="QuotationGrp" style="padding-left: 4%;">
                                        <div class="form-group">
                                            <input type="checkbox" id="QuotationNDiv" name="QuotationDiv" value="700007">
                                            <label for="QuotationNDiv" id="QuotationNDivLbl">Sample Transfer</label>
                                        </div>
                                    </div>
                                    <div id="QuotationGrp" style="padding-left: 4%;">
                                        <div class="form-group">
                                            <input type="checkbox" id="QuotationNDiv" name="QuotationDiv" value="700008">
                                            <label for="QuotationNDiv" id="QuotationNDivLbl">Sample Return</label>
                                        </div>
                                    </div>
                                </div>
                                 <div class="col-lg-3 col-md-12 mb-r">
                                    <div class="form-group">
                                        <input type="checkbox" id="QuotationDiv" value="800001" disabled>
                                        <label for="QuotationDiv" style="font-size: large;">Order</label>
                                    </div>
                                    <div id="QuotationGrp" style="padding-left: 4%;">
                                        <div class="form-group">
                                            <input type="checkbox" id="QuotationNDiv" name="QuotationDiv" value="700002">
                                            <label for="QuotationNDiv" id="QuotationNDivLbl">New Order</label>
                                        </div>
                                    </div>
                                    <div id="QuotationGrp" style="padding-left: 4%;">
                                        <div class="form-group">
                                            <input type="checkbox" id="QuotationNDiv" name="QuotationDiv" value="700003">
                                            <label for="QuotationNDiv" id="QuotationNDivLbl">In Process Order</label>
                                        </div>
                                    </div>
                                    <div id="QuotationGrp" style="padding-left: 4%;">
                                        <div class="form-group">
                                            <input type="checkbox" id="QuotationNDiv" name="QuotationDiv" value="700004">
                                            <label for="QuotationNDiv" id="QuotationNDivLbl">Pending Order</label>
                                        </div>
                                    </div>
                                    <div id="QuotationGrp" style="padding-left: 4%;">
                                        <div class="form-group">
                                            <input type="checkbox" id="QuotationNDiv" name="QuotationDiv" value="700005">
                                            <label for="QuotationNDiv" id="QuotationNDivLbl">Completed Order</label>
                                        </div>
                                    </div>
                                </div> -->
                               
                            </div>                                                    
                            <!-- <div class="row">
                                <div class="text-center mt-1-half">
                                    <button id="Submit" class="btn btn-info mb-1">Submit</button>
                                    <button class="btn btn-outline-info waves-effect" data-dismiss="modal">Close</button>
                                </div>
                            </div> -->
                        </div>
                    </form>
                <!-- </div>
            </div> -->
        </div>
    </div>
</section>
</body>
</html>