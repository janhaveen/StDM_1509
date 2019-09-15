$(document).ready(function(){
	
	$("#clientId").focusout(function() 
		    {
		    
		  	  
		        var clientId = $("#clientId").val();
		        if (clientId != "") 
		        {
		            /*if (mobileno.length > 9)*/
		                getCustomerInfo(clientId);
		        }
		        	else
		        	{
		        		SwalWarning("Client Id not present");
		        	}
		       
		    });
	  
    $('#datatables tbody').on( 'click', 'td', function () {
		var data = $('#datatables').DataTable().row($(this).parents('tr')).data();
		console.log("all client data",data);
		$("#selectedClientId").val(data.rowId);
		$('#clientName').val(data.companyName);
		$('#clientId').val(data.rowNo);
		
		$('#selectedBillingAddressId').val(data.addressId);
		$('#clientBillingAddress').html(data.branchName+", "+data.locationadd+", "+data.state_text+", "+data.pincode);
		getAddress();
		
		$('#selectedDeliveryAddressId').val(data.addressId);
		$('#clientDeliveryAddress').html(data.branchName+", "+data.locationadd+", "+data.state_text+", "+data.pincode);
		
		$('#selectedClientContactPersonId').val(data.cpid);
		console.log("selectedClientContactPersonId",data.cpid);
		$('#clientContactPersonName').val(data.contactPerson);
		$('#ContactNumber').val(data.contactNoCP);
		getCotactPerson();
		
		$('#SelectClientModal').modal('hide');
    });
	
    /*$('#addressModal').on('shown.bs.modal', function (e) {
    	$('#addressTable').DataTable().destroy();
    	addressList();
	})
	
    $('#contactPersonModal').on('shown.bs.modal', function (e) {
    	$('#contactPTable').DataTable().destroy();
    	contactPList();
	})*/
});
   
function showAddressModal(type)
{
	$("#addressType").val(type);
	$('#SelectClientAddressModal').modal('show');
}
    function getCustomerInfo(clientId){
    	console.log(clientId);
        $.ajax({
            type: "GET",
            url: "listCustomerInfo?rowNo=" + clientId,
            data: $(this).serialize(), // serializes the form's elements.
            success: function(data) {
            	console.log("clientListData",data);
            if (data.data.length > 0) {
                    for (var i = 0; i < data.data.length; i++) {
                    	console.log("length",data.data.length);
                        if (clientId == data.data[i].rowNo) {   
                            console.log("...cust..", data.data[i].rowId);
       
                            $("#selectedClientId").val(data.data[i].rowId);
                         	$("#clientName").val(data.data[i].companyName);
                            $("#selectedBillingAddressId").val(data.data[i].addressId);
                            $('#clientBillingAddress').html(data.data[i].branchName+", "+data.data[i].locationadd+", "+data.data[i].state_text+", "+data.data[i].pincode);
                            getAddress();
                            $("#selectedDeliveryAddressId").val(data.data[i].addressId);
                            $('#clientDeliveryAddress').html(data.data[i].branchName+", "+data.data[i].locationadd+", "+data.data[i].state_text+", "+data.data[i].pincode);
                            $("#selectedClientContactPersonId").val(data.data[i].cpid);
                            $("#clientContactPersonName").val(data.data[i].contactPerson);
                            $("#ContactNumber").val(data.data[i].contactNoCP);
                            getCotactPerson();
                           
                        }

                    }
                } else {
                	  console.log("hello world customer");
                	  SwalWarning("Enter valid client Id");
                	  document.getElementById('selectedClientId').value = "";
                      document.getElementById('clientName').value = "";
                      document.getElementById('selectedBillingAddressId').value = "";
                      document.getElementById("clientBillingAddress").value = "";
                      document.getElementById('clientBillingAddress').html = "";
                      document.getElementById('selectedDeliveryAddressId').value = "";
                      document.getElementById('clientDeliveryAddress').html = "";
                      document.getElementById('selectedDeliveryAddressId').value = "";
                      document.getElementById('selectedClientContactPersonId').value = "";
                      document.getElementById('clientContactPersonName').value = "";
                      document.getElementById('ContactNumber').value = "";
                }
            }

        });
    }