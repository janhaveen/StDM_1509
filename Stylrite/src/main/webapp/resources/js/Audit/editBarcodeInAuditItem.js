var scanBarcodeDataAraay = [];
var barcodeInfoInScanBarcodeArray = [];
var statusOfBarCodeInfo = "No";
$(document).ready(function()
{
	DropDownForProductLegend();
	
	dropdownFunctionForBarcodeLegend();
	
	// Scan the Bar code
	$("#barcode").focusout(function() 
	{
		var barcode = $("#barcode").val();
		
		if(scanBarcodeDataAraay.length == 0 && barcode.length > 10)
		{
			//ckeckSectionOfBarcode(barcode, $("#section").val());
			
			scanBarcode(barcode);
		}
		else if(barcode.length > 10)
		{
			 var checkBarcode = checkBarcodeIfExists(scanBarcodeDataAraay, barcode);
			 
			if(checkBarcode)
			{
				SwalBarcodeAlreadyExist("Barcode Already Scanned!", barcode);
				
				console.log(checkBarcode+".........checkBarcode....true");
			}
			else
			{
				console.log(checkBarcode+".........checkBarcode....false");
				
				//ckeckSectionOfBarcode(barcode, $("#section").val());

				$("#editClickInBarCodeEdit").removeClass("HideThisElement");
				
				scanBarcode(barcode);
				
				console.log(scanBarcodeDataAraay);
			}
		}
	});
	
	$('#editClick').click(function() 
			 {
     			spinnerOn();
     			
     			var generator = new IDGenerator();
     			
     			$.ajax
     		    ({
     		    	  type:"GET",
     		    	  url:"getProductOfScanBarcode?sku="+$("#currentSkuId").val(),
     		    	  data:$(this).serialize(),  // serializes the form's elements.
     		          success: function(data)
     		          {
     		        	 spinnerOff();
     		        	 
     		        	dataOfProduct = data.data[0];
     		        	
     		        	console.log(data.data.length);
     		        	
     		        	console.log(dataOfProduct);
     		        	
       				$("#barcodeFormDiv").removeClass("HideThisElement");
       				
       	    		$('#brand').val(dataOfProduct.brand);  $('.selectpicker').selectpicker('refresh');
       		        $('#brandText').val(dataOfProduct.brand_text); //$('#brandAbbr').val(data.brandAbbr);
       			    $('#modelNo').val(dataOfProduct.modelNo);	$('#size').val(dataOfProduct.size);  $('#cost').val($('#currentRate').val());
       			    $("#location").val($('#currentLocation').val());	
       			    $('#color').val(dataOfProduct.color);	 $('#type').val(dataOfProduct.type);  $("#status").val($('#currentStatusText').val());
       			    
       			    $('#oldSkuId').val(dataOfProduct.sku);
       			    
       			    $("#UpdateButtonBarcode").click(function() 
			    	    {
       			    
       					productId = ("P"+generator.generate());
       					
       					$("#productId").val(productId);
       					
       			    	var skuText = $("#brand").children("option:selected").attr("id")+"-"+$('#modelNo').val()+"-"+$('#color').val()+"-"+$('#size').val();
           				
       			    	console.log(skuText);
       			    	
       			    	 checkProductIfExistsOrNot(skuText, $("#auditItemId").val());
       			    	 
			    	    });
       			    
     		          }
     		    });
			});

});

//var itemsDuplicatedBarcode = false;

//Check if Item is already scanned
function checkBarcodeIfExists(barcodeArray, barcodeValue) 
{
	var returnBarcodeValue = false;
	
	for (var i = 0; i < barcodeArray.length; i++) 
	{
		if(barcodeArray[i].barcode == barcodeValue)
		{
			console.log("checkBarcodeIfExists");
		
			console.log(barcodeArray[i].barcode,  barcodeValue);
			
			returnBarcodeValue = true;
			
			//itemsDuplicatedBarcode = true;
		}
	}
	
	return returnBarcodeValue;
}

