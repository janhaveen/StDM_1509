package com.barcode.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

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
@Table(name="f_childbarcode_log")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="ChildBarcodeLog")
@Proxy(lazy = false)
public class ChildBarcodeLog  implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;
	
	@Column(name="rowId", unique = true)
	private String rowId;

	@Column(name="productid")
	private String productid;
	
	@Column(name="auditItemId")
	private String auditItemId;
	
	@Column(name="sku")
	private String sku;
	
	@Column(name="barcode")
	private String barcode;
	
	@Column(name="stockId")
	private String stockId; 
	
	@Column(name="stockActionType")
	private String stockActionType;

	@Column(name="\"from\"")
	private String from;
	
	@Column(name="\"to\"")
	private String to;
	
	@Column(name="issuesTo")
	private String issuesTo;
	
	@Column(name="refNo")
	private String refNo; 
	
	@Column(name="status")
	private String status; 
	
	@Column(name="reason")
	private String reason; 
	
	@Column(name="createdBy")
	private String createdBy;

	@Column(name="createdOn")
	private Timestamp createdOn;
	

	public ChildBarcodeLog() 
	{
		
	}


	public long getRowNo() {
		return rowNo;
	}


	public void setRowNo(long rowNo) {
		this.rowNo = rowNo;
	}


	public String getRowId() {
		return rowId;
	}


	public void setRowId(String rowId) {
		this.rowId = rowId;
	}


	public String getProductid() {
		return productid;
	}


	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getAuditItemId() {
		return auditItemId;
	}


	public void setAuditItemId(String auditItemId) {
		this.auditItemId = auditItemId;
	}


	public String getSku() {
		return sku;
	}


	public void setSku(String sku) {
		this.sku = sku;
	}


	public String getBarcode() {
		return barcode;
	}


	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}


	public String getStockId() {
		return stockId;
	}


	public void setStockId(String stockId) {
		this.stockId = stockId;
	}


	public String getStockActionType() {
		return stockActionType;
	}


	public void setStockActionType(String stockActionType) {
		this.stockActionType = stockActionType;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public String getIssuesTo() {
		return issuesTo;
	}


	public void setIssuesTo(String issuesTo) {
		this.issuesTo = issuesTo;
	}


	public String getRefNo() {
		return refNo;
	}


	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public Timestamp getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}


	@Override
	public String toString() {
		return "ChildBarcodeLog [rowNo=" + rowNo + ", rowId=" + rowId + ", productid=" + productid + ", auditItemId="
				+ auditItemId + ", sku=" + sku + ", barcode=" + barcode + ", stockId=" + stockId + ", stockActionType="
				+ stockActionType + ", from=" + from + ", to=" + to + ", issuesTo=" + issuesTo + ", refNo=" + refNo
				+ ", status=" + status + ", reason=" + reason + ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ "]";
	}
}
