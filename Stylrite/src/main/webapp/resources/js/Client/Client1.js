$(document).ready(function() {
    $("#source").change(function() {
        var val = this.value;
        $('#legendGroupLbl').addClass("active");
        if (val == "246") {
            $('#reference').val("");
            $("#referenceDiv").removeClass("HideThisElement");
        } else {
            $("#referenceDiv").addClass("HideThisElement");
        }

    });

   
    $("#SubmitButtonRegister").click(function() {
        if (validate())
            formSubmit();

    });
    
    $("#SubmitButtonContactPerson").click(function() {
       if (validateContactPerson())
            formSubmitContactDetils();

    });
    
    $("#SubmitButtonAddressDetails").click(function() {
        /*if (validate())*/
            formSubmitAddressDetails();

    });

    $("#SubmitButtonBack").click(function() 
    {
    	document.getElementById("insertContactPersonDetailsDetails").reset();
        $("#ClientTableDiv").removeClass("HideThisElement");
        $("#ClientViewDiv").addClass("HideThisElement");
        $("#ClientFormDiv").addClass("HideThisElement");
    });

    $("#SubmitButtonBackFromView").click(function() {
        $("#ClientTableDiv").removeClass("HideThisElement");
        $("#ClientViewDiv").addClass("HideThisElement");
        $("#ClientFormDiv").addClass("HideThisElement");
    });

    $("#SubmitButtonUpdate").click(function() {
    	  if (validateClientUpdate())
    	formUpdate();
                    
    });
    $("#SubmitButtonUpdateContactPerson").click(function() {
    	  if (validateContactPerson())
    	formUpdateContactPerson();
                    
    });
    $("#SubmitButtonUpdateAddress").click(function() {
    	  if (ValidateAddressDetails())
    	formUpdateAddress();
                    
    });

    /* $("#DeleteClientConfirmed").click(function() {
         var DeleteClientId = document.querySelector('#DeleteClientId').value;
         $.ajax({
             type: "GET",
             url: '../../../ModifyClient?DeleteClientId=' + DeleteClientId,
             success: function(data) {
                 if (data == 0) {
                     $('#centralModalDangerDemo').modal('hide');
                     $(".errorMsg").removeClass("HideThisElement");
                     $("#errorMsg").html(' <strong>Error!</strong> Failed to Delete Client!');
                 } else {
                     $('#centralModalDangerDemo').modal('hide');
                     $('#selectedEmployeeId').val('');
                     $('#datatables').DataTable().ajax.reload();
                     $(".successMsg").removeClass("HideThisElement");
                     $("#successMsg").html(' <strong>Success!</strong>  Client Deleted Successfully!');
                 }
             }
         })
         return false; // avoid to execute the actual submit of the form.
     });*/

});

