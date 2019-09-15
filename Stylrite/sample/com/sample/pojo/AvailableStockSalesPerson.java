package com.sample.pojo;

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
@Table(name="availablestocksalesperson")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "AvailableStockSalesPerson")
@Proxy(lazy = false)
public class AvailableStockSalesPerson {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private int rowNo;
	
	@Column(name="empid")
	private String empid;

	@Column(name="spname")
	private String spname;
	
	@Column(name="mobileNo")
	private String mobileNo;
	
	@Column(name="rowId")
	private String rowId;
	
	@Column(name="brand_txt")
	private String brand_txt;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="location")
	private String location;
	
	@Column(name="productid")
	private String productid;
	
	@Column(name="sku")
	private String sku;
      
	@Column(name="productinfo")
	private String productinfo;
     
	@Column(name="modelNo")
	private String modelNo;

	@Column(name="skuid")
	private String skuid;

	@Column(name="color")
	private String color;

	@Column(name="size")
	private String size;

	@Column(name="cost")
	private String cost;
	
	@Column(name="type_txt")
	private String type_txt;
	
	@Column(name="availableStock")
	private String availableStock;

	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getSpname() {
		return spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getBrand_txt() {
		return brand_txt;
	}

	public void setBrand_txt(String brand_txt) {
		this.brand_txt = brand_txt;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getProductinfo() {
		return productinfo;
	}

	public void setProductinfo(String productinfo) {
		this.productinfo = productinfo;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getSkuid() {
		return skuid;
	}

	public void setSkuid(String skuid) {
		this.skuid = skuid;
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

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getType_txt() {
		return type_txt;
	}

	public void setType_txt(String type_txt) {
		this.type_txt = type_txt;
	}

	public String getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(String availableStock) {
		this.availableStock = availableStock;
	}
      
	
	
	
	@Override
	public String toString() {
		return "AvailableStockSalesPerson [rowNo=" + rowNo + ", empid=" + empid + ",  spname=" + spname
				+ ", mobileNo=" + mobileNo + ", rowId=" + rowId + ", brand_txt=" + brand_txt + ", brand=" + brand
				+ ", location=" + location + ", productid=" + productid + ", sku=" + sku + ", productinfo="
				+ productinfo + ", modelNo=" + modelNo + ", skuid=" + skuid + ", color=" + color + ", size=" + size
				+ ", cost=" + cost + ", type_txt=" + type_txt + ", availableStock=" + availableStock + "]";
	}

	

}
