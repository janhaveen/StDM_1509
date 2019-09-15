function dropdownFunctionForBarcodeLegend() 
{
    var ourRequest1 = new XMLHttpRequest();
    var data1 = [];
    ourRequest1.open('GET', 'getBarcodeLegend');
    ourRequest1.onload = function()
    {
        if (ourRequest1.status >= 200 && ourRequest1.status < 400) 
        {
            data1 = JSON.parse(ourRequest1.responseText);
            createHTML1(data1);
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
        var options3;
        $('#status').empty();
        options3 = '<option value="" selected>Select Status</option>'
        for (i = 0; i < Data.data.length; i++)
        {
            if (Data.data[i].category == "Status") 
            {
                options3 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
            }
        }
        $('#status').html(options3);
    }
}