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
@Table(name = "detailedrequisitionitem")
@DynamicUpdate
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "RequistionList")
@Proxy(lazy = false)
public class RequistionList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rowNo")                                      
	private int rowNo;                                 

	@Column( name = "rowId")
	private String rowId;
	
	@Column( name = "requisitionId")
	private String requisitionId;

	@Column( name = "referenceid")
	private String referenceid;
	
	@Column( name = "requisitionType")
	private String requisitionType;
	
	@Column( name = "productId")
	private String productId;
	
	@Column( name = "status")
	private String status;
	
	@Column( name = "qty")
	private String qty;
	
	@Column( name = "createdBy")
	private String createdBy;
	
	@Column( name = "updatedBy")
	private String updatedBy;
	
	@Column( name = "createdOn")
	private String createdOn;
	
	@Column( name = "updatedOn")
	private String updatedOn;
	
	@Column( name = "EmpName")
	private String EmpName;
	
	@Column( name = "formattedOrderCreatedOn")
	private String formattedOrderCreatedOn;
	
	@Column( name = "RequisitionCreatedOn")
	private String RequisitionCreatedOn;
	
	@Column( name = "formattedExpectedReceiptDate")
	private String formattedExpectedReceiptDate;
	
	@Column( name = "formattedDispatchedDate")
	private String formattedDispatchedDate;
	
	@Column( name = "transportName")
	private String transportName;
	
	@Column( name = "trackingID")
	private String trackingID;
	
	@Column( name = "eBillNo")
	private String eBillNo;
	
	@Column( name = "formattedReceiptDate")
	private String formattedReceiptDate;
	
	@Column( name = "reason_text")
	private String reason_text;
	
	@Column( name = "rqtnItmstatus_text")
	private String rqtnItmstatus_text;
	
	@Column( name = "productInfo")
	private String productInfo;
	
	@Column( name = "skuid")
	private String skuid;
	
	@Column( name = "class1")
	private String class1;
	
	@Column( name = "rqtnStatus")
	private String rqtnStatus;
	
	@Column( name = "modeofDelivery_text")
	private String modeofDelivery_text;
	
	@Column( name = "rqtnStatus_text")
	private String rqtnStatus_text;
	
	@Column( name = "requisitionType_text")
	private String requisitionType_text;
	
	@Column( name = "orderitemid")
	private String orderitemid;
	
	@Column( name = "orderid")
	private String orderid;
	
	@Column( name = "state_txt")
	private String state_txt;
	
	@Column( name = "orderCreatedOn")
	private String orderCreatedOn;
	
	@Column( name = "companyName")
	private String companyName;
	
	@Column( name = "spname")
	private String spname;
	
	@Column( name = "invoiceid")
	private String invoiceid;
	
	@Column( name = "dispatchid")
	private String dispatchid;
	
	@Column( name = "bbranchName")
	private String bbranchName;
	
	@Column( name = "locationAdd")
	private String locationAdd;
	
	@Column( name = "blocationadd")
	private String blocationadd;
	
	@Column( name = "bGst")
	private String bGst;
	
	@Column( name = "bstate_text")
	private String bstate_text;
	
	@Column( name = "bpincode")
	private String bpincode;
	
	@Column( name = "dbranchName")
	private String dbranchName;
	
	@Column( name = "dlocationadd")
	private String dlocationadd;
	
	@Column( name = "dstate_text")
	private String dstate_text;
	
	@Column( name = "dpincode")
	private String dpincode;
	
	@Column( name = "ca11")
	private String ca11;
	
	@Column( name = "ca12")
	private String ca12;
	
	@Column( name = "ca21")
	private String ca21;
	
	@Column( name = "ca22")
	private String ca22;
	
	@Column( name = "invoicedate")
	private String invoicedate;

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

	public String getReferenceid() {
		return referenceid;
	}

	public void setReferenceid(String referenceid) {
		this.referenceid = referenceid;
	}

	public String getRequisitionType() {
		return requisitionType;
	}

	public void setRequisitionType(String requisitionType) {
		this.requisitionType = requisitionType;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
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
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
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

	public String getTransportName() {
		return transportName;
	}

	public void setTransportName(String transportName) {
		this.transportName = transportName;
	}

	public String getTrackingID() {
		return trackingID;
	}

	public void setTrackingID(String trackingID) {
		this.trackingID = trackingID;
	}

	public String geteBillNo() {
		return eBillNo;
	}

	public void seteBillNo(String eBillNo) {
		this.eBillNo = eBillNo;
	}

	public String getFormattedReceiptDate() {
		return formattedReceiptDate;
	}

	public void setFormattedReceiptDate(String formattedReceiptDate) {
		this.formattedReceiptDate = formattedReceiptDate;
	}

	public String getReason_text() {
		return reason_text;
	}

	public void setReason_text(String reason_text) {
		this.reason_text = reason_text;
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

	
	public String getRqtnStatus() {
		return rqtnStatus;
	}

	public void setRqtnStatus(String rqtnStatus) {
		this.rqtnStatus = rqtnStatus;
	}

	public String getModeofDelivery_text() {
		return modeofDelivery_text;
	}

	public void setModeofDelivery_text(String modeofDelivery_text) {
		this.modeofDelivery_text = modeofDelivery_text;
	}

	public String getRqtnStatus_text() {
		return rqtnStatus_text;
	}

	public void setRqtnStatus_text(String rqtnStatus_text) {
		this.rqtnStatus_text = rqtnStatus_text;
	}

	public String getRequisitionType_text() {
		return requisitionType_text;
	}

	public void setRequisitionType_text(String requisitionType_text) {
		this.requisitionType_text = requisitionType_text;
	}

	public String getOrderitemid() {
		return orderitemid;
	}

	public void setOrderitemid(String orderitemid) {
		this.orderitemid = orderitemid;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getState_txt() {
		return state_txt;
	}

	public void setState_txt(String state_txt) {
		this.state_txt = state_txt;
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

	public String getBbranchName() {
		return bbranchName;
	}

	public void setBbranchName(String bbranchName) {
		this.bbranchName = bbranchName;
	}

	public String getLocationAdd() {
		return locationAdd;
	}

	public void setLocationAdd(String locationAdd) {
		this.locationAdd = locationAdd;
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

	public String getInvoicedate() {
		return invoicedate;
	}

	public void setInvoicedate(String invoicedate) {
		this.invoicedate = invoicedate;
	}

	
	
	public String getClass1() {
		return class1;
	}

	public void setClass1(String class1) {
		this.class1 = class1;
	}

	@Override
	public String toString() {
		return "RequistionList [rowNo=" + rowNo + ", rowId=" + rowId + ", requisitionId=" + requisitionId
				+ ", referenceid=" + referenceid + ", requisitionType=" + requisitionType + ", productId=" + productId
				+ ", status=" + status + ", qty=" + qty + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", EmpName=" + EmpName
				+ ", formattedOrderCreatedOn=" + formattedOrderCreatedOn + ", RequisitionCreatedOn="
				+ RequisitionCreatedOn + ", formattedExpectedReceiptDate=" + formattedExpectedReceiptDate
				+ ", formattedDispatchedDate=" + formattedDispatchedDate + ", transportName=" + transportName
				+ ", trackingID=" + trackingID + ", eBillNo=" + eBillNo + ", formattedReceiptDate="
				+ formattedReceiptDate + ", reason_text=" + reason_text + ", rqtnItmstatus_text=" + rqtnItmstatus_text
				+ ", productInfo=" + productInfo + ", skuid=" + skuid + ", class1=" + class1 + ", rqtnStatus=" + rqtnStatus
				+ ", modeofDelivery_text=" + modeofDelivery_text + ", rqtnStatus_text=" + rqtnStatus_text
				+ ", requisitionType_text=" + requisitionType_text + ", orderitemid=" + orderitemid + ", orderid="
				+ orderid + ", state_txt=" + state_txt + ", orderCreatedOn=" + orderCreatedOn + ", companyName="
				+ companyName + ", spname=" + spname + ", invoiceid=" + invoiceid + ", dispatchid=" + dispatchid
				+ ", bbranchName=" + bbranchName + ", locationAdd=" + locationAdd + ", blocationadd=" + blocationadd
				+ ", bGst=" + bGst + ", bstate_text=" + bstate_text + ", bpincode=" + bpincode + ", dbranchName="
				+ dbranchName + ", dlocationadd=" + dlocationadd + ", dstate_text=" + dstate_text + ", dpincode="
				+ dpincode + ", ca11=" + ca11 + ", ca12=" + ca12 + ", ca21=" + ca21 + ", ca22=" + ca22
				+ ", invoicedate=" + invoicedate + "]";
	}
	


}
