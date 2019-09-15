$(document).ready(function() {
	$("#HomeText").text("Empty Location List");
	$('#BoxDatatables thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
    });
	
    $("#BoxDatatables thead input").on('keyup change', function () {
        contactPersonTable.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
    var table = $('#BoxDatatables').DataTable( {
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
		"ajax": "GetEmptyBoxBarcodeList",
		"columns": [
        	 /*{
             	className: "center",
                 defaultContent: '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> '
             }, */ 
			 { "data": "rowNo" },
			 { "data": "floor" },
            { "data": "aisle" },
            { "data": "rack" },
            { "data": "section" },
            { "data": "location" }
        ],
        fixedColumns: true
    });
});