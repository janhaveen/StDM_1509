package com.crm.service.Impl;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.VendorDao;
import com.crm.pojo.Vendor;
import com.crm.pojo.VendorAddress;
import com.crm.pojo.VendorContactPerson;
import com.crm.service.VendorService;
import com.data.service.impl.CurrentDateTime;

@Service
public class VendorServiceImpl implements VendorService
{
    @Autowired
    HttpSession session;
    
    @Autowired
    private VendorDao vendorDao;
    
    public void setVendorDao(VendorDao vendorDao) 
    {
        this.vendorDao = vendorDao;
    }
    
    
    @Override
    public int addVendor(Vendor vendor, String action)
    {
        boolean b11=false;
        int status=0;
        vendor.setCreatedBy(String.valueOf(session.getAttribute("empName")));
          
        vendor.setCreatedOn(CurrentDateTime.CurrentTimestamp());
        vendor.setIsDeleted("0");
         
        
        if(action.equals("insert"))
        {
            b11=vendorDao.addVendor(vendor);
            if(b11)
            {
                status=1501;
                
            }
        }
        else {
            status=1502;
        }
        return status;
    }
    @Override
    public int addVendorAddress(VendorAddress vaddress) {
    	
        boolean b11=false;
        int status=0;
        vaddress.setCreatedBy(String.valueOf(session.getAttribute("empName")));
          
        vaddress.setCreatedOn(CurrentDateTime.CurrentTimestamp());
        vaddress.setIsDeleted("0");
        
        
           b11=vendorDao.addVendorAddress(vaddress);
        
        if(b11)
        {
            status = 1601;
        }
        else
        {
            status =1602;
        }
        
        return status;
    }
    @Override
    public int addVendorContactPerson(VendorContactPerson vperson) {
        boolean b11=false;
        int status=0;
        vperson.setCreatedBy(String.valueOf(session.getAttribute("empName")));
          
        vperson.setCreatedOn(CurrentDateTime.CurrentTimestamp());
        vperson.setIsDeleted("0");
        
           b11=vendorDao.addVendorContactPerson(vperson);
        
        if(b11)
        {
            status = 1701;
        }
        else
        {
            status =1702;
        }
        
        return status;
    }
    @Override
    public List getAllVendorList() {
        // TODO Auto-generated method stub
        return vendorDao.getAllVendorList();
    }
    @Override
    public List getAllVendorAddressList(String clientId) {
        // TODO Auto-generated method stub
        return vendorDao.getAllVendorAddressList(clientId);
    }
    @Override
    public List getAllVendorContactPersonList(String vendorId) {
        // TODO Auto-generated method stub
        return vendorDao.getAllVendorContactPersonList(vendorId);
    }
    @Override 
    public int updateVendor(Vendor vendor, String action) {
        boolean b1=false;
        int status=0;
        vendor.setUpdatedBy(String.valueOf(session.getAttribute("empName")));
          
        vendor.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
       
        
                 try {
                        if(action.equals("updateVendor")) {
                            b1=vendorDao.updateVendor(vendor);
                            
                        }
                        if(b1) {
                            status=2501;
                        }
                        else {
                            status=2502;
                        }
                    }catch (Exception e) {
                        // TODO: handle exception
                    }
                return status;  
    }
    @Override
    public int updateVendorAddressDetails(VendorAddress vaddress, String action) {
        boolean b2=false;
           int status=0;
           vaddress.setUpdatedBy(String.valueOf(session.getAttribute("empName")));
              
           vaddress.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
           
           try 
           { if(action.equals("updateAddress")) {
             b2=vendorDao.updateVendorAddressDetails(vaddress);
           }
             if(b2)
             {
                 status=2601;
             }
             else 
             {
                 status=2602;
             }
           }
           catch (Exception e) {
            // TODO: handle exception
               e.printStackTrace();
        }
           
            return status;
            
    }
    @Override
    public int updateVendorContactDetail(VendorContactPerson vperson, String action) {
        boolean b3 =false;
        int status=0;
        vperson.setUpdatedBy(String.valueOf(session.getAttribute("empName")));
          
        vperson.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
        
        try {
             if(action.equals("updateContactPerson"))
             {
                 b3=vendorDao.updateVendorContactDetail(vperson);
             }
            
            if(b3) {
                status=2701;
            }
            else {
                status=2702;
            }
            
        }
        catch (Exception e) {
            // TODO: handle exception
        }
        return status;
    }


	@Override
	public int addNewVendorContactPersonDetails(VendorContactPerson vperson, String action)
	{
		boolean b11=false;
		int status=0;
		vperson.setCreatedBy(String.valueOf(session.getAttribute("empName")));
		  
		vperson.setCreatedOn(CurrentDateTime.CurrentTimestamp());
		  vperson.setIsDeleted("0");
		if(action.equals("insertContactPerson")) {
		
           b11=vendorDao.addNewVendorContactPersonDetails(vperson);
		}
		if(b11)
		{
			status = 1703;
		}
		else
		{
			status =1704;
		}
		
		return status;
	}


	@Override
	public int addNewVendorAddressDetails(VendorAddress vaddress, String action)
	{
		boolean b11=false;
		int status=0;
		vaddress.setCreatedBy(String.valueOf(session.getAttribute("empName")));
		  
		vaddress.setCreatedOn(CurrentDateTime.CurrentTimestamp());
		  vaddress.setIsDeleted("0");
		if(action.equals("insertAddress")) {
		
           b11=vendorDao.addNewVendorAddressDetails(vaddress);
		}
		if(b11)
		{
			status = 1603;
		}
		else
		{
			status =1604;
		}
		
		return status;
	}


	@Override
	public int deleteVendor(String vendorId, Vendor vendor) {
		int status=0;
		boolean b1=false;
		
		vendor.setUpdatedBy(String.valueOf(session.getAttribute("empName")));
         
		vendor.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
		
		try {
			b1=vendorDao.deleteVendor(vendorId,vendor);
		
		if(b1) {
			status=801;
		}
		else {
			status=802;
		}
		
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}


	@Override
	public int deleteVendorContactPersonList(String vendorId, VendorContactPerson vperson) {
		int status=0;
		boolean b1=false;
		
		vperson.setUpdatedBy(String.valueOf(session.getAttribute("empName")));
         
		vperson.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
		
		try {
			b1=vendorDao.deleteVendorContactPerson(vendorId,vperson);
		
		if(b1) {
			status=1901;
		}
		else {
			status=1902;
		}
		
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}


	@Override
	public int deleteVendorAddressList(String vendorId, VendorAddress vaddress) {
		int status=0;
		boolean b1=false;
		
		vaddress.setUpdatedBy(String.valueOf(session.getAttribute("empName")));
         
		vaddress.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
		
		try {
			b1=vendorDao.deleteVendorAddressList(vendorId,vaddress);
		
		if(b1) 
		{
			status=1903;
		}
		else
		{
			status=1904;
		}
		
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	

}