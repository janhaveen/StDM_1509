<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>

    <body>
        <div class="card HideThisElement" id="returnItemListViewDiv">
            <div class="card-body">
                <div class="alert alert-success alert-dismissible fade show HideThisElement successMsg" role="alert">
                    <p id="successMsg"></p>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="alert alert-danger alert-dismissible fade show HideThisElement errorMsg" role="alert">
                    <p id="errorMsg"></p>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <h5 class="card-title">Return Details</h5></div>
                    <div class="col-md-6 ">
                    </div>
                </div>
                <hr>
                <dl class="row">
                    <dt class="col-sm-2">Return ID</dt>
                    <dd class="col-sm-2" id="ReturnOrderIDText">-</dd>
                    <dt class="col-sm-2">Return Date</dt>
                    <dd class="col-sm-2" id="ReturnOrderDateText">-</dd>
                    <dt class="col-sm-2">Return Status</dt>
                    <dd class="col-sm-2" id="ReturnStatusText">-</dd>
                    <dt class="col-sm-2">Client Name</dt>
                    <dd class="col-sm-2" id="ClientnameText">-</dd>
                    <dt class="col-sm-2">Client Contact Person</dt>
                    <dd class="col-sm-2" id="ClientCpText">-</dd>
                    <dt class="col-sm-2">Contact Number</dt>
                    <dd class="col-sm-2" id="ContactNumberText">-</dd>
                    <dt class="col-sm-2">Client Address</dt>
                    <dd class="col-sm-6" id="clientAddressText">-</dd>
                    <dt class="col-sm-2">Sales Person</dt>
                    <dd class="col-sm-2" id="SalesPersonText">-</dd>
                </dl>

                <hr>

                <div class="row">
                    <div class="col-md-6">
                        <h5 class="card-title">Return Item Details</h5></div>
                    <div class="col-md-6 ">
                    </div>
                </div>
                <hr>
                <dl class="row">
                    <dt class="col-sm-2">Return Item ID</dt>
                    <dd class="col-sm-2" id="ReturnItemIDText">-</dd>
                    <dt class="col-sm-2">Return ID</dt>
                    <dd class="col-sm-2" id="ReturnIDText">-</dd>
                    <dt class="col-sm-2">Product Id</dt>
                    <dd class="col-sm-2" id="productIdText">-</dd>
                    <dt class="col-sm-2">Sku Id</dt>
                    <dd class="col-sm-2" id="skuIdText">-</dd>
                    <dt class="col-sm-2">Product Name</dt>
                    <dd class="col-sm-2" id="productNameText">-</dd>
                    <dt class="col-sm-2 HideThisElement">IsDamaged</dt>
                    <dd class="col-sm-2 HideThisElement" id="isDamagedText">-</dd>
                    <dt class="col-sm-2 HideThisElement">BarCode</dt>
                    <dd class="col-sm-2 HideThisElement" id="barcodeText">-</dd>
                    <dt class="col-sm-2">Quantity</dt>
                    <dd class="col-sm-2" id="quantityText">-</dd>
                </dl>
                <!--  <hr> -->
                <div class="card HideThisElement">
                    <div class="card-body">
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active show" id="Status-tab" data-toggle="tab" href="#qC" role="tab" aria-controls="Status" aria-selected="false">QC</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="Status-tab" data-toggle="tab" href="#Status" role="tab" aria-controls="Status" aria-selected="false">Update Status</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link HideThisElement" id="Remarks-tab" data-toggle="tab" href="#Remarks" role="tab" aria-controls="Remarks" aria-selected="true">Remarks</a>
                            </li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade active show" id="qC" role="tabpanel" aria-labelledby="qC-tab">
                                <div class="form-row">
                                    <div class="form-group col-md-4">
                                        <label for="qCStatus">QC Status <span class="mandatory-element">*</span></label>
                                        <select class="form-control" id="qCStatus" name="qCStatus">
                                            <option value=""  selected>Select QC Status</option>
                                            <option value="101"> QC Passed</option>
                                            <option value="104"> QC Failed</option>
                                            <!-- <option value="107"> Lost</option> -->
                                        </select>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <label id="qCLbl" for="qCremarks" class="">Remarks</label>
                                        <textarea type="text" rows="4" class="md-textarea  form-control" id="qCremarks" name="qCremarks" style="height: 4rem;overflow-y: auto;"></textarea>
                                        <br>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <button type="button" id="submitQcStatus" class="btn btn-primary">Submit</button>
                                        <!-- <button type="button" id="cancelUpdateStatus" class="btn btn-outline-primary">Cancel</button> -->
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="Status" role="tabpanel" aria-labelledby="Status-tab">
                                <form id="updateStatus" name="updateStatus">
                                    <div class="form-row">
                                        <div class="form-group col-md-12">
                                            <label id="statusLbl" for="refNo" class="">Ref No</label>
                                            <input type="text" class="form-control" name="refNo" id="refNo">
                                        </div>
                                        <br>
                                        <div class="form-group col-md-12">
                                            <label id="updateStatusremarksLbl" for="updateStatusremarks" class="">Remarks</label>
                                            <textarea type="text" rows="4" class="md-textarea  form-control" id="updateStatusremarks" name="updateStatusremarks" style="height: 4rem;overflow-y: auto;"></textarea>
                                            <br>
                                        </div>
                                        <br>
                                        <div class="col-md-6">
                                            <label for="vendorStatus">Vendor Status <span class="mandatory-element">*</span></label>
                                            <select class="form-control" id="vendorStatus" name="vendorStatus">
                                            </select>
                                        </div>
                                        <br>
                                        <div class="col-md-6">
                                            <label for="customerStatus">Customer Status <span class="mandatory-element">*</span></label>
                                            <select class="form-control" id="customerStatus" name="customerStatus" onchange="changeCustomerFunction(this.value);">
                                            </select>
                                        </div>
                                        <br>
                                    </div>
                                    <div class="credit HideThisElement" id="creditNoteDetails">
                                        <hr>
                                        <div class="card">
                                            <div class="card-body">
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <h5 class="card-title">Credit Note Details </h5></div>
                                                </div>
                                                <input type="hidden" name="actionCreditNoteStatus" id="actionCreditNoteStatus" value="updateCreditNoteStatus">
                                                <hr>
                                                <div class="form-row">
                                                    <div class="form-group col-md-6">
                                                        <label id="cnIdLbl" for="cnId" class="">CN Id <span class="mandatory-element">*</span></label>
                                                        <input type="text" class="form-control" id="cnId" name="cnId" placeholder="CN Id">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <input type="hidden" id="DispatchId">
                                                        <label id="cndateLbl" for="cndate" class="">CN Date <span class="mandatory-element">*</span></label>
                                                        <input type="text" class="form-control datepicker" id="cndate" name="cndate" placeholder="CN Date">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label id="cnAmountLbl" for="cnAmount" class="">CN Amount <span class="mandatory-element">*</span></label>
                                                        <input type="text" class="form-control" id="cnAmount" name="cnAmount" placeholder="CN Amount">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label id="accountantLbl" for="accountant" class="">Accountant <span class="mandatory-element">*</span></label>
                                                        <input type="text" class="form-control" id="accountant" name="accountant" placeholder="Accountant">
                                                    </div>
                                                    <div class="form-group col-md-12">
                                                        <label id="cnRemarksLbl" for="cnRemarks" class="">Remarks</label>
                                                        <textarea type="text" rows="4" class="md-textarea  form-control" id="cnRemarks" name="cnRemarks" style="height: 4rem;overflow-y: auto;"></textarea>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <hr>
                                    </div>
                                    <div class="dispatch HideThisElement" id="dispatchDetails">
                                        <hr>
                                        <div class="card">
                                            <div class="card-body">
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <h5 class="card-title">Dispatch Details </h5></div>
                                                </div>
                                                <input type="hidden" name="actionDispatchStatus" id="actionDispatchStatus" value="updateDispatchStatus">
                                                <hr>
                                                <div class="form-row">
                                                    <div class="form-group col-md-6">
                                                        <input type="hidden" id="DispatchId">
                                                        <label id="firstNameLbl" for="firstName" class="">Dispatch Date <span class="mandatory-element">*</span></label>
                                                        <input type="text" class="form-control datepicker" id="dispatchDate" name="dispatchDate" placeholder="Dispatch Date">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label id="lastNameLbl" for="lastName" class="">LR No <span class="mandatory-element">*</span></label>
                                                        <input type="text" class="form-control" id="LRNO" name="LRNO" placeholder="LR No">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label id="lastNameLbl" for="lastName" class="">Courier Name <span class="mandatory-element">*</span></label>
                                                        <input type="text" class="form-control" id="CourierName" name="CourierName" placeholder="Courier Name">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label id="dispatchByLbl" for="charges" class="">Dispatch By <span class="mandatory-element">*</span></label>
                                                        <input type="text" class="form-control" id="dispatchBy" name="dispatchBy" placeholder="Dispatch By">
                                                    </div>
                                                    <div class="form-group col-md-12">
                                                        <label id="dispatchRemarksLbl" for="dispatchRemarks" class="">Remarks</label>
                                                        <textarea type="text" rows="4" class="md-textarea  form-control" id="dispatchRemarks" name="dispatchRemarks" style="height: 4rem;overflow-y: auto;"></textarea>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <hr>
                                    </div>
                                    <br>
                                    <div class="form-group col-md-12">
                                        <button type="button" id="submitUpdateStatus" class="btn btn-primary">Submit</button>
                                        <!-- <button type="button" id="cancelUpdateStatus" class="btn btn-outline-primary">Cancel</button> -->
                                    </div>
                                </form>
                            </div>
                            <div class="tab-pane fade" id="Remarks" role="tabpanel" aria-labelledby="Remarks-tab">
                                <div class="form-group">
                                    <div id="remarkDiv">
                                        <label id="remarksLbl" for="remarks" class="">Remarks</label>
                                        <textarea type="text" rows="4" class="md-textarea  form-control" id="newremarks" name="remarks" style="height: 4rem;overflow-y: auto;"></textarea>
                                        <br>
                                        <input type="button" id="SubmitButtonRegisterRemarks" value="Save" class="btn btn-info btn-rounded">
                                    </div>
                                    <div id="remarksDiv"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <br>
                <button type="button" class="btn btn-primary " id="SubmitButtonBackFromView">Back</button>
            </div>
        </div>
    </body>
   </html>