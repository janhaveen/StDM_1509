package com.session.pojo;

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
@Table(name="f_logInAndLogOutTimeLog")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "LogLogInAndLogOutTime")
@Proxy(lazy = false)
public class LogLogInAndLogOutTime 
{
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String logIn;
	@Column
	private String logOut;
	@Column
	private String typeOfLogIn;
	@Column
	private String reasonOfLogOut;
	@Column
	private int employeeId;
	@Column
	private String emailId;

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogIn() {
		return logIn;
	}
	public void setLogIn(String logIn) {
		this.logIn = logIn;
	}
	public String getLogOut() {
		return logOut;
	}
	public void setLogOut(String logOut) {
		this.logOut = logOut;
	}
	public String getTypeOfLogIn() {
		return typeOfLogIn;
	}
	public void setTypeOfLogIn(String typeOfLogIn) {
		this.typeOfLogIn = typeOfLogIn;
	}
	public String getReasonOfLogOut() {
		return reasonOfLogOut;
	}
	public void setReasonOfLogOut(String reasonOfLogOut) {
		this.reasonOfLogOut = reasonOfLogOut;
	}
	
	
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "LogLogInAndLogOutTime [id=" + id + ", logIn=" + logIn + ", logOut=" + logOut + ", typeOfLogIn="
				+ typeOfLogIn + ", reasonOfLogOut=" + reasonOfLogOut + ", employeeId=" + employeeId + ", emailId="
				+ emailId + "]";
	}
}
