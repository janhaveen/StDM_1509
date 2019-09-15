package com.product.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.product.dao.ProductDao;
import com.product.pojo.HSN;
import com.product.pojo.Product;
import com.product.pojo.ProductListDataTable;
import com.product.pojo.ProductListView;


@Repository("productDaoImpl")
@Transactional("transactionManagerInventory")
public class ProductDaoImpl implements ProductDao
{
	@PersistenceContext(unitName="stylriteInventory")
	private EntityManager entityManagerInventory;
	
	public void setEntityManager(EntityManager entityManagerInventory) 
	{
		this.entityManagerInventory = entityManagerInventory;
	}

	@Override
	public List getProductList() 
	{
		return entityManagerInventory.createQuery("select plv from ProductListView plv where plv.isdeleted='0'",ProductListView.class).getResultList();
	}
	
	@Override
	public boolean addProduct(Product product)
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
	public List getHSNList()
	{
		return entityManagerInventory.createQuery("select hsn from HSN hsn",HSN.class).getResultList();
	}

	@Override
	public boolean updateProduct(Product product)
	{
		boolean bool = false;
	
		System.out.println("product"+product);
		
		try 
		{
			String hql="update Product p set p.brand='"+product.getBrand()+"',p.color='"+product.getColor()+"',p.description='"+product.getDescription()+"',p.hsnId='"+product.getHsnId()+"',p.modelNo='"+product.getModelNo()+"',p.cost='"+product.getCost()+"',p.size='"+product.getSize()+"',p.tag='"+product.getTag()+"',p.type='"+product.getType()+"',p.sku='"+product.getSku()+"',p.updatedBy='"+product.getUpdatedBy()+"',p.updatedOn='"+product.getUpdatedOn()+"' where p.rowId='"+product.getRowId()+"'";
			
			System.out.println("UpdateQuery product"+hql);
			
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
	public boolean deleteProduct(Product product, String rowId) 
	{
		boolean bool = false;
		
		System.out.println("product"+product+"  "+rowId);
		
		try 
		{
			String hql="update Product p set p.isdeleted='1' where p.rowId='"+rowId+"'";
			
			System.out.println("deleteProduct product"+hql);
			
			javax.persistence.Query query = entityManagerInventory.createQuery(hql);
			
			int i=query.executeUpdate();
			
			System.out.println("deleteProduct  Modified-->"+i);
			
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
	public boolean CheckSkuExists(Product product)
	{
		boolean bol = false;
		
	    List list = new ArrayList();
	
	    String query1 = "select p from Product p where p.brand='"+product.getBrand()+"' and p.modelNo='"+product.getModelNo()+"' and p.color='"+product.getColor()+"' and p.size='"+product.getSize()+"' and p.rowId!='"+product.getRowId()+"'";
		
		Query q = entityManagerInventory.createQuery(query1);
		
		System.out.println(q);

		list = q.getResultList();
 		
		System.out.println("CheckSkuExists........."+list);
		
		if(list.size() == 0)
		{
			bol=true;
		}
		
		return bol;
	}

	@Override
	public List getCheckSkuIfExists(Product product)
	{

	       List list = new ArrayList();
			
		    String query2 = "select p from ProductListView p where p.brand='"+product.getBrand()+"' and p.modelNo='"+product.getModelNo()+"' and p.color='"+product.getColor()+"' and p.size='"+product.getSize()+"' and p.rowId!='"+product.getRowId()+"'";
			
			Query q = entityManagerInventory.createQuery(query2);
			
			System.out.println(q);

			list = q.getResultList();
	 		
			System.out.println("getCheckSkuIfExists........."+list);
			
			if(list.size() == 0)
			{
				list = null;
				
				return list;
				
			}
			else
			{
				return list;
			}
		
	}

	@Override
	public List getProductListDataTable() {
		// TODO Auto-generated method stub
		return entityManagerInventory.createQuery("select plc from ProductListDataTable plc where plc.isdeleted='0'",ProductListDataTable.class).getResultList();
	}

	@Override
	public boolean updateTypeOfProduct(String productIdText, String type) 
	{
		boolean bool = false;
		
		System.out.println("productIdText"+productIdText+"  "+type);
		
		try 
		{
			String hql="update Product p set p.type='"+type+"' where p.rowId='"+productIdText+"'";
			
			System.out.println("updateTypeOfProduct product"+hql);
			
			javax.persistence.Query query = entityManagerInventory.createQuery(hql);
			
			int i=query.executeUpdate();
			
			System.out.println("updateTypeOfProduct  Modified-->"+i);
			
			bool = true;
		
		}
		catch (Exception e) 
		{
			bool = false;
			
			e.printStackTrace();
		}
		return bool;
	}

	/*
	 * @Override public boolean addProduct(Product product) { // TODO Auto-generated
	 * method stub return false; }
	 * 
	 * @Override public boolean updateProduct(Product product) { // TODO
	 * Auto-generated method stub return false; }
	 * 
	 * @Override public boolean deleteProduct(Product product, String rowId) { //
	 * TODO Auto-generated method stub return false; }
	 * 
	 * @Override public boolean CheckSkuExists(Product product) { // TODO
	 * Auto-generated method stub return false; }
	 */
	/*
	 * @Override public List getCheckSkuIfExists(Product product) { List list = new
	 * ArrayList();
	 * 
	 * String query2 =
	 * "select p from ProductListView p where p.brand='"+product.getBrand()
	 * +"' and p.modelNo='"+product.getModelNo()+"' and p.color='"+product.getColor(
	 * )+"' and p.size='"+product.getSize()+"' and p.rowId!='"+product.getRowId()+
	 * "'";
	 * 
	 * Query q = entityManagerInventory.createQuery(query2);
	 * 
	 * System.out.println(q);
	 * 
	 * list = q.getResultList();
	 * 
	 * System.out.println("getCheckSkuIfExists........."+list);
	 * 
	 * if(list.size() == 0) { list = null;
	 * 
	 * return list;
	 * 
	 * } else { return list; }
	 * 
	 * }
	 */

}
		