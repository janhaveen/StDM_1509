$(document).ready(function(){
	$('[data-toggle="popover"]').popover();
	$("#HomeText").text("Stock Out (Sample)");
	$('#Orderdatatables').DataTable().destroy();
	var ProductIdArr=[];
	$('#Orderdatatables thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
    });
	
    $("#Orderdatatables thead input").on('keyup change', function () {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
	spinnerOn();

	var table = $('#Orderdatatables').DataTable( {
		dom: 'Bfrtip',
        buttons: [
            /*{
                text: 'New Order',
                action: function ( e, dt, node, config ) {
                	loadBlankformForOrder();
                }
            }*/
        ],
		"bLengthChange": true,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "../../../GetStockOutListForSample?grpBy=y",
		"columns": [
        	 {
             	className: "center",
                 defaultContent: '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> '
             },
            { "data": "id" },
            { "data": "createdOn" },
            { "data": "total" },
            { "data": "createdby_txt" }
        ],        
        fixedColumns: true,
        "initComplete": function(settings, json) {     
            spinnerOff();
        }
    });
	
    $('#Orderdatatables tbody').off('click');
        
    $('#Orderdatatables tbody').on('click', '.select_me', function() {
    	spinnerOn();
    	var strOfProduct="";
    	var data = table.row($(this).parents('tr')).data();
    	$('#ProductDataBody').html('');
    	$.ajax({
    		url:"../../../GetStockOutListForSample?id="+data.id+"&status=p",
    		type:"GET",
    		aync:false,
    		success:function(data1){
    			var newHtml="";
    			if(data1.data.length>0){
    				for (var i = 0; i < data1.data.length; i++) {
    					ProductIdArr.push(data1.data[i].productId);
	    				newHtml += '<tr id="productIdRow">'+
	    							  '<td>'+(i+1)+'</td>'+
	    							  '<td>'+data1.data[i].skuid+'</td>'+
				  					  '<td>'+data1.data[i].productinfo+'</td>'+
				  					  '<td class="quantity" id="qtytd'+data1.data[i].productId+'">'+data1.data[i].quantity+'</td>'+
				  					  '<td id="ready'+data1.data[i].productId+'">0</td>'+
				  					  '<td class="HideThisElement">'+data1.data[i].productId+'</td>'+
				  					  '<td class="HideThisElement" class="orderid">'+data1.data[i].id+'</td>'+
				  					  '<td class="HideThisElement" id="oi'+data1.data[i].productId+'" class="orderitemid">'+data1.data[i].itemid+'</td>'+
				  					  '<td class="HideThisElement"><input type="hidden" class="issuesto" value="'+data1.data[i].createdBy+'"></td>'+
				  					  '<td>'+data1.data[i].availableStockInventory+'</td>'+
				  					  '<td>'+data1.data[i].availableStockSample+'</td>'+
				  					  '<td>'+data1.data[i].location+'</td>'+
				  					  //'<td><button type="button" class="btn btn-lg btn-danger" data-toggle="popover" title="Popover title"' +
				  					  //'data-content="And heres some amazing content. Its very engaging. Right?">Click to toggle popover</button></td>'+
				  					  '</tr>';
	    				strOfProduct+="'"+data1.data[i].productId+"',";
					}
    				$(function () {
  					  $('[data-toggle="popover"]').popover();
  					});
    				document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', newHtml);
    			}
    			getSalesPersonSampleTable(strOfProduct);
    		}
    	});
    	$("#OrderTableDiv").addClass("HideThisElement");
    	$("#StockOutDiv").removeClass("HideThisElement");
    });
    
    $("#BackProduct").click(function() { 
    	$("#OrderTableDiv").removeClass("HideThisElement");
    	$("#StockOutDiv").addClass("HideThisElement");
    });
    
    $("#childbarcodeIdText").keyup(function() {
    	if($("#childbarcodeIdText").val().length>=14){ 
    		/*if($("#childbarcodeIdText").val().indexOf("SRDI")<0){
    			$("#childbarcodeIdText").val("SRDI"+$("#childbarcodeIdText").val());
    		}else{*/
    			if($("#childbarcodeIdText").val().length>14){ 
    				/*$("#SelectChildModal #errorMessage").removeClass("HideThisElement");
    				$("#SelectChildModal #errorMessage").html("<b>Error!</b> Invalid Barcode!");*/
    				SwalErrorHeader("Invalid Barcode !");
    			}else{console.log("ie23");
    				$.ajax({
    					url:"../../../GetChildBarcodeList?cbId="+$("#childbarcodeIdText").val()+"&listForBarcode=y&noOut=y",
    					type:"GET",
    					async:false,
    					success:function(data){
    						if(data.data.length>0){
    							$("#SelectChildModal #errorMessage").addClass("HideThisElement");
    							if(ProductIdArr.includes(data.data[0].productId)){
    								var a=checkIfExists($("#childbarcodeIdText").val());
    								if(a!=""){
    									/*$("#StockOutDiv .successMsg").addClass("HideThisElement");
    									$("#StockOutDiv .warningMsg").addClass("HideThisElement");
    									 $("#StockOutDiv .errorMsg").removeClass("HideThisElement");
    							         $("#StockOutDiv #errorMsg").html(' <strong>Error!</strong> Barcode Scanned Already !');*/
    									SwalErrorHeader("Barcode Scanned Already !");
    								}else{
    									if(!checkQty(data.data[0].productId, data.data[0].productQty)){
    										/*$("#StockOutDiv .warningMsg").addClass("HideThisElement");
    										$("#StockOutDiv .errorMsg").addClass("HideThisElement");
    										$("#StockOutDiv .successMsg").removeClass("HideThisElement");
    								        $("#StockOutDiv #successMsg").html(' <strong>Success!</strong> Barcode Scanned!');*/
    										$("#ready"+data.data[0].productId).html((parseInt($("#ready"+data.data[0].productId).html())+1));
    										var str="<input type='hidden' id='cbIdH"+$("#oi"+data.data[0].productId).html()+"' class='cbIdH' value='"+$("#childbarcodeIdText").val()+"'>";
    										document.querySelector('#hiddenChildBarcodeDiv').insertAdjacentHTML('beforeend', str);
    										checkQty(data.data[0].productId, data.data[0].productQty);
    										$("#childbarcodeIdText").val('');
    									}
    								}
    							}else{
    								/*$("#StockOutDiv .warningMsg").removeClass("HideThisElement");
    								$("#StockOutDiv .errorMsg").addClass("HideThisElement");
    								$("#StockOutDiv .successMsg").addClass("HideThisElement");
    						        $("#StockOutDiv #warningMsg").html(' <strong>Warning!</strong> Barcode does not match!');*/
    								SwalWarningHeader("Barcode does not match !");
    							}
    							$("#childbarcodeIdText").val($("#childbarcodeIdText").val());
    							$("#SelectChildModal").modal('hide');
    						}else{
    							/*$("#SelectChildModal #errorMessage").removeClass("HideThisElement");
    							$("#SelectChildModal #errorMessage").html("<b>Error!</b> Barcode Not Found!");*/
								SwalErrorHeader("Barcode Not Found !");
    						}
    					}
    				});
    			//}
    		}
    	}
    });
    $("#findbtn").click(function() { 
		/*if($("#childbarcodeIdTextA").val().indexOf("SRDI")<0){
			$("#childbarcodeIdTextA").val("SRDI"+$("#childbarcodeIdTextA").val());
		}else{*/
			if($("#childbarcodeIdTextA").val().length>14){ 
				/*$("#SelectChildModal #errorMessage").removeClass("HideThisElement");
				$("#SelectChildModal #errorMessage").html("<b>Error!</b> Invalid Barcode!");*/
				SwalErrorHeader('Invalid Barcode !');
			}else{console.log("ie23");
				$.ajax({
					url:"../../../GetChildBarcodeList?cbId="+$("#childbarcodeIdTextA").val()+"&listForBarcode=y&noOut=y",
					type:"GET",
					async:false,
					success:function(data){
						if(data.data.length>0){
							$("#SelectChildModal #errorMessage").addClass("HideThisElement");
							if(ProductIdArr.includes(data.data[0].productId)){
								var a=checkIfExists($("#childbarcodeIdTextA").val());
								if(a!=""){
									/*$("#StockOutDiv .warningMsg").addClass("HideThisElement");
									$("#StockOutDiv .successMsg").addClass("HideThisElement");
									 $("#StockOutDiv .errorMsg").removeClass("HideThisElement");
							         $("#StockOutDiv #errorMsg").html(' <strong>Error!</strong> Barcode Scanned Already !');*/
									SwalErrorHeader('Barcode Scanned Already !');
								}else{
									if(!checkQty(data.data[0].productId, data.data[0].productQty)){
										/*$("#StockOutDiv .warningMsg").addClass("HideThisElement");
										$("#StockOutDiv .errorMsg").addClass("HideThisElement");
										$("#StockOutDiv .successMsg").removeClass("HideThisElement");
								        $("#StockOutDiv #successMsg").html(' <strong>Success!</strong> Barcode Scanned!');*/
										$("#ready"+data.data[0].productId).html((parseInt($("#ready"+data.data[0].productId).html())+1));
										var str="<input type='hidden' id='cbIdH"+$("#oi"+data.data[0].productId).html()+"' class='cbIdH' value='"+$("#childbarcodeIdTextA").val()+"'>";
										document.querySelector('#hiddenChildBarcodeDiv').insertAdjacentHTML('beforeend', str);
										checkQty(data.data[0].productId, data.data[0].productQty);
										$("#childbarcodeIdTextA").val("");
									}
								}
							}else{
								/*$("#StockOutDiv .warningMsg").removeClass("HideThisElement");
								$("#StockOutDiv .errorMsg").addClass("HideThisElement");
								$("#StockOutDiv .successMsg").addClass("HideThisElement");
						        $("#StockOutDiv #warningMsg").html(' <strong>Warning!</strong> Barcode does not match!');*/
								SwalWarningHeader('Barcode does not match !');
							}
							$("#childbarcodeIdText").val($("#childbarcodeIdTextA").val());
							$("#SelectChildModal").modal('hide');
						}else{
							/*$("#SelectChildModal #errorMessage").removeClass("HideThisElement");
							$("#SelectChildModal #errorMessage").html("<b>Error!</b> Barcode Not Found!");*/
							SwalErrorHeader('Barcode Not Found !');
						}
					}
				});
			//}
		}
	});
    
    $("#submitStockOut").click(function() { 
    	var generator = new IDGenerator();
    	var returnval1=false, returnval2=false;
		var table1 = document.getElementById('ProductData');
		var rowCount = table1.rows.length;
		   var formData="";
		   $(".cbIdH").each(function(i) {
	        	$.ajax({
	        		url:"../../../UpdateChildBarcodeSample",
	        		type:"POST",
	        		async:false,
	        		data:"requisitionitemid="+$($(".cbIdH")[i]).attr('id').replace("cbIdH",'')
	        		+"&from=101&to=102&status=102"
	        		+"&barcode="+$($(".cbIdH")[i]).val()+"&location="+$(".issuesto").val(),
	        		success:function(data){
	        			if(data.indexOf("1")>=0)
	        				returnval1=true;
	        		}
	        	});
	        });
		   for (var i = 1; i < rowCount; i++){
			   formData="StockOutId=SO"+generator.generate()+"&sampleId=S"+generator.generate()+"&";
		        var row = table1.rows[i];
		        formData +="ProductId="+$(row.cells[5]).html()+"&"
		        			+"requisitionitemid="+$(row.cells[7]).html()+"&"
		        			+"quantity="+$(row.cells[4]).html()+"&"
		        			+"location="+$(".issuesto").val()+"&";
		        if($(row.cells[4]).html()>0){
		        	formData+="status=212";
		        }else{
		        	formData+="status=213";
		        }
		        //if($(row.cells[4]).html()>0){
	    			$.ajax({
		        		url:"../../../StockOutSample",
		        		type:"POST",
		        		async:false,
		        		data:formData,
		        		success:function(data){
		        			if(data.indexOf("1")>=0)
		        				returnval2=true;
		        		}
		        	});	
		        //}					
		   }
		   if(returnval1 && returnval2){
			   $("#OrderTableDiv").removeClass("HideThisElement");
			   $("#StockOutDiv").addClass("HideThisElement");
			   $('#Orderdatatables').DataTable().ajax.reload();
			   $("#OrderTableDiv .successMsg").removeClass("HideThisElement");
		       $("#OrderTableDiv #successMsg").html(' <strong>Success!</strong> Product(s) stocked out successfully !');
		   }
    });
 
});

function checkQty(productId, qty) {console.log(parseInt($("#ready"+productId).html()),parseInt(qty));
	if(parseInt($("#ready"+productId).html())>parseInt(qty)){
		$("#ready"+productId).html(qty); 
		/*$("#StockOutDiv .errorMsg").removeClass("HideThisElement");
		$("#StockOutDiv #errorMsg").html(' <strong>Error!</strong> Ready Quantity greater than actual quantity!');*/
		SwalErrorHeader("Ready Quantity greater than actual quantity! !");
		$($(".cbIdH")[$(".cbIdH").length-1]).remove();		
		return true;
	}else{
		return false;
	}
}


function checkIfExists(id) {
	var idExists = ""; 	
	$(".cbIdH").each(function(i) {console.log($($(".cbIdH")[i]).val(),(id));
		if($($(".cbIdH")[i]).val()==id && $(".cbIdH").length>0){ 
			idExists = "duplicate";
			return idExists;
		}
	});
	return idExists;
}

function checkIfExistsProduct(id) {
	var table1 = document.getElementById('ProductData');
	var rowCount = table1.rows.length;
	 var idExists = false;
     for (var i = 1; i < rowCount; i++)
     {
         var row = table1.rows[i];
         var a = $(row.cells[0]).html();
         var idToCheck = $(a).attr('id');
         if (idToCheck == id)
         {
             idExists = true;
             return idExists;
         }
     }
     return idExists;
}
