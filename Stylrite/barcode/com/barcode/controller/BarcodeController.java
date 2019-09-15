package com.barcode.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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

import com.barcode.pojo.ChildBarcode;
import com.barcode.pojo.ChildBarcodeListForCSV;
import com.barcode.pojo.ChildBarcodeLogListView;
import com.barcode.service.BarcodeService;
import com.product.pojo.Product;


@Controller
@WebListener
public class BarcodeController 
{
	@Autowired
	BarcodeService barcodeService;
	
    /*** Page Redirect on Barcode.jsp ***/
	@RequestMapping(value = "/showBarcodeList", method = RequestMethod.GET)
    public ModelAndView showBarcodeListData(ModelAndView model) 
    {
      //  model.addObject("product", new Product());
        
        model.setViewName("Barcode/Barcode");
        
		return model;
    }
	
	/*** Listing BarCode List in Json Format ***/
    @RequestMapping(value = "/getChildBarcodeListData", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listBarcodeData(Model model, HttpSession session) 
    {
    		HashMap<String, Object> hm = new HashMap();
		
		 	List listBarcode = barcodeService.getChildBarcodeList();
	        
	        hm.put("data", listBarcode);
	        
	        return hm ;
		
	}
    
    /*** Update Product ***/
    @RequestMapping(value="/barcodeUpdate",method=RequestMethod.POST)
    public @ResponseBody int barcodeUpdateData(@ModelAttribute("childBarcode") ChildBarcode childBarcode)
    {
    	int status=0;
    	
    	try
    	{
    		System.out.println(childBarcode +"   .........");
    		
    		status = barcodeService.updateBarcode(childBarcode);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    	
        return status;
    }
    
    /*** Page Redirect on EditBarcodeForm.jsp ***/
	@RequestMapping(value = "/editBarcode", method = RequestMethod.GET)
    public ModelAndView showEditBarcodeData(ModelAndView model) 
    {
      //  model.addObject("product", new Product());
        
        model.setViewName("barcode/EditBarcodeForm");
        
		return model;
    }
	
	  /*** Check Scan Barcode in Json Format ***/
    @RequestMapping(value = "/checkScanBarcode", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap checkScanBarcodeData(Model model, HttpSession session, @RequestParam ("barcode") String barcode) 
    {
    	   System.out.println("sdffvbc................."+barcode);
    	
	        HashMap<String, Object> hm = new HashMap();
			
		 	List list34 = barcodeService.checkScanBarcode(barcode);
	        
	        hm.put("data", list34);
	        
			return hm;
	        
    }
    
    /*** Check Product Of Scan Barcode in Json Format ***/
    @RequestMapping(value = "/getProductOfScanBarcode", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap getProductOfScanBarcodeData(Model model, HttpSession session, @RequestParam ("sku") String sku) 
    {
    	   System.out.println("xzcb................."+sku);
    	
	        HashMap<String, Object> hm = new HashMap();
			
		 	List list34 = barcodeService.getProductOfScanBarcode(sku);
	        
	        hm.put("data", list34);
	        
			return hm;
	        
    }
    
    /*** check Product If Exists Or Not in Product table ***/
    @RequestMapping(value="/checkProductIfExistsOrNot",method=RequestMethod.POST)
    public @ResponseBody int checkProductIfExistsOrNotData(@ModelAttribute("childBarcode") ChildBarcode childBarcode, @ModelAttribute("product") Product product, @RequestParam ("barndText") String barndText, @RequestParam ("productIdText") String productIdText, @RequestParam ("barcodeIdText") String barcodeIdText)
    {
    	int status=0;
    	
    	try
    	{
    		System.out.println(childBarcode +"   ....786....."+product);
    		
    		System.out.println(barndText +"   ...78......"+productIdText+" ...........767...... "+barcodeIdText);
    		
    		product.setBrand(barndText);
    		
    		status = barcodeService.checkProductIfExistsOrNot(childBarcode, product, productIdText, barcodeIdText);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    	
        return status;
    }
    
    /*** New Product And Update BarCode  ***/
    @RequestMapping(value="/addNewProductAndUpdateBarcodeData",method=RequestMethod.POST)
    public @ResponseBody int addNewProductAndUpdateBarcodeData(@ModelAttribute("childBarcode") ChildBarcode childBarcode, @ModelAttribute("product") Product product, @RequestParam ("barndText") String barndText, @RequestParam ("productIdText") String productIdText, @RequestParam ("barcodeIdText") String barcodeIdText, @RequestParam ("oldSku") String oldSku, @RequestParam ("gRNnumber") String gRNnumber, @RequestParam ("oldLocation") String oldLocation, @RequestParam ("oldStatus") String oldStatus, @RequestParam ("oldType") String oldType, @RequestParam ("auditItemIdCurrentId") String auditItemIdCurrentId)
    {
    	int status=0;
    	
    	try
    	{
    		
    		product.setBrand(barndText);
    		
    		product.setRowId(productIdText);
    		
    		childBarcode.setGRNNumber(gRNnumber);
    		
    		System.out.println(childBarcode +"   .....45...."+product+"...................."+oldSku+"........"+oldType);
    		
    		System.out.println(barndText +"   .....123...."+productIdText+" ......65........... "+barcodeIdText+"........."+auditItemIdCurrentId);
    		
    		status = barcodeService.addNewProductAndUpdateBarcode(childBarcode, product, productIdText, barcodeIdText, oldSku , oldLocation, oldStatus, oldType, auditItemIdCurrentId);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    	
        return status;
    }
    
    /*** Update BarCode  ***/
    @RequestMapping(value="/updateBarcodeWithOldSku",method=RequestMethod.POST)
    public @ResponseBody int updateBarcodeData(@ModelAttribute("childBarcode") ChildBarcode childBarcode, @ModelAttribute("product") Product product, @RequestParam ("barndText") String barndText, @RequestParam ("productIdText") String productIdText, @RequestParam ("barcodeIdText") String barcodeIdText, @RequestParam ("oldLocation") String oldLocation, @RequestParam ("oldStatus") String oldStatus, @RequestParam ("gRNnumber") String gRNnumber, @RequestParam ("oldType") String oldType, @RequestParam ("auditItemIdCurrentId") String auditItemIdCurrentId)
    {
    	int status=0;
    	
    	try
    	{
    		System.out.println(childBarcode +"   .....69...."+product+"............"+oldLocation+".........."+oldStatus+"........"+oldType);
    		
    		System.out.println(barndText +"   .....89...."+productIdText+" ......52........... "+barcodeIdText+" .........."+auditItemIdCurrentId);
    		
    		product.setBrand(barndText);
    		
    		childBarcode.setGRNNumber(gRNnumber);
    		
    		status = barcodeService.updateBarcodeWithOldSku(childBarcode, product, productIdText, barcodeIdText, oldLocation, oldStatus, oldType, auditItemIdCurrentId);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    	
        return status;
    }
    
    /*** Get BarCode Edit Log History in Json Format ***/
    @RequestMapping(value = "/getEditBarCodeLogHistory", produces = "text/html", method = RequestMethod.GET)
	public @ResponseBody String getEditBarCodeLogHistoryData(Model model, HttpSession session, @RequestParam ("rowId") String rowId, @RequestParam ("start") String start, @RequestParam ("limit") String limit) 
    {
    	   System.out.println(rowId+"...................."+start+"................"+limit);
    	
	        //HashMap<String, Object> hm = new HashMap();
    	   String hm="";
		 	List<ChildBarcodeLogListView> list34 = barcodeService.getEditBarCodeLogHistory(rowId,start,limit);
	        
		 	
		 	Iterator<ChildBarcodeLogListView> itr = list34.iterator();
		 
		 	while(itr.hasNext())
		 	{
		 		System.out.println("xcvjh.................."+itr.next());
		 		
		 	}
		 	
		 	for (ChildBarcodeLogListView object1 : list34) 
		 	{
		 		System.out.println("dfcvbnm..................."+list34);
		 		
		 		/*
				 * hm += "<div class='col-md-12'>"
				 * +"<input type='hidden' id='start' value='"+start+"'>"
				 * +"<div style='display:block;' class='row'>"
				 * +"<div class='card z-depth-2 col-md-12' style='float: left;margin-bottom: 2px;background-color: rgba(3, 169, 244, 0.1);padding: 1%;font-family: cursive;'>"
				 * +"<div style='float: left;font-family: Comic Sans MS;font-size: small;'>"
				 * +itr.next().getCreatedOntxt()+"</div>"
				 * +"<div style='float: left;font-family: Comic Sans MS;padding-left: 2%;color: #656565;'>"
				 * +itr.next().getRemarks()+" "+itr.next().getRowNo()+"</div>" +"</div></div>"
				 * +"</div><br>";
				 */
		 		
			
			}
	        
			return hm;
	        
    }
    
    /*** Export BarCode of GRN Item As CSV in Json Format ***/
    @RequestMapping(value = "/exportBarcodeAsCSV", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap exportBarcodeAsCSVDetails(Model model, HttpSession session,@RequestParam ("barcodes") String barcodes) 
    {
    	
	        HashMap<String, Object> hm = new HashMap();
	        HashMap<String, Object> hm1 = null ;
			
		 	List<ChildBarcodeListForCSV> list = barcodeService.getExportBarcodeAsCSVList(barcodes);
		 	List list1=new ArrayList();
		    for(ChildBarcodeListForCSV ch : list)
		    {
		    	System.out.println("hyyy=="+list.size());
		    	hm1= new HashMap();
		    	hm1.put("rowNo", ch.getRowNo());
		    	hm1.put("rowId", ch.getRowId());
		    	hm1.put("brand_text", ch.getBrand_text());
		    	hm1.put("modelNo", ch.getModelNo());
		    	hm1.put("color", ch.getColor());
		    	hm1.put("type_txt", ch.getType_txt());
		    	hm1.put("GRNNumber", ch.getGRNNumber());
		    	hm1.put("location", ch.getLocation());
		    	list1.add(hm1);
		    }
		    hm.put("data",list1);
	      
	        
			return hm;
	        
    }
    
    /*** check BarCode If Match Current Section Or Not in BarCode table ***/
    //@RequestMapping(value="/ckeckSectionOfBarcode",method=RequestMethod.POST)
    /*public @ResponseBody int ckeckSectionOfBarcodeData(@RequestParam ("barcode") String barcode, @RequestParam ("section") String section)
    {
    	int status=0;
    	
    	try
    	{
    		System.out.println(barcode +"   ...34......"+section+" ...........cx...... ");
    		
    		status = barcodeService.ckeckSectionOfBarcode(barcode, section);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    	
        return status;
    }*/
}