function formSubmit() 
{
   spinnerOn();

	var dataCP = "&isDefault="+$("#isDefaultCP").is(":checked");
	var dataAdd = "&isDefault="+$("#isDefaultAdd").is(":checked");
 //   console.log($("#newElementForm").serialize()+" "+$("#insertAddressDetails").serialize()+" "+$("#insertContactPersonDetailsDetails").serialize()+" "+data+" "+data1);
    
    $.ajax({
        type: "POST",
        url: "clientRegister",
        data: $("#newElementForm").serialize(), // serializes the form's elements.
        success: function(data) 
        {
        	
            $.ajax({
                type: "POST",
                url: "clientAddressRegister",
                data: $("#insertAddressDetails").serialize()+'&clientId=' + $("#selectedClientId").val()+dataAdd, // serializes the form's elements.
                success: function(data) {
                    spinnerOff();

                    console.log("clientAdddressDetails",data);

                    $.ajax({

                        type: "POST",
                        url: "contactPersonRegister",
                        data: $("#insertContactPersonDetailsDetails").serialize() +'&clientId=' + $("#selectedClientId").val()+dataCP, // serializes the form's elements.
                        success: function(data)
                        {
                        	  console.log("contactPersonRegisterDetails", data);
                        
                        }
                    });

                    //window.location = 'showOrder';
                
                  
                  
                }
            
            });
            getClientList();
            window.location = 'showClient';
            SwalSuccess("Client  added Sucessfully");
        }
    });

}


                   function formSubmitContactDetils()
                   {
                	
                	   var dataCP = "&isDefault="+$("#isDefaultCP").is(":checked");
                	   
                	   $.ajax({
                           type: "POST",
                           url: "newContactDetails",
                           data: $("#insertContactPersonDetailsDetails").serialize()+'&clientId='+$("#selectedClientId").val()+dataCP, // serializes the form's elements.
                           success: function(data) 
                           {
                               spinnerOff();

                               console.log("newClientDetails",data);
                            
                                 if(data==703)
                                 {
                                	 $("#ClientFormDiv").addClass("HideThisElement");
                                	 $("#ClientViewDiv").removeClass("HideThisElement");
                                	 document.getElementById("insertContactPersonDetailsDetails").reset();
                                	 getCotactPerson();
                                	 
                                	 SwalSuccess("Client ContactPerson Added  Sucessfully");
                                 }
                                 else if(data==704){
                                	 SwalSuccess("No client added Sucessfully");
                                	 
                                 }
                                
                           }
                	   });
                   }
                    function formSubmitAddressDetails()
                    {
                    	var dataAdd = "&isDefault="+$("#isDefaultAdd").is(":checked");
                    	
                    	 $.ajax({
                             type: "POST",
                             url: "newAddressDetails",
                             data: $("#insertAddressDetails").serialize()+'&clientId=' + $("#selectedClientId").val()+dataAdd, // serializes the form's elements.
                             success: function(data) {
                                 spinnerOff();

                                 console.log("newAddressDetails",data);
                                   if(data==603)
                                   {
                                	   $("#ClientFormDiv").addClass("HideThisElement");
                                  	   $("#ClientViewDiv").removeClass("HideThisElement");
                                  	   document.getElementById("insertAddressDetails").reset();

                                  	   getAddress();
                                  	  
                                  	  	SwalSuccess("Client Address Details Added  Sucessfully");
                                   }
                                   else if(data==604){
                                  	 SwalSuccess("No client  Address added Sucessfully");
                                  	 
                                   }
                                  
                             }
                  	   });
                    }
 
            /* if (data == 501)
	            {
	                spinnerOff();

	                document.getElementById('newElementForm').reset();

	                SwalSuccess("Client Register Sucessfully");
	                $("#ClientTableDiv").removeClass("HideThisElement");
					$("#ClientFormDiv").addClass("HideThisElement");							
					$('#datatables').DataTable().ajax.reload();	
					$("#myTabContent").addClass("HideThisElement");		
					$("#SubmitButtonRegister").addClass("HideThisElement");
				    $("#SubmitButtonUpdate").addClass("HideThisElement");
				    $("#SubmitButtonBack").addClass("HideThisElement");	
	                getVendorList();

	                $("#vendorFormDiv").addClass("HideThisElement");
	                $("#venderTableDiv").removeClass("HideThisElement");
	            } 
	          else if (data == 502) 
	            {
	                spinnerOff();
	                //$("#contactNo").val("");
	                SwalWarning("Failed to Register New Client !");
	            }*/
            /*else if (data == 303) 
              {
                  spinnerOff();
                  //$("#gstNo").val("");
                  SwalWarning("GST No is Already Present!");
              }*/
                      function validateClientUpdate(){
                    	  
                          	    if ($("#companyName").val() == "")
                    	        SwalWarning("Company Name is mandatory !");
                    	    else if ($("#location").val() == "")
                    	        SwalWarning("Location is mandatory !");
                    	    else if ($("#customerType").val() == "")
                    	        SwalWarning("Customer Type is mandatory !");
                    	    else if ($("#creditTime").val() == "")
                    	        SwalWarning("Credit Time is mandatory !");

                    	    else if ($("#salesPerson").val() == "")
                    	        SwalWarning("Sales Person is not selected !");

                    	    else if ($("#source").val() == "")
                    	        SwalWarning("Source is not selected !");
                    	    else
                    	    	return true;

                    	  
                      }
                    function validateContactPerson() {
                    	 if ($("#firstName").val() == "")
                            SwalWarning("First Name is mandatory !");
                        else if ($("#locationCP").val() == "")
                            SwalWarning("Location is mandatory !");
                        else if ($("#mobileno").val() == "")
                            SwalWarning("Mobile Number is mandatory !");
                        else if ($("#emailId").val() == "")
                            SwalWarning("Email ID is mandatory !");
                        else if ($("#designation").val() == "")
                            SwalWarning("Designation is mandatory !");
                        else
                        	return true;
                    }
    
function validate() {

    if ($("#companyName").val() == "")
        SwalWarning("Company Name is mandatory !");
    else if ($("#location").val() == "")
        SwalWarning("Location is mandatory !");
    else if ($("#customerType").val() == "")
        SwalWarning("Customer Type is mandatory !");
    else if ($("#creditTime").val() == "")
        SwalWarning("Credit Time is mandatory !");

    else if ($("#salesPerson").val() == "")
        SwalWarning("Sales Person is not selected !");

    else if ($("#source").val() == "")
        SwalWarning("Source is not selected !");

    else if ($("#firstName").val() == "")
        SwalWarning("First Name is mandatory !");
    else if ($("#locationCP").val() == "")
        SwalWarning("Location is mandatory !");
    else if ($("#mobileno").val() == "")
        SwalWarning("Mobile Number is mandatory !");
    else if ($("#emailId").val() == "")
        SwalWarning("Email ID is mandatory !");
    else if ($("#designation").val() == "")
        SwalWarning("Designation is mandatory !");
    else if ($("#branchName").val() == "")
        SwalWarning("Branch Name is mandatory !");
    else if ($("#inputState").val() == "")
        SwalWarning(" State is mandatory !");
    else
    	return true;

}
 function ValidateAddressDetails(){
	   if ($("#branchName").val() == "")
	        SwalWarning("Branch Name is mandatory !");
	    else if ($("#inputState").val() == "")
	        SwalWarning(" State is mandatory !");
	    else
	    	return true;
 }     


