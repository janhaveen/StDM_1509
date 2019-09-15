package com.employee.pojo;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="d_employee", uniqueConstraints={@UniqueConstraint(columnNames = {"rowId", "mobileNo", "emailId","userId", "accountNo"}) })
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Employee")
@Proxy(lazy = false)

public class Employee {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private String rowNo;
	
	@Column(name="rowId")
	private String rowId;
	@Column(name="firstName")	
	private String firstName;
	@Column(name="lastName")	
	private String lastName;
	@Column(name="department")
	private String department;
	@Column(name="designation")
	private String designation;
	@Column(name="mobileNo")
	private long mobileNo;
	@Column(name="altContactNo")
	private long altContactNo;
	@Column(name="emailId")
	private String emailId;
	@Column(name="userId")
	private String userId;
	@Column(name="branchId") 	 	
	private String branchId;
	@Column(name="password")
	private String password;
	@Column(name="workingAt")
	private String workingAt;
	@Column(name="permissions")
	private String permissions;
	@Column(name="birthDate")
	private Date birthDate;
	@Column(name="joinDate")
	private Date joinDate;
	@Column(name="status")
	private String status;
	@Column(name="reportTo") 	 
	private String reportTo;
	@Column(name="location") 
	private String location;
	@Column(name="prefix")
	private String prefix;
	@Column(name="gender")
	private String gender;
	@Column(name="inputAddress")
	private String inputAddress;
	@Column(name="inputAddress2")
	private String inputAddress2;
	@Column(name="inputCity")
	private String inputCity;
	@Column(name="inputState")
	private String inputState;
	@Column(name="inputZip")
	private String inputZip;
	@Column(name="BasicSalary")
	private float BasicSalary;
	@Column(name="TravelAllowance")
	private float TravelAllowance;
	@Column(name="DearnessAllowance")
	private float DearnessAllowance;
	@Column(name="HouseRentAllowance") 
	private float HouseRentAllowance;
	@Column(name="ConveyanceAllowance")
	private float ConveyanceAllowance;
	@Column(name="SpecialAllowance")         
	private float SpecialAllowance;
	@Column(name="VariableSalary")
	private float VariableSalary;
	@Column(name="EPF")
	private float EPF;
	@Column(name="ESIC")
	private float ESIC;
	@Column(name="ProfessionalTax")
	private float ProfessionalTax;
	@Column(name="Mediclaim")
	private float Mediclaim;
	@Column(name="StatutoryBonus")
	private float StatutoryBonus;
	@Column(name="AccountNo")
	private String AccountNo;
	@Column(name="BankName")
	private String BankName;
	@Column(name="BankBranch")
	private String BankBranch;
	@Column(name="IFSCCOde")
	private String IFSCCOde;
	@Column(name="createdOn")
	private Timestamp createdOn;
	@Column(name="updatedOn")
	private Timestamp updatedOn;
	@Column(name="createdBy")	
	private String createdBy;
	@Column(name="updatedBy")	
	private String updatedBy;
	@Column(name="isDeleted")	
	private String isDeleted;
	public String getRowNo() {
		return rowNo;
	}
	public void setRowNo(String rowNo) {
		this.rowNo = rowNo;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
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
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWorkingAt() {
		return workingAt;
	}
	public void setWorkingAt(String workingAt) {
		this.workingAt = workingAt;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReportTo() {
		return reportTo;
	}
	public void setReportTo(String reportTo) {
		this.reportTo = reportTo;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getInputAddress() {
		return inputAddress;
	}
	public void setInputAddress(String inputAddress) {
		this.inputAddress = inputAddress;
	}
	public String getInputAddress2() {
		return inputAddress2;
	}
	public void setInputAddress2(String inputAddress2) {
		this.inputAddress2 = inputAddress2;
	}
	public String getInputCity() {
		return inputCity;
	}
	public void setInputCity(String inputCity) {
		this.inputCity = inputCity;
	}
	public String getInputState() {
		return inputState;
	}
	public void setInputState(String inputState) {
		this.inputState = inputState;
	}
	public String getInputZip() {
		return inputZip;
	}
	public void setInputZip(String inputZip) {
		this.inputZip = inputZip;
	}
	public float getBasicSalary() {
		return BasicSalary;
	}
	public void setBasicSalary(float basicSalary) {
		BasicSalary = basicSalary;
	}
	public float getTravelAllowance() {
		return TravelAllowance;
	}
	public void setTravelAllowance(float travelAllowance) {
		TravelAllowance = travelAllowance;
	}
	public float getDearnessAllowance() {
		return DearnessAllowance;
	}
	public void setDearnessAllowance(float dearnessAllowance) {
		DearnessAllowance = dearnessAllowance;
	}
	public float getHouseRentAllowance() {
		return HouseRentAllowance;
	}
	public void setHouseRentAllowance(float houseRentAllowance) {
		HouseRentAllowance = houseRentAllowance;
	}
	public float getConveyanceAllowance() {
		return ConveyanceAllowance;
	}
	public void setConveyanceAllowance(float conveyanceAllowance) {
		ConveyanceAllowance = conveyanceAllowance;
	}
	public float getSpecialAllowance() {
		return SpecialAllowance;
	}
	public void setSpecialAllowance(float specialAllowance) {
		SpecialAllowance = specialAllowance;
	}
	public float getVariableSalary() {
		return VariableSalary;
	}
	public void setVariableSalary(float variableSalary) {
		VariableSalary = variableSalary;
	}
	public float getEPF() {
		return EPF;
	}
	public void setEPF(float ePF) {
		EPF = ePF;
	}
	public float getESIC() {
		return ESIC;
	}
	public void setESIC(float eSIC) {
		ESIC = eSIC;
	}
	public float getProfessionalTax() {
		return ProfessionalTax;
	}
	public void setProfessionalTax(float professionalTax) {
		ProfessionalTax = professionalTax;
	}
	public float getMediclaim() {
		return Mediclaim;
	}
	public void setMediclaim(float mediclaim) {
		Mediclaim = mediclaim;
	}
	public float getStatutoryBonus() {
		return StatutoryBonus;
	}
	public void setStatutoryBonus(float statutoryBonus) {
		StatutoryBonus = statutoryBonus;
	}
	public String getAccountNo() {
		return AccountNo;
	}
	public void setAccountNo(String accountNo) {
		AccountNo = accountNo;
	}
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public String getBankBranch() {
		return BankBranch;
	}
	public void setBankBranch(String bankBranch) {
		BankBranch = bankBranch;
	}
	public String getIFSCCOde() {
		return IFSCCOde;
	}
	public void setIFSCCOde(String iFSCCOde) {
		IFSCCOde = iFSCCOde;
	}
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	public Timestamp getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
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
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
}
