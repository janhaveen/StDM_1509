package com.barcode.service;

import java.util.List;


import com.barcode.pojo.ChildBarcode;
import com.barcode.pojo.ChildBarcodeListForCSV;
import com.product.pojo.Product;

public interface BarcodeService 
{
	List getChildBarcodeList();

	int updateBarcode(ChildBarcode childBarcode);

	List checkScanBarcode(String barcode);

	List getProductOfScanBarcode(String sku);

	int checkProductIfExistsOrNot(ChildBarcode childBarcode, Product product, String productIdText, String barcodeIdText2);

	int addNewProductAndUpdateBarcode(ChildBarcode childBarcode, Product product, String productIdText, String barcodeIdText, String oldSku, String oldLocation, String oldStatus, String oldType, String auditItemIdCurrentId);

	int updateBarcodeWithOldSku(ChildBarcode childBarcode, Product product, String productIdText, String barcodeIdText,  String oldLocation, String oldStatus, String oldType, String auditItemIdCurrentId);

	List getEditBarCodeLogHistory(String rowId, String start, String limit);

	int ckeckSectionOfBarcode(String barcode, String section);

	List<ChildBarcodeListForCSV> getExportBarcodeAsCSVList(String barcodes);
}
