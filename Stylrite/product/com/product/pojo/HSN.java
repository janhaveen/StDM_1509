package com.product.pojo;

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
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="d_hsn")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="HSN")
@Proxy(lazy = false)
public class HSN implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;
	
	@Column(name="rowId", unique = true)
	private String rowId;
	
	@Column(name="Hsnid")
	private String Hsnid; 

	@Column(name="Sgst")
	private String  Sgst;
	
	@Column(name="Cgst")
	private String  Cgst; 

	@Column(name="Igst")
	private String  Igst;
	
	@Column(name="Ugst")
	private String  Ugst;
	
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

	public String getHsnid() {
		return Hsnid;
	}

	public void setHsnid(String hsnid) {
		Hsnid = hsnid;
	}

	public String getSgst() {
		return Sgst;
	}

	public void setSgst(String sgst) {
		Sgst = sgst;
	}

	public String getCgst() {
		return Cgst;
	}

	public void setCgst(String cgst) {
		Cgst = cgst;
	}

	public String getIgst() {
		return Igst;
	}

	public void setIgst(String igst) {
		Igst = igst;
	}

	public String getUgst() {
		return Ugst;
	}

	public void setUgst(String ugst) {
		Ugst = ugst;
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
}