package com.barcode.pojo;

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
@Table(name="boxbarcodelist")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="EmptyBoxBarcodeLocationList")
@Proxy(lazy = false)
public class EmptyBoxBarcodeLocationList implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;
	@Column(name="rowId")
	private String rowId;
	@Column(name="stockInDate")
	private String stockInDate;
	@Column(name="stockOutDate")
	private String stockOutDate;
	@Column(name="capacity")
	private String capacity;
	@Column(name="brand")
	private String brand;
	@Column(name="quantity")
	private String quantity;
	@Column(name="floor")
	private String floor;
	@Column(name="aisle")
	private String aisle;
	@Column(name="rack")
	private String rack;
	@Column(name="section")
	private String section;
	@Column(name="location")
	private String location;
	@Column(name="createdBy")
	private String createdBy;
	@Column(name="updatedBy")
	private String updatedBy;
	@Column(name="createdOn")
	private String createdOn;
	@Column(name="updatedOn")
	private String updatedOn;
	@Column(name="isPresent")
	private String isPresent;
	@Column(name="remQty")
	private String remQty;
	@Column(name="presentQty")
	private String presentQty;
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
	public String getStockInDate() {
		return stockInDate;
	}
	public void setStockInDate(String stockInDate) {
		this.stockInDate = stockInDate;
	}
	public String getStockOutDate() {
		return stockOutDate;
	}
	public void setStockOutDate(String stockOutDate) {
		this.stockOutDate = stockOutDate;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getAisle() {
		return aisle;
	}
	public void setAisle(String aisle) {
		this.aisle = aisle;
	}
	public String getRack() {
		return rack;
	}
	public void setRack(String rack) {
		this.rack = rack;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public String getIsPresent() {
		return isPresent;
	}
	public void setIsPresent(String isPresent) {
		this.isPresent = isPresent;
	}
	public String getRemQty() {
		return remQty;
	}
	public void setRemQty(String remQty) {
		this.remQty = remQty;
	}
	public String getPresentQty() {
		return presentQty;
	}
	public void setPresentQty(String presentQty) {
		this.presentQty = presentQty;
	}

}
