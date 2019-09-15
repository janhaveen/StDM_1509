package com.sample.service;

import java.util.List;

import com.barcode.pojo.ChildBarcode;
import com.barcode.pojo.ChildBarcodeLog;
import com.sample.pojo.AvailableStockSalesPerson;
import com.sample.pojo.Requistion;
import com.sample.pojo.RequistionItem;
import com.sample.pojo.RequistionList;
import com.sample.pojo.RequistionLog;
import com.sample.pojo.RequistionLogList;

public interface SampleService {
	public int addSampleRequistionItem(RequistionItem rqitem, RequistionLog rqlog);

	public int addSampleNewRequistion(Requistion requistion, String action, RequistionLog rqlog);

	public List getAllSampleRequistionList();

	public List getAllSampleProductRequistionList(String requisitionId);

	public List<RequistionLogList> getAllRemarksHistory(String requisitionId, String start, String limit);

	public List getStockSalesPerson(String spEmpid);

	public int addSampleTransferRequistion(Requistion requistion, RequistionLog rqlog, String requisitionID,
			String requisitionLogID, String requitionstatus, String requisitionType, String action);

	public int addSampleTransferRequistionItem(RequistionItem rqitem, String requisitionItemID, String requisitionID,
			String requitionItemstatus);

	
	/*public int updateChildBarcodeLocation(ChildBarcode childBarcode, String cdRowId);*/

	/*public int addSampleChildBarcodeLog(ChildBarcodeLog childbarcodelog, String action, String cdRowId, String refid,
			String oldlocation, String location);
*/
	public List getStockSalesPersonForTransfer(String spEmpid);

	public int updateChildBarcodeLocation(ChildBarcode childBarcode, ChildBarcodeLog childbarcodelog, String cdRowId,
			String action, String refid, String oldlocation, String location);

	

	public int addSampleReturnRequistionItem(RequistionItem rqitem, String requisitionID, String requisitionItemID,
			String requitionItemstatus);

	public int addSampleReturnRequistion(Requistion requistion, RequistionLog rqlog, String requisitionID,
			String requisitionLogID, String requisitionType, String requistionstatus, String action,
			String salesperson);

	public int upadateChildBarcodeSampleReturn(ChildBarcode childbarcode, ChildBarcodeLog cblog, String barcode,
			String action, String requisitionitemid);

	

	

	
	





	
}
