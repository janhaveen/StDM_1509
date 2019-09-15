package com.sample.pojo;

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
@Table(name = "d_requisition_items")
@DynamicUpdate
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "RequistionItem")
@Proxy(lazy = false)
public class RequistionItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rowNo")
	private int rowNo;

	@Column(unique = true, name = "rowId")
	private String rowId;

	@Column(name = "requisitionId")
	private String requisitionId;

	@Column(name = "productId")
	private String productId;

	@Column(name = "qty")
	private int qty;

	@Column(name = "status")
	private String status;

	@Column(name = "referenceId")
	private String referenceId;

	@Column(name = "createdBy")
	private String createdBy;

	@Column(name = "updatedBy")
	private String updatedBy;

	@Column(name = "createdOn")
	private Timestamp createdOn;

	@Column(name = "updatedOn")
	private Timestamp updatedOn;

	public int getRowNo() {
		return rowNo;
	}

	public String getRowId() {
		return rowId;
	}

	public String getRequisitionId() {
		return requisitionId;
	}

	public String getProductId() {
		return productId;
	}

	public int getQty() {
		return qty;
	}

	public String getStatus() {
		return status;
	}

	public String getReferenceId() {
		return referenceId;
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

	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
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
		return "RequistionItem [rowNo=" + rowNo + ", rowId=" + rowId + ", requisitionId=" + requisitionId
				+ ", productId=" + productId + ", qty=" + qty + ", status=" + status + ", referenceId=" + referenceId
				+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", createdOn=" + createdOn + ", updatedOn="
				+ updatedOn + "]";
	}
	
	

}
