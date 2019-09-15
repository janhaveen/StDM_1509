function DropDownForProductLegend() {
 	var ourRequest2 = new XMLHttpRequest();
    var data2 = [];
    ourRequest2.open('GET', 'getProductLegendList');
    ourRequest2.onload = function() {
      if (ourRequest2.status >= 200 && ourRequest2.status < 400) { 
    	  data2 = JSON.parse(ourRequest2.responseText);
    	  createHTML1(data2); createHTML2(data2);
      } else {
    	  console.log("We connected to the server, but it returned an error.");
      }
    };
    ourRequest2.onerror = function() {
    	console.log("Connection error");
    };
    ourRequest2.send();
    
    function createHTML1(Data)
    {
    	var options1="";
    	$("#brandFrm select").html('');
        for (i = 0; i < Data.data.length; i++){ 
        	if(Data.data[i].subCategory=="Brand"){
        		options1 += "<option value='" + Data.data[i].rowId + "' id='"+Data.data[i].otherInfo+"'>" + Data.data[i].description + "</option>";
        	}
        }console.log(options1);
        $("#brandFrm select").html(options1);
		$('#brandFrm select').selectpicker('refresh');
		
	}
    
    function createHTML2(Data) 
    {
    	var options2;
    	$('#type').empty();
    	options2 = '<option value="" selected>Select Product Type</option>'
        for (i = 0; i < Data.data.length; i++)
        { 
        	if(Data.data[i].subCategory=="Product Type"){
        		options2 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
        	}
        }
        $('#type').html(options2); 
    }
}