package com.crm.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dao.ClientDao;
import com.crm.pojo.Client;
import com.crm.pojo.ClientAddress;
import com.crm.pojo.ClientContactPerson;
import com.crm.pojo.DetailedClientAddress;
import com.crm.pojo.DetailedClientContactPerson;
import com.crm.pojo.DetailedClientInfo;

@Repository("clientDaoImpl")
@Transactional("transactionManagerGeneral")
public class ClientDaoImpl implements ClientDao
{
	@PersistenceContext(unitName="stylriteGeneral")
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) 
	{
		this.entityManager = entityManager;
	}


	@Override
	public boolean addClient(Client client) {
        boolean bol = false;
		
		System.out.println("client"+client);
		
		try
		{
			entityManager.persist(client);
			
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
	public List<DetailedClientInfo> getClientList()
	{
		return entityManager.createQuery("select d from DetailedClientInfo d",DetailedClientInfo.class).getResultList();
	}




	@Override
	public boolean addClientAddress(ClientAddress caddress) {
       boolean bol = false;
		
		System.out.println("clientAddress"+caddress);
		
		try
		{
			entityManager.persist(caddress);
			
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
	public boolean addClientContactPerson(ClientContactPerson cperson) {
      boolean bol = false;
		
		System.out.println("clientContactPerson"+cperson);
		
		try
		{
			entityManager.persist(cperson);
			
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
	public boolean updateClient(Client client) {
		
		boolean b1=false;
		try {
		String hql="update Client client set client.companyName='"+client.getCompanyName()+"',client.location='" + client.getLocation() + "',"
				+ "client.customerType='"+client.getCustomerType()+"',client.source='"+client.getSource()+"',"
				+ "client.referenceBy='"+client.getReferenceBy()+"',client.creditTime='"+client.getCreditTime()+"',"
				+ "client.creditLimit='"+client.getCreditLimit()+"',client.salesPerson='"+client.getSalesPerson()+"'where client.rowId='"+client.getRowId()+"'";
		
		 System.out.println("update ClientDetails" + client);
         Query q = entityManager.createQuery(hql);
         int i = q.executeUpdate();
         System.out.println("affected row" + i);
         b1 = true;
     } catch (Exception e) {
         e.printStackTrace();
         b1 = false;
     }

     return b1;

         
	}


	@Override
	public boolean updateClientAddressDetails(ClientAddress caddress) {
		boolean b1=false;
		try {
		String hql="update ClientAddress caddress set caddress.branchName='"+caddress.getBranchName()+"',caddress.contactNo='" + caddress.getContactNo() + "',"
				+ "caddress.addressLine1='"+caddress.getAddressLine1()+"',caddress.addressLine2='"+caddress.getAddressLine2()+"',"
				+ "caddress.ledgerName='"+caddress.getLedgerName()+"',caddress.location='"+caddress.getLocation()+"',"
				+ "caddress.city='"+caddress.getCity()+"',caddress.state='"+caddress.getState()+"',"
				+ "caddress.gstNo='"+caddress.getGstNo()+"',caddress.pincode='"+caddress.getPincode()+"',caddress.isDefault='"+caddress.getIsDefault()+"' where caddress.rowId='"+caddress.getRowId()+"'";
		
		 System.out.println("update ClientAddressDetails" + caddress);
         Query q = entityManager.createQuery(hql);
         int i = q.executeUpdate();
         System.out.println("affected row" + i);
         b1 = true;
     } catch (Exception e) {
         e.printStackTrace();
         b1 = false;
     }

     return b1;

         
	}


	@Override
	public boolean updateClientContactDetail(ClientContactPerson cperson) {
		boolean b1=false;
		try
		{
		String hql="update ClientContactPerson cperson set cperson.firstName='"+cperson.getFirstName()+"',cperson.lastName='" + cperson.getLastName() + "',"
				+ "cperson.contactNo='"+cperson.getContactNo()+"',cperson.altContactNo='"+cperson.getAltContactNo()+"',"
				+ "cperson.emailId='"+cperson.getEmailId()+"',cperson.department='"+cperson.getDepartment()+"',"
				+ "cperson.designation='"+cperson.getDesignation()+"',cperson.birthdate='"+cperson.getBirthdate()+"',"
				+ "cperson.location='"+cperson.getLocation()+"',cperson.isDefault='"+cperson.getIsDefault()+"' where cperson.rowId='"+cperson.getRowId()+"'";
		
		 System.out.println("updateClientContactDetail" + cperson);
         Query q = entityManager.createQuery(hql);
         int i = q.executeUpdate();
         System.out.println("affected row" + i);
         b1 = true;
     } catch (Exception e) {
         e.printStackTrace();
         b1 = false;
     }

     return b1;
	}


	@Override
	public List<DetailedClientAddress> getAllClientAddressList(String clientId) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select detailedaddress from DetailedClientAddress detailedaddress where detailedaddress.clientId='"+clientId+"'",DetailedClientAddress.class).getResultList();
	}


	@Override
	public List<DetailedClientContactPerson> getAllClientContactPersonList(String clientId) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select contactpersonlist from DetailedClientContactPerson contactpersonlist where contactpersonlist.clientId='"+clientId+"'",DetailedClientContactPerson.class).getResultList();
	}


	@Override
	public boolean addNewClientContactPersonDetails(ClientContactPerson cperson) {
		 boolean bol = false;
			
			System.out.println("clientContactPerson"+cperson);
			
			try
			{
				entityManager.persist(cperson);
				
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
	public boolean addNewClientAddressDetails(ClientAddress caddress) {
             boolean bol = false;
		
		System.out.println("clientAddress"+caddress);
		
		try
		{
			entityManager.persist(caddress);
			
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
	public boolean updateIsDefaultOfClientContactPerson(String clientId)
	{
		boolean bool = false;
		try
		{
			String hql="update ClientContactPerson cperson set cperson.isDefault='0' where cperson.clientId='"+clientId+"'";
			
			 System.out.println("updateClientContactDetail" + hql);
			 
	         Query q = entityManager.createQuery(hql);
	         
	         int i = q.executeUpdate();
	         
	         System.out.println("affected row" + i);
	         
	         bool = true;
	         
		}
		catch (Exception e)
		{
	         e.printStackTrace();
	         bool = false;
		}

     return bool;
	}


	@Override
	public boolean updateIsDefaultOfClientAddress(String clientId)
	{
		boolean bool = false;
		try
		{
			String hql="update ClientAddress caddress set caddress.isDefault='0' where caddress.clientId='"+clientId+"'";
			
			 System.out.println("ClientAddressDetails" + hql);
			 
	         Query q = entityManager.createQuery(hql);
	         
	         int i = q.executeUpdate();
	         
	         System.out.println("affected row" + i);
	         
	         bool = true;
	         
		}
		catch (Exception e)
		{
	         e.printStackTrace();
	         
	         bool = false;
		}

     return bool;
     
	}


	@Override
	public List<DetailedClientInfo> getAllCustomerInfo(int rowNo) {
		// TODO Auto-generated method stub
		 return entityManager.createQuery("select d from DetailedClientInfo d where d.rowNo="+rowNo,DetailedClientInfo.class).getResultList();
	}
}
