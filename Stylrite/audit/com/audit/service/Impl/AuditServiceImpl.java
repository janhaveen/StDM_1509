package com.audit.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.dao.AuditDao;
import com.audit.pojo.Audit;
import com.audit.pojo.AuditItem;
import com.audit.pojo.AuditItemDetailsView;
import com.audit.service.AuditService;
import com.barcode.dao.BarcodeDao;
import com.data.service.impl.CurrentDateTime;

@Service
public class AuditServiceImpl implements AuditService
{

	@Autowired
	HttpSession session;
	
	@Autowired
	private AuditDao auditDao;
	
	@Autowired
	private BarcodeDao barcodeDao;

	@Override
	public int createAuditReason(Audit audit)
	{
		boolean bol = false;
		
		int status = 0;
		
		try
		{
			  
			audit.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
			
			audit.setCreatedOn(CurrentDateTime.CurrentTimestamp());
			
			audit.setStartTime(CurrentDateTime.CurrentTimestamp());
			
			audit.setItemsAudited("0");
			
			audit.setItemsCorrected("0");
			
			audit.setItemsDuplicated("0");
			 
			bol = auditDao.createAuditReason(audit);
			
			if(bol)
			{
				status = 1801;
			}
			else
			{
				status = 1802;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public List viewAuditDetails(String auditId) 
	{
		return auditDao.viewAuditDetails(auditId);
	}

	@Override
	public int saveAuditItem(JSONArray auditItemArray)
	{
		boolean bol = false;
		
		int status = 0;
		
		JSONObject js = new JSONObject();
		
		
		 try
		 {
			 for (int i = 0; i < auditItemArray.length(); i++)
			  {
				  JSONObject jsonObject = (JSONObject) auditItemArray.get(i);
				 
				 js = jsonObject;
				 System.out.println(jsonObject+"..................jsonObject......"+i);
				 
				 AuditItem auditItem = new AuditItem();
				 auditItem.setRowId(jsonObject.getString("rowId"));
				 auditItem.setAuditId(jsonObject.getString("auditId"));
				 auditItem.setBarcode(jsonObject.getString("barcode"));
				 auditItem.setSkuId(jsonObject.getString("sku"));
				 auditItem.setIsEdited("0");
				 auditItem.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
				 auditItem.setCreatedOn(CurrentDateTime.CurrentTimestamp());
				 
				 	bol = auditDao.saveAuditItem(auditItem);
					
					if(bol)
					{
						status = 2001;
					}
					else
					{
						status = 2002;
					}
				  
			  }
			 
			 System.out.println(js+"..................jsonObject......");
			 boolean bool = false;
			 Audit audit = new Audit();
			 	   audit.setRowId(js.getString("auditId"));
			 	   audit.setLostCount(js.getString("totalLostItem"));
			 	 bool = auditDao.updateLostCountInAudit(audit);
		 }
		 catch (Exception e) 
		 {
			e.printStackTrace();
		 }
		 
		return status;
	}

	@Override
	public int updateItemsAudited(Audit audit, JSONArray itemsAuditedArray)
	{
		boolean bol = false;
		
		int status = 0;
		
		JSONObject js = new JSONObject();
		
		 for (int i = 0; i < itemsAuditedArray.length(); i++)
		  {
			  JSONObject jsonObject = (JSONObject) itemsAuditedArray.get(i);
			 
			  js = jsonObject;
		  }
		 
		 System.out.println(js+"..................jsonObject......");
		 
		 try
		 {
			 audit.setRowId(js.getString("auditId"));
			 
			 audit.setItemsAudited(js.getString("itemsAuditedValue"));
			 
			 audit.setEndTime(CurrentDateTime.CurrentTimestamp());
			 
			 audit.setUpdatedBy(String.valueOf(session.getAttribute("userRowId")));
			 
			 audit.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
			 
			 bol = auditDao.updateItemsAudited(audit);
			 
			 if(bol)
			 {
				 status = 2101; 
			 }
			 else 
			 {
				 status = 2102;
			 }
			 
			 
		 }
		 catch (Exception e) 
		 {
			e.printStackTrace();
		 }
		 
		return status;
	}

	@Override
	public int updateItemsCorrected(Audit audit, JSONArray itemsCorrectedArray) 
	{
		boolean bol = false;
		
		int status = 0;
		
		JSONObject js = new JSONObject();
		
		 for (int i = 0; i < itemsCorrectedArray.length(); i++)
		  {
			  JSONObject jsonObject = (JSONObject) itemsCorrectedArray.get(i);
			 
			  js = jsonObject;
			  
		  }
		 
		  System.out.println(js+"..................jsonObject......");
		  
		  if(js.isEmpty())
		  {
			  System.out.println("js isEmpty in itemsCorrectedArray");
		  }
		  else
		  {
			  
			  try
				 {
					 audit.setRowId(js.getString("auditId"));
					 
					 audit.setItemsCorrected(js.getString("itemsCorrectedValue"));
					 
					 audit.setUpdatedBy(String.valueOf(session.getAttribute("userRowId")));
					 
					 audit.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
					 
					 bol = auditDao.updateItemsCorrected(audit);
					 
					 if(bol)
					 {
						 status = 2201; 
					 }
					 else 
					 {
						 status = 2202;
					 }
					 
					 
				 }
				 catch (Exception e) 
				 {
					e.printStackTrace();
				 }
		  }
		 
		return status;
	}

	@Override
	public int updateItemsDuplicated(Audit audit, JSONArray itemsDuplicatedArray) 
	{
		boolean bol = false;
		
		int status = 0;
		
		JSONObject js = new JSONObject();
		
		 for (int i = 0; i < itemsDuplicatedArray.length(); i++)
		  {
			  JSONObject jsonObject = (JSONObject) itemsDuplicatedArray.get(i);
			 
			  js = jsonObject;
		  }
		 
		 System.out.println(js+"..................jsonObject......");
		 
		 if(js.isEmpty())
		  {
			  System.out.println("js isEmpty in itemsDuplicatedArray");
		  }
		  else
		  {
			 try
			 {
				 audit.setRowId(js.getString("auditId"));
				 
				 audit.setItemsDuplicated(js.getString("itemsDuplicatedValue"));
				 
				 audit.setUpdatedBy(String.valueOf(session.getAttribute("userRowId")));
				 
				 audit.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
				 
				 bol = auditDao.updateItemsDuplicated(audit);
				 
				 if(bol)
				 {
					 status = 2301; 
				 }
				 else 
				 {
					 status = 2302;
				 }
			 }
			 catch (Exception e) 
			 {
				e.printStackTrace();
			 }
		  }
		 
		return status;
	}

	@Override
	public int updateIsEditedAuditItem(AuditItem auditItem, JSONArray updateIsEditedAuditItemArray)
	{
		boolean bol = false;
		
		int status = 0;
		
		 try
		 {
			 
			 for (int i = 0; i < updateIsEditedAuditItemArray.length(); i++)
			  {
				  JSONObject jsonObject = (JSONObject) updateIsEditedAuditItemArray.get(i);
				  
				  System.out.println(jsonObject+"..................jsonObject......"+i);
				  
				  	auditItem.setRowId(jsonObject.getString("auditItemIdCurrentId"));
					 
					 auditItem.setBarcode(jsonObject.getString("barcode"));
					 
					 auditItem.setIsEdited(jsonObject.getString("isEdited"));
					 
					 auditItem.setAuditId(jsonObject.getString("auditId"));
					 
					 auditItem.setUpdatedBy(String.valueOf(session.getAttribute("userRowId")));
					 
					 auditItem.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
					 
					 System.out.println(auditItem+"..................auditItem......");
					 
					 bol = auditDao.updateIsEditedAuditItem(auditItem);
					 
					 if(bol)
					 {
						 status = 2401; 
					 }
					 else 
					 {
						 status = 2402;
					 }
					 
				 
			  }
		 }
		 catch (Exception e) 
		 {
			e.printStackTrace();
		 }
		 
		return status;
	}

	@Override
	public List getAuditList()
	{
		return auditDao.getAuditList();
	}

	@Override
	public List getAuditItemDetailsViewList(String auditId)
	{
		return auditDao.getAuditItemDetailsViewList(auditId);
	}

	@Override
	public List<AuditItemDetailsView> getExportAuditItemAsCSVList(String auditItem) 
	{
		List<AuditItemDetailsView> list = auditDao.getExportAuditItemAsCSVList(auditItem);
		
		 HashMap<String, Object> hashMap  = null ;
		
		List list1=new ArrayList();
		
		for(AuditItemDetailsView auditItemDetailsView : list)
		{
			System.out.println("AuditItemDetailsView list size is .......... "+list.size());
			
			hashMap = new HashMap();
			
			/*
			 * hashMap.put("rowNo", auditItemDetailsView.getRowNo());
			 * hashMap.put("AuditItemId", auditItemDetailsView.getRowId());
			 * hashMap.put("BarCode", auditItemDetailsView.getBarcode());
			 * hashMap.put("rowNo", auditItemDetailsView.getRowNo()); hashMap.put("rowNo",
			 * auditItemDetailsView.getRowNo()); hashMap.put("rowNo",
			 * auditItemDetailsView.getRowNo()); hashMap.put("rowNo",
			 * auditItemDetailsView.getRowNo()); hashMap.put("rowNo",
			 * auditItemDetailsView.getRowNo()); hashMap.put("rowNo",
			 * auditItemDetailsView.getRowNo()); hashMap.put("rowNo",
			 * auditItemDetailsView.getRowNo()); hashMap.put("rowNo",
			 * auditItemDetailsView.getRowNo()); hashMap.put("rowNo",
			 * auditItemDetailsView.getRowNo()); hashMap.put("rowNo",
			 * auditItemDetailsView.getRowNo()); hashMap.put("rowNo",
			 * auditItemDetailsView.getRowNo()); hashMap.put("rowNo",
			 * auditItemDetailsView.getRowNo());
			 */
		}
		
		return list1;
	}

	@Override
	public int updateInCorrectedLocationAuditItem(AuditItem auditItem, JSONArray isInCorrectedLocationArray)
	{
		boolean bol = false;
		
		int status = 0;
		
		 try
		 {
			 
			 for (int i = 0; i < isInCorrectedLocationArray.length(); i++)
			  {
				  JSONObject jsonObject = (JSONObject) isInCorrectedLocationArray.get(i);
				  
				  System.out.println(jsonObject+"..................jsonObject......"+i);
				  
				  	 auditItem.setRowId(jsonObject.getString("auditItemIdCurrentId"));
				  	 
				  	 auditItem.setBarcode(jsonObject.getString("barcode"));
					 
				  	 auditItem.setIsInCorrectedLocation(jsonObject.getString("isInCorrectedLocation"));
				  	 
				  	 auditItem.setLocation(jsonObject.getString("location"));
					 
					 auditItem.setUpdatedBy(String.valueOf(session.getAttribute("userRowId")));
					 
					 auditItem.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
					 
					 System.out.println(auditItem+"..................auditItem......");
					 
					 bol = auditDao.updateInCorrectedLocationAuditItem(auditItem);
					 
					 if(bol)
					 {
						 status = 2601; 
					 }
					 else 
					 {
						 status = 2602;
					 }
					 
				 
			  }
		 }
		 catch (Exception e) 
		 {
			e.printStackTrace();
		 }
		 
		return status;
	}

	@Override
	public int getCurrentSectionData(String section) 
	{
		int countOfSection =  0;
		
		try
		{
			 countOfSection = barcodeDao.getCurrentSectionOfBarcode(section);
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return countOfSection;
	}

}
