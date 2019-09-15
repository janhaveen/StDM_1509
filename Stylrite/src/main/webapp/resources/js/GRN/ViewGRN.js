$(document).ready(function() 
{
	$("#HomeText").text("View GRN: "+$("#grnId").val());
	$("#ExportasCSV").click(function() 
	{
		exportasCSV();
	});
	
	$("#deleteBarCodeInGRN").click(function() 
	{
		deleteBarCodeInGRNData();
	});
	
	spinnerOn();
	
	$.ajax
	({
		url:"getGRNViewData?grnId="+$("#grnId").val(),
		type:"GET",
		success:function(data1)
		{
			var data=data1.data[0];		
			
			 console.log(data);
			 
			$("#GRNNumberTextView").text(data.gRNnumber); 
			$("#VendorTextView").text(data.vendorName);
			$("#ContactPersonTextView").text(data.contactPerson);
			$("#VendorAddrId").val(data.vendoraddrid);  
			$("#AddressTextView").html(data.branchName+", "+data.locationadd+", "+data.state_text+", "+data.pincode);
			$("#PurchaseDateTextView").text(data.podate);  
			$("#ReceivedByTextView").text(data.receivedBy);  
			$("#ReceiptDateTextView").text(data.receiptDate);  
			$("#CourierNameTextView").text(data.courierName);
			$("#LRTextView").text(data.lrnumber); 
			$("#OtherTextView").text(data.otherCharges);
			
				
			$.ajax
			({
				url:"getChildBarcodeList?grnId="+$("#grnId").val(),
				type:"GET",
				success:function(data2)
				{
					spinnerOff();
					
					$("#productDiv").removeClass("HideThisElement");
					
					var html="";
					
					 console.log(data2);
					 
					if(data2.data.length>0)
					{
						for (var i = 0; i < data2.data.length; i++) 
						{
							html+='<tr id="productIdRow">'+
								  '<td>'+(i+1)+'</td>'+
								  '<td>'+data2.data[i].skuid+'</td>'+
								  '<td>'+data2.data[i].productInfo+'</td>'+
								  '<td class="barcodeCls">'+data2.data[i].rowId+'</td>'+
								  '<td>'+data2.data[i].productQty+'</td>'+
								  '<td>'+data2.data[i].rate+'</td>'+
								  '</tr>';
							
							// $('#ProductViewData').DataTable();
						}
					}
					else
					{
						
					}
					document.querySelector('#ProductViewDataBody').insertAdjacentHTML('beforeend', html);
				}
			});
		}
	});
});

function exportasCSV() 
{
	spinnerOn();
	
	var str="";
	$('.barcodeCls').each(function (i) {
		str+=",'"+$($('.barcodeCls')[i]).html()+"'";
	});
	
	$.ajax({
    	url:"exportBarcodeAsCSV?barcodes="+str.substr(1,str.length),
    	type:"GET",
        headers: {  'Access-Control-Allow-Origin': '*' },
    	success:function(data)
    	{
    		spinnerOff();
    		//console.log(JSON.parse(JSON.stringify(data.data, null, 2)), data.data);
    		JSONToCSVConvertor(data.data, $("#grnId").val()+'.csv', 'yes');
    	},
        complete: function() {
        	
        }
    });
}

function deleteBarCodeInGRNData()
{
	var str="";
	$('.barcodeCls').each(function (i)
	{
		str+=",'"+$($('.barcodeCls')[i]).html()+"'";
		
		console.log(str);
	});
}