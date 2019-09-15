$(document).ready(function(){
	
});

function getCotactPerson()
{
	$('#contactPersonDatatables').DataTable().destroy();
	
	$('#contactPersonDatatables thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
    });
	
    $("#contactPersonDatatables thead input").on('keyup change', function () {
        contactPersonTable.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
    
    var actionStr = "";
    if(window.location.href.indexOf("JSPs/Order.jsp")>=0)
    {
    	actionStr = '<i class="select_me_clientCP fa fa-check fa-2x" aria-hidden="true"></i> ';
    }
    else
    {
    	actionStr = '<i class="edit_me fa fa-pencil-alt fa-2x" aria-hidden="true"></i> '+
            '<i class="delete_me fa fa-trash fa-2x " aria-hidden="true"></i>'
    }
    
	var contactPersonTable = $('#contactPersonDatatables').DataTable( {
        buttons: [
            {
                text: 'New Contact Person',
                action: function ( e, dt, node, config ) {
                	loadBlankformCP();
                }
            }
        ],dom: 'Bfrtip',
		"bLengthChange": true,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "GetVendorContactPersonList?vendorId="+$("#selectedVendorId").val(),
		"columns": [
        	 {
             	className: "center",
                 defaultContent: actionStr
             },
            { "data": "name" },
            { "data": "designation_text" },
            { "data": "contactNo" },
            { "data": "altContactNo" },
            { "data": "emailId" },
            { "data": "location" }
        ],
        columnDefs: [
            { width: '25pc', targets: 1 },
            { width: '30pc', targets: 2 }
        ],
        fixedColumns: true
    });
	
	$('#contactPersonDatatables tbody').off('click');
	
	$('#contactPersonDatatables tbody').on('click', '.edit_me', function() {
	    var data = contactPersonTable.row($(this).parents('tr')).data();
	    console.log("data is",data)
	    document.getElementById("insertVendorContactDetails").reset();
		/*DropDownForLegend();
		dropdownFunctionForManager();*/
		dropdownFunctionForState();
		DropDownForLegend();
	/*	DropDownForEmployee("");*/
		 document.querySelector('#selectedVendorId').value = data.VendorId;
	    document.querySelector('#selectedVendorContactPersonId').value = data.rowId;
	    
		$("#VendorViewDiv").addClass("HideThisElement");
		$("#VendorFormDiv").removeClass("HideThisElement");
		
		$("#VendorFormDiv #myTab").addClass("HideThisElement");
		$("#VendorFormDiv #VendorDetails").addClass("HideThisElement");
		$("#VendorFormDiv #ContactPersonDetails").removeClass("HideThisElement");
		$("#VendorFormDiv #AddressDetails").addClass("HideThisElement");
		
		$("#VendorFormDiv #VendorDetails").removeClass("active");
		$("#VendorFormDiv #AddressDetails").removeClass("active");
		$("#VendorFormDiv #ContactPersonDetails").addClass("active");
		
		$("#VendorFormDiv #VendorDetails").removeClass("show");
		$("#VendorFormDiv #AddressDetails").removeClass("show");
		$("#VendorFormDiv #ContactPersonDetails").addClass("show");

		$("#VendorFormDiv .card-title").html("Update Contact Person");

		$("#VendorFormDiv #SubmitButtonRegister").addClass("HideThisElement");
		$("#VendorFormDiv #SubmitButtonUpdate").addClass("HideThisElement");
		$("#VendorFormDiv #SubmitButtonVendorAddressDetails").addClass("HideThisElement");
		$("#VendorFormDiv #SubmitButtonVendorContactPerson").addClass("HideThisElement");
		$("#VendorFormDiv #SubmitButtonVendorAddressDetails").addClass("HideThisElement");
		$("#VendorFormDiv #SubmitButtonUpdateVContactPerson").removeClass("HideThisElement");
		
		$("#VendorFormDiv #action").val("updateContactPerson");
		
		$("#firstName").val(data.firstName);
		$("#lastName").val(data.lastName);
		$("#locationCP").val(data.location);
		$("#mobileno").val(data.contactNo);
		$("#altContactNo").val(data.altContactNo);
		$("#emailId").val(data.emailId);
		$("#department").val(data.department);
		$("#designation").val(data.designation_text);
		$("#birthDate").val(data.birthdate);
	/*	console.log($("#inputState").val(data.state),data.state);*/
		
	});
    
    $('#contactPersonDatatables tbody').on( 'click', '.select_me_clientCP', function () {
		var data = $('#contactPersonDatatables').DataTable().row($(this).parents('tr')).data();
		console.log(data);
		$('#selectedClientContactPersonId').val(data.rowId);
		$('#clientContactPersonName').val(data.name);
		$('#SelectClientContactPersonModal').modal('hide');
    });
	
	/*$('#editClick').click(function() {
		$("#SubmitButtonRegister").addClass("HideThisElement");
	    $("#SubmitButtonUpdate").removeClass("HideThisElement");
	    $("#SubmitButtonBack").removeClass("HideThisElement");	    
		$("#alertMessage").addClass("HideThisElement");
		$("#errorMessage").addClass("HideThisElement");
		$("#successMessage").addClass("HideThisElement");
		$("#EmpTableDiv").addClass("HideThisElement");
		$("#myTabContent").removeClass("HideThisElement");		
		$("#EmpViewDiv").addClass("HideThisElement");
		$("#EmpFormDiv").removeClass("HideThisElement");
	});*/
	
	/*$('#contactPersonDatatables tbody').on( 'click', '.select_me', function () {
    	var data = contactPersonTable.row( $(this).parents('tr') ).data();
        document.querySelector('#ResetPassEmpId').value = data.employeeId;
    	$('#centralModalWarningDemo').modal('show');
    });*/
    
    $('#contactPersonDatatables tbody').on( 'click', '.delete_me', function () 
      {
    	var data = contactPersonTable.row( $(this).parents('tr') ).data();
    	/*document.querySelector('#DeleteClientId').value = data.rowId;*/
    	SwalDeleteContact("It will permanently deleted !",data.rowId);
    	console.log("contactPerson",data.rowId)
    });
}





function SwalDeleteContact(msg, vendorCId) {
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
        alert('hgdnhfh')
        deleteContactPersonList(vendorCId);
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

function deleteContactPersonList(vendorCId)
{
	 alert("rowid"+vendorCId);
$.ajax
({
    type: "POST",
    url: "deleteVendorContactPersonDetails?rowId=" +vendorCId,
    data:$(this).serialize(),
    	
    // serializes the form's elements.
    success: function(data) {
        if (data == 1901) {
        	
        	getCotactPerson();
        }
    },
    error: function() {

    }
});
}
function loadBlankformCP() {
	var generator = new IDGenerator();
	var clientId = $('#selectedVendorId').val();
	document.getElementById("insertVendorContactDetails").reset();
	
	/*$("#myTabContent").removeClass("HideThisElement");		
	$("#SubmitButtonRegister").removeClass("HideThisElement");
	$("#SubmitButtonUpdate").addClass("HideThisElement");
	$("#SubmitButtonBack").removeClass("HideThisElement");	    
	$("#alertMessage").addClass("HideThisElement");
	$("#errorMessage").addClass("HideThisElement");
	$("#successMessage").addClass("HideThisElement");
	$("#statuscheckbox").attr("disabled",true);
	$("#ClientTableDiv").addClass("HideThisElement");
	$("#ClientFormDiv").removeClass("HideThisElement");*/
    $('#selectedVendorId').val(clientId);
	$("#selectedVendorContactPersonId").val("VCP"+ generator.generate());

	/*$("#ClientViewDiv").addClass("HideThisElement");
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

	$("#ClientFormDiv .card-title").html("New Address");*/

	$("#VendorViewDiv").addClass("HideThisElement");
	$("#VendorFormDiv").removeClass("HideThisElement");
	
	$("#VendorFormDiv #myTab").addClass("HideThisElement");
	$("#VendorFormDiv #VendorDetails").addClass("HideThisElement");
	$("#VendorFormDiv #ContactPersonDetails").removeClass("HideThisElement");
	$("#VendorFormDiv #AddressDetails").addClass("HideThisElement");
	
	$("#VendorFormDiv #VendorDetails").removeClass("active");
	$("#VendorFormDiv #AddressDetails").removeClass("active");
	$("#VendorFormDiv #ContactPersonDetails").addClass("active");
	
	$("#VendorFormDiv #VendorDetails").removeClass("show");
	$("#VendorFormDiv #AddressDetails").removeClass("show");
	$("#VendorFormDiv #ContactPersonDetails").addClass("show");

	$("#VendorFormDiv .card-title").html("New Contact Person");

	$("#VendorFormDiv #SubmitButtonRegister").addClass("HideThisElement");
	$("#VendorFormDiv #SubmitButtonUpdate").addClass("HideThisElement");
	$("#VendorFormDiv #SubmitButtonVendorAddressDetails").addClass("HideThisElement");
	$("#VendorFormDiv #SubmitButtonUpdateVContactPerson").addClass("HideThisElement");
	$("#VendorFormDiv #SubmitButtonVendorAddressDetails").addClass("HideThisElement");
	$("#VendorFormDiv #SubmitButtonVendorContactPerson").removeClass("HideThisElement");
	$("#VendorFormDiv #action").val("insertContactPerson");
	DropDownForLegend();
/*	DropDownForEmployee("");*/
	dropdownFunctionForState();
}