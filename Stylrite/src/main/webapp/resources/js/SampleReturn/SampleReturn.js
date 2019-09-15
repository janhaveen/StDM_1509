$(document).ready(function(){   
	$("#HomeText").text("Sample Return");
	$("#SalesPersonDiv").removeClass("HideThisElement");
	DropDownForInventoryLegend();
	DropDownForEmployee("");
	$('#ProductDatatables').DataTable().destroy();
	 getProductList();
	
	$('#ProductDatatables thead').on('click', '.cb', function (e) {
		console.log($(this).val());
		if($(this).prop("checked")){
			$(".cbtd").attr("checked", true);			
		}else{console.log("df");
			$(".cbtd").attr("checked", false);
		}
	});
	
	$('#SalesPerson').change(function() {
		 $('#ProductDatatables').DataTable().destroy();
		getProductList();
	});
	
	$('#submitReturn').click(function() {
		if($("#reason").val() == "")
		{
			SwalMsgWarning("Please Select Reason!");
		}
		else if($("#expectedReceiptDate").val() == "")
		{
			SwalMsgWarning("Please Select Expected Receipt Date!");
		}
		else if($("#SalesPerson").val() == "")
		{
			SwalMsgWarning("Please Select Sales Person!");
		}
		else
		{
	    	formSubmit(); 
		}
    	return false;
	});
	
	$("#ExportasCSV").click(function() {
		exportasCSV();
	});
});

function formSubmit() {
	var generator = new IDGenerator();
	var barcodeArr=[];
	var returnVal=false,returnVal1=false;
	var count = 1;
	var requisitionLogID = "RL"+generator.generate();
	var requisitionID = "R"+generator.generate();	
	var formData="";
	if($('input[name="cbtdName"]:checked').length==0){
		SwalMsgWarning("No Items selected for Sample Return !");
	}else{		
		$(".cbtd").each(function() {
			if($(this).prop("checked")){
		     	barcodeArr.push($.trim($(this).val()));  
				var formData=""; 
				var ProductId=$(this).attr('id').replace('cb','');
				formData+="ProductId="+ProductId+"&";
				var reqItemId="RI"+generator.generate();
				formData+="requisitionType=132&requisitionItemID="+reqItemId+
						  "&requitionstatus=204&requitionItemstatus=212&remarks="+$("#remarks").val()+"&";
	
				formData+="requisitionID="+requisitionID+"&requisitionLogID="+requisitionLogID
						+"&reason="+$("#reason").val()+"&modeOfTransport="+$("#modeOfTransport").val()
						+"&expectedReceiptDate="+$("#expectedReceiptDate").val()
						+"&remarks="+$("#remarks").val()+"&action=insert&count="+count;
				console.log(formData);
				$.ajax({
		            type: "POST",
		            url: "../../../ModifyRequisition",
		            data: formData, 
		            async:false,
		            success: function(data)
			        {
		            	if(data!="0")
		            		returnVal=true;
			     	    else
			     		  returnVal=false
		            }
		    	});
				var formData1=""; 
				formData1+="action=update"+"&";
				formData1+="requisitionitemid="+reqItemId+"&";
				formData1+="barcode="+$(this).val()+"&from=102&to=101&status=101"; 
				$.ajax({
		            type: "POST",
		            url: "../../../UpdateChildBarcodeSample",
		            data: formData1, 
		            async:false,
		            success: function(data)
			        {	
		               if(data!="0")
		            		returnVal1=true;	            
			     	   else
			     		  returnVal1=false
			     	
		            }
		    	});
				count++;
			}
		});	
		if(returnVal1 && returnVal){
			//printBarcode(barcodeArr);
			//window.location.href="../../Samples/JSPs/Sample.jsp?for=sampleListView";
			SwalMsgSuccess(' <strong>Success!</strong> Sample Returned Successfully !');
			window.location.href="../../Samples/JSPs/Sample.jsp?for=sampleListView";
		}
	}
}

function SwalMsgWarning(msg)
{
	swal({
		  html: msg,
		  type: "warning",
		  confirmButtonText: "Ok!",
		  closeOnConfirm: false
		});
}
function SwalMsgSuccess(msg)
{
	swal({
		  html: msg,
		  type: "success",
		  confirmButtonText: "Ok!",
		  closeOnConfirm: false
		});
}
function SwalMsgError(msg)
{
	swal({
		  html: msg,
		  type: "error",
		  confirmButtonText: "Ok!",
		  closeOnConfirm: false
		});
}

function printBarcode(barArray){ 
	$("#GeneratedChildBarcodeDiv").html('');
	var html="<div class='row'>";
	for (var i = 0; i < barArray.length; i++) {
			html+=
				"<div class='col-md-4' style='border: 1px solid;'>" +
				"<p  class='brcd' style='font-size:30px;'>"+barArray[i]+"</p>"+
				"<input type='hidden' class='barcodePrintVal' value='"+barArray[i]+"'>"+
				"</div>";
	}
	html+="</div>";
	document.querySelector('#GeneratedChildBarcodeDiv').insertAdjacentHTML('beforeend', html);
	$("#ViewBarcodeDiv").removeClass("HideThisElement");
	$("#ViewBarcodeDiv .successMsg").removeClass("HideThisElement");
	$("#ViewBarcodeDiv #successMsg").html(' <strong>Success!</strong> Sample Returned Successfully !');	
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
    		JSONToCSVConvertor(data.data, $("#SalesPerson").val()+'.csv', 'yes');
    	},
        complete: function() {
        	
        }
    });
}