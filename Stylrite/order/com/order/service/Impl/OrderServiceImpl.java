package com.order.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.service.impl.CurrentDateTime;
import com.order.dao.OrderDao;
import com.order.pojo.DetailedOrderItem;
import com.order.pojo.GetOrderList;
import com.order.pojo.Order;
import com.order.pojo.OrderItem;
import com.order.service.OrderService;
import com.product.pojo.Product;
import com.sample.pojo.AvailableStockSalesPerson;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	HttpSession session;

	@Autowired
	private OrderDao orderDao;

	@Override
	public int addOrder(Order order, String action) {
		boolean bol = false;
		int status = 0;
		try {
			order.setStatus("941");
			order.setCreatedBy(String.valueOf(session.getAttribute("empName")));

			order.setCreatedOn(CurrentDateTime.CurrentTimestamp());

			if (action.equals("insertOrder")) {
				bol = orderDao.addOrder(order);
			}
			if (bol) {
				status = 601;
			} else {
				status = 602;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public List<GetOrderList> getAllOrderDetails(String orderId) {
		// TODO Auto-generated method stub
		return orderDao.getAllOrderDetails(orderId);
	}

	@Override
	public List getAllOrderListDatatables() {
		// TODO Auto-generated method stub
		return orderDao.getAllOrderListDatatables();
	}

	@Override
	public int addOrderItem(OrderItem oitem, Product product) {
		boolean bol = false;
		boolean bool = false;
		int status = 0;

		// grn.setIsdeleted("0");

		try {

			/*
			 * bool = orderDao.CheckProductIfExists(product);
			 * 
			 * System.out.println("CheckProduct" + bool); if (bool) {
			 */
			oitem.setStatus("955");
			oitem.setCreatedBy(String.valueOf(session.getAttribute("empName")));

			oitem.setCreatedOn(CurrentDateTime.CurrentTimestamp());

			bol = orderDao.addOrderItem(oitem);
			if (bol) {
				status = 701;
			} else {
				status = 702;
			}
			/*
			 * else { status = 803;
			 * 
			 * product.setNPD("1"); System.out.print("MJANHA");
			 * product.setCreatedBy(String.valueOf(session.getAttribute("empName")));
			 * 
			 * product.setCreatedOn(CurrentDateTime.CurrentTimestamp());
			 * 
			 * if(orderDao.addProductOrder(product)) {
			 * 
			 * oitem.setProductId(product.getRowId()); oitem.setStatus("952");
			 * oitem.setCreatedBy(String.valueOf(session.getAttribute("empName")));
			 * 
			 * oitem.setCreatedOn(CurrentDateTime.CurrentTimestamp());
			 * 
			 * bol = orderDao.addOrderItem(oitem);
			 * 
			 * }
			 */
			// status = orderService.addProduct(product);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public int addProduct(Product product) {
		boolean bool = false;
		boolean b1 = false;
		int status = 0;
		try {

			bool = orderDao.CheckProductIfExists(product);

			System.out.println("CheckProduct" + bool);

			if (bool) {

				product.setNPD("1");

				product.setCreatedBy(String.valueOf(session.getAttribute("empName")));

				product.setCreatedOn(CurrentDateTime.CurrentTimestamp());
				product.setIsdeleted("0");

				bool = orderDao.addProductOrder(product);

				if (bool) {
					status = 801;
				} else {
					status = 802;
				}
			} else {
				status = 803;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;

	}

	@Override
	public int updateOrder(Order order, String action) {
		boolean bol = false;
		int status = 0;
		try {
			order.setStatus("941");
			order.setUpdatedBy(String.valueOf(session.getAttribute("empName")));

			order.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
			System.out.println("order is ....." + order);
			if (action.equals("updateOrder")) {
				System.out.println("order Update111111 ....." + order);
				bol = orderDao.updateOrder(order);
			}
			if (bol) {
				status = 2601;
			} else {
				status = 2602;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public int updateOrderItem(OrderItem oitem) {
		boolean bol = false;
		boolean bool = false;
		int status = 0;

		// grn.setIsdeleted("0");

		try {

			oitem.setStatus("955");

			oitem.setUpdatedBy(String.valueOf(session.getAttribute("empName")));

			oitem.setUpdatedOn(CurrentDateTime.CurrentTimestamp());

			bol = orderDao.UpdateOrderItem(oitem);
			if (bol) {
				status = 1701;
			} else {
				status = 1702;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public int deleteOrderItem(String parameter, OrderItem oitem) {
		boolean bol = false;
		boolean bool = false;
		int status = 0;

		// grn.setIsdeleted("0");

		try {

			oitem.setUpdatedBy(String.valueOf(session.getAttribute("empName")));

			oitem.setUpdatedOn(CurrentDateTime.CurrentTimestamp());

			bol = orderDao.deleteOrderItem(parameter,oitem);
			if (bol) {
				status = 2701;
			} else {
				status = 2702;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public int addNewEditOrder(Order order, String action) {

		boolean bol = false;
		int status = 0;
		try {
			order.setStatus("941");
			order.setCreatedBy(String.valueOf(session.getAttribute("empName")));

			order.setCreatedOn(CurrentDateTime.CurrentTimestamp());

			if (action.equals("updateOrder")) {
				bol = orderDao.addNewEditOrder(order);
			}
			if (bol) {
				status = 6001;
			} else {
				status = 6002;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	
	}

	@Override
	public int addNewEditOrderItem(OrderItem oitem, Product product) {
		boolean bol = false;
		boolean bool = false;
		int status = 0;

		// grn.setIsdeleted("0");

		try {

			/*
			 * bool = orderDao.CheckProductIfExists(product);
			 * 
			 * System.out.println("CheckProduct" + bool); if (bool) {
			 */
			oitem.setStatus("955");
			oitem.setCreatedBy(String.valueOf(session.getAttribute("empName")));

			oitem.setCreatedOn(CurrentDateTime.CurrentTimestamp());

			bol = orderDao.addNewEditOrderItem(oitem);
			if (bol) {
				status = 701;
			} else {
				status = 702;
			}
			/*
			 * else { status = 803;
			 * 
			 * product.setNPD("1"); System.out.print("MJANHA");
			 * product.setCreatedBy(String.valueOf(session.getAttribute("empName")));
			 * 
			 * product.setCreatedOn(CurrentDateTime.CurrentTimestamp());
			 * 
			 * if(orderDao.addProductOrder(product)) {
			 * 
			 * oitem.setProductId(product.getRowId()); oitem.setStatus("952");
			 * oitem.setCreatedBy(String.valueOf(session.getAttribute("empName")));
			 * 
			 * oitem.setCreatedOn(CurrentDateTime.CurrentTimestamp());
			 * 
			 * bol = orderDao.addOrderItem(oitem);
			 * 
			 * }
			 */
			// status = orderService.addProduct(product);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public int addNewEditProduct(Product product) {
		boolean bool = false;
		boolean b1 = false;
		int status = 0;
		try {

			bool = orderDao.CheckProductIfExists(product);

			System.out.println("CheckProduct" + bool);

			if (bool) {

				product.setNPD("1");

				product.setCreatedBy(String.valueOf(session.getAttribute("empName")));

				product.setCreatedOn(CurrentDateTime.CurrentTimestamp());
				product.setIsdeleted("0");

				bool = orderDao.addNewEditProductOrder(product);

				if (bool) {
					status = 801;
				} else {
					status = 802;
				}
			} else {
				status = 803;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;

	}

	@Override
	public JSONArray getInprocessOrderList() {
		List<Object[]> author =orderDao.getInprocessOrderList();
		JSONArray jarray=new JSONArray();
		for (Object[] a : author) {
			JSONObject jsonobj=new JSONObject();
			jsonobj.put("orderdate",a[0]);
			jsonobj.put("orderId",a[1]);
			jsonobj.put("companyName",a[2]);
			jsonobj.put("clientLocation",a[3]);
			jsonobj.put("cpname",a[4]);
			jsonobj.put("contactNo",a[5]);
			jsonobj.put("spname",a[6]);
			jsonobj.put("count",a[7]);
			jsonobj.put("sum1",a[8]);
		
			jarray.put(jsonobj);
			
			
		    System.out.println("Author "
		            + a[0]
		            + " "
		            + a[1]);
		}
	

		return jarray;
		
	}

	@Override
	public JSONArray getPendingOrderList() {
		// TODO Auto-generated method stub
		List <Object[]> list=orderDao.getPendingOrderList();
		JSONArray jArray =new JSONArray();
		for(Object [] a:list) {
			JSONObject jsonobj =new JSONObject();
			jsonobj.put("orderdate", a[0]);
			jsonobj.put("orderId", a[1]);
			jsonobj.put("companyName", a[2]);
			jsonobj.put("clientLocation", a[3]);
			jsonobj.put("cpname", a[4]);
			jsonobj.put("contactNo", a[5]);
			jsonobj.put("spname", a[6]);
			jsonobj.put("count", a[7]);
			jsonobj.put("sum1", a[8]);
			
			jArray.put(jsonobj);
		}
		
		return jArray;
	}

	@Override
	public JSONArray getAllOrderStatus() {
		// TODO Auto-generated method stub
		List<Object []> list=orderDao.getAllOrderStatus();
		JSONArray jArray=new JSONArray();
		for(Object [] a:list) {
			JSONObject jsonobj=new JSONObject();
			jsonobj.put("orderdate",a[0]);
			jsonobj.put("orderId",a[1]);
			jsonobj.put("companyName",a[2]);
            jsonobj.put("clientLocation",a[3]);
            jsonobj.put("cpname", a[4]);
            jsonobj.put("contactNo", a[5]);
            jsonobj.put("spname",a[6]);
            jsonobj.put("count",a[7]);
            jsonobj.put("sum1",a[8]);
			jArray.put(jsonobj);
		}
		return jArray;
	}

	

}
