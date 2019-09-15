package com.returnData.pojo;

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
@Table(name="d_return_item")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="ReturnItem")
@Proxy(lazy = false)
public class ReturnItem implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;
	
	@Column(name="rowId", unique = true)
	private String rowId; 
	
	@Column(name="returnId")
    private String returnId;
    
	@Column(name="productId")
    private String productId;
	
	@Column(name="sku")
    private String sku;
	
	@Column(name="quantity")
    private int quantity;
	
	@Column(name="isDamaged")
    private int isDamaged;
	
	@Column(name="status")
    private String status;
	
	@Column(name="barcode")
	private String barcode;
	
	@Column(name="refNo")
	private String refNo;
	
	@Column(name="vendorStatus")
	private String vendorStatus;
	
	@Column(name="customerStatus")
	private String customerStatus;
	
	@Column(name="CNId")
	private String CNId;
	
	@Column(name="CNDate")
	private String CNDate;
	
	@Column(name="CNAmt")
	private Float CNAmt;
	
	@Column(name="CNAccountant")
	private String CNAccountant;
	
	@Column(name="dispatchDate")
	private String dispatchDate;
	
	@Column(name="LRNumber")
	private String LRNumber;
	
	@Column(name="CourierName")
	private String CourierName;
	
	@Column(name="dispathedBy")
	private String dispathedBy;
	
	@Column(name="closureDate")
    private Timestamp closureDate;
    
	@Column(name="createdBy")
	private String createdBy;

	@Column(name="createdOn")
	private Timestamp createdOn;
	
	@Column(name="updatedBy")
	private String updatedBy;

	@Column(name="updatedOn")
	private Timestamp updatedOn;

	public ReturnItem() 
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

	public String getReturnId() {
		return returnId;
	}

	public void setReturnId(String returnId) {
		this.returnId = returnId;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getIsDamaged() {
		return isDamaged;
	}

	public void setIsDamaged(int isDamaged) {
		this.isDamaged = isDamaged;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getVendorStatus() {
		return vendorStatus;
	}

	public void setVendorStatus(String vendorStatus) {
		this.vendorStatus = vendorStatus;
	}

	public String getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}

	public String getCNId() {
		return CNId;
	}

	public void setCNId(String cNId) {
		CNId = cNId;
	}

	public String getCNDate() {
		return CNDate;
	}

	public void setCNDate(String cNDate) {
		CNDate = cNDate;
	}

	public Float getCNAmt() {
		return CNAmt;
	}

	public void setCNAmt(Float cNAmt) {
		CNAmt = cNAmt;
	}

	public String getCNAccountant() {
		return CNAccountant;
	}

	public void setCNAccountant(String cNAccountant) {
		CNAccountant = cNAccountant;
	}

	public String getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(String dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public String getLRNumber() {
		return LRNumber;
	}

	public void setLRNumber(String lRNumber) {
		LRNumber = lRNumber;
	}

	public String getCourierName() {
		return CourierName;
	}

	public void setCourierName(String courierName) {
		CourierName = courierName;
	}

	public String getDispathedBy() {
		return dispathedBy;
	}

	public void setDispathedBy(String dispathedBy) {
		this.dispathedBy = dispathedBy;
	}

	public Timestamp getClosureDate() {
		return closureDate;
	}

	public void setClosureDate(Timestamp closureDate) {
		this.closureDate = closureDate;
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
		return "ReturnItem [rowNo=" + rowNo + ", rowId=" + rowId + ", returnId=" + returnId + ", productId=" + productId
				+ ", sku=" + sku + ", quantity=" + quantity + ", isDamaged=" + isDamaged + ", status=" + status
				+ ", barcode=" + barcode + ", refNo=" + refNo + ", vendorStatus=" + vendorStatus + ", customerStatus="
				+ customerStatus + ", CNId=" + CNId + ", CNDate=" + CNDate + ", CNAmt=" + CNAmt + ", CNAccountant="
				+ CNAccountant + ", dispatchDate=" + dispatchDate + ", LRNumber=" + LRNumber + ", CourierName="
				+ CourierName + ", dispathedBy=" + dispathedBy + ", closureDate=" + closureDate + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn
				+ "]";
	}
}
