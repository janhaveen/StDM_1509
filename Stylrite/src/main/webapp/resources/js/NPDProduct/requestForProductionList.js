$(document).ready(function()
{
	$("#HomeText").html("Request For Production List");
	
	getRequestForProductionList();
	
});


//Product NPD list
function getRequestForProductionList() 
{
		//spinnerOn();
	
	    var actionStr = "",
	        str = "?1=1";
	    var i = 0;
	    var url = "getRequestForProductionList";
	    if (window.location.href.indexOf("showRequestForProduction") >= 0) 
	    {
	        actionStr = '<i class="edit_me fa fa-check fa-2x" aria-hidden="true"></i> ';
	      
	    } 
	
		$('#requestForProductionListTable').DataTable().destroy();
	
		$('#requestForProductionListTable thead #filterrow th').each( function () {
	    	var title = $(this).text();
	        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
	    });
		
    	$("#requestForProductionListTable thead input").on('keyup change', function () {
    	    table.column($(this).parent().index() + ':visible')
    	        .search(this.value)
    	        .draw();
    	});
    	
    	 var table=$('#requestForProductionListTable').DataTable({ 
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
                  { "data": "rowId" },
                  { "data": "productInfo" },
                  { "data": "sku" },
                  { "data": "statusText" },
                  { "data": "createdBy" }
               ],
               
               "initComplete": function(settings, json)
               {   
               	spinnerOff();
               }

             
    	 });
    	 
    	 
    	 $('#requestForProductionListTable tbody').off('click');
    	 
    	 $('#requestForProductionListTable tbody').on( 'click', '.edit_me', function () 
    	 {
    		 var data = table.row( $(this).parents('tr') ).data();
    		 
    		 SwalOfNPDProductSentInfo("Are You Want To Send This Product !",  data);
       		 
    	 });
}

/*------------------------------------------SWAL NPD Product Sent Info Start-----------------------------------------------------------------*/

function SwalOfNPDProductSentInfo(msg, data) 
{
	swal
	({
		 // title: 'Add New Product and Update Barcode?',
		  text: msg,
		  type: 'warning',
		  showCancelButton: true,
		  confirmButtonText: 'Processed',
		  cancelButtonText: 'In Processed'
		}).then(function()
		 {
			 updateStatusForProcessed(data);
		 }, 
		function(dismiss)
		{
		  if (dismiss === 'cancel')
		  {
			  updateStatusForInProcessed(data);
		  }
	});
}
/*------------------------------------------SWAL  NPD Product Sent Info End-----------------------------------------------------------------*/

/*------------------------------------------Update Status For Processed Function Start-----------------------------------------------------------------*/
//update Status For Processed (function)
function updateStatusForProcessed(data)
{
	 console.log(data);
	 
	 var generator = new IDGenerator();
	 
	$.ajax
	({
	      type: "POST",
	      url: "updateStatusForProcessedInNPD",
	      data: "sku="+data.sku+"&rowId="+data.rowId+"&productId="+data.productId+"&npdStatus="+"400001", // serializes the form's elements.
	      async:false,
	      success: function(data)
	      {
	    	  console.log(data);
	    	  
	    	  getRequestForProductionList();
	    	  
	      },
			  error : function ()
			  {
				  
			  }
	
	  });
}
/*------------------------------------------Update Status For Processed Function End-----------------------------------------------------------------*/

/*------------------------------------------Update Status For InProcessed Function Start-----------------------------------------------------------------*/
//update Status For InProcessed (function)
function updateStatusForInProcessed(data)
{
	 console.log(data);
	 
	 var generator = new IDGenerator();
	 
	$.ajax
	({
	      type: "POST",
	      url: "updateStatusForInProcessedInNPD",
	      data: "sku="+data.sku+"&rowId="+data.rowId+"&productId="+data.productId+"&npdStatus="+"400002", // serializes the form's elements.
	      async:false,
	      success: function(data)
	      {
	    	  console.log(data);
	    	  
	    	  getRequestForProductionList();
	    	  
	      },
			  error : function ()
			  {
				  
			  }
	
	  });
}
/*------------------------------------------Update Status For InProcessed Function End-----------------------------------------------------------------*/