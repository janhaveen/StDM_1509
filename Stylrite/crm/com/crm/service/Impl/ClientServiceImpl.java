package com.crm.service.Impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.ClientDao;
import com.crm.pojo.Client;
import com.crm.pojo.ClientAddress;
import com.crm.pojo.ClientContactPerson;
import com.crm.service.ClientService;
import com.data.service.impl.CurrentDateTime;


@Service
public class ClientServiceImpl implements ClientService
{
	
	
	@Autowired
	HttpSession session;
	
	@Autowired
	private ClientDao clientDao;
	

	/*@Override
	public int addClient(Client client, String action) {
		// TODO Auto-generated method stub
       boolean bool = false;
		int  status = 0;
		if(action.equals("insert"))
		{
			bool=clientDao.addClient(client);
		}
		if(bool)
		{
		    boolean b3=clientDao.addContactPersonDetails();
		    if(b3)
		    {
		    	boolean b4=clientDao.addClientAddress(client);
		    	if(b4) 
		    	{
		    		status=501;
		    	}
		    }
		}
		else {
		 status=502;
		}
		return status;
	}*/


	@Override
	public List getAllClientList()
	{
		// TODO Auto-generated method stub
		return clientDao.getClientList();
	}


	@Override
	public int addClient(Client client, String action) {
		boolean b11=false;
		int status=0;
		client.setCreatedBy(String.valueOf(session.getAttribute("empName")));
		  
		client.setCreatedOn(CurrentDateTime.CurrentTimestamp());
		 
		
		if(action.equals("insert"))
		{
			b11=clientDao.addClient(client);
			if(b11)
			{
				status=501;
				
			}
		}
		else 
		{
			status=502;
		}
		return status;
	}


	


	


	@Override
	public int addClientAddress(ClientAddress caddress, boolean isDefault)
	{
		boolean b11=false;
		
		int status=0;
		
		caddress.setCreatedBy(String.valueOf(session.getAttribute("empName")));
		  
		caddress.setCreatedOn(CurrentDateTime.CurrentTimestamp());
		
		if(isDefault)
		{
			caddress.setIsDefault("1");
		}
		else
		{
			caddress.setIsDefault("0");
		}
		
        b11=clientDao.addClientAddress(caddress);
		
		if(b11)
		{
			status = 601;
		}
		else
		{
			status =602;
		}
		
		return status;
	}


	@Override
	public int addClientContactPerson(ClientContactPerson cperson, boolean isDefault)
	{
		boolean b11=false;
		int status=0;
		cperson.setCreatedBy(String.valueOf(session.getAttribute("empName")));
		  
		cperson.setCreatedOn(CurrentDateTime.CurrentTimestamp());
		
		if(isDefault)
		{
			cperson.setIsDefault("1");
		}
		else
		{
			cperson.setIsDefault("0");
		}
         
		b11=clientDao.addClientContactPerson(cperson);
		
		if(b11)
		{
			status = 701;
		}
		else
		{
			status =702;
		}
		
		return status;
	}


	@Override
	public int updateClient(Client client, String action) {
		
		boolean b1=false;
		int status=0;
		client.setUpdatedBy(String.valueOf(session.getAttribute("empName")));
		  
		client.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
       
		
        		 try {
        		    	if(action.equals("updateClient")) {
        		    		b1=clientDao.updateClient(client);
        		    		
        		    	}
        		    	if(b1) {
        		    		status=1501;
        		    	}
        		    	else {
        		    		status=1502;
        		    	}
        		    }catch (Exception e) {
        				// TODO: handle exception
        			}

		        return status;	
	}


