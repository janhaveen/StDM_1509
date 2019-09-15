package com.requisition.dao;

import java.util.List;

public interface RequisitionDao {

	public List getInvoiceRequisitionList();

	public List getInvoiceRequisitionDetails(String requisitionId);

	public List getDispatchDetails(String requisitionId);

	public List getInvoiceDetails(String requisitionId);


}
