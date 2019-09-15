$(document).ready(function(){   
	$("#HomeText").text("Sample Transfer");
	$("#sampleTransferDiv").removeClass("HideThisElement");
	$("#noDiv").addClass("HideThisElement");
	DropDownForInventoryLegend();
	DropDownForEmployee("");
	$('#ProductDatatables').DataTable().destroy();
	getProductList();
	
	$('#ProductDatatables thead').on('click', '.cb', function (e) {
		console.log($(this).val());
		if($(this).prop("checked")){
			$(".cbtd").attr("checked", true);		
		}else{//console.log("df");
			$(".cbtd").attr("checked", false);
		}
	});
	
	$('#SalesPersonF').change(function() {
		 $('#ProductDatatables').DataTable().destroy();
		getProductList();
	});
	

	$("#ExportasCSV").click(function() {
		exportasCSV();
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
		else if($("#SalesPersonF").val() == "")
		{
			SwalMsgWarning("Please Select Sales Person!");
		}
		else if($("#SalesPersonT").val() == "")
		{
			SwalMsgWarning("Please Select Sales Person!");
		}
		else
		{
			$('#submitReturn').addClass("HideThisElement");
			spinnerOn();
			setTimeout(function(){ formSubmit(); }, 1000);	    	
		}
    	//return false;
	});
	
	/*$(".cbtd").change(function(){ console.log("ashhh");
		if($(this).prop("checked")){
			var html="<input type='hidden' class='cbTd1' id='cb"+$(this).attr("id").replace("cb","")+"' value='"+$(this).attr("value")+"'>";
			document.querySelector('#ViewBarcodeDiv').insertAdjacentHTML('beforeend', html);
		}
	});*/
});

function addThis(element)
{//console.log("ashhh");
	if($(element).prop("checked")){
		var html="<input type='hidden' class='cbTd1' id='cbt"+$(element).attr("id").replace("cb","")+"' value='"+$(element).attr("value")+"'>";
		document.querySelector('#ViewBarcodeDiv').insertAdjacentHTML('beforeend', html);
	}else{
		console.log($("#cbt"+$(element).attr("id").replace("cb","")));
		if($("#cbt"+$(element).attr("id").replace("cb","")))
			console.log($("#cbt"+$(element).attr("id").replace("cb","")).remove());
	}
}

function formSubmit() {
	var generator = new IDGenerator();
	var returnVal=false,returnVal1=false;
	var count = 1;
	var barcodeArr=[];
	var requisitionLogID = "RL"+generator.generate();
	var requisitionID = "R"+generator.generate();	
	var formData="";
	if($('input[name="cbtdName"]:checked').length==0){
		SwalMsgWarning("No Items selected for Sample Transfer.");
	}else{
		$(".cbtd").each(function() {
			//if($(this).prop("checked")){
				barcodeArr.push($.trim($(this).val()));
				var formData="";
				var ProductId=$(this).attr('id').replace('cbt','');
				formData+="ProductId="+ProductId+"&";
				var reqItemId="RI"+generator.generate();
				formData+="requisitionType=133&requisitionItemID="+reqItemId+
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
				var formData1="action=update&"; 
				formData1+="refid="+reqItemId+"&";
				formData1+="location="+$("#SalesPersonT").val()+"&";
				formData1+="cdRowId="+$(this).val(); 
				$.ajax({
		            type: "POST",
		            url: "../../../UpdateChildBarcodeLocation",
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
			//}
		});	
		if(returnVal1 && returnVal){
			//printBarcode(barcodeArr);
			//spinnerOff();
			SwalMsgSuccess(' <strong>Success!</strong> Sample Transferred Successfully !');
			window.location.href="../../Samples/JSPs/Sample.jsp?for=sampleListView";
		}
	}
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
    		JSONToCSVConvertor(data.data, $("#SalesPersonT").val()+'.csv', 'yes');
    	},
        complete: function() {
        	
        }
    });
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