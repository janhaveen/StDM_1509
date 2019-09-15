package com.returnData.pojo;

import java.io.Serializable;
import java.sql.Date;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="detailreturnitemview")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="DetailReturnItemView")
@Proxy(lazy = false)
public class DetailReturnItemView implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private long rowNo;
	
	@Column(name="rowId", unique = true)
	private String rowId; 
	
	@Column(name="returnId")
    private String returnId;
	
	@Column(name="clientId")
    private String clientId;
	
	@Column(name="contactPersonId")
    private String contactPersonId;
	
	@Column(name="salesPerson")
    private String salesPerson;
	
	@Column(name="salesPersonText")
    private String salesPersonText;
	
	@Column(name="clientAddressId")
    private String clientAddressId;
	
	@Column(name="productId")
    private String productId;
	
	@Column(name="quantity")
    private String quantity;
	
	@Column(name="isDamaged")
    private String isDamaged;
	
	@Column(name="returnItemstatus")
    private String returnItemstatus;
	
	@Column(name="returnStatus")
    private String returnStatus;
	
	@Column(name="productInfo")
	private String  productInfo;
	
	@Column(name="brand_text")
	private String  brand_text;
	
	@Column(name="skuId")
	private String  skuId;
	
	@Column(name="sku")
    private String sku;
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="cpname")
	private String cpname;
	
	@Column(name="contactNo")
	private String contactNo;
	
	@Column(name="clientAddress1")
	private String clientAddress1;
	
	@Column(name="clientAddress2")
	private String clientAddress2;
	
	@Column(name="bstate_text")
	private String bstate_text;
	
	@Column(name="bpincode")
	private String bpincode;
	
	@Column(name="returndate")
	private String returndate;
	
	@Column(name="createdBy")
	private String createdBy;

	@Column(name="createdOn")
	private String createdOn;
	
	@Column(name="receivedBy")
    private String receivedBy;
	
	@Column(name="receivedOn")
    private String receivedOn;
	
	@Column(name="returnstatus_txt")
	private String returnstatus_txt;
	
	@Column(name="returnItemstatus_txt")
	private String returnItemstatus_txt;
	
	@Column(name="remarks")
	private String remarks;
	
	public DetailReturnItemView() 
	{
		
	}

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

	public String getReturnId() {
		return returnId;
	}

	public void setReturnId(String returnId) {
		this.returnId = returnId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getContactPersonId() {
		return contactPersonId;
	}

	public void setContactPersonId(String contactPersonId) {
		this.contactPersonId = contactPersonId;
	}

	public String getSalesPerson() {
		return salesPerson;
	}

	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}

	public String getSalesPersonText() {
		return salesPersonText;
	}

	public void setSalesPersonText(String salesPersonText) {
		this.salesPersonText = salesPersonText;
	}

	public String getClientAddressId() {
		return clientAddressId;
	}

	public void setClientAddressId(String clientAddressId) {
		this.clientAddressId = clientAddressId;
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

	public String getIsDamaged() {
		return isDamaged;
	}

	public void setIsDamaged(String isDamaged) {
		this.isDamaged = isDamaged;
	}

	public String getReturnItemstatus() {
		return returnItemstatus;
	}

	public void setReturnItemstatus(String returnItemstatus) {
		this.returnItemstatus = returnItemstatus;
	}

	public String getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public String getBrand_text() {
		return brand_text;
	}

	public void setBrand_text(String brand_text) {
		this.brand_text = brand_text;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
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

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getClientAddress1() {
		return clientAddress1;
	}

	public void setClientAddress1(String clientAddress1) {
		this.clientAddress1 = clientAddress1;
	}

	public String getClientAddress2() {
		return clientAddress2;
	}

	public void setClientAddress2(String clientAddress2) {
		this.clientAddress2 = clientAddress2;
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

	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
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

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public String getReceivedOn() {
		return receivedOn;
	}

	public void setReceivedOn(String receivedOn) {
		this.receivedOn = receivedOn;
	}

	public String getReturnstatus_txt() {
		return returnstatus_txt;
	}

	public void setReturnstatus_txt(String returnstatus_txt) {
		this.returnstatus_txt = returnstatus_txt;
	}

	public String getReturnItemstatus_txt() {
		return returnItemstatus_txt;
	}

	public void setReturnItemstatus_txt(String returnItemstatus_txt) {
		this.returnItemstatus_txt = returnItemstatus_txt;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "DetailReturnItemView [rowNo=" + rowNo + ", rowId=" + rowId + ", returnId=" + returnId + ", clientId="
				+ clientId + ", contactPersonId=" + contactPersonId + ", salesPerson=" + salesPerson
				+ ", salesPersonText=" + salesPersonText + ", clientAddressId=" + clientAddressId + ", productId="
				+ productId + ", quantity=" + quantity + ", isDamaged=" + isDamaged + ", returnItemstatus="
				+ returnItemstatus + ", returnStatus=" + returnStatus + ", productInfo=" + productInfo + ", brand_text="
				+ brand_text + ", skuId=" + skuId + ", sku=" + sku + ", companyName=" + companyName + ", cpname="
				+ cpname + ", contactNo=" + contactNo + ", clientAddress1=" + clientAddress1 + ", clientAddress2="
				+ clientAddress2 + ", bstate_text=" + bstate_text + ", bpincode=" + bpincode + ", returndate="
				+ returndate + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", receivedBy=" + receivedBy
				+ ", receivedOn=" + receivedOn + ", returnstatus_txt=" + returnstatus_txt + ", returnItemstatus_txt="
				+ returnItemstatus_txt + ", remarks=" + remarks + "]";
	}
}
