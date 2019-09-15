function DropDownForReturnStatus() 
{
	var ourRequest1 = new XMLHttpRequest();
    var data1 = [];
    ourRequest1.open('GET', '../../../GetReturnItemStatus');
    ourRequest1.onload = function() 
    {
      if (ourRequest1.status >= 200 && ourRequest1.status < 400)
      {
    	data1 = JSON.parse(ourRequest1.responseText);
        createHTML1(data1); createHTML2(data1); 
      }
      else 
      {
        console.log("We connected to the server, but it returned an error.");
      }
    };
    ourRequest1.onerror = function() 
    {
      console.log("Connection error");
    };
    
    ourRequest1.send();
    
    function createHTML1(Data) 
    {
    	var options1;
    	$('#customerStatus').empty();
        options1 = '<option value="" selected>Select Customer Status</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subCategory == "Customer Status") 
        	{
        		options1 += "<option id = 'customer' value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
        		/*
        		if(Data.data[i].description == "Closed-CN-Raised")
        		{
        			$("#creditNoteDetails").removeClass("HideThisElement");
        		}
        		else
        		{
        			$("#creditNoteDetails").addClass("HideThisElement");
        		}*/
    		}
        }
        $('#customerStatus').html(options1);
       // $('#turnOver').material_select('refresh');
    }
    
    function createHTML2(Data) 
    {
    	var options2;
    	$('#vendorStatus').empty();
        options2 = '<option value="" selected>Select Vendor Status </option>';
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subCategory == "Vendor Status") 
        	{
        		options2 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
        	}
   
        }
        $('#vendorStatus').html(options2);
               
    	/*if(options2 == "Closed-CN-Raised")
    	{
        	$("#creditNoteDetails").removeClass("HideThisElement");
    	}*/
        //$('#employeeStrength').material_select('refresh');
    }
}