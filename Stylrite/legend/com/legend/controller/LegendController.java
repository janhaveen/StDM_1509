package com.legend.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.legend.service.LegendService;


@Controller
@WebListener
public class LegendController 
{
    @Autowired
    private LegendService legendService;
    
	
    /*** Listing Product Legend List in Json Format ***/
    @RequestMapping(value = "/getProductLegendList", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listProductLegend(Model model, HttpSession session) 
    {
		
    		HashMap<String, Object> hm = new HashMap();
		
		 	List listProductLegendData = legendService.getProductLegendList();
	        
	        //mv.addAttribute("listCustomers", listCustomers);
	        
	        hm.put("data", listProductLegendData);
	        
	        return hm ;
		
	}
    
    /*** Listing General Legend List
    function createHTML1(Data)
    {
    	var options1="";
    	$("#brandFrm select").html('');
        for (i = 0; i < Data.data.length; i++){ 
        	if(Data.data[i].subCategory=="Brand"){
        		options1 += "<option value='" + Data.data[i].rowId + "' id='"+Data.data[i].otherInfo+"'>" + Data.data[i].description + "</option>";
        	} in Json Format ***/
    @RequestMapping(value = "/getLegendList", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listGeneralLegend(Model model, HttpSession session) 
    {
		
    		HashMap<String, Object> hm = new HashMap();
		
		 	List listProductLegendData = legendService.getGeneralLegendList();
	        
	        //mv.addAttribute("listCustomers", listCustomers);
	        
	        hm.put("data", listProductLegendData);
	        
	        return hm ;
		
	}
    
    
    /*** Listing State List in Json Format ***/
    @RequestMapping(value = "/GetState", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listState(Model model, HttpSession session) 
    {
		
    		HashMap<String, Object> hm = new HashMap();
		
		 	List listStateData = legendService.getAllState();
	        
	        //mv.addAttribute("listCustomers", listCustomers);
	        
	        hm.put("data", listStateData);
	        
	        return hm ;
		
	}
    
    /*** Listing Product Legend List in Json Format ***/
    @RequestMapping(value = "/GetPermissionLegend", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listPermissionLegend(Model model, HttpSession session) 
    {
		
    		HashMap<String, Object> hm = new HashMap();
		
		 	List listProductLegendData = legendService.getPermissionLegendListVerticalss();
		 	List listProductLegendData1 = legendService.getPermissionLegendList();

	        //mv.addAttribute("listCustomers", listCustomers);
	        
	        hm.put("data1", listProductLegendData1);
	        hm.put("data", listProductLegendData);
	        
	        return hm ;
		
	}
    
    /*** Listing Barcode Legend List in Json Format ***/
    @RequestMapping(value = "/getBarcodeLegend", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listBarcodeLegend(Model model, HttpSession session) 
    {
		
    		HashMap<String, Object> hm = new HashMap();
		
		 	List listBarcodeLegendData = legendService.getBarcodeLegendList();
	        
	        //mv.addAttribute("listCustomers", listCustomers);
	        
	        hm.put("data", listBarcodeLegendData);
	        
	        return hm ;
		
	}
    
    /*** Listing Audit Legend List in Json Format ***/
    @RequestMapping(value = "/getAuditLegend", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listAuditegend(Model model, HttpSession session) 
    {
		
    		HashMap<String, Object> hm = new HashMap();
		
		 	List list = legendService.getAuditList();
	        
	        //mv.addAttribute("listCustomers", listCustomers);
	        
	        hm.put("data", list);
	        
	        return hm ;
		
	}
    /*** Listing Inventory Legend List in Json Format ***/
    @RequestMapping(value = "/GetInventoryLegend", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listInventoryLegend(Model model, HttpSession session) 
    {
		
    		HashMap<String, Object> hm = new HashMap();
		
		 	List listInventoryLegendData = legendService.getInventoryLegendList();
	        
	        //mv.addAttribute("listCustomers", listCustomers);
	        
	        hm.put("data", listInventoryLegendData);
	        
	        return hm ;
		
	}
    
}
