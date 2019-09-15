package com.product.pojo;

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
@Table(name = "productlistdatatable")
@DynamicUpdate
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ProductListDataTable")
@Proxy(lazy = false)
public class ProductListDataTable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rowNo")
	private long rowNo;

	@Column(name = "rowId")
	private String rowId;

	@Column(name = "modelNo")
	private String modelNo;

	@Column(name = "color")
	private String color;

	@Column(name = "size")
	private String size;

	@Column(name = "price")
	private String price;

	@Column(name = "sku")
	private String sku;

	@Column(name = "brand_text")
	private String brand_text;


	@Column(name = "Igst")
	private String Igst;

	@Column(name = "hsnId")
	private String hsnId;

	@Column(name = "productInfo")
	private String productInfo;

	@Column(name = "skuid")
	private String skuid;

	@Column(name = "type_txt")
	private String type_txt;
	
	@Column(name = "isdeleted")
	private String isdeleted;
	
	

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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getBrand_text() {
		return brand_text;
	}

	public void setBrand_text(String brand_text) {
		this.brand_text = brand_text;
	}


	public String getIgst() {
		return Igst;
	}

	public void setIgst(String igst) {
		Igst = igst;
	}

	public String getHsnId() {
		return hsnId;
	}

	public void setHsnId(String hsnId) {
		this.hsnId = hsnId;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public String getSkuid() {
		return skuid;
	}

	public void setSkuid(String skuid) {
		this.skuid = skuid;
	}

	public String getType_txt() {
		return type_txt;
	}

	public void setType_txt(String type_txt) {
		this.type_txt = type_txt;
	}

	
	public String getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Override
	public String toString() {
		return "ProductListDataTable [rowNo=" + rowNo + ", rowId=" + rowId + ", modelNo=" + modelNo + ", color=" + color
				+ ", size=" + size + ", price=" + price + ", sku=" + sku + ", brand_text=" + brand_text + ", Igst="
				+ Igst + ", hsnId=" + hsnId + ", productInfo=" + productInfo + ", skuid=" + skuid + ", type_txt="
				+ type_txt + ", isdeleted=" + isdeleted + "]";
	}

	
}
