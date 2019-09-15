package com.audit.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
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

import com.audit.pojo.Audit;
import com.audit.pojo.AuditItem;
import com.audit.pojo.AuditItemDetailsView;
import com.audit.service.AuditService;

@Controller
@WebListener
public class AuditController 
{
    @Autowired
    private AuditService auditService;
    
	
    /*** Page Redirect on audit.jsp ***/
	@RequestMapping(value = "/showCreateAudit", method = RequestMethod.GET)
    public ModelAndView showAudit(ModelAndView model) 
    {
        model.addObject("audit", new Audit());
        
        model.setViewName("Audit/audit");
        
		return model;
    }
	
    /*** Creating a add new Audit ***/
    @PostMapping("/continueAndCreateAuditReason")
    public @ResponseBody int continueAndCreateAuditReasonData(@ModelAttribute("audit") Audit audit, BindingResult br) 
    {
    	System.out.println(audit+" ");
    	
    	int status = 0;
    	
    	try
    	{
    		 status = auditService.createAuditReason(audit);
    	}
    	catch (Exception e)
    	{
			e.printStackTrace();
		}
    	
        return status;
    }
    
    /*** Page Redirect on viewAudit.jsp ***/
   	@RequestMapping(value = "/viewAudit", method = RequestMethod.GET)
       public ModelAndView viewAudit(ModelAndView model, @RequestParam("auditId") String auditId, @RequestParam("section") String section) 
       {
           model.addObject("auditId",auditId);
           
           model.addObject("section",section);
           
           model.setViewName("Audit/viewAudit");
           
   		return model;
       }
   	
    /*** Page Redirect on viewAuditListDetails.jsp ***/
   	@RequestMapping(value = "/viewAuditListDetails", method = RequestMethod.GET)
       public ModelAndView viewAuditListDetails(ModelAndView model, @RequestParam("auditId") String auditId) 
       {
           model.addObject("auditId",auditId);
           
           model.setViewName("Audit/viewAuditListDetails");
           
   		return model;
       }
    
