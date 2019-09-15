$(document).ready(function() {
	/*$("input:checkbox").on('click', function() { console.log("gasch");
	    
	});*/
});

function getDataForPermission() {
    $.ajax({
        url: "GetPermissionLegend",
        type: "GET",
        success: function(data) {
            var j = 0;
            var k = 0;
            var obj = [];
            for (var i = 0; i < data.data.length; i++) {
            	var text1='<div class="col-lg-3 col-md-12 mb-r">'+
		                '<div class="form-group">'+
		                    '<input type="checkbox"  style="margin-right: 4%;" id="'+data.data[i].rowId+'Div" value="'+data.data[i].rowId+'">'+
		                    '<label for="'+data.data[i].rowId+'Div" id="'+data.data[i].rowId+'DivLbl" style="font-size: large;"> '+data.data[i].description+'</label>'+
		                '</div>'+
		                '<div id="'+data.data[i].rowId+'Grp" style="padding-left: 4%;">'+
		                '</div>'+            	
            		 '</div>';
            	$('#apppendDiv').append(text1);	
            	//console.log(document.querySelector('#'+data.data1[j].subCategory+'Grp'));
            }
            for (var j = 0; j < data.data1.length; j++) {
            	var text='<div class="form-group">'+
		                    '<input type="checkbox" style="margin-right: 4%;" onclick="onCheckboxSelected(this)" id="'+data.data1[j].rowId+'Div" name="'+data.data1[j].subCategory+'Div" value="'+data.data1[j].rowId+'">'+
		                    '<label for="'+data.data1[j].rowId+'Div" id="employeeDivLbl"> '+data.data1[j].description+'</label>'+
		                '</div>';
            	 $('#'+data.data1[j].subCategory+'Grp').append(text);		           
			}
        }
    });
}

function onCheckboxSelected(element) {
	var $box = $(element);
    if ($box.is(":checked")) {
        var group = "input:checkbox[id='" + $box.attr("name") + "']";
        $(group).prop("checked", true);
    } else {
        var group = "input:checkbox[id='" + $box.attr("name") + "']";
        var names = "input:checkbox[name='" + $box.attr("name") + "']";
        $(group).prop("checked", false);
        $('input[type=checkbox]').each(function() {
            if (this.checked) {
                var $box = $(this);
                var group = "input:checkbox[id='" + $box.attr("name") + "']";
                $(group).prop("checked", true);
            }
        });
    }
}