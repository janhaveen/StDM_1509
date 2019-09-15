/**
 * 
 */
package com.requisition.service;

import java.util.List;

/**
 * @author janhavee
 *
 */

public interface RequisitionService {

	public List getInvoiceRequisitionList();

	public List getInvoiceRequisitionDetails(String requisitionId);

	public List getInvoiceDetails(String requisitionId);

	public List getDispatchDetails(String requisitionId);

}
