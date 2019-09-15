 var arrayqty = [];
 $(document).ready(function() {

    DropDownForEmployee('');
     DropDownForLegend();
     DropDownForProductLegend();
     DropDownForHSN();
     $("#OrderProductListDiv").removeClass("HideThisElement");
     console.log($('#ProductDatatables tbody'));

     $("#DeleteOrderConfirmed").click(function() {
         var DeleteOrderId = document.querySelector('#DeleteOrderId').value;
         $.ajax({
             type: "GET",
             url: '../../../ModifyOrder?DeleteOrderId=' + DeleteOrderId,
             success: function(data) {
                 if (data == 0) {
                     $('#centralModalDangerDemo').modal('hide');
                     $(".errorMsg").removeClass("HideThisElement");
                     $("#errorMsg").html(' <strong>Error!</strong> Failed to Delete Order!');
                 } else {
                     $('#centralModalDangerDemo').modal('hide');
                     $('#selectedOrderId').val('');
                     $('#datatablesOrder').DataTable().ajax.reload();
                     $(".successMsg").removeClass("HideThisElement");
                     $("#successMsg").html(' <strong>Success!</strong>  Order Deleted Successfully!');
                 }
             }
         })
         return false; // avoid to execute the actual submit of the form.
     });

     $("#SubmitButtonCancel").click(function() {
         SwalDelete("your order will be Cancelled !");

     });

     var deletedProductId = [];

     $("#SubmitButtonRegister").click(function() {
         if (validationCompulsory()) {
             $("#action").val('insertOrder');
             SwalAdd("You Want to add New Order !");
             /*formSubmit(); */
         }
         /*if(!validationCompulsory())
		{
			$("#action").val('insertOrder');

		}
    	return false;*/
     });

     $("#SubmitButtonUpdate").click(function() {
         if (validationCompulsory()) {
             $("#action").val('updateOrder');
             SwalUpdate("You Want to Update Order !", deletedProductId);
             /*formSubmit(); */
         }
         /*if(!validationCompulsory())
				{
					$("#action").val('insertOrder');

				}
		    	return false;*/
     });

     /*$("#SubmitButtonUpdate").click(function() {		
		if(!validationCompulsory())
		{
			$("#action").val('updateOrder');
	    	formSubmit(deletedProductId); 
		}
    	return false;
    });
*/
     $("#DeleteProduct").click(function() {
         try {
             var table = document.getElementById('ProductDataBody');
             var rowCount = table.rows.length;
             for (var i = 0; i < rowCount; i++) {
                 var row = table.rows[i];
                 var chkbox = row.cells[0].childNodes[0];

                 if (null != chkbox && true == chkbox.checked) {
                     table.deleteRow(i);
                     deletedProductId.push($($(row.cells[0]).html()).attr('name'));
                     console.log("...delete product",deletedProductId);
                     rowCount--;
                     i--;
                 }
             }
         } catch (e) {
             alert(e);
         }
         return false;
     });

     /*var hsnId = $("#hsnId").val();
     var type = $("#type").val();
     var MRP = $("#MRP").val();*/
     var qty = $("#qty").val();
     var type;
     /*var discount = $("#discount").val();*/
     var productId;
     var skuid;
     var price = 0;
     var productinfo;
     var tax = "";
     var stock = 0;
     var discount = 0;
     var i = "";
     var igst = "";
     var hsnid = "";

     /*var brand = $("#brand").val();
     var modelNo = $("#modelNo").val();
     var color = $("#color").val();
     var size = $("#size").val();
     */
     var brand1 = $("#brand").children("option:selected").html();

     /*var skuid=$("#brand").children("option:selected").attr("id")+"-"+modelNo+"-"+color+"-"+$("#size").val();*/

     $("#size").focusout(function() {
         if (validateBrandProduct()) {

             $.ajax({
                 url: "CheckSkuIfExists",
                 data: {
                     brand: $("#brand").val(),
                     modelNo: $("#modelNo").val(),
                     color: $("#color").val(),
                     size: $("#size").val(),
                     action: $("#action").val(),
                     rowId: $('#productId').val()
                 },
                 type: "GET",
                 async: false,
                 success: function(data) {

                     console.log("action values", $("#action").val())
                     if (data.data == null) {
                         var generator = new IDGenerator();
                         productId = ("P" + generator.generate());
                         $("#productId").val(productId);
                         i = "(NPD)";
                         skuid = $("#brand").children("option:selected").attr("id") + "-" + $("#modelNo").val() + "-" + $("#color").val() + "-" + $("#size").val();
                         productinfo = $("#brand option:selected").text() + " " + $("#modelNo").val() + " " + $("#color").val() + " " + $("#size").val();
                         price = 0;
                         console.log("new product id " + $("#productId").val());
                         console.log("abc", data);
                         SwalWarning("Product doesnt exist " +
                             "Clik on add button to add new Product!");

                         /* SwalAddNewProduct("Are You Sure you want to add  New Product !",$("#productId").val(productId), skuid, productinfo,price);*/

                         /* document.getElementById('hsnId').value = "";
                          document.getElementById('price').value = "";
                          document.getElementById('MRP').value = "";*/
                         // document.getElementById('type').value = "";

                     } else {
                         console.log("Match Product", data);

                         /* $("#hsnId").val(data.data[0].hsnId);
                          $("#price").val(data.data[0].price);
                          $("#MRP").val(data.data[0].mrp);*/
                         i = "";
                         $("#type").val(data.data[0].type);
                         skuid = data.data[0].skuid;
                       //  $("#rate").val(data.data[0].type);
                         productinfo = data.data[0].brand_txt + " " + data.data[0].modelNo + " " + data.data[0].color + " " + data.data[0].size;
                         qty = $("#qty").val();
                         price = data.data[0].price;
                         $("#productId").val(data.data[0].rowId);
                         tax = data.data[0].hsnId;
                         if (data.data[0].npd == "1") {
                             i = "(NPD)";
                         }
                         /*   productId=data.data[0].rowId;*/
                         console.log(" OLD product id" + $("#productId").val());

                     }
                 }
             });
         }

         /*	
         	var newHtml = '<tr id="productIdRow">'+
         	'<td><input type="checkbox" value="'+brand+'" id="'+brand+'" name="' + brand + '"><label for="'+brand+'"></label></td>'+
         	  '<td>'+brand+'</td>'+
         	  '<td><input class="form-control qty" style="width: 40%;" type="text" id="qty'+brand+'"></td>'+
         	  '<td>'+price+'</td>'+
         	  '<td class="HideThisElement">'+price+'</td>'+
         	  '<td class="HideThisElement"><input type="checkbox"  value=""><label for="'+color+'"></label></td>'+
         	  '</tr>';

         	document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', newHtml);*/

         //document.getElementById('insertProductForm').reset();

     });
     /*function SwalAddNewProduct(msg,productId,skuid, productinfo,price)
     {
     	swal
     	({
     		 // title: 'Add New Product and Update Barcode?',
     		  text: msg,
     		  type: 'success',
     		  showCancelButton: true,
     		  confirmButtonText: 'Yes, Update!',
     		  cancelButtonText: 'No !'
     		}).then(function()
     		 {
     		  swal(
     			'Add New Product and Update Barcode!',
     			'Your data has been Added.',
     			'success'
     		  );
     		  AddNewProduct(msg,productId,skuid, productinfo,price);
     		}, function(dismiss)
     		{
     		  if (dismiss === 'cancel')
     		  {
     		    swal(
     		      'Ok',
     		      'Cancelled !',
     		      'error'
     		    )
     		  }
     	});
     }
     */

     $("#saveProduct").click(function()

         {
             if (validateProduct()) {
                 var typeText = "";

                 if ($("#type").val() == 200001) {
                     typeText = "Frames";
                     igst = 12;
                     hsnid = "90031100";

                 } else if ($("#type").val() == 200002) {
                     typeText = "Sunglasses";
                     igst = 18;
                     hsnid = "90041000";
                 } else if ($("#type").val() == 200003) {
                     typeText = "Reading Frames";
                     igst = 12;
                 }

                 /*if(tax="90031100"){
        		 igst=12;
        	 }
        	 else if(tax="90041000"){
        		 igst=18;
        	 }
        	 */

                 var newHtml = '<tr id="ProductData">' +
                     '<td><input type="checkbox" value="' + $('#productId').val() + '" id="' + $('#productId').val() + '" name="' + $('#productId').val() + '"><label for="' + $('#productId').val() + '"></label></td>' +
                     '<td id="skuid' + $('#productId').val() + '">' + i + '  ' + skuid + '</td>' +
                     '<td id="productinfo' + $('#productId').val() + '">' + productinfo + '</td>' +
                     '<td >' +typeText+ '</td>' +
                     '<td id="igstText' + $('#productId').val() + '">' + igst + '</td>' +
                     '<td id="stock' + $('#productId').val() + '">' + stock + '</td>' +
                     '<td><input class="form-control itemQty" style="width:50px;" type="text" id="quantity' + $('#productId').val() + '" onfocusout="AddtotalQuantity(this)" value = "' + $("#qty").val() + '"></td>' +
                     '<td><input class="form-control " style="width:80px;" type="text" id="price' + $('#productId').val() + '" value = "' + price + '"></td>' +
                     '<td><input class="form-control " style="width:50px;" type="text" id="discountText' + $('#productId').val() + '" value ="' + discount + '"></td>' +
                     '<td id="brandText1' + $('#productId').val() + '" class="HideThisElement">' + $("#brand").val() + '</td>' +
                     '<td id="typeText' + $('#productId').val() + '" class="HideThisElement">' + $("#type").val() + '</td>' +
                     '<td id="skuText' + $('#productId').val() + '" class="HideThisElement">' + skuid + '</td>' +
                     '<td id="modelNoText' + $('#productId').val() + '"class="HideThisElement">' + $("#modelNo").val() + '</td>' +
                     '<td id="colorText' + $('#productId').val() + '" class="HideThisElement">' + $("#color").val() + '</td>' +
                     '<td id="sizeText' + $('#productId').val() + '"class="HideThisElement">' + $("#size").val() + '</td>' +
                     '<td id="taxText' + $('#productId').val() + '"class="HideThisElement">' + hsnid + '</td>' +
                     '</tr>';

                 document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', newHtml);
                 arrayqty.push({
                     "qty": $("#quantity" + $('#productId').val()).val()
                 });
                 AddtotalQuantity();
                 /*onfocusout="AddtotalQuantity1(\''+'quantity'+$('#productId').val()+'\',this)"*/
                 /*  AddtotalQuantity($("#qty").val());*/
                 //document.getElementById('insertProductForm').reset();
                 document.getElementById('brand').value = "";
                 $('#brandFrm select').selectpicker('refresh');
                 document.getElementById('modelNo').value = "";
                 document.getElementById('color').value = "";
                 document.getElementById('size').value = "";
                 document.getElementById('type').value = "";
                 document.getElementById('qty').value = "";

             }
         });

 });
 /* */
 var tqty = 0;

 function AddtotalQuantity() {
     var totalquantity = 0;
     $(".itemQty").each(function(i) {
         totalquantity += parseInt($($('.itemQty')[i]).val());
         console.log("totalquantity", totalquantity);
     });
     //tqty+=totalquantity;
     console.log("qty3", tqty);
     // tqty=tqty+totalquantity;
     console.log("...3...", tqty);
     $("#totalQuantity").text(totalquantity);
 }
 /*function AddtotalQuantity(totalquantity){
 	console.log("...qtydata..1...",arrayqty);
 	console.log("totalquantity",totalquantity)
  tqty=tqty+parseInt(totalquantity);
 	$("#totalQuantity").text(tqty);

 }
 function AddtotalQuantity1(id,curentqty)
 {
 	console.log("id",id);
 	console.log("...qtydata..2...",arrayqty);
 	var cqty=parseInt($(curentqty).val());
 	console.log("changequantity",$(curentqty).val());
 	AddtotalQuantity(cqty);
 }*/

 function SwalAdd(msg) {
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
                 'Added!',
                 'New Order Added.',
                 'success'
             );
             formSubmit();
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

 function SwalDelete(msg) {
     swal
         ({
             title: 'Are you sure?',
             text: msg,
             type: 'warning',
             showCancelButton: true,
             confirmButtonText: 'Yes, Cancel it!',
             cancelButtonText: 'No !'
         }).then(function() {
             swal(
                 'Cancelled!',
                 'Your Order has been cancelled.',
                 'success'
             );
             cancelOrderPopup();
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

 function SwalUpdate(msg, deletedProductId) {
     swal
         ({
             title: 'Are you sure?',
             text: msg,
             type: 'warning',
             showCancelButton: true,
             confirmButtonText: 'Yes, Update it!',
             cancelButtonText: 'No !'
         }).then(function() {
             swal(
                 'Added!',
                 '  Order Updated.',
                 'success'
             );
             formUpdate(deletedProductId);
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

 function cancelOrderPopup() {
     $("#OrderTableDiv").removeClass("HideThisElement");
     $("#OrderViewDiv").addClass("HideThisElement");
     $("#orderFormDiv").addClass("HideThisElement");
 }

 function validateBrandProduct() {
     if ($("#brand").val() == "")
         SwalWarning("Enter Brand!");
     if ($("#modelNo").val() == "")
         SwalWarning("Enter Model No!");
     else if ($("#color").val() == "")
         SwalWarning("Enter Color!");
     else if ($("#size").val() == "")
         SwalWarning("Enter Size!");
     else
         return true;
 }

 function validateProduct() {
     if ($("#brand").val() == "")
         SwalWarning("Enter Brand!");
     if ($("#modelNo").val() == "")
         SwalWarning("Enter Model No!");
     else if ($("#color").val() == "")
         SwalWarning("Enter Color!");
     else if ($("#size").val() == "")
         SwalWarning("Enter Size!");
     else if ($("#type").val() == "")
         SwalWarning("Enter Type!");
     else if ($("#qty").val() == "")
         SwalWarning("Enter Quantity!");

     else
         return true;
 }

 function formSubmit() {

     var returnVal = false;
     var generator = new IDGenerator();
     var returnVal = false;
     var count = 1;
     var orderID = $("#OrderId").val();
     var table1 = document.getElementById('ProductDataBody');
     console.log("table1",table1);
     var rowCount = table1.rows.length;
     
     for (var i = 0; i < rowCount; i++) {

         var row = table1.rows[i];
  
         var formData = "OrderItemId=OI" + generator.generate() + "&count=" + i + "&rowId=" + $("#OrderId").val() + "&remarks=" + $("#updateRemarks").val() + "&";
         var OrderForm = "";
         for (var j = 0; j < $(row.cells).length; j++)
         {
             if (j == 0)
             {
                 var ProductId = $($(row.cells[j]).html()).val();
                 console.log($("#price" + ProductId).val());

                 OrderForm += "brand=" + $("#brandText1" + ProductId).html() + "&modelNo=" + $("#modelNoText" + ProductId).html() + "&color=" + $("#colorText" + ProductId).html() + "&size=" + $("#sizeText" + ProductId).html() + "&type=" + $("#typeText" + ProductId).html() + "&qty=" + $("#quantity" + ProductId).val() + "&price=" + $("#price" + ProductId).val() + "&sku=" + $("#skuText" + ProductId).html() + "&";

                 formData += "ProductId=" + ProductId + "&quantity=" + $("#quantity" + ProductId).val() + "&rate=" + $("#price" + ProductId).val() + "&igst=" + $("#igstText" + ProductId).html() + "&hsnId=" + $("#taxText" + ProductId).html() + "&discount=" + $("#discountText" + ProductId).val() + "&";
             }
         }
         console.log("...", ($("#quantity" + ProductId).val()));

         /*  if($("#quantity"+ProductId).val()=="")
					{

						alert("Heloo0q.......");
				        SwalWarning(" Product Quantity is mandatory !");

					}*/
         /*	else*/

         $.ajax({
             type: "POST",
             url: "orderSave",
             data: OrderForm + formData + $("#clientInfoForm").serialize(),
             async: false,
             success: function(data) {
                 console.log(data);

                 returnVal = true;

             }
         });
     }
     /*}*/
     if (returnVal) {
         SwalSuccess(" Order(s) Added successfully ! ");
         $("#orderFormDiv").addClass('HideThisElement');
         $("#OrderViewDiv").removeClass('HideThisElement');

         getOrderDataForView(orderID);
         console.log("order id IS", orderID);

         /*  window.location.href="viewOrder?orderId="+$("#OrderId").val();*/

         /*$("#boxInfoDiv .successMsg").removeClass("HideThisElement");
	        $("#boxInfoDiv #successMsg").html(" <strong>Success !</strong> Product(s) Received successfully ! ");
	        */
         /*setTimeout(function(){

         }, 2000);*/
         /*$(".qty").attr("readOnly", true);
			$("#submitProductGRN").addClass('HideThisElement');
			$("#GenerateBarcode").removeClass('HideThisElement');*/
     }

 }

 function validationCompulsory() {
     /*  var enteredQty=false;
       	var enteredQty=false, t=false;
       	for(var i = 0; i < $(".itemQty").length; i++) {
       		if($($(".itemQty")[i]).val()=="" || $($(".itemQty")[i]).val()=="0"){
       			enteredQty=true;
       		}
       	}*/
     var enterQty = false;

     for (var i = 0; i < $(".itemQty").length; i++) {
         if ($($(".itemQty")[i]).val() == "" || $($(".itemQty")[i]).val() == "0") {
             enterQty = true;
         }
     }

     if ($("#clientId").val() == "") {
         SwalWarning("Please Enter Client Id !");

     } else if ($("#selectedClientId").val() == "") {
         SwalWarning("Please Select Client !");
     } else if ($("#selectedClientContactPersonId").val() == "") {
         SwalWarning("Please Select Contact Person!");
     } else if ($("#selectedBillingAddressId").val() == "") {
         SwalWarning("Please Select Billing Address!");
     } else if ($("#selectedDeliveryAddressId").val() == "") {
         SwalWarning("Please Select Delivery Address!");
     } else if ($("#clientSalesPerson").val() == "") {
         SwalWarning("Please Select Sales Person!");
     } else if ($("#RefNo").val() == "") {
         SwalWarning("Please Enter Reference Number!");
     } else if (enterQty) {

         SwalWarning("Please Enter Quantity!");
     } else
         return true;
     /*
     else if($("#invoiceType").val() == "")
     {
     	Swal("Please Select Invoice Type!");
     }
     else if($("#modeOfPayment").val() == "")
     {
     	Swal("Please Select Mode Of Payment!");
     }
     else if($("#expectedDeliveryDate").val() == "")
     {
     	Swal("Please Select Expected Delivery Date!");
     }*/
 }

 function formUpdate(deletedProductId) 
 {
     /*  alert("deleted productId"+deletedProductId);*/
     var returnVal = false;
     var generator = new IDGenerator();
     var returnVal = false;
     var count = 1;
     var oldData = $("#oldData").val();
     var orderID = $("#OrderId").val();
     var table1 = document.getElementById('ProductDataBody');
     var rowCount = table1.rows.length;
     for (var i = 0; i < rowCount; i++) {
         var row = table1.rows[i];
         if (oldData == "oldValue") {
             /*alert("old value");*/
             var formData = "&oldData=" + oldData + "&count=" + i + "&rowId=" + $("#OrderId").val() + "&remarks=" + $("#updateRemarks").val() + "&";
             var OrderForm = "";
             for (var j = 0; j < $(row.cells).length; j++) {
                 if (j == 0) {
                     var ProductId = $($(row.cells[j])[0].innerHTML).attr('name');
                     formData += "ProductId=" + ProductId + "&quantity=" + $("#quantity" + ProductId).val() + "&OldOrderItemID=" + $("#orderItemID1" + ProductId).val() + "&rate=" + $("#ItemRate" + ProductId).val() + "&igst=" + $("#igst1" + ProductId).val() + "&hsnId=" + $("#hsnId" + ProductId).val() + "&discount=" + $("#ItemDiscount" + ProductId).val() + "&";
                 }

             }
             var deleteData = "";
             if (deletedProductId.length > 0) {
                 for (var d = 0; d < deletedProductId.length; d++) {
                     if (d == 0) {
                         deleteData += "&";
                         console.log("deleredd data " + deleteData);
                     }
                     deleteData += "deleteid[" + d + "]=" + deletedProductId[d] + "&";
                 }
                 deleteData += "deleteidCount=" + deletedProductId.length + "&";
             }
             /*	formData+=deleteData;*/
             console.log("formdata is" + formData);
             console.log("...", ($("#quantity" + ProductId).val()));
             console.log("...", ($("#orderItemID1" + ProductId).val()));
             console.log("...", ($("#ItemRate" + ProductId).val()));
             console.log("...", ($("#igst1" + ProductId).val()));
             console.log("...", ($("#ItemDiscount" + ProductId).val()));

         } else {
             /* alert("New value");*/
             var formData = "OrderItemId=OI" + generator.generate() + "&count=" + i + "&rowId=" + $("#OrderId").val() + "&remarks=" + $("#updateRemarks").val() + "&";
             var OrderForm = "";
             for (var j = 0; j < $(row.cells).length; j++) {
                 if (j == 0) {
                     var ProductId = $($(row.cells[j]).html()).val();
                     console.log($("#price" + ProductId).val());

                     OrderForm += "brand=" + $("#brandText1" + ProductId).html() + "&modelNo=" + $("#modelNoText" + ProductId).html() + "&color=" + $("#colorText" + ProductId).html() + "&size=" + $("#sizeText" + ProductId).html() + "&type=" + $("#typeText" + ProductId).html() + "&qty=" + $("#quantity" + ProductId).val() + "&price=" + $("#price" + ProductId).val() + "&sku=" + $("#skuText" + ProductId).html() + "&";

                     formData += "ProductId=" + ProductId + "&quantity=" + $("#quantity" + ProductId).val() + "&rate=" + $("#price" + ProductId).val() + "&igst=" + $("#igstText" + ProductId).html() + "&hsnId=" + $("#taxText" + ProductId).html() + "&discount=" + $("#discountText" + ProductId).val() + "&";
                 }
             }
             console.log("...", ($("#quantity" + ProductId).val()));

         }

         /*  if($("#quantity"+ProductId).val()=="")
					{

						alert("Heloo0q.......");
				        SwalWarning(" Product Quantity is mandatory !");

					}*/
         /*	else*/

         $.ajax({
             type: "POST",
             url: "orderUpdate",
             data: OrderForm + formData + deleteData + $("#clientInfoForm").serialize(),
             async: false,
             success: function(data) {
                 console.log(data);

                 returnVal = true;

             }
         });
     }
     /*}*/
     if (returnVal) {
         SwalSuccess(" Order(s) Updated successfully ! ");
         $("#orderFormDiv").addClass('HideThisElement');
         $("#OrderViewDiv").removeClass('HideThisElement');

         getOrderDataForView(orderID);
         console.log("order id IS", orderID);

         /*  window.location.href="viewOrder?orderId="+$("#OrderId").val();*/

         /*$("#boxInfoDiv .successMsg").removeClass("HideThisElement");
	        $("#boxInfoDiv #successMsg").html(" <strong>Success !</strong> Product(s) Received successfully ! ");
	        */
         /*setTimeout(function(){

         }, 2000);*/
         /*$(".qty").attr("readOnly", true);
			$("#submitProductGRN").addClass('HideThisElement');
			$("#GenerateBarcode").removeClass('HideThisElement');*/
     }

 }

 /*
 function formSubmit(deletedProductId)
 {
 	var generator = new IDGenerator();
 	var returnVal=false;
 	var count = 1;
 	var orderID = $("#OrderId").val();

 	var table1 = document.getElementById('ProductDataBody');
 	var rowCount = table1.rows.length;

 	for (var i = 0; i < rowCount; i++)
 	{
 		var row = table1.rows[i]; 
 		var formData="";
 		for(var j=0; j<$(row.cells).length; j++)
 		{
 			if(j==0)
 			{
 				var ProductId=$($(row.cells[j])[0].innerHTML).attr('name');
 				formData+="ProductId="+ProductId+"&";
 			}
 			if(j==4)
 			{
 				var name = $($(row.cells[j]).html()).attr('name');
 				formData+=name+"="+parseFloat($(row.cells[j].childNodes[0]).val())+"&";
 			}
 			if(j==4)
 			{
 				var name = $($(row.cells[j]).html()).attr('name');
 				formData+=name+"="+parseFloat($(row.cells[j].childNodes[0]).val())+"&";
 			}
 			if(j==5)
 			{
 				var name = $($(row.cells[j]).html()).attr('name');
 				formData+=name+"="+parseFloat($(row.cells[j].childNodes[0]).val())+"&";
 			}
 			if(j==6)
 			{
 				var name = $($(row.cells[j]).html()).attr('name');
 				formData+=name+"="+parseFloat($(row.cells[j].childNodes[0]).val())+"&";
 			}
 			if(j==7)
 			{
 				var name = $($(row.cells[j]).html()).attr('name');
 				formData+=name+"="+parseFloat($(row.cells[j].childNodes[0]).val())+"&";
 			}
 			if(j==9)
 			{
 				var name = $($(row.cells[j]).html()).attr('name');
 				formData+=name+"="+($(row.cells[j].childNodes[0]).val())+"&";
 			}
 		}

 		formData+="orderID="+orderID+"&orderStatus=941&remarks="+$("#updateRemarks").val()+"&modeOfPayment="+$("#modeOfPayment").val()+"&expectedDeliveryDate="
 					+$("#expectedDeliveryDate").val()+"&invoiceType="+$("#invoiceType").val()+"&selectedClientId="+$("#selectedClientId").val()+
 						"&selectedClientContactPersonId="+$("#selectedClientContactPersonId").val()+"&selectedBillingAddressId="+$("#selectedBillingAddressId").val()+
 						"&selectedDeliveryAddressId="+$("#selectedDeliveryAddressId").val()+"&clientSalesPerson="+$("#clientSalesPerson").val()
 						+"&action="+$("#action").val()+"&orderItemstatus=951&RefNo="+$("#RefNo").val()+"&count="+count;
 		var deleteData="";
 		if(deletedProductId.length>0){
 			for(var d=0; d<deletedProductId.length;d++){
 				if(d==0)
 				{
 					deleteData+="&";
 				}
 				deleteData+="deleteid["+d+"]="+deletedProductId[d]+"&";
 			}deleteData+="deleteidCount="+deletedProductId.length;
 		}
 		formData+=deleteData;
 		console.log(formData);
 		$.ajax({
             type: "POST",
             url: "../../../ModifyOrder",
             data: formData, 
             async:false,
             success: function(data)
 	        {
             	if(data!="0")
             		returnVal=true;
 	     	   else
 	     		  returnVal=false
             }
     	});
 		count++;
 	}

 	if(returnVal){
 		$("#OrderTableDiv").removeClass("HideThisElement");
 		$("#orderFormDiv").addClass("HideThisElement");
 		$('#datatablesOrder').DataTable().ajax.reload();
 		$("#OrderViewDiv .successMsg").removeClass("HideThisElement");
         $("#OrderViewDiv #successMsg").html(' <strong>Success!</strong> Order placed Successfully!');
         getOrderDataForView(orderID);
 	}

 	if($("#action").val() == "insert")
 	{
 	}
 	else if($("#action").val() == "updateAccpStatus" || $("#action").val() == "updateDispatched" || $("#action").val() == "updateRecieved")
 	{
 		var requisitionID = $("#selectedRequisitioId").val();
 	}

 	if($("#action").val() == "insert" || $("#action").val() == "updateAccpStatus")
 	{
 	}
 	else if($("#action").val() == "updateDispatched" || $("#action").val() == "updateRecieved")
 	{
 		if($("#action").val() == "updateDispatched")
 		{
 			var formData=$("#dispatchForm").serialize()+"&requisitionID="+requisitionID+"&requisitionLogID="+requisitionLogID+"&requitionstatus=203&action="+$("#action").val()+"&count="+count;
 		}
 		else if($("#action").val() == "updateRecieved")
 		{
 			var formData="requisitionID="+requisitionID+"&requisitionLogID="+requisitionLogID+"&requitionstatus=204" +
 					"&receiptDate="+$("#sampleReceiptDate").val()+"&remarks="+$("#receivedRemarks").val()+
 							"&action="+$("#action").val()+"&count="+count;
 		}
 		console.log(formData);
 		$.ajax({
             type: "POST",
             url: "../../../ModifyRequisition",
             data: formData,
             async:false,
             success: function(data)
 	        {
             	if(data!="0")
             		returnVal=true;
 	     	   else
 	     		  returnVal=false
             }
     	});
 	}
 	if(returnVal)
 	{
 //		alert("vsgh");
 		if($("#for").val() == "newSample" || $("#for").val() == "sampleListRdyToRcv")
 		{
 			window.location.href = "Sample.jsp?for=sampleListView";
 		}
 		else if($("#for").val() == "sampleListInvtAccp" || $("#for").val() == "sampleListDispatched")
 		{
 			location.reload();
 			$("#action").val("updateAccpStatus");
 			$("#SampleFormProductListDiv").addClass("HideThisElement");
 			$("#SampleFormDiv").addClass("HideThisElement");
 			$("#SampleTableDiv").removeClass("HideThisElement");
 			$("#ProductTableDiv").addClass("HideThisElement");
 			$("#SampleFormProductListDiv").addClass("HideThisElement");
 			$("#SampleViewDiv").addClass("HideThisElement");
 			$("#SampleFormDiv").removeClass("HideThisElement");
 			$("#SampleTableDiv").removeClass("HideThisElement");
 			$("#ProductTableDiv").removeClass("HideThisElement");
 		    document.querySelector('#ProductDataBody').value = "";
 			$("#DeleteProduct").removeClass("HideThisElement");
 			$("#SubmitButtonRegister").removeClass("HideThisElement");
 			$("#SubmitButtonUpdate").addClass("HideThisElement");
 			$("#SubmitButtonBack").addClass("HideThisElement");
 			$("#SampleFormProductListDiv").addClass("HideThisElement");
 			$("#updateBtnDiv").addClass("HideThisElement");
 			$("#SampleFormDispatchDiv").removeClass("HideThisElement");
 			$("#submitBtnDiv").removeClass("HideThisElement");
 			$('#datatables').DataTable().ajax.reload();
 		}
 	}
 	else
 		alert("Failed");
 }*/

 /*function getProductClick(){
     $('#ProductDatatables tbody').on( 'click', '.select_me', function () { console.log("sdf");
 		var generator = new IDGenerator();
 		var data = $('#ProductDatatables').DataTable().row($(this).parents('tr')).data();
 		var table1 = document.getElementById('ProductDataBody');
 		 $('#OrderProductListDiv').removeClass("HideThisElement");
 		var rowCount = table1.rows.length;
 		var idExists = false;
 		for(var i=0; i<rowCount; i++) {
 			var row = table1.rows[i];
 			var a = $(row.cells[0]).html();
 			var idToCheck= $(a).attr('id');
 	    	if (idToCheck == data.rowId) {
 				idExists = true;
 				break;
 			}
 		}
 		console.log(idExists);
 		if (idExists) {
 			swal({
 				  title: 'Product Already Selected !',
 				  text: 'Product Already Selected ! You want to add it again ?',
 				  type: 'warning',
 				  showCancelButton: true,
 				  confirmButtonText: 'Yes, Add it!',
 				  cancelButtonText: 'No !'
 				}).then(function() {
 				  swal(
 				    'Ok',
 				    'Product Added !',
 				    'success'
 				  );
 				  $("#ItemQty"+ data.rowId).val(parseInt($("#ItemQty"+ data.rowId).val())+1);
 				}, function(dismiss) {
 				  if (dismiss === 'cancel') {
 				    swal(
 				      'Ok',
 				      'Cancelled !)',
 				      'error'
 				    )
 				  }
 				});
 			 $(".errorMsg").removeClass("HideThisElement");
 	         $("#errorMsg").html(' <strong>Error!</strong> Product Already Selected !');
 	        // Swal("Product Already Selected !");
 			swal({
 				  title: "Are you sure?",
 				  text: "Once deleted, you will not be able to recover this imaginary file!",
 				  icon: "warning",
 				  buttons: true,
 				  dangerMode: true,
 				})
 				.then((willDelete) => {
 				  if (willDelete) {
 				    swal("Poof! Your imaginary file has been deleted!", {
 				      icon: "success",
 				    });
 				  } else {
 				    swal("Your imaginary file is safe!");
 				  }
 			});
 		} else { console.log("dsd");
 			var newHtml = '<tr id="productIdRow">'+
 						  '<td><input type="checkbox" id="'+data.rowId+'" name="' + data.rowId + '"><label for="'+data.rowId+'"></label></td>'+
 						  '<td>'+data.skuid+'</td>'+
 						  '<td>'+data.productInfo+'</td>'+
 						  '<td style="text-align: center">'+data.availableStock+' ('+data.blocked+')</td>' +
 						  '<td style="text-align: center"><input type="number" class="form-control itemQty" value=1 style="width:50px;" id="ItemQty' + data.rowId +'" name="Qty" ></td>' +
 						  '<td style="text-align: center"><input type="number" class="form-control" value=' + parseFloat(data.price).toFixed(2) + ' style="width:80px;" id="ItemRate' + data.rowId + '" name="rate" step="0.01" ></td>' +
 						  '<td style="text-align: center"><input type="number" class="form-control" value=0 style="width:50px;" id="ItemDiscount' + data.rowId + '" name="discount" min="0" max="100" ></td>' +
 						  '<td style="display:none;"><input type="hidden" id="tax' + data.rowId + '" name="tax" value="' + data.Igst + '"></td>' +
 						  '<td style="display:none;"><input type="hidden" id="hsnId' + data.rowId + '" name="hsnId" value="' + data.hsnId + '"></td>' +
 						  '<td style="display:none;"><input type="hidden" id="orderItemID' + data.rowId + '" name="orderItemID" value="OI'+generator.generate()+ '"></td>' +
 						  '<td style="display:none;"><input type="hidden" id="orderItemstatus' + data.rowId + '" name="orderItemstatus" value="951"></td>' +
 						  '</tr>';
 			document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', newHtml);
 		}
     });
 }*/