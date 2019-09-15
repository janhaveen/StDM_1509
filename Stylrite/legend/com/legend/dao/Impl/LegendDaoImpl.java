package com.legend.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.legend.dao.LegendDao;
import com.legend.pojo.AuditLegend;
import com.legend.pojo.BarcodeLegend;
import com.legend.pojo.GeneralLegend;
import com.legend.pojo.InventoryLegend;
import com.legend.pojo.PermissionLegend;
import com.legend.pojo.ProductLegend;
import com.legend.pojo.States;


@Repository("legendDaoImpl")
@Transactional("transactionManagerLegend")
public class LegendDaoImpl implements LegendDao
{
	@PersistenceContext(unitName="stylriteLegend")
	private EntityManager entityManagerLegend;
	
	public void setEntityManager(EntityManager entityManagerLegend) 
	{
		this.entityManagerLegend = entityManagerLegend;
	}
	
	@Override
	public List getProductLegendList() 
	{
		return entityManagerLegend.createQuery("select pl from ProductLegend pl",ProductLegend.class).getResultList();
	}
	
	public List getGeneralLegendList()
	{
		return entityManagerLegend.createQuery("select gl from GeneralLegend gl",GeneralLegend.class).getResultList();
	}

	@Override
	public List getAllState()
	{
		return entityManagerLegend.createQuery("select st from States st",States.class).getResultList();
	}

	@Override
	public List getPermissionLegendList() {
		return entityManagerLegend.createQuery("select st from PermissionLegend st where st.subCategory!='permissionVertical'",PermissionLegend.class).getResultList();
	}

	@Override
	public List getPermissionLegendListVerticalss() {
		return entityManagerLegend.createQuery("select st from PermissionLegend st where st.subCategory='permissionVertical'",PermissionLegend.class).getResultList();
	}

	@Override
	public List<ProductLegend> getbrandlegend(String brand) {
		
		 List<ProductLegend> prodlist = entityManagerLegend.createQuery("SELECT p from ProductLegend p where p.description = :description",ProductLegend.class)
			      .setParameter("description", brand)
			      .getResultList(); 
		return prodlist;
	}
	

	@Override
	public List<ProductLegend> getTypelegend(String type)
	{
		List<ProductLegend> typeList = entityManagerLegend.createQuery("SELECT p from ProductLegend p where p.description = :description",ProductLegend.class)
			      .setParameter("description", type)
			      .getResultList();
		return typeList;
	}
	
	@Override
	public List<ProductLegend> checkbrandsexists(List lst) {
		List<ProductLegend> prodlist = entityManagerLegend.createQuery("SELECT p from ProductLegend p where p.description IN ("+(lst.toString().substring(1, lst.toString().length()-1)).replaceAll("\"", "'")+")",ProductLegend.class)
			      .getResultList();
		System.out.println("List Size==>"+prodlist);
		return prodlist;
	}

	@Override
	public List getAuditList() 
	{
		return entityManagerLegend.createQuery("select al from AuditLegend al",AuditLegend.class).getResultList();
	}

	@Override
	public List getBarcodeLegendList() 
	{
		return entityManagerLegend.createQuery("select bl from BarcodeLegend bl",BarcodeLegend.class).getResultList();
	}

	@Override
	public List getInventoryLegendList() {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		return entityManagerLegend.createQuery("select il from InventoryLegend il",InventoryLegend.class ).getResultList();
	
	}
}
