package com.purchase.pojo;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name="grnlistview")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="GRNList")
@Proxy(lazy = false)
public class GRNList implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;
	
	@Column(name="rowId", unique = true)
	private String rowId; 
	
	@Column(name="GRNId")
	private String GRNId; 
	
	@Column(name="status")
	private String status;
	
	@Column(name="status_txt")
	private String status_txt;
	
	@Column(name="productId")
	private String productId;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="rate")
	private float rate;
	
	@Column(name="createdBy")
	private String createdBy;

	@Column(name="createdOn")
	private String createdOn;
	
	@Column(name="updatedBy")
	private String updatedBy;

	@Column(name="updatedOn")
	private String updatedOn;
	
	@Column(name="gRNnumber")
	private String gRNnumber; 
	
	@Column(name="podate")
	private String podate;
	
	@Column(name="receivedBy")
	private String receivedBy;
	
	@Column(name="receiptDate")
	private String receiptDate;
	
	@Column(name="otherCharges")
	private float  otherCharges;
	
	@Column(name="LRNumber")
	private String  LRNumber;
	
	@Column(name="courierName")
	private String  courierName;
	
	@Column(name="vendorId")
	private String vendorId; 
	
	@Column(name="vendorcpid")
	private String vendorcpid;
	
	@Column(name="vendoraddrid")
	private String vendoraddrid;
	
	@Column(name="vendorName")
	private String vendorName; 
	
	@Column(name="location")
	private String location;
	
	@Column(name="productInfo")
	private String productInfo;
	
	@Column(name="price")
	private String  price;
	
	@Column(name="branchName")
	private String branchName;
	
	@Column(name="locationadd")
	private String locationadd;
	
	@Column(name="state_text")
	private String state_text; 
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="contactPerson")
	private String contactPerson; 
	
	@Column(name="childbarcodeid")
	private String childbarcodeid;
	
	@Column(name="isBracodegenerated")
	private String isBracodegenerated;
	
	@Column(name="skuid")
	private String skuid;
	
	@Column(name="totalQty")
	private String totalQty;
	
	@Column(name="totalRate")
	private String totalRate;
	
	@Column(name="itemCount")
	private String itemCount;

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

	public String getGRNId() {
		return GRNId;
	}

	public void setGRNId(String gRNId) {
		GRNId = gRNId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus_txt() {
		return status_txt;
	}

	public void setStatus_txt(String status_txt) {
		this.status_txt = status_txt;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
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

	public String getgRNnumber() {
		return gRNnumber;
	}

	public void setgRNnumber(String gRNnumber) {
		this.gRNnumber = gRNnumber;
	}

	public String getPodate() {
		return podate;
	}

	public void setPodate(String podate) {
		this.podate = podate;
	}

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public String getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(String receiptDate) {
		this.receiptDate = receiptDate;
	}

	public float getOtherCharges() {
		return otherCharges;
	}

	public void setOtherCharges(float otherCharges) {
		this.otherCharges = otherCharges;
	}

	public String getLRNumber() {
		return LRNumber;
	}

	public void setLRNumber(String lRNumber) {
		LRNumber = lRNumber;
	}

	public String getCourierName() {
		return courierName;
	}

	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorcpid() {
		return vendorcpid;
	}

	public void setVendorcpid(String vendorcpid) {
		this.vendorcpid = vendorcpid;
	}

	public String getVendoraddrid() {
		return vendoraddrid;
	}

	public void setVendoraddrid(String vendoraddrid) {
		this.vendoraddrid = vendoraddrid;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getLocationadd() {
		return locationadd;
	}

	public void setLocationadd(String locationadd) {
		this.locationadd = locationadd;
	}

	public String getState_text() {
		return state_text;
	}

	public void setState_text(String state_text) {
		this.state_text = state_text;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getChildbarcodeid() {
		return childbarcodeid;
	}

	public void setChildbarcodeid(String childbarcodeid) {
		this.childbarcodeid = childbarcodeid;
	}

	public String getIsBracodegenerated() {
		return isBracodegenerated;
	}

	public void setIsBracodegenerated(String isBracodegenerated) {
		this.isBracodegenerated = isBracodegenerated;
	}

	public String getSkuid() {
		return skuid;
	}

	public void setSkuid(String skuid) {
		this.skuid = skuid;
	}

	public String getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(String totalQty) {
		this.totalQty = totalQty;
	}

	public String getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(String totalRate) {
		this.totalRate = totalRate;
	}

	public String getItemCount() {
		return itemCount;
	}

	public void setItemCount(String itemCount) {
		this.itemCount = itemCount;
	}

	@Override
	public String toString() {
		return "GRNList [rowNo=" + rowNo + ", rowId=" + rowId + ", GRNId=" + GRNId + ", status=" + status
				+ ", status_txt=" + status_txt + ", productId=" + productId + ", quantity=" + quantity + ", rate="
				+ rate + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy
				+ ", updatedOn=" + updatedOn + ", gRNnumber=" + gRNnumber + ", podate=" + podate + ", receivedBy="
				+ receivedBy + ", receiptDate=" + receiptDate + ", otherCharges=" + otherCharges + ", LRNumber="
				+ LRNumber + ", courierName=" + courierName + ", vendorId=" + vendorId + ", vendorcpid=" + vendorcpid
				+ ", vendoraddrid=" + vendoraddrid + ", vendorName=" + vendorName + ", location=" + location
				+ ", productInfo=" + productInfo + ", price=" + price + ", branchName=" + branchName + ", locationadd="
				+ locationadd + ", state_text=" + state_text + ", pincode=" + pincode + ", contactPerson="
				+ contactPerson + ", childbarcodeid=" + childbarcodeid + ", isBracodegenerated=" + isBracodegenerated
				+ ", skuid=" + skuid + ", totalQty=" + totalQty + ", totalRate=" + totalRate + ", itemCount="
				+ itemCount + "]";
	}
}
