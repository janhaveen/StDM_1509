function getSalesPersonSampleTable(pid) {
	console.log(pid);
	 $('#SalesPersonSampleTable').DataTable().destroy();

	$('#SalesPersonSampleTable thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
    });
	
    $("#SalesPersonSampleTable thead input").on('keyup change', function () {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
       
	var table = $('#SalesPersonSampleTable').DataTable( {
		dom: 'Bfrtip',
        buttons: [
            /*{
                text: 'New Order',
                action: function ( e, dt, node, config ) {
                	loadBlankformForOrder();
                }
            }*/
        ],
        //"lengthMenu": [ [10, 25, 50, -1], [10, 25, 50, "All"] ],
		"bLengthChange": true,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax":{
			"url":"GetSampleListForStockOutFromSample?1=1",
			"type":"POST",
			"data":{
				"Product_id":pid.substring(0, pid.length-1)
			}
		},
		"columns": [
        	 {
             	className: "center",
                 defaultContent: '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> '
             },
             { "data": "skuid" },
             { "data": "brand_text" },
             { "data": "modelNo" },
             { "data": "color" },
             { "data": "size" },
            { "data": "issuesTo_txt" }
        ],        
        fixedColumns: true,
        "initComplete": function(settings, json) {     
            spinnerOff();
        }
    });
	
    $('#SalesPersonSampleTable tbody').off('click');
    
    $('#SalesPersonSampleTable tbody').on('click', '.select_me', function() {
    	var data = table.row($(this).parents('tr')).data();
    	var str=data.barcodes.split(",");
    	$("#childbarcodeIdText").val(str[0]);
        $("#childbarcodeIdText").keyup();
        $('#TakeFromSample').modal('hide');
    });
}