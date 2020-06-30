package com.ssg.dojangfarm.controller.user;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.ssg.dojangfarm.domain.Address;
import com.ssg.dojangfarm.domain.Card;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;

@Controller
@SessionAttributes("addressList")
public class AddressController {
	private static final String LISTADDRESS= "user/AddressListView";
	private static final String VIEWADDRESS = "user/AddressView";
	private static final String ADDADDRESSFORM = "user/CreateAddressFormView";
	private static final String UPDATEADDRESSORM = "user/ModifyAddressFormView";
	
	@Autowired
	private FarmFacade farm;
	
	public void setFarm(FarmFacade  farm) {
		this.farm = farm;
	}
		
	//addressCommand 
	@ModelAttribute("addressCommand")
	public AddressCommand formBacking(HttpServletRequest request) {
		Address address = null;
		
		if(request.getParameter("addrNo") != null) {
			int addrNo = Integer.parseInt(request.getParameter("addrNo"));
			address = this.farm.getAddress(addrNo);
		}
		
		// edit address
		if (address != null) {	
			return new AddressCommand(address.getAddrNo(), address.getAddr(), String.valueOf(address.getZip()), address.getDetail(), address.getaName());
		}
		else {	// create new address
			return new AddressCommand();
		}
	}
	
	//view addressList
	@RequestMapping("/address/getAddressList.do")
	public ModelAndView listAddress(
			HttpServletRequest request) throws Exception {
		
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");

		PagedListHolder<Address> addressList = new PagedListHolder<Address>(this.farm.getAddressList(user.getUserNo()));
		addressList.setPageSize(10);
		
		return new ModelAndView(LISTADDRESS, "addressList", addressList);
	}
	
	//view cardList by page
	@RequestMapping("/address/getAddressList2.do")
	public String listAddress2(
			@RequestParam("page") String page,
			@ModelAttribute("addressList") PagedListHolder<Address> addressList,
			BindingResult result) throws Exception {
		if (addressList== null) {
			throw new IllegalStateException("Cannot find pre-loaded addressList");
		}
		if ("next".equals(page)) { 
			addressList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			addressList.previousPage(); 
		}
		
		return LISTADDRESS;
	}	


	//view address
	@RequestMapping("/address/getAddress.do")
	public ModelAndView viewAddress(
			@RequestParam("addrNo") int addrNo) throws Exception {
		
		Address address = this.farm.getAddress(addrNo);

		return new ModelAndView(VIEWADDRESS, "address", address);
	}
	
	//create address ... form
	@RequestMapping(value="/address/createAddress.do", method=RequestMethod.GET)
	public String addressForm(
			 @ModelAttribute("addressCommand") AddressCommand addressCommand,
			 HttpServletRequest request) {				
		return ADDADDRESSFORM;
	}
	
	//create address ... insert
	@RequestMapping(value="/address/createAddress.do", method=RequestMethod.POST)
	public String insert(
			@Valid @ModelAttribute("addressCommand") AddressCommand addressCommand, 
			BindingResult result,
			HttpServletRequest request) throws Exception {

		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		
		//validate
		if (result.hasErrors()) {
			return ADDADDRESSFORM;
		}
		
		//addressCommand to address
		Address address = new Address();
		address.setUser(user);
		address.setAddr(addressCommand.getAddr());
		address.setZip(Integer.parseInt(addressCommand.getZip()));
		address.setaName(addressCommand.getaName());
		address.setDetail(addressCommand.getDetail());
		
		this.farm.createAddress(address);	

		return "redirect:/address/getAddress.do?addrNo=" + address.getAddrNo();
	}
	
	//update address ... form
	@RequestMapping(value="/address/modifyAddress.do", method=RequestMethod.GET)
	public String updateAddressForm(
			 @ModelAttribute("addressCommand") AddressCommand addressCommand,
			 HttpServletRequest request) {				
		return UPDATEADDRESSORM;
	}
	
	//update address ... update
	@RequestMapping(value="/address/modifyAddress.do", method=RequestMethod.POST)
	public String update(
			@Valid @ModelAttribute("addressCommand") AddressCommand addressCommand, 
			BindingResult result) throws Exception {
		
		//validate
		if (result.hasErrors()) {
			return ADDADDRESSFORM;
		}
		
		//addressCommand to address
		Address address = new Address();
		address.setAddrNo(addressCommand.getAddrNo());
		address.setAddr(addressCommand.getAddr());
		address.setZip(Integer.parseInt(addressCommand.getZip()));
		address.setaName(addressCommand.getaName());
		address.setDetail(addressCommand.getDetail());
		
		this.farm.modifyAddress(address);

		return "redirect:/address/getAddress.do?addrNo=" + address.getAddrNo();
	}
	
	//delete address
	@RequestMapping("/address/deleteAddress.do")
	public String delete(
			@RequestParam("addrNo") int addrNo) throws Exception {
		
		this.farm.deletAddress(addrNo);	

		return "redirect:/address/getAddressList.do";
	}
	
}
