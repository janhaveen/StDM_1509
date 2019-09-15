package com.sample.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.barcode.pojo.ChildBarcode;
import com.barcode.pojo.ChildBarcodeLog;
import com.product.pojo.Product;
import com.sample.pojo.AvailableStockSalesPerson;
import com.sample.pojo.Requistion;
import com.sample.pojo.RequistionItem;
import com.sample.pojo.RequistionLog;
import com.sample.service.SampleService;

@Controller
@WebListener
public class SampleTransferController {
	@Autowired
	private SampleService sampleService;

	public void setSampleService(SampleService sampleService) {
		this.sampleService = sampleService;
	}
           
	/*** Page Redirect on SampleTransfer.jsp ***/
	@RequestMapping(value="/showSampleTransfer",method=RequestMethod.GET)
	public ModelAndView showSampleTransfer(ModelAndView model) 
	{
		System.out.println("Hello Sample Transfer");
		model.addObject("requistion",new Requistion());
		model.setViewName("SampleTransfer/SampleTRansferMain");
		return model;
	}
	
	 /*** Get Stock Person Sales Wise ***/
	@RequestMapping(value = "/GetStockSalesPerson", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody String getStockSalesPerson(Model model, HttpSession session,@RequestParam("spEmpid") String spEmpid) {
		/*System.out.println("list GetStockSales");
		HashMap<String, Object> hm = new HashMap<>();
		List getStockSalesPerson = sampleService.getStockSalesPerson(spEmpid);
		hm.put("data", getStockSalesPerson);
		System.out.println("Stock Sales Person " +getStockSalesPerson);
		return hm;*/
		
            JSONArray jArray=new JSONArray();
		List<AvailableStockSalesPerson> list= sampleService.getStockSalesPerson(spEmpid);
	    for(int i=0;i<list.size();i++){
	    	JSONObject jsonobj=new JSONObject();
	    	AvailableStockSalesPerson availablestockperson=new AvailableStockSalesPerson();
	    	availablestockperson=list.get(i);
	    	jsonobj.put("rowNo",availablestockperson.getRowNo());
	    	jsonobj.put("empid",availablestockperson.getEmpid());
	    	jsonobj.put("spname",availablestockperson.getSpname());
	    	jsonobj.put("mobileNo",availablestockperson.getMobileNo());
	    	jsonobj.put("rowId",availablestockperson.getRowId());
	    	jsonobj.put("brand_txt",availablestockperson.getBrand_txt());
	    	jsonobj.put("brand",availablestockperson.getBrand());
	    	jsonobj.put("location",availablestockperson.getLocation());
	    	jsonobj.put("productid",availablestockperson.getProductid());
	    	jsonobj.put("sku",availablestockperson.getSku());
	    	jsonobj.put("productinfo",availablestockperson.getProductinfo());
	    	jsonobj.put("modelNo",availablestockperson.getModelNo());
	    	jsonobj.put("skuid",availablestockperson.getSkuid());
	    	jsonobj.put("size", availablestockperson.getSize());
	    	jsonobj.put("color", availablestockperson.getColor());
	    	jsonobj.put("cost", availablestockperson.getCost());
	    	jsonobj.put("type_txt", availablestockperson.getType_txt());
	    	jsonobj.put("availableStock",availablestockperson.getAvailableStock());
	    	jsonobj.put("act","<input type='checkbox' name='cbtdName' class='cbtd' id='cb"+availablestockperson.getProductid()+"'onclick='addThis(this)' value='"+availablestockperson.getRowId()+"'>"); 
	    	
	    	jArray.put(jsonobj);
	    }
	    return jArray.toString();
	    
	}
	
	/*@RequestMapping(value = "/GetStockSalesPerson", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, Object> getStockSalesPerson(Model model, HttpSession session,@RequestParam("spEmpid") String spEmpid) {
		System.out.println("list GetStockSales");
		HashMap<String, Object> hm = new HashMap<>();
		List getStockSalesPerson = sampleService.getStockSalesPersonForTransfer(spEmpid);
		System.out.println(getStockSalesPerson);
		hm.put("data", getStockSalesPerson);
		System.out.println("Stock Sales Person " +getStockSalesPerson);
		return hm;	    
	}*/

	
	/*** Adding Sample Transfer  Requistion and  Sample Transfer Requistion Item ***/
	
	@PostMapping("/ModifyRequisition")
	public @ResponseBody int SampleTransferRequistionSave(@ModelAttribute("requistion")Requistion  requistion,@ModelAttribute("rqitem")RequistionItem rqitem,
			@ModelAttribute("rqlog")RequistionLog rqlog,@RequestParam("requisitionID")String requisitionID,@RequestParam("requisitionLogID")String requisitionLogID,
			@RequestParam("requisitionItemID")String requisitionItemID,@RequestParam("requisitionType")String requisitionType,@RequestParam("requitionstatus")String requitionstatus,
			@RequestParam("action") String action,@RequestParam("count")String count,@RequestParam("requitionItemstatus")String requitionItemstatus)
	{
		  int status=0;
		  if(count.equals("1")) 
		  {
			  status=sampleService.addSampleTransferRequistion(requistion,rqlog,requisitionID,requisitionLogID,requitionstatus,requisitionType,action);
			  
		  }
		  status=sampleService.addSampleTransferRequistionItem(rqitem,requisitionItemID,requisitionID,requitionItemstatus);
		  if(status==1803) {
			  
		  }
		  return status;
		    
	}
	
	/*** update childbarcode location AND INSERT ***/
	@PostMapping("/UpdateChildBarcodeLocation")
	  public @ResponseBody int updateChildBarcodeLocation(@ModelAttribute("childBarcode")ChildBarcode childBarcode,@ModelAttribute("childbarcodelog")ChildBarcodeLog childbarcodelog,
			          @RequestParam("action")String action,@RequestParam("cdRowId") String cdRowId,@RequestParam("refid") String refid,@RequestParam("oldlocation") String oldlocation,
			          @RequestParam("location")String location)
	  {
		  int status=0;
		  System.out.println("hello11");
		  try {
			  status=sampleService.updateChildBarcodeLocation(childBarcode,childbarcodelog,cdRowId,action,refid,oldlocation,location);
			  
			 /* status=sampleService.addSampleChildBarcodeLog(childbarcodelog,cdRowId,refid,oldlocation,location);*/
			  System.out.println("status is "+status);
			 
			  
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		return status;
		
	  }
	 
   

	
}
