package com.order.service;

import java.util.List;

import org.json.JSONArray;

import com.order.pojo.DetailedOrderItem;
import com.order.pojo.Order;
import com.order.pojo.OrderItem;
import com.product.pojo.Product;

public interface OrderService {

	public int addOrder(Order order,String action);


	public int addProduct(Product product);

	public List getAllOrderDetails(String orderId);

	public List getAllOrderListDatatables();


	public int addOrderItem(OrderItem oitem, Product product);


	public int updateOrder(Order order, String action);


	public int updateOrderItem(OrderItem oitem);


	public int deleteOrderItem(String parameter, OrderItem oitem);


	public int addNewEditOrder(Order order, String action);


	public int addNewEditOrderItem(OrderItem oitem, Product product);


	public int addNewEditProduct(Product product);


	public JSONArray getInprocessOrderList();


	public JSONArray getPendingOrderList();


	public JSONArray getAllOrderStatus();







	

}
