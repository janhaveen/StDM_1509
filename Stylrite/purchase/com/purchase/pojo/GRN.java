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
@Table(name="d_grn")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="GRN")
@Proxy(lazy = false)
public class GRN implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;
	
	@Column(name="rowId", unique = true)
	private String rowId; 
	
	@Column(name="gRNnumber")
	private String gRNnumber; 
	
	@Column(name="vendorId")
	private String vendorId; 
	
	@Column(name="vendorCpId")
	private String vendorCpId;
	
	@Column(name="vendorAddrId")
	private String vendorAddrId;
	
	@Column(name="POId")
	private String POId;
	
	@Column(name="podate")
	private Date podate;
	
	@Column(name="status")
	private String status;
	
	@Column(name="printStatus")
	private long printStatus; 
	
	@Column(name="receivedBy")
	private String receivedBy;
	
	@Column(name="receiptDate")
	private Date  receiptDate;
	
	@Column(name="isEditable")
	private String isEditable;
	
	@Column(name="otherCharges")
	private float  otherCharges;
	
	@Column(name="courierName")
	private String  courierName;
	
	@Column(name="LRNumber")
	private String  LRNumber;
	
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

	public String getgRNnumber() {
		return gRNnumber;
	}

	public void setgRNnumber(String gRNnumber) {
		this.gRNnumber = gRNnumber;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorCpId() {
		return vendorCpId;
	}

	public void setVendorCpId(String vendorCpId) {
		this.vendorCpId = vendorCpId;
	}

	public String getVendorAddrId() {
		return vendorAddrId;
	}

	public void setVendorAddrId(String vendorAddrId) {
		this.vendorAddrId = vendorAddrId;
	}

	public String getPOId() {
		return POId;
	}

	public void setPOId(String pOId) {
		POId = pOId;
	}

	public Date getPodate() {
		return podate;
	}

	public void setPodate(Date podate) {
		this.podate = podate;
	}

	public String getStatus() {
		return status;
	}

	public long getPrintStatus() {
		return printStatus;
	}

	public void setPrintStatus(long printStatus) {
		this.printStatus = printStatus;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public Date getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}

	public String getIsEditable() {
		return isEditable;
	}

	public void setIsEditable(String isEditable) {
		this.isEditable = isEditable;
	}

	public float getOtherCharges() {
		return otherCharges;
	}

	public void setOtherCharges(float otherCharges) {
		this.otherCharges = otherCharges;
	}

	public String getCourierName() {
		return courierName;
	}

	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}

	public String getLRNumber() {
		return LRNumber;
	}

	public void setLRNumber(String lRNumber) {
		LRNumber = lRNumber;
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
		return "GRN [rowNo=" + rowNo + ", rowId=" + rowId + ", gRNnumber=" + gRNnumber + ", vendorId=" + vendorId
				+ ", vendorCpId=" + vendorCpId + ", vendorAddrId=" + vendorAddrId + ", POId=" + POId + ", podate="
				+ podate + ", status=" + status + ", printStatus=" + printStatus + ", receivedBy=" + receivedBy
				+ ", receiptDate=" + receiptDate + ", isEditable=" + isEditable + ", otherCharges=" + otherCharges
				+ ", courierName=" + courierName + ", LRNumber=" + LRNumber + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + "]";
	}
}
