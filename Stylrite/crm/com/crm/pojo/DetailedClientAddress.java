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
@Table(name = "detailedclientaddress")
@DynamicUpdate
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Client")
@Proxy(lazy = false)
public class DetailedClientAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rowNo")
	private int rowNo;

	@Column(name = "rowId")
	private String rowId;

	@Column(name = "clientId")
	private String clientId;

	@Column(name = "branchName")
	private String branchName;

	@Column(name = "contactNo")
	private long contactNo;

	@Column(name = "addressLine1")
	private String addressLine1;

	@Column(name = "addressLine2")
	private String addressLine2;

	@Column(name = "ledgerName")
	private String ledgerName;

	@Column(name = "location")
	private String location;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "gstNo")
	private String gstNo;

	@Column(name = "pincode")
	private String pincode;

	@Column(name = "isDefault")
	private String isDefault;

	@Column(name = "createdBy")
	private String createdBy;

	@Column(name = "updatedBy")
	private String updatedBy;

	@Column(name = "createdOn")
	private String createdOn;

	@Column(name = "updatedOn")
	private String updatedOn;

	@Column(name = "state_text")
	private String state_text;

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

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
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

	public String getLedgerName() {
		return ledgerName;
	}

	public void setLedgerName(String ledgerName) {
		this.ledgerName = ledgerName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
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

	public String getState_text() {
		return state_text;
	}

	public void setState_text(String state_text) {
		this.state_text = state_text;
	}

	@Override
	public String toString() {
		return "DetailedClientAddress [rowNo=" + rowNo + ", rowId=" + rowId + ", clientId=" + clientId + ", branchName="
				+ branchName + ", contactNo=" + contactNo + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", ledgerName=" + ledgerName + ", location=" + location + ", city=" + city + ", state="
				+ state + ", gstNo=" + gstNo + ", pincode=" + pincode + ", isDefault=" + isDefault + ", createdBy="
				+ createdBy + ", updatedBy=" + updatedBy + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn
				+ ", state_text=" + state_text + "]";
	}

}
