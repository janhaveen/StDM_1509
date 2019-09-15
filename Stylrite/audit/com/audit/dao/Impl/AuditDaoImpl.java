package com.audit.dao.Impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.audit.dao.AuditDao;
import com.audit.pojo.Audit;
import com.audit.pojo.AuditItem;
import com.audit.pojo.AuditItemDetailsView;
import com.audit.pojo.AuditList;
import com.audit.pojo.AuditView;


@Repository("auditDaoImpl")
@Transactional("transactionManagerInventory")
public class AuditDaoImpl implements AuditDao
{
	@PersistenceContext(unitName="stylriteInventory")
	private EntityManager entityManagerInventory;
	
	public void setEntityManager(EntityManager entityManagerInventory) 
	{
		this.entityManagerInventory = entityManagerInventory;
	}

	@Override
	public boolean createAuditReason(Audit audit) 
	{
		boolean bol = false;
		
		System.out.println("audit.... "+audit);
		
		try
		{
			entityManagerInventory.persist(audit);
			
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
	public List viewAuditDetails(String auditId) 
	{
		return entityManagerInventory.createQuery("select a from AuditView a where a.rowId = '"+auditId+"'",AuditView.class).getResultList();
	}

	@Override
	public boolean saveAuditItem(AuditItem auditItem) 
	{
		boolean bol = false;
		
		System.out.println("auditItem.... "+auditItem);
		
		try
		{
			entityManagerInventory.persist(auditItem);
			
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
	public boolean updateItemsAudited(Audit audit)
	{
		boolean bool = false;
		
		System.out.println("audit  "+audit);
		
		try 
		{
			String hql="update Audit a set a.itemsAudited='"+audit.getItemsAudited()+"', a.endTime='"+audit.getEndTime()+"', a.updatedBy='"+audit.getUpdatedBy()+"',a.updatedOn='"+audit.getUpdatedOn()+"' where a.rowId='"+audit.getRowId()+"'";
			
			System.out.println("UpdateQuery Audit"+hql);
			
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
	public boolean updateItemsCorrected(Audit audit) 
	{
		boolean bool = false;
		
		System.out.println("audit  "+audit);
		
		try 
		{
			String hql="update Audit a set a.itemsCorrected='"+audit.getItemsCorrected()+"',a.updatedBy='"+audit.getUpdatedBy()+"',a.updatedOn='"+audit.getUpdatedOn()+"' where a.rowId='"+audit.getRowId()+"'";
			
			System.out.println("UpdateQuery Audit"+hql);
			
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
	public boolean updateItemsDuplicated(Audit audit)
	{
		boolean bool = false;
		
		System.out.println("audit  "+audit);
		
		try 
		{
			String hql="update Audit a set a.itemsDuplicated='"+audit.getItemsDuplicated()+"',a.updatedBy='"+audit.getUpdatedBy()+"',a.updatedOn='"+audit.getUpdatedOn()+"' where a.rowId='"+audit.getRowId()+"'";
			
			System.out.println("UpdateQuery Audit"+hql);
			
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
	public boolean updateIsEditedAuditItem(AuditItem auditItem)
	{
		boolean bool = false;
		
		System.out.println("auditItem  "+auditItem);
		
		try 
		{
			String hql="update AuditItem ai set ai.isEdited='"+auditItem.getIsEdited()+"' where ai.rowId='"+auditItem.getRowId()+"'";
			
			System.out.println("UpdateQuery AuditItem"+hql);
			
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
	public List getAuditList() 
	{
		return entityManagerInventory.createQuery("select al from AuditList al",AuditList.class).getResultList();
	}

	@Override
	public List getAuditItemDetailsViewList(String auditId) 
	{
		return entityManagerInventory.createQuery("select a from AuditItemDetailsView a where a.auditId = '"+auditId+"'",AuditItemDetailsView.class).getResultList();
	}

	@Override
	public List<AuditItemDetailsView> getExportAuditItemAsCSVList(String auditItem) 
	{
		return entityManagerInventory.createQuery("select a from AuditItemDetailsView a where a.rowId in("+auditItem+")",AuditItemDetailsView.class).getResultList();
	}

	@Override
	public boolean updateInCorrectedLocationAuditItem(AuditItem auditItem) 
	{
		boolean bool = false;
		
		System.out.println("auditItem  "+auditItem);
		
		try 
		{
			String hql="update AuditItem ai set ai.isInCorrectedLocation='"+auditItem.getIsInCorrectedLocation()+"', ai.location='"+auditItem.getLocation()+"' where ai.rowId='"+auditItem.getRowId()+"'";
			
			System.out.println("UpdateQuery AuditItem"+hql);
			
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
	public boolean updateLostCountInAudit(Audit audit) 
	{
		boolean bool = false;
		
		System.out.println("audit  "+audit);
		
		try 
		{
			String hql="update Audit a set a.lostCount='"+audit.getLostCount()+"' where a.rowId='"+audit.getRowId()+"'";
			
			System.out.println("UpdateQuery Audit"+hql);
			
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

}
		