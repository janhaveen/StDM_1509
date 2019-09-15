package com.audit.pojo;

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
@Table(name="auditItemDetailsView")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "AuditItemDetailsView")
@Proxy(lazy = false)
public class AuditItemDetailsView implements Serializable 
{
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="rowNo")
		private long rowNo;
	
	    @Column(name="rowId", unique = true)
    	private String rowId;
	
    	@Column(name="auditId")
    	private String auditId;
		
		@Column(name="barcode")
		private String barcode;
		
		@Column(name="sku")
		private String sku;
		
		@Column(name="isEdited")
		private String isEdited;
		
		@Column(name="status")
		private String status;
		
		@Column(name="skuId")
		private String skuId;
		
		@Column(name="createdBy")
		private String createdBy;

		@Column(name="createdOn")
    	private String createdOn;
		
		@Column(name="updatedBy")
		private String updatedBy;

		@Column(name="updatedOn")
		private String updatedOn;
		
		@Column(name="auditReason")
    	private String auditReason;
    	
    	@Column(name="auditReasonText")
    	private String auditReasonText;
    	
		@Column(name="itemsAudited")
		private String itemsAudited;
	
		@Column(name="itemsCorrected")
		private String itemsCorrected;
		
		@Column(name="itemsDuplicated")
		private String itemsDuplicated;
		
		@Column(name="remarks")
		private String remarks;

		@Column(name="startTime")
		private String startTime;
		
		@Column(name="endTime")
		private String endTime;
		
		@Column(name="location")
		private String location; 
		@Column(name="stockindate")
		private String stockindate;
		
		@Column(name="stockoutdate")
		private String stockoutdate;
		
		@Column(name="GRNNumber")
		private String GRNNumber;
		
		@Column(name="rate")
		private String rate;
		
		@Column(name="stockActionTypeText")
		private String stockActionTypeText;
		
		@Column(name="fromText")
		private String fromText;
		
		@Column(name="toText")
		private String toText;

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

		public String getAuditId() {
			return auditId;
		}

		public void setAuditId(String auditId) {
			this.auditId = auditId;
		}

		public String getBarcode() {
			return barcode;
		}

		public void setBarcode(String barcode) {
			this.barcode = barcode;
		}

		public String getSku() {
			return sku;
		}

		public void setSku(String sku) {
			this.sku = sku;
		}

		public String getIsEdited() {
			return isEdited;
		}

		public void setIsEdited(String isEdited) {
			this.isEdited = isEdited;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getSkuId() {
			return skuId;
		}

		public void setSkuId(String skuId) {
			this.skuId = skuId;
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

		public String getAuditReason() {
			return auditReason;
		}

		public void setAuditReason(String auditReason) {
			this.auditReason = auditReason;
		}

		public String getAuditReasonText() {
			return auditReasonText;
		}

		public void setAuditReasonText(String auditReasonText) {
			this.auditReasonText = auditReasonText;
		}

		public String getItemsAudited() {
			return itemsAudited;
		}

		public void setItemsAudited(String itemsAudited) {
			this.itemsAudited = itemsAudited;
		}

		public String getItemsCorrected() {
			return itemsCorrected;
		}

		public void setItemsCorrected(String itemsCorrected) {
			this.itemsCorrected = itemsCorrected;
		}

		public String getItemsDuplicated() {
			return itemsDuplicated;
		}

		public void setItemsDuplicated(String itemsDuplicated) {
			this.itemsDuplicated = itemsDuplicated;
		}

		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		public String getStartTime() {
			return startTime;
		}

		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}

		public String getEndTime() {
			return endTime;
		}

		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getStockindate() {
			return stockindate;
		}

		public void setStockindate(String stockindate) {
			this.stockindate = stockindate;
		}

		public String getStockoutdate() {
			return stockoutdate;
		}

		public void setStockoutdate(String stockoutdate) {
			this.stockoutdate = stockoutdate;
		}

		public String getGRNNumber() {
			return GRNNumber;
		}

		public void setGRNNumber(String gRNNumber) {
			GRNNumber = gRNNumber;
		}

		public String getRate() {
			return rate;
		}

		public void setRate(String rate) {
			this.rate = rate;
		}

		public String getStockActionTypeText() {
			return stockActionTypeText;
		}

		public void setStockActionTypeText(String stockActionTypeText) {
			this.stockActionTypeText = stockActionTypeText;
		}

		public String getFromText() {
			return fromText;
		}

		public void setFromText(String fromText) {
			this.fromText = fromText;
		}

		public String getToText() {
			return toText;
		}

		public void setToText(String toText) {
			this.toText = toText;
		}

		@Override
		public String toString() {
			return "AuditItemDetailsView [rowNo=" + rowNo + ", rowId=" + rowId + ", auditId=" + auditId + ", barcode="
					+ barcode + ", sku=" + sku + ", isEdited=" + isEdited + ", status=" + status + ", skuId=" + skuId
					+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy
					+ ", updatedOn=" + updatedOn + ", auditReason=" + auditReason + ", auditReasonText="
					+ auditReasonText + ", itemsAudited=" + itemsAudited + ", itemsCorrected=" + itemsCorrected
					+ ", itemsDuplicated=" + itemsDuplicated + ", remarks=" + remarks + ", startTime=" + startTime
					+ ", endTime=" + endTime + ", location=" + location + ", stockindate=" + stockindate
					+ ", stockoutdate=" + stockoutdate + ", GRNNumber=" + GRNNumber + ", rate=" + rate
					+ ", stockActionTypeText=" + stockActionTypeText + ", fromText=" + fromText + ", toText=" + toText
					+ "]";
		}
}
