package com.sample.pojo;

import java.io.Serializable;

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
@Table(name="samplelist")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="SampleList")
@Proxy(lazy = false)
public class SampleList implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;

	@Column(name="issuesTo_txt")
	private String  issuesTo_txt;
	@Column(name="productInfo")
	private String  productInfo;
	@Column(name="skuid")
	private String  skuid;
	@Column(name="brand_text")
	private String  brand_text;
	@Column(name="issueDate")
	private String  issueDate;
	@Column(name="modelNo")
	private String  modelNo;
	@Column(name="size")
	private String  size;
	@Column(name="color")
	private String color;
	@Column(name="location")
	private String  location;
	@Column(name="quantity")
	private String  quantity;
	@Column(name="brand")
	private String  brand;
	@Column(name="barcodes")
	private String  barcodes;
	@Column(name="productid")
	private String  productid;
	public long getRowNo() {
		return rowNo;
	}
	public void setRowNo(long rowNo) {
		this.rowNo = rowNo;
	}
	public String getIssuesTo_txt() {
		return issuesTo_txt;
	}
	public void setIssuesTo_txt(String issuesTo_txt) {
		this.issuesTo_txt = issuesTo_txt;
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
	public String getBrand_text() {
		return brand_text;
	}
	public void setBrand_text(String brand_text) {
		this.brand_text = brand_text;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getBarcodes() {
		return barcodes;
	}
	public void setBarcodes(String barcodes) {
		this.barcodes = barcodes;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	
}
