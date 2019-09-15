package com.employee.pojo;

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
@Table(name="employeelist")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "EmployeeListView")
@Proxy(lazy = false)

public class EmployeeListView implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rowNo")
	private String rowNo;	
	@Column(name="rowId")
	private String rowId;
	@Column(name="firstName")
	private String  firstName;
	@Column(name="lastName")
	private String  lastName;
	@Column(name="empname")
	private String  empname;
	@Column(name="department")
	private String  department;
	@Column(name="designation")
	private String  designation;
	@Column(name="contactNo")
	private long  contactNo;
	@Column(name="altcontactNo")
	private long  altcontactNo;
	@Column(name="emailId")
	private String  emailId;
	@Column(name="location")
	private String  location;
	@Column(name="workingAt")
	private String  workingAt;
	@Column(name="DOB")
	private String  DOB;
	@Column(name="joiningDate")
	private String  joiningDate;
	@Column(name="reportTo")
	private String  reportTo;
	@Column(name="userId")
	private String  userId;
	@Column(name="status")
	private String  status;
	@Column(name="password")
	private String  password;
	@Column(name="createdOn")
	private Timestamp  createdOn;
	@Column(name="updatedOn")
	private Timestamp  updatedOn;
	@Column(name="createdBy")
	private String  createdBy;
	@Column(name="updatedBy")
	private String  updatedBy;
	@Column(name="deptText")
	private String  deptText;
	@Column(name="desigText")
	private String  desigText;
	@Column(name="statustext")
	private String  statustext;
	@Column(name="reporttext")
	private String  reporttext;
	@Column(name="permissions")
	private String  permissions;
	@Column(name="gender")
	private String  gender;
	@Column(name="inputAddress")
	private String  inputAddress;
	@Column(name="inputAddress2")
	private String  inputAddress2;
	@Column(name="inputCity")
	private String  inputCity;
	@Column(name="inputState")
	private String  inputState;
	@Column(name="inputZip")
	private String  inputZip;
	@Column(name="BasicSalary")
	private float  BasicSalary;
	@Column(name="TravelAllowance")
	private float  TravelAllowance;
	@Column(name="DearnessAllowance")
	private float  DearnessAllowance;
	@Column(name="HouseRentAllowance")
	private float  HouseRentAllowance;
	@Column(name="ConveyanceAllowance")
	private float  ConveyanceAllowance;
	@Column(name="SpecialAllowance")
	private float  SpecialAllowance;
	@Column(name="VariableSalary")
	private float  VariableSalary;
	@Column(name="EPF")
	private float  EPF;
	@Column(name="ESIC")
	private float  ESIC;
	@Column(name="ProfessionalTax")
	private float  ProfessionalTax;
	@Column(name="Mediclaim")
	private float  Mediclaim;
	@Column(name="StatutoryBonus")
	private float  StatutoryBonus;
	@Column(name="AccountNo")
	private String  AccountNo;
	@Column(name="BankName")
	private String  BankName;
	@Column(name="BankBranch")
	private String  BankBranch;
	@Column(name="IFSCCOde")
	private String  IFSCCOde;
	@Column(name="genderText")
	private String  genderText;
	@Column(name="addressText")
	private String  addressText;
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
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
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
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public long getAltcontactNo() {
		return altcontactNo;
	}
	public void setAltcontactNo(long altcontactNo) {
		this.altcontactNo = altcontactNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getWorkingAt() {
		return workingAt;
	}
	public void setWorkingAt(String workingAt) {
		this.workingAt = workingAt;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getReportTo() {
		return reportTo;
	}
	public void setReportTo(String reportTo) {
		this.reportTo = reportTo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getDeptText() {
		return deptText;
	}
	public void setDeptText(String deptText) {
		this.deptText = deptText;
	}
	public String getDesigText() {
		return desigText;
	}
	public void setDesigText(String desigText) {
		this.desigText = desigText;
	}
	public String getStatustext() {
		return statustext;
	}
	public void setStatustext(String statustext) {
		this.statustext = statustext;
	}
	public String getReporttext() {
		return reporttext;
	}
	public void setReporttext(String reporttext) {
		this.reporttext = reporttext;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
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
	public String getGenderText() {
		return genderText;
	}
	public void setGenderText(String genderText) {
		this.genderText = genderText;
	}
	public String getAddressText() {
		return addressText;
	}
	public void setAddressText(String addressText) {
		this.addressText = addressText;
	}
	public EmployeeListView() {
	}
	public EmployeeListView(String rowNo, String rowId, String firstName, String lastName, String empname,
			String department, String designation, long contactNo, long altcontactNo, String emailId, String location,
			String workingAt, String dOB, String joiningDate, String reportTo, String userId, String status,
			String password, Timestamp createdOn, Timestamp updatedOn, String createdBy, String updatedBy,
			String deptText, String desigText, String statustext, String reporttext, String permissions, String gender,
			String inputAddress, String inputAddress2, String inputCity, String inputState, String inputZip,
			float basicSalary, float travelAllowance, float dearnessAllowance, float houseRentAllowance,
			float conveyanceAllowance, float specialAllowance, float variableSalary, float ePF, float eSIC,
			float professionalTax, float mediclaim, float statutoryBonus, String accountNo, String bankName,
			String bankBranch, String iFSCCOde, String genderText, String addressText) {
		super();
		this.rowNo = rowNo;
		this.rowId = rowId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.empname = empname;
		this.department = department;
		this.designation = designation;
		this.contactNo = contactNo;
		this.altcontactNo = altcontactNo;
		this.emailId = emailId;
		this.location = location;
		this.workingAt = workingAt;
		DOB = dOB;
		this.joiningDate = joiningDate;
		this.reportTo = reportTo;
		this.userId = userId;
		this.status = status;
		this.password = password;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.deptText = deptText;
		this.desigText = desigText;
		this.statustext = statustext;
		this.reporttext = reporttext;
		this.permissions = permissions;
		this.gender = gender;
		this.inputAddress = inputAddress;
		this.inputAddress2 = inputAddress2;
		this.inputCity = inputCity;
		this.inputState = inputState;
		this.inputZip = inputZip;
		BasicSalary = basicSalary;
		TravelAllowance = travelAllowance;
		DearnessAllowance = dearnessAllowance;
		HouseRentAllowance = houseRentAllowance;
		ConveyanceAllowance = conveyanceAllowance;
		SpecialAllowance = specialAllowance;
		VariableSalary = variableSalary;
		EPF = ePF;
		ESIC = eSIC;
		ProfessionalTax = professionalTax;
		Mediclaim = mediclaim;
		StatutoryBonus = statutoryBonus;
		AccountNo = accountNo;
		BankName = bankName;
		BankBranch = bankBranch;
		IFSCCOde = iFSCCOde;
		this.genderText = genderText;
		this.addressText = addressText;
	}
	
	
}