package com.barcode.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.dao.AuditDao;
import com.barcode.dao.BarcodeDao;
import com.barcode.pojo.ChildBarcode;
import com.barcode.pojo.ChildBarcodeListForCSV;
import com.barcode.pojo.ChildBarcodeLog;
import com.barcode.pojo.ChildBarcodeLogListView;
import com.barcode.service.BarcodeService;
import com.data.service.impl.CurrentDateTime;
import com.product.dao.ProductDao;
import com.product.pojo.Product;
import com.purchase.dao.GRNDao;



@Service
public class BarcodeServiceImpl implements BarcodeService
{
	@Autowired
	HttpSession session;
	
	@Autowired
	private BarcodeDao barcodeDao;
	
	
	public void setBarcodeDao(BarcodeDao barcodeDao) 
	{
		this.barcodeDao = barcodeDao;
	}
	
	@Autowired
	private ProductDao productDao;
	
	
	public void setProductDao(ProductDao productDao) 
	{
		this.productDao = productDao;
	}
	
	@Autowired
	private GRNDao grnDao;
	
	@Autowired
	private AuditDao auditDao;

	@Override
	public List getChildBarcodeList() 
	{
		return barcodeDao.getChildBarcodeList();
	}

	@Override
	public int updateBarcode(ChildBarcode childBarcode)
	{
		boolean bool = false;
		
		int status=0;
		
		try
		{
			childBarcode.setUpdatedBy(String.valueOf(session.getAttribute("userRowId")));
			
			childBarcode.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
			
			bool = barcodeDao.updateBarcode(childBarcode);
			
			if(bool) 
			{
				status = 1301;
			}
			else 
			{
				status = 1302;
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public List checkScanBarcode(String barcode)
	{
		return barcodeDao.checkScanBarcode(barcode);
	}

	@Override
	public List getProductOfScanBarcode(String sku) 
	{
		return barcodeDao.getProductOfScanBarcode(sku);
	}

	@Override
	public int checkProductIfExistsOrNot(ChildBarcode childBarcode, Product product, String productIdText, String barcodeIdText2)
	{
		boolean bool = false;
		
		int status = 0;
		
		try
		{
			product.setRowId(productIdText);
			
			bool = productDao.CheckSkuExists(product);
			
			if(bool) 
			{
				status = 1501;
				
			}
			else 
			{
				status = 1502;
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public int addNewProductAndUpdateBarcode(ChildBarcode childBarcode, Product product, String productIdText, String barcodeIdText, String oldSku, String oldLocation, String oldStatus, String oldType, String auditItemIdCurrentId)
	{
		boolean bool = false;
		
		int status = 0;
		
		try
		{
			    product.setIsdeleted("0");
			    
			    product.setRowId(productIdText);
			  
			    product.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
			  
			    product.setCreatedOn(CurrentDateTime.CurrentTimestamp());
				
			    bool = productDao.addProduct(product);
			    if(bool)
				{
					System.out.println("new Sku..........");
					
					boolean bol = false;
					
					childBarcode.setUpdatedBy(String.valueOf(session.getAttribute("userRowId")));
					
					childBarcode.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
					
					childBarcode.setRowId(barcodeIdText);
					
					childBarcode.setRate(product.getCost());
					
					bol = barcodeDao.updateBarcode(childBarcode);
					
					if(bol) 
					{
						
						boolean checkSKU = false;
						
						ChildBarcodeLog childBarcodeLog = new ChildBarcodeLog();
						childBarcodeLog.setRowId(UUID.randomUUID().toString());
						childBarcodeLog.setBarcode(childBarcode.getRowId());
						childBarcodeLog.setAuditItemId(auditItemIdCurrentId);
						childBarcodeLog.setSku(childBarcode.getSku());
						childBarcodeLog.setStockActionType("304");
						childBarcodeLog.setFrom(oldSku);
						childBarcodeLog.setTo(childBarcode.getSku());
						childBarcodeLog.setRefNo(childBarcode.getGRNNumber());
						childBarcodeLog.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
						childBarcodeLog.setCreatedOn(CurrentDateTime.CurrentTimestamp());
						
						System.out.println(childBarcodeLog);
						
						checkSKU = grnDao.addChildBarcodeLog(childBarcodeLog);

						if(checkSKU) 
						{
							status = 1601;
						}
						else
						{
							status = 1602;
						}

						//Only For Product Type is Change...//
						if(!product.getType().equals(oldType))
						{
							boolean checkType1 = false;
							
							ChildBarcodeLog childBarcodeLog1 = new ChildBarcodeLog();
							childBarcodeLog1.setRowId(UUID.randomUUID().toString());
							childBarcodeLog1.setBarcode(childBarcode.getRowId());
							childBarcodeLog1.setAuditItemId(auditItemIdCurrentId);
							childBarcodeLog1.setSku(childBarcode.getSku());
							childBarcodeLog1.setStockActionType("305");
							childBarcodeLog1.setFrom(oldType);
							childBarcodeLog1.setTo(product.getType());
							childBarcodeLog1.setRefNo(childBarcode.getGRNNumber());
							childBarcodeLog1.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
							childBarcodeLog1.setCreatedOn(CurrentDateTime.CurrentTimestamp());
							
							checkType1 = grnDao.addChildBarcodeLog(childBarcodeLog1);
							
							if(checkType1)
							{
								boolean productType = false;
								
								//When we Product Type is Change then it is update in Product Table...//
								productType = productDao.updateTypeOfProduct(productIdText, product.getType());
								
								if(productType)
								{
									status = 1603;
								}
								else
								{
									status = 1604;
								}
							}
							else
							{
								status = 1605;
							}
						}
						//Only For ChildBarcode Location is Change...//
						if(!childBarcode.getLocation().equals(oldLocation))
						{
							boolean checkLocation1 = false;
							
							ChildBarcodeLog childBarcodeLog2 = new ChildBarcodeLog();
							childBarcodeLog2.setRowId(UUID.randomUUID().toString());
							childBarcodeLog2.setBarcode(childBarcode.getRowId());
							childBarcodeLog2.setAuditItemId(auditItemIdCurrentId);
							childBarcodeLog2.setSku(childBarcode.getSku());
							childBarcodeLog2.setStockActionType("301");
							childBarcodeLog2.setFrom(oldLocation);
							childBarcodeLog2.setTo(childBarcode.getLocation());
							childBarcodeLog2.setRefNo(childBarcode.getGRNNumber());
							childBarcodeLog2.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
							childBarcodeLog2.setCreatedOn(CurrentDateTime.CurrentTimestamp());

							checkLocation1 = grnDao.addChildBarcodeLog(childBarcodeLog2);

							if(checkLocation1)
							{
								status = 1606;
							}
							else
							{
								status = 1607;
							}
						}
						//Only For ChildBarcode Status is Change...//
						if(!childBarcode.getStatus().equals(oldStatus))
						{
							boolean checkStatus1 = false;
							
							ChildBarcodeLog childBarcodeLog3 = new ChildBarcodeLog();
							childBarcodeLog3.setRowId(UUID.randomUUID().toString());
							childBarcodeLog3.setBarcode(childBarcode.getRowId());
							childBarcodeLog3.setAuditItemId(auditItemIdCurrentId);
							childBarcodeLog3.setSku(childBarcode.getSku());
							childBarcodeLog3.setStockActionType("303");
							childBarcodeLog3.setFrom(oldStatus);
							childBarcodeLog3.setTo(childBarcode.getStatus());
							childBarcodeLog3.setRefNo(childBarcode.getGRNNumber());
							childBarcodeLog3.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
							childBarcodeLog3.setCreatedOn(CurrentDateTime.CurrentTimestamp());
							
							checkStatus1 = grnDao.addChildBarcodeLog(childBarcodeLog3);
							
							if(checkStatus1)
							{								
								status = 1608;
							}
							else
							{
								status = 1609;
							}
						}
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public int updateBarcodeWithOldSku(ChildBarcode childBarcode, Product product, String productIdText, String barcodeIdText, String oldLocation, String oldStatus, String oldType, String auditItemIdCurrentId)
	{
		System.out.println("old Sku..........");
		
		boolean bol = false;
		
		int status = 0;
		
		try
		{
			childBarcode.setUpdatedBy(String.valueOf(session.getAttribute("userRowId")));
			
			childBarcode.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
			
			childBarcode.setRowId(barcodeIdText);
			
			childBarcode.setRate(product.getCost());
			
			bol = barcodeDao.updateBarcode(childBarcode);
			
			if(bol) 
			{
				//Only For Product Type is Change...//
				if(!product.getType().equals(oldType))
				{
					boolean checkType1 = false;
					
					ChildBarcodeLog childBarcodeLog1 = new ChildBarcodeLog();
					childBarcodeLog1.setRowId(UUID.randomUUID().toString());
					childBarcodeLog1.setBarcode(childBarcode.getRowId());
					childBarcodeLog1.setAuditItemId(auditItemIdCurrentId);
					childBarcodeLog1.setSku(childBarcode.getSku());
					childBarcodeLog1.setStockActionType("305");
					childBarcodeLog1.setFrom(oldType);
					childBarcodeLog1.setTo(product.getType());
					childBarcodeLog1.setRefNo(childBarcode.getGRNNumber());
					childBarcodeLog1.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
					childBarcodeLog1.setCreatedOn(CurrentDateTime.CurrentTimestamp());
					
					checkType1 = grnDao.addChildBarcodeLog(childBarcodeLog1);
					
					if(checkType1)
					{
						boolean productType = false;
						
						//When we Product Type is Change then it is update in Product Table...//
						productType = productDao.updateTypeOfProduct(productIdText, product.getType());
						
						if(productType)
						{
							status = 1701;
						}
						else
						{
							status = 1702;
						}
					}
					else
					{
						status = 1703;
					}
				}
				//Only For ChildBarcode Location is Change...//
				if(!childBarcode.getLocation().equals(oldLocation))
				{
					boolean checkLocation1 = false;
					
					ChildBarcodeLog childBarcodeLog2 = new ChildBarcodeLog();
					childBarcodeLog2.setRowId(UUID.randomUUID().toString());
					childBarcodeLog2.setBarcode(childBarcode.getRowId());
					childBarcodeLog2.setAuditItemId(auditItemIdCurrentId);
					childBarcodeLog2.setSku(childBarcode.getSku());
					childBarcodeLog2.setStockActionType("301");
					childBarcodeLog2.setFrom(oldLocation);
					childBarcodeLog2.setTo(childBarcode.getLocation());
					childBarcodeLog2.setRefNo(childBarcode.getGRNNumber());
					childBarcodeLog2.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
					childBarcodeLog2.setCreatedOn(CurrentDateTime.CurrentTimestamp());

					checkLocation1 = grnDao.addChildBarcodeLog(childBarcodeLog2);

					if(checkLocation1)
					{
						status = 1704;
					}
					else
					{
						status = 1705;
					}
				}
				
				//Only For ChildBarcode Status is Change...//
				if(!childBarcode.getStatus().equals(oldStatus))
				{
					boolean checkStatus1 = false;
					
					ChildBarcodeLog childBarcodeLog3 = new ChildBarcodeLog();
					childBarcodeLog3.setRowId(UUID.randomUUID().toString());
					childBarcodeLog3.setBarcode(childBarcode.getRowId());
					childBarcodeLog3.setAuditItemId(auditItemIdCurrentId);
					childBarcodeLog3.setSku(childBarcode.getSku());
					childBarcodeLog3.setStockActionType("303");
					childBarcodeLog3.setFrom(oldStatus);
					childBarcodeLog3.setTo(childBarcode.getStatus());
					childBarcodeLog3.setRefNo(childBarcode.getGRNNumber());
					childBarcodeLog3.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
					childBarcodeLog3.setCreatedOn(CurrentDateTime.CurrentTimestamp());
					
					checkStatus1 = grnDao.addChildBarcodeLog(childBarcodeLog3);
					
					if(checkStatus1)
					{								
						status = 1706;
					}
					else
					{
						status = 1707;
					}
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

		return status;
	}
	
	@Override
	public List<ChildBarcodeLogListView> getEditBarCodeLogHistory(String rowId, String start, String limit)
	{
		return barcodeDao.getEditBarCodeLogHistory(rowId,start,limit);
	}

	@Override
	public int ckeckSectionOfBarcode(String barcode, String section) 
	{
		List<ChildBarcodeListForCSV> list = new ArrayList<ChildBarcodeListForCSV>();
		
		int status = 0;
		
		try
		{
			list = barcodeDao.ckeckSectionOfBarcode(barcode, section);
			
			if(list.size() == 0) 
			{
				status = 2501;
				
			}
			else 
			{
				status = 2502;
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public List<ChildBarcodeListForCSV> getExportBarcodeAsCSVList(String barcodes)
	{
		return barcodeDao.getExportBarcodeAsCSVList(barcodes);
		
		/*
		 * JSONArray jArray = new JSONArray();
		 * 
		 * List<ChildBarcodeListForCSV> list = new ArrayList<ChildBarcodeListForCSV>();
		 * 
		 * list = barcodeDao.getExportBarcodeAsCSVList(barcodes);
		 * 
		 * Iterator<ChildBarcodeListForCSV> itr = list.iterator();
		 * 
		 * while(itr.hasNext()) { ChildBarcodeListForCSV ch = itr.next();
		 * 
		 * JSONObject jsonObject = new JSONObject();
		 * 
		 * jsonObject.put("rowNo", ch.getRowNo()==0?0:ch.getRowNo());
		 * jsonObject.put("rowId", ch.getRowId()==null?"":ch.getRowId());
		 * jsonObject.put("brand_text", ch.getBrand_text()==null?"":ch.getBrand_text());
		 * jsonObject.put("modelNo", ch.getModelNo()==null?"":ch.getModelNo());
		 * jsonObject.put("color", ch.getColor()==null?"":ch.getColor());
		 * jsonObject.put("size", ch.getSize()==null?"":ch.getSize());
		 * jsonObject.put("type_text", ch.getType_txt()==null?"":ch.getType_txt());
		 * jsonObject.put("GRN", ch.getGRNNumber()==null?"":ch.getGRNNumber());
		 * jsonObject.put("location", ch.getLocation()==null?"":ch.getLocation());
		 * jArray.put(jsonObject); }
		 * 
		 * JSONObject jsonFinal = new JSONObject(); jsonFinal.putOnce("data", jArray);
		 * 
		 * return jsonFinal;
		 */
	
	}
	
}
