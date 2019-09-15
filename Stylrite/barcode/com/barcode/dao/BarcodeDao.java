package com.barcode.dao;

import java.util.List;

import com.barcode.pojo.ChildBarcode;
import com.barcode.pojo.ChildBarcodeListForCSV;

public interface BarcodeDao 
{
	List getChildBarcodeList();

	boolean updateBarcode(ChildBarcode childBarcode);

	List checkScanBarcode(String barcode);

	List getProductOfScanBarcode(String sku);

	List getEditBarCodeLogHistory(String rowId, String start, String limit);

	List<ChildBarcodeListForCSV> ckeckSectionOfBarcode(String barcode, String section);

	List<ChildBarcodeListForCSV> getExportBarcodeAsCSVList(String barcodes);

	int getCurrentSectionOfBarcode(String section);

}
