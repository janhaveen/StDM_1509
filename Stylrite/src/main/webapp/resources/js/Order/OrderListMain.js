 $(document).ready(function()
		{
	 getOrderList();
	$("#SubmitButtonBackFromView").click(function() {
	    document.getElementById("clientInfoForm").reset();		
	    $("#clientBillingAddress").html("");
	    $("#clientDeliveryAddress").html("");
	    $("#ProductDataBody").html("");
		$("#OrderTableDiv").removeClass("HideThisElement");
		$("#OrderViewDiv").addClass("HideThisElement");
		$("#orderFormDiv").addClass("HideThisElement");
		$("#SubmitButtonRegister").removeClass("HideThisElement");
		$("#SubmitButtonUpdate").addClass("HideThisElement");
		getOrderList();
	});
	
});
 function getOrderList(){
		spinnerOn();
		
		 if($("#t").val().indexOf("1")>=0){
		  	$("#HomeText").text("New Order");
			 $('#ProductDatatables').DataTable().destroy();
			/* getProductList();
			 getProductClick();*/
			if($("#departmentHeader").val()=="Sales"){
		    	$('#clientSalesPerson').val($("#loggedInUserId").val());
		    	$('#clientSalesPerson').attr("disabled", true);
			}
			var generator = new IDGenerator();
			$("#OrderId").val("O"+generator.generate());		
			$("#OrderTableDiv").addClass("HideThisElement");
			$("#orderFormDiv").removeClass("HideThisElement");
		}else{
			$("#OrderTableDiv").removeClass("HideThisElement");
			$("#orderFormDiv").addClass("HideThisElement");
		}
		
		$('#datatablesOrder').DataTable().destroy();
		
		$('#datatablesOrder thead #filterrow th').each( function () {
	    	var title = $(this).text();
	        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
	    });
		
	    $("#datatablesOrder thead input").on('keyup change', function () {
	        table.column($(this).parent().index() + ':visible')
	            .search(this.value)
	            .draw();
	    });
	    
	    var actionStr = "";
	    if(window.location.href.indexOf("showOrder")<0)
	    {
	    	actionStr = '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> ';
	    }
	    else
	    {
	    	actionStr = '<i class="edit_me fa fa-pencil-alt fa-2x" aria-hidden="true"></i>'+
	    	'<i class="select_me_order1 fa fa-eye fa-2x" aria-hidden="true"></i> '+
	        '<i class="delete_me fa fa-trash fa-2x HideThisElement" aria-hidden="true"></i>';
	    }
	    
	    var str="?1=1&list=y";
	    if($("#type").val()){
	    	str+="&type="+$("#type").val();
	    	if($("#type").val()=="c")
	    		$("#HomeText").text("Completed Order List");
	    	else if($("#type").val()=="p")
	    		$("#HomeText").text("Pending Order List");
	    }else
	    	$("#HomeText").text("Order List");
	    
		var table = $('#datatablesOrder').DataTable( {
			dom: 'Bfrtip',
	        buttons: [
	            {
	                text: 'New Order',
	                action: function ( e, dt, node, config ) {
	                	loadBlankformForOrder();
	                }
	            }
	        ],
			"bLengthChange": true,
			"searching": true,
			"orderCellsTop": true ,
			"sScrollX": "100%",
	        "sScrollXInner": "100%",
	        "bScrollCollapse": true,
			"ajax": "GetMainOrderList",
			"columns": [
	        	 {
	                 className: "center",
	                 defaultContent: actionStr
	             },
	            //{ "data": "i" },
	            { "data": "orderdate" },
	            { "data": "orderId" },
	            { "data": "companyName" },
	            { "data": "clientLocation" },
	            { "data": "cpname" },
	            { "data": "contactNo" },
	            { "data": "spname" },
	            { "data": "count" }
	        ],
	        /*columnDefs: [
	            { width: '25pc', targets: 1 },
	            { width: '30pc', targets: 2 }
	        ],*/
	        "fnRowCallback": function( nRow, aData, iDisplayIndex ) {
	            if ( aData['isEditable'] == "0" )
	            {
	                console.log($($($(nRow).children()[0]).children()[0]).addClass("HideThisElement"));
	                //spinnerOff();
	            }
	        },
	        fixedColumns: true,
	        "initComplete": function(settings, json) {     
	            spinnerOff();
	        }
	    });
		
	    $('#datatablesOrder tbody').off('click');
	    
	    $('#datatablesOrder tbody').on('click', '.select_me', function() {
	    	var data = table.row( $(this).parents('tr') ).data();
	    	console.log("data is ",data);
	    	//window.location.href="viewOrder?orderId="+$("#OrderId").val();
	    	/*window.location.href="ViewOrder.jsp?t="+$("#type").val()+"&oid="+data.orderId;*/
	    });
	    
	    $('#datatablesOrder tbody').on( 'click', '.delete_me', function () {
	    	var data = table.row( $(this).parents('tr') ).data();
	    	document.querySelector('#DeleteOrderId').value = data.orderId;
	    	$('#centralModalDangerDemo').modal('show');
	    });
	    
	    $('#datatablesOrder tbody').on('click', '.edit_me', function() {
			var data = table.row($(this).parents('tr')).data();	  
		 console.log("edit order data ",data);
		    editOrderData(data);
		});
	    
		$('#datatablesOrder tbody').on('click', '.select_me_order1', function() {
			var data = table.row($(this).parents('tr')).data();	   
		    getOrderDataForView(data.orderId);
		});
 }

