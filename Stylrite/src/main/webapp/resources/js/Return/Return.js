$(document).ready(function()
{
	
	  $("#expectedDeliveryDateDiv").addClass("HideThisElement");
	  $("#refNoDiv").addClass("HideThisElement");
	  $("#receivedOnAndReceivedByDiv").removeClass("HideThisElement");
		
		
	$("#addProduct").click(function()
	{
		var newHtml = "";
		
		if(validateProduct())
		{
			var generator = new IDGenerator();
			
			productId = ("P"+generator.generate());
			
			$("#productId").val(productId);
			
			var brand = $("#brand").val();
			var modelNo = $("#modelNo").val();
			var color = $("#color").val();
			var size = $("#size").val();
			var type = $("#type").val();
			var cost = $("#cost").val();
			var MRP = $("#MRP").val();
			var quantity = $("#quantity").val();
			
			var brandText = $("#brand").children("option:selected").html();
			var sku=$("#brand").children("option:selected").attr("id")+"-"+modelNo+"-"+color+"-"+size;
			var typeText = "";
			
			if(type == 200001)
			{
				typeText = "Frames";
			}
			else if(type == 200002)
			{
				typeText = "Sunglasses";
			}
			else if(type == 200003)
			{
				typeText = "Reading Frames";
			}
			
			spinnerOn();
			
			$.ajax
			({
				url:"CheckSkuExists",
				data:{brand:brand, modelNo:modelNo, color:color, size:size, rowId:$('#productId').val()},
				type:"GET",
				async:false,
				success:function(data)
				{
					if(data === 1)
					{
						spinnerOff();
						
						i="(NPD)";
						
						newHtml = '<tr id="productIdRow">'+
						'<td><input type="checkbox" value="'+$('#productId').val()+'" id="'+$('#productId').val()+'" name="' + $('#productId').val() + '"><label for="'+$('#productId').val()+'"></label></td>'+
						  '<td>'+brandText+' '+i+'</td>'+
						  '<td id="modelNoText'+productId+'">'+modelNo+'</td>'+
						  '<td id="colorText'+productId+'">'+color+'</td>'+
						  '<td id="sizeText'+productId+'">'+size+'</td>'+
						  '<td>'+typeText+'</td>'+
						  '<td><input class="form-control qty" style="width: 40%;" type="text" id="quantity'+productId+'" value = "'+quantity+'"></td>'+
						  '<td><input class="form-control cost" style="width: 40%;" type="text" id="cost'+productId+'" value = "'+cost+'"></td>'+
						  '<td><input class="form-control MRP HideThisElement" style="width: 40%;" type="text" id="MRP'+productId+'" value = "'+MRP+'"></td>'+
						  '<td id="brandText'+productId+'" class="HideThisElement">'+brand+'</td>'+
						  '<td id="typeText'+productId+'" class="HideThisElement">'+type+'</td>'+
						  '<td class="HideThisElement"><input type="checkbox"  value=""><label for="'+$('#productId').val()+'"></label></td>'+
						  '<td id="skuText'+productId+'" class="HideThisElement">'+sku+'</td>'+
						  '</tr>';
					}
					else
					{
						spinnerOff();
						
						/*({
							url:"CheckSkuIfExists",
							data:"brand="+brand+"&modelNo="+modelNo+"&color="+color+"&size="+size+"rowId="+$('#productId').val(),
							type:"GET",
							async:false,
							success:function(data1)
							{
								console.log("DSFGH");
								 console.log(data1);
							}
						});*/
						
						newHtml = '<tr id="productIdRow">'+
						'<td><input type="checkbox" value="'+$('#productId').val()+'" id="'+$('#productId').val()+'" name="' + $('#productId').val() + '"><label for="'+$('#productId').val()+'"></label></td>'+
						  '<td>'+brandText+'</td>'+
						  '<td id="modelNoText'+productId+'">'+modelNo+'</td>'+
						  '<td id="colorText'+productId+'">'+color+'</td>'+
						  '<td id="sizeText'+productId+'">'+size+'</td>'+
						  '<td>'+typeText+'</td>'+
						  '<td><input class="form-control qty" style="width: 40%;" type="text" id="quantity'+productId+'" value = "'+quantity+'"></td>'+
						  '<td><input class="form-control cost" style="width: 40%;" type="text" id="cost'+productId+'" value = "'+cost+'"></td>'+
						  '<td><input class="form-control MRP HideThisElement" style="width: 40%;" type="text" id="MRP'+productId+'" value = "'+MRP+'"></td>'+
						  '<td id="brandText'+productId+'" class="HideThisElement">'+brand+'</td>'+
						  '<td id="typeText'+productId+'" class="HideThisElement">'+type+'</td>'+
						  '<td class="HideThisElement"><input type="checkbox"  value=""><label for="'+$('#productId').val()+'"></label></td>'+
						  '<td id="skuText'+productId+'" class="HideThisElement">'+sku+'</td>'+
						  '</tr>';
					}
				}
			});
			
			document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', newHtml);
			
			$("#DeleteProduct").removeClass('HideThisElement');
			$("#submitProductGRN").removeClass('HideThisElement');
			
			 document.getElementById('brand').value = "";
			 $('#brandFrm select').selectpicker('refresh');
			 document.getElementById('modelNo').value = "";
			 document.getElementById('color').value = "";
			 document.getElementById('size').value = "";
			 document.getElementById('cost').value = "";
			 document.getElementById('type').value = "";
			 document.getElementById('quantity').value = "";
			 document.getElementById('MRP').value = "";
		}
		
	});
	
	$("#DeleteProduct").click(function()
	{
    	try 
    	{
        	var table = document.getElementById('ProductDataBody');
        	var rowCount = table.rows.length;
        	for(var i=0; i<rowCount; i++) {
        		var row = table.rows[i]; 
        		var chkbox = row.cells[0].childNodes[0]; 

        		if(null != chkbox && true == chkbox.checked) 
        		{
        			table.deleteRow(i); 
        			//calculateAmountPayable();
        			rowCount--;
        			i--;
        			//count--;
        		}
        	}
        	}catch(e) 
        	{
        		alert(e);
        	}
        return false; // avoid to execute the actual submit of the form.
    });
	
	$("#SubmitButtonReturn").click(function() 
	{
		formSubmitReturn();
	});

});

