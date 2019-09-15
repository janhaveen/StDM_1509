package com.requisition.pojo;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name="invoicedetails")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="InvoiceDetails")
@Proxy(lazy = false)
public class InvoiceDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;
	@Column(name="rowid")
	private String rowid;
	@Column(name="invoicedate")
	private Date invoicedate;
	@Column(name="invoiceAmt")
	private float invoiceAmt;
	@Column(name="taxamt")
	private float taxamt;
	@Column(name="createdBy")
	private String createdBy;
	@Column(name="updatedBy")
	private String updatedBy;
	@Column(name="createdOn")
	private String createdOn;
	@Column(name="updatedOn")
	private String updatedOn;
	@Column(name="accountant")
	private String accountant;
	@Column(name="refRequisition")
	private String refRequisition;
	@Column(name="remarks")
	private String remarks;
	
	public long getRowNo() {
		return rowNo;
	}
	public void setRowNo(long rowNo) {
		this.rowNo = rowNo;
	}
	public String getRowid() {
		return rowid;
	}
	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	public Date getInvoicedate() {
		return invoicedate;
	}
	public void setInvoicedate(Date invoicedate) {
		this.invoicedate = invoicedate;
	}
	public float getInvoiceAmt() {
		return invoiceAmt;
	}
	public void setInvoiceAmt(float invoiceAmt) {
		this.invoiceAmt = invoiceAmt;
	}
	public float getTaxamt() {
		return taxamt;
	}
	public void setTaxamt(float taxamt) {
		this.taxamt = taxamt;
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
	public String getAccountant() {
		return accountant;
	}
	public void setAccountant(String accountant) {
		this.accountant = accountant;
	}
	public String getRefRequisition() {
		return refRequisition;
	}
	public void setRefRequisition(String refRequisition) {
		this.refRequisition = refRequisition;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
		
}
