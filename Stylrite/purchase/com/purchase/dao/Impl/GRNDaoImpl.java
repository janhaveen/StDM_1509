package com.purchase.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.barcode.pojo.ChildBarcode;
import com.barcode.pojo.ChildBarcodeListForCSV;
import com.barcode.pojo.ChildBarcodeLog;
import com.product.pojo.Product;
import com.product.pojo.ProductListView;
import com.purchase.dao.GRNDao;
import com.purchase.pojo.GRN;
import com.purchase.pojo.GRNItem;
import com.purchase.pojo.GRNList;
import com.purchase.pojo.GRNViewDetails;


@Repository("grnDaoImpl")
@Transactional("transactionManagerInventory")
public class GRNDaoImpl implements GRNDao
{
	@PersistenceContext(unitName="stylriteInventory")
	private EntityManager entityManagerInventory;
	
	public void setEntityManager(EntityManager entityManagerInventory) 
	{
		this.entityManagerInventory = entityManagerInventory;
	}
	
	@Override
	public boolean addGRN(GRN grn)
	{
		boolean bol = false;
		
		System.out.println("grn.... "+grn);
		
		try
		{
			entityManagerInventory.persist(grn);
			
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
	public boolean addGRNItem(GRNItem grnItem) 
	{
		boolean bol = false;
		
		System.out.println("grnItem.... "+grnItem);
		
		try
		{
			entityManagerInventory.persist(grnItem);
			
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
	public boolean CheckProductIfExists(Product product)
	{
		   
		boolean bool = false;
		
	  List list = new ArrayList();
			  
	  String query2 ="select p from ProductListView p where p.brand='"+product.getBrand()+"' and p.modelNo='"+product.getModelNo()+"' and p.color='"+product.getColor()+"' and p.size='"+product.getSize()+"' and p.rowId!='"+product.getRowId()+ "'";
	  
	  Query q = entityManagerInventory.createQuery(query2);
	  
	  System.out.println(q);
	  
	  list = q.getResultList();
	  
	  System.out.println("CheckProductIfExists........."+list);
	  
	  if(list.size() == 0) 
	  { 
		  bool = true;
	  } 
	  else 
	  {
		  System.out.println("......."+list);
		  bool = false;
	  }
	  
	  return bool;
	}

	@Override
	public boolean addProductGRN(Product product)
	{
		boolean bol = false;
		
		System.out.println("product.... "+product);
		
		try
		{
			entityManagerInventory.persist(product);
			
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
	public boolean addNewChildBarcode(ChildBarcode cBarCode) 
	{
		boolean bol = false;
		
		System.out.println("cBarCode.... "+cBarCode);
		
		try
		{
			entityManagerInventory.persist(cBarCode);
			
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
	public List getChildBarcodeListForGrnIdBased(String grnId) 
	{
		return entityManagerInventory.createQuery("select cb from ChildBarcodeListForCSV cb where cb.GRNId='"+grnId+"'",ChildBarcodeListForCSV.class).getResultList();
	}
	
	@Override
	public List<ProductListView> getAllProductMsterData(ProductListView productListView)
	{
		
		 List<ProductListView> prodlist = entityManagerInventory.createQuery("SELECT p from ProductListView p where p.brand_txt = :brand And p.modelNo=:modelNo And p.color=:color And p.size=:size",ProductListView.class)
			      .setParameter("brand", productListView.getBrand())
			      .setParameter("modelNo", productListView.getModelNo())
			      .setParameter("color", productListView.getColor())
			      .setParameter("size", productListView.getSize())
			      .getResultList();
		 
		return  prodlist;
	}

	@Override
	public List getGRNList()
	{
		return entityManagerInventory.createQuery("select gl from GRNList gl",GRNList.class).getResultList();
	}

	@Override
	public List getGRNViewData(String grnId)
	{
		return entityManagerInventory.createQuery("select g from GRNViewDetails g where g.GRNId='"+grnId+"'",GRNViewDetails.class).getResultList();
	}

	@Override
	public boolean addChildBarcodeLog(ChildBarcodeLog childBarcodeLog) 
	{
		boolean bol = false;
		
		System.out.println("childBarcodeLog.... "+childBarcodeLog);
		
		try
		{
			entityManagerInventory.persist(childBarcodeLog);
			
			bol = true;
		}
		catch (Exception e) 
		{
			bol = false;
			
			e.printStackTrace();
		}
		
		return bol;	
	}

}