	@Override
	public int updateClientAddressDetails(ClientAddress caddress, String action, boolean isDefault)
	{
       boolean b2=false;
       int status=0;
       caddress.setUpdatedBy(String.valueOf(session.getAttribute("empName")));
		  
       caddress.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
       
       try 
       { 
	       if(action.equals("updateAddress"))
	       {
	    	   if(isDefault)
	    	   {
	    		   caddress.setIsDefault("1");
	    		   
	    		   boolean bool = clientDao.updateIsDefaultOfClientAddress(caddress.getClientId());
					
					if(bool)
					{
						status = 1603;
					}
					else
					{
						status = 1604;
					}
	    	   }
	    	   else
	    	   {
	    		   caddress.setIsDefault("0");	   
	    	   }
	    	 b2=clientDao.updateClientAddressDetails(caddress);
	       }
	       
    	 if(b2)
    	 {
    		 status=1601;
    	 }
    	 else 
    	 {
    		 status=1602;
    	 }
       }
       catch (Exception e) {
		// TODO: handle exception
    	   e.printStackTrace();
	}
       

		return status;
		
		
		}


	
	@Override
	public List getAllClientAddressList(String clientId) {
		
		// TODO Auto-generated method stub
		return clientDao.getAllClientAddressList(clientId);
	}


	@Override
	public List getAllClientContactPersonList(String clientId) {
		// TODO Auto-generated method stub
		return clientDao.getAllClientContactPersonList(clientId);
	}


	@Override
	public int updateClientContactDetail(ClientContactPerson cperson, String action, boolean isDefault) 
	{
		boolean b3 =false;
		int status=0;
		cperson.setUpdatedBy(String.valueOf(session.getAttribute("empName")));
		  
		cperson.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
		
		try
		{
			 if(action.equals("updateContactPerson"))
			 {
				if(isDefault)
				{
					cperson.setIsDefault("1");
					
					boolean bool = clientDao.updateIsDefaultOfClientContactPerson(cperson.getClientId());
					
					if(bool)
					{
						status = 1703;
					}
					else
					{
						status = 1704;
					}
					
				}
				else
				{
					cperson.setIsDefault("0");
				}
				 b3=clientDao.updateClientContactDetail(cperson);
			 }
			
			if(b3) {
				status=1701;
			}
			else {
				status=1702;
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return status;
	}


	@Override
	public int addNewClientContactPersonDetails(ClientContactPerson cperson, String action, boolean isDefault)
	{
		boolean b11=false;
		int status=0;
		cperson.setCreatedBy(String.valueOf(session.getAttribute("empName")));
		  
		cperson.setCreatedOn(CurrentDateTime.CurrentTimestamp());
		if(action.equals("insertContactPerson")) 
		{
			if(isDefault)
			{
				cperson.setIsDefault("1");
				
				boolean bool = clientDao.updateIsDefaultOfClientContactPerson(cperson.getClientId());
				
				if(bool)
				{
					status = 701;
				}
				else
				{
					status = 702;
				}
				
			}
			else
			{
				cperson.setIsDefault("0");
			}
			
			b11=clientDao.addNewClientContactPersonDetails(cperson);
		}
		if(b11)
		{
			status = 703;
		}
		else
		{
			status =704;
		}
		
		return status;
	}


	@Override
	public int addNewClientAddressDetails(ClientAddress caddress, String action, boolean isDefault)
	{
		boolean b11=false;
		int status=0;
		caddress.setCreatedBy(String.valueOf(session.getAttribute("empName")));
		  
		caddress.setCreatedOn(CurrentDateTime.CurrentTimestamp());
		if(action.equals("insertAddress")) 
		{
			if(isDefault)
			{
				caddress.setIsDefault("1");
				
				boolean bool = clientDao.updateIsDefaultOfClientAddress(caddress.getClientId());
				
				if(bool)
				{
					status = 601;
				}
				else
				{
					status = 602;
				}
			}
			else
			{
				caddress.setIsDefault("0");
			}
			
           b11=clientDao.addNewClientAddressDetails(caddress);
		}
		if(b11)
		{
			status = 603;
		}
		else
		{
			status =604;
		}
		
		return status;
	}


	@Override
	public List getAllCustomerInfo(int rowNo) {
		// TODO Auto-generated method stub
		return clientDao.getAllCustomerInfo(rowNo);
	}


	

}
