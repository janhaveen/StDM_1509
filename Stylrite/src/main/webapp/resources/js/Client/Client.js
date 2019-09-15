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
    
	/*$('#newElementForm').on('focusout', '#mobileno', function() {
	    var mobile = $('#mobileno').val();
	    var selectedEmployeeId = document.querySelector('#selectedEmployeeId').value;
	    $.ajax({
    		type: "GET",
	        url: "../../../GetClientList?forDup=dup&mobile="+mobile+"&selectedEmployeeId="+selectedEmployeeId,
	        success: function(data)
	        {
				if(data.data.length>0){
	                document.querySelector('#alertMessage').innerHTML = "<center><strong>Duplicate!</strong> The Number You Entered Is Already In Use By " + data.data[0].employeeName + " !</center>";
	                $("#alertMessage").removeClass("HideThisElement");
	               // $("#alertMessage").delay(5000).fadeOut(100);
	                $("#SubmitButtonUpdate").addClass("disabled");
	                $("#SubmitButtonUpdate").attr("disabled", true);
	                $("#SubmitButtonRegister").addClass("disabled");
	                $("#SubmitButtonRegister").attr("disabled", true);
		        } else {
		            $("#alertMessage").addClass("HideThisElement");
		            $("#SubmitButtonUpdate").removeClass("disabled");
		            $("#SubmitButtonUpdate").attr("disabled", false);
		            $("#SubmitButtonRegister").removeClass("disabled");
		            $("#SubmitButtonRegister").attr("disabled", false);
		        }
	        }
	    });
	});*/
	
	/*$('#newElementForm').on('focusout', '#UserId', function() {
	    var usrid = document.querySelector('#UserId').value;
	    var selectedEmployeeId = document.querySelector('#selectedEmployeeId').value;
	    $.ajax({
    		type: "GET",
	        url: "../../../GetEmployeeList?forDup=dup&usrid="+usrid+"&selectedEmployeeId="+selectedEmployeeId,
	        success: function(data)
	        {
				if(data.data.length>0){
	                document.querySelector('#alertMessage').innerHTML = "<strong>Duplicate!</strong> The User Id You Entered Is Already In Use By " + data.data[0].employeeName + " !";
	                $("#alertMessage").removeClass("HideThisElement");
	                $("#SubmitButtonUpdate").addClass("disabled");
	                $("#SubmitButtonUpdate").attr("disabled", true);
	                $("#SubmitButtonRegister").addClass("disabled");
	                $("#SubmitButtonRegister").attr("disabled", true);
		        } else {
		            $("#alertMessage").addClass("HideThisElement");
		            $("#SubmitButtonUpdate").removeClass("disabled");
		            $("#SubmitButtonUpdate").attr("disabled", false);
		            $("#SubmitButtonRegister").removeClass("disabled");
		            $("#SubmitButtonRegister").attr("disabled", false);
		        }
	        }
	    });
	});*/
	
	$("#SubmitButtonRegister").click(function() {
    	formSubmit("new"); 
    	return false;
    });
    
    $("#SubmitButtonUpdate").click(function() {
    	formSubmit("edit");
    	return false;
    });
    
    $("#SubmitButtonBack").click(function() {
	    $("#ClientTableDiv").removeClass("HideThisElement");
		$("#ClientViewDiv").addClass("HideThisElement");
		$("#ClientFormDiv").addClass("HideThisElement");
    });
    
    $("#SubmitButtonBackFromView").click(function() {
	    $("#ClientTableDiv").removeClass("HideThisElement");
		$("#ClientViewDiv").addClass("HideThisElement");
		$("#ClientFormDiv").addClass("HideThisElement");
    });
    
    $("#DeleteClientConfirmed").click(function() {
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
    });
});

