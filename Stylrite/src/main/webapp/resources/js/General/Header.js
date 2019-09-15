function DownloadLocationwiseStock(status){
	var filename="";
	if(status.indexOf("101")>=0) filename="StockIn";
	else filename="Sample";
    $.ajax({
    	url:"http://localhost:8087/Stylrite/ExportBarcodeAsCSV?status="+status,
    	type:"GET",
        headers: {  'Access-Control-Allow-Origin': '*' },
        beforeSend: function() {
        	spinnerOn();
        },
    	success:function(data){ 
    		JSONToCSVConvertor(data.data, filename+'.csv', 'yes');
    	},
        complete: function() {
        	spinnerOff();
        }
    });
}