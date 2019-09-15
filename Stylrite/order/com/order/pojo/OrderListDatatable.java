package com.order.pojo;

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
@Table(name="orderlistfordatatable")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "OrderListDatatable")
@Proxy(lazy = false)

public class OrderListDatatable {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private int rowNo;
	
	
	@Column(name="orderId")
	private String orderId;
	
	@Column(name="clientLocation")
	private String clientLocation;
	
	@Column(name="contactNo")
	private String contactNo;
	
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="cpname")
	private String cpname;

	@Column(name="count")
	private int count;
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="salesperson")
	private String salesperson;
	
	@Column(name="orderdate")
	private String orderdate;
	
	@Column(name="spname")
	private String spname	;
	
	@Column(name="isEditable")
	private String isEditable;

	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCpname() {
		return cpname;
	}

	public void setCpname(String cpname) {
		this.cpname = cpname;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getSalesperson() {
		return salesperson;
	}

	public void setSalesperson(String salesperson) {
		this.salesperson = salesperson;
	}

	public String getSpname() {
		return spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
	}

	public String getIsEditable() {
		return isEditable;
	}

	public void setIsEditable(String isEditable) {
		this.isEditable = isEditable;
	}

	
	
	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	
	
	public String getClientLocation() {
		return clientLocation;
	}

	public void setClientLocation(String clientLocation) {
		this.clientLocation = clientLocation;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "OrderListDatatable [rowNo=" + rowNo + ", orderId=" + orderId + ", clientLocation=" + clientLocation
				+ ", contactNo=" + contactNo + ", companyName=" + companyName + ", cpname=" + cpname + ", count="
				+ count + ", createdBy=" + createdBy + ", salesperson=" + salesperson + ", orderdate=" + orderdate
				+ ", spname=" + spname + ", isEditable=" + isEditable + "]";
	}

	

	
}
