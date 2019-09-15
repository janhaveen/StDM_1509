$(document).ready(function()
{
	spinnerOn();
	$('#datatablesReturnItem').DataTable().destroy();
	
	$('#datatablesReturnItem thead #filterrow th').each( function () {
	    	var title = $(this).text();
	        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
	    });
		
	    $("#datatablesReturnItem thead input").on('keyup change', function () {
	        table.column($(this).parent().index() + ':visible')
	            .search(this.value)
	            .draw();
	    });
	    
	    var actionStr = "";
	    if(window.location.href.indexOf("JSPs/Return.jsp") < 0)
	    {
	    	actionStr = '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> ';
	    }
	    else
	    {
	    	actionStr = '<i class="edit_me fa fa-pencil-alt fa-2x HideThisElement" aria-hidden="true"></i>'+
	    	'<i class="select_me_order1 fa fa-eye fa-2x" aria-hidden="true"></i> '+
	        '<i class="delete_me fa fa-trash fa-2x HideThisElement" aria-hidden="true"></i>';
	    }
	    
	    var str="?1=1&list=y";
	  
	    $("#HomeText").text("Return");
	    
		var table = $('#datatablesReturnItem').DataTable( {
			//dom: 'Bfrtip',
	        buttons: [
	            {
	                /*//text: 'New Return',
	                action: function ( e, dt, node, config ) {
	                	loadBlankformForOrder();
	                }*/
	            }
	        ],
			"bLengthChange": true,
			"searching": true,
			"orderCellsTop": true ,
			"sScrollX": "100%",
	        "sScrollXInner": "100%",
	        "bScrollCollapse": true,
			"ajax": "getReturnItemList",
			"columns": [
	        	 {
	             	className: "center",
	                 defaultContent: actionStr
	             },
	            //{ "data": "i" },
	           // { "data": "orderdate" },
	            { "data": "returndate" },
	            { "data": "rowId" },
	            { "data": "brand_text" },
	            { "data": "skuId" },
	            { "data": "productInfo" },
	            { "data": "cpname" },
	            { "data": "salesPersonText" }
	            
	        ],
	        /*columnDefs: [
	            { width: '25pc', targets: 1 },
	            { width: '30pc', targets: 2 }
	        ],*/
	        "fnRowCallback": function( nRow, aData, iDisplayIndex ) {
	            if ( aData['isEditable'] == "0" ){
	                //console.log($($($(nRow).children()[0]).children()[0]).addClass("HideThisElement"));
	            }
	            spinnerOff();
	        },
	        fixedColumns: true,
	        "initComplete": function(settings, json) {     
	           spinnerOff();
	        }
	    });
	
    $('#datatablesReturnItem tbody').off('click');
    
    $('#datatablesReturnItem tbody').on('click', '.select_me', function() 
    {
    	var data = table.row( $(this).parents('tr') ).data();
    	
    	console.log(data);
    	
    	//getReturnItemDataForView(data.rowId);
    	
    	 $("#returnItemListTableDiv").addClass("HideThisElement");
    	 $("#returnItemListViewDiv").removeClass("HideThisElement");
    	
    	$("#ReturnOrderIDText").text(data.returnId);
		$("#ClientnameText").text(data.companyName);
		$("#ClientCpText").text(data.cpname);
		$("#ReturnStatusText").text(data.returnItemstatus_txt);
		$("#ReturnOrderDateText").text(data.returndate);
		$("#clientAddressText").html(data.clientAddress1+" "+data.clientAddress2+", "+data.bstate_text+", "+data.bpincode);
		$("#SalesPersonText").text(data.salesPersonText);
		if(data.contactNo!=0) 
		
		$("#ContactNumberText").text(data.contactNo); 
		
		$("#ReturnItemIDText").text(data.rowId);
		$("#ReturnIDText").text(data.returnId);
		$("#productIdText").text(data.productId);
		$("#skuIdText").text(data.sku);
		$("#productNameText").text(data.productInfo);
		$("#quantityText").text(data.quantity);
		$("#isDamagedText").text(data.isDamaged);
		//$("#barcodeText").text(data.data[0].barcode);
    	
    	
    	//window.location.href="ViewReturnOrder.jsp?t="+$("#type").val()+"&rid="+data.returnId;
    });
    /*
    $('#datatablesReturnItem tbody').on( 'click', '.delete_me', function () {
    	var data = table.row( $(this).parents('tr') ).data();
    	document.querySelector('#DeleteOrderId').value = data.returnId;
    	$('#centralModalDangerDemo').modal('show');
    });
    
    $('#datatablesReturnItem tbody').on('click', '.edit_me', function() {
		var data = table.row($(this).parents('tr')).data();	 
	    editOrderData(data);
	});
    
	$('#datatablesReturnItem tbody').on('click', '.select_me_order1', function() {
		var data = table.row($(this).parents('tr')).data();	  
		console.log("ppp..........."+data.returnId);
	    getReturnOrderDataForView(data.returnId);
	});*/
    
	$("#SubmitButtonBackFromView").click(function() {
	    //document.getElementById("clientInfoForm").reset();		
	    $("#clientBillingAddress").html("");
	    $("#clientDeliveryAddress").html("");
	    $("#ProductDataBody").html("");
		$("#returnItemListTableDiv").removeClass("HideThisElement");
		$("#returnItemListViewDiv").addClass("HideThisElement");
		//$("#retrunFormDiv").addClass("HideThisElement");
		$("#SubmitButtonRegister").removeClass("HideThisElement");
		$("#SubmitButtonUpdate").addClass("HideThisElement");
	});
	
	DropDownForReturnStatus();
	
	$("#submitUpdateStatus").click(function() 
	{
		if(validate())
		saveReturnItemStatus();
	});
	
	$("#refNo").click(function() {
    	if($("#refNo").val().length>=14){ 
			if($("#refNo").val()>14){ 
				SwalErrorHeader("Invalid Barcode !");
			}else{//console.log("ie23");
				$.ajax({
					url:"../../../GetChildBarcodeList?cbId="+$("#refNo").val()+"&listForBarcode=y&noOut=y",
					type:"GET",
					async:false,
					success:function(data){
						if(data.data.length==0){
							SwalErrorHeader("Barcode Not Found !");
						}else{
							SwalSuccessHeader("Barcode Scanned !");	
						}
					}
				});
			}
    	}
	});
	
});

