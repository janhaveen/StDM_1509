package com.requisition.controller;

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

import com.requisition.service.RequisitionService;
import com.stock.service.StockService;

@Controller
@WebListener
public class RequisitionController {
	 @Autowired
	 private RequisitionService requisitionService;
	 
	@RequestMapping(value = "/showRequisition", method = RequestMethod.GET)
    public ModelAndView showRequisition(ModelAndView model) {        
        model.setViewName("InvoiceDispatch/RequisitionList");
		return model;
    }
	
	/*** Listing Requisition List in Json Format ***/
    @RequestMapping(value = "/GetRequisitionListDatatable", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listInvoiceRequisitionData(Model model, HttpSession session) {
		HashMap<String, Object> hm = new HashMap();
	 	List listInvoiceRequisitionData = requisitionService.getInvoiceRequisitionList();
        //mv.addAttribute("listCustomers", listCustomers);
        hm.put("data", listInvoiceRequisitionData);
        return hm;
	}
    
    /*** Requisition Details in Json Format ***/
    @RequestMapping(value = "/GetRequisitionDetails", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listInvoiceRequisitionDetails(Model model, HttpSession session, @RequestParam ("requisitionId") String requisitionId) {
		HashMap<String, Object> hm = new HashMap();
	 	List listInvoiceRequisitionDetails = requisitionService.getInvoiceRequisitionDetails(requisitionId);
        //mv.addAttribute("listCustomers", listCustomers);
        hm.put("data", listInvoiceRequisitionDetails);
        return hm;
	}
    
    /*** Invoice Details in Json Format ***/
    @RequestMapping(value = "/GetInvoiceDetails", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap GetInvoiceDetails(Model model, HttpSession session, @RequestParam ("requisitionId") String requisitionId) {
		HashMap<String, Object> hm = new HashMap();
	 	List listInvoiceRequisitionDetails = requisitionService.getInvoiceDetails(requisitionId);
        //mv.addAttribute("listCustomers", listCustomers);
        hm.put("data", listInvoiceRequisitionDetails);
        return hm;
	}
    
    /*** Dispatch Details in Json Format ***/
    @RequestMapping(value = "/GetDispatchDetails", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap GetDispatchDetails(Model model, HttpSession session, @RequestParam ("requisitionId") String requisitionId) {
		HashMap<String, Object> hm = new HashMap();
	 	List listInvoiceRequisitionDetails = requisitionService.getDispatchDetails(requisitionId);
        //mv.addAttribute("listCustomers", listCustomers);
        hm.put("data", listInvoiceRequisitionDetails);
        return hm;
	}
   
	/*
	 * @RequestMapping(value = "/stockOutSample", method = RequestMethod.GET) public
	 * ModelAndView stockOutSample(ModelAndView model) {
	 * model.setViewName("StockOut/SampleForStockOut"); return model; }
	 */
}
