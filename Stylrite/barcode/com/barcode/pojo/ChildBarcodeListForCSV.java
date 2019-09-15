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
@Table(name="childbarcodelistforcsv")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="ChildBarcodeListForCSV")
@Proxy(lazy = false)
public class ChildBarcodeListForCSV  implements Serializable
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
	
	@Column(name="stockindate")
	private String stockindate;
	
	@Column(name="stockInDateText")
	private String stockInDateText;
	
	@Column(name="stockoutdate")
	private String stockoutdate;
	
	@Column(name="stockOutDateText")
	private String stockOutDateText;
	
	@Column(name="location")
	private String location; 
	
	@Column(name="section")
	private String section; 
	
	@Column(name="purchaseorderitemid")
	private String purchaseorderitemid;
	
	@Column(name="GRNId")
	private String GRNId;
	
	@Column(name="GRNNumber")
	private String GRNNumber;
	
	@Column(name="rate")
	private float rate; 
	
	@Column(name="status")
	private String status; 
	
	@Column(name="createdBy")
	private String createdBy;

	@Column(name="createdOn")
	private String createdOn;
	
	@Column(name="updatedBy")
	private String updatedBy;

	@Column(name="updatedOn")
	private String updatedOn;
	
	@Column(name="sku")
	private String sku;
	
	@Column(name="productInfo")
	private String productInfo;

	@Column(name="price")
	private String price;
	
	@Column(name="brand_text")
	private String brand_text;

	@Column(name="modelNo")
	private String modelNo;
	
	@Column(name="color")
	private String color;

	@Column(name="size")
	private String size;
	
	@Column(name="type")
	private String type;
	
	@Column(name="type_txt")
	private String type_txt;
	
	@Column(name="isAvailable")
	private String isAvailable;

	@Column(name="skuid")
	private String skuid;
	
	@Column(name="status_txt")
	private String status_txt;

	@Column(name="brand")
	private String brand;
	
	@Column(name="productQty")
	private String productQty;


	public ChildBarcodeListForCSV() 
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


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getStockindate() {
		return stockindate;
	}


	public void setStockindate(String stockindate) {
		this.stockindate = stockindate;
	}


	public String getStockInDateText() {
		return stockInDateText;
	}


	public void setStockInDateText(String stockInDateText) {
		this.stockInDateText = stockInDateText;
	}


	public String getStockoutdate() {
		return stockoutdate;
	}


	public void setStockoutdate(String stockoutdate) {
		this.stockoutdate = stockoutdate;
	}


	public String getStockOutDateText() {
		return stockOutDateText;
	}


	public void setStockOutDateText(String stockOutDateText) {
		this.stockOutDateText = stockOutDateText;
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


	public String getGRNId() {
		return GRNId;
	}


	public void setGRNId(String gRNId) {
		GRNId = gRNId;
	}


	public String getGRNNumber() {
		return GRNNumber;
	}


	public void setGRNNumber(String gRNNumber) {
		GRNNumber = gRNNumber;
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


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public String getUpdatedOn() {
		return updatedOn;
	}


	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}


	public String getSku() {
		return sku;
	}


	public void setSku(String sku) {
		this.sku = sku;
	}


	public String getProductInfo() {
		return productInfo;
	}


	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getBrand_text() {
		return brand_text;
	}


	public void setBrand_text(String brand_text) {
		this.brand_text = brand_text;
	}


	public String getModelNo() {
		return modelNo;
	}


	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getType_txt() {
		return type_txt;
	}


	public void setType_txt(String type_txt) {
		this.type_txt = type_txt;
	}


	public String getIsAvailable() {
		return isAvailable;
	}


	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}


	public String getSkuid() {
		return skuid;
	}


	public void setSkuid(String skuid) {
		this.skuid = skuid;
	}


	public String getStatus_txt() {
		return status_txt;
	}


	public void setStatus_txt(String status_txt) {
		this.status_txt = status_txt;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getProductQty() {
		return productQty;
	}


	public void setProductQty(String productQty) {
		this.productQty = productQty;
	}


	@Override
	public String toString() {
		return "ChildBarcodeListForCSV [rowNo=" + rowNo + ", rowId=" + rowId + ", productId=" + productId
				+ ", stockindate=" + stockindate + ", stockInDateText=" + stockInDateText + ", stockoutdate="
				+ stockoutdate + ", stockOutDateText=" + stockOutDateText + ", location=" + location + ", section="
				+ section + ", purchaseorderitemid=" + purchaseorderitemid + ", GRNId=" + GRNId + ", GRNNumber="
				+ GRNNumber + ", rate=" + rate + ", status=" + status + ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + ", sku=" + sku
				+ ", productInfo=" + productInfo + ", price=" + price + ", brand_text=" + brand_text + ", modelNo="
				+ modelNo + ", color=" + color + ", size=" + size + ", type=" + type + ", type_txt=" + type_txt
				+ ", isAvailable=" + isAvailable + ", skuid=" + skuid + ", status_txt=" + status_txt + ", brand="
				+ brand + ", productQty=" + productQty + "]";
	}
}
