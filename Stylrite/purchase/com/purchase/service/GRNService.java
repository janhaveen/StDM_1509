package com.purchase.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.barcode.pojo.ChildBarcode;
import com.product.pojo.Product;
import com.purchase.pojo.GRN;
import com.purchase.pojo.GRNItem;


public interface GRNService 
{
	int addGRN(GRN grn);

	int addGRNItem(GRNItem grnItem);

	int addProductGRN(Product product);

	int addNewChildBarcode(ChildBarcode cBarCode);

	List getChildBarcodeListForGrnIdBased(String grnId);

	public String uploadecsv(JSONObject obj,String grnid);
	
	public String checkbrandsexists(List lst);

	List getGRNViewData(String grnId);

	List getGRNList();

	int createSkuOfUploadGRNandAddNewChildBarcode(String brand, String modelNo, String color, String size , ChildBarcode childBarcode);

	//int addGRNItemWithAddProduct(GRNItem grnItem, Product product, String grnId, String productId, String sku);
}
