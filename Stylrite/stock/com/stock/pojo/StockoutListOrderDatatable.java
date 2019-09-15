package com.stock.pojo;

import java.io.Serializable;

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
@Table(name="stockoutlistorderDatatable")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="StockoutListOrderDatatable")
@Proxy(lazy = false)
public class StockoutListOrderDatatable implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;
	@Column(name="id")
	private String id;
	@Column(name="orderIdDisplay")
	private String orderIdDisplay;
	@Column(name="clientName")
	private String clientName;
	@Column(name="createdOn")
	private String createdOn;
	@Column(name="spname")
	private String spname;
	@Column(name="createdby_txt")
	private String createdby_txt;
	@Column(name="total")
	private String total;
	public long getRowNo() {
		return rowNo;
	}
	public void setRowNo(long rowNo) {
		this.rowNo = rowNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderIdDisplay() {
		return orderIdDisplay;
	}
	public void setOrderIdDisplay(String orderIdDisplay) {
		this.orderIdDisplay = orderIdDisplay;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public String getSpname() {
		return spname;
	}
	public void setSpname(String spname) {
		this.spname = spname;
	}
	public String getCreatedby_txt() {
		return createdby_txt;
	}
	public void setCreatedby_txt(String createdby_txt) {
		this.createdby_txt = createdby_txt;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}

}
