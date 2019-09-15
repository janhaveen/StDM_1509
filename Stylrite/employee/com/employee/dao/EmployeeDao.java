/**
 * 
 */
package com.employee.dao;

import java.util.List;

import com.employee.pojo.Employee;
import com.session.pojo.LogLogInAndLogOutTime;

/**
 * @author janhavee
 *
 */
public interface EmployeeDao {

	 public List<Employee> employeeValidate(Employee employee);
	 public List getAllEmployees();
	/*
	 * public boolean addEmployee(Employee employee);
	 * 
	 * 
	 * 
	 * public List getLegendList();
	 * 
	 * 
	 * public void loginlog(LogLogInAndLogOutTime logTime);
	 * 
	 * public void logOutEmployee(String email);
	 */
	public List getManagerList();
	public boolean addEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);

}
