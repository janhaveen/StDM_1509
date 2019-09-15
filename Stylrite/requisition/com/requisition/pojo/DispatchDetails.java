package com.requisition.pojo;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name="dispatchdetails")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="DispatchDetails")
@Proxy(lazy = false)
public class DispatchDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;
	@Column(name="rowid")
	private String rowid;
	@Column(name="dispatchid")
	private String dispatchid;
	@Column(name="dispatchDate")
	private Date dispatchDate;
	@Column(name="LrNo")
	private String LrNo;
	@Column(name="courierName")
	private String courierName;
	@Column(name="charges")
	private float charges;
	@Column(name="createdBy")
	private String createdBy;
	@Column(name="updatedBy")
	private String updatedBy;
	@Column(name="CreatedOn")
	private String CreatedOn;
	@Column(name="updatedOn")
	private String updatedOn;
	@Column(name="dispatchedby")
	private String dispatchedby;
	@Column(name="refRequisition")
	private String refRequisition;
	@Column(name="remarks")
	private String remarks;
	public String getDispatchid() {
		return dispatchid;
	}
	public void setDispatchid(String dispatchid) {
		this.dispatchid = dispatchid;
	}
	public Date getDispatchDate() {
		return dispatchDate;
	}
	public void setDispatchDate(Date dispatchDate) {
		this.dispatchDate = dispatchDate;
	}
	public String getLrNo() {
		return LrNo;
	}
	public void setLrNo(String lrNo) {
		LrNo = lrNo;
	}
	public String getCourierName() {
		return courierName;
	}
	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}
	public float getCharges() {
		return charges;
	}
	public void setCharges(float charges) {
		this.charges = charges;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getCreatedOn() {
		return CreatedOn;
	}
	public void setCreatedOn(String createdOn) {
		CreatedOn = createdOn;
	}
	public String getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getDispatchedby() {
		return dispatchedby;
	}
	public void setDispatchedby(String dispatchedby) {
		this.dispatchedby = dispatchedby;
	}
	public String getRefRequisition() {
		return refRequisition;
	}
	public void setRefRequisition(String refRequisition) {
		this.refRequisition = refRequisition;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


}