function getOrderDataForView(orderId)
{
	/*alert("getorderdata is"+orderId);*/
	$('dd').text('-');
	spinnerOn();
	$.ajax({
		url:"GetOrderDetails?&orderId="+orderId,
		type:"GET",
		success:function(data){	
			console.log("view order data ",data)
			spinnerOff();
			$("#OrderIDText").text(data.data[0].orderId);
			$("#ClientnameText").text(data.data[0].companyName);
			$("#ClientCpText").text(data.data[0].cpname);
			$("#OrderStatusText").text(data.data[0].orderstatus_txt);
			$("#OrderDateText").text(data.data[0].orderdate);
			$("#BillingAddressText").html(data.data[0].branchName+", "+data.data[0].blocationadd+", "+data.data[0].bstate_text+", "+data.data[0].bpincode);
			$("#DeliveryAddressText").html(data.data[0].dbranchName+", "+data.data[0].dlocationadd+", "+data.data[0].dstate_text+", "+data.data[0].dpincode);
			$("#SalesPersonText").text(data.data[0].spname);
			if(data.data[0].contactNo!=0) $("#ContactNumberText").text(data.data[0].contactNo); 
			$("#InvoiceTypeText").text(data.data[0].invoicetype_txt);
			$("#ModeOfPaymentText").text(data.data[0].modeofpay_txt);
			$("#ExpDDText").text(data.data[0].expectedDeilvery);
			$("#RefNumberText").text(data.data[0].refno);	
			$("#OrderIDText2").text(data.data[0].orderId);
			$("#ClientnameText2").text(data.data[0].companyName);
			$("#ClientCpText2").text(data.data[0].cpname);
			$("#OrderDateText2").text(data.data[0].orderdate);
			$("#BillingAddressText2").html(data.data[0].bbranchName+", "+data.data[0].blocationadd+", "+data.data[0].bstate_text+", "+data.data[0].bpincode);
			$("#DeliveryAddressText2").html(data.data[0].dbranchName+", "+data.data[0].dlocationadd+", "+data.data[0].dstate_text+", "+data.data[0].dpincode);
			$("#SalesPersonText2").text(data.data[0].spname);
			if(data.data[0].contactNo!=0) $("#ContactNumberText2").text(data.data[0].contactNo); 
			$("#InvoiceTypeText2").text(data.data[0].invoicetype_txt);
			$("#ModeOfPaymentText2").text(data.data[0].modeofpay_txt);
			$("#ExpDDText2").text(data.data[0].expectedDeilvery);
			$("#RefNumberText2").text(data.data[0].refno);
			$("#RemarksText").text(data.data[0].remarks);
			$("#OrderIDText1").text(data.data[0].orderId);
			$("#OrderDateText1").text(data.data[0].orderdate);
			$("#ClientnameText1").text(data.data[0].companyName);
			$("#SalesPersonText1").text(data.data[0].spname);
			$('#ProductDataBody2').html(""); $('#ProductDataBody1').html("");
			var countQty=0;
			for (var j = 0; j < data.data.length; j++) {
				var html="<tr>"
						+"<td>"+(i + 1)+"</td>"
						+"<td>"+data.data[j].skuid+"</td>"
						+"<td>"+data.data[j].productInfo+"</td>"
						+"<td>"+data.data[j].quantity+"</td>"
						+"<td>"+data.data[j].status_txt+"</td>"
						+"<td>"+data.data[j].availableStockInventory+"</td>"
						+"<td>"+data.data[j].availableStockSample+"</td>"						
						+"<td>"+data.data[j].location+"</td>"
						"<tr>";
				countQty+=parseInt(data.data[j].quantity);
				document.querySelector('#ProductDataBody2').insertAdjacentHTML('beforeend', html);				
			}
			$("#TotalQtyText").text(countQty);
			
			var totalamt=0, totalDisc=0, totalTax=0;
			
			for (var i = 0; i < data.data.length; i++) {
				var discount=0, amount=0, tax=0;
				amount=parseInt(data.data[i].rate)*parseInt(data.data[i].quantity);
				discount=parseInt(data.data[i].discount)*amount*0.01;
				tax=parseInt(data.data[i].igst)*(amount-discount)*0.01;
				console.log("igst   ...."+data.data[i].igst); 
				var html="<tr>"
						+"<td>"+ (i + 1) +/*data.data[i].+ (i + 1) ++*/"</td>"
						+"<td>"+data.data[i].skuid+"</td>"
						+"<td>"+data.data[i].productInfo+"</td>"
						+"<td>"+data.data[i].quantity+"</td>"
						+"<td>"+data.data[i].rate+"</td>"
						+"<td>"+data.data[i].igst+"%</td>"
						+"<td>"+data.data[i].discount+"%</td>"
						+"<td>"+data.data[i].status_txt+"</td>"
						"<tr>";
				document.querySelector('#ProductDataBody1').insertAdjacentHTML('beforeend', html);
				totalamt+=amount;
				totalDisc+=discount;
				totalTax+=tax;
			}
			var str="<tr class='left'>" +
					"<td colspan='7'> Billing State</td>"+
		            "<td>"+data.data[0].bstate_text+"</td>"+
					"</tr>"+
					"<tr class='left'>" +
					"<td colspan='7'> GST Number</td>"+
                    "<td>"+data.data[0].bGst+"</td>"+
					"</tr>"+					
					"<tr class='left'>" +
					"<td colspan='7'> Total Amount</td>"+
                    "<td>"+totalamt.toFixed(2)+"</td>"+
					"</tr>"+
					"<tr class='left'>" +
					"<td colspan='7'> Discount</td>"+
                    "<td>"+totalDisc.toFixed(2)+"</td>"+
					"</tr>"+
                    "<tr class='left'>" +
					"<td colspan='7'> Net Amount</td>"+
                    "<td>"+(totalamt-totalDisc).toFixed(2)+"</td>"+
					"</tr>"+
					"<tr class='left'>" +
					"<td colspan='7'> Tax Amount</td>"+
                    "<td>"+totalTax.toFixed(2)+"</td>"+
					"</tr>"+
					"<tr class='left'>" +
					"<td colspan='7'> Amount Payable</td>"+
                    "<td>"+Math.round(totalamt-totalDisc+totalTax).toFixed(2)+"</td>"+
					"</tr>";
			document.querySelector('#ProductDataBody1').insertAdjacentHTML('beforeend', str);

			$.ajax({
    	   		url:"CreatePdf",
    	   		data:{data:$("#DownloadPdf")[0].innerHTML, id:$("#OrderIDText").text()},
    	   		type:"POST",
    	   		success:function(data){
    	   			console.log(data);
    	   			$("#printLocationDetails").attr('href',"/DownloadServlet?id="+$("#OrderIDText").text());
    	   		}
    	   });
			$.ajax({
    	   		url:"../../../CreatePdf",
    	   		data:{data:$("#downloadPdf1")[0].innerHTML, id:$("#OrderIDText").text()+"P"},
    	   		type:"POST",
    	   		success:function(data){
    	   			console.log(data);
    	   			$("#printOrderDetails").attr('href',"../../../DownloadServlet?id="+$("#OrderIDText").text()+"P");
    	   		}
    	   });
			
			
		}
	});
    $("#OrderTableDiv").addClass("HideThisElement");
	$("#OrderViewDiv").removeClass("HideThisElement");
	$("#orderFormDiv").addClass("HideThisElement");
}

function loadBlankformForOrder() {
	//document.getElementById("newElementForm").reset();
	$('#ProductDatatables').DataTable().destroy();
	/* getProductList();
	 getProductClick();*/
	$("#OrderTableDiv").addClass("HideThisElement");
	$("#OrderViewDiv").addClass("HideThisElement");
	$("#orderFormDiv").removeClass("HideThisElement");
	$("#HomeText").text("New Order");
	 
	if($("#departmentHeader").val()=="Sales"){
    	$('#clientSalesPerson').val($("#loggedInUserId").val());
    	$('#clientSalesPerson').attr("disabled", true);
	}
	var generator = new IDGenerator();
	$("#OrderId").val("O"+generator.generate());
	$("#SubmitButtonRegister").removeClass("HideThisElement");
	$("#SubmitButtonUpdate").addClass("HideThisElement");
}


function Swal(msg)
{
	swal({
		  text: msg,
		  type: "warning",
		  confirmButtonText: "Ok!",
		  closeOnConfirm: false
		});
}