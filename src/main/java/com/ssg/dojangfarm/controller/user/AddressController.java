package com.ssg.dojangfarm.controller.user;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.dojangfarm.domain.Address;
import com.ssg.dojangfarm.domain.Card;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;

public class AddressController {
	private static final String LISTADDRESS= "address/AddressListView";
	private static final String VIEWADDRESS = "address/AddressView";
	private static final String ADDADDRESSFORM = "address/CreateAddressFormView";
	private static final String UPDATEADDRESSORM = "address/ModifyAddressFormView";
	
	private FarmFacade farm;
	
	@Autowired
	public void setFarm(FarmFacade  farm) {
		this.farm = farm;
	}
	
	//addressCommand 
	@ModelAttribute("addressCommand")
	public AddressCommand formBacking() {
		return new AddressCommand();
	}
	
	//view addressList
	@RequestMapping("/address/getAddressList.do")
	public ModelAndView listMyAuction(
			HttpServletRequest request) throws Exception {
		
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");

		PagedListHolder<Address> addressList = new PagedListHolder<Address>(this.farm.getAddressList(user.getUserNo()));
		addressList.setPageSize(4);
		
		return new ModelAndView(LISTADDRESS, "addressList ", addressList);
	}
	
/*	//view cardList by page
	@RequestMapping("/auction/viewMyAuctionList2.do")
	public String listMyAuction2(
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
*/

	//view address
	@RequestMapping("/address/getAddress.do")
	public ModelAndView viewAuction(
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
			@ModelAttribute("addressCommand") AddressCommand addressCommand, 
			BindingResult result,
			HttpServletRequest request) throws Exception {

		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		
		//validate
		if (result.hasErrors()) {
			return ADDADDRESSFORM;
		}
		
		//커맨드객체 - 실제객체 ?????????
		Address address = new Address();
		
		this.farm.createAddress(address);	

		return "redirect:/address/viewAddress.do?addrNo=" + address.getAddrNo();
	}
	
	//같은 커멘드객체 쓰는건가...
	//update address ... form
	//@RequestMapping(value="/address/modifyAddress.do", method=RequestMethod.GET)
	public String updateAddressForm(
			 @ModelAttribute("addressCommand") AddressCommand addressCommand,
			 HttpServletRequest request) {				
		return UPDATEADDRESSORM;
	}
	
	//update address ... update
	@RequestMapping(value="/address/modifyAddress.do", method=RequestMethod.POST)
	public String update(
			@RequestParam("bank") String bank,
			@RequestParam("type") String type,
			@RequestParam("cardPayNo") String cardPayNo,
			@RequestParam("period") Date period,
			@RequestParam("cvc") int cvc,
			@RequestParam("cardPW") String cardPW,
			HttpServletRequest request,
			BindingResult result) throws Exception {

		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		
		//cardPayNo is unique
//		if(this.farm.checkCardPayNo(cardPayNo) != null) {
//			result.rejectValue("cardPayNo", "invalidCardPayNo", new Object[] { request.getParameter("cardPayNo") }, null);
//
//			return CARDFORM;
//		}
		
		Card card = new Card(user, bank, cardPW, period, cvc, type, cardPayNo);
		
		this.farm.insertCard(card);	

		return "redirect:/card/viewCard.do?cardNo=" + card.getCardNo();
	}
	
	//delete address
//	@RequestMapping("/address/deleteAddress.do")
//	public String register(
//			@ModelAttribute("addressCommand") AddressCommand addressCommand, 
//			BindingResult result) throws Exception {
//		
//		//validate
//		if (result.hasErrors()) {
//			return ADDADDRESSFORM;
//		}
//		
//		//커맨드객체 - 실제객체 ?????????	
//		//aNo를 리퀘스트.파람으로 받을 것인가 커맨드객체에 담을 것인가.....
//		this.farm.modifyAddress(aNo, addressCommand.getaName(), addressCommand.getAddress(), addressCommand.getZip(), addressCommand.getDetail());
//
//		return "redirect:/address/viewAddress.do?addrNo=" + aNo;
//	}
	
}
