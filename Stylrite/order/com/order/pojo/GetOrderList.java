package com.order.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="getOrderDetails")
@DynamicUpdate
@NamedStoredProcedureQueries({
	  @NamedStoredProcedureQuery(
	    name = "getOrderDetails", 
	    procedureName = "getOrderDetails", 
	    resultClasses = { GetOrderList.class }, 
	    parameters = { 
	        @StoredProcedureParameter(
	          name = "orderId", 
	          type = String.class, 
	          mode = ParameterMode.IN) }) 
	})
/*@NamedStoredProcedureQuery(
		name = "getOrderDetails", 
		procedureName = "getOrderDetails", 
		parameters = { 
			@StoredProcedureParameter( mode = ParameterMode.IN, type = String.class, name = "orderId")})*/
public class GetOrderList {
	
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
	private int quantity;
	
	@Column(name="rate")
	private float rate;
	
	@Column(name="brand_txt")
	private String brand_txt;
	
	@Column(name="discount")
	private float discount;
	
	@Column(name="hsnId")
	private String hsnId;
	
	@Column(name="igst")
	private int igst;
	
	@Column(name="refno")
	private String refno;
	
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
	
	@Column(name="ClientRowNo")
	private String ClientRowNo;
	
	@Column(name="branchName")
	private String branchName;
	
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
	
	@Column(name="type_txt")
	private String type_txt;
	
	@Column(name="modeofpay_txt")
	private String modeofpay_txt;
	
	@Column(name="expectedDeilvery")
	private String expectedDeilvery;
	
	@Column(name="contactNo")
	private String contactNo;
	
	@Column(name="quantity_out")
	private String quantity_out;
	
	@Column(name="createdBy")
	private String createdBy;
	
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

	

	public String getClientRowNo() {
		return ClientRowNo;
	}


	public void setClientRowNo(String clientRowNo) {
		ClientRowNo = clientRowNo;
	}


	public String getRefno() {
		return refno;
	}


	public void setRefno(String refno) {
		this.refno = refno;
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


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public float getRate() {
		return rate;
	}


	public void setRate(float rate) {
		this.rate = rate;
	}


	public String getBrand_txt() {
		return brand_txt;
	}


	public void setBrand_txt(String brand_txt) {
		this.brand_txt = brand_txt;
	}


	public float getDiscount() {
		return discount;
	}


	public void setDiscount(float discount) {
		this.discount = discount;
	}


	public String getHsnId() {
		return hsnId;
	}


	public void setHsnId(String hsnId) {
		this.hsnId = hsnId;
	}


	public int getIgst() {
		return igst;
	}


	public void setIgst(int igst) {
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


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
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


	public String getQuantity_out() {
		return quantity_out;
	}


	public void setQuantity_out(String quantity_out) {
		this.quantity_out = quantity_out;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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


	

	@Override
	public String toString() {
		return "GetOrderList [rowNo=" + rowNo + ", rowId=" + rowId + ", orderId=" + orderId + ", clientid=" + clientid
				+ ", contactpersonid=" + contactpersonid + ", salesperson=" + salesperson + ", billingaddressid="
				+ billingaddressid + ", deliveryaddressid=" + deliveryaddressid + ", productId=" + productId
				+ ", quantity=" + quantity + ", rate=" + rate + ", brand_txt=" + brand_txt + ", discount=" + discount
				+ ", hsnId=" + hsnId + ", igst=" + igst + ", refno=" + refno + ", orderItemstatus=" + orderItemstatus
				+ ", orderStatus=" + orderStatus + ", productInfo=" + productInfo + ", companyName=" + companyName
				+ ", cpname=" + cpname + ", orderdate=" + orderdate + ", status_txt=" + status_txt + ", skuid=" + skuid
				+ ", ClientRowNo=" + ClientRowNo + ", branchName=" + branchName + ", blocationadd=" + blocationadd
				+ ", bGst=" + bGst + ", bstate_text=" + bstate_text + ", bpincode=" + bpincode + ", dbranchName="
				+ dbranchName + ", dlocationadd=" + dlocationadd + ", dstate_text=" + dstate_text + ", dpincode="
				+ dpincode + ", spname=" + spname + ", invoicetype_txt=" + invoicetype_txt + ", type_txt=" + type_txt
				+ ", modeofpay_txt=" + modeofpay_txt + ", expectedDeilvery=" + expectedDeilvery + ", contactNo="
				+ contactNo + ", quantity_out=" + quantity_out + ", createdBy=" + createdBy + ", orderstatus_txt="
				+ orderstatus_txt + ", createdOn=" + createdOn + ", location=" + location + ", isEditable=" + isEditable
				+ ", remarks=" + remarks + ", ca11=" + ca11 + ", ca12=" + ca12 + ", ca21=" + ca21 + ", ca22=" + ca22
				+ "]";
	}


	public String getType_txt() {
		return type_txt;
	}


	public void setType_txt(String type_txt) {
		this.type_txt = type_txt;
	}


	
	
	
}
