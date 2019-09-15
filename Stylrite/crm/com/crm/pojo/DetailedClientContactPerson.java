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
@Table(name = "detailedclientcontactperson")
@DynamicUpdate
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Client")
@Proxy(lazy = false)
public class DetailedClientContactPerson {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private int rowNo;	

	@Column(name="rowId")
	private String rowId;
	
	@Column(name="clientId")
	private String clientId;
	
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

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public long getAltContactNo() {
		return altContactNo;
	}

	public void setAltContactNo(long altContactNo) {
		this.altContactNo = altContactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
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

	public String getDepartment_text() {
		return department_text;
	}

	public void setDepartment_text(String department_text) {
		this.department_text = department_text;
	}

	public String getDesignation_text() {
		return designation_text;
	}

	public void setDesignation_text(String designation_text) {
		this.designation_text = designation_text;
	}

	public String getFormattedBirthdate() {
		return formattedBirthdate;
	}

	public void setFormattedBirthdate(String formattedBirthdate) {
		this.formattedBirthdate = formattedBirthdate;
	}

	@Override
	public String toString()
	{
		return "DetailedClientContactPerson [rowNo=" + rowNo + ", rowId=" + rowId + ", clientId=" + clientId + ", name="
				+ name + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNo=" + contactNo
				+ ", altContactNo=" + altContactNo + ", emailId=" + emailId + ", department=" + department
				+ ", designation=" + designation + ", birthdate=" + birthdate + ", location=" + location
				+ ", isDefault=" + isDefault + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", createdOn="
				+ createdOn + ", updatedOn=" + updatedOn + ", department_text=" + department_text
				+ ", designation_text=" + designation_text + ", formattedBirthdate=" + formattedBirthdate + "]";
	}
	
}
