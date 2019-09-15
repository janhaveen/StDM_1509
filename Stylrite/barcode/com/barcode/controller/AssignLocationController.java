package com.barcode.controller;

import javax.servlet.annotation.WebListener;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@WebListener
public class AssignLocationController {
	@RequestMapping(value = "/assignLocation", method = RequestMethod.GET)
    public ModelAndView showBarcodeListData(ModelAndView model) 
    {        
        model.setViewName("Barcode/AssignLocation");
        
		return model;
    }
}
