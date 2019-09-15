package com.stock.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sample.pojo.SampleList;
import com.stock.dao.StockDao;
import com.stock.pojo.StockoutListOrder;
import com.stock.pojo.StockoutListOrderDatatable;

@Repository("stockDaoImpl")
@Transactional("transactionManagerSales")
public class StockDaoImpl implements StockDao {
	@PersistenceContext(unitName="stylriteSales")
	private EntityManager entityManagerSales;
	@PersistenceContext(unitName="stylriteInventory")
	private EntityManager entityManagerInventory;
	public void setEntityManager(EntityManager entityManagerSales) 
	{
		this.entityManagerSales = entityManagerSales;
	}
	
	@Override
	public List getOrdersForStockOutList() {
		return entityManagerSales.createQuery("select sto from StockoutListOrderDatatable sto",StockoutListOrderDatatable.class).getResultList();
	}

	@Override
	public List getOrderProductsForStockOutList(String orderId) {
		return entityManagerSales.createQuery("select sto from StockoutListOrder sto where (sto.status_txt='Received' OR sto.status_txt='Partially Fulfilled')"
				+ " AND sto.id='"+orderId+"'",StockoutListOrder.class).getResultList();
	}

	@Override
	public List getSampleListForStockOutFromSample(String product_id) {
		// TODO Auto-generated method stub
		return entityManagerInventory.createQuery("SELECT s FROM SampleList s where 1=1 AND productid IN ("+product_id+")", SampleList.class).getResultList();
	}

}
