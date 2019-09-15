$(document).ready(function()
{
	$("#HomeText").html("Product");
	
	getProductList();

	//Product form back button
	$("#BackButtonProduct").click(function() 
	{
		 document.getElementById('insertProductForm').reset();
		
		 $("#productListTableDiv").removeClass("HideThisElement");
     	 $("#productFormDiv").addClass("HideThisElement");
	});
	
	//Product view back button
	$("#SubmitButtonBackFromView").click(function() 
	{
		 document.getElementById('insertProductForm').reset();
		 
     	 $("#productListTableDiv").removeClass("HideThisElement");
		 $("#productViewDiv").addClass("HideThisElement");
	});
	
	 $("#brandFrm select").change(function() 
		 {
	    	$("#GenerateSKU").removeClass("HideThisElement");
	        $("#SubmitButtonProduct").addClass("HideThisElement");
	        $("#UpdateButtonProduct").addClass("HideThisElement");
		});
	    
	    $("#modelNo").change(function() 
	    {
	    	$("#GenerateSKU").removeClass("HideThisElement");
	        $("#SubmitButtonProduct").addClass("HideThisElement");
	        $("#UpdateButtonProduct").addClass("HideThisElement");
		});
	    
	    $("#color").change(function()
	    {
	    	$("#GenerateSKU").removeClass("HideThisElement");
	        $("#SubmitButtonProduct").addClass("HideThisElement");
	        $("#UpdateButtonProduct").addClass("HideThisElement");
		});
	    $("#size").change(function() 
	    {
	    	$("#GenerateSKU").removeClass("HideThisElement");
	        $("#SubmitButtonProduct").addClass("HideThisElement");
	        $("#UpdateButtonProduct").addClass("HideThisElement");
		});
	
	$("#GenerateSKU").click(function()
	{ 
    	GenerateSKU(); 
	});
	
	DropDownForProductLegend();
	
	DropDownForHSN();
	
});


//Product list
function getProductList() 
{
		spinnerOn();
	
	    var actionStr = "",
	        str = "?1=1";
	    var i = 0;
	    var url = "getProductList";
	    if (window.location.href.indexOf("showProduct") >= 0) 
	    {
	        actionStr = '<i class="edit_me fa fa-check fa-2x" aria-hidden="true"></i> ' +
	            '<i class="delete_me fa fa-trash fa-2x " aria-hidden="true"></i>';
	        i = 10;
	    } 
	    else if (window.location.href.indexOf("showGRN") >= 0) 
	    {
	    	console.log("543120");
	    	
	        actionStr = '<i class="select_me_sample select_me fa fa-check fa-2x" aria-hidden="true"></i> ';
	        i = 5;
	        str += "&listSample=y";
	    }
	    else if (window.location.href.indexOf("JSPs/Order.jsp") >= 0) 
	    {
	        actionStr = '<i class="select_me_order fa fa-check fa-2x" aria-hidden="true"></i> ';
	        i = 5;
	    }
	    else
	    {
	    	 console.log("dcfgvhb");
	    	 
	        actionStr = '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> ';
	        i = 5;
	    }

	    if (window.location.href.indexOf("SampleReturn.jsp") >= 0) {
	        url = "../../../GetStockSalesPerson";
	        str = "?1=1&spEmpid=" + $('#SalesPerson').val();
	    }

	    if (window.location.href.indexOf("showSampleTransfer") >= 0) {
	        url = "GetStockSalesPerson";
	        str = "?1=1&spEmpid=" + $('#SalesPersonF').val();
	    }
	
		$('#productListTable').DataTable().destroy();
	
		$('#productListTable thead #filterrow th').each( function () {
	    	var title = $(this).text();
	        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
	    });
		
    	$("#productListTable thead input").on('keyup change', function () {
    	    table.column($(this).parent().index() + ':visible')
    	        .search(this.value)
    	        .draw();
    	});
    	
    	 var table=$('#productListTable').DataTable({ 
    		 dom: 'Bfrtip',
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
    	 
    	 
    	 $('#productListTable tbody').off('click');
    	 
    	 $('#productListTable tbody').on( 'click', '.edit_me', function () 
    	 {
    		 var data = table.row( $(this).parents('tr') ).data();
    		 
    		 console.log(data);
    

    		 $('#editClick').click(function() 
    		 {
    			 	$("#headerName").html("Update Product");
    			 
    			 	$("#GenerateSKU").addClass("HideThisElement");
    				$("#SubmitButtonProduct").addClass("HideThisElement"); 
    			    $("#UpdateButtonProduct").removeClass("HideThisElement");
    			    $("#BackButtonProduct").removeClass("HideThisElement");	
    				$("#productListTableDiv").addClass("HideThisElement");
    				$("#productViewDiv").addClass("HideThisElement");
    				$("#productFormDiv").removeClass("HideThisElement");
    				GenerateSKU(); 
    		});
    		 
    		 $("#productListTableDiv").addClass("HideThisElement");
    		 $("#productViewDiv").removeClass("HideThisElement");
    		 $("#UpdateButtonEmployee").removeClass("HideThisElement");
    		 $("#SubmitButtonEmployee").addClass("HideThisElement");
    		 
    		 $("#BrandText").html(data.brand_txt);
    		 $("#typeText").html(data.type_txt);
    		 $("#ModelNoText").html(data.modelNo);
    		 $("#ColorText").html(data.color);
    		 $("#SizeText").html(data.size);
    		 $("#HSNIDText").html(data.hsn_text);
    		 $("#CostText").html(data.cost);
    		 $("#TagsText").html(data.tag);
    		 $("#DescriptionText").html(data.description);
    		 //$("#skuDiv").html(data.sku);
    		 
    		
    		$('#productId').val(data.rowId);
    		$('#brand').val(data.brand);  /*$('.selectpicker').selectpicker('refresh');*/
	        $('#brandText').val(data.brand_text); $('#brandAbbr').val(data.brandAbbr);
		    $('#modelNo').val(data.modelNo);	$('#size').val(data.size);  $('#cost').val(data.cost); $('#MRP').val(data.mrp);
		    $('#color').val(data.color);	$('#hsnId').val(data.hsnId); $('#type').val(data.type);    $('#tag').val(data.tag);  $('#description').val(data.description);
    		 
    		 $("#action").val("updateProduct");
    		 
    		 
    	 });
    	 
    	 $('#productListTable tbody').on( 'click', '.delete_me', function () 
    	 {
    		 //SwalWarning("Are You Sure Delete!"); 
    		 
    		 var data = table.row( $(this).parents('tr') ).data();
    		 
    		 console.log(data);
    		 
    		 //deleteProduct(data.rowId);
    		 
    		 SwalDelete("It will permanently deleted !",  data.rowId);
    	 });
}

function addNewProduct()
{
	 var generator = new IDGenerator();
 	 $("#productId").val("P"+generator.generate());
	$("#productListTableDiv").addClass("HideThisElement");
	$("#productFormDiv").removeClass("HideThisElement");
	$("#UpdateButtonProduct").addClass("HideThisElement");
	$("#skuDiv").html('');
	/*$("#SubmitButtonProduct").removeClass("HideThisElement");*/
	$("#action").val("insertProduct");
	$("#headerName").html("New Product");
	
}

