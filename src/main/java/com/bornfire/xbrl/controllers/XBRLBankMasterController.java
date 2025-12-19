package com.bornfire.xbrl.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bornfire.xbrl.entities.BankMaster;
import com.bornfire.xbrl.entities.BRBS.BRBS_CONTACT_DETAILS_ENTITY;
import com.bornfire.xbrl.services.BankServices;
 


@Controller
public class XBRLBankMasterController {

	
	@Autowired
	BankServices bankmasterRepServices;
 
	@RequestMapping(value = "bankmasteredit", method = RequestMethod.POST)
	@ResponseBody
	public String bankmasteredit(@ModelAttribute("singledetail") BankMaster detail,  HttpServletRequest hs) {
		System.out.println("abcd");
		String userid = (String) hs.getSession().getAttribute("USERID");
		return bankmasterRepServices.detailChanges(detail, 'E', userid);
		
	}
	
	
	
	@RequestMapping(value = "bankmasteradd", method = RequestMethod.POST)
	@ResponseBody
	public String bankmasterAdd(@ModelAttribute("singledetail") BankMaster detail,  HttpServletRequest hs) {
		String userid = (String) hs.getSession().getAttribute("USERID");
		System.out.println("abcd");
		return bankmasterRepServices.detailChanges(detail, 'A',userid);
		
	}
	
	
	@RequestMapping(value = "bankmasterdelete", method = RequestMethod.POST)
	@ResponseBody
	public String bankmasterDelete(@ModelAttribute("singledetail") BankMaster detail,  HttpServletRequest hs) {
		String userid = (String) hs.getSession().getAttribute("USERID");
		return bankmasterRepServices.detailChanges(detail, 'D',userid);
		
	}
	
	@RequestMapping(value = "CONTACT", method = RequestMethod.POST)
	@ResponseBody
	public String CONTACT(@ModelAttribute("singledetail") BRBS_CONTACT_DETAILS_ENTITY detail,HttpServletRequest hs) {
		//String userid = (String) hs.getSession().getAttribute("USERID");
		System.out.println("inside conto;ller"+detail.getContact_name());
		
		 
		return  bankmasterRepServices.RBSCONTACT(detail,'A') ;
		
	}
	
	@RequestMapping(value = "CONTACTEDIT", method = RequestMethod.POST)
	@ResponseBody
	public String CONTACTEDIT(@ModelAttribute("singledetail") BRBS_CONTACT_DETAILS_ENTITY detail,HttpServletRequest hs) {
		//String userid = (String) hs.getSession().getAttribute("USERID");
		//System.out.println("inside conto;ller"+detail.getCONTACT_NAME());
		//System.out.println("outside conto;ller"+detail.getDesignation());
		 
		return  bankmasterRepServices.RBSCONTACT(detail,'E') ;
		
	}
	@RequestMapping(value = "CONTACTDELETE", method = RequestMethod.POST)
	@ResponseBody
	public String CONTACTDELETE(@ModelAttribute("singledetail") BRBS_CONTACT_DETAILS_ENTITY detail,HttpServletRequest hs) {
		//String userid = (String) hs.getSession().getAttribute("USERID");
		//System.out.println("inside conto;ller"+detail.getCONTACT_NAME());
		
		 
		return  bankmasterRepServices.RBSCONTACT(detail,'D') ;
		
	}
	
}
