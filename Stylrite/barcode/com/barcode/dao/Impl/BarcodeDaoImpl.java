package com.barcode.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.barcode.dao.BarcodeDao;
import com.barcode.pojo.ChildBarcode;
import com.barcode.pojo.ChildBarcodeListForCSV;
import com.barcode.pojo.ChildBarcodeLogListView;
import com.product.pojo.ProductListView;


@Repository("barcodeDaoImpl")
@Transactional("transactionManagerInventory")
public class BarcodeDaoImpl implements BarcodeDao
{
	@PersistenceContext(unitName="stylriteInventory")
	private EntityManager entityManagerInventory;
	
	public void setEntityManager(EntityManager entityManagerInventory) 
	{
		this.entityManagerInventory = entityManagerInventory;
	}

	@Override
	public List getChildBarcodeList() 
	{
		return entityManagerInventory.createQuery("select cb from ChildBarcodeListForCSV cb",ChildBarcodeListForCSV.class).getResultList();
	}

	@Override
	public boolean updateBarcode(ChildBarcode childBarcode) 
	{
		boolean bool = false;
		
		System.out.println("childBarcode  "+childBarcode);
		
		try 
		{
			String hql="update ChildBarcode cb set cb.location='"+childBarcode.getLocation()+"',cb.rate='"+childBarcode.getRate()+"',cb.sku='"+childBarcode.getSku()+"',cb.status='"+childBarcode.getStatus()+"',cb.updatedBy='"+childBarcode.getUpdatedBy()+"',cb.updatedOn='"+childBarcode.getUpdatedOn()+"' where cb.rowId='"+childBarcode.getRowId()+"'";
			
			System.out.println("UpdateQuery childBarcode"+hql);
			
			javax.persistence.Query query = entityManagerInventory.createQuery(hql);
			
			int i=query.executeUpdate();
			
			System.out.println("product Modified-->"+i);
			
			bool = true;
		
		}
		catch (Exception e) 
		{
			bool = false;
			
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public List checkScanBarcode(String barcode) 
	{
		return entityManagerInventory.createQuery("select ch from ChildBarcodeListForCSV ch where ch.rowId='"+barcode+"'",ChildBarcodeListForCSV.class).getResultList();
	}

	@Override
	public List getProductOfScanBarcode(String sku) 
	{
		return entityManagerInventory.createQuery("select pl from ProductListView pl where pl.sku='"+sku+"'",ProductListView.class).getResultList();
	}

	@Override
	public List<ChildBarcodeLogListView> getEditBarCodeLogHistory(String rowId, String start, String limit)
	{
		return entityManagerInventory.createQuery("select chl from ChildBarcodeLogListView chl where chl.barcode='"+rowId+"' ",ChildBarcodeLogListView.class).setFirstResult(Integer.parseInt(start)).setMaxResults(Integer.parseInt(limit)).getResultList();
	}

	@Override
	public List<ChildBarcodeListForCSV> ckeckSectionOfBarcode(String barcode, String section)
	{
		return entityManagerInventory.createQuery("select ch from ChildBarcodeListForCSV ch where ch.rowId='"+barcode+"' and ch.section='"+section+"'",ChildBarcodeListForCSV.class).getResultList();
	}

	@Override
	public List<ChildBarcodeListForCSV> getExportBarcodeAsCSVList(String barcodes)
	{
		 TypedQuery<ChildBarcodeListForCSV> query = entityManagerInventory.createQuery("select ch from ChildBarcodeListForCSV ch where ch.rowId in("+barcodes+")", ChildBarcodeListForCSV.class);
			  
		 List<ChildBarcodeListForCSV> list = query.getResultList();
		
		 return list;
			  
		//return entityManagerInventory.createQuery("select ch.rowNo, ch.brand_text from ChildBarcodeListForCSV ch where ch.rowId in("+barcodes+")",ChildBarcodeListForCSV.class).getResultList();
	}

	@Override
	public int getCurrentSectionOfBarcode(String section) 
	{
		int countResult=0;
		try
		{
			Query query = entityManagerInventory.createQuery("SELECT ch FROM ChildBarcode ch where ch.section='"+section+"'",ChildBarcode.class);

			countResult=(int) query.getResultList().size();
			
			System.out.println("Count result:"+countResult);
		}
		catch (Exception e)
		{
			countResult=0;
			
			e.printStackTrace();
		}
		//return entityManagerInventory.createQuery("select ch from ChildBarcodeListForCSV ch where ch.section='"+section+"'",ChildBarcodeListForCSV.class).getResultList();
		
		return countResult;
	}
	
}
