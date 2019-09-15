package com.returnData.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.returnData.dao.ReturnDao;
import com.returnData.pojo.DetailReturnItemView;
import com.returnData.pojo.ReturnDemo;
import com.returnData.pojo.ReturnItem;

@Repository("returnDaoImpl")
@Transactional("transactionManagerSales")
public class ReturnDaoImpl implements ReturnDao
{
	@PersistenceContext(unitName="stylriteSales")
	private EntityManager entityManagerSales;

	public void setEntityManagerSales(EntityManager entityManagerSales)
	{
		this.entityManagerSales = entityManagerSales;
	}

	@Override
	public List<ReturnDemo> getAllReturnDetails()
	{
		return entityManagerSales.createQuery("select r from ReturnDemo r",ReturnDemo.class).getResultList();
	}

	@Override
	public boolean saveReturn(ReturnDemo returnDemo) 
	{
		boolean bol = false;
		
		System.out.println("returnDemo.... "+returnDemo);
		
		try
		{
			entityManagerSales.persist(returnDemo);
			
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
	public boolean saveReturnItem(ReturnItem returnItem) 
	{
		boolean bol = false;
		
		System.out.println("returnItem.... "+returnItem);
		
		try
		{
			entityManagerSales.persist(returnItem);
			
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
	public List<DetailReturnItemView> getAllReturnItemDetails() 
	{
		return entityManagerSales.createQuery("select dri from DetailReturnItemView dri",DetailReturnItemView.class).getResultList();
	}
	
	
}
