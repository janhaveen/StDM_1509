$(document).ready(function()
{
	var sku = "";
	$("#HomeText").text("Upload GRN");
	$('#productListTable').addClass('display compact');
	
	$("#clear").click(function()
	  {
	    	$("#divId1").remove();
	  });
	
	//DropDownForProductLegend();
	
	$("#DeleteProduct").click(function() {
    	try {
        	var table = document.getElementById('ProductDataBody');
        	var rowCount = table.rows.length;
        	for(var i=0; i<rowCount; i++) {
        		var row = table.rows[i]; 
        		var chkbox = row.cells[0].childNodes[0]; 

        		if(null != chkbox && true == chkbox.checked) {
        			table.deleteRow(i); 
        			//calculateAmountPayable();
        			rowCount--;
        			i--;
        			//count--;
        		}
        	}
        	}catch(e) {
        		alert(e);
        	}
        return false; // avoid to execute the actual submit of the form.
    });
	
	$("#GenerateBarcode").click(function() {
		formSubmit();
	});
	
	$("#ExportasCSV").click(function() {
		exportasCSV();
	});
	
	$("#submitProductGRN").click(function() {
		formSubmitGRN();
	});
	
});

function validate() 
{
	/*if($("#brand").val()=="")
		SwalWarning("Select Brand!");*/
	if($("#GRNText").val()=="")
		SwalWarning("Select GRN No!");
	else if($("#PurchaseDateText").val()=="")
		SwalWarning("Select Purchase Date!");
	else if($("#VendorId").val()=="")
		SwalWarning("Select Vendor!");
	else if($("#ReceivedText").val()=="")
		SwalWarning("Select Received By!");
	else if($("#ReceiptDateText").val()=="")
		SwalWarning("Select Receipt Date !");
	else 
		return true;
}

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
	
	else 
		return true;
}


/*function genrateBarcode() 
{
	
}*/

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

function Upload() 
{
	spinnerOn();
	
	var brandarray=[];
	
        var fileUpload = document.getElementById("fileUpload");
        var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.csv|.txt)$/;
        if (regex.test(fileUpload.value.toLowerCase())) {
            if (typeof (FileReader) != "undefined") {
                var reader = new FileReader();
                reader.onload = function (e) {
                    var table = document.createElement("table");
                    //table.id="divId1";
                    table.id = "divId1";
                    var rows = e.target.result.split("\n");
                    for (var i = 0; i < rows.length; i++) {
                        
                            var cells = rows[i].split(",");
                            if (cells.length > 1) {
                                var row = table.insertRow(-1);
                                for (var j = 0; j < cells.length; j++) {
                                    var cell = row.insertCell(-1);
                                    if(i==0){
                                        cell.innerHTML ='<b>'+cells[j]+'</b>';
                                    }else{
                                        if(j==0){
                                            cell.innerHTML = cells[j];
                                        }
                                        if(j==1){ 
                                            cell.innerHTML = '<input type="text" id="brand'+i+'" style="width:130px;" value="'+cells[j]+'">';
                                            brandarray.push(cells[j]);
                                        }
                                        if(j==2){
                                            cell.innerHTML = '<input type="text" id="modal'+i+'" style="width:130px;" value="'+cells[j]+'">';                                    
                                        }
                                        if(j==3){
                                            cell.innerHTML = '<input type="text" id="color'+i+'" style="width:130px;" value='+cells[j]+'>';
                                        }
                                        if(j==4){
                                            cell.innerHTML = '<input type="text" id="size'+i+'" style="width:130px;" value="'+cells[j]+'">';
                                        }
                                       if(j==5){
                                           cell.innerHTML = '<input type="text" id="type'+i+'" style="width:110px;" value="'+cells[j]+'">';
                                        }
                                       if(j==6){
                                           cell.innerHTML = '<input type="text" id="qty'+i+'" style="width:110px;" value="'+cells[j]+'">';
                                        }
                                       if(j==7){
                                           cell.innerHTML = '<input type="text" id="cost'+i+'" style="width:110px;" value="'+cells[j]+'">';
                                        }
                                       if(j==8){
                                           cell.innerHTML = '<input type="text" id="MRP'+i+'" style="width:110px;" value="'+cells[j]+'">';
                                        }
                                    }
                                    
                                }
                            }
                        
                        
                    }
                   // $('#import').removeClass('HideThisElement');
                    $.ajax({  
                        type: "POST",
                            url: "checkbrandexist", 
                            data:"brandarray="+JSON.stringify(brandarray),
                            success: function(Data)
                            {
                            	if(Data=="true")
                            	{
                            		spinnerOff();
                            		
                            		var dvCSV = document.getElementById("dvCSV");
                                    dvCSV.innerHTML = "";
                                    dvCSV.appendChild(table);
                            	}
                            	else
                            	{
                            		  spinnerOff();
                            		
                            		  alert("Brands Not valid "+Data)
                            	}  
                                
                            }});
                    
                    
                }
                reader.readAsText(fileUpload.files[0]);
            } else {
                alert("This browser does not support HTML5.");
            }
        } else {
            alert("Please upload a valid CSV file.");
        }
    }
    
