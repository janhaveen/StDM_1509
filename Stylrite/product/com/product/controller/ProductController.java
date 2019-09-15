package com.product.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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

import com.product.pojo.Product;
import com.product.service.ProductService;


@Controller
@WebListener
public class ProductController 
{
    @Autowired
    private ProductService productService;
    
	
    /*** Page Redirect on product.jsp ***/
	@RequestMapping(value = "/showProduct", method = RequestMethod.GET)
    public ModelAndView showProduct(ModelAndView model) 
    {
        model.addObject("product", new Product());
        
        model.setViewName("Product/Product");
        
		return model;
    }
	
	/*** Listing HSN List in Json Format ***/
    @RequestMapping(value = "/getProductList", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listProductData(Model model, HttpSession session) 
    {
		
    		HashMap<String, Object> hm = new HashMap();
		
		 	List listProdcut = productService.getProductList();
	        
	        //mv.addAttribute("listCustomers", listCustomers);
	        
	        hm.put("data", listProdcut);
	        
	        return hm ;
		
	}
    
	
    /*** Creating a add new Product ***/
    @PostMapping("/productSave")
    public @ResponseBody int productSaveData(@ModelAttribute("product") Product product, BindingResult br, @RequestParam ("action") String action, @RequestParam ("size1") String size1, @RequestParam ("color1") String color1) 
    {
    	System.out.println(product+" ");
    	
    	System.out.println(action+" "+size1+" "+color1);
    	
    	int status = 0;
    	
    	try
    	{
    		 product.setColor(color1);
    		 product.setSize(size1);
    		 
    		 status = productService.addProduct(product, action);
    	}
    	catch (Exception e)
    	{
			e.printStackTrace();
		}
    	
        return status;
    }
    
    /*** Listing HSN List in Json Format ***/
    @RequestMapping(value = "/getHSNList", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listHSNData(Model model, HttpSession session) 
    {
		
    		HashMap<String, Object> hm = new HashMap();
		
		 	List listHSN = productService.getHSNList();
	        
	        //mv.addAttribute("listCustomers", listCustomers);
	        
	        hm.put("data", listHSN);
	        
	        return hm ;
		
	}
    
    /*** Update Product ***/
    @RequestMapping(value="/productUpdate",method=RequestMethod.POST)
    public @ResponseBody int updateProductData(@ModelAttribute("product") Product product,@RequestParam("action")String action, @RequestParam ("size1") String size1, @RequestParam ("color1") String color1)
    {
    	int status=0;
    	try
    	{
    		System.out.println(product +"");
    		
    		System.out.println(action +" ");
    		
    		product.setColor(color1);
    		
    		product.setSize(size1);
    		
    		status = productService.updateProduct(product,action);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    	
        return status;
    }
    
    /*** Delete Product ***/
    @RequestMapping(value="/productDelete",method=RequestMethod.POST)
    public @ResponseBody int deleteProductData(@ModelAttribute("product") Product product, @RequestParam("rowId") String rowId)
    {
    	int status=0;
    	try
    	{
    		System.out.println(product +"");
    		
    		System.out.println(rowId +"  ");
    		
    		status = productService.deleteProduct(product, rowId);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    	
        return status;
    }
    
    /*** Check SKU Exists In Product ***/
    @RequestMapping(value="/CheckSkuExists",method=RequestMethod.GET)
    public @ResponseBody int CheckSkuExistsData(@ModelAttribute("product") Product product, @RequestParam("brand") String brand)
    {
    	int status = 0;
    	
    	try
    	{
    		System.out.println(product +"   "+brand);
    		
    		
    		status = productService.CheckSkuExists(product);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    	
        return status;
    }
    /*** Listing PRODUCT List in Json Format ***/
    @RequestMapping(value = "/GetProductListDatatable", produces = "application/json", method = RequestMethod.GET)
   	public @ResponseBody HashMap getProductListDataTable(Model model, HttpSession session) 
       {
   		
       		HashMap<String, Object> hm = new HashMap();
   		
   		 	List listProdcutDataTable = productService.getProductListDataTable();
   	        
   	        //mv.addAttribute("listCustomers", listCustomers);
   	        
   	        hm.put("data", listProdcutDataTable);
   	        
   	        return hm ;
   		
   	}
    
    /*** Check SKU If Exists In Product ***/
    @RequestMapping(value="/CheckSkuIfExists", produces = "application/json", method=RequestMethod.GET)
    public @ResponseBody HashMap CheckSkuIfExistsData(@ModelAttribute("product") Product product)
    {
    	
    	HashMap<String, Object> hm = new HashMap();
		
	 	List listSku = productService.getCheckSkuIfExists(product);
        
        hm.put("data", listSku);
        
        return hm ;
    }
    /*** Get Stock Person Sales Wise ***/
   /* @RequestMapping(value="/CheckSkuExists",method=RequestMethod.GET)
    public @ResponseBody int CheckSkuExistsData(@ModelAttribute("product") Product product, @RequestParam("brand") String brand)
    {
    	int status = 0;
    	
    	try
    	{
    		System.out.println(product +"   "+brand);
    		
    		
    		status = productService.CheckSkuExists(product);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    	
        return status;
    }*/

}
