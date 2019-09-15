$(document).ready(function(){
	spinnerOn();
   /* if(window.location.href.indexOf("JSPs/Order.jsp")<0 && window.location.href.indexOf("JSPs/Return.jsp")<0){
    	$('#SelectClientModal').on('shown.bs.modal', function (e) {
        	$('#datatables').DataTable().destroy();
        	//vendorTable();
    	});
    }else{
    	$('#datatables').DataTable().destroy();
    }
*/
    dropdownFunctionForState();
	DropDownForEmployee("");  
	DropDownForLegend();

	getClientList();

});

// get Client List Data
function getClientList() 
{
	$('#datatables thead #filterrow th').each( function () 
			{
		    	var title = $(this).text();
		        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
		    });
			
		    $("#datatables thead input").on('keyup change', function () {
		        table.column($(this).parent().index() + ':visible')
		            .search(this.value)
		            .draw();
		    });
		    
		    var actionStr = "";
			$('#datatables').DataTable().destroy();
		    if(window.location.href.indexOf("showClient")<0)
		    {
		    	actionStr = '<i class="select_me_client fa fa-check fa-2x" aria-hidden="true"></i> ';
		    }
		    else
		    {
		    	actionStr = '<i class="edit_me fa fa-pencil-alt fa-2x" aria-hidden="true"></i> '+
		        '<i class="delete_me fa fa-trash fa-2x " aria-hidden="true"></i>';
		    }
		    
			var table = $('#datatables').DataTable( {
		        buttons: [
		            {
		                text: 'New Client',
		                action: function ( e, dt, node, config ) {
		                	loadBlankform();
		                }
		            }
		        ],dom: 'Bfrtip',
				"bLengthChange": true,
				"searching": true,
				"orderCellsTop": true ,
				"sScrollX": "100%",
		        "sScrollXInner": "100%",
		        "bScrollCollapse": true,
				"ajax": "GetClientList",
				"columns": [
		        	 {
		             	className: "center",
		                 defaultContent: actionStr
		             },
		            { "data": "companyName" },
		            { "data": "location" },
		            { "data": "contactPerson" },
		            { "data": "contactNoCP" },
		            { "data": "altContactNoCP" },
		            { "data": "emailIdCP" }
		        ],
		        fixedColumns: true,
		        "initComplete": function(settings, json) {   
		        	spinnerOff();
		        }
		    });
			
		    $('#datatables tbody').off('click');
			
			$('#datatables tbody').on('click', '.edit_me', function() {
				console.log("edit click",data);
			    $("#ClientTableDiv").addClass("HideThisElement");
				$("#ClientViewDiv").removeClass("HideThisElement");
				$("#ClientFormDiv").addClass("HideThisElement");

				var data = table.row($(this).parents('tr')).data();
				console.log(data);
			    document.getElementById("newElementForm").reset();
			    document.querySelector('#selectedClientId').value = data.rowId;
				$("#companyNameText").text(data.companyName);
				$("#locationText").text(data.location);
				$("#customerTypeText").text(data.customerType_txt);
				console.log(1);
				$("#sourceText").text(data.source_text);
				console.log(data.source_text);
				$("#creditTimeText").text(data.creditTime);
				$("#creditLimitText").text(data.creditLimit);
				$("#salesPersonText").text(data.salesPerson_text);
			    getCotactPerson();
			    getAddress();
			    
				$("#companyName").val(data.companyName);
				$("#location").val(data.location);
				//document.querySelector('#customerType').value = data.customerType;    
				//console.log($("#customerType").val(data.customerType), $("#customerType").val(), data.customerType);
			  //  $("#customerType").val(data.customerType);
			    $('#customerType').val(data.customerType);
				$("#creditTime").val(data.creditTime);
				$("#creditLimit").val(data.creditLimit);
				$("#salesPerson").val(data.salesPerson);
				$("#source").val(data.source);
			});
			
			$('#editClick').click(function() {
				console.log($("#customerType").val());
				$("#ClientViewDiv").addClass("HideThisElement");
				$("#ClientFormDiv").removeClass("HideThisElement");
				
				$("#ClientFormDiv #myTab").addClass("HideThisElement");
				$("#ClientFormDiv #ClientDetails").removeClass("HideThisElement");
				$("#ClientFormDiv #ContactPersonDetails").addClass("HideThisElement");
				$("#ClientFormDiv #AddressDetails").addClass("HideThisElement");
				
				$("#ClientFormDiv #ClientDetails").addClass("active");
				$("#ClientFormDiv #AddressDetails").removeClass("active");
				$("#ClientFormDiv #ContactPersonDetails").removeClass("active");
				
				$("#ClientFormDiv #ClientDetails").addClass("show");
				$("#ClientFormDiv #AddressDetails").removeClass("show");
				$("#ClientFormDiv #ContactPersonDetails").removeClass("show");

				$("#ClientFormDiv .card-title").html("Update Client");

				$("#ClientFormDiv #SubmitButtonRegister").addClass("HideThisElement");
				$("#SubmitButtonUpdateAddress").addClass("HideThisElement");
				$("#ClientFormDiv #SubmitButtonUpdate").removeClass("HideThisElement");
				$("#ClientFormDiv #action").val("updateClient");
				
			});
		    
		    $('#datatables tbody').on( 'click', '.delete_me', function () {
		    	var data = table.row( $(this).parents('tr') ).data();
		    	document.querySelector('#DeleteClientId').value = data.rowId;
		    	  var rowId = data.rowId;

		          console.log(data);

		          //deleteCustomer(rowNo);
		          SwalDelete("It will permanently deleted !", data.rowId);
		      });
		  }

		  function SwalDelete(msg, rowno) {
		      swal
		          ({
		              title: 'Are you sure?',
		              text: msg,
		              type: 'warning',
		              showCancelButton: true,
		              confirmButtonText: 'Yes, delete it!',
		              cancelButtonText: 'No !'
		          }).then(function() {
		              swal(
		                  'Deleted!',
		                  'Your file has been deleted.',
		                  'success'
		              );
		              deleteClient(rowno);
		          }, function(dismiss) {
		              if (dismiss === 'cancel') {
		                  swal(
		                      'Ok',
		                      'Cancelled !',
		                      'error'
		                  )
		              }
		          });
		  }

		  function deleteClient(rowId) {
		      $.ajax({
		          type: "POST",
		          url: "deleteClient?rowId="+rowId,
		          data:  $(this).serialize(), // serializes the form's elements.
		          success: function(data) {
		              if (data == 81) {
		            	  getClientList();
		              }
		          },
		          error: function() {

		          }
		      });
		  }

