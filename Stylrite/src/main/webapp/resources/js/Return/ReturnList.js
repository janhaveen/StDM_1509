$(document).ready(function()
{
    $("#HomeText").text("Return");
    
	spinnerOn();
	
	DropDownForProductLegend();
	
	DropDownForEmployee("");
	
	$('#datatablesReturnOrder').DataTable().destroy();
	
	$('#datatablesReturnOrder thead #filterrow th').each( function () 
		{
	    	var title = $(this).text();
	        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
	    });
		
	    $("#datatablesReturnOrder thead input").on('keyup change', function ()
	    {
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
	    
	    //var str="?1=1&list=y";
	   
		var table = $('#datatablesReturnOrder').DataTable( {
			dom: 'Bfrtip',
	        buttons: [
	            {
	                text: 'New Return',
	                action: function ( e, dt, node, config ) 
	                {
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
			"ajax": "getReturnList",
			"columns": [
	        	 {
	             	className: "center",
	                 defaultContent: actionStr
	             },
	            //{ "data": "i" },
	            { "data": "rowId" },
	            { "data": "clientId" },
	            { "data": "salesPerson" },
	            { "data": "contactPersonId" },
	            { "data": "status" }
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
	
    $('#datatablesReturnOrder tbody').off('click');
    
});

function getReturnOrderDataForView(returnId) {
	$('dd').text('-');
	spinnerOn();
	$.ajax({
		url:"../../../GetReturnOrderList?1=1&rid="+returnId,
		type:"GET",
		success:function(data)
		{
			console.log(data);
			spinnerOff();
			$("#ReturnOrderIDText").text(data.data[0].returnId);
			$("#ClientnameText").text(data.data[0].companyName);
			$("#ClientCpText").text(data.data[0].cpname);
			$("#OrderStatusText").text(data.data[0].returnStatus_txt);
			$("#ReturnOrderDateText").text(data.data[0].orderdate);
			//$("#BillingAddressText").html(data.data[0].clientAddress1);
			$("#clientAddressText").html(data.data[0].clientAddress1+","+data.data[0].clientAddress2+", "+data.data[0].bstate_text+", "+data.data[0].bpincode);
			$("#SalesPersonText").text(data.data[0].salespersonText);
			//$("#isDamagedText").text(data.data[0].isDamaged);
			if(data.data[0].contactNo!=0) $("#ContactNumberText").text(data.data[0].contactNo); 
			
			$('#ProductDataBody2').html(""); $('#ProductDataBody1').html("");
			for (var j = 0; j < data.data.length; j++)
			{

				var html="<tr>"
						+"<td>"+data.data[j].i+"</td>"
						+"<td>"+data.data[j].rowId+"</td>"
						+"<td>"+data.data[j].productInfo+"</td>"
						+"<td>"+data.data[j].quantity+"</td>"
						/*+"<td>"+data.data[j].isDamaged+"</td>"*/
						+"<td>"+data.data[j].returnStatus_txt+"</td>"
						"<tr>";
				document.querySelector('#ProductDataBody1').insertAdjacentHTML('beforeend', html);				
			}
					
		}
			
	});
    $("#returnTableDiv").addClass("HideThisElement");
	$("#returnViewDiv").removeClass("HideThisElement");
	$("#retrunFormDiv").addClass("HideThisElement");
}

function loadBlankformForOrder() 
{
	$("#HomeText").text("New Return");
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


function Swal(msg)
{
	swal({
	  text: msg,
	  type: "warning",
	  confirmButtonText: "Ok!",
	  closeOnConfirm: false
	});
}