function validate() 
{
	if($("#refNo").val()=="")
	{
		SwalWarningHeader("Select Ref No!");
		return false;
	}
	else if($("#vendorStatus").val()=="")
	{
		SwalWarningHeader("Select Vendor Status!");
		return false;
	}
	else if($("#customerStatus").val()=="")
	{
		SwalWarningHeader("Select Customer Status!");
		return false;
	}
	else 
		return true;
}

function validateQCStatus() 
{
	if($("#qCStatus").val()=="")
	{
		SwalWarningHeader("Select Status!");
		return false;
	}
	else 
		return true;
}

function getReturnItemDataForView(rowId) 
{
	$('dd').text('-');
	spinnerOn();
	$.ajax({
		url:"../../../GetReturnItemOrderList?1=1&rowId="+rowId,
		type:"GET",
		success:function(data)
		{
			//console.log(data);
			spinnerOff();
			
			document.getElementById("updateStatus").reset();
			
			$("#ReturnOrderIDText").text(data.data[0].returnId);
			$("#ClientnameText").text(data.data[0].companyName);
			$("#ClientCpText").text(data.data[0].cpname);
			$("#ReturnStatusText").text(data.data[0].returnItemstatus_txt);
			$("#ReturnOrderDateText").text(data.data[0].returndate);
			$("#clientAddressText").html(data.data[0].clientAddress1+" "+data.data[0].clientAddress2+", "+data.data[0].bstate_text+", "+data.data[0].bpincode);
			$("#SalesPersonText").text(data.data[0].salespersonText);
			if(data.data[0].contactNo!=0) $("#ContactNumberText").text(data.data[0].contactNo); 
			
			$("#ReturnItemIDText").text(data.data[0].rowId);
			$("#ReturnIDText").text(data.data[0].returnId);
			$("#productIdText").text(data.data[0].productId);
			$("#productNameText").text(data.data[0].productName);
			$("#quantityText").text(data.data[0].quantity);
			$("#isDamagedText").text(data.data[0].isDamaged);
			$("#barcodeText").text(data.data[0].barcode);
			
			//getRemarksHistory(data.returnId, 0, 1);
			
			//saveCustomerStatus(data.data[0].rowId);
			
		}
			
	});
    $("#returnItemListTableDiv").addClass("HideThisElement");
	$("#returnItemListViewDiv").removeClass("HideThisElement");
	//$("#retrunFormDiv").addClass("HideThisElement");
}

function loadBlankformForOrder() 
{
	$("#HomeText").text("New Order");
	console.log("Hi");$("#ProductDatatables #thClick").click();
	//document.getElementById("newElementForm").reset();
	$("#returnTableDiv").addClass("HideThisElement");
	$("#returnViewDiv").addClass("HideThisElement");
	$("#retrunFormDiv").removeClass("HideThisElement");
	if($("#departmentHeader").val()=="Sales")
	{
    	$('#clientSalesPerson').val($("#loggedInUserId").val());
    	$('#clientSalesPerson').attr("disabled", true);
	}
	var generator = new IDGenerator();
	$("#returnId").val("RT"+generator.generate());
	$("#SubmitButtonRegister").removeClass("HideThisElement");
	$("#SubmitButtonUpdate").addClass("HideThisElement");
}

