$(document).ready(function()
{
    $("#Backbtn").click(function() {
    	$("#tableDiv").removeClass("HideThisElement");
    	$("#ViewDiv").addClass("HideThisElement");
    	$("#HomeText").text("InProcess Order List");
	});
    
    $("#Cancelbtn").click(function() {
    	cancelOrder();
	});
    
    
    getInProcessOrder();
    $("#HomeText").text("InProcess Order List");
	
});

function getInProcessOrder() 
{
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
	    if(window.location.href.indexOf("InProcessOrders")<0){
	    	actionStr = '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> ';
	    }else{
	    	actionStr = '<i class="select_me_order1 fa fa-eye fa-2x" aria-hidden="true"></i> '+
	        '<i class="delete_me fa fa-trash fa-2x HideThisElement" aria-hidden="true"></i>';
	    }
	    
	    var str="?1=1&list=y";
	    if($("#type").val()){
	    	str+="&type="+$("#type").val();
	    	/*if($("#type").val()=="c")
	    		$("#HomeText").text("Completed Order List");
	    	else if($("#type").val()=="p")
	    		$("#HomeText").text("Pending Order List");*/
	    }else
	    	$("#HomeText").text("InProcess Order List");
	    
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
			"ajax": {
                "url": "GetInprocessOrderList",
                "dataSrc": "",
            },
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
	        fixedColumns: true
	    });
		
	    $('#datatablesOrder tbody').off('click');
	    
	    $('#datatablesOrder tbody').on('click', '.select_me', function() {
	    	var data = table.row( $(this).parents('tr') ).data();
	    	/*getOrderData(data.orderId);
	    	$("#oid").val(data.orderId);
	    	$("#HomeText").text("InProcess Order List");
	    	$("#tableDiv").addClass("HideThisElement");
	    	$("#ViewDiv").removeClass("HideThisElement");*/
	    	//window.location.href="ViewOrder.jsp?t="+$("#type").val()+"&oid="+data.orderId;
	    });
	    
	    $('#datatablesOrder tbody').on( 'click', '.delete_me', function () {
	    	var data = table.row( $(this).parents('tr') ).data();
	    	document.querySelector('#DeleteOrderId').value = data.orderId;
	    	$('#centralModalDangerDemo').modal('show');
	    });
}


/*function getOrderData(oid) {
	$('#ProductDataBody').html("");
	spinnerOn();
	$("#HomeText").text("view Order (ID:"+oid+")");
   	 var str="?1=1&oid="+oid;
   	 if($("#type").val()){
       	str+="&type="+$("#type").val();
     }
   	 $.ajax({
   		url:"../../../GetOrderList"+str,
   		type:"GET",
   		success:function(data){
   			for (var i = 0; i < data.data.length; i++) {
   				var html="<tr>"
   						+"<td class='center'>"+"<input class='form-check-input cancelCb' type='checkbox' value='"+data.data[i].rowId+"'>"+"</td>"						
   						+"<td>"+data.data[i].skuid+"</td>"
   						+"<td>"+data.data[i].productInfo+"</td>"
   						+"<td>"+data.data[i].quantity+"</td>"
   						+"<td>"+data.data[i].balancequantity+"</td>"
   						+"<td>"+data.data[i].blockedquantity+"</td>"
   						+"<td>"+data.data[i].status_txt+"</td>"
   						"<tr>";
   				document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', html);
   				spinnerOff();
   			}
   		}
	 });
}
*/
/*function cancelOrder() {
	if($("#Remarks").val()==""){
		SwalWarningHeader("Enter Remarks!");
	}else if($(".cancelCb").filter(':checked').length>0){
		for (var i = 0; i < $(".cancelCb").filter(':checked').length; i++) {
			$.ajax({
				url:"../../../CancelOrder",
		   		type:"POST",
		   		data:{"orderitemid":$($(".cancelCb")[i]).val(),"remarks":$("#Remarks").val(),"oid":$("#oid").val()},
		   		success:function(data){
		   			SwalSuccessHeader("Order Cancelled Successfully !");
		   	    	$("#tableDiv").removeClass("HideThisElement");
		   	    	$("#ViewDiv").addClass("HideThisElement");
		   			//getOrderData(data.orderId);
		   	    	$('#datatablesOrder').DataTable().ajax.reload();
		   		}
			});
		}	
	}else{
		SwalWarningHeader("Select Items!");
	}
}*/