package com.order.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.order.dao.OrderDao;
import com.order.pojo.DetailedOrderItem;
import com.order.pojo.GetOrderList;
import com.order.pojo.Order;
import com.order.pojo.OrderItem;
import com.order.pojo.OrderListDatatable;
import com.product.pojo.Product;

@Repository("orderDaoImpl")
@Transactional("transactionManagerSales")
public class OrderDaoImpl implements OrderDao {

	@PersistenceContext(unitName="stylriteSales")
	private EntityManager entityManagerSales;
	
	@PersistenceContext(unitName="stylriteInventory")
	private EntityManager entityManagerInventory;
	@Override
	public boolean addOrder(Order order) {
	boolean bol = false;
		
		System.out.println("new Order.... "+order);
		
		try
		{
			entityManagerSales.persist(order);
			
			bol = true;
		}
		catch (Exception e) 
		{
			bol = false;
			
			e.printStackTrace();
		}
		
		return bol;
	}

	@Override
	public boolean addOrderItem(OrderItem oitem) {
             boolean bol = false;
		
		System.out.println("OrderItem data.... "+oitem);
		
		try
		{
			entityManagerSales.persist(oitem);
			
			bol = true;
		}
		catch (Exception e) 
		{
			bol = false;
			
			e.printStackTrace();
		}
		
		return bol;
	}

	@Override
	public boolean CheckProductIfExists(Product product) {
		boolean bool = false;
		
		  List list = new ArrayList();
				  
		  String query2 ="select p from ProductListView p where p.brand='"+product.getBrand()+"' and p.modelNo='"+product.getModelNo()+"' and p.color='"+product.getColor()+"' and p.size='"+product.getSize()+"' and p.rowId!='"+product.getRowId()+ "'";
		  
		  Query q = entityManagerInventory.createQuery(query2);
		  
		  System.out.println("Janhavee"+q);
		  
		  list = q.getResultList();
		  
		  System.out.println("CheckProductIfExists........."+list);
		  
		  if(list.size() == 0) 
		  { 
			  bool = true;
		  } 
		  else 
		  {
			  System.out.println("......."+list);
			  bool = false;
		  }
		  
		  return bool;
	}

	@Override
	@Transactional("transactionManagerInventory")
	public boolean addProductOrder(Product product) {
      boolean bol = false;
		
		System.out.println("product.... "+product);
		
		try
		{
			entityManagerInventory.persist(product);
			
			bol = true;
		}
		catch (Exception e) 
		{
			bol = false;
			
			e.printStackTrace();
		}
		
		return bol;
	}

	@Override
	public List<GetOrderList> getAllOrderDetails(String orderId) {
		
		StoredProcedureQuery query= entityManagerSales.createNamedStoredProcedureQuery("getOrderDetails");
        query.setParameter("orderId",orderId);
        System.out.println("query call procedur213123123123e" +query);
        
        return query.getResultList();
	}

	@Override
	public List<OrderListDatatable> getAllOrderListDatatables() {
		// TODO Auto-generated method stub
		return entityManagerSales.createQuery("select orderlist from OrderListDatatable orderlist",OrderListDatatable.class).getResultList();
	}

	@Override
	public boolean updateOrder(Order order) {
		boolean b1=false;
		System.out.println("Order update"+order);
		try {
		String hql="update Order o set o.clientId='"+order.getClientId()+"',o.contactPersonId='"+order.getContactPersonId()+"',o.billingAddressId='"+order.getBillingAddressId()+"',o.deliveryAddressId='"+order.getDeliveryAddressId()+"',o.salesPerson='"+order.getSalesPerson()+"',o.invoiceType='"+order.getInvoiceType()+"',o.modeOfPayment='"+order.getModeOfPayment()+"',o.expectedDeilvery='"+order.getExpectedDeilvery()+"',o.status='"+order.getStatus()+"',o.RefNo='"+order.getRefNo()+"',o.remarks='"+order.getRemarks()+"',o.updatedBy='"+order.getUpdatedBy()+"',o.updatedOn='"+order.getUpdatedOn()+"'where o.rowId='"+order.getRowId()+"'"; 				
		System.out.println("update Order"+hql);
		Query q=entityManagerSales.createQuery(hql);
		int i=q.executeUpdate();
		System.out.println("infected row"+i);
		b1=true;
		}
		catch(Exception e)
		{
			b1=false;
			e.printStackTrace();
		}
		return b1;
	}

	@Override
	public boolean UpdateOrderItem(OrderItem oitem) {
		boolean b1=false;
		System.out.println("OrderItem update"+oitem);
		try {
		String hql="update OrderItem oitem set oitem.orderId='"+oitem.getOrderId()+"',oitem.productId='"+oitem.getProductId()+"',oitem.quantity='"+oitem.getQuantity()+"',oitem.rate='"+oitem.getRate()+"',oitem.discount='"+oitem.getDiscount()+"',oitem.hsnId='"+oitem.getHsnId()+"',oitem.igst='"+oitem.getIgst()+"',oitem.status='"+oitem.getStatus()+"',oitem.updatedBy='"+oitem.getUpdatedBy()+"',oitem.updatedOn='"+oitem.getUpdatedOn()+"'where oitem.rowId='"+oitem.getRowId()+"'"; 				
		System.out.println("update OrderItem"+hql);
		Query q=entityManagerSales.createQuery(hql);
		int i=q.executeUpdate();
		System.out.println("infected row"+i);
		b1=true;
		}
		catch(Exception e)
		{
			b1=false;
			e.printStackTrace();
		}
		return b1;
	}

