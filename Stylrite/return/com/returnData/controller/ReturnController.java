package com.returnData.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
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

import com.barcode.pojo.ChildBarcode;
import com.product.pojo.Product;
import com.returnData.pojo.DetailReturnItemView;
import com.returnData.pojo.ReturnDemo;
import com.returnData.pojo.ReturnItem;
import com.returnData.service.ReturnService;


@Controller
public class ReturnController 
{
    @Autowired
    private ReturnService returnService;
    
	
    /*** Page Redirect on Return.jsp ***/
	@RequestMapping(value = "/showReturn", method = RequestMethod.GET)
	public ModelAndView showVendor(ModelAndView model)
	{
		//model.addObject("order", new Order());

		model.setViewName("Return/Return");

		return model;
	}
    
	
	/*** View Return Details ***/
	@RequestMapping(value = "/getReturnList", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listReturnDetails(Model model, HttpSession session) 
	{

		HashMap<String, Object> hm = new HashMap();

		List viewReturnDetails = returnService.getAllReturnDetails();

		System.out.println("Return Details" + viewReturnDetails);

		hm.put("data", viewReturnDetails);

		System.out.println("hm " + hm);

		return hm;

	}
	
	/*** Creating a add new Return ***/
	@RequestMapping(value = "/returnSave", method = RequestMethod.POST)
    public @ResponseBody int returnSaveData(@ModelAttribute("returnDemo") ReturnDemo returnDemo, @ModelAttribute("product") Product product, ReturnItem returnItem, BindingResult br, HttpServletRequest request, HttpServletResponse response) 
    {
    	System.out.println(returnDemo+" ");
    	
    	System.out.println(product+" "+request.getParameter("ProductId"));
    	
    	int status = 0;
    	
    	try
    	{
    		 product.setRowId(request.getParameter("ProductId"));
    		 
    		 if(request.getParameter("count").equals("0"))
    		 {
    			status = returnService.saveReturn(returnDemo);
    		 }
    		 
    		 //status = returnService.saveReturnItem(returnItem , returnDemo, product, request);
    		 
    		 if(status == 3001)
    		 {
    			 status = returnService.addProductReturn(product); 
    		 }
			         	
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
		}
    	
    	 return status;
    }
	
	   /*** Creating a add new Return ***/
	  @PostMapping("/returnItemSave") 
	  public @ResponseBody int returnSaveData(@ModelAttribute("returnDemo") ReturnDemo returnDemo, @ModelAttribute("product") Product product, ReturnItem returnItem, BindingResult br, HttpServletRequest request, HttpServletResponse response, @RequestParam ("returnItemArray") JSONArray returnItemArray)
	  {
		  
		  int status = 0;

		  try 
		  {
			status = returnService.saveReturnItemArray(returnItem , returnDemo, product, request, returnItemArray);
		  } 
		  catch (Exception e) 
		  {
			  e.printStackTrace();
		  }
		  
		  return status; 
	  }
	
	/*** Page Redirect on ReturnItem.jsp ***/
	@RequestMapping(value = "/showReturnItem", method = RequestMethod.GET)
	public ModelAndView showReturnItem(ModelAndView model)
	{
		//model.addObject("order", new Order());

		model.setViewName("Return/ReturnItem");

		return model;
	}
	
	/*** View Return Item Details ***/
	@RequestMapping(value = "/getReturnItemList", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listReturnItemDetails(Model model, HttpSession session) 
	{

		HashMap<String, Object> hm = new HashMap();

		List<DetailReturnItemView> viewReturnItemDetails = returnService.getAllReturnItemDetails();

		System.out.println("Return Details" + viewReturnItemDetails);

		hm.put("data", viewReturnItemDetails);

		System.out.println("hm " + hm);

		return hm;

	}
}
