package com.employee.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.employee.pojo.Employee;
import com.employee.service.EmployeeService;

@Controller
@WebListener
public class EmployeeController {
	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public ModelAndView
	 * home(ModelAndView model) { // model.addObject("employee", new Employee());
	 * System.out.println("hi"); model.setViewName("LogIn");
	 * 
	 * return model; }
	 */
	/*
	*/
	@Autowired
    private EmployeeService employeeService;
	/*** Page Redirect on employee.jsp ***/
	  @RequestMapping(value = "/showEmployee", method = RequestMethod.GET) 
	  public ModelAndView showEmployee(ModelAndView model) {
	  		model.addObject("employee",new Employee());
	 		model.setViewName("Employee/Employee");
	  		return model; 
	  }
	  
	/*** Listing Customer List in Json Format ***/
    @RequestMapping(value = "/GetManagerList", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap getManagerList(Model model, HttpSession session) 
    {	
		HashMap<String, Object> hm = new HashMap();
	 	List listEmployees = employeeService.getManagerList();
        //mv.addAttribute("listCustomers", listCustomers);
        hm.put("data", listEmployees);
        return hm ;	
	}
    
    /*** Listing Manager List in Json Format ***/
    @RequestMapping(value = "/GetEmployeeList", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listEmployee(Model model, HttpSession session) 
    {	
		HashMap<String, Object> hm = new HashMap();
	 	List listEmployees = employeeService.getAllEmployees();
        //mv.addAttribute("listCustomers", listCustomers);
        hm.put("data", listEmployees);
        return hm ;
		
	}
    
    /*** Creating a add new Employee ***/
    @PostMapping("/addEmployee")
    public @ResponseBody int employeeRegister(@ModelAttribute("employee") Employee employee, BindingResult br, @RequestParam ("action") String action) 
    {
    	System.out.println(employee+" ");
    	System.out.println(action+" ");
    	int status = 0;
        status = employeeService.addEmployee(employee, action);
        return status;
    }
    
    /*** Updating Employee ***/
    @PostMapping("/updateEmployee")
    public @ResponseBody int employeeUpdate(@ModelAttribute("employee") Employee employee, BindingResult br, @RequestParam ("action") String action) 
    {
    	System.out.println(employee+" ");
    	System.out.println(action+" ");
    	int status = 0;
        status = employeeService.updateEmployee(employee, action);
        return status;
    }
	  
	 /*** Listing Customer List in Json Format ***/
	/*
	 * @RequestMapping(value = "/listEmployee", produces = "application/json",
	 * method = RequestMethod.GET) public @ResponseBody HashMap listEmployee(Model
	 * model, HttpSession session) {
	 * 
	 * HashMap<String, Object> hm = new HashMap();
	 * 
	 * List listEmployees = employeeService.getAllEmployees();
	 * 
	 * //mv.addAttribute("listCustomers", listCustomers);
	 * 
	 * hm.put("data", listEmployees);
	 * 
	 * return hm ;
	 * 
	 * }
	 * 
	 *//*** Creating a add new Vendor ***/
	/*
	 * @PostMapping("/employeeRegister") public @ResponseBody int
	 * employeeRegister(@ModelAttribute("employee") Employee employee, BindingResult
	 * br, @RequestParam ("action") String action) {
	 * System.out.println(employee+" ");
	 * 
	 * System.out.println(action+" ");
	 * 
	 * int status = 0;
	 * 
	 * status = employeeService.addEmployee(employee, action);
	 * 
	 * return status; }
	 *//*** LogIn employee ***/
	/*
	 * @PostMapping("/logInEmployee") public @ResponseBody String
	 * logIn(@ModelAttribute("employee") Employee employee, HttpSession session,
	 * Model model) { try {
	 * 
	 * System.out.println("employee emaild 11111id"+employee.getEmailId());
	 * session.setAttribute("emailId", employee.getEmailId());
	 * 
	 * boolean bol = employeeService.employeeValidate(employee);
	 * System.out.println("employee emaild id"+employee.getEmailId()); if (bol) {
	 * //employeeService.getEmployeeByEmail(employeePojo.getEmail());
	 * 
	 * return "1"; } else {
	 * 
	 * model.addAttribute("messege", employee.getEmailId().toString() +
	 * "Email And Password Invalid !!");
	 * 
	 * return "2"; } } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * return "500"; }
	 * 
	 *//*** Listing DepartmentAndDesignation List in Json Format ***/
	/*
	 * @RequestMapping(value = "/getLegendList", produces = "application/json",
	 * method = RequestMethod.GET) public @ResponseBody HashMap getLegendList(Model
	 * model, HttpSession session) {
	 * 
	 * HashMap<String, Object> hm = new HashMap();
	 * 
	 * List listEmployees = employeeService.getLegendList();
	 * 
	 * //mv.addAttribute("listCustomers", listCustomers);
	 * 
	 * hm.put("data", listEmployees);
	 * 
	 * return hm ;
	 * 
	 * }
	 *//*** Logout Employee ***//*
								 * @RequestMapping(value = "/logout", method = RequestMethod.GET) public
								 * ModelAndView logout(HttpServletRequest request, ModelAndView model,
								 * HttpSession session) { try {
								 * 
								 * System.out.println("EmailId Session"+session.getAttribute("emailId"));
								 * 
								 * String email = (String)session.getAttribute("emailId");
								 * 
								 * if (session != null) { employeeService.logOutEmployee(email);
								 * 
								 * session.removeAttribute("emailId");
								 * 
								 * session.invalidate();
								 * 
								 * }
								 * 
								 * } catch (Exception e) { e.printStackTrace(); }
								 * 
								 * model.addObject("employee", new Employee());
								 * 
								 * model.setViewName("LogIn");
								 * 
								 * return model; }
								 */

}
