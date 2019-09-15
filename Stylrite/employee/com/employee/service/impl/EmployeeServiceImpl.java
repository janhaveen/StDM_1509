package com.employee.service.impl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.support.CurrentDateTimeProvider;
import org.springframework.stereotype.Service;

import com.data.service.impl.CurrentDateTime;
import com.employee.dao.EmployeeDao;
import com.employee.pojo.Employee;
import com.employee.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService
{

	@Autowired
	HttpSession session;
	
	@Autowired
	private EmployeeDao employeeDao;

	/*
	 * public void setEmployeeDao(EmployeeDao employeeDao) { this.employeeDao =
	 * employeeDao; }
	 * 
	 * public int addEmployee(Employee employee, String action) { boolean bol =
	 * false;
	 * 
	 * int status = 0;
	 * 
	 * employee.setPassword("pass123");
	 * 
	 * employee.setIsDeleted("0");
	 * 
	 * employee.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
	 * 
	 * employee.setCreatedOn(CurrentDateTime.CurrentTimestamp());
	 * 
	 * bol = employeeDao.addEmployee(employee);
	 * 
	 * if(bol) { status = 301; } else { status = 302; }
	 * 
	 * return status; }
	 */
	/*
	 * @Override public List getAllEmployees() { return
	 * employeeDao.getAllEmployees(); }
	 * 
	 * @Override public List getLegendList() { return employeeDao.getLegendList(); }
	 */

	public boolean employeeValidate(Employee employee) 
	{
		boolean b=false;
		
		List<Employee> list1=employeeDao.employeeValidate(employee);
		
		if(list1.size()==0) 
		{
			b=false;
		}
		
		else
		{
			for(Employee emp : list1)
			{
				
				/*
				 * session.setAttribute("userId", emp.getUserId());
				 * session.setAttribute("emailId", emp.getEmailId()); //
				 * session.setAttribute("password", emp.getPassword());
				 * session.setAttribute("empName", emp.getFirstName()+" "+emp.getLastName());
				 * session.setAttribute("department", emp.getDepartment());
				 * session.setAttribute("designation", emp.getDesignation());
				 * session.setAttribute("birthDate", emp.getBirthDate());
				 * session.setAttribute("mobileNo", emp.getMobileNo());
				 * session.setAttribute("UserId", emp.getUserId());
				 */
				 System.out.print(emp.getRowId());
				session.setAttribute("userRowId", emp.getRowId());
				session.setAttribute("userName", emp.getFirstName());
				session.setAttribute("empname",  emp.getFirstName()+" "+emp.getLastName());
				session.setAttribute("userId", emp.getUserId());
				session.setAttribute("password", emp.getUserId());
				session.setAttribute("Department",emp.getDepartment());
				session.setAttribute("Designation", emp.getDesignation());
				
				/*
				 * session.setAttribute("departmentTxt", rs.getString("deptText"));
				 * session.setAttribute("designationTxt", rs.getString("desigText"));
				 */
				 
			}
			
			Employee emp=new Employee();
			emp=list1.get(0);
			/*
			 * LogLogInAndLogOutTime logTime = new LogLogInAndLogOutTime();
			 * logTime.setEmployeeId(emp.getRowNo()); logTime.setEmailId(emp.getEmailId());
			 * logTime.setLogIn(CurrentDateTime.CurrentTime());
			 * logTime.setTypeOfLogIn("manual");
			 */
			 if(!employee.equals(null))
			  {
				// employeeDao.loginlog(logTime);
				  
				  b = true; 
			  }
			  
			
		}
		return b;	
	}
	/*
	 * public List getAllEmployees() { return employeeDao.getAllEmployees(); }
	 * 
	 * public List getLegendList() { return employeeDao.getLegendList(); }
	 * 
	 * public void logOutEmployee(String email) { employeeDao.logOutEmployee(email);
	 * }
	 */

	public List getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public List getManagerList() {
		return employeeDao.getManagerList();
	}

	@Override
	public int addEmployee(Employee employee, String action) {
		boolean bol = false;
		
		int status = 0;
		
		employee.setRowId(UUID.randomUUID().toString());
		
		employee.setPassword("pass123");
		
		employee.setIsDeleted("0");
		
		employee.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
		employee.setCreatedOn(CurrentDateTime.CurrentTimestamp());
		employee.setUpdatedBy(String.valueOf(session.getAttribute("userRowId")));
		employee.setUpdatedOn(CurrentDateTime.CurrentTimestamp());
		bol = employeeDao.addEmployee(employee);
		
		if(bol)
		{
			status = 1;
		}
		else
		{
			status = 0;
		}
		
		return status;
	}

	@Override
	public int updateEmployee(Employee employee, String action) {
		boolean bol = false;
		
		int status = 0;
		
		employee.setCreatedBy(String.valueOf(session.getAttribute("userRowId")));
		employee.setCreatedOn(CurrentDateTime.CurrentTimestamp());
		bol = employeeDao.updateEmployee(employee);
		if(bol){
			status = 1;
		}else{
			status = 0;
		}		
		return status;
	}	
	
}
