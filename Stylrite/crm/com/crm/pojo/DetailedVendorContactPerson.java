package com.crm.pojo;

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
@Table(name = "detailedvendorcontactperson")
@DynamicUpdate
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "DetailedClientContactPerson")
@Proxy(lazy = false)
public class DetailedVendorContactPerson {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private int rowNo;	

	@Column(name="rowId")
	private String rowId;
	
	@Column(name="vendorId")
	private String vendorId;
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="contactNo")
	private long contactNo;
	
	@Column(name="altContactNo")
	private long altContactNo;
	
	
	@Column(name="emailId")
	private String emailId;
	
	
	@Column(name="department")
	private String department;
	
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="birthdate")
	private String birthdate;
	
	@Column(name="location")
	private String location;
	
	@Column(name="isDefault")
	private String isDefault;
	
	@Column(name = "createdBy")
	private String createdBy;

	@Column(name = "updatedBy")
	private String updatedBy;

	@Column(name = "createdOn")
	private String createdOn;

	@Column(name = "updatedOn")
	private String updatedOn;
	
	
	@Column(name = "department_text")
	private String department_text;
	
	@Column(name = "designation_text")
	private String designation_text;
	
	@Column(name = "formattedBirthdate")
	private String formattedBirthdate;
	

	@Column(name="isDeleted")
	private String isDeleted;
	

	public int getRowNo() {
		return rowNo;
	}

	public String getRowId() {
		return rowId;
	}

	public String getVendorId() {
		return vendorId;
	}

	public String getName() {
		return name;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public long getContactNo() {
		return contactNo;
	}

	public long getAltContactNo() {
		return altContactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getDepartment() {
		return department;
	}

	public String getDesignation() {
		return designation;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public String getLocation() {
		return location;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public String getDepartment_text() {
		return department_text;
	}

	public String getDesignation_text() {
		return designation_text;
	}

	public String getFormattedBirthdate() {
		return formattedBirthdate;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public void setAltContactNo(long altContactNo) {
		this.altContactNo = altContactNo;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public void setDepartment_text(String department_text) {
		this.department_text = department_text;
	}

	public void setDesignation_text(String designation_text) {
		this.designation_text = designation_text;
	}

	public void setFormattedBirthdate(String formattedBirthdate) {
		this.formattedBirthdate = formattedBirthdate;
	}
      
	
	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "DetailedVendorContactPerson [rowNo=" + rowNo + ", rowId=" + rowId + ", vendorId=" + vendorId + ", name="
				+ name + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNo=" + contactNo
				+ ", altContactNo=" + altContactNo + ", emailId=" + emailId + ", department=" + department
				+ ", designation=" + designation + ", birthdate=" + birthdate + ", location=" + location
				+ ", isDefault=" + isDefault + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", createdOn="
				+ createdOn + ", updatedOn=" + updatedOn + ", department_text=" + department_text
				+ ", designation_text=" + designation_text + ", formattedBirthdate=" + formattedBirthdate
				+ ", isDeleted=" + isDeleted + "]";
	}

	
}
