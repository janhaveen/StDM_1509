package com.sample.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.barcode.pojo.ChildBarcode;
import com.barcode.pojo.ChildBarcodeLog;
import com.order.pojo.GetOrderList;
import com.sample.dao.SampleDao;
import com.sample.pojo.AvailableStockSalesPerson;
import com.sample.pojo.Requistion;
import com.sample.pojo.RequistionItem;
import com.sample.pojo.RequistionList;
import com.sample.pojo.RequistionLog;
import com.sample.pojo.RequistionLogList;

@Repository("sampleDaoImpl")
@Transactional("transactionManagerInventory")
public class SampleDaoImpl implements SampleDao {
	
	@PersistenceContext(unitName="stylriteInventory")
	private EntityManager entityManagerInventory;

	public void setEntityManagerInventory(EntityManager entityManagerInventory) {
		this.entityManagerInventory = entityManagerInventory;
	}

	@Override
	public boolean addSampleNewRequistion(Requistion requistion) {
		  boolean bol=false;
	      System.out.println(" New Requistion .... "+requistion);
			
			try
			{
				entityManagerInventory.persist(requistion);
				
				bol = true;
			}
			catch (Exception e) 
			{
				bol = false;
				
				e.printStackTrace();
			}
			
			return bol;
	}

	@Override
	public boolean addSampleRequistionItem(RequistionItem rqitem) {
		  boolean bol=false;
      System.out.println("Requistion Item.... "+rqitem);
		
		try
		{
			entityManagerInventory.persist(rqitem);
			
			bol = true;
		}
		catch (Exception e) 
		{
			bol = false;
			
			e.printStackTrace();
		}
		
		return bol;
		
	}

	@Override
	public boolean addSampleRequistionLog(RequistionLog rqlog) {
		  boolean bol=false;
	      System.out.println("Requistion Log.... "+rqlog);
			
			try
			{
				entityManagerInventory.persist(rqlog);
				
				bol = true;
			}
			catch (Exception e) 
			{
				bol = false;
				
				e.printStackTrace();
			}
			
			return bol;
	}

	@Override
	public List getAllSampleRequistionList() {
		// TODO Auto-generated method stub
		return entityManagerInventory.createQuery("select rqlist from  RequistionList rqlist",RequistionList.class).getResultList();
	}

	@Override
	public List getAllSampleProductRequistionList(String requisitionId) {
		// TODO Auto-generated method stub
		StoredProcedureQuery query= entityManagerInventory.createNamedStoredProcedureQuery("getRequisitionDetails");
		  query.setParameter("requisitionId",requisitionId);
		  System.out.println("query call procedur213123123123e" +query);
		  return query.getResultList();
	}

	@Override
	public List<RequistionLogList> getAllRemarksHistory(String requisitionId, String start, String limit)
	{
		// TODO Auto-generated method stub
		return  entityManagerInventory.createQuery("select rqlog from RequistionLogList rqlog where rqlog.requisitionId='"+requisitionId+"'",RequistionLogList.class).setFirstResult(Integer.parseInt(start)).setMaxResults(Integer.parseInt(limit)).getResultList();
		
	}

	@Override
	public List<AvailableStockSalesPerson> getStockSalesPerson(String spEmpid) {/*
		// TODO Auto-generated method stub
		List<AvailableStockSalesPerson> lst=entityManagerInventory.createQuery("select availstockperson from AvailableStockSalesPerson availstockperson where availstockperson.empid='"+spEmpid+"'", AvailableStockSalesPerson.class).getResultList();
		for(int i=0;i<lst.size();i++) {
			//a=lst.get(i);
			System.out.println(i+"sadhgfhsdfgh");
			System.out.println("act data===>"+lst.get(i));
		}
		return lst;
		
	*/
	return 	entityManagerInventory.createQuery("select availstockperson from AvailableStockSalesPerson availstockperson where availstockperson.empid='"+spEmpid+"'", AvailableStockSalesPerson.class).getResultList();
	}

	@Override
	public boolean addSampleTranasferRequistion(Requistion requistion) {
		// TODO Auto-generated method stub
	     boolean b1=false;
	     System.out.println("sample transfer requistion "+requistion);
	     try {
	    	 entityManagerInventory.persist(requistion);
	    	 b1=true;
	     }
	     catch(Exception e) {
	    	 e.printStackTrace();
	    	 b1=false;
	     }
		return b1;
	}

