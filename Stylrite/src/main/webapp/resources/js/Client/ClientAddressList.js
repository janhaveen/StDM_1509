$(document).ready(function(){
	
});

function getAddress()
{
//	var data = [];
	spinnerOn();
	dropdownFunctionForState();
	$('#addressDatatables').DataTable().destroy();
	
	$('#addressDatatables thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
    });
	
    $("#addressDatatables thead input").on('keyup change', function () {
        contactPersonTable.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
    
    var actionStr = "";
    if(window.location.href.indexOf("jsp/order/Order.jsp")>=0)
    {
    	actionStr = '<i class="select_me_clientAdd fa fa-check fa-2x" aria-hidden="true"></i> ';
    }
    else
    {
    	actionStr = '<i class="edit_me fa fa-pencil-alt fa-2x" aria-hidden="true"></i> '+
            '<i class="delete_me fa fa-trash fa-2x " aria-hidden="true"></i>'
    }
    
	var addressTable = $('#addressDatatables').DataTable( {
        buttons: [
            {
                text: 'New Address',
                action: function ( e, dt, node, config ) {
                	loadBlankformAddress();
                }
            }
        ],dom: 'Bfrtip',
		"bLengthChange": true,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "GetAddressList?clientId="+$("#selectedClientId").val(),
		"columns": [
        	 {
             	className: "center",
                 defaultContent: actionStr
             },
            { "data": "branchName" },
            { "data": "contactNo" },
            { "data": "gstNo" },
            { "data": "location" }
        ],
        columnDefs: [
            { width: '25pc', targets: 1 },
            { width: '30pc', targets: 2 }
        ],
        fixedColumns: true,
        "initComplete": function(settings, json) {   
        	spinnerOff();
        }
    });
	
	$('#addressDatatables tbody').off('click');
	
	$('#addressDatatables tbody').on('click', '.edit_me', function() {
		var data = addressTable.row($(this).parents('tr')).data();
		console.log(data);
	    document.getElementById("newElementForm").reset();
		/*DropDownForLegend();
		dropdownFunctionForManager();*/
		
	    document.querySelector('#selectedClientId').value = data.clientId;
	    document.querySelector('#selectedClientAddressId').value = data.rowId;

		$("#ClientViewDiv").addClass("HideThisElement");
		$("#ClientFormDiv").removeClass("HideThisElement");
		
		$("#ClientFormDiv #myTab").addClass("HideThisElement");
		$("#ClientFormDiv #ClientDetails").addClass("HideThisElement");
		$("#ClientFormDiv #ContactPersonDetails").addClass("HideThisElement");
		$("#ClientFormDiv #AddressDetails").removeClass("HideThisElement");
		$("#SubmitButtonAddressDetails").addClass("HideThisElement");
		
		$("#ClientFormDiv #ClientDetails").removeClass("active");
		$("#ClientFormDiv #AddressDetails").addClass("active");
		$("#ClientFormDiv #ContactPersonDetails").removeClass("active");
		
		$("#ClientFormDiv #ClientDetails").removeClass("show");
		$("#ClientFormDiv #AddressDetails").addClass("show");
		$("#ClientFormDiv #ContactPersonDetails").removeClass("show");

		$("#ClientFormDiv .card-title").html("Update Address");

		$("#ClientFormDiv #SubmitButtonRegister").addClass("HideThisElement");
		$("#ClientFormDiv #SubmitButtonUpdateAddress").removeClass("HideThisElement");
		$("#ClientFormDiv #SubmitButtonUpdateContactPerson").addClass("HideThisElement");

		$("#ClientFormDiv #action").val("updateAddress");
		
		$("#branchName").val(data.branchName);
		$("#ledgerName").val(data.ledgerName);
		$("#GSTNo").val(data.gstNo);
		$("#contactNoAdd").val(data.contactNo);
		$("#inputAddress").val(data.addressLine1);
		$("#inputAddress2").val(data.addressLine2);
		$("#locationAdd").val(data.location);
		$("#inputCity").val(data.city);
		console.log($("#inputState").val(data.state),data.state);
		$("#inputZip").val(data.pincode);
		if(data.isDefault == "1")
		{
			$("#isDefaultAdd").attr("checked", true);
		}
		else
		{
			$("#isDefaultAdd").attr("checked", false);
		}
	});
    
    $('#addressDatatables tbody').on( 'click', '.delete_me', function () {
    	var data = addressTable.row( $(this).parents('tr') ).data();
    	  var rowId = data.rowId;

          console.log(data);

          //deleteCustomer(rowNo);
          SwalDelete("It will permanently deleted !", data.rowId);
    });
    
    $('#addressDatatables tbody').on( 'click', 'td', function () {
		var data = $('#addressDatatables').DataTable().row($(this).parents('tr')).data();
		if($('#addressType').val() == "billingAddress")
		{
			$('#selectedBillingAddressId').val(data.rowId);
			$('#clientBillingAddress').val(data.addressLine1);
			$('#SelectClientAddressModal').modal('hide');
		}
		else if($('#addressType').val() == "deliveryAddress")
		{
			$('#selectedDeliveryAddressId').val(data.rowId);
			$('#clientDeliveryAddress').val(data.addressLine1);
			$('#SelectClientAddressModal').modal('hide');
		}
    });
}
function SwalDelete(msg, rowId) {
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
            deleteClientAddressList(rowId);
        }, function(dismiss) {
            if (dismiss === 'cancel') {
                swal(
                    'Ok',
                    'Cancelled !',
                    'error'
                )
            }
        });
}

