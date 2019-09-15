package com.product.service.Impl;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.service.impl.CurrentDateTime;
import com.product.dao.ProductDao;
import com.product.pojo.Product;
import com.product.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService
{

	@Autowired
	HttpSession session;
	
	@Autowired
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) 
	{
		this.productDao = productDao;
	}
	
	@Override
	public List getProductList() 
	{
		return productDao.getProductList();
	}
	

	@Override
	public int addProduct(Product product, String action)
	{
		boolean bol = false;
		
		int status = 0;
		
		  product.setIsdeleted("0");
		  
		  product.setNPD("0");
		  
		  product.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
		  
		  product.setCreatedOn(CurrentDateTime.CurrentTimestamp());
		 
		if(action.equals("insertProduct")) 
		{
			bol = productDao.addProduct(product);
			
			if(bol)
			{
				status = 301;
			}
			else
			{
				status = 302;
			}
			
		}
		else
		{
			
		}
		
		return status;
	}

	@Override
	public List getHSNList() 
	{
		return productDao.getHSNList();
	}

	@Override
	public int updateProduct(Product product, String action)
	{
		boolean bool = false;
		
		int status=0;
		
		try
		{
			product.setUpdatedBy(String.valueOf(session.getAttribute("userRowId")));
			
			product.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
			
			if(action.equals("updateProduct")) 
			{ 
				
					bool = productDao.updateProduct(product);
					
					if(bool) 
					{
						status = 401;
					}
					else 
					{
						status = 402;
					}
			}

			else
			{
				status = 403;
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	
	}

	@Override
	public int deleteProduct(Product product, String rowId) 
	{
		boolean bool = false;
		
		int status=0;
		
		try
		{
			product.setUpdatedBy(String.valueOf(session.getAttribute("userRowId")));
			
			product.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
				
			bool = productDao.deleteProduct(product, rowId);
			
			if(bool) 
			{
				status = 501;
			}
			else 
			{
				status = 502;
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int CheckSkuExists(Product product)
	{
		boolean bool = false;
		
		int status = 0;
		
		try
		{
			bool = productDao.CheckSkuExists(product);
			
			System.out.println(bool);
			
			if(bool) 
			{
				status = 1;
			}
			else 
			{
				status = 0;
			}
		}
		catch (Exception e) 
		{
			
		}
		
		return status;
	}

	@Override
	public List getCheckSkuIfExists(Product product) {
		// TODO Auto-generated method stub
		return productDao.getCheckSkuIfExists(product);
	}

	@Override
	public List getProductListDataTable() {
		// TODO Auto-generated method stub
		return productDao.getProductListDataTable();
	}

	/*
	 * @Override public int addProduct(Product product, String action) { // TODO
	 * Auto-generated method stub return 0; }
	 * 
	 * @Override public int updateProduct(Product product, String action) { // TODO
	 * Auto-generated method stub return 0; }
	 * 
	 * @Override public int deleteProduct(Product product, String rowId) { // TODO
	 * Auto-generated method stub return 0; }
	 * 
	 * @Override public int CheckSkuExists(Product product) { // TODO Auto-generated
	 * method stub return 0; }
	 */

	/*
	 * @Override public List getCheckSkuIfExists(Product product) { return
	 * productDao.getCheckSkuIfExists(product); }
	 */

}
