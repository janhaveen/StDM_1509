package com.product.pojo;

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
@Table(name="productlist")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="ProductListView")
@Proxy(lazy = false)
public class ProductListView implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;
	
	@Column(name="rowId")
	private String rowId;
	
	@Column(name="NPD")
	private String NPD; 

	@Column(name="brand")
	private String  brand;
	
	@Column(name="modelNo")
	private String  modelNo; 

	@Column(name="color")
	private String  color;
	
	@Column(name="size")
	private String  size;
	
	@Column(name="type")
	private String type;
	
	@Column(name="cost")
	private float  cost;
	
	@Column(name="MRP")
	private float MRP;
	
	@Column(name="hsnId")
	private String hsnId; 
	
	@Column(name="tag")
	private String  tag; 
	
	@Column(name="description")
	private String  description;
	
	@Column(name="hsn_text")
	private String  hsn_text;
	
	@Column(name="type_txt")
	private String  type_txt;
	
	@Column(name="brand_txt")
	private String  brand_txt;
	
	@Column(name="productInfo")
	private String  productInfo;
	
	@Column(name="sku")
	private String  sku;
	
	@Column(name="skuid")
	private String  skuid;
	
	@Column(name="isdeleted")
	private String isdeleted;
	
	@Column(name="createdBy")
	private String createdBy;

	@Column(name="createdOn")
	private Timestamp createdOn;
	
	@Column(name="updatedBy")
	private String updatedBy;

	@Column(name="updatedOn")
	private Timestamp updatedOn;

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

	public String getNPD() {
		return NPD;
	}

	public void setNPD(String nPD) {
		NPD = nPD;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
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

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public float getMRP() {
		return MRP;
	}

	public void setMRP(float mRP) {
		MRP = mRP;
	}

	public String getHsnId() {
		return hsnId;
	}

	public void setHsnId(String hsnId) {
		this.hsnId = hsnId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHsn_text() {
		return hsn_text;
	}

	public void setHsn_text(String hsn_text) {
		this.hsn_text = hsn_text;
	}

	public String getType_txt() {
		return type_txt;
	}

	public void setType_txt(String type_txt) {
		this.type_txt = type_txt;
	}

	public String getBrand_txt() {
		return brand_txt;
	}

	public void setBrand_txt(String brand_txt) {
		this.brand_txt = brand_txt;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getSkuid() {
		return skuid;
	}

	public void setSkuid(String skuid) {
		this.skuid = skuid;
	}

	public String getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
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
		return "ProductListView [rowNo=" + rowNo + ", rowId=" + rowId + ", NPD=" + NPD + ", brand=" + brand
				+ ", modelNo=" + modelNo + ", color=" + color + ", size=" + size + ", type=" + type + ", cost=" + cost
				+ ", MRP=" + MRP + ", hsnId=" + hsnId + ", tag=" + tag + ", description=" + description + ", hsn_text="
				+ hsn_text + ", type_txt=" + type_txt + ", brand_txt=" + brand_txt + ", productInfo=" + productInfo
				+ ", sku=" + sku + ", skuid=" + skuid + ", isdeleted=" + isdeleted + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + "]";
	}
}