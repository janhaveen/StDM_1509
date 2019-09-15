$(document).ready(function(){
	
});

function getAddress()
{
//	var data = [];
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
    if(window.location.href.indexOf("JSPs/Order.jsp")>=0)
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
		"ajax": "GetVendorAddressList?vendorId="+$("#selectedVendorId").val(),
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
        fixedColumns: true
    });
	
	$('#addressDatatables tbody').off('click');
	
	$('#addressDatatables tbody').on('click', '.edit_me', function() {
		var data = addressTable.row($(this).parents('tr')).data();
	    document.getElementById("insertVendorAddressDetails").reset();
	    /*DropDownForLegend();
		dropdownFunctionForManager();*/
		dropdownFunctionForState();
	    document.querySelector('#selectedVendorId').value = data.VendorId;
	    document.querySelector('#selectedVendorAddressId').value = data.rowId;

		$("#VendorViewDiv").addClass("HideThisElement");
		$("#VendorFormDiv").removeClass("HideThisElement");
		
		$("#VendorFormDiv #myTab").addClass("HideThisElement");
		$("#VendorFormDiv #VendorDetails").addClass("HideThisElement");
		$("#VendorFormDiv #ContactPersonDetails").addClass("HideThisElement");
		$("#VendorFormDiv #AddressDetails").removeClass("HideThisElement");
		
		$("#VendorFormDiv #VendorDetails").removeClass("active");
		$("#VendorFormDiv #AddressDetails").addClass("active");
		$("#VendorFormDiv #ContactPersonDetails").removeClass("active");
		
		$("#VendorFormDiv #VendorDetails").removeClass("show");
		$("#VendorFormDiv #AddressDetails").addClass("show");
		$("#VendorFormDiv #ContactPersonDetails").removeClass("show");

		$("#VendorFormDiv .card-title").html("Update Address");

		$("#VendorFormDiv #SubmitButtonRegister").addClass("HideThisElement");
		$("#VendorFormDiv #SubmitButtonUpdate").addClass("HideThisElement");
		$("#VendorFormDiv #SubmitButtonUpdateVContactPerson").addClass("HideThisElement");
		$("#VendorFormDiv #SubmitButtonVendorContactPerson").addClass("HideThisElement");
		$("#VendorFormDiv #SubmitButtonVendorAddressDetails").addClass("HideThisElement");
		$("#VendorFormDiv #SubmitButtonUpdateVAddress").removeClass("HideThisElement");
		$("#VendorFormDiv #action").val("updateAddress");
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
	});
    
    $('#addressDatatables tbody').on( 'click', '.delete_me', function () {
    	var data = addressTable.row( $(this).parents('tr') ).data();
    	SwalDeleteAddress("It will permanently deleted !", data.rowId);
    	    	console.log("addresss",data.rowId)
    });


    $('#addressDatatables tbody').on( 'click', '.select_me_clientAdd', function () {
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
function SwalDeleteAddress(msg, rowId) {
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
	        deleteVendorAddress(rowId);
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

	function deleteVendorAddress(rowId) {
	$.ajax({
	    type: "POST",
	    url: "deleteVendorAddress?rowId=" +rowId,
	    data:$(this).serialize(), // serializes the form's elements.
	    success: function(data) {
	        if (data == 1903) {
	        	getAddress();
	        }
	    },
	    error: function() {

	    }
	});
	}
function loadBlankformAddress() {
	var generator = new IDGenerator();
	var clientId = $('#selectedVendorId').val();
	document.getElementById("insertVendorAddressDetails").reset();
    $('#selectedVendorId').val(clientId);
	$("#selectedVendorAddressId").val("VA"+ generator.generate());
	
	$("#VendorViewDiv").addClass("HideThisElement");
	$("#VendorFormDiv").removeClass("HideThisElement");
	
	$("#VendorFormDiv #myTab").addClass("HideThisElement");
	$("#VendorFormDiv #VendorDetails").addClass("HideThisElement");
	$("#VendorFormDiv #ContactPersonDetails").addClass("HideThisElement");
	$("#VendorFormDiv #AddressDetails").removeClass("HideThisElement");
	
	$("#VendorFormDiv #VendorDetails").removeClass("active");
	$("#VendorFormDiv #AddressDetails").addClass("active");
	$("#VendorFormDiv #ContactPersonDetails").removeClass("active");
	
	$("#VendorFormDiv #VendorDetails").removeClass("show");
	$("#VendorFormDiv #AddressDetails").addClass("show");
	$("#VendorFormDiv #ContactPersonDetails").removeClass("show");

	$("#VendorFormDiv .card-title").html("New Address");

	$("#VendorFormDiv #SubmitButtonRegister").addClass("HideThisElement");
	
	$("#VendorFormDiv #SubmitButtonUpdate").addClass("HideThisElement");
	$("#VendorFormDiv #SubmitButtonUpdateVContactPerson").addClass("HideThisElement");
	$("#VendorFormDiv #SubmitButtonUpdateVAddress").addClass("HideThisElement");
	$("#VendorFormDiv #SubmitButtonVendorContactPerson").addClass("HideThisElement");
	$("#VendorFormDiv #SubmitButtonVendorAddressDetails").removeClass("HideThisElement");
	
	

	$("#VendorFormDiv #action").val("insertAddress");
	DropDownForLegend();
	/*DropDownForEmployee("");*/
	dropdownFunctionForState();
}