    /*** Audit View Details in Json Format ***/
    @RequestMapping(value = "/getAuditViewData", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap viewAuditData(Model model, HttpSession session, @RequestParam ("auditId") String auditId) 
    {
    	   System.out.println("sdffvbc................."+auditId);
    	
	        HashMap<String, Object> hm = new HashMap();
			
		 	List list = auditService.viewAuditDetails(auditId);
	        
	        hm.put("data", list);
	        
			return hm;
	        
    }
	
    
    /*** Current Section of BarCode in Json Format ***/
    @RequestMapping(value = "/getCurrentSectionOfBarCode", method = RequestMethod.GET)
    public @ResponseBody int CurrentSectionOfBarCodeData(Model model, HttpSession session, @RequestParam ("section") String section) 
    {
    	
    	System.out.println(section+" ");
    	
    	int status = 0;
    	
    	try
    	{
    		 status = auditService.getCurrentSectionData(section);
    	}
    	catch (Exception e)
    	{
			e.printStackTrace();
		}
    	
        return status;
    }
    
    /*** Creating a add new Audit Item ***/
	  @PostMapping("/saveAuditItem") 
	  public @ResponseBody int saveAuditItemData(@ModelAttribute("auditItem") AuditItem auditItem, BindingResult br, @RequestParam ("auditItemArray") JSONArray auditItemArray)
	  {
		  //System.out.println(grnId+"................i");
		  
		  int status = 0;

		  try 
		  {
				 status =  auditService.saveAuditItem(auditItemArray);
		  } 
		  catch (Exception e) 
		  {
			  e.printStackTrace();
		  }
		  
		  return status; 
	  }
	  
	  /*** update Items Audited in Audit Table ***/
	    @PostMapping("/updateItemsAuditedData")
	    public @ResponseBody int updateItemsAuditedData(@ModelAttribute("audit") Audit audit, BindingResult br,@RequestParam ("itemsAuditedArray") JSONArray itemsAuditedArray) 
	    {
	    	//System.out.println(audit+" ");
	    	
	    	int status = 0;
	    	
	    	try
	    	{
	    		 status = auditService.updateItemsAudited(audit, itemsAuditedArray);
	    	}
	    	catch (Exception e)
	    	{
				e.printStackTrace();
			}
	    	
	        return status;
	    }
 
	    /*** update Items Corrected in Audit Table ***/
	    @PostMapping("/updateItemsCorrectedData")
	    public @ResponseBody int updateItemsCorrectedData(@ModelAttribute("audit") Audit audit, BindingResult br,@RequestParam ("itemsCorrectedArray") JSONArray itemsCorrectedArray) 
	    {
	    	//System.out.println(audit+" ");
	    	
	    	int status = 0;
	    	
	    	try
	    	{
	    		 status = auditService.updateItemsCorrected(audit, itemsCorrectedArray);
	    	}
	    	catch (Exception e)
	    	{
				e.printStackTrace();
			}
	    	
	        return status;
	    }
	    
	    /*** update Items Duplicated in Audit Table ***/
	    @PostMapping("/updateItemsDuplicatedData")
	    public @ResponseBody int updateItemsDuplicatedData(@ModelAttribute("audit") Audit audit, BindingResult br,@RequestParam ("itemsDuplicatedArray") JSONArray itemsDuplicatedArray) 
	    {
	    	//System.out.println(audit+" ");
	    	
	    	int status = 0;
	    	
	    	try
	    	{
	    		 status = auditService.updateItemsDuplicated(audit, itemsDuplicatedArray);
	    	}
	    	catch (Exception e)
	    	{
				e.printStackTrace();
			}
	    	
	        return status;
	    }
	    
	    /*** update Items IsEdited Audit Item Table ***/
	    @PostMapping("/updateIsEditedAuditItemData")
	    public @ResponseBody int updateIsEditedAuditItemData(@ModelAttribute("auditItem") AuditItem auditItem, BindingResult br,@RequestParam ("updateIsEditedAuditItemArray") JSONArray updateIsEditedAuditItemArray) 
	    {
	    	//System.out.println(audit+" ");
	    	
	    	int status = 0;
	    	
	    	try
	    	{
	    		 status = auditService.updateIsEditedAuditItem(auditItem, updateIsEditedAuditItemArray);
	    	}
	    	catch (Exception e)
	    	{
				e.printStackTrace();
			}
	    	
	        return status;
	    }
	    
	    /*** Page Redirect on auditList.jsp ***/
		@RequestMapping(value = "/showAuditList", method = RequestMethod.GET)
	    public ModelAndView showProduct(ModelAndView model) 
	    {
	        model.addObject("audit", new Audit());
	        
	        model.setViewName("Audit/auditList");
	        
			return model;
	    }
		
		 /*** Listing Audit List in Json Format ***/
	    @RequestMapping(value = "/getAuditListData", produces = "application/json", method = RequestMethod.GET)
		public @ResponseBody HashMap getAuditListData(Model model, HttpSession session) 
	    {
	    	
		        HashMap<String, Object> hm = new HashMap();
				
			 	List list = auditService.getAuditList();
		        
		        hm.put("data", list);
		        
				return hm;
		        
	    }
	    
	    /*** Listing Audit Item Details View List in Json Format ***/
	    @RequestMapping(value = "/getAuditItemDetailsView", produces = "application/json", method = RequestMethod.GET)
		public @ResponseBody HashMap getAuditItemDetailsViewData(Model model, HttpSession session,@RequestParam ("auditId") String auditId) 
	    {
	    	
		        HashMap<String, Object> hm = new HashMap();
				
			 	List list = auditService.getAuditItemDetailsViewList(auditId);
		        
		        hm.put("data", list);
		        
				return hm;
		        
	    }
	    
	    /*** Export AuditItem As CSV in Json Format ***/
	    @RequestMapping(value = "/exportAuditItemAsCSV", produces = "application/json", method = RequestMethod.GET)
		public @ResponseBody HashMap exportAuditItemAsCSVDetails(Model model, HttpSession session,@RequestParam ("auditItem") String auditItem) 
	    {
	    	
		        HashMap<String, Object> hm = new HashMap();
				
			 	List<AuditItemDetailsView> list = auditService.getExportAuditItemAsCSVList(auditItem);
		        
		        hm.put("data", list);
		        
				return hm;
		        
	    }
	    
	    /*** update isInCorrectedLocation in Audit Item Table ***/
	    @PostMapping("/isInCorrectedLocationData")
	    public @ResponseBody int isInCorrectedLocationData(@ModelAttribute("auditItem") AuditItem auditItem, BindingResult br,@RequestParam ("isInCorrectedLocationArray") JSONArray isInCorrectedLocationArray) 
	    {
	    	//System.out.println(audit+" ");
	    	
	    	int status = 0;
	    	
	    	try
	    	{
	    		 status = auditService.updateInCorrectedLocationAuditItem(auditItem, isInCorrectedLocationArray);
	    	}
	    	catch (Exception e)
	    	{
				e.printStackTrace();
			}
	    	
	        return status;
	    }
}
