package com.purchase.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barcode.pojo.ChildBarcode;
import com.barcode.pojo.ChildBarcodeLog;
import com.data.service.impl.CurrentDateTime;
import com.legend.dao.LegendDao;
import com.legend.pojo.ProductLegend;
import com.product.pojo.Product;
import com.product.pojo.ProductListView;
import com.purchase.dao.GRNDao;
import com.purchase.pojo.GRN;
import com.purchase.pojo.GRNItem;
import com.purchase.service.GRNService;

@Service
public class GRNServiceImpl implements GRNService
{
	@Autowired
	HttpSession session;
	
	@Autowired
	private GRNDao grnDao;
	
	public void setGrnDao(GRNDao grnDao) 
	{
		this.grnDao = grnDao;
	}
	
	@Autowired
	private LegendDao legendDao;

	@Override
	public int addGRN(GRN grn) 
	{
		boolean bol = false;
		
		int status = 0;
		
		try
		{
			grn.setPrintStatus(0);
			  
			grn.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
			
			grn.setCreatedOn(CurrentDateTime.CurrentTimestamp());
			 
			bol = grnDao.addGRN(grn);
			
			if(bol)
			{
				status = 601;
			}
			else
			{
				status = 602;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public int addGRNItem(GRNItem grnItem)
	{
		boolean bol = false;
		
		int status = 0;
		
		  //grn.setIsdeleted("0");
		try
		{
			grnItem.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
			
			grnItem.setCreatedOn(CurrentDateTime.CurrentTimestamp());
			
			bol = grnDao.addGRNItem(grnItem);
			
			if(bol)
			{
				status = 701;
			}
			else
			{
				status = 702;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int addProductGRN(Product product)
	{
		boolean bool = false;
		
		int status = 0;
		
		try
		{
			bool = grnDao.CheckProductIfExists(product);
			
			System.out.println(bool);
			
			if(bool) 
			{
				boolean bol = false;
				
				product.setIsdeleted("0");
				
				product.setNPD("1");
				
				product.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
				
				product.setCreatedOn(CurrentDateTime.CurrentTimestamp());
				
				bol = grnDao.addProductGRN(product);
				
				if(bol)
				{
					status = 801;
				}
				else
				{
					status = 802;
				}	
			}
			else 
			{
				status = 803;
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;

	}

	@Override
	public int addNewChildBarcode(ChildBarcode cBarCode)
	{
		boolean bool = false;
		
		int status = 0;
		
		try
		{
				cBarCode.setStockInDate(CurrentDateTime.CurrentTimestamp());
				
				cBarCode.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
				
				cBarCode.setCreatedOn(CurrentDateTime.CurrentTimestamp());
				
				bool = grnDao.addNewChildBarcode(cBarCode);
				
				if(bool)
				{
					boolean bol = false;
					
					ChildBarcodeLog childBarcodeLog = new ChildBarcodeLog();
					childBarcodeLog.setRowId(UUID.randomUUID().toString());
					childBarcodeLog.setBarcode(cBarCode.getRowId());
					childBarcodeLog.setSku(cBarCode.getSku());
					childBarcodeLog.setStockActionType("303");
					childBarcodeLog.setFrom("");
					childBarcodeLog.setTo("101");
					childBarcodeLog.setRefNo(cBarCode.getGRNNumber());
					childBarcodeLog.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
					childBarcodeLog.setCreatedOn(CurrentDateTime.CurrentTimestamp());
					
					bol = grnDao.addChildBarcodeLog(childBarcodeLog);
					
					if(bol)
					{
						status = 901;
					}
					else
					{
						status = 902;
					}
					
				}
				else
				{
					status = 903;
				}	
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;
	}

	
	@Override
	public List getChildBarcodeListForGrnIdBased(String grnId) 
	{
		return grnDao.getChildBarcodeListForGrnIdBased(grnId);
	}

	
	@Override
	public String uploadecsv(JSONObject obj1, String grnid) {
		
		JSONArray childjsonobject= (JSONArray) obj1.get("myrows");
		System.out.println("File Product   "+obj1.toString());
		for(int i=1;i<childjsonobject.length();i++) {
			System.out.println("In Loop After Query");
		
			JSONObject obj=new JSONObject();
			obj=childjsonobject.getJSONObject(i);
			ProductListView productcheck=new ProductListView();
			productcheck.setBrand(obj.get("brand").toString());
			productcheck.setModelNo(obj.get("modal").toString());
			productcheck.setColor(obj.get("color").toString());
			productcheck.setSize(obj.get("size").toString());
			
			List<ProductListView> lst=grnDao.getAllProductMsterData(productcheck);
			System.out.println("dfdf-->"+lst.toString());
			GRNItem gRNItem=new GRNItem();
			String brandsku;
			String productId = null;
			if(lst.size()==0) {
				System.out.println("Brand Name--->"+obj.get("brand").toString());
				List<ProductLegend> plegendlist=legendDao.getbrandlegend(obj.get("brand").toString());
				List<ProductLegend> pTypelist = legendDao.getTypelegend(obj.get("type").toString());
				 brandsku=plegendlist.get(0).getOtherInfo(); 
				brandsku=brandsku+"-"+obj.get("modal").toString()+"-"+obj.get("color").toString()+"-"+obj.get("size").toString();
				Product msterProduct1=new Product();
				msterProduct1.setRowId(obj.get("productId").toString());
				msterProduct1.setBrand(plegendlist.get(0).getRowId());
				msterProduct1.setModelNo(obj.get("modal").toString());
				msterProduct1.setColor(obj.get("color").toString());
				msterProduct1.setSize(obj.get("size").toString());
				msterProduct1.setType(pTypelist.get(0).getRowId());
				msterProduct1.setQty(Integer.parseInt(obj.get("qty").toString()));
				msterProduct1.setCost(Float.parseFloat(obj.get("cost").toString()));
				msterProduct1.setMRP(Float.parseFloat(obj.get("MRP").toString()));
				msterProduct1.setSku(brandsku);
				msterProduct1.setIsdeleted("0");
				msterProduct1.setNPD("0");
				msterProduct1.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
				msterProduct1.setCreatedOn(CurrentDateTime.CurrentTimestamp());
				grnDao.addProductGRN(msterProduct1);
			}else 
			{
				brandsku= lst.get(0).getSku(); 
				productId = lst.get(0).getRowId();
				
				System.out.println(brandsku+" .......dsg........ "+productId);
			}
			
			GRNItem rProduct=new GRNItem();
			
			rProduct.setGRNId(grnid);
			rProduct.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
			rProduct.setCreatedOn(CurrentDateTime.CurrentTimestamp());
			rProduct.setQuantity(Integer.parseInt(obj.get("qty").toString()));
			rProduct.setRate(Float.parseFloat(obj.get("cost").toString()));
			/*
			 * if(productId.equals(null)) {
			 * rProduct.setRowId(obj.get("productId").toString()); } else {
			 * rProduct.setRowId(productId); }
			 */
			rProduct.setRowId(obj.get("grnitemid").toString());
			rProduct.setSku(brandsku);

			grnDao.addGRNItem(rProduct);
		}
		return null;
	}

	@Override
	public String checkbrandsexists(List lst) 
	{
		List<ProductLegend>lst1= legendDao.checkbrandsexists(lst);
		List returnlist=new ArrayList();
		if(lst.size()==lst1.size())
		{
			return "true";
		}else {
			for(int i=0;i<lst.size();i++) {
				boolean status=true;
				for(int j=0;j<lst1.size();j++) {
					System.out.println("LST 1==>"+lst.get(i)+"   LST2==>"+lst1.get(j).getDescription());
					if(lst.get(i).toString().substring(1, lst.get(i).toString().length()-1).equals(lst1.get(j).getDescription())) {
						
						status=false;
						System.out.println("In Status=="+status);
					}
				}
				if(status) {
					returnlist.add(lst.get(i));
				}
			}
			System.out.println("List Return ---"+returnlist.toString());
			return returnlist.toString();
		}
		
		
	}
	
	@Override
	public List getGRNViewData(String grnId)
	{
		return grnDao.getGRNViewData(grnId);
	}

	@Override
	public List getGRNList() 
	{
		return grnDao.getGRNList();
	}

	@Override
	public int createSkuOfUploadGRNandAddNewChildBarcode(String brand, String modelNo, String color, String size, ChildBarcode childBarcode) 
	{
		boolean bool = false;
		
		int status = 0;
		
		String sku;
		
		try 
		{
			List<ProductLegend> pl = legendDao.getbrandlegend(brand);
			
			sku = pl.get(0).getOtherInfo(); 
			
			sku = sku+"-"+modelNo+"-"+color+"-"+size;
			
			childBarcode.setSku(sku);
			
			childBarcode.setStockInDate(CurrentDateTime.CurrentTimestamp());
			
			childBarcode.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
			
			childBarcode.setCreatedOn(CurrentDateTime.CurrentTimestamp());
			
			System.out.println(childBarcode);
			
			bool = grnDao.addNewChildBarcode(childBarcode);
			
			if(bool)
			{
				boolean bol = false;
				
				ChildBarcodeLog childBarcodeLog = new ChildBarcodeLog();
				childBarcodeLog.setRowId(UUID.randomUUID().toString());
				childBarcodeLog.setBarcode(childBarcode.getRowId());
				childBarcodeLog.setSku(childBarcode.getSku());
				childBarcodeLog.setStockActionType("303");
				childBarcodeLog.setFrom("");
				childBarcodeLog.setTo("101");
				childBarcodeLog.setRefNo(childBarcode.getGRNNumber());
				childBarcodeLog.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
				childBarcodeLog.setCreatedOn(CurrentDateTime.CurrentTimestamp());
				
				bol = grnDao.addChildBarcodeLog(childBarcodeLog);
				
				if(bol)
				{
					status = 1901;
				}
				else
				{
					status = 1902;
				}
			}
			else
			{
				status = 1903;
			}	
			
		} 
		catch (Exception e)
		{
			
		}
		
		return status;
		
	}

	//@Override
	/*
	 * public int addGRNItemWithAddProduct(GRNItem grnItem, Product product, String
	 * grnId, String productId, String sku) { boolean bool = false;
	 * 
	 * int status = 0;
	 * 
	 * try { String oldSku;
	 * 
	 * String productOldId = null;
	 * 
	 * List<ProductListView> lst = grnDao.getAllProductMsterData(product);
	 * 
	 * System.out.println("In lst check ==..............."+lst);
	 * 
	 * if(lst.size() == 0) { product.setRowId(productId);
	 * 
	 * boolean bol = false;
	 * 
	 * product.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
	 * 
	 * product.setCreatedOn(CurrentDateTime.CurrentTimestamp());
	 * 
	 * System.out.println("product..............."+product);
	 * 
	 * //bol = grnDao.addProductGRN(product);
	 * 
	 * if(bol) { status = 801; } else { status = 802; } } else { oldSku =
	 * lst.get(0).getSku(); productOldId = lst.get(0).getRowId();
	 * 
	 * System.out.println("oldSku..............."+oldSku+"........................"+
	 * productOldId); } } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * return 0; }
	 */

}
