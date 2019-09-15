$(document).ready(function() {
	DropDownForEmployee("");
    DropDownForInventoryLegend();
    getProductListDatatable();
    ProductClickFn();
    $("#SubmitButtonRegister").click(function() {
       if (validate()){
    	   $("#action").val("insertSampleRequstion")
           formSubmit();
       }
    	

    });
    $("#DeleteProduct").click(function() {
        try {
            var table = document.getElementById('ProductDataBody');
            var rowCount = table.rows.length;
            for (var i = 0; i < rowCount; i++) {
                var row = table.rows[i];
                var chkbox = row.cells[0].childNodes[0];

                if (null != chkbox && true == chkbox.checked) {
                    table.deleteRow(i);
                    //        			calculateAmountPayable();
                    rowCount--;
                    i--;
                }
            }
        } catch (e) {
            alert(e);
        }
        return false;
    });

});

function formSubmit()
{

	var returnVal=false;
	var generator = new IDGenerator();
	var returnVal=false;
	var count = 1;
	$("#selectedRequisitioId").val("R"+generator.generate());	
	var requisitionLogID = "RL"+generator.generate();
	/*var requisitionID = "R"+generator.generate();
	var requisitionID = $("#selectedRequisitioId").val();*/
	var table1 = document.getElementById('ProductDataBody');
	var rowCount = table1.rows.length;//finds the length of current table
	console.log("rowCount "+rowCount);
	console.log("table1"+table1);
	for (var i = 0; i < rowCount; i++)
	{
		var row = table1.rows[i]; //tables row [0} position if i=0;
		  var formData="RequistionItemID=RI"+generator.generate()+"&count="+i+"&rowId="+$("#selectedRequisitioId").val()+"&requisitionLogID="+requisitionLogID+"&action="+$("#action").val()+"&reason="+$("#reason").val()+"&remarks="+$("#remarks").val()+"&expectedReceiptDate="+$("#expectedReceiptDate").val()+"&modeofDelivery="+$("#modeOfTransport").val()+"&issuesTo="+$("#SalesPersonR").val()+"&"; 	
		  var RequistionForm=""; 
		  console.log("row is "+row);
		  for(var j=0; j<$(row.cells).length; j++)
		   {
			  console.log("j value",j);
				if(j==0)
				{	
					var ProductId=$($(row.cells[j])[0].innerHTML).attr('name');
				console.log("productId is",ProductId);
				RequistionForm+="&ProductId="+ProductId+"&qty="+1+"&";
				console.log("formdata ",formData);
				console.log("RequistionForm",RequistionForm);
				
				/*OrderForm+="brand="+$("#brandText1"+ProductId).html()+"&modelNo="+$("#modelNoText"+ProductId).html()+"&color="+$("#colorText"+ProductId).html()+"&size="+$("#sizeText"+ProductId).html()+"&type="+$("#typeText"+ProductId).html()+"&qty="+$("#quantity"+ProductId).val()+"&price="+$("#price"+ProductId).val()+"&sku="+$("#skuText"+ProductId).html()+"&";
					
					formData+="ProductId="+ProductId+"&quantity="+$("#quantity"+ProductId).val()+"&rate="+$("#price"+ProductId).val()+"&discount="+$("#discountText"+ProductId).val()+"&igst="+$("#taxText"+ProductId).val()+"&";*/
				}
			}
			   /*    console.log("...",($("#quantity"+ProductId).val()));*/
		  $.ajax({
	            type: "POST",
	            url: "SampleRequistionSave",
	            data: RequistionForm+formData, 
	            async:false,
	            success: function(data)
		        {	
	            	console.log("AllData",data);
	            	
	            	returnVal=true;

	            }
	    	});
		  
	}
	
	if(returnVal){
		SwalSuccess(" SampleRequistion Added successfully ! ");
		$("#SampleFormDiv").addClass('HideThisElement');
		 $("#SampleFormProductListDiv").addClass('HideThisElement');
		$("#SampleTableDiv").removeClass('HideThisElement');
		getRequistionList();
	}

}


function ProductClickFn() {

    console.log("bnvhj");
    $('#productListTable tbody').on('click', '.select_me', function() {
        console.log("454");
        var generator = new IDGenerator();
        $("#submitBtnDiv").removeClass("HideThisElement");
        $("#SampleFormProductListDiv").removeClass("HideThisElement");
        var data = $('#productListTable').DataTable().row($(this).parents('tr')).data();
        console.log(data);
        var table1 = document.getElementById('ProductDataBody');
        var rowCount = table1.rows.length;
        var idExists = false;
        for (var i = 0; i < rowCount; i++) {
            var row = table1.rows[i];
            var a = $(row.cells[0]).html();
            var idToCheck = $(a).attr('id');
            if (idToCheck == data.rowId) {
                idExists = true;
                break;
            }
        }
        if (idExists) {
            // $(".errorMsg").removeClass("HideThisElement");
            SwalWarning('Product Already Selected !');
        } else {
            console.log("dsd");
            var newHtml = '<tr id="productIdRow">' +
                '<td><input type="checkbox" id="' + data.rowId + '" name="' + data.rowId + '"><label for="' + data.rowId + '"></label></td>' +
                '<td>' + data.skuid + '</td>' +
                '<td>' + data.productInfo + '</td>' +
                '</tr>';
            document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', newHtml);
        }
    });
}

function validate() {
    if ($("#reason").val() == "") {
    	SwalWarning("Please Select Reason!");
    } else if ($("#expectedReceiptDate").val() == "") {
    	SwalWarning("Please Select Expected Receipt Date!");
    } else if ($("#modeOfTransport").val() == "") {
    	SwalWarning("Please Select Mode of Transport!");
    } else 
        return true;
}