function validateProduct() 
{
	if($("#brand").val()=="")
		SwalWarning("Select Brand!");
	if($("#modelNo").val()=="")
		SwalWarning("Select Model No!");
	else if($("#color").val()=="")
		SwalWarning("Select Color!");
	else if($("#size").val()=="")
		SwalWarning("Select Size!");
	else if($("#type").val()=="")
		SwalWarning("Select Type!");
	else if($("#quantity").val()=="")
		SwalWarning("Select Quantity!");
	else if($("#cost").val()=="")
		SwalWarning("Select Cost!");
	else if($("#MRP").val()=="")
		SwalWarning("Select MRP!");
	
	else 
		return true;
}

var createBarcodeArray=[];
var returnItemArray = [];

function formSubmitReturn() 
{
	//spinnerOn();
	
	var returnVal=false;
	var barcodeArr=[];
	var generator = new IDGenerator();
	$("#returnId").val("R"+generator.generate());
		var table1 = document.getElementById('ProductDataBody');
		var rowCount = table1.rows.length; 		
		for (var i = 0; i < rowCount; i++) 
		{
		     var row = table1.rows[i]; 
		    
		     var formData="count="+i+"&"; 
		    
		     var productFormReturn="";
		    
		     formData+="clientId="+$("#selectedClientId").val()+"&contactPersonId="+$("#selectedClientContactPersonId").val()
			 +"&clientAddressId="+$("#selectedBillingAddressId").val()+"&selectedDeliveryAddressId="+$("#selectedDeliveryAddressId").val()
			 +"&ContactNumber="+$("#ContactNumber").val()+"&salesPerson="+$("#clientSalesPerson").val()+"&receivedOn="+$("#ReceivedOn").val()
			 +"&receivedBy="+$("#ReceivedBy").val()+"&"; 
			
		     for(var j=0; j<$(row.cells).length; j++)
			 {
				if(j==0)
				{
					var ProductId=$($(row.cells[j]).html()).val();
					
					productFormReturn+="brand="+$("#brandText"+ProductId).html()+"&modelNo="+$("#modelNoText"+ProductId).html()+"&color="+$("#colorText"+ProductId).html()+"&size="+$("#sizeText"+ProductId).html()+"&type="+$("#typeText"+ProductId).html()+"&qty="+$("#quantity"+ProductId).val()+"&cost="+$("#cost"+ProductId).val()+"&MRP="+$("#MRP"+ProductId).val()+"&sku="+$("#skuText"+ProductId).html()+"&";
					
					formData+="ProductId="+ProductId+"&quantity="+$("#quantity"+ProductId).val()+"&";
					
					for (var k = 0; k < $("#quantity"+ProductId).val(); k++) 
	      			{
						returnItemArray.push({"returnItemId":"RI"+generator.generate(), "rowId":$("#returnId").val(), "sku":$("#skuText"+ProductId).html(), "qty":"1"});
	      				
	      				createBarcodeArray.push({"rowId": "SRT1"+generator.generate(),"GRNNumber":$("#gRNnumber").val(), "sku":$("#skuText"+ProductId).html(), "cost":$("#cost"+ProductId).val(),"status": "101","printStatus":0});
	      			}
				}
			}
			
			if($("#quantity"+ProductId).val()=="")
			{
		        SwalMsgWarning(" <strong>Error!</strong> Product Quantity is mandatory !");
			}
			else
			{
				
				console.log(formData);
				
				console.log(productFormReturn);
				
				console.log(returnItemArray);
				
				console.log(createBarcodeArray);
				
				$.ajax({
		            type: "POST",
		            url: "returnSave",
		            data: productFormReturn+formData, 
		            async:false,
		            success: function(data)
			        {	
		            	 console.log(data);
		            	 
		            	returnVal=true;
		            	 
		            	/*if(data == 801 || data == 803)
		            	{
		            		
		            	}*/
		            }
		    	});
			}
		}
		
		if(returnVal)
		{
			var returnBarcodeVal = false;
			
			$.ajax
			({
	            type: "POST",
	            url: "returnItemSave",
	            data:{"returnItemArray":JSON.stringify(returnItemArray)}, // serializes the form's elements.
	            async:false,
	            success: function(data)
		        {	
	            	 console.log(data);
	            }
			 });
			/*$.ajax
		    ({
		        type: "POST",
		        url: "addNewChildBarcode",
		        async:false,
		        data: {"createBarcodeArray":JSON.stringify(createBarcodeArray)}, // serializes the form's elements.
		        success: function(data) 
		        {
		        	if(data == 901)
		        	{
		        		returnBarcodeVal=true;
		        	}
		        	
		        }
		    });
			
			if(returnBarcodeVal)
			{
				spinnerOff();
				
		        window.location.href="viewGRN?grnId="+$("#grnId").val();
		        SwalMsgSuccess("<strong>Success !</strong> Product(s) Received successfully ! ");
			}*/
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
