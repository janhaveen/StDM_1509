package com.crm.dao;
import java.util.List;

import com.crm.pojo.Vendor;
import com.crm.pojo.VendorAddress;
import com.crm.pojo.VendorContactPerson;

public interface VendorDao 
{
  public boolean addVendor(Vendor vendor);
    /*public boolean addVendor(Vendor vendor);
    public List getAllVendors();
    public List<Vendor> vendorValidate(Vendor vendor);
    public Vendor getVendorById(int id);
    public List<Vendor> getVendorByEmail(String email);
    public boolean updateVendor(Vendor vendor);
    public boolean deleteVendor(int rowNo, Vendor vendor);
    public boolean checkVendorContactNo(long contactNo);
    public boolean checkVendorGSTNo(String gstNo);
    public boolean checkUpdateVendorContactNo(long contactNo, int rowNo);
    public boolean checkUpdateVendorGSTNo(String gstNo, int rowNo);*/
  public  boolean addVendorAddress(VendorAddress vaddress);
    public  boolean addVendorContactPerson(VendorContactPerson vperson);
    public List getAllVendorList();
    public List getAllVendorAddressList(String clientId);
    public List getAllVendorContactPersonList(String vendorId);
    public boolean updateVendor(Vendor vendor);
    public boolean updateVendorAddressDetails(VendorAddress vaddress);
    public boolean updateVendorContactDetail(VendorContactPerson vperson);
	public boolean addNewVendorContactPersonDetails(VendorContactPerson vperson);
	public boolean addNewVendorAddressDetails(VendorAddress vaddress);
	public boolean deleteVendor(String vendorId, Vendor vendor);
	public boolean deleteVendorContactPerson(String vendorId, VendorContactPerson vperson);
	public boolean deleteVendorAddressList(String vendorId, VendorAddress vaddress);
}