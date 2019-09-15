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
@Table(name="detailedorderitem")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "DetailedOrderItem")
@Proxy(lazy = false)

public class DetailedOrderItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private int rowNo;
	
	@Column(name="rowId")
	private String rowId;
	
	@Column(name="orderId")
	private String orderId;
	
	@Column(name="clientid")
	private String clientid;
	
	@Column(name="contactpersonid")
	private String contactpersonid;
	
	@Column(name="salesperson")
	private String salesperson;
	
	@Column(name="billingaddressid")
	private String billingaddressid;
	
	@Column(name="deliveryaddressid")
	private String deliveryaddressid;
	
	@Column(name="productId")
	private String productId;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="rate")
	private String rate;
	
	@Column(name="brand_text")
	private String brand_text;
	
	@Column(name="discount")
	private String discount;
	
	@Column(name="hsnId")
	private String hsnId;
	
	@Column(name="igst")
	private String igst;
	
	@Column(name="availableStock")
	private String availableStock;
	
	@Column(name="availableStockSample")
	private String availableStockSample;
	
	@Column(name="availableStockInventory")
	private String availableStockInventory;

	@Column(name="orderItemstatus")
	private String orderItemstatus;
	
	@Column(name="orderStatus")
	private String orderStatus;
	
	@Column(name="productInfo")
	private String productInfo;
	
	@Column(name="companyName")
	private String companyName;

	@Column(name="cpname")
	private String cpname;

	@Column(name="orderdate")
	private String orderdate;

	@Column(name="status_txt")
	private String status_txt;

	@Column(name="skuid")
	private String skuid;
	
	@Column(name="bbranchName")
	private String bbranchName;
	
	@Column(name="blocationadd")
	private String blocationadd;
	
	@Column(name="bGst")
	private String bGst;
	
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
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="refno")
	private String refno;
	
	@Column(name="quantity_out")
	private String quantity_out;
	
	
	@Column(name="orderstatus_txt")
	private String orderstatus_txt;
	
	
	@Column(name="createdOn")
	private String createdOn;
	
	
	@Column(name="location")
	private String location;
	
	@Column(name="isEditable")
	private String isEditable;
	
	@Column(name="remarks")
	private String remarks;
	
	@Column(name="ca11")
	private String ca11;
	
	@Column(name="ca12")
	private String ca12;
	
	@Column(name="ca21")
	private String ca21;
	
	@Column(name="ca22")
	private String ca22;
	
	
	@Column(name="clientLocation")
	private String clientLocation;
	
	

	public String getClientLocation() {
		return clientLocation;
	}

	public void setClientLocation(String clientLocation) {
		this.clientLocation = clientLocation;
	}

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

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	public String getContactpersonid() {
		return contactpersonid;
	}

	public void setContactpersonid(String contactpersonid) {
		this.contactpersonid = contactpersonid;
	}

	public String getSalesperson() {
		return salesperson;
	}

	public void setSalesperson(String salesperson) {
		this.salesperson = salesperson;
	}

	public String getBillingaddressid() {
		return billingaddressid;
	}

	public void setBillingaddressid(String billingaddressid) {
		this.billingaddressid = billingaddressid;
	}

	public String getDeliveryaddressid() {
		return deliveryaddressid;
	}

	public void setDeliveryaddressid(String deliveryaddressid) {
		this.deliveryaddressid = deliveryaddressid;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getBrand_text() {
		return brand_text;
	}

	public void setBrand_text(String brand_text) {
		this.brand_text = brand_text;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getHsnId() {
		return hsnId;
	}

	public void setHsnId(String hsnId) {
		this.hsnId = hsnId;
	}

	public String getIgst() {
		return igst;
	}

	public void setIgst(String igst) {
		this.igst = igst;
	}

	public String getOrderItemstatus() {
		return orderItemstatus;
	}

	public void setOrderItemstatus(String orderItemstatus) {
		this.orderItemstatus = orderItemstatus;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
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

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getStatus_txt() {
		return status_txt;
	}

	public void setStatus_txt(String status_txt) {
		this.status_txt = status_txt;
	}

	public String getSkuid() {
		return skuid;
	}

	public void setSkuid(String skuid) {
		this.skuid = skuid;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getRefno() {
		return refno;
	}

	public void setRefno(String refno) {
		this.refno = refno;
	}

	public String getQuantity_out() {
		return quantity_out;
	}

	public void setQuantity_out(String quantity_out) {
		this.quantity_out = quantity_out;
	}

	public String getOrderstatus_txt() {
		return orderstatus_txt;
	}

	public void setOrderstatus_txt(String orderstatus_txt) {
		this.orderstatus_txt = orderstatus_txt;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIsEditable() {
		return isEditable;
	}

	public void setIsEditable(String isEditable) {
		this.isEditable = isEditable;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	
	
	public String getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(String availableStock) {
		this.availableStock = availableStock;
	}

	public String getAvailableStockSample() {
		return availableStockSample;
	}

	public void setAvailableStockSample(String availableStockSample) {
		this.availableStockSample = availableStockSample;
	}

	public String getAvailableStockInventory() {
		return availableStockInventory;
	}

	public void setAvailableStockInventory(String availableStockInventory) {
		this.availableStockInventory = availableStockInventory;
	}

	@Override
	public String toString() {
		return "DetailedOrderItem [rowNo=" + rowNo + ", rowId=" + rowId + ", orderId=" + orderId + ", clientid="
				+ clientid + ", contactpersonid=" + contactpersonid + ", salesperson=" + salesperson
				+ ", billingaddressid=" + billingaddressid + ", deliveryaddressid=" + deliveryaddressid + ", productId="
				+ productId + ", quantity=" + quantity + ", rate=" + rate + ", brand_text=" + brand_text + ", discount="
				+ discount + ", hsnId=" + hsnId + ", igst=" + igst + ", availableStock=" + availableStock
				+ ", availableStockSample=" + availableStockSample + ", availableStockInventory="
				+ availableStockInventory + ", orderItemstatus=" + orderItemstatus + ", orderStatus=" + orderStatus
				+ ", productInfo=" + productInfo + ", companyName=" + companyName + ", cpname=" + cpname
				+ ", orderdate=" + orderdate + ", status_txt=" + status_txt + ", skuid=" + skuid + ", bbranchName="
				+ bbranchName + ", blocationadd=" + blocationadd + ", bGst=" + bGst + ", bstate_text=" + bstate_text
				+ ", bpincode=" + bpincode + ", dbranchName=" + dbranchName + ", dlocationadd=" + dlocationadd
				+ ", dstate_text=" + dstate_text + ", dpincode=" + dpincode + ", spname=" + spname
				+ ", invoicetype_txt=" + invoicetype_txt + ", modeofpay_txt=" + modeofpay_txt + ", expectedDeilvery="
				+ expectedDeilvery + ", contactNo=" + contactNo + ", createdBy=" + createdBy + ", refno=" + refno
				+ ", quantity_out=" + quantity_out + ", orderstatus_txt=" + orderstatus_txt + ", createdOn=" + createdOn
				+ ", location=" + location + ", isEditable=" + isEditable + ", remarks=" + remarks + ", ca11=" + ca11
				+ ", ca12=" + ca12 + ", ca21=" + ca21 + ", ca22=" + ca22 + ", clientLocation=" + clientLocation + "]";
	}

	
	
}
