$(document).ready(function() 
{
	$("#HomeText").text("View Audit Id: "+$("#auditId").val());
	
	$("#headerName").html("Audit Details");
	
	$("#headerScanBarcode").html("Scan BarCode Details");
	
	$("#ExportasCSV").click(function() 
	{
		exportasCSV();
	});
	
	 if(window.location.href.indexOf("viewAuditListDetails")>=0)
     {
		 console.log("23456");
		 
			$.ajax
			({
				url:"getAuditViewData?auditId="+$("#auditId").val(),
				type:"GET",
				success:function(data1)
				{
					var data=data1.data[0];		
					
					 console.log(data);
					 
					$("#auditIdTextView").text(data.rowId);			$("#auditDateTextView").text(data.createdOn);
		       		$("#auditByTextView").text(data.createdBy);			$("#auditStartTimeTextView").text(data.startTime);  $("#auditeEndTimeTextView").text(data.endTime);
		       		$("#auditReasonTextView").text(data.auditReasonText); $("#remarksTextView").text(data.remarks);
		       		$("#itemsAuditedTextView").text(data.itemsAudited); $("#itemsAuditedValue").val(data.itemsAudited); 
		       		
		       		$("#itemsCorrectedTextView").text(data.itemsCorrected);
		       		$("#itemsDuplicatedTextView").text(data.itemsDuplicated);
		       		
			       	 if(window.location.href.indexOf("viewAuditListDetails")>=0)
			         {
			       		console.log("hiii");
			       		
			       		$.ajax
						({	
							url:"getAuditItemDetailsView?auditId="+$("#auditId").val(),
							type:"GET",
							success:function(data2)
							{
								var html="";
								
								if(data2.data.length>0)
								{
									for (var i = 0; i < data2.data.length; i++) 
									{
										console.log(data2.data[i]);
										
										html+='<tr id="productIdRow">'+
										  '<td>'+(i+1)+'</td>'+
										  '<td class="auditItemCls">'+data2.data[i].rowId+'</td>'+
										  '<td>'+data2.data[i].auditId+'</td>'+
										  '<td>'+data2.data[i].auditReasonText+'</td>'+
										  '<td>'+data2.data[i].barcode+'</td>'+
										  '<td>'+data2.data[i].isEdited+'</td>'+
										  '<td>'+data2.data[i].sku+'</td>'+
										  '<td>'+data2.data[i].startTime+'</td>'+
										  '<td>'+data2.data[i].endTime+'</td>'+
										  '<td>'+data2.data[i].grnnumber+'</td>'+
										  '<td>'+data2.data[i].remarks+'</td>'+
										  '</tr>';
									}
								}
								else
								{
									
								}
								
								document.querySelector('#auditItemWithBarCodeBody').insertAdjacentHTML('beforeend', html);
							}
						});
			         }
			       	 else
			       	{
			       		console.log("hello");
			       	}
		       		
				}
			});
     }
	 else
	{
		 console.log("vbjmgh");
		 

			$.ajax
			({
				url:"getAuditViewData?auditId="+$("#auditId").val()+"&section="+$("#section").val(),
				type:"GET",
				success:function(data1)
				{
					var data=data1.data[0];		
					
					 console.log(data);
					 
					$("#auditIdTextView").text(data.rowId);			$("#auditDateTextView").text(data.createdOn);
		       		$("#auditByTextView").text(data.createdBy);			$("#auditStartTimeTextView").text(data.startTime);  $("#auditeEndTimeTextView").text(data.endTime);
		       		$("#auditReasonTextView").text(data.auditReasonText); $("#remarksTextView").text(data.remarks);
		       		$("#itemsAuditedTextView").text(data.itemsAudited); $("#itemsAuditedValue").val(data.itemsAudited); 
		       		
		       		$("#itemsCorrectedTextView").text(data.itemsCorrected);
		       		$("#itemsDuplicatedTextView").text(data.itemsDuplicated);
		       		
		       		$.ajax
					({
						url:"getCurrentSectionOfBarCode?section="+$("#section").val(),
						type:"GET",
						success:function(data)
						{
							$("#totalLostItemForSectionView").text(data);
							
							$("#totalLostItem").val(data);
						}
					});
				}
			});
	}
	
       		//$("#auditListCall").val(data.rowId);
       		
	       	$("#SubmitButtonCompleteAudit").click(function() 
		      {
		    	 console.log(auditItem);
	       		
	       	 /*  $.ajax
	    	     ({
	    	    	 type: "POST",
		    	        url: "saveAuditItem",
		    	        data: {"auditItemArray":JSON.stringify(auditItem)}, // serializes the form's elements.
	    	           success: function(data)
	    	           {
	    	        	   console.log(data);
	    	           }
	    	     });*/
		    	 $.ajax
		    	    ({
		    	        type: "POST",
		    	        url: "saveAuditItem",
		    	        data: {"auditItemArray":JSON.stringify(auditItem)}, // serializes the form's elements.
		    	        success: function(data) 
		    	        {
		    	        	$.ajax
				    	     ({
				    	           type: "POST",
				    	           url: "updateItemsAuditedData",
				    	           data: {"itemsAuditedArray":JSON.stringify(itemsAuditedArray)}, // serializes the form's elements.
				    	           success: function(data)
				    	           {
				    	        	   $.ajax
				  		    	     ({
				  		    	           type: "POST",
				  		    	           url: "updateItemsCorrectedData",
				  		    	           data: {"itemsCorrectedArray":JSON.stringify(itemsCorrectedArray)}, // serializes the form's elements.
				  		    	           success: function(data)
				  		    	           {
				  		    	        	 $.ajax
				  				    	     ({
				  				    	           type: "POST",
				  				    	           url: "updateItemsDuplicatedData",
				  				    	           data: {"itemsDuplicatedArray":JSON.stringify(itemsDuplicatedArray)}, // serializes the form's elements.
				  				    	           success: function(data)
				  				    	           {
				  				    	        	 $.ajax
					  						    	    ({
					  						    	        type: "POST",
					  						    	        url: "updateIsEditedAuditItemData",
					  						    	        data: {"updateIsEditedAuditItemArray":JSON.stringify(updateIsEditedAuditItemArray)}, // serializes the form's elements.
					  						    	        success: function(data) 
					  						    	        {
					  						    	        	$.ajax
							  						    	    ({
							  						    	        type: "POST",
							  						    	        url: "isInCorrectedLocationData",
							  						    	        data: {"isInCorrectedLocationArray":JSON.stringify(isInCorrectedLocationArray)}, // serializes the form's elements.
							  						    	        success: function(data) 
							  						    	        {
							  						    	        	console.log(data);
							  						    	        	
							  						    	        	window.location.href="viewAuditListDetails?auditId="+$("#auditId").val();
							  						    	        }
							  						    	  });
					  						    	        }
					  						    	    });
				  				    	           },
				  				    	 		  error : function ()
				  				    	 		  {
				  				    	 			 console.log(data);
				  				    	 		  }
				  				    	     
				  				    	       });
				  		    	           },
				  		    	 		  error : function ()
				  		    	 		  {
				  		    	 			 console.log(data);
				  		    	 		  }
				  		    	     
				  		    	       });
				    	           },
				    	 		  error : function ()
				    	 		  {
				    	 			 console.log(data);
				    	 		  }
				    	     
				    	       });
		    	        }
		    	    });
		    	 
				  });
});


function exportasCSV() 
{
	var str="";
	$('.auditItemCls').each(function (i)
	{
		str+=",'"+$($('.auditItemCls')[i]).html()+"'";
	});
	
	$.ajax({
    	url:"exportAuditItemAsCSV?auditItem="+str.substr(1,str.length),
    	type:"GET",
        headers: {  'Access-Control-Allow-Origin': '*' },
    	success:function(data){
    		console.log(JSON.parse(JSON.stringify(data.data, null, 2)), data.data);
    		JSONToCSVConvertor(data.data, $("#auditId").val()+'.csv', 'yes');
    	},
        complete: function() {
        	
        }
    });
}
