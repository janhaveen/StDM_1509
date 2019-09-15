$(document).ready(function()
{
	$("#HomeText").html("Sample Transfer");
	
	getSampleTransferProductList();

	
});


//Product list
function getSampleTransferProductList() 
{
		spinnerOn();
	
	    var actionStr = "",
	        str = "?1=1";
	    var i = 0;
	    var url = "GetStockSalesPerson?&spEmpid="+$('#SalesPersonF').val();
	

	   /* if (window.location.href.indexOf("SampleReturn.jsp") >= 0) {
	        url = "../../../GetStockSalesPerson";
	        str = "?1=1&spEmpid=" + $('#SalesPerson').val();
	    }
*/
	  
	
		$('#SampleTransferproductListTable').DataTable().destroy();
	
	
    	 var table=$('#SampleTransferproductListTable').DataTable({ 
    		 dom: 'Bfrtip',
             buttons: [
                 {
                     text: 'Add New Product',
                     action: function ( e, dt, node, config ) {
                     
                     	
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
                  "url": url,
                  "dataSrc": "" 
              },
              //'processing': true,
              'dataType': "json",
              'language': {
                  'loadingRecords': '&nbsp;',
                  processing: '<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i><span class="sr-only"></span> '
              }, 
      		 "columns": [
      			{
                  	className: "center",
                      defaultContent:actionStr
                  },
                { "data": "act"},
                  { "data": "skuid" },
                  { "data": "brand_txt" },
                  { "data": "type_txt" },
                  { "data": "modelNo" },
                  { "data": "color" },
                  { "data": "size" },
                  { "data": "cost" }
               ],
               
               "initComplete": function(settings, json)
               {   
               	spinnerOff();
               /*
            	if(window.location.href.indexOf("SampleReturn.jsp")>=0 || window.location.href.indexOf("showSampleTransfer")>=0){
            		$(".spret").removeClass("HideThisElement");
            	}$("#Product Datatables #thClick").click();
        		$("select[name=ProductDatatables_length]").addClass('classForPageLengthMenu');
            */
               },
               fixedColumns: true

             
    	 });
    	  
    	
}


