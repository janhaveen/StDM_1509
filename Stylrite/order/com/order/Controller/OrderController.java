package com.order.Controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.jpa.criteria.expression.function.AggregationFunction.COUNT;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.order.pojo.DetailedOrderItem;
import com.order.pojo.GetOrderList;
import com.order.pojo.Order;
import com.order.pojo.OrderItem;
import com.order.service.OrderService;
import com.product.pojo.Product;
import com.sample.pojo.AvailableStockSalesPerson;
import com.sample.service.SampleService;

@Controller
@WebListener
public class OrderController {

	@Autowired
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	/*** Page Redirect on Order.jsp ***/
	@RequestMapping(value = "/showOrder", method = RequestMethod.GET)
	public ModelAndView showVendor(ModelAndView model) {
		System.out.println("Hello World");
		model.addObject("order", new Order());

		model.setViewName("Order/Order");

		return model;
	}
    
	
	/*** Page Redirect on InProcessOrder.jsp ***/
	@RequestMapping(value="/showInprocessOrder",method=RequestMethod.GET)
	public ModelAndView showInProcessOrder(ModelAndView model) {
		System.out.println("showInProcessOrder");
		model.addObject("detailedorderitem",new DetailedOrderItem());
		model.setViewName("ListOrders/InProcessOrders");
	        return model;	
	}
	
