$(document).ready(function() {
    $("#HomeText").text("Sample Transfer");

    $("#sampleTransferDiv").removeClass("HideThisElement");
    $("#noDiv").addClass("HideThisElement");
    DropDownForInventoryLegend();
    DropDownForEmployee("");
    $('#SampleTransferproductListTable').DataTable().destroy();
    getSampleTransferProductList();
    $("#OpoDiv").addClass("HideThisElement");
/*
    var table = $('#SampleTransferproductListTable').dataTable();
    table.on('click', '.cb', function(e) {*/
/*    $('thead input[name="select_all"]', table.table().container()).on('click', function(e){*/
   $('#SampleTransferproductListTable thead').on('click', '.cb', function(e) {
    	
        var data = table.row($(this).parents('tr')).data();
        console.log("data is ", data);
        console.log($(this).val());
        if ($(this).prop("checked")) {
            $(".cbtd").attr("checked", true);
        } else { //console.log("df");
            $(".cbtd").attr("checked", false);
        }
    });

    $('#SalesPersonF').change(function() {
        $('#SampleTransferproductListTable').DataTable().destroy();
        getSampleTransferProductList();
    });

    $('#submitReturn').click(function() {
        if ($("#reason").val() == "") {
            SwalWarning("Please Select Reason!");
        } else if ($("#expectedReceiptDate").val() == "") {
            SwalWarning("Please Select Expected Receipt Date!");
        } else if ($("#SalesPersonF").val() == "") {
            SwalWarning("Please Select Sales Person!");
        } else if ($("#SalesPersonT").val() == "") {
            SwalWarning("Please Select Sales Person!");
        } else {
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
	console.log("element",element);
	//console.log("ashhh");
    if ($(element).prop("checked")) {
        var html = "<input type='hidden' class='cbTd1' id='cbt" + $(element).attr("id").replace("cb","") + "' value='" + $(element).attr("value") + "'>";
        document.querySelector('#ViewBarcodeDiv').insertAdjacentHTML('beforeend', html);
        console.log($("#cbt" + $(element).attr("id").replace("cb", "")).remove());
    } else {
        console.log($("#cbt" + $(element).attr("id").replace("cb", "")));
        if ($("#cbt" + $(element).attr("id").replace("cb", "")))
            console.log($("#cbt" + $(element).attr("id").replace("cb", "")).remove());
    }
}

/*function formSubmit(){
	var generator=new IDGenerator();
	var returnVal=false,returnVal1=false;
	var count=1;
	var barcodeArr=[];
	var requistionLogID="RL"+generator.generate();
	var requistionID="R"+generator.generate();
	var formData="";
	if($('input[name="cbtdName"]:checked').length==0){
		SwalWarning("No Items selected for Sample Transfer.");
	}
	else{
		$(".cbtd").each(function()){}
	}

}*/

function formSubmit() {

    var generator = new IDGenerator();
    var returnVal = false;
    var   returnVal1 = false;
    var count = 1;
    var barcodeArr = [];
    var requisitionLogID = "RL" + generator.generate();
    var requisitionID = "R" + generator.generate();

    var formData = "";
    if ($('input[name="cbtdName"]:checked').length == 0) {
        SwalWarning("No Items selected for Sample Transfer.");
    } else {
        $(".cbtd").each(function()
       	{
            if ($(this).prop("checked")) {
                barcodeArr.push($.trim($(this).val()));
                console.log("barcode", barcodeArr);
                var formData = "";
                var ProductId = $(this).attr('id').replace("cb","");
                console.log("product id is"+ProductId);
                formData += "ProductId=" + ProductId + "&";
                var reqItemId = "RI" + generator.generate();
                formData += "requisitionType=133&requisitionItemID=" + reqItemId +
                    "&requitionstatus=204&requitionItemstatus=212&issuesTo=" + $("#SalesPersonT").val() + "&";

                formData += "requisitionID=" + requisitionID + "&requisitionLogID=" + requisitionLogID + "&reason=" + $("#reason").val() + "&modeOfTransport=" + $("#modeOfTransport").val() + "&expectedReceiptDate=" + $("#expectedReceiptDate").val() + "&remarks=" + $("#remarks").val() + "&action=insert&count=" + count;
                console.log("formData", formData);
                $.ajax({
                    type: "POST",
                    url: "ModifyRequisition",
                    data: formData,
                    async: false,
                    success: function(data) {
                    	
                        if (data != "0"){
                        	console.log("requistionsubmit",data);
                        	   returnVal = true;
                        }
                        	
                        else
                            returnVal = false
                    }
                });
                var formdata1 = "action=update&";
                formdata1 += "refid=" + reqItemId + "&";
                formdata1 += "oldlocation=" + $("#SalesPersonF").val() + "&";
                formdata1 += "location=" + $("#SalesPersonT").val() + "&";
                formdata1 += "productId=" + ProductId + "&";
                formdata1 += "cdRowId=" + $(this).val();
                
                console.log("formdata1" + formdata1);

                $.ajax({
                    type: "POST",
                    url: "UpdateChildBarcodeLocation",
                    data: formdata1,
                    async: false,
                    success: function(data) {
                        if (data != "0"){
                        	console.log("update Child Barcode",data);
                        	  returnVal1 = true;
                        }
                          
                        else
                            returnVal1 = false
                    }
                });
                count++;
            }
        });

        if (returnVal1 && returnVal)
        {
            //printBarcode(barcodeArr);
            console.log("data save sucessfully");
            spinnerOff();
            $("#SampleTransferFormDiv").addClass('HideThisElement');
            $("#SampleFormProductListDiv").addClass('HideThisElement');
            $("#SampleTableDiv").removeClass("HideThisElement");
            SwalSuccess(" Sample Return Successfully !");
            getRequistionList();
            //	SampleViewDiv
            ///window.location.href="../../Samples/JSPs/Sample.jsp?for=sampleListView";

        }
    }

}