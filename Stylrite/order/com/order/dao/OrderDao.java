package com.order.dao;

import java.util.List;

import com.order.pojo.DetailedOrderItem;
import com.order.pojo.GetOrderList;
import com.order.pojo.Order;
import com.order.pojo.OrderItem;
import com.product.pojo.Product;

public interface OrderDao {

	public	boolean addOrder(Order order);

	public boolean addOrderItem(OrderItem oitem);

	public boolean CheckProductIfExists(Product product);

	public boolean addProductOrder(Product product);

	public List<GetOrderList> getAllOrderDetails(String orderId);

	public List getAllOrderListDatatables();

	public boolean updateOrder(Order order);

	public boolean UpdateOrderItem(OrderItem oitem);

	public boolean deleteOrderItem(String parameter, OrderItem oitem);

	public boolean addNewEditProductOrder(Product product);

	public boolean addNewEditOrderItem(OrderItem oitem);

	public boolean addNewEditOrder(Order order);

	public List<Object[]> getInprocessOrderList();

	public List<Object[]> getPendingOrderList();

	public List<Object[]> getAllOrderStatus();


}
