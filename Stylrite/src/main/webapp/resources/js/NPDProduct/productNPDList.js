$(document).ready(function()
{
	$("#HomeText").html("NPD Product");
	
	getProductNPDList();
	
});


//Product NPD list
function getProductNPDList() 
{
		spinnerOn();
	
	    var actionStr = "",
	        str = "?1=1";
	    var i = 0;
	    var url = "getProductNPDList";
	    if (window.location.href.indexOf("showProductNPD") >= 0) 
	    {
	        actionStr = '<i class="edit_me fa fa-check fa-2x" aria-hidden="true"></i> ';
	      
	    } 
	
		$('#productNPDListTable').DataTable().destroy();
	
		$('#productNPDListTable thead #filterrow th').each( function () {
	    	var title = $(this).text();
	        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
	    });
		
    	$("#productNPDListTable thead input").on('keyup change', function () {
    	    table.column($(this).parent().index() + ':visible')
    	        .search(this.value)
    	        .draw();
    	});
    	
    	 var table=$('#productNPDListTable').DataTable({ 
    		// dom: 'Bfrtip',
             buttons: [
                 {
                     text: 'Add New Product',
                     action: function ( e, dt, node, config ) {
                     	addNewProduct();
                     	
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
                //  "dataSrc": "" 
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
                /*  { "data": "act" , "sClass":"HideThisElement spret center"},*/
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
               }

             
    	 });
    	 
    	 
    	 $('#productNPDListTable tbody').off('click');
    	 
    	 $('#productNPDListTable tbody').on( 'click', '.edit_me', function () 
    	 {
    		 var data = table.row( $(this).parents('tr') ).data();
    		 
    		 SwalOfNPDProduct("Are You Want To Sent This Product !",  data);
       		 
    	 });
    	 
    	
}

/*------------------------------------------SWAL NPD Product Start-----------------------------------------------------------------*/

//New Product and Update Barcode Data In Scan Barcode (Swal)
function SwalOfNPDProduct(msg, data) 
{
	swal
	({
		 // title: 'Add New Product and Update Barcode?',
		  text: msg,
		  type: 'warning',
		  showCancelButton: true,
		  confirmButtonText: 'Sent For Purchase',
		  cancelButtonText: 'Sent For Production'
		}).then(function()
		 {
			 sentForPurchase(data);
		 }, 
		function(dismiss)
		{
		  if (dismiss === 'cancel')
		  {
			  sentForProduction(data);
		  }
	});
}
/*------------------------------------------SWAL NPD Product End-----------------------------------------------------------------*/


/*------------------------------------------Sent For Purchase Function Start-----------------------------------------------------------------*/
//sent For Purchase (function)
function sentForPurchase(data)
{
	 console.log(data.sku, data.rowId, data);
	 
	 var generator = new IDGenerator();
	 
 $.ajax
  ({
        type: "POST",
        url: "sentForPurchase",
        data: "sku="+data.sku+"&productId="+data.rowId+"&rowId="+("NPD"+generator.generate())+"&npdType="+"300001", // serializes the form's elements.
        async:false,
        success: function(data)
        {
      	  console.log(data);
      	  
      	  getProductNPDList();
      	  
        },
		  error : function ()
		  {
			  
		  }
  
    });
}
/*------------------------------------------Sent For Purchase Function End-----------------------------------------------------------------*/

/*------------------------------------------Sent For Production Function Start-----------------------------------------------------------------*/
//sent For Production (function)
function sentForProduction(data)
{
	 console.log(data);
	 
	 var generator = new IDGenerator();
	 
	 $.ajax
	  ({
	        type: "POST",
	        url: "sentForProduction",
	        data: "sku="+data.sku+"&productId="+data.rowId+"&rowId="+("NPD"+generator.generate())+"&npdType="+"300002", // serializes the form's elements.
	        async:false,
	        success: function(data)
	        {
	      	  console.log(data);
	      	  
	      	  getProductNPDList();
	      	  
	        },
			  error : function ()
			  {
				  
			  }
	  
	    });
}

/*------------------------------------------Sent For Production Function End-----------------------------------------------------------------*/
