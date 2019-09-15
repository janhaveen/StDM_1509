$(document).ready(function() {

    getOrderStatus();
    $("#Backbtn").click(function() 
   	{
        $("#tableDiv").removeClass("HideThisElement");
        $("#ViewDiv").addClass("HideThisElement");
    });
});

function getOrderStatus() {
    $('#datatablesOrder').DataTable().destroy();

    $('#datatablesOrder thead #filterrow th').each(function() {
        var title = $(this).text();
        $(this).html('<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="' + title + '" />');
    });

    $("#datatablesOrder thead input").on('keyup change', function() {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });

    var actionStr = "";
    if (window.location.href.indexOf("JSPs/Order.jsp") < 0) {
        actionStr = '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> ';
    } else {
        actionStr = '<i class="select_me_order1 fa fa-eye fa-2x" aria-hidden="true"></i> ' +
            '<i class="delete_me fa fa-trash fa-2x HideThisElement" aria-hidden="true"></i>';
    }

    var str = "?1=1&list=y";
    if ($("#type").val()) {
        str += "&type=" + $("#type").val();
        /*if($("#type").val()=="c")
        	$("#HomeText").text("Completed Order List");
        else if($("#type").val()=="p")
        	$("#HomeText").text("Pending Order List");*/
    } else
        $("#HomeText").text("Order List");

    var table = $('#datatablesOrder').DataTable({
        dom: 'Bfrtip',
        buttons: [{
            text: 'New Order',
            action: function(e, dt, node, config) {
                loadBlankformForOrder();
            }
        }],
        "bLengthChange": true,
        "searching": true,
        "orderCellsTop": true,
        "lengthMenu": [
            [10, 25, 50, -1],
            [10, 25, 50, "All"]
        ],
        "bPaginate": true,
        "sPaginationType": "full_numbers",
        "iDisplayLength": 10,
        "sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
        "ajax": {
            "url": "GetOrderListStatus",
            "dataSrc": "",
        },
        "columns": [{
                className: "center",
                defaultContent: actionStr
            },
            //{ "data": "i" },
            { "data": "orderdate" },
            { "data": "orderId" },
            { "data": "companyName" },
            { "data": "clientLocation" },
            { "data": "cpname" },
            { "data": "contactNo" },
            { "data": "spname" },
            { "data": "count" }

        ],
        /*columnDefs: [
            { width: '25pc', targets: 1 },
            { width: '30pc', targets: 2 }
        ],*/
        fixedColumns: true
    });

    $('#datatablesOrder tbody').off('click');

    $('#datatablesOrder tbody').on('click', '.select_me', function() {
        var data = table.row($(this).parents('tr')).data();
        getOrderData(data.orderId);
        $("#tableDiv").addClass("HideThisElement");
        $("#ViewDiv").removeClass("HideThisElement");
        //window.location.href="ViewOrder.jsp?t="+$("#type").val()+"&oid="+data.orderId;
    });

    $('#datatablesOrder tbody').on('click', '.delete_me', function() {
        var data = table.row($(this).parents('tr')).data();
        document.querySelector('#DeleteOrderId').value = data.orderId;
        $('#centralModalDangerDemo').modal('show');
    });
}

function getOrderData(oid) {
    $('#ProductDataBody').html("");
    spinnerOn();
    $("#HomeText").text("view Order (ID:" + oid + ")");
    var str = "?1=1&oid=" + oid;
    //   	 if($("#type").val()){
    //       	str+="&type=c";
    //     }
    $.ajax({
        url: "../../../CompletedOrderItem" + str,
        type: "GET",
        success: function(data) {
            for (var i = 0; i < data.data.length; i++) {
                var html = "<tr>" + "<td>" + data.data[i].i + "</td>" + "<td>" + data.data[i].skuid + "</td>" + "<td>" + data.data[i].quantity + "</td>" + "<td>" + data.data[i].q_compltetedQty + "</td>" + "<td>" + data.data[i].q_cancelledQty + "</td>" + "<td>" + data.data[i].status_txt + "</td>"
                "<tr>";
                document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', html);
                spinnerOff();
            }
        }
    });
}