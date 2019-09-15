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
@Table(name="d_audit_item")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "AuditItem")
@Proxy(lazy = false)
public class AuditItem implements Serializable 
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
		
		@Column(name="skuId")
		private String skuId;
		
		@Column(name="isEdited")
		private String isEdited;
	
		@Column(name="status")
		private String status;
		
		@Column(name="createdBy")
		private String createdBy;

		@Column(name="createdOn")
    	private Timestamp createdOn;
		
		@Column(name="updatedBy")
		private String updatedBy;

		@Column(name="updatedOn")
		private Timestamp updatedOn;
		
		@Column(name="isInCorrectedLocation")
		private String isInCorrectedLocation;
		
		@Column(name="location")
		private String location;

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

		public String getSkuId() {
			return skuId;
		}

		public void setSkuId(String skuId) {
			this.skuId = skuId;
		}

		public String getBarcode() {
			return barcode;
		}

		public void setBarcode(String barcode) {
			this.barcode = barcode;
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
		
		public String getIsInCorrectedLocation() {
			return isInCorrectedLocation;
		}

		public void setIsInCorrectedLocation(String isInCorrectedLocation) {
			this.isInCorrectedLocation = isInCorrectedLocation;
		}
		
		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		@Override
		public String toString() {
			return "AuditItem [rowNo=" + rowNo + ", rowId=" + rowId + ", auditId=" + auditId + ", barcode=" + barcode
					+ ", skuId=" + skuId + ", isEdited=" + isEdited + ", status=" + status + ", createdBy=" + createdBy
					+ ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn
					+ ", isInCorrectedLocation=" + isInCorrectedLocation + ", location=" + location + "]";
		}
}
