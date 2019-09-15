$(document).ready(function(){
	 $("#HomeText").text("view Order (ID:"+$("#oid").val()+")");
	 var str="?1=1&oid="+$("#oid").val();
	 if($("#type").val()){
    	str+="&type="+$("#type").val();
     }
	 $.ajax({
		url:"GetOrderList",
		type:"GET",
		success:function(data){
			$('#ProductDataBody').html("");
			for (var i = 0; i < data.data.length; i++) {
				var html="<tr>"
						+"<td>"+data.data[i].i+"</td>"
						+"<td>"+data.data[i].productInfo+"</td>"
						+"<td>"+data.data[i].skuid+"</td>"
						+"<td>"+data.data[i].quantity+"</td>"
						+"<td>"+data.data[i].status_txt+"</td>"
						"<tr>";
				document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', html);
			}
		}
	 });
});