function formUpdate() {
    spinnerOn();

    $.ajax({
        type: "POST",
        url: "updateClient",
        data: $("#newElementForm").serialize(), // serializes the form's elements.
        success: function(data) {
        	spinnerOff();
        	    if(data==1501)
        	    {
        	    	SwalSuccess("Client Updated Sucessfully");
        	    	  $("#ClientFormDiv").addClass("HideThisElement");
                 	   $("#ClientViewDiv").removeClass("HideThisElement");
        	    }
        	    
       	}
    });
}  
    function formUpdateContactPerson()
    {
    	var dataCP = "&isDefault="+$("#isDefaultCP").is(":checked");
    	console.log("datacp");
    	
    	
        $.ajax({

            type: "POST",
            url: "clientUpdateContactDetails",
            data: $("#insertContactPersonDetailsDetails").serialize() +'&clientId=' + $("#selectedClientId").val()+dataCP, // serializes the form's elements.
            success: function(data)
            {
                console.log("contactPersonRegisterDetails", data);
                if(data==1701)
                {
                	$("#ClientFormDiv").addClass("HideThisElement");
                	$("#ClientViewDiv").removeClass("HideThisElement");
               	 	document.getElementById("insertContactPersonDetailsDetails").reset();
               	 	getCotactPerson();
               	 
                	SwalSuccess("Client Contact Person Data updated Sucessfully");
                }
                else if (data==1702)
                {
                	SwalSuccess("No updated Contact Person");
                }

              
            }
        });
    	
    }
       function formUpdateAddress()
       {
    	   alert("called");
    		var dataAdd = "&isDefault="+$("#isDefaultAdd").is(":checked");
    		console.log("dta add",dataAdd);
    		alert(dataAdd);
    		
    		
    	   $.ajax({
               type: "POST",
               url: "clientUpdateAddressDetails",
               data: $("#insertAddressDetails").serialize()+'&clientId=' + $("#selectedClientId").val()+dataAdd, // serializes the form's elements.
               success: function(data) {
                   spinnerOff();

                   console.log("clientAdddressDetails",data);

                   if(data=1601)
                   {
                	   $("#ClientFormDiv").addClass("HideThisElement");
                  	   $("#ClientViewDiv").removeClass("HideThisElement");
                  	   document.getElementById("insertAddressDetails").reset();

                  	   getAddress();
                  	   
                   		SwalSuccess("Client Address Detail data updated  Sucessfully");
                   }
                   else if(data==1602){
                   	SwalSuccess("No updated Address Details");
                   }

                 
               }
           });
       	
    	   
       }
        	/*
     	
            $.ajax({
                type: "POST",
                url: "clientAddressupdate",
                data: $("#insertAddressDetails").serialize()+'&clientId=' + $("#selectedClientId").val(), // serializes the form's elements.
                success: function(data) {
                    spinnerOff();

                    console.log("clientAdddressDetails",data);

                    $.ajax({

                        type: "POST",
                        url: "contactPersonupdate",
                        data: $("#insertContactPersonDetailsDetails").serialize() +'&clientId=' + $("#selectedClientId").val(), // serializes the form's elements.
                        success: function(data)
                        {
                            console.log("contactPersonRegister Details", data);

                          
                        }
                    });

                    //window.location = 'showOrder';
                }
            });

             if (data == 501)
	            {
	                spinnerOff();

	                document.getElementById('newElementForm').reset();

	                SwalSuccess("Client Register Sucessfully");
	                $("#ClientTableDiv").removeClass("HideThisElement");
					$("#ClientFormDiv").addClass("HideThisElement");							
					$('#datatables').DataTable().ajax.reload();	
					$("#myTabContent").addClass("HideThisElement");		
					$("#SubmitButtonRegister").addClass("HideThisElement");
				    $("#SubmitButtonUpdate").addClass("HideThisElement");
				    $("#SubmitButtonBack").addClass("HideThisElement");	
	                getVendorList();

	                $("#vendorFormDiv").addClass("HideThisElement");
	                $("#venderTableDiv").removeClass("HideThisElement");
	            } 
	          else if (data == 502) 
	            {
	                spinnerOff();
	                //$("#contactNo").val("");
	                SwalWarning("Failed to Register New Client !");
	            }
            else if (data == 303) 
              {
                  spinnerOff();
                  //$("#gstNo").val("");
                  SwalWarning("GST No is Already Present!");
              }

            console.log(data);
        */
     

