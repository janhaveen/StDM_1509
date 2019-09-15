$(document).ready(function() {
	spinnerOn();
	var table = $('#datatables').DataTable({
        buttons: [
            /*{
                text: 'New Client',
                action: function ( e, dt, node, config ) {
                	loadBlankform();
                }
            }*/
        ],dom: 'Bfrtip',
		"bLengthChange": true,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "GetRequisitionListDatatable?list=invoiceAndDispatch&type="+$("#t").val(),
		"columns": [
        	 {
             	className: "center",
                 defaultContent: "<i class='fa fa-check select_me' ></i>"
             },
            { "data": "requisitionId" },
            { "data": "requisitionCreatedOn" },
            { "data": "orderid" },
            { "data": "orderCreatedOn" },
            { "data": "companyName" },
            { "data": "spname" },
            { "data": "count" },
            { "data": "invoiceid" },
            { "data": "invoicedate" }
        ],
        columnDefs: [
            { width: '25pc', targets: 1 },
            { width: '30pc', targets: 2 }
        ],
        fixedColumns: true,
        "initComplete": function(settings, json) {     
            spinnerOff();
        }
    });
	

	$('#datatables tbody').on('click', '.select_me', function() {
		var data = table.row($(this).parents('tr')).data();	   
	    getRequisitionDataForView(data.requisitionId);
	});
	
	$(".editDispatch").click(function() {
		$(".editDispatch").addClass("HideThisElement");
		$("#dispatchView").addClass("HideThisElement");
		$("#formForDispatch").removeClass("HideThisElement");
	});
	$(".editInvoice").click(function() {
		$(".editInvoice").addClass("HideThisElement");
		$("#invoiceView").addClass("HideThisElement");
		$("#formForInvoice").removeClass("HideThisElement");
	});
	
	$("#cancelDispatch").click(function() {
		$(".editDispatch").removeClass("HideThisElement");
		$("#dispatchView").removeClass("HideThisElement");
		$("#formForDispatch").addClass("HideThisElement");
	});
	
	$("#cancelInvoice").click(function() {
		$(".editInvoice").removeClass("HideThisElement");
		$("#invoiceView").removeClass("HideThisElement");
		$("#formForInvoice").addClass("HideThisElement");
	});
		
	$("#SubmitButtonBackFromView").click(function() {
		$("#RequisitionTableDiv").removeClass("HideThisElement");
		$("#RequisitionViewDiv").addClass("HideThisElement");
		$("#RequisitionFormDiv").addClass("HideThisElement");
	});
	
	$("#submitDispatch").click(function() {
		formSubmitDispatch();
	});
	
	$("#submitInvoice").click(function() {
		formSubmitInvoice();
	});
});


function getRequisitionDataForView(RequisitionId) {
	$('#ProductDataBody1').html("");
	$('dd').text('-');
	document.getElementById("formForDispatch").reset();	
	document.getElementById("formForInvoice").reset();	
	$("#invoiceView").removeClass("HideThisElement");
	$("#formForInvoice").addClass("HideThisElement");
	$(".editInvoice").removeClass("HideThisElement");
	$("#dispatchView").removeClass("HideThisElement");
	$("#formForDispatch").addClass("HideThisElement");
	$(".editDispatch").removeClass("HideThisElement");
	spinnerOn();
	$.ajax({
		url:"GetRequisitionDetails?1=1&requisitionId="+RequisitionId,
		type:"GET",
		success:function(data){		
			$("#RequisitionIDText").text(data.data[0].requisitionId);
			$("#ClientnameText").text(data.data[0].companyName);
			$("#ClientCpText").text(data.data[0].cpname);
			$("#RequisitionStatusText").text(data.data[0].rqtnStatus_text);
			$("#RequisitionDateText").text(data.data[0].RequisitionCreatedOn);
			$("#BillingAddressText").html(data.data[0].ca11+", "+data.data[0].ca12+", "+data.data[0].bbranchName+", "+data.data[0].blocationadd+", "+data.data[0].bstate_text+", "+data.data[0].bpincode);
			$("#DeliveryAddressText").html(data.data[0].ca21+", "+data.data[0].ca22+", "+data.data[0].dbranchName+", "+data.data[0].dlocationadd+", "+data.data[0].dstate_text+", "+data.data[0].dpincode);
			$("#SalesPersonText").text(data.data[0].spname);
			if(data.data[0].contactNo!=0) $("#ContactNumberText").text(data.data[0].contactNo); 
			$("#InvoiceTypeText").text(data.data[0].invoicetype_txt);
			$("#ModeOfPaymentText").text(data.data[0].modeofpay_txt);
			$("#ExpDDText").text(data.data[0].expectedDeilvery);
			$("#OrderDateText").text(data.data[0].orderCreatedOn);
			$("#OrderIDText").text(data.data[0].orderId);
			$("#stockOutId").val(data.data[0].referenceid);
			$("#ReqCreatedByText").text(data.data[0].EmpName);
			$("#GSTText").text(data.data[0].bGst);
			getDispatchDetails(); getInvoiceDetails();

			var totalamt=0, totalDisc=0, totalTax=0;
			for (var i = 0; i < data.data.length; i++) {
				var discount=0, amount=0, tax=0;
				amount=parseInt(data.data[i].rate)*parseInt(data.data[i].stockoutQty);
				discount=parseInt(data.data[i].discount)*amount*0.01;
				tax=parseInt(data.data[i].igst)*(amount-discount)*0.01;
				var html="<tr>"
						+"<td>"+data.data[i].i+"</td>"
						+"<td>"+data.data[i].skuid+"</td>"
						+"<td>"+data.data[i].productInfo+"</td>"
						+"<td>"+data.data[i].rqtnItmstatus_text+"</td>"
						+"<td>"+data.data[i].stockoutQty+"</td>"
						+"<td>"+data.data[i].rate+"</td>"
						+"<td>"+data.data[i].igst+"%</td>"
						+"<td class='center'>"+data.data[i].discount+"%</td>"
						/*+"<td>"+(amount+tax).toFixed(2)+"</td>"*/
						"<tr>";
				document.querySelector('#ProductDataBody1').insertAdjacentHTML('beforeend', html);
				totalamt+=parseInt(amount); //console.log(parseInt(data.data[i].rate),parseInt(data.data[i].quantity));
				totalDisc+=discount;
				totalTax+=tax;
			}
			var str="<tr class='right'>" +
					"<td colspan='7'> Total Amount</td>"+
                    "<td>"+totalamt.toFixed(2)+"</td>"+
					"</tr>"+
					"<tr class='right'>" +
					"<td colspan='7'> Discount</td>"+
                    "<td>"+totalDisc.toFixed(2)+"</td>"+
					"</tr>"+
                    "<tr class='right'>" +
					"<td colspan='7'> Net Amount</td>"+
                    "<td>"+(totalamt-totalDisc).toFixed(2)+"</td>"+
					"</tr>"+
					"<tr class='right'>" +
					"<td colspan='7'> Tax Amount</td>"+
                    "<td>"+totalTax.toFixed(2)+"</td>"+
					"</tr>"+
					"<tr class='right'>" +
					"<td colspan='7'> Amount Payable</td>"+
                    "<td>"+(totalamt-totalDisc+totalTax).toFixed(2)+"</td>"+
					"</tr>";
			document.querySelector('#ProductDataBody1').insertAdjacentHTML('beforeend', str);				
			spinnerOff();
		}
	});
	
    $("#RequisitionTableDiv").addClass("HideThisElement");
	$("#RequisitionViewDiv").removeClass("HideThisElement");
	$("#RequisitionFormDiv").addClass("HideThisElement");
}

