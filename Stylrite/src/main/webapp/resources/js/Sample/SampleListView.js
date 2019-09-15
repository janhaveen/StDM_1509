$(document).ready(function(){    
	var table = $('#ProductDatatables').DataTable( {
        buttons: [
            /*{
                text: 'New Product',
                action: function ( e, dt, node, config ) {
                	loadBlankform();
                }
            }*/
        ],dom: 'Bfrtip',
		"bLengthChange": true,
		"iDisplayLength":10,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "../../../GetSampleList",
		"columns": [
        	 /*{
        		 "className":      'details-control center',
                 "orderable":      false,
                 "data":           null,
                 "defaultContent": '<i class="fa fa-plus-circle  pl fa-2x"></i> '+
                 				  '<i class="fa fa-minus-circle mi HideThisElement fa-2x"></i>'
             },*/
            { "data": "i" },
            { "data": "issuesTo_txt" },
            { "data": "productInfo" },
            { "data": "issueDate" }
            
        ],
        fixedColumns: true
    });
	
	/*$('#ProductDatatables tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var row = table.row( tr );
        if ( row.child.isShown() ) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            row.child( format(row.data()) ).show();
            tr.addClass('shown');
        }
    } );*/
});

function format(d) { console.log(d);
	var str="";
	$.ajax({
		url:"../../../GetAvailableStockLocationWise?brand_txt="+d.brand,
		type:"GET",
		async:false,
		success:function(data){			
			str+='<table class="table table-hover mb-0 nowrap" >';
			for (var i = 0; i < data.data.length; i++) {		
				str+='<tr>'+
	            	'<td>'+data.data[i].productinfo+'</td>'+
	            	'<td>'+data.data[i].total+'</td>'+
	             '</tr>';
			}
		}
	});
	str+='</table>';
	return str;   
}