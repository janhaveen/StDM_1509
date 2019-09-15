$(document).ready(function() 
 {
    $("#SubmitButtonProduct").click(function() 
    {
    		console.log("hello.........");
    		if(validate())
    		saveProductData();
    });
    
    $("#UpdateButtonProduct").click(function() 
    {
    		console.log("hii.........");
    		if(validate())
    		updateProductData();
    });
    
    
    $("#closeBtn").click(function() 
    {
    	document.getElementById('insertEmployeeData').reset();
        $("#empFormDiv").addClass("HideThisElement");
        $("#empTableDiv").removeClass("HideThisElement");
	});
    
});

function SwalDelete(msg, rowId) 
{
	swal
	({
		  title: 'Are you sure?',
		  text: msg,
		  type: 'warning',
		  showCancelButton: true,
		  confirmButtonText: 'Yes, delete it!',
		  cancelButtonText: 'No !'
		}).then(function() {
		  swal(
			'Deleted!',
			'Your file has been deleted.',
			'success'
		  );
		  deleteProduct(rowId);
		}, function(dismiss)
		{
		  if (dismiss === 'cancel')
		  {
		    swal(
		      'Ok',
		      'Cancelled !',
		      'error'
		    )
		  }
	});
}

function deleteProduct(rowId)
{
	spinnerOn();
	
	$.ajax
    ({
          type: "POST",
          url: "productDelete?rowId="+rowId,
          data: $(this).serialize(), // serializes the form's elements.
          success: function(data)
          {
        	  if(data == 501)
       	      {
       		    spinnerOff();
       		   
       		    getProductList();
       		 }
          },
		  error : function ()
		  {
			  
		  }
    
      });
}

function GenerateSKU()
{
	var SkuData=[];	
	if ($("#brand select").val() == "") 
	{ 
		SwalWarning("Select Brand!");
	} 
	else if (document.getElementById("modelNo").value == "") 
	{
		SwalWarning("Select Model No!");
	}
	else if (document.getElementById("color").value == "")
	{ 
		SwalWarning("Select Color!");
		
	}
	else if(document.getElementById("size").value == "")
	{
		SwalWarning("Select Size!");
	}
	else
	{
		var str = document.getElementById("color").value;
		var str1 = document.getElementById("size").value;
		var res = str.split(",");	var res1 = str1.split(",");	
		var sku="";
		for (var i = 0; i < res.length; i++) 
		{
			for (var j = 0; j < res1.length; j++) 
			{
				
				sku= $("#brandFrm select").children(":selected").attr("id")+"-"+document.getElementById("modelNo").value+"-"+$.trim(res[i])+"-"+$.trim(res1[j]);
				//SkuData.push({sku:sku, color:$.trim(res[i]), size:$.trim(res1[j])});
				
				$.ajax({
					url:"CheckSkuExists",
					data:{brand:$("#brand").val(), modelNo:$("#modelNo").val(), color:$.trim(res[i]), size:$.trim(res1[j]), action:$("#action").val(), rowId:$('#productId').val()},
					type:"GET",
					 async:false,
					success:function(data)
					{ 
						if(data == 1)
						{
							console.log(data);
							
							sku= $("#brandFrm select").children(":selected").attr("id")+"-"+document.getElementById("modelNo").value+"-"+$.trim(res[i])+"-"+$.trim(res1[j]);
							SkuData.push({sku:sku, color:$.trim(res[i]), size:$.trim(res1[j])});
						}
						else
						{
							console.log(data);
							
							SwalWarning(" Product already exists !");
						}
					}
				});
				
				
			}			
		}		
		$("#skuDiv").html('');
		console.log(SkuData);
		if(SkuData.length>0)
		{
			var skuDiv="<label>Sku ID</label><div class='form-row'>";
			for (var i = 0; i < SkuData.length; i++) 
			{ 
				skuDiv+="<div class='col-md-3'><div class='custom-control custom-checkbox skuDi'>"+
				  		"<input type='checkbox' checked class='custom-control-input sku' id='customCheck"+i+"' value='"+SkuData[i].color+"'>"+
				  		"<input type='hidden' class='custom-control-input size' id='customCheck"+i+"' value='"+SkuData[i].size+"'>"+
				  		"<input type='hidden' class='custom-control-input skuVal' id='customCheck"+i+"' value='"+SkuData[i].sku+"'>"+
				  		"<label class='custom-control-label' for='customCheck"+i+"'>"+SkuData[i].sku+"</label>"+
				  		"</div></div>";
			}
			skuDiv+="</div>";
			document.querySelector('#skuDiv').insertAdjacentHTML('beforeend', skuDiv);
			$("#GenerateSKU").addClass("HideThisElement");
			if($("#action").val().indexOf("insertProduct")>=0)
				$("#SubmitButtonProduct").removeClass("HideThisElement");
			else $("#UpdateButtonProduct").removeClass("HideThisElement");
		}
		else
		{
			/*document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Product  already exists !";
			$("#alertMessage").removeClass("HideThisElement");*/
			//SwalWarning(" Product  already exists !");
		}
		
		
	}
}



