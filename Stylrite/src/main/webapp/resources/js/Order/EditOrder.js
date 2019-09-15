function editOrderData(data) {
	
	$("#HomeText").text("Edit Order (ID:"+data.orderId+")");
	$("#OrderTableDiv").addClass("HideThisElement");
	$("#OrderViewDiv").addClass("HideThisElement");
	$("#orderFormDiv").removeClass("HideThisElement");
	$('#ProductDataBody').html("");
	//$("#selectedClientId").val(data.);
	
	spinnerOn();
	$.ajax({
		url:"GetOrderDetails?&orderId="+data.orderId,
		type:"GET",
		success:function(data){
			$("#selectedClientId").val(data.data[0].clientid);
			
			$("#clientId").val(data.data[0].clientRowNo);
			$('#clientName').val(data.data[0].companyName);
			$("#OrderId").val(data.data[0].orderId);
			$("#updateRemarks").val(data.data[0].remarks);
			$('#selectedBillingAddressId').val(data.data[0].billingaddressid);
			$('#clientBillingAddress').html(data.data[0].bbranchName+", "+data.data[0].blocationadd+", "+data.data[0].bstate_text+", "+data.data[0].bpincode);
			
			$('#selectedDeliveryAddressId').val(data.data[0].deliveryaddressid);
			$('#clientDeliveryAddress').html(data.data[0].dbranchName+", "+data.data[0].dlocationadd+", "+data.data[0].dstate_text+", "+data.data[0].dpincode);
			
			$('#selectedClientContactPersonId').val(data.data[0].contactpersonid);
			$('#clientContactPersonName').val(data.data[0].cpname);
			$('#ContactNumber').val(data.data[0].contactNo);
			
			$("#clientSalesPerson").val(data.data[0].salesperson);
			$("#expectedDeliveryDate").val(data.data[0].expectedDeilvery);
			$("#RefNo").val(data.data[0].refno);
			
			spinnerOff();
			for (var i = 0; i < data.data.length; i++)
			{ 
				
				console.log(data.data.length);
	    	 	$('#OrderProductListDiv').removeClass("HideThisElement");
				var newHtml = '<tr id="productIdRow">'+
				  '<td><input type="checkbox" id="'+data.data[i].productId+'" name="' + data.data[i].productId + '"><label for="'+data.data[i].productId+'"></label></td>'+
				  '<td>'+data.data[i].skuid+'</td>'+
				  '<td>'+data.data[i].productInfo+'</td>'+
				  '<td>'+data.data[i].type_txt+'</td>'+
				  '<td>'+data.data[i].igst+'</td>'+
				  '<td id="stock'+$('#productId').val()+'">0</td>'+
				  '<td style="display:none;"><input type="hidden" id="tax' + data.data[i].productId + '" name="tax" value="' + data.data[i].igst + '"></td>' +
				/*  '<td style="text-align: center">'+data.data[i].availableStock+' ('+data.data[i].blocked+')</td>' +*/
				  '<td style="text-align: center"><input type="number" class="form-control itemQty" value="'+parseInt(data.data[i].quantity)+'" style="width:50px;" id="quantity' + data.data[i].productId + '"  ></td>' +
				  '<td style="text-align: center"><input type="number" class="form-control" value=' + parseFloat(data.data[i].rate).toFixed(2) + ' style="width:80px;" id="ItemRate' + data.data[i].productId + '"step="0.01" ></td>' +
				  '<td style="text-align: center"><input type="number" class="form-control" value="'+parseInt(data.data[i].discount) +'" style="width:50px;" id="ItemDiscount' + data.data[i].productId + '" name="discount" min="0" max="100" ></td>' +
				  '<td style="display:none;"><input type="hidden" id="igst1' + data.data[i].productId + '"  value="' + data.data[i].igst + '"></td>' +
				  '<td style="display:none;"><input type="hidden" id="hsnId' + data.data[i].productId + '"  value="' + data.data[i].hsnId + '"></td>' +
				  '<td style="display:none;"><input type="hidden" id="orderItemID1' + data.data[i].productId + '" name="orderItemID" value="' + data.data[i].rowId + '"></td>' +
				  '<td style="display:none;"><input type="hidden" id="oldData"  value="oldValue"></td>' +
				  '</tr>';
				document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', newHtml);				
			}
		}
	});
	$("#SubmitButtonRegister").addClass("HideThisElement");
	$("#SubmitButtonUpdate").removeClass("HideThisElement");
}