	/*** Page Redirect on PendingOrder.jsp ***/
	@RequestMapping(value="/showPendingOrder",method=RequestMethod.GET)
	public ModelAndView showPendingOrder(ModelAndView model) {
		System.out.println("showPendingOrder");
		model.addObject("detailedorderitem",new DetailedOrderItem());
		model.setViewName("ListOrders/PendingOrders");
	        return model;	
	}
	/*** Page Redirect on StatusOrder.jsp ***/
	@RequestMapping(value="/showOrderStatus",method=RequestMethod.GET)
	public ModelAndView showOrderStatus(ModelAndView model) {
		System.out.println("showOrderStatus");
		model.addObject("detailedorderitem",new DetailedOrderItem());
		model.setViewName("ListOrders/OrderStatus");
	        return model;	
	}
	
	
	@PostMapping("/orderSave")
	public @ResponseBody int orderSaveData(@ModelAttribute("order") Order order,
			@ModelAttribute("product") Product product, @ModelAttribute("oitem") OrderItem oitem, BindingResult br,
			@RequestParam("count") String count, @RequestParam("OrderItemId") String OrderItemId,
			@RequestParam("ProductId") String ProductId, @RequestParam("action") String action,
			@RequestParam("quantity") int quantity, @RequestParam("rowId") String rowId) {
		int status = 0;

		try {

			product.setRowId(ProductId);
			oitem.setRowId(OrderItemId);
			oitem.setOrderId(rowId);

			System.out.println(order + " ");
			System.out.println("product obj  " + product + " product id" + ProductId + " ");
			System.out.println("order item " + oitem + "order item id " + OrderItemId);
			System.out.println("count " + count);
			System.out.println("order id " + rowId);
			System.out.println("quantity" + quantity);

			if (count.equals("0")) {
				status = orderService.addOrder(order,action);
			}

			status = orderService.addOrderItem(oitem, product);
			if (status == 701) {
				status = orderService.addProduct(product);

			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@PostMapping("/orderUpdate")
	public @ResponseBody int orderUpdateData(@ModelAttribute("order") Order order,
			@ModelAttribute("product") Product product, @ModelAttribute("oitem") OrderItem oitem, BindingResult br,
			@RequestParam("OldOrderItemID") String OldOrderItemID, @RequestParam("count") String count,
			@RequestParam("oldData") String oldData, @RequestParam("ProductId") String ProductId,
			@RequestParam("action") String action, @RequestParam("quantity") int quantity, HttpServletRequest request,
			@RequestParam("rowId") String rowId) {
		int status = 0;
		/*System.out.println(order + " ");
		System.out.println("product obj  " + product + " product id" + ProductId + " ");
		System.out.println("order item " + oitem + "order item id " + OldOrderItemID);
		System.out.println("count " + count);
		System.out.println("order id " + rowId);
		System.out.println("quantity" + quantity);
*/
		try {

			product.setRowId(ProductId);
			oitem.setRowId(OldOrderItemID);
			oitem.setOrderId(rowId);
			if (oldData.equals("oldValue")) {
				
				if (count.equals("0")) {
					System.out.println("if called");
					System.out.println("count data " + count);
					System.out.println("action is "+action);
					status = orderService.updateOrder(order, action);
				}
				
			if (request.getParameter("deleteidCount") != null) {
				System.out.println("action DELETE is "+action);
				int deleteidCount = Integer.parseInt(request.getParameter("deleteidCount"));
				System.out.println("deleted count of oredr "+deleteidCount);
				for (int i = 0; i <deleteidCount; ++i) {
					System.out.println("deleted id FIRST "+request.getParameter("deleteid[" + i + "]"));
					status=orderService.deleteOrderItem(request.getParameter("deleteid[" + i + "]"), oitem);
					System.out.println("deleted id REMOVE "+request.getParameter("deleteid[" + i + "]")+oitem);
				}
				
			}	
			

				status = orderService.updateOrderItem(oitem);

			} else {

				if (count.equals("0")) {
					System.out.println("Else called");
					status = orderService.addNewEditOrder(order, action);
				}

				status = orderService.addNewEditOrderItem(oitem, product);
				if (status == 701) {
					status = orderService.addNewEditProduct(product);

				}

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	/*
	 * @PostMapping("/orderSave") public @ResponseBody int
	 * orderSaveData(@ModelAttribute("order") Order order,@ModelAttribute("product")
	 * Product product,@ModelAttribute("oitem") OrderItem oitem, BindingResult
	 * br, @RequestParam("count") String count, @RequestParam("OrderItemId") String
	 * OrderItemId, @RequestParam("ProductId") String ProductId
	 * , @RequestParam("quantity") int quantity, @RequestParam("rowId") String
	 * rowId) { System.out.println(order+" ");
	 * 
	 * 
	 * System.out.println(" "+product+" "+ProductId + " " ); int status = 0; try {
	 * 
	 * 
	 * product.setRowId(ProductId); oitem.setRowId(OrderItemId);
	 * oitem.setOrderId(rowId);
	 * 
	 * if(count.equals("0")) { status = orderService.addOrder(order); }
	 * 
	 * status = orderService.addOrderItem(oitem); if(status == 701) { status =
	 * orderService.addProduct(product);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * catch (Exception e) { e.printStackTrace(); }
	 * 
	 * return status; }
	 */
	/*** Page Redirect on GRN.jsp ***/
	@RequestMapping(value = "/viewOrder", method = RequestMethod.GET)
	public ModelAndView showGRNView(ModelAndView model, @RequestParam("orderId") String orderId) {
		model.addObject("orderId", orderId);

		model.setViewName("order/OrderForEditView");

		return model;
	}

	/*** View Order Details ***/
	@RequestMapping(value = "/GetOrderDetails", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listOrderDetails(Model model, HttpSession session,
			@RequestParam("orderId") String orderId) {

		HashMap<String, Object> hm = new HashMap();

		List viewOrderDetails = orderService.getAllOrderDetails(orderId);

		System.out.println("viewOrder" + viewOrderDetails);

		// mv.addAttribute("listCustomers", listCustomers);

		hm.put("data", viewOrderDetails);

		hm.put("status", "200");
		System.out.println("hm " + hm);

		return hm;

	}

	/*** OrderList DataTables ***/
	@RequestMapping(value = "/GetMainOrderList", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listOrderDataTables(Model model, HttpSession session) {
		System.out.println("list order");
		HashMap<String, Object> hm = new HashMap<>();
		List listOrderDatatables = orderService.getAllOrderListDatatables();
		hm.put("data", listOrderDatatables);
		System.out.println("list order " + listOrderDatatables);
		return hm;
	}
	
	/*** list inprocess order  ***/
	@RequestMapping(value="/GetInprocessOrderList",produces="application/json",method=RequestMethod.GET)
       public @ResponseBody String listInProcessOrderList(Model model,HttpSession session, DetailedOrderItem detailedOrderItem) 
	{
		System.out.println("list iprocess order list");
		JSONArray jarray=new JSONArray();
		jarray = orderService.getInprocessOrderList();
		System.out.println(jarray);
		return jarray.toString();
	}
	
	/*** list pending  order  ***/
	@RequestMapping(value="/GetPendingOrders",produces="application/json",method=RequestMethod.GET)
    public @ResponseBody String listPendingOrders(Model model,HttpSession session, DetailedOrderItem detailedOrderItem) 
	{
		System.out.println("listPendingOrders list");
		JSONArray jarray=new JSONArray();
		jarray = orderService.getPendingOrderList();
		System.out.println(jarray);
		return jarray.toString();
	}
	
	/*** list order status***/
	@RequestMapping(value="/GetOrderListStatus",produces="application/json",method=RequestMethod.GET)
	public @ResponseBody String listOrderStatus(Model model,HttpSession session)
	{
		 System.out.println("list orderstatus");
		 JSONArray jarray=new JSONArray();
		 jarray=orderService.getAllOrderStatus();
		 System.out.println(jarray);
		 return jarray.toString();
	}
	
	
}


