package com.npdProduct.daoImpl;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.npdProduct.dao.NPDProductDao;
import com.npdProduct.pojo.NPDProduct;
import com.npdProduct.pojo.NPDProductSentInfo;
import com.product.pojo.Product;
import com.product.pojo.ProductListView;



@Repository("npdProductDaoImpl")
@Transactional("transactionManagerInventory")
public class NPDProductDaoImpl implements NPDProductDao
{
	@PersistenceContext(unitName="stylriteInventory")
	private EntityManager entityManagerInventory;
	
	public void setEntityManager(EntityManager entityManagerInventory) 
	{
		this.entityManagerInventory = entityManagerInventory;
	}

	@Override
	public List getProductNPDList() 
	{
		return entityManagerInventory.createQuery("select p from ProductListView p where p.NPD='1'",ProductListView.class).getResultList();
	}

	@Override
	public boolean updateNPDProduct(Product product, String productId) 
	{
		boolean bool = false;
		
		System.out.println("product"+product+"  "+productId);
		
		try 
		{
			String hql="update Product p set p.NPD='0', p.updatedBy='"+product.getUpdatedBy()+"', p.updatedOn='"+product.getUpdatedOn()+"' where p.rowId='"+productId+"'";
			
			System.out.println("updateNPDProduct............"+hql);
			
			javax.persistence.Query query = entityManagerInventory.createQuery(hql);
			
			int i=query.executeUpdate();
			
			System.out.println("updateNPDProduct  Modified-->"+i);
			
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
	public boolean saveNPDProdduct(NPDProduct npdProduct) 
	{
		boolean bol = false;
		
		System.out.println("NPDProduct.... "+npdProduct);
		
		try
		{
			entityManagerInventory.persist(npdProduct);
			
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
	public List getRequestForPurchaseList() 
	{
		return entityManagerInventory.createQuery("select r from NPDProductSentInfo r where r.type='300001'",NPDProductSentInfo.class).getResultList();
	}

	@Override
	public List getRequestForProductionList() 
	{
		return entityManagerInventory.createQuery("select r from NPDProductSentInfo r where r.type='300002'",NPDProductSentInfo.class).getResultList();
	}

	@Override
	public boolean updateStatusForNPD(NPDProduct npdProduct)
	{
		boolean bool = false;
		
		System.out.println("npdProduct......................."+npdProduct);
		
		try 
		{
			String hql="update NPDProduct np set np.status = '"+npdProduct.getStatus()+"',  np.updatedBy='"+npdProduct.getUpdatedBy()+"', np.updatedOn='"+npdProduct.getUpdatedOn()+"' where np.rowId='"+npdProduct.getRowId()+"'";
			
			System.out.println("NPDProduct............"+hql);
			
			javax.persistence.Query query = entityManagerInventory.createQuery(hql);
			
			int i=query.executeUpdate();
			
			System.out.println("NPDProduct  Modified-->"+i);
			
			bool = true;
		
		}
		catch (Exception e) 
		{
			bool = false;
			
			e.printStackTrace();
		}
		return bool;
	}
}
		