function formSubmitInvoice() {
	var action="";
	if($("#InvoiceNoText").text()=="-"){
		action="&action=insert";
	}else
		action="&action=update";
	$.ajax({
		url:"../../../SaveInvoice",
		data:$("#formForInvoice").serialize()+action+"&stockOutid="+$("#stockOutId").val()+"&RequisitionId="+$("#RequisitionIDText").text(),
		type:"POST",
		success:function(data){
			SwalSuccessHeader("Invoice updated successfully !");
			$("#invoiceView").removeClass("HideThisElement");
			$("#formForInvoice").addClass("HideThisElement");
			$(".editInvoice").removeClass("HideThisElement");
			getInvoiceDetails();
		}
	});
}

function formSubmitDispatch() {
	var action="";
	if($("#DispatchDateText").text()=="-"){
		action="&action=insert";
		var generator = new IDGenerator();
		$("#DispatchId").val("D"+generator.generate());
	}else
		action="&action=update";
	$.ajax({
		url:"../../../SaveDispatch",
		data:$("#formForDispatch").serialize()+"&DispatchId="+$("#DispatchId").val()+action+"&stockOutid="+$("#stockOutId").val()+"&RequisitionId="+$("#RequisitionIDText").text(),
		type:"POST",
		success:function(data){
			SwalSuccessHeader("Dispatch Details updated successfully !");
			$("#dispatchView").removeClass("HideThisElement");
			$("#formForDispatch").addClass("HideThisElement");
			$(".editDispatch").removeClass("HideThisElement");
			getDispatchDetails();
		}
	});
}

function getInvoiceDetails() {
	$.ajax({
		url:"../../../GetInvoiceDetails",
		data:{"requisitionId":$("#RequisitionIDText").text()},
		type:"GET",
		success:function(data){
			if(data.data.length>0){
				$("#InvoiceNoText").text(data.data[0].rowId);
				$("#InvoiceNo").val(data.data[0].rowId);
				$("#InvoiceDateText").text(data.data[0].invoicedate);
				$("#InvoiceDate").val(data.data[0].invoicedate);
				$("#InvoiceAmountText").text(data.data[0].invoiceAmt);
				$("#InvoiceAmt").val(data.data[0].invoiceAmt);
				$("#TaxAmountText").text(data.data[0].taxamt);
				$("#TaxAmount").val(data.data[0].taxamt);	
				$("#AccountantText").text(data.data[0].accountant);
				$("#Accountant").val(data.data[0].accountant);
				$("#IRemarksText").text(data.data[0].remarks);
				$("#IRemarks").val(data.data[0].remarks);
			}
		}
	});
}


function getDispatchDetails() {
	$.ajax({
		url:"../../../GetDispatchDetails",
		data:{"requisitionId":$("#RequisitionIDText").text()},
		type:"GET",
		success:function(data){
			if(data.data.length>0){
				//$("#InvoiceNoText").text(data.data[0].rowId);
				$("#DispatchId").val(data.data[0].rowId);
				$("#DispatchDateText").text(data.data[0].dispatchDate);
				$("#dispatchDate").val(data.data[0].dispatchDate);
				$("#LRNoText").text(data.data[0].LrNo);
				$("#LRNO").val(data.data[0].LrNo);
				$("#CourierNameText").text(data.data[0].courierName);
				$("#CourierName").val(data.data[0].courierName);
				$("#ChargesText").text(data.data[0].charges);
				$("#Charges").val(data.data[0].charges);
				$("#DispatchedByText").text(data.data[0].dispatchedby);
				$("#DispatchedBy").val(data.data[0].dispatchedby);
				$("#DRemarks").val(data.data[0].remarks);
				$("#DRemarksText").text(data.data[0].remarks);
			}
		}
	});
}