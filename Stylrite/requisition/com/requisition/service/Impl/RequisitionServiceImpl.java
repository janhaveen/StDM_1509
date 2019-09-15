package com.requisition.service.Impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.requisition.dao.RequisitionDao;
import com.requisition.service.RequisitionService;
@Service
public class RequisitionServiceImpl implements RequisitionService {
	@Autowired
	HttpSession session;
	
	@Autowired
	private RequisitionDao requisitionDao;

	public RequisitionDao getRequisitionDao() {
		return requisitionDao;
	}

	public void setRequisitionDao(RequisitionDao requisitionDao) {
		this.requisitionDao = requisitionDao;
	}
	@Override
	public List getInvoiceRequisitionList() {
		return requisitionDao.getInvoiceRequisitionList();
	}

	@Override
	public List getInvoiceRequisitionDetails(String requisitionId) {		
		return requisitionDao.getInvoiceRequisitionDetails(requisitionId);
	}

	@Override
	public List getInvoiceDetails(String requisitionId) {
		return requisitionDao.getInvoiceDetails(requisitionId);
	}

	@Override
	public List getDispatchDetails(String requisitionId) {
		return requisitionDao.getDispatchDetails(requisitionId);
	}

	
}
