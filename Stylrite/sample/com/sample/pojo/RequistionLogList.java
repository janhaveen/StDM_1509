package com.sample.pojo;

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
@Table(name="requisitionloglist")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "RequistionLogList")
@Proxy(lazy = false)
public class RequistionLogList 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private int rowNo;
	
	@Column(unique = true,name="rowId")
	private String rowId;
	
	@Column(name="requisitionId")
	private String requisitionId;
	
	@Column(name="action")
	private String action;
	
	@Column(name="remarks")
	private String remarks;
	
	@Column(name="status")
	private String status;
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="createdOn")
	private String createdOn;
	
	@Column(name="createdBy_txt")
	private String createdBy_txt;

	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getRequisitionId() {
		return requisitionId;
	}

	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy_txt() {
		return createdBy_txt;
	}

	public void setCreatedBy_txt(String createdBy_txt) {
		this.createdBy_txt = createdBy_txt;
	}

	@Override
	public String toString() {
		return "RequistionLogList [rowNo=" + rowNo + ", rowId=" + rowId + ", requisitionId=" + requisitionId
				+ ", action=" + action + ", remarks=" + remarks + ", status=" + status + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", createdBy_txt=" + createdBy_txt + "]";
	}
	
	
	
	
	
	
}
