package com.sample.pojo;

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
@Table(name="d_requisition")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Requistion")
@Proxy(lazy = false)
public class Requistion
{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private int rowNo;
	
	@Column(unique = true,name="rowId")
	private String rowId;
	
	@Column(name="reason")
	private String reason;
	
	@Column(name="expectedReceiptDate")
	private Date expectedReceiptDate;
	
	@Column(name="modeofDelivery")
	private String modeofDelivery;
	
	@Column(name="transportName")
	private String transportName;
	
	@Column(name="trackingID")
	private String trackingID;
	
	@Column(name="dispatchedDate")
	private Date dispatchedDate;
	
	@Column(name="eBillNo")
	private String eBillNo;
	
	@Column(name="receiptDate")
	private Date receiptDate;
	
	@Column(name="requisitionType")
	private String requisitionType;
	
	
	@Column(name="status")
	private String status;
	
	@Column(name="issuesTo")
	private String issuesTo;
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="updatedBy")
	private String updatedBy;
	
	@Column(name="createdOn")
	private Timestamp createdOn;
	
	@Column(name="updatedOn")
	private Timestamp updatedOn;

	public int getRowNo() {
		return rowNo;
	}

	public String getRowId() {
		return rowId;
	}

	public String getReason() {
		return reason;
	}

	public Date getExpectedReceiptDate() {
		return expectedReceiptDate;
	}

	public String getModeofDelivery() {
		return modeofDelivery;
	}

	public String getTransportName() {
		return transportName;
	}

	public String getTrackingID() {
		return trackingID;
	}

	public Date getDispatchedDate() {
		return dispatchedDate;
	}

	public String geteBillNo() {
		return eBillNo;
	}

	public Date getReceiptDate() {
		return receiptDate;
	}

	public String getRequisitionType() {
		return requisitionType;
	}

	public String getStatus() {
		return status;
	}

	public String getIssuesTo() {
		return issuesTo;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setExpectedReceiptDate(Date expectedReceiptDate) {
		this.expectedReceiptDate = expectedReceiptDate;
	}

	public void setModeofDelivery(String modeofDelivery) {
		this.modeofDelivery = modeofDelivery;
	}

	public void setTransportName(String transportName) {
		this.transportName = transportName;
	}

	public void setTrackingID(String trackingID) {
		this.trackingID = trackingID;
	}

	public void setDispatchedDate(Date dispatchedDate) {
		this.dispatchedDate = dispatchedDate;
	}

	public void seteBillNo(String eBillNo) {
		this.eBillNo = eBillNo;
	}

	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}

	public void setRequisitionType(String requisitionType) {
		this.requisitionType = requisitionType;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setIssuesTo(String issuesTo) {
		this.issuesTo = issuesTo;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "Requistion [rowNo=" + rowNo + ", rowId=" + rowId + ", reason=" + reason + ", expectedReceiptDate="
				+ expectedReceiptDate + ", modeofDelivery=" + modeofDelivery + ", transportName=" + transportName
				+ ", trackingID=" + trackingID + ", dispatchedDate=" + dispatchedDate + ", eBillNo=" + eBillNo
				+ ", receiptDate=" + receiptDate + ", requisitionType=" + requisitionType + ", status=" + status
				+ ", issuesTo=" + issuesTo + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", createdOn="
				+ createdOn + ", updatedOn=" + updatedOn + "]";
	}
	
	
}
