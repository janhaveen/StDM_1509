function getProductListDatatable() {
	/*spinnerOn();*/
	var actionStr="", str="?1=1"; var i=5; var url="GetProductListDatatable";
	
    if(window.location.href.indexOf("showProduct")>=0){
    	actionStr='<i class="edit_me fa fa-check fa-2x" aria-hidden="true"></i> '+
	     		'<i class="delete_me fa fa-trash fa-2x " aria-hidden="true"></i>';
    	i=10;
    	url="GetProductListDatatable";
    }else if(window.location.href.indexOf("showNewRequistion")>=0){
    	actionStr='<i class="select_me_sample select_me fa fa-check fa-2x" aria-hidden="true"></i> ';
    	i=5;
    	url="GetProductListDatatable";
    
    }else if(window.location.href.indexOf("JSPs/Order.jsp")>=0){
    	url="GetProductListDatatable";
    	actionStr='<i class="select_me_order fa fa-check fa-2x" aria-hidden="true"></i> ';
    	i=5;
    }else{
    	actionStr='<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> ';
    	i=5;
    }
	var table = $('#productListTable').DataTable( {
		
        buttons: [
            {
                text: 'New Product',
                action: function ( e, dt, node, config ) {
                	loadBlankform();
                }
            }
        ],
        "dom": '<"top"Blf>rt<"bottom"ip><"clear">',
	    lengthMenu: [
	        [ 5, 10, 25, 50, -1 ],
	        ['5', '10', '25', '50', 'All' ]
	    ],
		"bLengthChange": true,
		"iDisplayLength":i,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
        "processing": true,
        "language": {
            processing: '<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i><span class="sr-only">Loading...</span> '
         },
		"ajax": url,
		"columns": [
        	 {
             	className: "center ret",
                 defaultContent: '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i>'
             },
         /*    { "data": "act" , "sClass":"HideThisElement spret center"},*/
            { "data": "sku" },
            { "data": "brand_text" },
            { "data": "type_txt" },
            { "data": "modelNo" },
            { "data": "color" },
            { "data": "size" },
            { "data": "price" }/*,
            { "data": "availableStock" }    */                  
        ],
        "initComplete": function(settings, json) {   
        	spinnerOff(); //$("#productListTable #thClick").click();        	
        },
        fixedColumns: true
    });
}