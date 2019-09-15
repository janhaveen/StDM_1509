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
public class RequisitionDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;
	@Column(name="requisitionId")
	private String requisitionId;
	@Column(name="qty")
	private String qty;
	@Column(name="EmpName")
	private String EmpName;
	@Column(name="formattedOrderCreatedOn")
	private String formattedOrderCreatedOn;
	@Column(name="RequisitionCreatedOn")
	private String RequisitionCreatedOn;
	@Column(name="formattedExpectedReceiptDate")
	private String formattedExpectedReceiptDate;
	@Column(name="formattedDispatchedDate")
	private String formattedDispatchedDate;
	@Column(name="formattedReceiptDate")
	private String formattedReceiptDate;
	@Column(name="rqtnItmstatus_text")
	private String rqtnItmstatus_text;
	@Column(name="productInfo")
	private String productInfo;
	@Column(name="skuid")
	private String skuid;
	@Column(name="rqtnStatus_text")
	private String rqtnStatus_text;
	@Column(name="orderId")
	private String orderId;
	@Column(name="locationAdd")
	private String locationAdd;
	@Column(name="state_txt")
	private String state_txt;
	@Column(name="rate")
	private float rate;
	@Column(name="discount")
	private float discount;
	@Column(name="igst")
	private float igst;
	@Column(name="companyName")
	private String companyName;
	@Column(name="cpname")
	private String cpname;
	@Column(name="bbranchName")
	private String bbranchName;
	@Column(name="blocationadd")
	private String blocationadd;
	@Column(name="bGst")
	private String bGst;
	@Column(name="orderCreatedOn")
	private String orderCreatedOn;
	@Column(name="bstate_text")
	private String bstate_text;
	@Column(name="bpincode")
	private String bpincode;
	@Column(name="dbranchName")
	private String dbranchName;
	@Column(name="dlocationadd")
	private String dlocationadd;
	@Column(name="dstate_text")
	private String dstate_text;
	@Column(name="dpincode")
	private String dpincode;
	@Column(name="spname")
	private String spname;
	@Column(name="invoicetype_txt")
	private String invoicetype_txt;
	@Column(name="modeofpay_txt")
	private String modeofpay_txt;
	@Column(name="expectedDeilvery")
	private String expectedDeilvery;
	@Column(name="contactNo")
	private String contactNo;
	@Column(name="stockoutQty")
	private String stockoutQty;
	@Column(name="ca11")
	private String ca11;
	@Column(name="ca12")
	private String ca12;
	@Column(name="ca21")
	private String ca21;
	@Column(name="ca22")
	private String ca22;
	@Column(name="invoiceid")
	private String invoiceid;
	@Column(name="dispatchid")
	private String dispatchid;
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
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getFormattedOrderCreatedOn() {
		return formattedOrderCreatedOn;
	}
	public void setFormattedOrderCreatedOn(String formattedOrderCreatedOn) {
		this.formattedOrderCreatedOn = formattedOrderCreatedOn;
	}
	public String getRequisitionCreatedOn() {
		return RequisitionCreatedOn;
	}
	public void setRequisitionCreatedOn(String requisitionCreatedOn) {
		RequisitionCreatedOn = requisitionCreatedOn;
	}
	public String getFormattedExpectedReceiptDate() {
		return formattedExpectedReceiptDate;
	}
	public void setFormattedExpectedReceiptDate(String formattedExpectedReceiptDate) {
		this.formattedExpectedReceiptDate = formattedExpectedReceiptDate;
	}
	public String getFormattedDispatchedDate() {
		return formattedDispatchedDate;
	}
	public void setFormattedDispatchedDate(String formattedDispatchedDate) {
		this.formattedDispatchedDate = formattedDispatchedDate;
	}
	public String getFormattedReceiptDate() {
		return formattedReceiptDate;
	}
	public void setFormattedReceiptDate(String formattedReceiptDate) {
		this.formattedReceiptDate = formattedReceiptDate;
	}
	public String getRqtnItmstatus_text() {
		return rqtnItmstatus_text;
	}
	public void setRqtnItmstatus_text(String rqtnItmstatus_text) {
		this.rqtnItmstatus_text = rqtnItmstatus_text;
	}
	public String getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	public String getSkuid() {
		return skuid;
	}
	public void setSkuid(String skuid) {
		this.skuid = skuid;
	}
	public String getRqtnStatus_text() {
		return rqtnStatus_text;
	}
	public void setRqtnStatus_text(String rqtnStatus_text) {
		this.rqtnStatus_text = rqtnStatus_text;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getLocationAdd() {
		return locationAdd;
	}
	public void setLocationAdd(String locationAdd) {
		this.locationAdd = locationAdd;
	}
	public String getState_txt() {
		return state_txt;
	}
	public void setState_txt(String state_txt) {
		this.state_txt = state_txt;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getIgst() {
		return igst;
	}
	public void setIgst(float igst) {
		this.igst = igst;
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
	public String getBbranchName() {
		return bbranchName;
	}
	public void setBbranchName(String bbranchName) {
		this.bbranchName = bbranchName;
	}
	public String getBlocationadd() {
		return blocationadd;
	}
	public void setBlocationadd(String blocationadd) {
		this.blocationadd = blocationadd;
	}
	public String getbGst() {
		return bGst;
	}
	public void setbGst(String bGst) {
		this.bGst = bGst;
	}
	public String getOrderCreatedOn() {
		return orderCreatedOn;
	}
	public void setOrderCreatedOn(String orderCreatedOn) {
		this.orderCreatedOn = orderCreatedOn;
	}
	public String getBstate_text() {
		return bstate_text;
	}
	public void setBstate_text(String bstate_text) {
		this.bstate_text = bstate_text;
	}
	public String getBpincode() {
		return bpincode;
	}
	public void setBpincode(String bpincode) {
		this.bpincode = bpincode;
	}
	public String getDbranchName() {
		return dbranchName;
	}
	public void setDbranchName(String dbranchName) {
		this.dbranchName = dbranchName;
	}
	public String getDlocationadd() {
		return dlocationadd;
	}
	public void setDlocationadd(String dlocationadd) {
		this.dlocationadd = dlocationadd;
	}
	public String getDstate_text() {
		return dstate_text;
	}
	public void setDstate_text(String dstate_text) {
		this.dstate_text = dstate_text;
	}
	public String getDpincode() {
		return dpincode;
	}
	public void setDpincode(String dpincode) {
		this.dpincode = dpincode;
	}
	public String getSpname() {
		return spname;
	}
	public void setSpname(String spname) {
		this.spname = spname;
	}
	public String getInvoicetype_txt() {
		return invoicetype_txt;
	}
	public void setInvoicetype_txt(String invoicetype_txt) {
		this.invoicetype_txt = invoicetype_txt;
	}
	public String getModeofpay_txt() {
		return modeofpay_txt;
	}
	public void setModeofpay_txt(String modeofpay_txt) {
		this.modeofpay_txt = modeofpay_txt;
	}
	public String getExpectedDeilvery() {
		return expectedDeilvery;
	}
	public void setExpectedDeilvery(String expectedDeilvery) {
		this.expectedDeilvery = expectedDeilvery;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getStockoutQty() {
		return stockoutQty;
	}
	public void setStockoutQty(String stockoutQty) {
		this.stockoutQty = stockoutQty;
	}
	public String getCa11() {
		return ca11;
	}
	public void setCa11(String ca11) {
		this.ca11 = ca11;
	}
	public String getCa12() {
		return ca12;
	}
	public void setCa12(String ca12) {
		this.ca12 = ca12;
	}
	public String getCa21() {
		return ca21;
	}
	public void setCa21(String ca21) {
		this.ca21 = ca21;
	}
	public String getCa22() {
		return ca22;
	}
	public void setCa22(String ca22) {
		this.ca22 = ca22;
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
}