//Product Save Function
function saveProductData() 
{
	spinnerOn();
	
	if ($('.sku:checked').length>0) 
	{
		var pid="";
		
		var generator = new IDGenerator();
	    for (var j = 0; j < $('.sku:checked').length; j++) 
	    {
	    	var sizeStr = document.getElementById("size").value;
			var sizeStrArray = sizeStr.split(",");
			//$("#size").attr("disabled", true);
			//for (var i = 0; i < sizeStrArray.length; i++) {
				/*$.ajax({
					url:"../../../CheckSkuExists",
					data:{brand:$("#brandFrm select").val(), model:$("#modelNo").val(), color:$($('.sku')[j]).val(), size:$($('.size')[j]).val(), action:$("#action").val()},
					type:"GET",
					 async:false,
					success:function(data){ */
							if($("#action").val().indexOf("insertProduct")>=0)
							{
								$("#productId").attr("disabled", true);
								
								pid="P"+generator.generate();
							}
							$.ajax
							({
					            type: "POST",
					            url: "productSave",
					            data: $("#insertProductForm").serialize()+"&size1="+$.trim($($('.size')[j]).val())+"&rowId="+pid+"&color1="+$($('.sku')[j]).val()+"&sku="+$.trim($($('.skuVal')[j]).val()), 
					            async:false,// serializes the form's elements.
					            success: function(data)
					            {
					            	console.log(data);
					            	
					            	successMsg=true;
					            }
							});
							
	    }
	    
	    if (successMsg) 
	    {
	    	  spinnerOff();
     		   
     		   document.getElementById('insertProductForm').reset();
     		
     		   SwalSuccess("Product Saved Successfully");
     		  
     		   getProductList();
         	   
         	   $("#productListTableDiv").removeClass("HideThisElement");
         	  
         	   $("#productFormDiv").addClass("HideThisElement");	
         	   
			   $('#ProductDatatables').DataTable().ajax.reload();	
		}
	    
	}
}

//Product Update Function
function updateProductData()
{
	spinnerOn();
	
	if ($('.sku:checked').length>0) 
	{
		var pid="";
		
		var generator = new IDGenerator();
	    for (var j = 0; j < $('.sku:checked').length; j++) 
	    {
	
			$.ajax
			 ({
			     type: "POST",
			     url: "productUpdate",
			     data: $("#insertProductForm").serialize()+"&size1="+$.trim($($('.size')[j]).val())+"&color1="+$($('.sku')[j]).val()+"&sku="+$.trim($($('.skuVal')[j]).val()),
			     async:false,
			     success: function(data)
			      {
			    	if(data == 401)
		       		{
		       		   spinnerOff();
		       		   
		       		   document.getElementById('insertProductForm').reset();
		       		
		       		   SwalSuccess("Product Updated Successfully");
		       		  
		       		   getProductList();
		           	   
		           	   $("#productListTableDiv").removeClass("HideThisElement");
		           	   $("#productFormDiv").addClass("HideThisElement");
		       		}
			    	 
			    	 console.log(data);
			      }
			 });
	    }
	}
}

function validate() 
{
	/*if($("#brand").val()=="")
		SwalWarning("Select Brand!");*/
	if($("#modelNo").val()=="")
		SwalWarning("Select Model No!");
	else if($("#color").val()=="")
		SwalWarning("Select Color!");
	else if($("#size").val()=="")
		SwalWarning("Select Size!");
	else if($("#hsnId").val()=="")
		SwalWarning("Select HSN Id!");
	else if($("#cost").val()=="")
		SwalWarning("Select Cost!");
	else if($("#MRP").val()=="")
		SwalWarning("Select MRP!");
	else if($("#type").val()=="")
		SwalWarning("Select Type!");
	else 
		return true;
}