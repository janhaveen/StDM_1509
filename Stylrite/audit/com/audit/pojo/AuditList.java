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
@Table(name="auditList")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "AuditList")
@Proxy(lazy = false)
public class AuditList implements Serializable 
{
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="rowNo")
		private long rowNo;
	
		@Column(name="rowId", unique = true)
    	private String rowId;
	
    	@Column(name="auditReason")
    	private String auditReason;
    	
    	@Column(name="auditReasonText")
    	private String auditReasonText;
    	
		@Column(name="remarks")
		private String remarks;
		
		@Column(name="itemsAudited")
		private String itemsAudited;
	
		@Column(name="itemsCorrected")
		private String itemsCorrected;
		
		@Column(name="itemsDuplicated")
		private String itemsDuplicated;

		@Column(name="startTime")
		private String startTime;
		
		@Column(name="endTime")
		private String endTime;
		
		@Column(name="createdBy")
		private String createdBy;

		@Column(name="createdOn")
    	private String createdOn;
		
		@Column(name="updatedBy")
		private String updatedBy;

		@Column(name="updatedOn")
		private String updatedOn;
		
		@Column(name="totalAuditItem")
		private String totalAuditItem;

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

		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
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

		public String getTotalAuditItem() {
			return totalAuditItem;
		}

		public void setTotalAuditItem(String totalAuditItem) {
			this.totalAuditItem = totalAuditItem;
		}

		@Override
		public String toString() {
			return "AuditList [rowNo=" + rowNo + ", rowId=" + rowId + ", auditReason=" + auditReason
					+ ", auditReasonText=" + auditReasonText + ", remarks=" + remarks + ", itemsAudited=" + itemsAudited
					+ ", itemsCorrected=" + itemsCorrected + ", itemsDuplicated=" + itemsDuplicated + ", startTime="
					+ startTime + ", endTime=" + endTime + ", createdBy=" + createdBy + ", createdOn=" + createdOn
					+ ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + ", totalAuditItem=" + totalAuditItem
					+ "]";
		}
}
