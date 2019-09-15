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
@Table(name="d_child_barcode")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="ChildBarcode")
@Proxy(lazy = false)
public class ChildBarcode  implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;
	
	@Column(name="rowId", unique = true)
	private String rowId;

	@Column(name="productId")
	private String productId;
	
	@Column(name="sku")
	private String sku;
	
	@Column(name="location")
	private String location; 
	
	@Column(name="section")
	private String section; 
	
	@Column(name="purchaseorderitemid")
	private String purchaseorderitemid;
	
	@Column(name="GRNNumber")
	private String GRNNumber;
	
	@Column(name="stockInDate")
	private Timestamp stockInDate;
	
	@Column(name="stockoutdate")
	private Timestamp stockoutdate;
	
	@Column(name="rate")
	private float rate; 
	
	@Column(name="status")
	private String status; 
	
	@Column(name="printStatus")
	private long printStatus; 
	
	@Column(name="createdBy")
	private String createdBy;

	@Column(name="createdOn")
	private Timestamp createdOn;
	
	@Column(name="updatedBy")
	private String updatedBy;

	@Column(name="updatedOn")
	private Timestamp updatedOn;

	public ChildBarcode() 
	{
		
	}
	
	public ChildBarcode(String rowId, String GRNNumber, String sku, float rate, String status, long printStatus) 
	{
		this.rowId = rowId;
		this.GRNNumber = GRNNumber;
		this.sku = sku;
		this.rate = rate;
		this.status = status;
		this.printStatus = printStatus;
	}
	
	public ChildBarcode(String rowId, String GRNNumber, float rate, String status, long printStatus) 
	{
		this.rowId = rowId;
		this.GRNNumber = GRNNumber;
		this.rate = rate;
		this.status = status;
		this.printStatus = printStatus;
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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getPurchaseorderitemid() {
		return purchaseorderitemid;
	}

	public void setPurchaseorderitemid(String purchaseorderitemid) {
		this.purchaseorderitemid = purchaseorderitemid;
	}

	public String getGRNNumber() {
		return GRNNumber;
	}

	public void setGRNNumber(String gRNNumber) {
		GRNNumber = gRNNumber;
	}

	public Timestamp getStockInDate() {
		return stockInDate;
	}

	public void setStockInDate(Timestamp stockInDate) {
		this.stockInDate = stockInDate;
	}

	public Timestamp getStockoutdate() {
		return stockoutdate;
	}

	public void setStockoutdate(Timestamp stockoutdate) {
		this.stockoutdate = stockoutdate;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getPrintStatus() {
		return printStatus;
	}

	public void setPrintStatus(long printStatus) {
		this.printStatus = printStatus;
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

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "ChildBarcode [rowNo=" + rowNo + ", rowId=" + rowId + ", productId=" + productId + ", sku=" + sku
				+ ", location=" + location + ", section=" + section + ", purchaseorderitemid=" + purchaseorderitemid
				+ ", GRNNumber=" + GRNNumber + ", stockInDate=" + stockInDate + ", stockoutdate=" + stockoutdate
				+ ", rate=" + rate + ", status=" + status + ", printStatus=" + printStatus + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + "]";
	}
}
