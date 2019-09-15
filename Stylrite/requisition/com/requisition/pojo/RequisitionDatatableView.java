package com.requisition.pojo;

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
@Table(name="requisitiondatatableview")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="RequisitionDatatableView")
@Proxy(lazy = false)
public class RequisitionDatatableView implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;
	@Column(name="requisitionId")
	private String requisitionId;
	@Column(name="requisitionType")
	private String requisitionType;
	@Column(name="RequisitionCreatedOn")
	private String RequisitionCreatedOn;
	@Column(name="orderid")
	private String orderid;
	@Column(name="orderCreatedOn")
	private String orderCreatedOn;
	@Column(name="companyName")
	private String companyName;
	@Column(name="spname")
	private String spname;
	@Column(name="invoiceid")
	private String invoiceid;
	@Column(name="dispatchid")
	private String dispatchid;
	@Column(name="invoicedate")
	private String invoicedate;
	@Column(name="createdOn")
	private String createdOn;
	@Column(name="stockoutQty")
	private String stockoutQty;
	@Column(name="count")
	private String count;
	public long getRowNo() {
		return rowNo;
	}
	public void setRowNo(long rowNo) {
		this.rowNo = rowNo;
	}
	public String getRequisitionId() {
		return requisitionId;
	}
	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}
	public String getRequisitionType() {
		return requisitionType;
	}
	public void setRequisitionType(String requisitionType) {
		this.requisitionType = requisitionType;
	}
	public String getRequisitionCreatedOn() {
		return RequisitionCreatedOn;
	}
	public void setRequisitionCreatedOn(String requisitionCreatedOn) {
		RequisitionCreatedOn = requisitionCreatedOn;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getOrderCreatedOn() {
		return orderCreatedOn;
	}
	public void setOrderCreatedOn(String orderCreatedOn) {
		this.orderCreatedOn = orderCreatedOn;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSpname() {
		return spname;
	}
	public void setSpname(String spname) {
		this.spname = spname;
	}
	public String getInvoiceid() {
		return invoiceid;
	}
	public void setInvoiceid(String invoiceid) {
		this.invoiceid = invoiceid;
	}
	public String getDispatchid() {
		return dispatchid;
	}
	public void setDispatchid(String dispatchid) {
		this.dispatchid = dispatchid;
	}
	public String getInvoicedate() {
		return invoicedate;
	}
	public void setInvoicedate(String invoicedate) {
		this.invoicedate = invoicedate;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public String getStockoutQty() {
		return stockoutQty;
	}
	public void setStockoutQty(String stockoutQty) {
		this.stockoutQty = stockoutQty;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
}
