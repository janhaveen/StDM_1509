$(document).ready(function(){
	
	$('#datatables').DataTable().destroy();
	getVendorList();
	dropdownFunctionForState();
	DropDownForLegend();
	getVendorList();
/*	DropDownForEmployee("");*/
    
});

function getVendorList() 
{
	$('#datatables thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
    });
	
    $("#datatables thead input").on('keyup change', function () {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
    
    var actionStr = "";
    if(window.location.href.indexOf("showGRN") >= 0)
    {
    	actionStr = '<i class="select_me_client fa fa-check fa-2x" aria-hidden="true"></i> ';
    }
    else if(window.location.href.indexOf("uploadGRN") >= 0)
    {
    	actionStr = '<i class="select_me_client fa fa-check fa-2x" aria-hidden="true"></i> ';
    }
    else
    {
    	
    	actionStr = '<i class="edit_me fa fa-pencil-alt fa-2x" aria-hidden="true"></i> '+
        '<i class="delete_me fa fa-trash fa-2x " aria-hidden="true"></i>';
    }
    
	var table = $('#datatables').DataTable( {
        buttons: [
            {
                text: 'New Vendor',
                action: function ( e, dt, node, config ) {
                	loadBlankform();
                }
            }
        ],dom: 'Bfrtip',
		"bLengthChange": true,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "GetVendorList",
		"columns": [
        	 {
             	className: "center",
                 defaultContent: actionStr
             },
            { "data": "companyName" },
            { "data": "location" },
            { "data": "contactPerson" },
            { "data": "contactNoCP" },
            { "data": "altContactNoCP" },
            { "data": "emailIdCP" }
        ],
        fixedColumns: true
    });
	
    $('#datatables tbody').off('click');
	
	$('#datatables tbody').on('click', '.edit_me', function() {
		var data = table.row($(this).parents('tr')).data();
	    document.getElementById("newVendorElementForm").reset();
	    document.querySelector('#selectedVendorId').value = data.rowId;
		$("#companyNameText").text(data.companyName);
		$("#locationText").text(data.location);
		$("#customerTypeText").text(data.customerType_txt);
		$("#sourceText").text(data.source_text);
		$("#creditTimeText").text(data.creditTime);
		$("#creditLimitText").text(data.creditLimit);
		$("#salesPersonText").text(data.contactPerson);
		
	    getCotactPerson();
	    getAddress();
	    
		$("#companyName").val(data.companyName);
		$("#location").val(data.location);
		document.querySelector('#customerType').value = data.customerType;     
//		$("#customerType").val(data.customerType);
		$("#creditTime").val(data.creditTime);
		$("#creditLimit").val(data.creditLimit);
		$("#salesPerson").val(data.salesPerson);
		$("#source").val(data.source);

	    $("#VendorTableDiv").addClass("HideThisElement");
		$("#VendorViewDiv").removeClass("HideThisElement");
		$("#VendorFormDiv").addClass("HideThisElement");
	});
	
	$('#editClick').click(function() {
		$("#alertMessage").addClass("HideThisElement");
		$("#errorMessage").addClass("HideThisElement");
		$("#successMessage").addClass("HideThisElement");
		
		$("#VendorViewDiv").addClass("HideThisElement");
		$("#VendorFormDiv").removeClass("HideThisElement");
		
		$("#VendorFormDiv #myTab").addClass("HideThisElement");
		$("#VendorFormDiv #VendorDetails").removeClass("HideThisElement");
		$("#VendorFormDiv #ContactPersonDetails").addClass("HideThisElement");
		$("#VendorFormDiv #AddressDetails").addClass("HideThisElement");
		
		$("#VendorFormDiv #VendorDetails").addClass("active");
		$("#VendorFormDiv #AddressDetails").removeClass("active");
		$("#VendorFormDiv #ContactPersonDetails").removeClass("active");
		
		$("#VendorFormDiv #VendorDetails").addClass("show");
		$("#VendorFormDiv #AddressDetails").removeClass("show");
		$("#VendorFormDiv #ContactPersonDetails").removeClass("show");

		$("#VendorFormDiv .card-title").html("Update Vendor");

		$("#VendorFormDiv #SubmitButtonRegister").addClass("HideThisElement");
		$("#VendorFormDiv #SubmitButtonUpdate").removeClass("HideThisElement");
		
		$("#VendorFormDiv #action").val("updateVendor");
	});
    
    $('#datatables tbody').on( 'click', '.delete_me', function () {
    	var data = table.row( $(this).parents('tr') ).data();
    	console.log(data.rowId);
    	document.querySelector('#DeleteVendorId').value = data.rowId;
    	$('#centralModalDangerDemo').modal('show');
    });
}

function loadBlankform() {
	console.log("Hi");
	document.getElementById("newVendorElementForm").reset();
	$("#myTabContent").removeClass("HideThisElement");		
	$("#SubmitButtonRegister").removeClass("HideThisElement");
	$("#SubmitButtonUpdate").addClass("HideThisElement");
	$("#SubmitButtonBack").removeClass("HideThisElement");	    
	$("#alertMessage").addClass("HideThisElement");
	$("#errorMessage").addClass("HideThisElement");
	$("#successMessage").addClass("HideThisElement");
	$("#statuscheckbox").attr("disabled",true);
	$("#VendorTableDiv").addClass("HideThisElement");
	$("#VendorFormDiv").removeClass("HideThisElement");
	$("#action").val("insert");
	var generator = new IDGenerator();
	DropDownForLegend();
/*	DropDownForEmployee("");*/
	dropdownFunctionForState();
	$("#selectedVendorId").val("V"+ generator.generate());
	$("#selectedVendorAddressId").val("VA"+ generator.generate());
	$("#selectedVendorContactPersonId").val("VCP"+ generator.generate());
}