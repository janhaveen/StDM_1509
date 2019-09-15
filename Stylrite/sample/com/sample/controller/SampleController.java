package com.sample.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

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

import com.sample.pojo.Requistion;
import com.sample.pojo.RequistionItem;
import com.sample.pojo.RequistionLog;
import com.sample.pojo.RequistionLogList;
import com.sample.service.SampleService;

@Controller
@WebListener
public class SampleController {

	@Autowired
	private SampleService sampleService;

	public void setSampleService(SampleService sampleService) {
		this.sampleService = sampleService;
	}

	/*** Page Redirect on Sample.jsp ***/
	@RequestMapping(value = "/showNewRequistion", method = RequestMethod.GET)
	public ModelAndView showVendor(ModelAndView model) {
		System.out.println("Hello World");
		model.addObject("requistion", new Requistion());

		model.setViewName("Sample/Sample");

		return model;
	}

	/*** Adding Requistion and Requistion Item ***/
	@PostMapping("/SampleRequistionSave")
	public @ResponseBody int sampleRequistionSave(@ModelAttribute("requistion") Requistion requistion,
			@ModelAttribute("rqitem") RequistionItem rqitem, @RequestParam("count") String count,
			@ModelAttribute("rqlog") RequistionLog rqlog, @RequestParam("rowId") String rowId,
			@RequestParam("action") String action, @RequestParam("RequistionItemID") String RequistionItem,
			@RequestParam("requisitionLogID") String requisitionLogID) {
		int status = 0;
		try {
			requistion.setRowId(rowId);
			rqitem.setRowId(RequistionItem);
			rqitem.setRequisitionId(rowId);
			rqlog.setRowId(requisitionLogID);
			if (count.equals("0")){
				status = sampleService.addSampleNewRequistion(requistion, action, rqlog);
				/* status=sampleService.addSampleRequistion(requistion,action); */

			}
			status = sampleService.addSampleRequistionItem(rqitem, rqlog);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return status;
	}

	/*** Sample Requistion List ***/
	@RequestMapping(value = "/GetRequisitionList", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listSampleRequistion(Model model, HttpSession session) {
		System.out.println("list order");
		HashMap<String, Object> hm = new HashMap<>();
		List listSampleRequistion = sampleService.getAllSampleRequistionList();
		hm.put("data", listSampleRequistion);
		System.out.println("list order " + listSampleRequistion);
		return hm;
	}

	/*** Get Requistion Product List ***/
	@RequestMapping(value = "/GetProductRequisitionList", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listSampleRequistionProduct(Model model, HttpSession session,
			@RequestParam("requisitionId") String requisitionId) {
		System.out.println("list Requistion List");
		HashMap<String, Object> hm = new HashMap<>();
		List listProductSampleRequistion = sampleService.getAllSampleProductRequistionList(requisitionId);
		hm.put("data", listProductSampleRequistion);
		System.out.println("list order " + listProductSampleRequistion);
		return hm;
	}
	
	/*** Get RequistionRemarks history***/
	@RequestMapping(value = "/GetRequisitionRemarksHistory", produces = "text/html", method = RequestMethod.GET)
	public @ResponseBody String getRemarksHistory( Model model,
			HttpSession session, @RequestParam("requisitionId") String requisitionId,
			@RequestParam("start") String start, @RequestParam("limit") String limit) { 
		   String str = "";
		   System.out.println("start" + start + limit);
		   System.out.println("Get RequistionRemarks History");
		   List<RequistionLogList> list23 = sampleService.getAllRemarksHistory(requisitionId, start, limit);
		   System.out.println("list 123..." + list23);
		  for (RequistionLogList object1 : list23) 
	 	   {
			  
	 		System.out.println("dfcvbnm..................."+list23);
	 		
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
	 		str += "<div class='row'>" + "<input type='hidden' id='start' value='" + start + "'>"
					+object1.getCreatedBy_txt() +
					"<div class='col-md-10'>" + object1.getRemarks() + "</div>" + "</div>";
		
		 }
	  /*	Iterator<RequistionLogList> itr = list23.iterator();
	    	System.out.println("irr itr.." + itr);*/
		
	    	/*while (itr.hasNext()) {
			str += "<div class='row'>" + "<input type='hidden' id='start' value='" + start + "'>"
					+itr.next().getCreatedBy_txt() +
					"<div class='col-md-10'>" + itr.next().getRemarks() + "</div>" + "</div>";

	    	}*/
		System.out.println("str...." + str);
		return str;

	}






}
