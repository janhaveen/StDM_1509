package com.stock.pojo;

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
@Table(name="stockoutlistorder")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="StockoutListOrder")
@Proxy(lazy = false)
public class StockoutListOrder implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;
	@Column(name="id")
	private String id;
	@Column(name="orderIdDisplay")
	private String orderIdDisplay;
	@Column(name="status")
	private String status;
	@Column(name="productId")
	private String productId;
	@Column(name="clientName")
	private String clientName;
	@Column(name="expectedDeilvery")
	private String expectedDeilvery;
	@Column(name="itemid")
	private String itemid;
	@Column(name="ogquantity")
	private int ogquantity;
	@Column(name="quantity")
	private double quantity;
	@Column(name="createdOn")
	private String createdOn;
	@Column(name="createdBy")
	private String createdBy;
	@Column(name="cpname")
	private String cpname;
	@Column(name="spname")
	private String spname;
	@Column(name="createdby_txt")
	private String createdby_txt;
	@Column(name="status_txt")
	private String status_txt;
	@Column(name="qtyOut")
	private int qtyOut;
	@Column(name="location")
	private String location;
	@Column(name="productInfo")
	private String productInfo;
	@Column(name="skuid")
	private String skuid;
	@Column(name="availableStockInventory")
	private int availableStockInventory;
	@Column(name="availableStockSample")
	private int availableStockSample;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getRowNo() {
		return rowNo;
	}
	public void setRowNo(long rowNo) {
		this.rowNo = rowNo;
	}
	public String getOrderIdDisplay() {
		return orderIdDisplay;
	}
	public void setOrderIdDisplay(String orderIdDisplay) {
		this.orderIdDisplay = orderIdDisplay;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getExpectedDeilvery() {
		return expectedDeilvery;
	}
	public void setExpectedDeilvery(String expectedDeilvery) {
		this.expectedDeilvery = expectedDeilvery;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public int getOgquantity() {
		return ogquantity;
	}
	public void setOgquantity(int ogquantity) {
		this.ogquantity = ogquantity;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCpname() {
		return cpname;
	}
	public void setCpname(String cpname) {
		this.cpname = cpname;
	}
	public String getSpname() {
		return spname;
	}
	public void setSpname(String spname) {
		this.spname = spname;
	}
	public String getCreatedby_txt() {
		return createdby_txt;
	}
	public void setCreatedby_txt(String createdby_txt) {
		this.createdby_txt = createdby_txt;
	}
	public String getStatus_txt() {
		return status_txt;
	}
	public void setStatus_txt(String status_txt) {
		this.status_txt = status_txt;
	}
	public int getQtyOut() {
		return qtyOut;
	}
	public void setQtyOut(int qtyOut) {
		this.qtyOut = qtyOut;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public int getAvailableStockInventory() {
		return availableStockInventory;
	}
	public void setAvailableStockInventory(int availableStockInventory) {
		this.availableStockInventory = availableStockInventory;
	}
	public int getAvailableStockSample() {
		return availableStockSample;
	}
	public void setAvailableStockSample(int availableStockSample) {
		this.availableStockSample = availableStockSample;
	}
	
}
