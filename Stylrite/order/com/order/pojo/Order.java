package com.order.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="d_order")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Order")
@Proxy(lazy = false)

public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private int rowNo;
	
	@Column(unique = true,name="rowId")
	private String rowId;
	
	@Column(name="clientId")
	private String clientId;
	
	@Column(name="contactPersonId")
	private String contactPersonId;
	
	
	@Column(name="billingAddressId")
	private String billingAddressId;
	
	@Column(name="deliveryAddressId")
	private String deliveryAddressId;
	
	@Column(name="salesPerson")
	private String salesPerson;
	
	@Column(name="invoiceType")
	private String invoiceType;
	
	@Column(name="modeOfPayment")
	private String modeOfPayment;
	
	@Column(name="expectedDeilvery")
	private String expectedDeilvery;
	
	@Column(name="status")
	private String status;
	
	@Column(name="RefNo")
	private String RefNo;
	
	@Column(name="remarks")
	private String remarks;
	
	@Column(name="remarks2")
	private String remarks2;
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="updatedBy")
	private String updatedBy;
	
	@Column(name="createdOn")
	private Timestamp createdOn;
	
	@Column(name="updatedOn")
	private Timestamp updatedOn;

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

	public String getContactPersonId() {
		return contactPersonId;
	}

	public void setContactPersonId(String contactPersonId) {
		this.contactPersonId = contactPersonId;
	}

	public String getBillingAddressId() {
		return billingAddressId;
	}

	public void setBillingAddressId(String billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	public String getDeliveryAddressId() {
		return deliveryAddressId;
	}

	public void setDeliveryAddressId(String deliveryAddressId) {
		this.deliveryAddressId = deliveryAddressId;
	}

	public String getSalesPerson() {
		return salesPerson;
	}

	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public String getExpectedDeilvery() {
		return expectedDeilvery;
	}

	public void setExpectedDeilvery(String expectedDeilvery) {
		this.expectedDeilvery = expectedDeilvery;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRefNo() {
		return RefNo;
	}

	public void setRefNo(String refNo) {
		RefNo = refNo;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarks2() {
		return remarks2;
	}

	public void setRemarks2(String remarks2) {
		this.remarks2 = remarks2;
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

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "Order [rowNo=" + rowNo + ", rowId=" + rowId + ", clientId=" + clientId + ", contactPersonId="
				+ contactPersonId + ", billingAddressId=" + billingAddressId + ", deliveryAddressId="
				+ deliveryAddressId + ", salesPerson=" + salesPerson + ", invoiceType=" + invoiceType
				+ ", modeOfPayment=" + modeOfPayment + ", expectedDeilvery=" + expectedDeilvery + ", status=" + status
				+ ", RefNo=" + RefNo + ", remarks=" + remarks + ", remarks2=" + remarks2 + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}
	
	

}
