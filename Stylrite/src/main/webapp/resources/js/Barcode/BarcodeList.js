$(document).ready(function() 
{
	getBarcodeList();
	
	$("#UpdateButtonBarcode").click(function() 
    {
    		console.log("hii.........");
    		updateBarcodeData();
    });
});

function getBarcodeList()
{
	spinnerOn();
	$("#HomeText").text("Barcode List");
	$('#BarcodeDatatables thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
    });
	
    $("#BarcodeDatatables thead input").on('keyup change', function () {
        contactPersonTable.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
    
    var actionStr = "";
    if(window.location.href.indexOf("JSPs/Order.jsp")>=0)
    {
    	actionStr = '<i class="select_me_clientAdd fa fa-check fa-2x" aria-hidden="true"></i> ';
    }
    else
    {
    	actionStr = '<i class="edit_me fa fa-pencil-alt fa-2x" aria-hidden="true"></i> '+
            '<i class="delete_me fa fa-trash fa-2x " aria-hidden="true"></i>'
    }
    
	var table = $('#BarcodeDatatables').DataTable( {
        buttons: [
            /*{
                text: 'New Address',
                action: function ( e, dt, node, config ) {
                	loadBlankformAddress();
                }
            }*/
        ],dom: 'Bfrtip',
		"bLengthChange": true,
		"bServerSide": false,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "iDisplayLength":10,
        "bScrollCollapse": true,
        "deferRender": true,
		"ajax": "getChildBarcodeListData",
		"columns": [
        	 {
             	className: "center",
                 defaultContent: '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> '
             },  
			 //{ "data": "i" },
			 { "data": "rowId" },
            { "data": "skuid" },
            { "data": "productInfo" },
            { "data": "location" },
            /*{ "data": "gstNo" },*/
            { "data": "status_txt" }
        ],
        fixedColumns: true,
        "initComplete": function(settings, json) {   
        	spinnerOff();
        },
    });

	$('#BarcodeDatatables tbody').on('click', '.select_me', function() 
	{
		var data = table.row($(this).parents('tr')).data();
		console.log(data);
		$("#BarcodeTableDiv").addClass("HideThisElement");
		$("#BarcodeViewDiv").removeClass("HideThisElement");
		$('#editClick').addClass("HideThisElement");
		$("#HomeText").text("View Barcode (ID: "+data.rowId+")");
		$(".barcodePrintVal").val(data.rowId);
		/*$("#locationTextView").text(data.location);			$("#createdOnTextView").text(data.createdOn);
		$("#statusTextView").text(data.status_txt);			$("#productInfoTextView").text(data.productInfo);
		$("#GRNNumberTextView").text(data.grnnumber);		$("#SKUIdTextView").text(data.skuid);
		$("#createdByTextView").text(data.createdBy);		$("#BrandTextView").text(data.brand_text);*/
		
		$("#barcodeTextView").text(data.rowId);
		
		$("#locationTextView").text(data.location);			$("#UpdatedOnTextView").text(data.updatedOn);
  		$("#statusTextView").text(data.status_txt);			$("#productInfoTextView").text(data.productInfo);
  		$("#GRNNumberTextView").text(data.grnnumber);		$("#SKUIdTextView").text(data.sku);
  		$("#UpdatedByTextView").text(data.updatedBy);		$("#BrandTextView").text(data.brand_text);
  		$("#ModelNoTextView").text(data.modelNo);			$("#ColorTextView").text(data.color);
  		$("#SizeTextView").text(data.size);			$("#BrandTextView").text(data.brand_text);
  		$("#stockInDateTextView").text(data.stockInDateText); $("#typeTextView").text(data.type_txt);
		
		$('#editClick').click(function() 
		 {
			//$("#hrBarcode").html("Update Barcode");
			$("#barcodeTableDiv").addClass("HideThisElement");
			$("#barcodeViewDiv").addClass("HideThisElement");
			$("#barcodeFormDiv").removeClass("HideThisElement");
			
			$("#location").val(data.location);	   $("#barcodeId").val(data.rowId);
			$("#status").val(data.status);			$("#rate").val(data.rate);
			$("#GRNNumber").val(data.grnnumber);		$("#sku").val(data.skuid);
		});
		//getCommentsHistory(data.rowId, 0, 1);
	});
	$("#SubmitButtonBackFromView").click(function()
	{
		$("#BarcodeTableDiv").removeClass("HideThisElement");
		$("#BarcodeViewDiv").addClass("HideThisElement");
		
		$("#HomeText").text("Barcode List");
	});
	
	$("#BackButtonBarcodet").click(function()
	{
		$("#barcodeViewDiv").removeClass("HideThisElement");
		$("#barcodeFormDiv").addClass("HideThisElement");
		document.getElementById('insertBarcodeForm').reset();
	});
	
	$(".reprint").click(function() {
		exportasCSV();
	});
}

function exportasCSV() {
	var str="";
	$('.barcodePrintVal').each(function (i) {
		str+=",'"+$($('.barcodePrintVal')[i]).val()+"'";
	});
	
	$.ajax({
    	url:"../../../ExportBarcodeAsCSV?Barcodes="+str.substr(1,str.length),
    	type:"GET",
        headers: {  'Access-Control-Allow-Origin': '*' },
    	success:function(data){
    		console.log(JSON.parse(JSON.stringify(data.data, null, 2)), data.data);
    		JSONToCSVConvertor(data.data, $($('.barcodePrintVal')[0]).val()+'.csv', 'yes');
    	},
        complete: function() {
        	
        }
    });
}

function getCommentsHistory(rowId, start, isRefresh, e) {	
	$.ajax({
		url:"getCommentsHistory?cbId="+rowId+"&start="+start+"&limit=5",
		type:"GET",
		success:function(data){ 
			if(e)	e.preventDefault();
			if(data!=0){
				var str="";$('#lm').html('');
				if(isRefresh==1)$('#remarksDiv').html('');
				document.querySelector('#remarksDiv').insertAdjacentHTML('beforeend', data);
				//$('#remarksDiv').append(data);
				str="<div id='lm'><a href='#' onclick='getCommentsHistory(\""+rowId+"\", "+(parseInt(start)+5)+",0, "+$(this).event+");'>Load More . . .</a></div>";
				document.querySelector('#remarksDiv').insertAdjacentHTML('afterend', str);
				$(document).scrollTop($(document).height());
				if($('#remarksDiv .card:first').length>0){
			        var firstMsg = $('#remarksDiv .card:first');
			        // Store current scroll/offset
			        var curOffset = firstMsg.offset().top - $(document).scrollTop();
			        
			        // Add your new messages
			        firstMsg.before($('#remarksDiv .card').eq(5).clone());
			        firstMsg.before($('#remarksDiv .card').eq(5).clone());
			        firstMsg.before($('#remarksDiv .card').eq(5).clone());
			       
			        $(document).scrollTop(firstMsg.offset().top-curOffset);
				}    
			}else if(data==0){ 
				$('#lm').html('');
				$(document).scrollTop($(document).height());
				if($('#remarksDiv .card:first').length>0){
			        var firstMsg = $('#remarksDiv .card:first');
			        // Store current scroll/offset
			        var curOffset = firstMsg.offset().top - $(document).scrollTop();
			        
			        // Add your new messages
			        firstMsg.before($('#remarksDiv .card').eq(5).clone());
			        firstMsg.before($('#remarksDiv .card').eq(5).clone());
			        firstMsg.before($('#remarksDiv .card').eq(5).clone());
			       
			        $(document).scrollTop(firstMsg.offset().top-curOffset);
				}
			}
			/*if(e)	e.preventDefault();
			if(data!=0){
				var str="";$('#lm').html('');
				if(isRefresh==1)$('#remarksDiv').html('');
				document.querySelector('#remarksDiv').insertAdjacentHTML('beforeend', data);
				//$('#remarksDiv').append(data);
				str="<div id='lm'><a href='#' onclick='getCommentsHistory(\""+rowId+"\", "+(parseInt(start)+5)+",0, "+$(this).event+");'>Load More . . .</a></div>";
				document.querySelector('#remarksDiv').insertAdjacentHTML('afterend', str);
				$(document).scrollTop($(document).height());
				if($('#remarksDiv .card:first').length>0){
			        var firstMsg = $('#remarksDiv .card:first');
			        // Store current scroll/offset
			        var curOffset = firstMsg.offset().top - $(document).scrollTop();
			        
			        // Add your new messages
			        firstMsg.before($('#remarksDiv .card').eq(5).clone());
			        firstMsg.before($('#remarksDiv .card').eq(5).clone());
			        firstMsg.before($('#remarksDiv .card').eq(5).clone());
			       
			        $(document).scrollTop(firstMsg.offset().top-curOffset);
				}    
			}else if(data==0){ 
				$('#lm').html('');
				$(document).scrollTop($(document).height());
				if($('#remarksDiv .card:first').length>0){
			        var firstMsg = $('#remarksDiv .card:first');
			        // Store current scroll/offset
			        var curOffset = firstMsg.offset().top - $(document).scrollTop();
			        
			        // Add your new messages
			        firstMsg.before($('#remarksDiv .card').eq(5).clone());
			        firstMsg.before($('#remarksDiv .card').eq(5).clone());
			        firstMsg.before($('#remarksDiv .card').eq(5).clone());
			       
			        $(document).scrollTop(firstMsg.offset().top-curOffset);
				}
			}*/
		}
	});
}

/*function updateBarcodeData() 
{
	$.ajax
	 ({
	     type: "POST",
	     url: "barcodeUpdate",
	     data: $("#insertBarcodeForm").serialize(),
	     async:false,
	     success: function(data)
	     {
	    	 document.getElementById('insertBarcodeForm').reset();
	     		
   		   SwalSuccess("Barcode Update Successfully");
   		  
   		   getBarcodeList();
       	   
       	   $("#barcodeTableDiv").removeClass("HideThisElement");
       	  
       	   $("#barcodeFormDiv").addClass("HideThisElement");	
       	   
       	  // $('#BarcodeDatatables').DataTable().ajax.reload();
	     }
	 });
}
*/