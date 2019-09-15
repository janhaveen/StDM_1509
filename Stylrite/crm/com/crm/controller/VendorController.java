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

import com.crm.pojo.Vendor;
import com.crm.pojo.VendorAddress;
import com.crm.pojo.VendorContactPerson;
import com.crm.service.VendorService;

@Controller
@WebListener
public class VendorController 
{
    @Autowired
    private VendorService vendorService;
    
    /*** Page Redirect on vendor.jsp ***/
    @RequestMapping(value = "/showVendor", method = RequestMethod.GET)
    public ModelAndView showVendor(ModelAndView model) 
    {
        model.addObject("vendor", new Vendor());
        
        model.setViewName("vendor/Vendor");
        
        return model;
    }
//*** Creating a add new Client ***//*
    @PostMapping("/vendorRegister")
    public @ResponseBody int registerClient(@ModelAttribute("vendor") Vendor  vendor, BindingResult br,
            @RequestParam("action") String action) {
        System.out.println(vendor + " ");
        System.out.println(action + " ");
        int status = 0;
        status = vendorService.addVendor(vendor, action);
        return status;
    }
    @PostMapping("/vendorAddressRegister")
    public @ResponseBody int registerClientAddress(@ModelAttribute("vaddress") VendorAddress vaddress,
            BindingResult br) {
        System.out.println(vaddress + " ");
        int status = 0;
        status = vendorService.addVendorAddress(vaddress);
        return status;
    }
    @PostMapping("/VendorPersonRegister")
    public @ResponseBody int registerVendorContactPerson(@ModelAttribute("vperson") VendorContactPerson vperson,
            BindingResult br)
    {
        System.out.println(vperson + " ");
        int status = 0;
        status = vendorService.addVendorContactPerson(vperson);
        return status;
    }
    
    /*** Listing Client List in Json Format ***/
    @RequestMapping(value = "/GetVendorList", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody HashMap listClientList(Model model, HttpSession session) {
        HashMap<String, Object> hm = new HashMap();
        List listVendor = vendorService.getAllVendorList();
        System.out.println("listClient" + listVendor);
        // mv.addAttribute("listCustomers", listCustomers);
        hm.put("data", listVendor);
        hm.put("status", "200");
        return hm;
    }
    /*** Listing VendorAddress List in Json Format ***/
    @RequestMapping(value = "/GetVendorAddressList", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody HashMap listVendorAddressList(Model model, HttpSession session,@RequestParam("vendorId")String ClientId) {
        HashMap<String, Object> hm = new HashMap();
        List listVAddress = vendorService.getAllVendorAddressList(ClientId);
        System.out.println("listAddressClient" + listVAddress);
        // mv.addAttribute("listCustomers", listCustomers);
        hm.put("data", listVAddress);
        hm.put("status", "200");
        return hm;
    }
    /*** Listing VendorContactPerson List in Json Format ***/
    @RequestMapping(value = "/GetVendorContactPersonList", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody HashMap listVendorContactPersonList(Model model, HttpSession session,@RequestParam("vendorId")String vendorId) {
        HashMap<String, Object> hm = new HashMap();
        List listVContactPerson = vendorService.getAllVendorContactPersonList(vendorId);
        System.out.println("listContactPerson" + listVContactPerson);
        // mv.addAttribute("listCustomers", listCustomers);
        hm.put("data", listVContactPerson);
        hm.put("status", "200");
        return hm;
    }
    /*** Updating Vendor ***/
    @PostMapping("/updateVendor")
    public @ResponseBody int updateVendor(@ModelAttribute("vendor") Vendor vendor, BindingResult br,
            @RequestParam("action") String action) {
        System.out.println(vendor + " ");
        System.out.println(action + " ");
        int status = 0;
        status = vendorService.updateVendor(vendor, action);
        return status;
    }
    
    /*** Updating  Vendor  Address Details ***/
    @PostMapping("/vendorUpdateAddressDetails")
    public @ResponseBody int updateVendorAddressDetails(@ModelAttribute("vaddress") VendorAddress vaddress,
            BindingResult br,@RequestParam("action") String action) {
        System.out.println(vaddress + " ");
        int status = 0;
        status = vendorService.updateVendorAddressDetails(vaddress,action);
        return status;
    }
             
    /*** Updating Vendor Contact Details ***/
    @PostMapping("/vendorUpdateContactDetails")
    public @ResponseBody int updateVendorContactDetails(@ModelAttribute("vperson") VendorContactPerson vperson,
            BindingResult br, @RequestParam("action") String action) {
        System.out.println(vperson + " ");
        System.out.println(action + " ");
        int status = 0;
        status = vendorService.updateVendorContactDetail(vperson,action);
        return status;
    }
    /*** Adding  New  VendorContact Details ***/
	@PostMapping("/newVendorContactDetails")
	public @ResponseBody int newClientContactPersonDetails(@ModelAttribute("vperson") VendorContactPerson vperson,
			BindingResult br,@RequestParam("action") String action) {
		System.out.println(vperson + " ");

		int status = 0;

		status = vendorService.addNewVendorContactPersonDetails(vperson,action);

		return status;
	}
	/*** Adding  New Address ***/
	@PostMapping("/newVendorAddressDetails")
	public @ResponseBody int NewClientAddressDetails(@ModelAttribute("vaddress") VendorAddress vaddress,
			BindingResult br,@RequestParam("action") String action) {
		System.out.println(vaddress + " ");

		int status = 0;

		status = vendorService.addNewVendorAddressDetails(vaddress,action);

		return status;
	}
	/*** Deleting the Vendor ***/
	@RequestMapping(value="/DeletedVendor",method=RequestMethod.POST)
	public @ResponseBody int deleteVendor(@RequestParam("rowId")String vendorId,Vendor vendor) {
		int status=0;
		System.out.println("( in Delete Vendor ");
		try {
			status=vendorService.deleteVendor(vendorId,vendor);
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Vendor status delete "+status);
		return status;
	}
	
	/*** Deleting the Vendor ContactPerson List ***/
	@RequestMapping(value="/deleteVendorContactPersonDetails",method=RequestMethod.POST)
	public @ResponseBody int deleteVendorContactPersonList(@RequestParam("rowId")String vendorId,VendorContactPerson vperson) {
		int status=0;
		System.out.println("( in Delete Vendor Contact Person List ");
		System.out.println("controller"+vendorId);
		try {
			status=vendorService.deleteVendorContactPersonList(vendorId,vperson);
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Vendor Contact Person List status delete "+status);
		return status;
	}
	
	/*** Deleting the Vendor Address List ***/
	@RequestMapping(value="/deleteVendorAddress",method=RequestMethod.POST)
	public @ResponseBody int deleteVendorAddressList(@RequestParam("rowId")String vendorId,VendorAddress vaddress) {
		int status=0;
		System.out.println("( in Delete Vendor Address  List ");
		try {
			status=vendorService.deleteVendorAddressList(vendorId,vaddress);
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Vendor address  status delete "+status);
		return status;
	}
}