	@Override
	public boolean deleteOrderItem(String parameter, OrderItem oitem) {
		boolean b1=false;
		System.out.println("OrderItem Delete"+oitem);
		System.out.println("PARAMETER DAta "+parameter);
		try {
			
		String hql="delete from OrderItem oitem where oitem.productId ='"+parameter+"' and oitem.orderId='"+oitem.getOrderId()+"'";
		System.out.println("Delete OrderItem"+hql);
		Query q=entityManagerSales.createQuery(hql);
		int i=q.executeUpdate();
		System.out.println("infected row"+i);
		b1=true;
		}
		catch(Exception e)
		{
			b1=false;
			e.printStackTrace();
		}
		return b1;
	}

	
	@Override
	@Transactional("transactionManagerInventory")
	public boolean addNewEditProductOrder(Product product) {

	      boolean bol = false;
			
			System.out.println("product.... "+product);
			
			try
			{
				entityManagerInventory.persist(product);
				
				bol = true;
			}
			catch (Exception e) 
			{
				bol = false;
				
				e.printStackTrace();
			}
			
			return bol;
		
	}

	@Override
	public boolean addNewEditOrderItem(OrderItem oitem) {

        boolean bol = false;
	
	System.out.println(" new Edit OrderItem data.... "+oitem);
	
	try
	{
		entityManagerSales.persist(oitem);
		
		bol = true;
	}
	catch (Exception e) 
	{
		bol = false;
		
		e.printStackTrace();
	}
	
	return bol;

	}

	@Override
	public boolean addNewEditOrder(Order order) {
	boolean bol = false;
		
		System.out.println("new  Edit Order Item .... "+order);
		
		try
		{
			entityManagerSales.persist(order);
			
			bol = true;
		}
		catch (Exception e) 
		{
			bol = false;
			
			e.printStackTrace();
		}
		
		return bol;
	}

	@Override
	public List<Object[]> getInprocessOrderList() {

		// TODO Auto-generated method stub
		
	/*return entityManagerSales.createQuery("select d.orderdate,d.orderId,d.companyName,d.blocationadd,"
				+ "d.cpname,d.contactNo,d.salesperson,sum(d.quantity)AS d.count,sum(isEditable) AS d.sum1 from "
				+ "DetailedOrderItem d where d.quantity>d.quantity_out AND d.status_txt IN('Received','Partially Fulfilled')GROUP BY d.orderId "
				+ "ORDER BY d.createdOn DESC",DetailedOrderItem.class).getResultList();*/
		
	/*	return entityManagerSales.createQuery("select doi from DetailedOrderItem doi",DetailedOrderItem.class).getResultList();
	*/	/*+ "d.cpname,d.contactNo,d.salesperson from "
				+ "DetailedOrderItem d",DetailedOrderItem.class).getResultList();*/
		
		Query q = entityManagerSales.createNativeQuery("select d.orderdate,d.orderId,d.companyName,d.clientLocation,"
				+ "d.cpname,d.contactNo,d.spname,sum(d.quantity)AS count,sum(d.isEditable) AS sum1 from "
				+ "detailedorderitem d where d.quantity>d.quantity_out AND d.orderstatus_txt IN('Received','Partially Fulfilled')GROUP BY d.orderId "
				+ "ORDER BY d.createdOn DESC");
	
		List<Object[]> authors =q.getResultList();
		 
		/*System.out.println("Author "
		    + author[0]
		    + " "
		+ author[1]);*/
		
	return authors;
				
	
	}

	@Override
	public List<Object[]> getPendingOrderList() {
		// TODO Auto-generated method stub
		Query q= entityManagerSales.createNativeQuery("select d.orderdate,d.orderId,d.companyName,d.clientLocation,"
				     +"d.cpname,d.contactNo,d.spname,sum(d.quantity)AS count,sum(d.isEditable)AS sum1 from "
				     + "detailedorderitem d where d.orderstatus_txt='Received' OR d.orderstatus_txt='Partially Fulfilled' AND "
				     + "d.availablestock<(d.quantity-d.quantity_out) GROUP BY d.orderId ORDER BY d.createdOn DESC");
				
		List <Object[]> obj=q.getResultList();
		
		return obj;
	}

	@Override
	public List<Object[]> getAllOrderStatus() {
		// TODO Auto-generated method stub
		Query q=entityManagerSales.createNativeQuery("select d.orderdate,d.orderId,d.companyName,d.clientLocation,"
				+ "d.cpname,d.contactNo,d.spname,sum(d.quantity) AS count,sum(d.isEditable) AS sum1 from "
				+ "detailedorderitem d GROUP BY d.orderId ORDER BY d.createdOn DESC");
		List <Object[]> obj=q.getResultList();
		return obj;
	}

	

	
	}
