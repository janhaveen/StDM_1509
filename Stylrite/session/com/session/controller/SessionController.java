package com.session.controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.employee.pojo.Employee;
import com.employee.service.EmployeeService;


@Controller
@WebListener
public class SessionController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView model) {
		// model.addObject("employee", new Employee());
		System.out.println("hi");
		model.setViewName("LogIn");

		return model;
	}
	@Autowired
    private EmployeeService employeeService;
	/*** LogIn employee ***/
    @PostMapping("/logInEmployee")
	public @ResponseBody String logIn(@ModelAttribute("employee") Employee employee, HttpSession session, Model model) 
    {
        try{
        	session.setAttribute("emailId", employee.getUserId());            
            boolean bol = employeeService.employeeValidate(employee);
            System.out.println("employee emaild id"+employee.getUserId());
            if (bol){
            	return "1";
            } else {            
            	//model.addAttribute("messege", employee.getEmailId().toString() + "Email And Password Invalid !!");            	
    			return "2";
            }
		} 
        catch (Exception e) 
        {
        	e.printStackTrace();
		}
        
		return "500";
    }
}