/*------------------------------------------BarCode Already Scanned Start-----------------------------------------------------------------*/

var itemsDuplicated = 0;

var itemsDuplicatedArray = [];


function SwalBarcodeAlreadyExist(msg, barcode) 
{
	swal
	({
		 // title: 'Add New Product and Update Barcode?',
		  text: msg,
		  type: 'warning',
		  showCancelButton: true,
		  confirmButtonText: 'Proceed !',
		  cancelButtonText: 'Cancel !'
		}).then(function()
		 {
		  swal(
			'Barcode Scanned Successfully!',
			'Your data has been Added.',
			'success'
		  );
		  
		  $("#editClickInBarCodeEdit").addClass("HideThisElement");
		  
		  scanBarcode(barcode);
		  
		  itemsDuplicated = itemsDuplicated + 1;
		  
		  $("#itemsDuplicatedTextView").text(itemsDuplicated);
	    	
	      $("#itemsDuplicatedValue").val(itemsDuplicated);
	      
	      itemsDuplicatedArray.push({"auditId":$("#auditId").val(), "itemsDuplicatedValue":$("#itemsDuplicatedValue").val()});
	    	
	      console.log("itemsDuplicatedArray..........",itemsDuplicatedArray);
	      
	        $("#totalLostItem").val(parseInt($("#totalLostItem").val()) + 1);
	      
    		$("#totalLostItemForSectionView").text($("#totalLostItem").val());
    		
	    
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

/*------------------------------------------BarCode Already Scanned End-----------------------------------------------------------------*/

var auditItem=[];

var itemsAudited = 0;

var itemsAuditedArray = [];

var itemsCorrected = 0;

var itemsCorrectedArray = [];

var updateIsEditedAuditItemArray = [];

var dataOfProduct;

var auditItemId;

var totalBarcodeForCurrentSection = 0;

//Scan Barcode
function scanBarcode(barcode) 
{
	var generator = new IDGenerator();
	
	var html="";
	
	spinnerOn();
	
	$.ajax
    ({
    	  type:"GET",
    	  url:"checkScanBarcode?barcode="+barcode,
    	  data:$(this).serialize(),  // serializes the form's elements.
          success: function(data)
          {
        	  if(data.data.length>0)
        	  {
        		  spinnerOff();
        		  
        		  if($("#section").val() == data.data[0].section)
        		  {
        			  console.log("correted");
        			  
        			  $("#barcodeFormDiv").addClass("HideThisElement");
        			  
        			  $("#barcodeListTableInScanBarCode").removeClass("HideThisElement");
        			  
        			  //$("#editClickInBarCodeEdit").removeClass("HideThisElement");
            		  
            		  scanBarcodeDataAraay.push({"barcode": barcode, "auditId":$("#auditId").val()});
            		  
            		  dataOfProduct = "";
            		  
            		  var checkBarCodeData = data.data[0];
            		  
            		  console.log(data.data[0]);
            		  
            		  $("#BarcodeViewDiv").removeClass("HideThisElement");
                	  $("#SubmitButtonBackFromView").addClass("HideThisElement");
                	  
                	  $("#SubmitButtonCompleteAudit").removeClass("HideThisElement");
                	  
                	  $('#currentLocation').val(data.data[0].location);
                	  
                	  $('#currentStatusText').val(data.data[0].status);
                	  
                	  $('#currentRate').val(data.data[0].rate);
                	  
                	  $('#barcodeId').val(barcode);
                	  
                	$("#barcodeTextView").text(barcode);	
                	
                	$("#locationTextView").text(data.data[0].location);			$("#UpdatedOnTextView").text(data.data[0].updatedOn);
              		$("#statusTextView").text(data.data[0].status_txt);			$("#productInfoTextView").text(data.data[0].productInfo);
              		$("#GRNNumberTextView").text(data.data[0].grnnumber);		$("#SKUIdTextView").text(data.data[0].sku);
              		$("#UpdatedByTextView").text(data.data[0].updatedBy);		$("#BrandTextView").text(data.data[0].brand_text);
              		$("#ModelNoTextView").text(data.data[0].modelNo);			$("#ColorTextView").text(data.data[0].color);
              		$("#SizeTextView").text(data.data[0].size);			$("#BrandTextView").text(data.data[0].brand_text);
              		$("#stockInDateTextView").text(data.data[0].stockInDateText); $("#typeTextView").text(data.data[0].type_txt);
              		
              		if(data.data[0].stockOutDateText == null)
              		{
              			$("#stockOutDateTextView").text("-");
              		}
              		else
              		{
              			$("#stockOutDateTextView").text(data.data[0].stockOutDateText);
              		}
              		
              		$('#oldProductId').val(data.data[0].productId);
              		
              		$('#oldGrnNumber').val(data.data[0].grnnumber);
              		
              		$('#oldLocation').val(data.data[0].location);
              		
              		$('#oldStatus').val(data.data[0].status);
              		
              		$('#oldType').val(data.data[0].type);
              		
              		$('#currentSection').val(data.data[0].section);
              		
              		itemsAudited = itemsAudited + 1;
              		
              		$("#itemsAuditedTextView").text(itemsAudited);
              		
              		$("#itemsAuditedValue").val(itemsAudited);
              		
              		itemsAuditedArray.push({"auditId":$("#auditId").val(), "itemsAuditedValue":$("#itemsAuditedValue").val()});
              		
              		$("#currentSkuId").val(data.data[0].sku);
              		
          			totalBarcodeForCurrentSection = $("#totalLostItem").val() - 1;
              		
              		$("#totalLostItemForSectionView").text(totalBarcodeForCurrentSection);
              		
              		$("#totalLostItem").val(totalBarcodeForCurrentSection);
              		
              		auditItemId = ("AI"+generator.generate());
					
    				$("#auditItemId").val(auditItemId);
    		    		
    		    	auditItem.push({"barcode": barcode, "auditId":$("#auditId").val(), "rowId":$("#auditItemId").val(), "totalLostItem":$("#totalLostItem").val(), "sku":data.data[0].sku});
    		    	
    		    	barcodeInfoInSacnBarcode(itemsAudited, barcode, statusOfBarCodeInfo, data.data[0].sku, data.data[0].location);
              		
    		    	$("#barcode").val("");
    		    	
        		  }
        		  else
        		  {
        			  console.log("In correted");
        			  
        			  SwalCheckSection("Section Is InCorrect !", data.data[0].section , barcode, data);
        		  }
        		  
        	  }
        	  else
        	  {
        		  spinnerOff();
        		  
        		  $("#barcodeViewDiv").addClass("HideThisElement");
        		  
        		  SwalError("Invalid Barcode !");
			  }
          }
    });
}

//checkProductIfExistsOrNot
function checkProductIfExistsOrNot(skuText, auditItemIdCurrentId) 
{
	console.log(skuText, auditItemIdCurrentId)
	
	$.ajax
	 ({
	     type: "POST",
	     url: "checkProductIfExistsOrNot",
	     data: "productIdText="+$("#productId").val()+"&barcodeIdText="+$('#barcodeId').val()+"&status="+$("#status").val()+"&barndText="+$("#brand").val()+"&modelNo="+$('#modelNo').val()+"&color="+$('#color').val()+"&size="+$('#size').val()+"&type="+$('#type').val()+"&cost="+$('#cost').val()+"&sku="+skuText+"&location="+$("#location").val(),
	     async:false,
	     success: function(data)
	     {
	    	 console.log(data);
	    	 
	        //New Product In Scan Barcode
	    	if(data == 1501)
	    	{
	    		 SwalAddNewProductAndUpdateBarCode("Are You Sure New Product !",  $("#productId").val(), $('#barcodeId').val(), $("#status").val(), $("#brand").val(), $('#modelNo').val(), $('#color').val(), $('#size').val(), $('#type').val(), $('#cost').val(), skuText, $("#location").val(), $('#oldSkuId').val(),  $('#oldLocation').val(), $('#oldStatus').val(),  $('#oldGrnNumber').val(), $('#oldType').val(), auditItemIdCurrentId);
	    	}
	    	else if(data == 1502)
	    	{
	    		SwalUpdateBarCode("If Product doesn't exist !",  $("#oldProductId").val(), $('#barcodeId').val(), $("#status").val(), $("#brand").val(), $('#modelNo').val(), $('#color').val(), $('#size').val(), $('#type').val(), $('#cost').val(), skuText, $("#location").val(), $('#oldLocation').val(), $('#oldStatus').val(), $('#oldGrnNumber').val(), $('#oldType').val(), auditItemIdCurrentId);
	    	}
	     }
	 });
}

/*------------------------------------------New Product and Update Barcode Start-----------------------------------------------------------------*/

//New Product and Update Barcode Data In Scan Barcode (Swal)
function SwalAddNewProductAndUpdateBarCode(msg, productId, barcodeId, status, brand, modelNo, color, size, type, cost, skuText, location, oldSku, oldLocation, oldStatus, oldGrnNumber, oldType,  auditItemIdCurrentId) 
{
	swal
	({
		 // title: 'Add New Product and Update Barcode?',
		  text: msg,
		  type: 'success',
		  showCancelButton: true,
		  confirmButtonText: 'Yes, Update!',
		  cancelButtonText: 'No !'
		}).then(function()
		 {
		  swal(
			'Add New Product and Update Barcode!',
			'Your data has been Added.',
			'success'
		  );
		  addNewProductAndUpdateBarcodeData(productId, barcodeId, status, brand, modelNo, color, size, type, cost, skuText, location, oldSku, oldLocation, oldStatus, oldGrnNumber, oldType, auditItemIdCurrentId);
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

//New Product and Update Barcode Data In Scan Barcode (function)
function addNewProductAndUpdateBarcodeData(productId, barcodeId, status, brand, modelNo, color, size, type, cost, skuText, location, oldSku, oldLocation, oldStatus, oldGrnNumber, oldType, auditItemIdCurrentId)
{
	//getEditBarCodeLogHistory(barcodeId, 0, 1);
	
	$.ajax
    ({
          type: "POST",
          url: "addNewProductAndUpdateBarcodeData",
          data: "productIdText="+productId+"&barcodeIdText="+barcodeId+"&status="+status+"&barndText="+brand+"&modelNo="+modelNo+"&color="+color+"&size="+size+"&type="+type+"&cost="+cost+"&sku="+skuText+"&location="+location+"&oldSku="+oldSku+"&gRNnumber="+oldGrnNumber+"&oldLocation="+oldLocation+"&oldStatus="+oldStatus+"&oldType="+oldType+"&auditItemIdCurrentId="+auditItemIdCurrentId, // serializes the form's elements.
          async:false,
          success: function(data)
          {
        	  console.log(data);
        	  
        	if(data == 1601 || data == 1603 || data == 1605 || data == 1607)
  	    	{
        		$("#barcodeFormDiv").addClass("HideThisElement");
        		
        		$("#barcodeViewDiv").addClass("HideThisElement");
        		
        		itemsCorrected = itemsCorrected  + 1;
		    	
		    	$("#itemsCorrectedTextView").text(itemsCorrected);
		    	
		    	$("#itemsCorrectedValue").val(itemsCorrected);
		    	
		    	itemsCorrectedArray.push({"auditId":$("#auditId").val(), "itemsCorrectedValue":$("#itemsCorrectedValue").val()});
		    	
		    	console.log("itemsCorrectedArray..........",itemsCorrectedArray);
		    	
		    	updateIsEditedAuditItemArray.push({"auditItemIdCurrentId":auditItemIdCurrentId, "barcode": barcodeId, "auditId":$("#auditId").val(),"isEdited":"1"});
		    	
		    	console.log("updateIsEditedAuditItemArray..........",updateIsEditedAuditItemArray);
		    	
		    	
		    	
		    	//scanBarcode(barcodeId);
		    	
  	    	}
        	else
        	{
        		
        	}
          },
		  error : function ()
		  {
			  
		  }
    
      });
}

/*------------------------------------------New Product and Update Barcode End-----------------------------------------------------------------*/


/*------------------------------------------Update Barcode Start-----------------------------------------------------------------*/

//Update Barcode Data In Scan Barcode (Swal)
function SwalUpdateBarCode(msg, productId, barcodeId, status, brand, modelNo, color, size, type, cost, skuText, location, oldLocation, oldStatus, oldGrnNumber,oldType, auditItemIdCurrentId) 
{
	swal
	({
		  //title: 'Update Barcode?',
		  text: msg,
		  type: 'success',
		  showCancelButton: true,
		  confirmButtonText: 'Yes, Update!',
		  cancelButtonText: 'No !'
		}).then(function()
		 {
		  swal(
			'Update Barcode!',
			'Your data has been updated.',
			'success'
		  );
		  updateBarcodeWithOldProductData(productId, barcodeId, status, brand, modelNo, color, size, type, cost, skuText, location, oldLocation, oldStatus, oldGrnNumber, oldType, auditItemIdCurrentId);
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

//Update Barcode Data In Scan Barcode (function)
function updateBarcodeWithOldProductData(productId, barcodeId, status, brand, modelNo, color, size, type, cost, skuText, location, oldLocation, oldStatus, oldGrnNumber, oldType, auditItemIdCurrentId)
{
	//getEditBarCodeLogHistory(barcodeId, 0, 1);
	
	$.ajax
    ({
          type: "POST",
          url: "updateBarcodeWithOldSku",
          data: "productIdText="+productId+"&barcodeIdText="+barcodeId+"&status="+status+"&barndText="+brand+"&modelNo="+modelNo+"&color="+color+"&size="+size+"&type="+type+"&cost="+cost+"&sku="+skuText+"&location="+location+"&oldLocation="+oldLocation+"&oldStatus="+oldStatus+"&gRNnumber="+oldGrnNumber+"&oldType="+oldType+"&auditItemIdCurrentId="+auditItemIdCurrentId, // serializes the form's elements.
          async:false,
          success: function(data)
          {
        	  	/*if(data == 1701)
		    	{*/
		      	    $("#barcodeFormDiv").addClass("HideThisElement");
		      	    
		      	    $("#barcodeViewDiv").addClass("HideThisElement");
		      	    
		      	   $("#barcode").val("");
		      	   
		      	    itemsCorrected = itemsCorrected  + 1;
			    	
		      	    console.log("itemsCorrected..........",itemsCorrected);
			    	
			    	$("#itemsCorrectedTextView").text(itemsCorrected);
			    	
			    	$("#itemsCorrectedValue").val(itemsCorrected);
			    	
			    	itemsCorrectedArray.push({"auditId":$("#auditId").val(), "itemsCorrectedValue":$("#itemsCorrectedValue").val()});
			    	
			    	console.log("itemsCorrectedArray..........",itemsCorrectedArray);
			    	
			    	updateIsEditedAuditItemArray.push({"auditItemIdCurrentId":auditItemIdCurrentId, "barcode": barcodeId, "auditId":$("#auditId").val(),"isEdited":"1"});
			    	
			    	console.log("updateIsEditedAuditItemArray..........",updateIsEditedAuditItemArray);
			    	
			    	statusOfBarCodeInfo = "Yes";
			    	
			    	barcodeInfoInSacnBarcode(itemsAudited, barcodeId, statusOfBarCodeInfo, skuText, location);
			    	
			    	//scanBarcode(barcodeId);
		    	/*}
	        	else
	        	{
	        		
	        	}*/
          },
		  error : function ()
		  {
			  
		  }
    
      });
}
/*------------------------------------------Update Barcode End-----------------------------------------------------------------*/


/*------------------------------------------Edit Barcode Log History Start-----------------------------------------------------------------*/

function getEditBarCodeLogHistory(rowId, start, isRefresh, e) 
{	
	var newHtml = "";
	$.ajax({
		url:"getEditBarCodeLogHistory?rowId="+rowId+"&start="+start+"&limit=5",
		type:"GET",
		success:function(data)
		{ 
			if(e)	
			e.preventDefault();
			if(data!=0)
			{
				console.log(data);
				
				var str="";
				
				$('#lm').html('');
				
				if(isRefresh==1)
					
				$('#remarksDiv').html('');
				
				document.querySelector('#remarksDiv').insertAdjacentHTML('beforeend', data);
				
				//$('#remarksDiv').append(data);
				document.querySelector('#remarksDiv').insertAdjacentHTML('afterend', str);
				$(document).scrollTop($(document).height());
				if($('#remarksDiv .card:first').length>0)
				{
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
			else if(data==0){ 
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
			/*if(e)	
			e.preventDefault();
			if(data!=0)
			{
				var str="";$('#lm').html('');
				if(isRefresh==1)
				$('#remarksDiv').html('');
				
				for (var j = 0; j < data.data.length; j++)
				{
					console.log(j);
					
					newHtml+= "<div class='col-md-12'>"
						+"<input type='hidden' id='start' value='"+start+"'>"
						+"<div style='display:block;' class='row'>"
	        			+"<div class='card z-depth-2 col-md-12' style='float: left;margin-bottom: 2px;background-color: rgba(3, 169, 244, 0.1);padding: 1%;font-family: cursive;'>"
						+"<div style='float: left;font-family: Comic Sans MS;font-size: small;'>"+data.data[j].createdOntxt+"</div>"
						+"<div style='float: left;font-family: Comic Sans MS;padding-left: 2%;color: #656565;'>"+data.data[j].remarks+"</div>"
						+"</div></div>"
						+"</div><br>";
					
				}
				
				document.querySelector('#remarksDiv').insertAdjacentHTML('beforeend', newHtml );	
				
				//$('#remarksDiv').append(data);
				str="<div id='lm'><a href='#' onclick='getEditBarCodeLogHistory(\""+rowId+"\", "+(parseInt(start)+5)+",0, "+$(this).event+");'>Load More . . .</a></div>";
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
			}else if(data==0)
			{ 
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
/*------------------------------------------Edit Barcode Log History End-----------------------------------------------------------------*/

/*------------------------------------------Swal BarCode Is Not Present In Section Start-----------------------------------------------------------------*/

function SwalCheckSection(msg, section, barcode, data) 
{
	swal
	({
		 // title: 'Add New Product and Update Barcode?',
		  text: msg,
		  type: 'warning',
		  showCancelButton: true,
		  confirmButtonText: 'Proceed!',
		  cancelButtonText: 'Cancel !'
		}).then(function()
		 {
		  
		  scanBarcodeOfIncorrectSection(barcode,data);
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

/*------------------------------------------Swal BarCode Is Not Present In Section End-----------------------------------------------------------------*/

var isInCorrectedLocationArray = [];

/*------------------------------------------Scan BarCode Of Incorrect Section start-----------------------------------------------------------------*/
function scanBarcodeOfIncorrectSection(barcode, data)
{
	var generator = new IDGenerator();
	
	 $("#barcodeFormDiv").addClass("HideThisElement");
	 
	  $("#barcodeListTableInScanBarCode").removeClass("HideThisElement");
	  
	  scanBarcodeDataAraay.push({"barcode": barcode, "auditId":$("#auditId").val()});
	  
	  dataOfProduct = "";
	  
	  var checkBarCodeData = data.data[0];
	  
	  console.log(data.data[0]);
	  
	  $("#BarcodeViewDiv").removeClass("HideThisElement");
	  $("#SubmitButtonBackFromView").addClass("HideThisElement");
	  
	  $("#SubmitButtonCompleteAudit").removeClass("HideThisElement");
	  
	  $('#currentLocation').val(data.data[0].location);
	  
	  $('#currentStatusText').val(data.data[0].status);
	  
	  $('#currentRate').val(data.data[0].rate);
	  
	  $('#barcodeId').val(barcode);
	  
	   $("#barcodeTextView").text(barcode);	
	
	 	$("#locationTextView").text(data.data[0].location);			$("#UpdatedOnTextView").text(data.data[0].updatedOn);
		$("#statusTextView").text(data.data[0].status_txt);			$("#productInfoTextView").text(data.data[0].productInfo);
		$("#GRNNumberTextView").text(data.data[0].grnnumber);		$("#SKUIdTextView").text(data.data[0].sku);
		$("#UpdatedByTextView").text(data.data[0].updatedBy);		$("#BrandTextView").text(data.data[0].brand_text);
		$("#ModelNoTextView").text(data.data[0].modelNo);			$("#ColorTextView").text(data.data[0].color);
		$("#SizeTextView").text(data.data[0].size);			$("#BrandTextView").text(data.data[0].brand_text);
		$("#stockInDateTextView").text(data.data[0].stockInDateText); $("#typeTextView").text(data.data[0].type_txt);
		
		if(data.data[0].stockOutDateText == null)
		{
			$("#stockOutDateTextView").text("-");
		}
		else
		{
			$("#stockOutDateTextView").text(data.data[0].stockOutDateText);
		}
		
		$('#oldGrnNumber').val(data.data[0].grnnumber);
		
		$('#oldLocation').val(data.data[0].location);
		
		$('#oldStatus').val(data.data[0].status);
		
		$('#currentSection').val(data.data[0].section);
		
		itemsAudited = itemsAudited + 1;
		
		$("#itemsAuditedTextView").text(itemsAudited);
		
		$("#itemsAuditedValue").val(itemsAudited);
		
		itemsAuditedArray.push({"auditId":$("#auditId").val(), "itemsAuditedValue":$("#itemsAuditedValue").val()});
		
		auditItemId = ("AI"+generator.generate());
		
	    $("#auditItemId").val(auditItemId);
	    
	    auditItem.push({"barcode": barcode, "auditId":$("#auditId").val(), "rowId":$("#auditItemId").val(), "totalLostItem":$("#totalLostItem").val(), "sku":data.data[0].sku});

	    $("#barcode").val("");
	    
		$("#currentSkuId").val(data.data[0].sku);
		
		isInCorrectedLocationArray.push({"barcode": barcode, "auditItemIdCurrentId":$("#auditItemId").val(), "location":data.data[0].location, "isInCorrectedLocation":"1"});
		
		 console.log(isInCorrectedLocationArray);
		 
		 barcodeInfoInSacnBarcode(itemsAudited, barcode, statusOfBarCodeInfo, data.data[0].sku, data.data[0].location);
}

/*------------------------------------------Scan BarCode Of Incorrect Section End-----------------------------------------------------------------*/


function barcodeInfoInSacnBarcode(srNo, barcode, statusOfBarCodeInfo, sku, location)
{
	var html = "";
	
	html+='<tr id="productIdRow">'+
	  '<td>'+(srNo)+'</td>'+
	  '<td>'+barcode+'</td>'+
	  '<td>'+statusOfBarCodeInfo+'</td>'+
	  '<td class="barcodeCls">'+sku+'</td>'+
	  '<td>'+location+'</td>'+
	  '</tr>';
	
	document.querySelector('#addBarcodeInfoInScanBarcode').insertAdjacentHTML('afterend', html);
}