var createBarcodeArrayOfUploadGRN=[];

function formSubmitGRN() 
{
	spinnerOn();
	
	var returnVal=false;
	var generator = new IDGenerator();
	$("#grnId").val("G"+generator.generate());
	var grnFormData = "";
	var grnItemData=[];

	grnFormData+="&gRNnumber="+$("#gRNnumber").val()+"&rowId="+$("#grnId").val()+"&podate="+$("#purchaseDate").val()+"&vendorId="+$("#vendorId").val()+"&vendorCpId="+$("#vendorCpId").val()+"&vendorAddrId="+$("#vendorAddrId").val()+"&receivedBy="+$("#receivedBy").val()+"&receiptDate="+$("#receiptDate").val()+"&courierName="+$("#courierName").val()+"&LRNumber="+$("#LRNumber").val()+"&otherCharges="+$("#otherCharges").val()+"&";
	 
	 var myRows = [];
	 var i = 0;
     var $rows = $("#divId1 tr").each(function (index)
     {
         if(index !=0)
         {
             $cells = $(this).find('td');
             myRows[index] = {};
              $cells.each(function(cellIndex) 
              { 
            	  var srno;
                  if(cellIndex==0)
                  {
                	  //grnItemData.push({"count":i,"PurchaseOrderId":"PO"+generator.generate(), "ProductId":"P"+generator.generate(), "GRNItemId":"GI"+generator.generate()});
                	
             		 //formData+="gRNnumber="+$("#gRNnumber").val()+"&podate="+$("#purchaseDate").val()+"&vendorId="+$("#vendorId").val()+"&vendorCpId="+$("#vendorCpId").val()+"&vendorAddrId="+$("#vendorAddrId").val()+"&";
             		 
                      srno=$(this).html();
                      myRows[index]['srno'] = $(this).html();
                  }
                  if(cellIndex==1){
                      myRows[index]['brand'] = $("#brand"+index).val();
                  }
                  if(cellIndex==2){
                      myRows[index]['modal'] = $("#modal"+index).val();
                  }
                  if(cellIndex==3){
                      myRows[index]['color'] = $("#color"+index).val();
                  }
                  if(cellIndex==4){
                      myRows[index]['size'] = $("#size"+index).val();
                  }
                  if(cellIndex==5){
                      myRows[index]['type'] = $("#type"+index).val();
                  }
                  if(cellIndex==6)
                  {
                      myRows[index]['qty'] = $("#qty"+index).val();
                     
                      for (var i = 0; i < $("#qty"+index).val(); i++) 
                      {
                    	  createBarcodeArrayOfUploadGRN.push({"barCodeId": "SRT1"+generator.generate(),"gRNnumber":$("#gRNnumber").val(), "brand":$("#brand"+index).val(), "modelNo":$("#modal"+index).val(), "color":$("#color"+index).val(),"size":$("#size"+index).val(), "cost":$("#cost"+index).val(), "status": "101","printStatus":0});
                      }
                  }
                  if(cellIndex==7){
                      myRows[index]['cost'] = $("#cost"+index).val();
                  }
                  if(cellIndex==7){
                      myRows[index]['MRP'] = $("#MRP"+index).val();
                  }
                     myRows[index]['grnitemid'] = "GI"+generator.generate();
                     
                     myRows[index]['productId'] = "P"+generator.generate();
                });    
         }
         
         i++;
         
     });
     var myObj = {};
     myObj.myrows = myRows;
     /*alert(JSON.stringify(myObj));*/
     
     console.log(createBarcodeArrayOfUploadGRN);
     
     $.ajax
     ({  
         type: "POST",
             url: "Productcsvupload", 
             async:false,
             data:"jsonobject="+JSON.stringify(myObj)+grnFormData,
             success: function(Data)
             {
            	 console.log(Data);
            	 
            	if(Data == 601)
 	        	{
            		returnVal = true;
 	        	}
            	 
             }
     });
     
    if(returnVal)
	{
		var returnBarcodeVal = false;
		$.ajax
	    ({
	        type: "POST",
	        url: "addNewChildBarcodeOfUploadGRN",
	        async:false,
	        data: {"createBarcodeArrayOfUploadGRN":JSON.stringify(createBarcodeArrayOfUploadGRN)}, // serializes the form's elements.
	        success: function(data) 
	        {
	        	 spinnerOff();
	        	 
	        	console.log(data);
	        	
	        	if(data == 1901)
	        	{
	        		returnBarcodeVal=true;
	        	}
	        	
	        }
	    });
		
		if(returnBarcodeVal)
		{
			SwalMsgSuccess("<strong>Success !</strong> Product(s) Received successfully ! ");
	        window.location.href="viewGRN?grnId="+$("#grnId").val();
		}
	}
}