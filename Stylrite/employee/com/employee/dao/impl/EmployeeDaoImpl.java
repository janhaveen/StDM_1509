package com.employee.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.EntityManager;
import
javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.employee.dao.EmployeeDao;
import com.employee.pojo.Employee;
import com.employee.pojo.EmployeeListView;
import com.session.pojo.LogLogInAndLogOutTime;

@Repository("employeeDaoImpl")

@Transactional public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext(unitName="stylriteGeneral")
    private EntityManager entityManager;

	public List<Employee> employeeValidate(Employee employee) {
		@SuppressWarnings("unchecked")
		List <Employee> list = entityManager.createQuery("Select emp from Employee emp where emp.userId='" +employee.getUserId()
		+ "'and emp.password='" + employee.getPassword() +"'").getResultList(); 
		System.out.println("list of employee Login" + list.get(0));
		   return list; 
	}
	public List getAllEmployees() { 
		return entityManager.createQuery("select empListView from EmployeeListView empListView",EmployeeListView.class).getResultList(); 
	 }
	@Override
	public List getManagerList() {
		@SuppressWarnings("unchecked")
		List <Employee> list = entityManager.createQuery("Select emp from EmployeeListView emp where emp.desigText='Manager' OR emp.deptText='Management'").getResultList(); 
		System.out.println("list of employee Login" + list);
		   return list; 
	}
	@Override
	public boolean addEmployee(Employee employee) {
		boolean bol = false;
		System.out.println("employee.... "+employee);
		try{
			entityManager.persist(employee);
			bol = true;
		}catch (Exception e) {
			bol = false;
			e.printStackTrace();
		}
		return bol;
	}
	@Override
	public boolean updateEmployee(Employee employee) {

		boolean b1=false;
		try {
		String hql="update Employee e set e.firstName='"+employee.getFirstName()+"', e.lastName='"+employee.getLastName()+"', "
				+ "e.department='"+employee.getDepartment()+"', e.designation='"+employee.getDesignation()+"', e.mobileNo="+employee.getMobileNo()+", "
				+ "e.altContactNo="+employee.getAltContactNo()+", e.emailId='"+employee.getEmailId()+"', e.userId='"+employee.getUserId()+"', e.branchId='"+employee.getBranchId()+"', "
				+ "e.workingAt='"+employee.getWorkingAt()+"', e.permissions='"+employee.getPermissions()+"', "
				+ "e.birthDate='"+employee.getBirthDate()+"', e.joinDate='"+employee.getJoinDate()+"', e.status='"+employee.getStatus()+"', "
				+ "e.reportTo='"+employee.getReportTo()+"', e.location='"+employee.getLocation()+"', e.prefix='"+employee.getPrefix()+"', "
				+ "e.gender='"+employee.getGender()+"', e.inputAddress='"+employee.getInputAddress()+"', "
				+ "e.inputAddress2='"+employee.getInputAddress2()+"', e.inputCity='"+employee.getInputCity()+"', e.inputState='"+employee.getInputState()+"', "
				+ "e.inputZip='"+employee.getInputZip()+"', e.BasicSalary="+employee.getBasicSalary()+", e.TravelAllowance="+employee.getTravelAllowance()+", "
				+ "e.DearnessAllowance="+employee.getDearnessAllowance()+", e.HouseRentAllowance="+employee.getHouseRentAllowance()+", "
				+ "e.ConveyanceAllowance="+employee.getConveyanceAllowance()+", e.SpecialAllowance="+employee.getSpecialAllowance()+", e.VariableSalary="+employee.getVariableSalary()+", "
				+ "e.EPF="+employee.getEPF()+", e.ESIC="+employee.getESIC()+", e.ProfessionalTax="+employee.getProfessionalTax()+", e.Mediclaim="+employee.getMediclaim()+", "
				+ "e.StatutoryBonus="+employee.getStatutoryBonus()+", e.AccountNo='"+employee.getAccountNo()+"', e.BankName='"+employee.getBankName()+"', "
				+ "e.BankBranch='"+employee.getBankBranch()+"', e.IFSCCOde='"+employee.getIFSCCOde()+"', e.updatedOn='"+employee.getCreatedOn()+"', "
				+ "e.updatedBy='"+employee.getCreatedBy()+"' where e.rowId='"+employee.getRowId()+"'";
		
         Query q = entityManager.createQuery(hql);
         int i = q.executeUpdate();
         b1 = true;
     } catch (Exception e) {
         e.printStackTrace();
         b1 = false;
     }

     return b1;
	}

	/*
	 * public void setEntityManager(EntityManager entityManager) {
	 * this.entityManager = entityManager; }
	 * 
	 * @Override public boolean addEmployee(Employee employee) { boolean bol =
	 * false;
	 * 
	 * System.out.println("employee.... " + employee);
	 * 
	 * try { entityManager.persist(employee);
	 * 
	 * bol = true; } catch (Exception e) { bol = false;
	 * 
	 * e.printStackTrace(); }
	 * 
	 * return bol; }
	 * 
	 * @Override public List getAllEmployees() { 
	 * return entityManager.createQuery("select empListView from EmployeeListView empListView",EmployeeListView.class).getResultList(); 
	 * }
	 * 
	 * @Override public List getLegendList() { return
	 * entityManager.createQuery("select lng from Legend lng", Legend.class).
	 * getResultList(); }
	 */
	/*
	 * @Override public List <Employee> employeeValidate(Employee employee) { 
	 * List <Employee > list = entityManager.createQuery("Select emp from Employee emp where emp.emailId='" +employee.getEmailId() + "'and emp.password='" + employee.getPassword() +"'").getResultList(); System.out.println("list of employee Login" + list);
	   return list; }
	 */

	/*
	 * @Override public void loginlog(LogLogInAndLogOutTime logTime) { boolean bool
	 * = false;
	 * 
	 * try { entityManager.persist(logTime);
	 * 
	 * bool = true; } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * @Override public void logOutEmployee(String email) { try {
	 * 
	 * String hql = "UPDATE LogLogInAndLogOutTime lg set lg.logOut ='" +
	 * CurrentDateTime. CurrentTime() +
	 * "',lg.reasonOfLogOut='manual' where lg.emailId='" + email + "'";
	 * 
	 * System.out.println("Query of login and logout" + hql);
	 * 
	 * javax.persistence.Query query = entityManager.createQuery(hql);
	 * 
	 * int i = query.executeUpdate();
	 * 
	 * System.out.println("Iffected Row in Task Modified-->" + i);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 * 
	 * public void loginlog(LogLogInAndLogOutTime logTime) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 */
}