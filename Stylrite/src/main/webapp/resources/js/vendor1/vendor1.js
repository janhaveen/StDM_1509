$(document).ready(function(){
    $("#source").change(function () {
        var val = this.value;
		$('#legendGroupLbl').addClass("active");
        if (val=="246") {
        	$('#reference').val("");
        	$("#referenceDiv").removeClass("HideThisElement");
		}
        else
        {
        	$("#referenceDiv").addClass("HideThisElement");
        }
    });
        $("#SubmitButtonRegister").click(function() {
        	formSubmit(); 
        	
        });
        
        $("#SubmitButtonUpdate").click(function()
        	{
        	formUpdate();
        	
          });
        
        $("#SubmitButtonBack").click(function()
       	{
    	    $("#VendorTableDiv").removeClass("HideThisElement");
    		$("#VendorViewDiv").addClass("HideThisElement");
    		$("#VendorFormDiv").addClass("HideThisElement");
        });
        
        $("#SubmitButtonBackFromView").click(function()
        {
    	    $("#VendorTableDiv").removeClass("HideThisElement");
    		$("#VendorViewDiv").addClass("HideThisElement");
    		$("#VendorFormDiv").addClass("HideThisElement");
        });
        $("#SubmitButtonUpdateVContactPerson").click(function() {
        	
        	formUpdateVendorContactPerson();
                        
        });
        $("#SubmitButtonUpdateVAddress").click(function() {
        	formUpdateVendorAddress();
        
    });
        $("#SubmitButtonVendorContactPerson").click(function() {
            /*if (validate())*/
                      formSubmitContactDetils();

        });
        
        $("#SubmitButtonVendorAddressDetails").click(function() {
            /*if (validate())*/
                formSubmitAddressDetails();

        });
        $("#DeleteVendorConfirmed").click(function() {
            var DeleteVendorId = document.querySelector('#DeleteVendorId').value;
           /* alert(DeleteVendorId);*/
            $.ajax({
                type: "POST",
                url: 'DeletedVendor?rowId='+DeleteVendorId,
              
                success: function(data) {
                	if(data==801){
                		
                		 $('#centralModalDangerDemo').modal('hide');
                		  $('#datatables').DataTable().ajax.reload();
                		  SwalSuccess("vendor Deleted Sucessdfully")
                	}
                	else if(data==802){
                		SwalError("No Vendor Deleted")
                	}
                   /* if (data == 802) {
                        $('#centralModalDangerDemo').modal('hide');
                        SwalError("No Vendor Deleted")
                        $(".errorMsg").removeClass("HideThisElement");
                        $("#errorMsg").html(' <strong>Error!</strong> Failed to Delete Client!');
                    } else {
                        $('#centralModalDangerDemo').modal('hide');
                        $('#selectedEmployeeId').val('');
                        $('#datatables').DataTable().ajax.reload();
                        $(".successMsg").removeClass("HideThisElement");
                        $("#successMsg").html(' <strong>Success!</strong>  Client Deleted Successfully!');
                    }*/
                }
            })
            return false; // avoid to execute the actual submit of the form.
        });
});
function formSubmit()
{
    spinnerOn();

    $.ajax({
        type: "POST",
        url: "vendorRegister",
        data: $("#newVendorElementForm").serialize(), // serializes the form's elements.
        success: function(data) {
        	 console.log("VendorAd",data)
        	
            $.ajax({
                type: "POST",
                url: "vendorAddressRegister",
                data: $("#insertVendorAddressDetails").serialize()+'&vendorId=' + $("#selectedVendorId").val(), // serializes the form's elements.
                success: function(data) {
                    spinnerOff();

                    console.log("VendorAdddressDetails",data);

                    $.ajax({

                        type: "POST",
                        url: "VendorPersonRegister",
                        data: $("#insertVendorContactDetails").serialize() +'&vendorId='+ $("#selectedVendorId").val(), // serializes the form's elements.
                        success: function(data)
                        {
                            console.log(" vendor contactPersonRegister Details", data);

                          
                        }
                    });

                    //window.location = 'showOrder';
                }
            });
            console.log(data);
        }
    });

}
       function formUpdate(){
    	   spinnerOn();

    	    $.ajax({
    	        type: "POST",
    	        url: "updateVendor",
    	        data: $("#newVendorElementForm").serialize(), // serializes the form's elements.
    	        success: function(data) {
    	        	spinnerOff();
    	        	    if(data==2501)
    	        	    {
    	        	    	SwalSuccess("Vendor Updated Sucessfully");
    	        	    }
    	        	    
    	       	}
    	    });
       }
     function formUpdateVendorContactPerson()
     {
    	    $.ajax({

                type: "POST",
                url: "vendorUpdateContactDetails",
                data: $("#insertVendorContactDetails").serialize() +'&vendorId=' + $("#selectedVendorId").val(), // serializes the form's elements.
                success: function(data)
                {
                    console.log("VendorPersonRegister Details", data);
                    if(data==2701){
                    	SwalSuccess("Vendor Contact Person Data updated Sucessfully");
                    }
                    else if (data==2702){
                    	SwalSuccess("No updated Vendor Person");
                    }

                  
                }
            });
    	 
     }
     function formUpdateVendorAddress(){
    	   $.ajax({
               type: "POST",
               url: "vendorUpdateAddressDetails",
               data: $("#insertVendorAddressDetails").serialize()+'&vendorId=' + $("#selectedVendorId").val(), // serializes the form's elements.
               success: function(data) {
                   spinnerOff();

                   console.log("vendorAdddressDetails",data);

                   if(data=2601){
                   	SwalSuccess("Vendor Address Detail data updated  Sucessfully");
                   }
                   else if(data==2602){
                   	SwalSuccess("No updated Vendor Details");
                   }

                 
               }
           });
       	
     }
       function  formSubmitContactDetils()
      {
    	   $.ajax({
               type: "POST",
               url: "newVendorContactDetails",
               data: $("#insertVendorContactDetails").serialize()+'&vendorId=' + $("#selectedVendorId").val(), // serializes the form's elements.
               success: function(data) {
                   spinnerOff();

                   console.log("newVendorClientDetails",data);
                     if(data==1703){
                    	  	SwalSuccess("Vendor ContactPerson Added  Sucessfully");
                     }
                     else if(data==1704){
                    	 SwalSuccess("No Vendor added Sucessfully");
                    	 
                     }
                    
               }
    	   });
    	   
    	   
            }   
       
     function formSubmitAddressDetails()
     {

    	 $.ajax({
             type: "POST",
             url: "newVendorAddressDetails",
             data: $("#insertVendorAddressDetails").serialize()+'&vendorId=' + $("#selectedVendorId").val(), // serializes the form's elements.
             success: function(data) {
                 spinnerOff();

                 console.log("newAddressDetails",data);
                   if(data==1603){
                  	  	SwalSuccess("Vendor Address Details Added  Sucessfully");
                   }
                   else if(data==1604){
                  	 SwalSuccess("No Vendor  Address added Sucessfully");
                  	 
                   }
                  
             }
  	   });

     }
     