function formSubmit(type){
	console.log(type);
	var ret=false;
	var url = "";
	if(type=="new")
	{
		url="registerCustomer";
	}else
	{
		url="updateCustomer";
	}
	if($("#action").val()=="insert"){
		if (document.getElementById("companyName").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Company Name is mandatory !";
			$("#alertMessage").removeClass("HideThisElement"); 
		} else if (document.getElementById("location").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Location is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		} else if (document.getElementById("customerType").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Customer Type is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		} else if (document.getElementById("creditTime").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Credit Time is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		}else if (document.getElementById("salesPerson").value ==  "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Sales Person is not selected !";
			$("#alertMessage").removeClass("HideThisElement");
		} else if (document.getElementById("source").value ==  "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Source is not selected !";
			$("#alertMessage").removeClass("HideThisElement");
		} else if (document.getElementById("firstName").value ==  "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> First Name is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		} /*else if (document.getElementById("lastName").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Last Name is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		}*/  else if (document.getElementById("locationCP").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Location is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		} else if (document.getElementById("mobileno").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Mobile Number is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		} else if (document.getElementById("emailId").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Email ID is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		}  /*else if (document.getElementById("department").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Department is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		} */else if (document.getElementById("designation").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Designation is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		} /*else if (document.getElementById("birthDate").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Birth Date is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		}*/else if (document.getElementById("branchName").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Branch Name is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		}else if (document.getElementById("inputState").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> State is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		}else{
			submitPart(url);
			return false;
	    }
	}
	if ($("#action").val()=="updateClient" ) {
		if (document.getElementById("companyName").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Company Name is mandatory !";
			$("#alertMessage").removeClass("HideThisElement"); 
		} else if (document.getElementById("location").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Location is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		} else if (document.getElementById("customerType").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Customer Type is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		} else if (document.getElementById("creditTime").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Credit Time is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		}else if (document.getElementById("salesPerson").value ==  "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Sales Person is not selected !";
			$("#alertMessage").removeClass("HideThisElement");
		} else if (document.getElementById("source").value ==  "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Source is not selected !";
			$("#alertMessage").removeClass("HideThisElement");
		} else{
			submitPart(url);
			return false;
	    }
	}
	if ($("#action").val()=="updateContactPerson"   || $("#action").val()=="insertContactPerson") {
		 if (document.getElementById("firstName").value ==  "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> First Name is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		} /*else if (document.getElementById("lastName").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Last Name is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		}*/  else if (document.getElementById("locationCP").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Location is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		} else if (document.getElementById("mobileno").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Mobile Number is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		} else if (document.getElementById("emailId").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Email ID is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		} /* else if (document.getElementById("department").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Department is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		}*/ else if (document.getElementById("designation").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Designation is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		} /*else if (document.getElementById("birthDate").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Birth Date is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		}*/else{
			submitPart(url);
			return false;
	    }
	}
	if ($("#action").val()=="updateAddress" || $("#action").val()=="insertAddress") {
		if (document.getElementById("branchName").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Branch Name is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		}else if (document.getElementById("inputState").value == "") {
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> State is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		}else{
			submitPart(url);
			return false;
	    }
	}
}

function submitPart(url) {
	var data = "";
	if($("#action").val() != "insert")
	{
		if($("#action").val()=="insertContactPerson" || $("#action").val()=="updateContactPerson")
		{
			data = "&isDefault="+$("#isDefaultCP").is(":checked");
		}
		else if($("#action").val()=="insertAddress" || $("#action").val()=="updateAddress")
		{
			data = "&isDefault="+$("#isDefaultAdd").is(":checked");
		}
	}
	console.log($("#newElementForm").serialize());
	$.ajax({
		
       type: "POST",
       url: url,
       data: $("#newElementForm").serialize()+data,
       success: function(data)
       {
           if (data == 1) {
        	   $("#ClientTableDiv").removeClass("HideThisElement");
				$("#ClientFormDiv").addClass("HideThisElement");							
				$('#datatables').DataTable().ajax.reload();	
        	   document.getElementById("newElementForm").reset();
				$("#alertMessage").addClass("HideThisElement");
				$("#errorMessage").addClass("HideThisElement");	
				if(data==501){
					
					document.querySelector('#successMsg').innerHTML = "<strong>Success!</strong> Client Details Registered Successfully !";
					$(".successMsg").removeClass("HideThisElement");
				}else {
					document.querySelector('#successMsg').innerHTML = "<strong>Success!</strong> Client Details Updated Successfully !";
					$(".successMsg").removeClass("HideThisElement");
				}
				$("#myTabContent").addClass("HideThisElement");		
				$("#SubmitButtonRegister").addClass("HideThisElement");
			    $("#SubmitButtonUpdate").addClass("HideThisElement");
			    $("#SubmitButtonBack").addClass("HideThisElement");	
				//setTimeout(function(){
					
				// }, 3000);		
			} else{
				if(data==502){
					document.querySelector('#errorMsg').innerHTML = "<strong>Error!</strong> Failed to Register New Client !";
					$(".errorMsg").removeClass("HideThisElement");
				}else{
					document.querySelector('#errorMsg').innerHTML = "<strong>Error!</strong> Failed to Update Client !";
					$(".errorMsg").removeClass("HideThisElement");
				}
			}
       }
	});
}