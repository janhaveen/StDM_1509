$(document).ready(function()
{
	getGRNList();
});

function getGRNList()
{
	spinnerOn();
	
	$('#grnDatatables thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
    });
	
    $("#grnDatatables thead input").on('keyup change', function () {
        contactPersonTable.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
    
    var actionStr = "", str="";
    str="&t="+$('#type').val();
    if(window.location.href.indexOf("JSPs/Order.jsp")>=0)
    {
    	actionStr = '<i class="select_me_clientAdd fa fa-check fa-2x" aria-hidden="true"></i> ';
    }
    else
    {
    	actionStr = '<i class="edit_me fa fa-pencil-alt fa-2x" aria-hidden="true"></i> '+
            '<i class="delete_me fa fa-trash fa-2x " aria-hidden="true"></i>'
    }
    
	var table = $('#grnDatatables').DataTable( {
        buttons: [
            /*{
                text: 'New Address',
                action: function ( e, dt, node, config ) {
                	loadBlankformAddress();
                }
            }*/
        ],dom: 'Bfrtip',
		"bLengthChange": true,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "getGRNList",
		"processing": true,
        "language": {
            processing: '<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i><span class="sr-only">Loading...</span> '
         },
		"columns": [
        	 {
             	className: "center",
                 defaultContent: '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> '
             },  
			 //{ "data": "i" },
			 { "data": "createdOn" },
            { "data": "gRNnumber" },
            { "data": "vendorName" },
            { "data": "location" },
            { "data": "itemCount" },
            { "data": "totalQty" }
        ],
        fixedColumns: true,
        "initComplete": function(settings, json) {   
        	spinnerOff();
        }
    });

	$('#grnDatatables tbody').on('click', '.select_me', function()
	 {
		var data = table.row($(this).parents('tr')).data();
		
		window.location.href="viewGRN?grnId="+data.grnid;
		
		/*if($('#type').val().indexOf("g")>=0)
			window.location.href="GenerateBarcode.jsp?id="+data.GRNId+"&t="+$('#type').val();
		else
			window.location.href="ViewGRN.jsp?id="+data.GRNId+"&t="+$('#type').val();*/
	});
}