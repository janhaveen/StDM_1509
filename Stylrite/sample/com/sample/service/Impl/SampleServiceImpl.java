package com.sample.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barcode.pojo.ChildBarcode;
import com.barcode.pojo.ChildBarcodeLog;
import com.data.service.impl.CurrentDateTime;
import com.sample.dao.SampleDao;
import com.sample.pojo.AvailableStockSalesPerson;
import com.sample.pojo.Requistion;
import com.sample.pojo.RequistionItem;
import com.sample.pojo.RequistionLog;
import com.sample.pojo.RequistionLogList;
import com.sample.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService {

	@Autowired
	HttpSession session;

	@Autowired
	private SampleDao sampleDao;

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public void setSampleDao(SampleDao sampleDao) {
		this.sampleDao = sampleDao;
	}

	@Override
	public int addSampleNewRequistion(Requistion requistion, String action, RequistionLog rqlog) {
		int status = 0;
		boolean b = false;
		boolean b1 = false;
		try {
			requistion.setCreatedBy(String.valueOf(session.getAttribute("empName")));
			requistion.setCreatedOn(CurrentDateTime.CurrentTimestamp());
			requistion.setStatus("201");
			requistion.setRequisitionType("131");

			if (action.equals("insertSampleRequstion")) {
				b = sampleDao.addSampleNewRequistion(requistion);
			}
			if (b) {
				rqlog.setCreatedBy(String.valueOf(session.getAttribute("empName")));
				rqlog.setCreatedOn(CurrentDateTime.CurrentTimestamp());
				rqlog.setStatus("201");
				rqlog.setAction("323");
				rqlog.setRequisitionId(requistion.getRowId());

				b1 = sampleDao.addSampleRequistionLog(rqlog);

				if (b1) {
					status = 1701;
				} else {
					status = 1702;
				}
			} else {
				status = 1703;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return status;
	}

	@Override
	public int addSampleRequistionItem(RequistionItem rqitem, RequistionLog rqlog) {
		int status = 0;
		boolean b = false;
		boolean b1 = false;
		try {
			rqitem.setCreatedBy(String.valueOf(session.getAttribute("empName")));
			rqitem.setCreatedOn(CurrentDateTime.CurrentTimestamp());
			rqitem.setStatus("211");
			b = sampleDao.addSampleRequistionItem(rqitem);
			if (b) {

				status = 1701;
			} else {
				status = 1702;
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception

		}

		return status;
	}

	@Override
	public List getAllSampleRequistionList() {
		// TODO Auto-generated method stub
		return sampleDao.getAllSampleRequistionList();
	}

	@Override
	public List getAllSampleProductRequistionList(String requisitionId) {
		// TODO Auto-generated method stub
		return sampleDao.getAllSampleProductRequistionList(requisitionId);
	}

	@Override
	public List<RequistionLogList> getAllRemarksHistory(String requisitionId, String start, String limit) {
		// TODO Auto-generated method stub
		return sampleDao.getAllRemarksHistory(requisitionId, start, limit);
	}

	@Override
	public List getStockSalesPerson(String spEmpid) {
		/*
		 * // TODO Auto-generated method stub List list = new ArrayList<>(); // Iterator
		 * itr=list.iterator(); //while(itr.hasNext()) { list
		 * =sampleDao.getStockSalesPerson(spEmpid); System.out.println("LIST IS "+list);
		 * if(list.size() == 0) {
		 * 
		 * } else { list.add("act"); System.out.println("LIST1"+list); } return list;
		 */
		List<AvailableStockSalesPerson> list = new ArrayList<>();
		list = sampleDao.getStockSalesPerson(spEmpid);
		System.out.println("stock sales person list" + list);

		return list;

	}

	@Override
	public int addSampleTransferRequistion(Requistion requistion, RequistionLog rqlog, String requisitionID,
			String requisitionLogID, String requitionstatus, String requisitionType, String action) {

		// TODO Auto-generated method stub
		int status = 0;
		boolean b = false;
		boolean b1 = false;
		try {
			requistion.setCreatedBy(String.valueOf(session.getAttribute("empName")));
			requistion.setCreatedOn(CurrentDateTime.CurrentTimestamp());
			requistion.setRowId(requisitionID);
			requistion.setStatus(requitionstatus);
			requistion.setRequisitionType(requisitionType);
			if (action.equals("insert")) {
				b = sampleDao.addSampleTranasferRequistion(requistion);
				if (b) {

					rqlog.setRowId(requisitionLogID);
					rqlog.setCreatedBy(String.valueOf(session.getAttribute("empName")));
					rqlog.setCreatedOn(CurrentDateTime.CurrentTimestamp());
					rqlog.setRequisitionId(requisitionID);
					b1 = sampleDao.addSampleTransferRequistionLog(rqlog);
					if (b1) {
						status = 1703;
					} else {
						status = 1704;
					}

				} else {
					status = 1710;
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;

	}

	@Override
	public int addSampleTransferRequistionItem(RequistionItem rqitem, String requisitionItemID, String requisitionID,
			String requitionItemstatus) {
		boolean b1 = false;
		int status = 0;
		try {
			rqitem.setRowId(requisitionItemID);
			rqitem.setRequisitionId(requisitionID);
			rqitem.setStatus(requitionItemstatus);

			rqitem.setCreatedBy(String.valueOf(session.getAttribute("empName")));
			rqitem.setCreatedOn(CurrentDateTime.CurrentTimestamp());
			b1 = sampleDao.addSampleTransferRequistionItem(rqitem);
			if (b1) {
				status = 1803;
			} else {
				status = 1804;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return status;
	}

	/*
	 * @Override public int updateChildBarcodeLocation(ChildBarcode childBarcode,
	 * String cdRowId) { boolean b1=false; int status=0;
	 * 
	 * childBarcode.setRowId(cdRowId);
	 * childBarcode.setCreatedBy(String.valueOf(session.getAttribute("empName")));
	 * childBarcode.setCreatedOn(CurrentDateTime.CurrentTimestamp());
	 * b1=sampleDao.updateChildBarcodeLocation(childBarcode,cdRowId); if(b1) {
	 * status=111;
	 * 
	 * } else { status=112; }
	 * 
	 * // TODO Auto-generated method stub return status; }
	 */

	/*
	 * @Override public int addSampleChildBarcodeLog(ChildBarcodeLog
	 * childbarcodelog, String action, String cdRowId, String refid, String
	 * oldlocation, String location) {
	 * 
	 * int status=0; boolean b1=false; try {
	 * childbarcodelog.setRowId(UUID.randomUUID().toString());
	 * childbarcodelog.setCreatedBy(String.valueOf(session.getAttribute("empName")))
	 * ; childbarcodelog.setCreatedOn(CurrentDateTime.CurrentTimestamp());
	 * childbarcodelog.setBarcode(cdRowId);
	 * childbarcodelog.setStockActionType("301"); childbarcodelog.setRefNo(refid);
	 * childbarcodelog.setFrom(oldlocation); childbarcodelog.setTo(location);
	 * 
	 * if(action.equals("insert")) {
	 * b1=sampleDao.addSampleChildBarcodeLog(childbarcodelog); if(b1) { status=101;
	 * 
	 * }
	 * 
	 * else {
	 * 
	 * status=102;
	 * 
	 * } } } catch (Exception e) { // TODO: handle exception }
	 * 
	 * // TODO Auto-generated method stub return status;
	 * 
	 * }
	 */

	@Override
	public List getStockSalesPersonForTransfer(String spEmpid) {
		// TODO Auto-generated method stub
		return sampleDao.getStockSalesPersonForTransfer(spEmpid);
	}

	@Override
	public int updateChildBarcodeLocation(ChildBarcode childBarcode, ChildBarcodeLog childbarcodelog, String cdRowId,
			String action, String refid, String oldlocation, String location) {
		// TODO Auto-generated method stub
		boolean b1 = false;
		boolean b2 = false;
		int status = 0;
		try {
			if (action.equals("update")) {
				childBarcode.setRowId(cdRowId);
				childBarcode.setUpdatedBy(String.valueOf(session.getAttribute("empName")));
				childBarcode.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
				b1 = sampleDao.updateChildBarcodeLocation(childBarcode, cdRowId);
				if (b1) {
					childbarcodelog.setRowId(UUID.randomUUID().toString());
					childbarcodelog.setCreatedBy(String.valueOf(session.getAttribute("empName")));
					childbarcodelog.setCreatedOn(CurrentDateTime.CurrentTimestamp());
					childbarcodelog.setBarcode(cdRowId);
					childbarcodelog.setStockActionType("301");
					childbarcodelog.setRefNo(refid);
					childbarcodelog.setFrom(oldlocation);
					childbarcodelog.setTo(location);
					b2 = sampleDao.addSampleChildBarcodeLog(childbarcodelog);
					if (b2) {
						status = 140;

					} else {
						status = 141;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int addSampleReturnRequistion(Requistion requistion, RequistionLog rqlog, String requisitionID,
			String requisitionLogID, String requisitionType, String requistionstatus, String action,
			String salesperson) {

		// TODO Auto-generated method stub

		int status = 0;
		boolean b1 = false;
		boolean b2 = false;
		try {
			requistion.setCreatedBy(String.valueOf(session.getAttribute("empName")));
			requistion.setCreatedOn(CurrentDateTime.CurrentTimestamp());
			requistion.setRowId(requisitionID);
			requistion.setStatus(requistionstatus);
			requistion.setRequisitionType(requisitionType);
			requistion.setIssuesTo(salesperson);
			if (action.equals("insert")) {
				b1 = sampleDao.addSampleReturnRequistion(requistion);
				if (b1) {
					rqlog.setCreatedBy(String.valueOf(session.getAttribute("empName")));
					rqlog.setCreatedOn(CurrentDateTime.CurrentTimestamp());
					rqlog.setRowId(requisitionLogID);
					rqlog.setRequisitionId(requisitionID);
					b2 = sampleDao.addSampleTransferRequistionlog(rqlog);

					if (b2) {
						status = 191;
					} else {
						status = 192;
					}
				} else {
					status = 193;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return status;

	}

	@Override
	public int addSampleReturnRequistionItem(RequistionItem rqitem, String requisitionID, String requisitionItemID,
			String requitionItemstatus) {
		int status = 0;
		boolean b1 = false;
		try {
			rqitem.setCreatedBy(String.valueOf(session.getAttribute("empName")));
			rqitem.setCreatedOn(CurrentDateTime.CurrentTimestamp());
			rqitem.setRowId(requisitionItemID);
			rqitem.setRequisitionId(requisitionID);
			rqitem.setStatus(requitionItemstatus);
			b1 = sampleDao.addSampleReturnRequistionItem(rqitem);
			if (b1) {
				status = 195;
			} else {
				status = 196;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public int upadateChildBarcodeSampleReturn(ChildBarcode childbarcode, ChildBarcodeLog cblog, String barcode,
			String action, String requisitionitemid) 
	{
		int status=0;
		boolean b1=false;
	    boolean b2=false;
		try {
			childbarcode.setUpdatedBy(String.valueOf(session.getAttribute("empName")));
			childbarcode.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
			childbarcode.setRowId(barcode);
			childbarcode.setLocation("null");
			if(action.equals("update")) {
				b1=sampleDao.updateChildBarcodeSampleReturn(childbarcode,barcode);
				if(b1) {
					cblog.setRowId(UUID.randomUUID().toString());
					cblog.setBarcode(barcode);
					cblog.setCreatedBy(String.valueOf(session.getAttribute("empName")));
					cblog.setCreatedOn(CurrentDateTime.CurrentTimestamp());
					cblog.setStockActionType("302");
					cblog.setRefNo(requisitionitemid);
					b2=sampleDao.addSampleReturnChildBarcodeLog(cblog);
					if(b2) {
						status=197;
					}
					else {
						status=198;
					}
					
				}
				else {
					status=199;
				}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return status;
	}

}
