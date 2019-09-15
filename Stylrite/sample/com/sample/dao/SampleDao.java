package com.sample.dao;

import java.util.List;

import com.barcode.pojo.ChildBarcode;
import com.barcode.pojo.ChildBarcodeLog;
import com.sample.pojo.AvailableStockSalesPerson;
import com.sample.pojo.Requistion;
import com.sample.pojo.RequistionItem;
import com.sample.pojo.RequistionList;
import com.sample.pojo.RequistionLog;
import com.sample.pojo.RequistionLogList;

public interface SampleDao {

	boolean addSampleNewRequistion(Requistion requistion);

	boolean addSampleRequistionItem(RequistionItem rqitem);

	

	boolean addSampleRequistionLog(RequistionLog rqlog);

  public List getAllSampleRequistionList();

public List getAllSampleProductRequistionList(String requisitionId);

List<RequistionLogList> getAllRemarksHistory(String requisitionId, String start, String limit);

 public List getStockSalesPerson(String spEmpid);

 public boolean addSampleTranasferRequistion(Requistion requistion);

boolean addSampleTransferRequistionLog(RequistionLog rqlog);

boolean addSampleTransferRequistionItem(RequistionItem rqitem);

boolean addSampleChildBarcodeLog(ChildBarcodeLog childbarcodelog);

boolean updateChildBarcodeLocation(ChildBarcode childBarcode, String cdRowId);

List getStockSalesPersonForTransfer(String spEmpid);

boolean addSampleReturnRequistion(Requistion requistion);

boolean addSampleTransferRequistionlog(RequistionLog rqlog);

boolean addSampleReturnRequistionItem(RequistionItem rqitem);

boolean updateChildBarcodeSampleReturn(ChildBarcode childbarcode, String barcode);

boolean addSampleReturnChildBarcodeLog(ChildBarcodeLog cblog);
 


}
