package com.npdProduct.Controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.npdProduct.Service.NPDProductService;
import com.npdProduct.pojo.NPDProduct;
import com.product.pojo.Product;


@Controller
@WebListener
public class NPDProductController 
{
    @Autowired
    private NPDProductService npdProductService;
    
    /*** Page Redirect on productNPD.jsp ***/
   	@RequestMapping(value = "/showProductNPD", method = RequestMethod.GET)
    public ModelAndView showProductNPD(ModelAndView model) 
    {
       model.addObject("product", new Product());
       
       model.setViewName("NPDProduct/productNPD");
       
	 return model;
    }
   	
   	/*** Listing Product NPD List in Json Format ***/
    @RequestMapping(value = "/getProductNPDList", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listProductNPDData(Model model, HttpSession session) 
    {
		
    		HashMap<String, Object> hm = new HashMap();
		
		 	List listProdcut = npdProductService.getProductNPDList();
	        
	        //mv.addAttribute("listCustomers", listCustomers);
	        
	        hm.put("data", listProdcut);
	        
	        return hm ;
		
	}
    
    /*** Sent For Purchase of NPD Product ***/
    @RequestMapping(value="/sentForPurchase",method=RequestMethod.POST)
    public @ResponseBody int sentForPurchaseData(@ModelAttribute("product") Product product, @RequestParam("sku") String sku, @RequestParam("productId") String productId, @RequestParam("rowId") String rowId, @RequestParam("npdType") String npdType)
    {
    	int status = 0;
    	
    	try
    	{
    		System.out.println(sku +"   "+productId+" "+rowId);
    		
    		status = npdProductService.sentForPurchaseData(product, sku, productId, rowId, npdType);
    		
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    	
        return status;
    }
    
    /*** Sent For Production of NPD Product ***/
    @RequestMapping(value="/sentForProduction",method=RequestMethod.POST)
    public @ResponseBody int sentForProductionData(@ModelAttribute("product") Product product, @RequestParam("sku") String sku, @RequestParam("productId") String productId, @RequestParam("rowId") String rowId, @RequestParam("npdType") String npdType)
    {
    	int status = 0;
    	
    	try
    	{
    		System.out.println(sku +"   "+productId+" "+rowId);
    		
    		status = npdProductService.sentForProductionData(product, sku, productId, rowId, npdType);
    		
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    	
        return status;
    }
    
    /*** Page Redirect on requestForPurchaseList.jsp ***/
   	@RequestMapping(value = "/showRequestForPurchase", method = RequestMethod.GET)
    public ModelAndView showRequestForPurchase(ModelAndView model) 
    {
       model.addObject("product", new Product());
       
       model.setViewName("NPDProduct/requestForPurchaseList");
       
	 return model;
	 
    }
   	
	/*** Listing Request For Purchase List in Json Format ***/
    @RequestMapping(value = "/getRequestForPurchaseList", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap getRequestForPurchaseListData(Model model, HttpSession session) 
    {
		
    		HashMap<String, Object> hm = new HashMap();
		
		 	List listData = npdProductService.getRequestForPurchaseList();
	        
	        //mv.addAttribute("listCustomers", listCustomers);
	        
	        hm.put("data", listData);
	        
	        return hm ;
		
	}
    
    
    /*** Page Redirect on requestForProductionList.jsp ***/
   	@RequestMapping(value = "/showRequestForProduction", method = RequestMethod.GET)
    public ModelAndView showRequestForProduction(ModelAndView model) 
    {
       model.addObject("product", new Product());
       
       model.setViewName("NPDProduct/requestForProductionList");
       
	 return model;
	 
    }
   	
   	/*** Listing Request For Production List in Json Format ***/
    @RequestMapping(value = "/getRequestForProductionList", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap getRequestForProductionListData(Model model, HttpSession session) 
    {
		
    		HashMap<String, Object> hm = new HashMap();
		
		 	List listData = npdProductService.getRequestForProductionList();
	        
	        //mv.addAttribute("listCustomers", listCustomers);
	        
	        hm.put("data", listData);
	        
	        return hm ;
		
	}
    
    /*** update Status For Processed In NPD ***/
    @RequestMapping(value="/updateStatusForProcessedInNPD",method=RequestMethod.POST)
    public @ResponseBody int updateStatusForProcessedInNPDData(@ModelAttribute("npdProduct") NPDProduct npdProduct, @RequestParam("sku") String sku, @RequestParam("productId") String productId, @RequestParam("rowId") String rowId, @RequestParam("npdStatus") String npdStatus)
    {
    	int status = 0;
    	
    	try
    	{
    		System.out.println(sku +"   "+productId+" "+rowId+"....."+npdStatus);
    		
    		status = npdProductService.updateStatusForProcessedInNPD(npdProduct, sku, productId, rowId, npdStatus);
    		
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    	
        return status;
    }
    
    /*** update Status For InProcessed In NPD ***/
    @RequestMapping(value="/updateStatusForInProcessedInNPD",method=RequestMethod.POST)
    public @ResponseBody int updateStatusForInProcessedInNPDData(@ModelAttribute("npdProduct") NPDProduct npdProduct, @RequestParam("sku") String sku, @RequestParam("productId") String productId, @RequestParam("rowId") String rowId, @RequestParam("npdStatus") String npdStatus)
    {
    	int status = 0;
    	
    	try
    	{
    		System.out.println(sku +"   "+productId+" "+rowId+"....."+npdStatus);
    		
    		status = npdProductService.updateStatusForInProcessedInNPD(npdProduct, sku, productId, rowId, npdStatus);
    		
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    	
        return status;
    }
}
