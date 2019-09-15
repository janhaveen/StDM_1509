package com.crm.service;
import java.util.List;

import com.crm.pojo.Vendor;
import com.crm.pojo.VendorAddress;
import com.crm.pojo.VendorContactPerson;

public interface VendorService 
{
     public int addVendor(Vendor vendor, String action);
    /*public int addVendor(Vendor vendor, String action);
    public List getAllVendors();
    public boolean vendorValidate(Vendor vendor);
    public Vendor getVendorById(int id);
    public boolean getVendorByEmail(String email);
    public int updateVendor(Vendor vendor, String action);
    public int deleteVendor(int rowNo, Vendor vendor);*/
    public int addVendorAddress(VendorAddress vaddress);
    public int addVendorContactPerson(VendorContactPerson vperson);
    public List getAllVendorList();
    public List getAllVendorAddressList(String clientId);
    public List getAllVendorContactPersonList(String vendorId);
    public int updateVendor(Vendor vendor, String action);
    public int updateVendorAddressDetails(VendorAddress vaddress, String action);
    public int updateVendorContactDetail(VendorContactPerson vperson, String action);
	public int addNewVendorContactPersonDetails(VendorContactPerson vperson, String action);
	public int addNewVendorAddressDetails(VendorAddress vaddress, String action);
	public int deleteVendor(String vendorId, Vendor vendor);
	public int deleteVendorContactPersonList(String vendorId, VendorContactPerson vperson);
	public int deleteVendorAddressList(String vendorId, VendorAddress vaddress);

}