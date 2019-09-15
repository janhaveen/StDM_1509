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
@Table(name="childbarcodeloglist")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="ChildBarcodeLogListView")
@Proxy(lazy = false)
public class ChildBarcodeLogListView  implements Serializable
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
	
	@Column(name="reason")
	private String reason; 
	
	@Column(name="createdBy")
	private String createdBy;

	@Column(name="createdOn")
	private String createdOn;
	
	@Column(name="createdOntxt")
	private String createdOntxt;
	
	@Column(name="remarks")
	private String remarks;
	

	public ChildBarcodeLogListView() 
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


	public String getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}


	public String getCreatedOntxt() {
		return createdOntxt;
	}


	public void setCreatedOntxt(String createdOntxt) {
		this.createdOntxt = createdOntxt;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	@Override
	public String toString() {
		return "ChildBarcodeLogListView [rowNo=" + rowNo + ", rowId=" + rowId + ", productid=" + productid + ", sku="
				+ sku + ", barcode=" + barcode + ", stockId=" + stockId + ", stockActionType=" + stockActionType
				+ ", from=" + from + ", to=" + to + ", issuesTo=" + issuesTo + ", refNo=" + refNo + ", reason=" + reason
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", createdOntxt=" + createdOntxt
				+ ", remarks=" + remarks + "]";
	}
}