function deleteClientAddressList(rowId) {
	var dataAdd = "&isDefault="+$("#isDefaultAdd").is(":checked");

    $.ajax({
        type: "POST",
        url: "deleteClientAddress?rowId="+rowId+dataAdd,
        data:  $(this).serialize(), // serializes the form's elements.
        success: function(data) {
            if (data == 83) {
            	getAddress();
            }
            else if(data==84){
            	SwalSuccess("Default Address Cannot be deleted");
            }
        },
        error: function() {

        }
    });
}


function loadBlankformAddress() 
{
	var generator = new IDGenerator();
	var clientId = $('#selectedClientId').val();
	document.getElementById("newElementForm").reset();
	document.getElementById("insertAddressDetails").reset();
    $('#selectedClientId').val(clientId);
	$("#selectedClientAddressId").val("CA"+ generator.generate());

	$("#ClientViewDiv").addClass("HideThisElement");
	$("#ClientFormDiv").removeClass("HideThisElement");
	
	$("#ClientFormDiv #myTab").addClass("HideThisElement");
	$("#ClientFormDiv #ClientDetails").addClass("HideThisElement");
	$("#ClientFormDiv #ContactPersonDetails").addClass("HideThisElement");
	
	$("#ClientFormDiv #AddressDetails").removeClass("HideThisElement");
	
	$("#ClientFormDiv #ClientDetails").removeClass("active");
	$("#ClientFormDiv #AddressDetails").addClass("active");
	$("#ClientFormDiv #ContactPersonDetails").removeClass("active");
	
	
	$("#ClientFormDiv #ClientDetails").removeClass("show");
	$("#ClientFormDiv #AddressDetails").addClass("show");
	$("#ClientFormDiv #ContactPersonDetails").removeClass("show");

	$("#ClientFormDiv .card-title").html("New Address");

	
	$("#ClientFormDiv #SubmitButtonContactPerson").addClass("HideThisElement");
	$("#ClientFormDiv #SubmitButtonUpdateAddress").addClass("HideThisElement");
	$("#ClientFormDiv #SubmitButtonAddressDetails").removeClass("HideThisElement");
	$("#ClientFormDiv #SubmitButtonRegister").addClass("HideThisElement");
	$("#ClientFormDiv #SubmitButtonUpdate").addClass("HideThisElement");
	$("#ClientFormDiv #action").val("insertAddress");
	DropDownForLegend();
	dropdownFunctionForState();
}