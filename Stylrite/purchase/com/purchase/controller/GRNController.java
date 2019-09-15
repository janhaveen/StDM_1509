package com.purchase.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.annotation.WebListener;
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
import com.purchase.pojo.GRN;
import com.purchase.pojo.GRNItem;
import com.purchase.service.GRNService;


@Controller
@WebListener
public class GRNController 
{
	@Autowired
	GRNService 	grnService;
	
    /*** Page Redirect on CreateGRN.jsp ***/
	@RequestMapping(value = "/showGRN", method = RequestMethod.GET)
    public ModelAndView showGRN(ModelAndView model) 
    {
      //  model.addObject("product", new Product());
        
        model.setViewName("GRN/CreateGRN");
        
		return model;
    }
	
	 /*** Creating a add new GRN ***/
	@RequestMapping(value = "/grnSave", method = RequestMethod.POST)
    public @ResponseBody int grnSaveData(@ModelAttribute("grn") GRN grn, @ModelAttribute("product") Product product, BindingResult br , @RequestParam("sku") String sku, @RequestParam("count") String count, @RequestParam("GRNItemId") String GRNItemId, @RequestParam("ProductId") String ProductId , @RequestParam("quantity") int quantity, @RequestParam("rowId") String rowId) 
    {
    	System.out.println(grn+" ");
    	
    	int status = 0;
    	
    	try
    	{
    		  product.setRowId(ProductId);
    		  product.setSku(sku);
    		  
    		  System.out.println("...........er........... "+product);

    		  if(count.equals("0")) 
			  { 
				status = grnService.addGRN(grn); 
			  }
			  
			  GRNItem grnItem = new GRNItem(GRNItemId, rowId, sku, quantity, product.getCost());
			  
			  System.out.println(".................... "+grnItem);
			  
			 status = grnService.addGRNItem(grnItem);
			  
			  if(status == 701) 
			  {
				status = grnService.addProductGRN(product); 
			  }
			         	
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
		}
    	
    	 return status;
    }
    
    /*** Creating a add new Barcode ***/
	  @PostMapping("/addNewChildBarcode") 
	  public @ResponseBody int addNewChildBarcodeData(@ModelAttribute("childBarcode") ChildBarcode childBarcode, BindingResult br, @RequestParam ("createBarcodeArray") JSONArray createBarcodeArray)
	  {
		  //System.out.println(grnId+"................i");
		  
		  int status = 0;

		  try 
		  {
			  for (int i = 0; i < createBarcodeArray.length(); i++)
			  {
				  JSONObject jsonObject = (JSONObject) createBarcodeArray.get(i);
				 
				 ChildBarcode cBarCode = new ChildBarcode(jsonObject.getString("rowId"), jsonObject.getString("GRNNumber"), jsonObject.getString("sku"), jsonObject.getFloat("cost"), jsonObject.getString("status"), jsonObject.getLong("printStatus"));
				 
				 System.out.println(jsonObject+"..........."+i+"..........."+cBarCode);
				  
				 status =  grnService.addNewChildBarcode(cBarCode);
			  }
		  } 
		  catch (Exception e) 
		  {
			  e.printStackTrace();
		  }
		  
		  return status; 
	  }
    
    /*** Page Redirect on GRN.jsp ***/
	@RequestMapping(value = "/viewGRN", method = RequestMethod.GET)
    public ModelAndView showGRNView(ModelAndView model, @RequestParam("grnId") String grnId) 
    {
        model.addObject("grnId",grnId);
        
        model.setViewName("GRN/ViewGRN");
        
		return model;
    }
	
