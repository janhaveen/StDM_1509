$(document).ready(function()
{
	$("#HomeText").html("Audit List");
	
	getProductNPDList();
	
});


//Product NPD list
function getProductNPDList() 
{
		spinnerOn();
	
	    var actionStr = "",
	        str = "?1=1";
	    var i = 0;
	    var url = "getAuditListData";
	    if (window.location.href.indexOf("showAuditList") >= 0) 
	    {
	        actionStr = '<i class="edit_me fa fa-check fa-2x" aria-hidden="true"></i> ';
	      
	    } 
	
		$('#auditListTable').DataTable().destroy();
	
		$('#auditListTable thead #filterrow th').each( function () {
	    	var title = $(this).text();
	        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
	    });
		
    	$("#auditListTable thead input").on('keyup change', function () {
    	    table.column($(this).parent().index() + ':visible')
    	        .search(this.value)
    	        .draw();
    	});
    	
    	 var table=$('#auditListTable').DataTable({ 
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
                  { "data": "auditReasonText" },
                  { "data": "startTime" },
                  { "data": "endTime" },
                  { "data": "remarks" },
                  { "data": "totalAuditItem" }
               ],
               
               "initComplete": function(settings, json)
               {   
               	spinnerOff();
               }

             
    	 });
    	 
    	 
    	 $('#auditListTable tbody').off('click');
    	 
    	 $('#auditListTable tbody').on( 'click', '.edit_me', function () 
    	 {
    		 var data = table.row( $(this).parents('tr') ).data();
    		 
    		 console.log(data);
    		 
    		window.location.href="viewAuditListDetails?auditId="+data.rowId;
    		
    	 });
    	 
    	
}
