package com.purchase.dao;

import java.util.List;

import com.barcode.pojo.ChildBarcode;
import com.barcode.pojo.ChildBarcodeLog;
import com.product.pojo.Product;
import com.product.pojo.ProductListView;
import com.purchase.pojo.GRN;
import com.purchase.pojo.GRNItem;



public interface GRNDao 
{
	boolean addGRN(GRN grn);

	boolean addGRNItem(GRNItem grnItem);

	boolean CheckProductIfExists(Product product);

	boolean addProductGRN(Product product);

	boolean addNewChildBarcode(ChildBarcode cBarCode);

	List getChildBarcodeListForGrnIdBased(String grnId);
	
	List<ProductListView> getAllProductMsterData(ProductListView productListView);

	List getGRNList();

	List getGRNViewData(String grnId);

	boolean addChildBarcodeLog(ChildBarcodeLog childBarcodeLog);
}
