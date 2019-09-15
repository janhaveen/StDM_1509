package com.crm.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

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

import com.crm.pojo.Client;
import com.crm.pojo.ClientAddress;
import com.crm.pojo.ClientContactPerson;
import com.crm.service.ClientService;


@Controller
@WebListener
public class ClientController
{

	@Autowired
	private ClientService clientService;

	public void setClientService(ClientService clientService)
	{
		this.clientService = clientService;
	}

	/*** Page Redirect on Client.jsp ***/
	@RequestMapping(value = "/showClient", method = RequestMethod.GET)
	public ModelAndView showVendor(ModelAndView model) {
		System.out.println("Hello World");
		model.addObject("client", new Client());

		model.setViewName("Client/client");

		return model;
	}

	/*** Creating a add new Client ***/
	@PostMapping("/clientRegister")
	public @ResponseBody int registerClient(@ModelAttribute("client") Client client, BindingResult br,
			@RequestParam("action") String action) {
		System.out.println(client + " ");

		System.out.println(action + " ");

		int status = 0;

		status = clientService.addClient(client, action);

		return status;
	}

	@PostMapping("/clientAddressRegister")
	public @ResponseBody int registerClientAddress(@ModelAttribute("caddress") ClientAddress caddress,BindingResult br, @RequestParam("isDefault") boolean isDefault)
	{
		System.out.println(caddress + " Add");

		int status = 0;

		status = clientService.addClientAddress(caddress, isDefault);

		return status;
	}

	@PostMapping("/contactPersonRegister")
	public @ResponseBody int registerClientContactPerson(@ModelAttribute("cperson") ClientContactPerson cperson,BindingResult br, @RequestParam("isDefault") boolean isDefault) 
	{
		System.out.println(cperson + " CP");

		int status = 0;

		status = clientService.addClientContactPerson(cperson, isDefault);

		return status;
	}
	@PostMapping("/newContactDetails")
	public @ResponseBody int newClientContactPersonDetails(@ModelAttribute("cperson") ClientContactPerson cperson, BindingResult br,@RequestParam("action") String action, @RequestParam("isDefault") boolean isDefault) 
	{
		System.out.println(cperson + " ");

		int status = 0;

		status = clientService.addNewClientContactPersonDetails(cperson,action, isDefault);

		return status;
	}
	@PostMapping("/newAddressDetails")
	public @ResponseBody int NewClientAddressDetails(@ModelAttribute("caddress") ClientAddress caddress, BindingResult br,@RequestParam("action") String action, @RequestParam("isDefault") boolean isDefault) 
	{
		System.out.println(isDefault + " ");

		int status = 0;

		status = clientService.addNewClientAddressDetails(caddress,action, isDefault);

		return status;
	}

	/*** Updating Client ***/
	@PostMapping("/updateClient")
	public @ResponseBody int updateClient(@ModelAttribute("client") Client client, BindingResult br,
			@RequestParam("action") String action) {
		System.out.println(client + " ");

		System.out.println(action + " ");

		int status = 0;

		status = clientService.updateClient(client, action);

		return status;
	}

	/*** Updating Client Address Details ***/
	@PostMapping("/clientUpdateAddressDetails")
	public @ResponseBody int updateClientAddressDetails(@ModelAttribute("caddress") ClientAddress caddress,
			BindingResult br,@RequestParam("action") String action, @RequestParam("isDefault") boolean isDefault) {
		System.out.println(caddress + " ");

		int status = 0;

		status = clientService.updateClientAddressDetails(caddress,action,isDefault);

		return status;
	}

	/*** Updating Client Contact Details ***/
	@PostMapping("/clientUpdateContactDetails")
	public @ResponseBody int updateClientContactDetails(@ModelAttribute("cperson") ClientContactPerson cperson,BindingResult br, @RequestParam("action") String action, @RequestParam("isDefault") boolean isDefault) 
	{
		System.out.println(cperson + " ");

		System.out.println(action + " ");

		int status = 0;

		status = clientService.updateClientContactDetail(cperson,action, isDefault);

		return status;
	}

	/*** Listing Client List in Json Format ***/
	@RequestMapping(value = "/GetClientList", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listClientList(Model model, HttpSession session) {

		HashMap<String, Object> hm = new HashMap();

		List listClient = clientService.getAllClientList();

		System.out.println("listClient" + listClient);

		// mv.addAttribute("listCustomers", listCustomers);

		hm.put("data", listClient);

		hm.put("status", "200");

		return hm;

	}
	/*** Listing ClientAddress List in Json Format ***/
	@RequestMapping(value = "/GetAddressList", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listClientAddressList(Model model, HttpSession session,@RequestParam("clientId")String ClientId) {

		HashMap<String, Object> hm = new HashMap();

		List listAddress = clientService.getAllClientAddressList(ClientId);

		System.out.println("listAddressClient" + listAddress);

		// mv.addAttribute("listCustomers", listCustomers);

		hm.put("data", listAddress);

		hm.put("status", "200");

		return hm;

	}
	/*** Listing ClientContactPerson  List in Json Format ***/
	@RequestMapping(value = "/GetContactPersonList", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody HashMap listClientContactPersonList(Model model, HttpSession session,@RequestParam("clientId")String ClientId) {

		HashMap<String, Object> hm = new HashMap();

		List listContactPersonList = clientService.getAllClientContactPersonList(ClientId);

		System.out.println("listClientContactPerson" + listContactPersonList);

		// mv.addAttribute("listCustomers", listCustomers);

		hm.put("data", listContactPersonList);

		hm.put("status", "200");

		return hm;

	}

	  @RequestMapping(value="/listCustomerInfo", produces="application/json",method=RequestMethod.GET)
		public @ResponseBody HashMap listCustmerInfo(Model model,HttpSession session,@RequestParam("rowNo") int  rowNo) 
	    {
	    		HashMap<String, Object> hm = new HashMap();
			
			 	List listCustomersInfo = clientService.getAllCustomerInfo(rowNo);
		        
		        //mv.addAttribute("listCustomers", listCustomers);
		        
		        hm.put("data", listCustomersInfo);
		        System.out.println("list of customers"+listCustomersInfo);
		        
		        return hm ;
			
		}
}
