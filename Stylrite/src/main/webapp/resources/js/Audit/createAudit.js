$(document).ready(function()
{
	$("#HomeText").html("New Audit");
	
	$("#headerName").html("New Audit");
	
	DropDownForAudit();
	
	$("#ContinueButtonCreateAudit").click(function() 
    {
    		if(validate())
    		continueAuditReason();
    });

});

function validate() 
{
	if($("#auditReason").val()=="")
		SwalWarning("Select Audit Reason!");
	else if($("#section").val()=="")
		SwalWarning("Select Section!");
	else 
		return true;
}

function continueAuditReason()
{
	spinnerOn();
	
	var generator = new IDGenerator();
	
	$("#auditId").val("A"+generator.generate());
	
	$.ajax
    ({
          type: "POST",
          url: "continueAndCreateAuditReason",
          data: $("#insertCreateAuditForm").serialize()+"&rowId="+$("#auditId").val(), // serializes the form's elements.
          success: function(data)
          {
        	spinnerOff();
        	
        	console.log(data);
        	
        	window.location.href="viewAudit?auditId="+$("#auditId").val()+"&section="+$("#section").val();
        	
          },
		  error : function ()
		  {
			  
		  }
    
      });
}