    /*** Listing BarCode List For GRN id based in Json Format ***/
    @RequestMapping(value = "/getChildBarcodeList", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listBarcodeDataForGRNIdBased(Model model, HttpSession session, @RequestParam("grnId") String grnId) 
    {
    		HashMap<String, Object> hm = new HashMap();
		
		 	List listGrn = grnService.getChildBarcodeListForGrnIdBased(grnId);
	        
	        hm.put("data", listGrn);
	        
	        return hm ;
		
	}
    
    /*** Page Redirect on UploadGRN.jsp ***/
   	@RequestMapping(value = "/uploadGRN", method = RequestMethod.GET)
       public ModelAndView uploadGRN(ModelAndView model) 
       {
         //  model.addObject("product", new Product());
           
           model.setViewName("GRN/UploadGRN");
           
   		 return model;
       }

	  
   	@RequestMapping(value="/Productcsvupload",method=RequestMethod.POST)
   	public @ResponseBody int Productcsvupload(@ModelAttribute("grn") GRN grn, @RequestParam("jsonobject") JSONObject  jsonobject, Product productData)
   	{
   		int status=0;
   		  
	  	System.out.println(grn+"...............546");
 	    
 	    System.out.println(jsonobject+"................i");
 	    
	   	  try 
		  {
	   		  status = grnService.addGRN(grn);
	  		  
	   		  if(status == 601)
	   		  {
	   			  
	   			grnService.uploadecsv(jsonobject, grn.getRowId());
				
	   		  }
		  }
	   	  catch (Exception e) 
	   	  {
			e.printStackTrace();
		  }
	   	  
   	    return status;
   	    
   	}
	@RequestMapping(value="/checkbrandexist",method=RequestMethod.POST)
   	public @ResponseBody String checkbrandexist( @RequestParam("brandarray") String  brandarray)
   	{
   		List<String> myList = new ArrayList<String>(Arrays.asList(brandarray.substring(1, brandarray.length()-1).split(",")));

   		Set<String> set = new HashSet<>((myList));
   		System.out.println(set.toString());
   		myList.clear();
   		myList.addAll(set);
   		System.out.println(myList.toString());
   		
   		
   	    return grnService.checkbrandsexists(myList);
   	    
   }
   	

   	
   	/*** Page Redirect on GRNList.jsp ***/
	@RequestMapping(value = "/listGRN", method = RequestMethod.GET)
    public ModelAndView showGRNList(ModelAndView model) 
    {
        //model.addObject("grnId",grnId);
        
        model.setViewName("GRN/GRNList");
        
		return model;
    }
	
	/*** Listing GRN View List in Json Format ***/
    @RequestMapping(value = "/getGRNList", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listGRNData(Model model, HttpSession session) 
    {
    		HashMap<String, Object> hm = new HashMap();
		
		 	List listGrn = grnService.getGRNList();
	        
	        hm.put("data", listGrn);
	        
	        return hm ;
		
	}
    
    /*** Listing GRN View List in Json Format ***/
    @RequestMapping(value = "/getGRNViewData", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap viewGRNData(Model model, HttpSession session, @RequestParam("grnId") String grnId) 
    {
    		HashMap<String, Object> hm = new HashMap();
		
		 	List listGrn = grnService.getGRNViewData(grnId);
	        
	        hm.put("data", listGrn);
	        
	        return hm ;
		
	}
    
    /*** Creating a add new Barcode Of Upload GRN ***/
	  @PostMapping("/addNewChildBarcodeOfUploadGRN") 
	  public @ResponseBody int addNewChildBarcodeOfUploadGRNData(@ModelAttribute("childBarcode") ChildBarcode childBarcode, BindingResult br, @RequestParam ("createBarcodeArrayOfUploadGRN") JSONArray createBarcodeArrayOfUploadGRN)
	  {
		  //System.out.println(grnId+"................i");
		  
		  int status = 0;

		  try 
		  {
			  for (int i = 0; i < createBarcodeArrayOfUploadGRN.length(); i++)
			  {
				  JSONObject jsonObject = (JSONObject) createBarcodeArrayOfUploadGRN.get(i);
				  
				  ChildBarcode cBarCode = new ChildBarcode(jsonObject.getString("barCodeId"), jsonObject.getString("gRNnumber"), jsonObject.getFloat("cost"), jsonObject.getString("status"), jsonObject.getLong("printStatus"));
					 
				  System.out.println(jsonObject+"..................jsonObject......"+i);
				  
				  status =  grnService.createSkuOfUploadGRNandAddNewChildBarcode(jsonObject.getString("brand"), jsonObject.getString("modelNo"),jsonObject.getString("color"),jsonObject.getString("size"), cBarCode);
				  
			  }
		  } 
		  catch (Exception e) 
		  {
			  e.printStackTrace();
		  
		  }
		  return status; 
	  }
}