function loadBlankform() 
{
	console.log("Hi");
	document.getElementById("newElementForm").reset();
	document.getElementById("insertAddressDetails").reset();
	document.getElementById("insertContactPersonDetailsDetails").reset();
	$("#isDefaultCP").attr("checked", true);
	$("#isDefaultAdd").attr("checked", true);
	$("#ClientFormDiv .card-title").html("New Client");
	$("#ClientFormDiv #myTab").removeClass("HideThisElement");
	$("#myTabContent").removeClass("HideThisElement");
	$("#ClientFormDiv #ClientDetails").removeClass("HideThisElement");
	$("#ClientFormDiv #ContactPersonDetails").removeClass("HideThisElement");
	$("#ClientFormDiv #AddressDetails").removeClass("HideThisElement");
	$("#SubmitButtonRegister").removeClass("HideThisElement");
	$("#SubmitButtonContactPerson").addClass("HideThisElement");
	$("#SubmitButtonAddressDetails").addClass("HideThisElement");
	$("#SubmitButtonUpdate").addClass("HideThisElement");
	$("#SubmitButtonUpdateAddress").addClass("HideThisElement");
	$("#SubmitButtonUpdateContactPerson").addClass("HideThisElement");
	$("#SubmitButtonBack").removeClass("HideThisElement");	    
	$("#successMessage").addClass("HideThisElement");
	$("#statuscheckbox").attr("disabled",true);
	$("#ClientTableDiv").addClass("HideThisElement");
	$("#ClientFormDiv").removeClass("HideThisElement");
	$("#action").val("insert");
	var generator = new IDGenerator();
	DropDownForLegend();
	DropDownForEmployee("");
	dropdownFunctionForState();
	$("#selectedClientId").val("C"+ generator.generate());
	$("#selectedClientAddressId").val("CA"+ generator.generate());
	$("#selectedClientContactPersonId").val("CCP"+ generator.generate());
}