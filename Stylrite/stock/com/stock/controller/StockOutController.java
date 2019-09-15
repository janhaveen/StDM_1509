package com.stock.controller;

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

import com.product.service.ProductService;
import com.stock.service.StockService;


@Controller
@WebListener
public class StockOutController {
	 @Autowired
	 private StockService stockService;
	 
	@RequestMapping(value = "/stockOutOrder", method = RequestMethod.GET)
    public ModelAndView stockOutOrder(ModelAndView model) 
    {        
        model.setViewName("StockOut/OrdersForStockOut");
		return model;
    }
	
	@RequestMapping(value = "/stockOutSample", method = RequestMethod.GET)
    public ModelAndView stockOutSample(ModelAndView model) 
    {        
        model.setViewName("StockOut/SampleForStockOut");
		return model;
    }
	/*** Listing Stock Out Order List in Json Format ***/
    @RequestMapping(value = "/GetStockOutListForOrder", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listOrderData(Model model, HttpSession session) 
    {
		HashMap<String, Object> hm = new HashMap();
	 	List listOrdersForStockOut = stockService.getOrdersForStockOutList();
        //mv.addAttribute("listCustomers", listCustomers);
        hm.put("data", listOrdersForStockOut);
        return hm ;
	}
    
    @RequestMapping(value = "/GetStockOutListForOrderProduct", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listProductData(Model model, HttpSession session, @RequestParam ("orderId") String orderId) 
    {
		HashMap<String, Object> hm = new HashMap();
	 	List listOrdersForStockOut = stockService.getOrderProductsForStockOutList(orderId);
        //mv.addAttribute("listCustomers", listCustomers);
        hm.put("data", listOrdersForStockOut);
        return hm ;
	}
    @RequestMapping(value = "/GetSampleListForStockOutFromSample", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody HashMap GetSampleListForStockOutFromSample(Model model, HttpSession session, @RequestParam ("Product_id") String Product_id) 
    {
		HashMap<String, Object> hm = new HashMap();
	 	List listOrdersForStockOut = stockService.getSampleListForStockOutFromSample(Product_id);
        //mv.addAttribute("listCustomers", listCustomers);
        hm.put("data", listOrdersForStockOut);
        return hm ;
	}
    
    
}
