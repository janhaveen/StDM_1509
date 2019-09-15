package com.crm.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="detailedclientinfo")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "DetailedClientInfo")
@Proxy(lazy = false)
public class DetailedClientInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private int rowNo;
	

	@Column(name="rowId")
	private String rowId;
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="location")
	private String location;
	
	@Column(name="customerType")
	private String customerType;
	
	
	@Column(name="source")
	private String source;
	
	@Column(name="referenceBy")
	private String referenceBy;
	
	@Column(name="creditTime")
	private String creditTime;
	
	@Column(name="creditLimit")
	private String creditLimit;
	
	
	@Column(name="salesPerson")
	private String salesPerson;
	
	@Column(name="createdBy")
	private String createdBy;
	
	
	@Column(name="updatedBy")
	private String updatedBy;
	
	@Column(name="createdOn")
	private String createdOn;
	
	@Column(name="updatedOn")
	private String updatedOn;
	
	@Column(name="locationadd")
	private String locationadd;
	
	@Column(name="addressId")
	private String addressId;
	
	@Column(name="branchName")
	private String branchName;
	
	@Column(name="ledgerName")
	private String ledgerName;
	
	@Column(name="addressLine1")
	private String addressLine1;
	
	@Column(name="addressLine2")
	private String addressLine2;

	@Column(name="gstNo")
	private String gstNo;
	

	@Column(name="state")
	private String state;
	
	@Column(name="pincode")
	private int pincode;
	
	
	@Column(name="contactPerson")
	private String contactPerson;
	
	@Column(name="CPId")
	private String CPId;
	
	@Column(name="contactNoCP")
	private long contactNoCP;
	
	
	@Column(name="altContactNoCP")
	private long altContactNoCP;
	
	
	@Column(name="emailIdCP")
	private String emailIdCP;
	
	@Column(name="state_text")
	private String state_text;
	
	@Column(name="salesPerson_text")
	private String salesPerson_text;
	
	@Column(name="designationOfSalesP")
	private String designationOfSalesP;
	
	@Column(name="reportToOfSalesP")
	private String reportToOfSalesP;
	
	
	@Column(name="source_text")
	private String source_text;
	
	@Column(name="customerType_txt")
	private String customerType_txt;
	
	@Column(name="industry_txt")
	private String industry_txt;

	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getReferenceBy() {
		return referenceBy;
	}

	public void setReferenceBy(String referenceBy) {
		this.referenceBy = referenceBy;
	}

	public String getCreditTime() {
		return creditTime;
	}

	public void setCreditTime(String creditTime) {
		this.creditTime = creditTime;
	}

	public String getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getSalesPerson() {
		return salesPerson;
	}

	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getLocationadd() {
		return locationadd;
	}

	public void setLocationadd(String locationadd) {
		this.locationadd = locationadd;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getLedgerName() {
		return ledgerName;
	}

	public void setLedgerName(String ledgerName) {
		this.ledgerName = ledgerName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getCPId() {
		return CPId;
	}

	public void setCPId(String cPId) {
		CPId = cPId;
	}

	public long getContactNoCP() {
		return contactNoCP;
	}

	public void setContactNoCP(long contactNoCP) {
		this.contactNoCP = contactNoCP;
	}

	public long getAltContactNoCP() {
		return altContactNoCP;
	}

	public void setAltContactNoCP(long altContactNoCP) {
		this.altContactNoCP = altContactNoCP;
	}

	public String getEmailIdCP() {
		return emailIdCP;
	}

	public void setEmailIdCP(String emailIdCP) {
		this.emailIdCP = emailIdCP;
	}

	public String getState_text() {
		return state_text;
	}

	public void setState_text(String state_text) {
		this.state_text = state_text;
	}

	public String getSalesPerson_text() {
		return salesPerson_text;
	}

	public void setSalesPerson_text(String salesPerson_text) {
		this.salesPerson_text = salesPerson_text;
	}

	public String getDesignationOfSalesP() {
		return designationOfSalesP;
	}

	public void setDesignationOfSalesP(String designationOfSalesP) {
		this.designationOfSalesP = designationOfSalesP;
	}

	public String getReportToOfSalesP() {
		return reportToOfSalesP;
	}

	public void setReportToOfSalesP(String reportToOfSalesP) {
		this.reportToOfSalesP = reportToOfSalesP;
	}

	public String getSource_text() {
		return source_text;
	}

	public void setSource_text(String source_text) {
		this.source_text = source_text;
	}

	public String getCustomerType_txt() {
		return customerType_txt;
	}

	public void setCustomerType_txt(String customerType_txt) {
		this.customerType_txt = customerType_txt;
	}

	public String getIndustry_txt() {
		return industry_txt;
	}

	public void setIndustry_txt(String industry_txt) {
		this.industry_txt = industry_txt;
	}

	@Override
	public String toString() {
		return "DetailedClientInfo [rowNo=" + rowNo + ", rowId=" + rowId + ", companyName=" + companyName
				+ ", location=" + location + ", customerType=" + customerType + ", source=" + source + ", referenceBy="
				+ referenceBy + ", creditTime=" + creditTime + ", creditLimit=" + creditLimit + ", salesPerson="
				+ salesPerson + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", createdOn=" + createdOn
				+ ", updatedOn=" + updatedOn + ", locationadd=" + locationadd + ", addressId=" + addressId
				+ ", branchName=" + branchName + ", ledgerName=" + ledgerName + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", gstNo=" + gstNo + ", state=" + state + ", pincode=" + pincode
				+ ", contactPerson=" + contactPerson + ", CPId=" + CPId + ", contactNoCP=" + contactNoCP
				+ ", altContactNoCP=" + altContactNoCP + ", emailIdCP=" + emailIdCP + ", state_text=" + state_text
				+ ", salesPerson_text=" + salesPerson_text + ", designationOfSalesP=" + designationOfSalesP
				+ ", reportToOfSalesP=" + reportToOfSalesP + ", source_text=" + source_text + ", customerType_txt="
				+ customerType_txt + ", industry_txt=" + industry_txt + "]";
	}
	
	
}
