package com.ssg.dojangfarm.controller.auction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.dojangfarm.domain.Address;
import com.ssg.dojangfarm.domain.Auction;
import com.ssg.dojangfarm.domain.Bid;
import com.ssg.dojangfarm.domain.Card;
import com.ssg.dojangfarm.domain.Delivery;
import com.ssg.dojangfarm.domain.ImPur;
import com.ssg.dojangfarm.domain.Payment;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;

@Controller
@SessionAttributes("imPurList")
public class ImPurController {
	private static final String LISTIMPUR = "auction/MyImPurListView";
	private static final String VIEWIMPUR = "auction/MyImPurView";
	private static final String IMPURFORM = "auction/ImPurFormView";
	private static final String IMPURSUCCESS = "auction/ImPurSuccessView";
	
	@Autowired
	private FarmFacade farm;
	
	public void setFarm(FarmFacade  farm) {
		this.farm = farm;
	}
	
	//ImPurCommand
	@ModelAttribute("imPurCommand")
	public ImPurCommand formBacking() {
		return new ImPurCommand();
	}
	
	//view myImPurList
	@RequestMapping("/auction/viewMyImPurList.do")
	public String listMyImPur(
			ModelMap model,
			HttpServletRequest request) throws Exception {
		
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");

		PagedListHolder<ImPur> imPurList = new PagedListHolder<ImPur>(this.farm.getMyImPurList(user.getUserNo()));	//add dao

		imPurList.setPageSize(10);
		model.put("imPurList", imPurList);
		return LISTIMPUR;
	}
	

	//view myImPurList by page
	@RequestMapping("/auction/viewMyImPurList2.do")
	public String listMyImPur2(
			@RequestParam("page") String page,
			@ModelAttribute("imPurList") PagedListHolder<ImPur> imPurList,
			BindingResult result) throws Exception {
		if (imPurList== null) {
			throw new IllegalStateException("Cannot find pre-loaded imPurList");
		}
		if ("next".equals(page)) { 
			imPurList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			imPurList.previousPage(); 
		}
			
		return LISTIMPUR;
	}

		
	//view myImPur
	@RequestMapping("/auction/viewMyImPur.do")
	public String viewMyImPur(
			@RequestParam("imPurNo") int imPurNo,
			ModelMap model) throws Exception {
			
		ImPur imPur = this.farm.getMyImPur(imPurNo);	
		model.put("imPur", imPur);
			
		return VIEWIMPUR;
	}	
	
	//ImPur ... ImPur form
	@RequestMapping(value = "/auction/immePurchase.do",  method = RequestMethod.GET)
	public String imPurForm(
			@ModelAttribute("imPurCommand") ImPurCommand imPurCommand,
			@RequestParam("aNo") int aNo,
			ModelMap model) throws Exception {
		
		Auction auction = this.farm.getAuction(aNo);
		
		model.put("auction", auction);

		return IMPURFORM;
	}
	
	//Bid ... insertBid
	@RequestMapping(value = "/auction/immePurchase.do",  method = RequestMethod.POST)
	public ModelAndView imPur(
		@RequestParam("aNo") int aNo,
		@ModelAttribute("imPurCommand") ImPurCommand imPurCommand,
		BindingResult bindingResult,
		HttpServletRequest request) throws Exception {
			
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		
		Auction auction = this.farm.getAuction(aNo);
		
		Card card = this.farm.getCard(imPurCommand.getCardNo());

		if(card == null) {
			bindingResult.rejectValue("cardNo", "nocardNo");
			return new ModelAndView(IMPURFORM, "auction", auction);
		}
		
		Address address = this.farm.getAddress(imPurCommand.getAddrNo());
		
		if(address == null) {
			bindingResult.rejectValue("addrNo", "noaddressNo");
			return new ModelAndView(IMPURFORM, "auction", auction);
		
		}	
		
		Payment payment = new Payment();
		payment.setCard(card);
		payment.setTotalPrice(auction.getImPurPrice());
		
		Delivery delivery = new Delivery();
		delivery.setAddress(address);
		
		ImPur imPur = new ImPur();
		imPur.setAuction(auction);
		imPur.setPayment(payment);
		imPur.setUser(user);
		imPur.setDelivery(delivery);
			
		this.farm.immePurchase(imPur);	

		return new ModelAndView(IMPURSUCCESS, "imPur", imPur);
	}
}
