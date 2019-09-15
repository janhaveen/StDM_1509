/*$(document).ready(function()
{*/
	function openNav() 
	{
		if(!$("#mySidenav").hasClass("viewDiv"))
		{
		    document.getElementById("mySidenav").style.width = "230px";
		    $("#mySidenav").addClass("viewDiv");
		}
		else
		{
			document.getElementById("mySidenav").style.width = "0px";
			$("#mySidenav").removeClass("viewDiv");
		}
	}

	/* function closeNav() {
	    document.getElementById("mySidenav").style.width = "0px";
	} */
	$( function() 
		{
		//ourRequest1.send();

		
	   $( ".datepicker" ).datepicker({
		   format: "yyyy-mm-dd",
		   orientation:"bottom"
	   });
	   $('.datepicker').datepicker()
	   .on('change', function(e) { 
	   		$('.datepicker').datepicker('hide');
	   });
	   $('body').on('click', function (e) { 
		    //did not click a popover toggle or popover
		    if ($(e.target).data('toggle') !== 'popover'
		        && $(e.target).parents('.popover.in').length === 0) { 
		        $('[data-toggle="popover"]').popover('hide');
		    }	    
		});
		casio = 0;
		$.d('casioInt',setInterval(function(){
			casio++;
			var a={pathStrokeWidth:5};
			if (casio==361) casio = 1;
			a.startAng = casio;
			a.endAng = casio + 90;
			$('#casio').drawCircle(a);
		},1));
	   $('.container').on('click', function (e) {  
		   if($("#mySidenav").hasClass("viewDiv")){
			   document.getElementById("mySidenav").style.width = "0px";
				$("#mySidenav").removeClass("viewDiv");
			}
		});
	 });
	 

	function SwalWarning(msg)
	{
		swal({
			  text: msg,
			  type: "warning",
			  confirmButtonText: "Ok!",
			  closeOnConfirm: false
			});
	}
	function SwalError(msg)
	{
		swal({
			  text: msg,
			  type: "error",
			  confirmButtonText: "Ok!",
			  closeOnConfirm: false
			});
	}

	function SwalSuccess(msg)
	{
		swal({
			  text: msg,
			  type: "success",
			  confirmButtonText: "Ok!",
			  closeOnConfirm: false
			});
	}

	function spinnerOn() {
	    document.getElementById("overlay").style.display = "block";
	}

	function spinnerOff() {
	  document.getElementById("overlay").style.display = "none";
	}
	
//});
	/*//$(".button-collapse").sideNav();
	//$('.datepicker').pickadate();
    
	var container = document.getElementById('slide-out');
	Ps.initialize(container, {
	    wheelSpeed: 2,
	    wheelPropagation: true,
	    minScrollbarLength: 20
	});
	
	casio = 0;
	$.d('casioInt',setInterval(function(){
		casio++;
		var a={pathStrokeWidth:5};
		if (casio==361) casio = 1;
		a.startAng = casio;
		a.endAng = casio + 90;
		$('#casio').drawCircle(a);
	},1));
});

function SwalWarning(msg)
{
	swal({
		  text: msg,
		  type: "warning",
		  confirmButtonText: "Ok!",
		  closeOnConfirm: false
		});
}
function SwalSuccess(msg)
{
	swal({
		  text: msg,
		  type: "success",
		  confirmButtonText: "Ok!",
		  closeOnConfirm: false
		});
}
function SwalError(msg)
{
	swal({
		  text: msg,
		  type: "error",
		  confirmButtonText: "Ok!",
		  closeOnConfirm: false
		});
}

function SwalDelete(msg, rowno) 
{
	swal
	({
		  title: 'Are you sure?',
		  text: msg,
		  type: 'warning',
		  showCancelButton: true,
		  confirmButtonText: 'Yes, Add it!',
		  cancelButtonText: 'No !'
		}).then(function() {
		  swal(
			'Deleted!',
			'Your file has been deleted.',
			'success'
		  );
		  //$("#ItemQty"+ data.rowId).val(parseInt($("#ItemQty"+ data.rowId).val())+1);
		}, function(dismiss)
		{
		  if (dismiss === 'cancel')
		  {
		    swal(
		      'Ok',
		      'Cancelled !)',
		      'error'
		    )
		  }
	});
}

function spinnerOn() {
    document.getElementById("overlay").style.display = "block";
}

function spinnerOff() {
  document.getElementById("overlay").style.display = "none";
}*/