	@Override
	public boolean addSampleTransferRequistionLog(RequistionLog rqlog) {
		
		// TODO Auto-generated method stub
		boolean b1=false;
		System.out.println("sample tansfer requistion log"+rqlog);
		try {
			entityManagerInventory.persist(rqlog);
			b1=true;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			b1=false;
		}
		return b1;
	}

	@Override
	public boolean addSampleTransferRequistionItem(RequistionItem rqitem) {
		
		// TODO Auto-generated method stub
		 boolean b1 =false;
		 System.out.println("sample transfer Requistion item "+rqitem);
		 try {
			 entityManagerInventory.persist(rqitem);
		          b1=true;
		 }
		 catch(Exception e ) {
			 e.printStackTrace();
		      b1=false;
		 }
		return b1;
	}

	@Override
	public boolean addSampleChildBarcodeLog(ChildBarcodeLog childbarcodelog) {
		boolean b1=false;
		System.out.println("sample child barcode log"+childbarcodelog);
		try { 
			entityManagerInventory.persist(childbarcodelog);
			b1=true;
		}
		catch (Exception e) {
			b1=false;
			e.printStackTrace();
			// TODO Auto-generated method stub
		}
		
		return b1;
	}

	@Override
	public boolean updateChildBarcodeLocation(ChildBarcode childBarcode, String cdRowId) {
		// TODO Auto-generated method stub
		boolean b1=false;
		try {
		System.out.println("update child barcode location"+childBarcode);
		String hql="update ChildBarcode chbarcode set chbarcode.location='"+childBarcode.getLocation()+"',chbarcode.updatedBy='"+childBarcode.getUpdatedBy()+"',chbarcode.updatedOn='"+childBarcode.getUpdatedOn()+"'"
				+ " where chbarcode.rowId='"+cdRowId+"'";
		
		Query q=entityManagerInventory.createQuery(hql);
		System.out.println("update child barcode location"+q);
		int i=q.executeUpdate();
		System.out.println("infected row"+i);
		b1=true;
		
		
		
		}
		catch (Exception e) {
			b1=false;
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return b1;
	}

	@Override
	public List getStockSalesPersonForTransfer(String spEmpid) {
		// TODO Auto-generated method stub
		return entityManagerInventory.createQuery("SELECT a FROM AvailableStockSalesPerson a where a.empid='"+spEmpid+"'",AvailableStockSalesPerson.class).getResultList();
	}

	@Override
	public boolean addSampleReturnRequistion(Requistion requistion) {
		// TODO Auto-generated method stub
		boolean b1=false;
		try {
			entityManagerInventory.persist(requistion);
			b1=true;
		}catch (Exception e) {
			b1=false;
	   e.printStackTrace();
			// TODO: handle exception
		}
		return b1;
	}

	@Override
	public boolean addSampleTransferRequistionlog(RequistionLog rqlog) {
		// TODO Auto-generated method stub
		boolean b2=false;
		System.out.println("addSampleTransferRequistionlog"+rqlog);
		try {
			entityManagerInventory.persist(rqlog);
			b2=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b2;
	}

	@Override
	public boolean addSampleReturnRequistionItem(RequistionItem rqitem) {
		// TODO Auto-generated method stub
		boolean b1=false;
		System.out.println("sample return requistionitem log"+rqitem);
		try {
			entityManagerInventory.persist(rqitem);
			b1=true;
		}
		catch (Exception e) {
			// TODO: handle exception
			b1=false;
			e.printStackTrace();
		}
		return b1;
	}

	@Override
	public boolean updateChildBarcodeSampleReturn(ChildBarcode childbarcode, String barcode) {
		boolean b1=false;
		System.out.println("sample updateChildBarcodeSampleReturn"+childbarcode);
		try {
		String hql="update ChildBarcode chbarcode set chbarcode.location='"+childbarcode.getLocation()+"',chbarcode.updatedBy='"+childbarcode.getUpdatedBy()+"',chbarcode.updatedOn='"+childbarcode.getUpdatedOn()+"'"
				+ " where chbarcode.rowId='"+barcode+"'";
	Query q=	entityManagerInventory.createQuery(hql);
		int i=q.executeUpdate();	
		System.out.println("infected row"+i);
		b1=true;
		
	}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			b1=false;
		}
		  return b1;
		  }

	@Override
	public boolean addSampleReturnChildBarcodeLog(ChildBarcodeLog cblog) {
		// TODO Auto-generated method stub
		boolean b3=false;
		try {
			entityManagerInventory.persist(cblog);
			b3=true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
			b3=false;
		}
		return b3;
	}

	
	
}
