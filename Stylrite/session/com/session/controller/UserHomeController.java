package com.session.controller;

import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@WebListener
public class UserHomeController {
	@RequestMapping(value = "/UserHome", method = RequestMethod.GET) 
	  public ModelAndView showDashboard(ModelAndView model) {
	 		model.setViewName("UserHome");
	  		return model; 
	  }
}
