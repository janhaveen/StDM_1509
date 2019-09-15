function DropDownForEmployee(id) {
	var ourRequest1 = new XMLHttpRequest();
    var data1 = [];
    ourRequest1.open('GET', 'GetEmployeeList');
    ourRequest1.onload = function() {
      if (ourRequest1.status >= 200 && ourRequest1.status < 400) {
    	data1 = JSON.parse(ourRequest1.responseText);
        createHTML1(data1);  createHTML2(data1); 
        createHTML5(data1); createHTML6(data1); createHTML7(data1);
        createClientSalesPerson(data1);createHTMLSalesPerson(data1);
      } else {
        console.log("We connected to the server, but it returned an error.");
      }
    };
    ourRequest1.onerror = function() {
      console.log("Connection error");
    };
    ourRequest1.send();
    
    
    function createHTML1(Data) {
    	var options1;
    	$('#branchManager').empty();
        options1 = '<option value="" selected>Select Warehouse Manager</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	options1 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].empname + "</option>";
        }
        $('#branchManager').html(options1);
    }

    function createHTML2(Data) {
    	var options2;
    	$('#SalesPerson').empty();	$('#SalesPersonR').empty();  $("#newCustomerForm #SalesPerson").empty(); 
    	$("#newElementForm #salesPerson").empty();//$('#SalesPersonF').empty(); $('#SalesPersonT').empty();
        options2 = '<option value="" selected>Select Sales Person</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	if(Data.data[i].deptText=="Sales")
        		options2 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].empname + "</option>";
    		//}
        }
        $('#SalesPerson').html(options2);	$('#SalesPersonR').html(options2);	$("#newCustomerForm #SalesPerson").html(options2); 
        $("#newElementForm #salesPerson").html(options2);
         $('#SalesPersonT').html(options2);
    }
    
    function createHTML5(Data) {
    	var options5;
    	$('#AssignedTo').empty();
        options5 = '<option value="" selected>Select Assigned To</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        		options5 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].empname + "</option>";
        }
        $('#AssignedTo').html(options5);
    }
    
    function createHTML6(Data) {
    	var options6;
    	$('#VisibilityTo').empty();
        options6 = '<option value="" selected>Select Visibility To</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        		options6 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].empname + "</option>";
        }
        $('#VisibilityTo').html(options6);
    }
    
    function createHTML7(Data) {
    	var options7;
    	$('#TransferTo').empty();
        options7 = '<option value="" selected>Select Sales Person</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].department == "2" && Data.data[i].rowId !="") 
        		options7 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].empname + "</option>";
        }
        $('#TransferTo').html(options7);
    }
    
    function createClientSalesPerson(Data) {
    	var options6;
    	$('#clientSalesPerson').empty();
        options6 = '<option value="" selected>Select Sales Person</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        	if(Data.data[i].deptText=="Sales" || Data.data[i].deptText=="Management" )
        		options6 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].empname + "</option>";
        }
       /* options1 += "<option value=Other>Other</option>";*/
        $('#clientSalesPerson').html(options6);
    }
    
    function createHTMLSalesPerson(Data) {
    	var optionsSalesPerson;
    	$('#SalesPersonF').empty();
    	optionsSalesPerson = '<option value="" selected>Select Sales Person</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	console.log("...........",Data.data[i]);
        	if(Data.data[i].deptText=="Sales" || Data.data[i].deptText=="Operations" )
        		optionsSalesPerson += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].empname + "</option>";
    		//}
        }      
        $('#SalesPersonF').html(optionsSalesPerson); 
    }
}