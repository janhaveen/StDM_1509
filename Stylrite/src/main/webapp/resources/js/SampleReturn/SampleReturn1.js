$(document).ready(function() {

    $("#HomeText").text("Sample Return");
    DropDownForInventoryLegend();
    DropDownForEmployee("");
    $("#SalesPersonDiv").removeClass("HideThisElement");
    $("#OpoDiv").addClass("HideThisElement");
    $('#SampleReturnproductListTable').DataTable().destroy();
    getSampleReturnProductList();

    $('#SampleReturnproductListTable thead').on('click', '.cb', function(e) {

        var data = table.row($(this).parents('tr')).data();
        console.log("data is ", data);
        console.log($(this).val());
        if ($(this).prop("checked")) {
            $(".cbtd").attr("checked", true);
        } else { //console.log("df");
            $(".cbtd").attr("checked", false);
        }
    });

    $('#SalesPerson').change(function() {
        $('#SampleTransferproductListTable').DataTable().destroy();
        getSampleReturnProductList();
    });

    $('#submitReturn').click(function() {
        if ($("#reason").val() == "") {
            SwalWarning("Please Select Reason!");
        } else if ($("#expectedReceiptDate").val() == "") {
            SwalWarning("Please Select Expected Receipt Date!");
        } else if ($("#SalesPerson").val() == "") {
            SwalWarning("Please Select Sales Person!");
        }  else {
            //$('#submitReturn').addClass("HideThisElement");
            //spinnerOn();
            setTimeout(function() {
                formSubmit();
            }, 500);
        }
        //return false;
    });
});
function addThis(element) {
	console.log("elementis ",element);
	//console.log("ashhh");
    if ($(element).prop("checked"))
    {
        var html = "<input type='hidden' class='cbTd1' id='cbt" + $(element).attr("id").replace("cb","") + "' value='" + $(element).attr("value") + "'>";
        document.querySelector('#ViewBarcodeDiv').insertAdjacentHTML('beforeend', html);
        console.log($("#cbt" + $(element).attr("id").replace("cb", "")).remove());
    } else
    {
        console.log($("#cbt" + $(element).attr("id").replace("cb", "")));
        if ($("#cbt" + $(element).attr("id").replace("cb", "")))
            console.log($("#cbt" + $(element).attr("id").replace("cb", "")).remove());
    }
}
   function formSubmit(){
	   var generator=new IDGenerator();
	   var barcodeArr=[];
		var returnVal=false,returnVal1=false;
		var count=1;
		var requisitionLogID="RL"+generator.generate();
		var requisitionID="R"+generator.generate();
		var formData="";
		if($('input[name="cbtdName"]:checked').length==0){
			SwalWarning("No Items selected for Sample Return !");
		}
		else{
			$(".cbtd").each(function()
					{
				if($(this).prop("checked")){
					barcodeArr.push($.trim($(this).val()));
					var formData=""; 
					var ProductId=$(this).attr('id').replace('cb','');
					formData+="productId="+ProductId+"&";
					var reqItemId="RI"+generator.generate();
					formData+="requisitionType=132&requisitionItemID="+reqItemId+
					 "&requistionstatus=204&requitionItemstatus=212&remarks="+$("#remarks").val()+"&";
					formData+="requisitionID="+requisitionID+"&requisitionLogID="+requisitionLogID
					+"&reason="+$("#reason").val()+"&modeOfTransport="+$("#modeOfTransport").val()
					+"&expectedReceiptDate="+$("#expectedReceiptDate").val()+"&salesperson="+$("#SalesPerson").val()
					+"&action=insert&count="+count;
			         console.log("formdata",formData);
			       $.ajax({
				            type: "POST",
				            url: "ModifyRequisitionSampleReturn",
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
						formData1 += "productId=" + ProductId + "&";
						formData1+="barcode="+$(this).val()+"&from=102&to=101&status=101"; 
						console.log("formdata1",formData1);
						$.ajax({
				            type: "POST",
				            url: "UpdateChildBarcodeSampleReturn",
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
					 console.log("data save sucessfully");
			            spinnerOff();
			            $("#SampleReturnFormDiv").addClass('HideThisElement');
			            $("#SampleFormProductListDiv").addClass('HideThisElement');
			            $("#SampleTableDiv").removeClass("HideThisElement");
			            SwalSuccess(" Sample Transferred Successfully !");
			            getRequistionList();
				}
			}

   }
				