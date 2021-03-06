package com.barcode.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.barcode.service.BoxBarcodeService;


@Controller
@WebListener
public class BoxBarcodeController {	
	@Autowired 
	private BoxBarcodeService boxBarcodeService;
	 
	@RequestMapping(value = "/showEmptyLocationList", method = RequestMethod.GET)
	public ModelAndView showEmptyLocationList(ModelAndView model) {        
       model.setViewName("Barcode/EmptyLocation");
		return model;
	}
	
	/*** Listing Empty Box Barcode List in Json Format ***/
	@RequestMapping(value = "/GetEmptyBoxBarcodeList", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listEmptyLocationList(Model model, HttpSession session) {
		HashMap<String, Object> hm = new HashMap();
	 	List listInvoiceRequisitionDetails = boxBarcodeService.getlistEmptyLocationList();
        hm.put("data", listInvoiceRequisitionDetails);
        return hm;
	}
	
}
