package com.sample.controller;

import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.barcode.pojo.ChildBarcode;
import com.barcode.pojo.ChildBarcodeLog;
import com.sample.pojo.Requistion;
import com.sample.pojo.RequistionItem;
import com.sample.pojo.RequistionLog;
import com.sample.service.SampleService;

@Controller
@WebListener
public class SampleReturnController {
	@Autowired
	private SampleService sampleService;

	public void setSampleService(SampleService sampleService) {
		this.sampleService = sampleService;
	}
	/*** Page Redirect on SampleReturn.jsp ***/
 @RequestMapping(value="/showSampleReturn",method=RequestMethod.GET)
 public ModelAndView showSampleReturn(ModelAndView model) {
	 System.out.println("hello Sample Return");
	 model.addObject("requsition",new Requistion());
	 model.setViewName("SampleReturn/SampleReturnMain");
	 return model;
 }
 
 
  @PostMapping("/ModifyRequisitionSampleReturn")
     public @ResponseBody int sampleReturnRequistionSave(@ModelAttribute("requistion")Requistion requistion,
    		 @ModelAttribute("rqlog")RequistionLog rqlog ,@ModelAttribute("rqitem")RequistionItem rqitem,
    		 @RequestParam("requisitionID")String requisitionID,@RequestParam("requisitionLogID")String requisitionLogID,
    		 @RequestParam("requisitionItemID") String requisitionItemID,@RequestParam("requistionstatus") String requistionstatus,
    		  @RequestParam("requitionItemstatus")String requitionItemstatus,@RequestParam("action")String action,
    		  @RequestParam("count") String count,@RequestParam("requisitionType")String requisitionType,@RequestParam("salesperson")String salesperson)
     {
	  int status=0;
	  if(count.equals("1")) {
		  status=sampleService.addSampleReturnRequistion(requistion,rqlog,requisitionID,requisitionLogID,requisitionType,requistionstatus,action,salesperson);
	  }
	  status=sampleService.addSampleReturnRequistionItem(rqitem,requisitionID,requisitionItemID,requitionItemstatus);
	  return status;
	 
     }
	    @PostMapping("/UpdateChildBarcodeSampleReturn")
	    public @ResponseBody int updateChildBarcodeSampleReturn(@ModelAttribute("childbarcode")ChildBarcode childbarcode,
	    		@ModelAttribute("cblog")ChildBarcodeLog cblog,@RequestParam("requisitionitemid")String requisitionitemid,
	    		@RequestParam("action")String action,@RequestParam("barcode")String barcode) 
	    {
	    	int status=0;
	    	status=sampleService.upadateChildBarcodeSampleReturn(childbarcode,cblog,barcode,action,requisitionitemid);
	    	return status;
	    }
}