/*function getRemarksHistory(rowId, start, isRefresh, e)
{
    $.ajax({
        url: "../../../GetCoreTeamRemarksHistoryForTask?TaskId=" + rowId + "&start=" + start + "&limit=5",
        type: "GET",
        success: function(data) {
            if (e) e.preventDefault();
            if (data != 0) {
                var str = "";
                $('#lm').html('');
                if (isRefresh == 1) $('#remarksDiv').html('');
                document.querySelector('#remarksDiv').insertAdjacentHTML('beforeend', data);
                //$('#remarksDiv').append(data);
                str = "<div id='lm'><a href='#' onclick='getRemarksHistory(\"" + rowId + "\", " + (parseInt(start) + 5) + ",0, " + $(this).event + ");'>Load More . . .</a></div>";
                document.querySelector('#remarksDiv').insertAdjacentHTML('afterend', str);
                $(document).scrollTop($(document).height());

                var firstMsg = $('#remarksDiv .card:first');
                // Store current scroll/offset
                var curOffset = firstMsg.offset().top - $(document).scrollTop();

                // Add your new messages
                firstMsg.before($('#remarksDiv .card').eq(5).clone());
                firstMsg.before($('#remarksDiv .card').eq(5).clone());
                firstMsg.before($('#remarksDiv .card').eq(5).clone());

                $(document).scrollTop(firstMsg.offset().top - curOffset);

            } else if (data == 0) {
                $('#lm').html('');
                $(document).scrollTop($(document).height());

                var firstMsg = $('#remarksDiv .card:first');
                // Store current scroll/offset
                var curOffset = firstMsg.offset().top - $(document).scrollTop();

                // Add your new messages
                firstMsg.before($('#remarksDiv .card').eq(5).clone());
                firstMsg.before($('#remarksDiv .card').eq(5).clone());
                firstMsg.before($('#remarksDiv .card').eq(5).clone());

                $(document).scrollTop(firstMsg.offset().top - curOffset);
            }
        }
    });
}*/

function changeCustomerFunction(value)
{
	if(value == "8884")
	{
		$("#dispatchDetails").removeClass("HideThisElement");
		$("#creditNoteDetails").addClass("HideThisElement");
	}
	else if(value == "8885")
	{
		$("#creditNoteDetails").removeClass("HideThisElement");
		$("#dispatchDetails").addClass("HideThisElement");
	}
	else
	{
		$("#dispatchDetails").addClass("HideThisElement");
		$("#creditNoteDetails").addClass("HideThisElement");
	}
}

function saveReturnItemStatus()
{
	spinnerOn();
	
	var returnVal=false;
	console.log("b ............ "+$("#ReturnItemIDText").text());
	
	$.ajax
	({
        type: "POST",
        url: "../../../SaveReturnItemStatus",
        data: $("#updateStatus").serialize()+"&rowId="+$("#ReturnItemIDText").text(), 
        async:false,
        success: function(data)
        {	
        	spinnerOff();
        	
        	SwalSuccessHeader("Return Item Save Sucessfully");
        	
        	console.log(data+" ...........opd");
        	
        	
        	if(data!="0")
        	{
        		//barcodeArr.push($.trim(data));
        		returnVal=true;
        	}
     	   else
     		  returnVal=false
        }
	});
	var bStatus="";
	
	if($("#vendorStatus").val()=="9995" || $("#vendorStatus").val()=="9996" )
	{
		bStatus="101";
	}
	else if($("#customerStatus").val()=="8884"|| $("#customerStatus").val()=="8883" )
	{
		bStatus="103";
	}
	$.ajax
	({
        type: "POST",
        url: "../../../saveQcStatus",
        data: "status="+bStatus+"&barcode="+$("#refNo").val(), 
        async:false,
        success: function(data)
        {	
        	spinnerOff();
        	if(data!="0")
        	{
        		//barcodeArr.push($.trim(data));
        		returnVal=true;
        	}
     	   else
     		  returnVal=false;        
        	$("#returnItemListTableDiv").removeClass("HideThisElement");
       	 	$("#returnItemListViewDiv").addClass("HideThisElement");
        }
	});
}

function saveQcStatus()
{
	spinnerOn();
	
	var returnVal=false;
	
	$.ajax
	({
        type: "POST",
        url: "../../../saveQcStatus",
        data: "status="+$("#qCStatus").val()+"&qCremarks="+$("#qCremarks").val()+"&barcode="+$("#barcodeText").text(), 
        async:false,
        success: function(data)
        {	
        	if(data!="0")
        	{
        		spinnerOff();
        		
        		SwalSuccessHeader("QC Save Sucessfully");
        		
        		returnVal=true;
        	}
     	   else
     		  returnVal=false
        }
	});
}

$("#submitQcStatus").click(function() 
{
	if(validateQCStatus())
	saveQcStatus();
});


