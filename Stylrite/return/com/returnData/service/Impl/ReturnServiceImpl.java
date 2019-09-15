package com.returnData.service.Impl;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.pojo.Audit;
import com.audit.pojo.AuditItem;
import com.data.service.impl.CurrentDateTime;
import com.product.dao.ProductDao;
import com.product.pojo.Product;
import com.returnData.dao.ReturnDao;
import com.returnData.pojo.DetailReturnItemView;
import com.returnData.pojo.ReturnDemo;
import com.returnData.pojo.ReturnItem;
import com.returnData.service.ReturnService;

@Service
public class ReturnServiceImpl implements ReturnService
{
	@Autowired
	ReturnDao returnDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	HttpSession session;
	
	@Override
	public List<ReturnDemo> getAllReturnDetails()
	{
		return returnDao.getAllReturnDetails();
	}

	@Override
	public int saveReturn(ReturnDemo returnDemo)
	{
		boolean bol = false;
		
		int status = 0;
		
		try
		{
			returnDemo.setStatus("941");
			
			returnDemo.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
			
			returnDemo.setCreatedOn(CurrentDateTime.CurrentTimestamp());
			 
			bol = returnDao.saveReturn(returnDemo);
			
			if(bol)
			{
				status = 3001;
			}
			else
			{
				status = 3002;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public int addProductReturn(Product product) 
	{
		  boolean bol = false;
		
		  int status = 0;
		
		  product.setIsdeleted("0");
		  
		  product.setNPD("1");
		  
		  product.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
		  
		  product.setCreatedOn(CurrentDateTime.CurrentTimestamp());
		 
		  bol = productDao.addProduct(product);
		
		 if(bol)
		 {
			status = 3201;
		 }
		 else
		 {
			status = 3202;
		 }
			
		return status;
	}

	@Override
	public List<DetailReturnItemView> getAllReturnItemDetails()
	{
		return returnDao.getAllReturnItemDetails();
	}

	@Override
	public int saveReturnItemArray(ReturnItem returnItemObject, ReturnDemo returnDemo, Product product, HttpServletRequest request, JSONArray returnItemArray) 
	{
		boolean bol = false;
		
		int status = 0;
		
		 try
		 {
			 for (int i = 0; i < returnItemArray.length(); i++)
			  {
				 
				JSONObject jsonObject = (JSONObject) returnItemArray.get(i);
				
				System.out.println(jsonObject);
				 
				
				  returnItemObject.setRowId(jsonObject.getString("returnItemId"));
				  
				  returnItemObject.setReturnId(jsonObject.getString("rowId"));
				  
				  returnItemObject.setSku(jsonObject.getString("sku"));
				  
				  returnItemObject.setQuantity(Integer.parseInt(jsonObject.getString("qty")));
				  
				  returnItemObject.setStatus("951");
				  
				  returnItemObject.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
				  
				  returnItemObject.setCreatedOn(CurrentDateTime.CurrentTimestamp());
				  
				  System.out.println(returnItemObject);
				  
				  bol = returnDao.saveReturnItem(returnItemObject);
				 			
					if(bol)
					 {
						status = 3301;
					 }
					 else
					 {
						status = 3302;
					 }
  
			  }
			 
		 }
		 catch (Exception e) 
		 {
			e.printStackTrace();
		 }
		 
		return status;
	}
	
}
