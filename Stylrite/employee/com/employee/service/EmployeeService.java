package com.employee.service;

import java.util.List;

import com.employee.pojo.Employee;

public interface EmployeeService {
	
	/*
	 * public int addEmployee(Employee employee, String action);
	 * 
	 * 
	 * 
	 * public List getLegendList();
	 */
	public List getAllEmployees();

	public boolean employeeValidate(Employee employee);

	public List getManagerList();

	public int addEmployee(Employee employee, String action);

	public int updateEmployee(Employee employee, String action);

	//public void logOutEmployee(String email);

}
