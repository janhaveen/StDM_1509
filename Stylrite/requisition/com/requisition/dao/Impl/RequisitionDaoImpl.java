package com.requisition.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.requisition.dao.RequisitionDao;
import com.requisition.pojo.DispatchDetails;
import com.requisition.pojo.InvoiceDetails;
import com.requisition.pojo.RequisitionDatatableView;
import com.requisition.pojo.RequisitionDetails;

@Repository("requisitionDaoImpl")
@Transactional("transactionManagerInventory")
public class RequisitionDaoImpl implements RequisitionDao {
	@PersistenceContext(unitName="stylriteInventory")
	private EntityManager entityManagerInventory;
	@PersistenceContext(unitName="stylriteSales")
	private EntityManager entityManagerSales;
	
	@Override
	public List getInvoiceRequisitionList() {
		return entityManagerInventory.createQuery("SELECT rq  FROM RequisitionDatatableView rq ",RequisitionDatatableView.class).getResultList();
	}

	@Override
	public List getInvoiceRequisitionDetails(String requisitionId) {
		//return entityManagerInventory.createQuery("call stylrite_inventory.getRequisitionDetails("+requisitionId+")", RequisitionDetails.class).getResultList();
		//return entityManagerInventory.createStoredProcedureQuery("call stylrite_inventory.getRequisitionDetails()", RequisitionDetails.class).getResultList();
		StoredProcedureQuery storedProcedure = 
				entityManagerInventory.createStoredProcedureQuery("getRequisitionDetails",RequisitionDetails.class)
		            .registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
		            .setParameter(1, requisitionId);
		return storedProcedure.getResultList();
	}

	@Override
	public List getDispatchDetails(String requisitionId) {
		return entityManagerSales.createQuery("SELECT d FROM DispatchDetails d where refRequisition='"+requisitionId+"'", DispatchDetails.class).getResultList();
	}

	@Override
	public List getInvoiceDetails(String requisitionId) {
		return entityManagerSales.createQuery("SELECT i FROM InvoiceDetails i where refRequisition='"+requisitionId+"'", InvoiceDetails.class).getResultList();
	}
}
