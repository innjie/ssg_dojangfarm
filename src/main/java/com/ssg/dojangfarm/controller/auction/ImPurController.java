package com.ssg.dojangfarm.controller.auction;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
import com.ssg.dojangfarm.service.KakaoPay;

@Controller
@SessionAttributes("imPurList")
public class ImPurController {
	private static final String LISTIMPUR = "auction/MyImPurListView";
	private static final String VIEWIMPUR = "auction/MyImPurView";
	private static final String IMPURFORM = "auction/ImPurFormView";
	private static final String IMPURSUCCESS = "auction/ImPurSuccessView";
	private static final String IMPURFAIL = "auction/BidFailView";
	private static final String IMPURKAKAOFORM = "auction/ImPurKakaoFormView";


	@Autowired
	private FarmFacade farm;
	
	@Autowired
    private KakaoPay kakaopay;
	
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
		
		ImPur imPur = this.farm.getMyImPurKakao(imPurNo);
		
		if(imPur.getPayment().getMethod().equals("카드")) {
			imPur = this.farm.getMyImPur(imPurNo);
		}			
		
		DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String pDate = sdFormat.format(imPur.getPayment().getpDate());
		
		model.put("imPur", imPur);
		model.put("pDate", pDate);
			
		return VIEWIMPUR;
	}	
	
	//kakao pay form
	@RequestMapping(value = "/auction/immePurchaseKaKao.do",  method = RequestMethod.GET)
	public String imPurkakaoForm(
			@ModelAttribute("imPurCommand") ImPurCommand imPurCommand,
			@RequestParam("aNo") int aNo,
			ModelMap model) throws Exception {
		
		Auction auction = this.farm.getAuction(aNo);
		
		DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		auction.setsDeadline(sdFormat.format(auction.getDeadline()));
		
		model.put("auction", auction);

		return IMPURKAKAOFORM;
	}
	
	//kakao pay
	@RequestMapping(value = "/auction/immePurchaseKaKao.do",  method = RequestMethod.POST)
	public String imPurkakao(
			@RequestParam("aNo") int aNo,
			@Valid @ModelAttribute("imPurCommand") ImPurCommand imPurCommand,
			BindingResult bindingResult,
			HttpServletRequest request,
			ModelMap model) throws Exception {
				
			
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
			
		Auction auction = this.farm.getAuction(aNo);
		
		DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		auction.setsDeadline(sdFormat.format(auction.getDeadline()));
					
		if(bindingResult.hasErrors()) {
			model.put("auction", auction);
			return IMPURKAKAOFORM;
		}
		
		//Address address = this.farm.getAddress(imPurCommand.getAddrNo());
		Address address = new Address();
		address.setZip(imPurCommand.getZip());
		address.setAddr(imPurCommand.getAddr());
		address.setDetail(imPurCommand.getDetail());	
		
		if(address.getZip() == 0 ) {
			bindingResult.rejectValue("zip", "noZip");
			model.put("auction", auction);
			return IMPURKAKAOFORM;			
		}
		
		if(address.getAddr().equals("")) {
			bindingResult.rejectValue("addr", "noAddr");
			model.put("auction", auction);
			return IMPURKAKAOFORM;			
		}
		
		if(address.getDetail().equals("")) {
			bindingResult.rejectValue("detail", "noDetail");
			model.put("auction", auction);
			return IMPURKAKAOFORM;			
		}
				
		if(this.farm.getAddrNo(address) == null) {
			bindingResult.rejectValue("zip", "noRegisteredAddr");
			model.put("auction", auction);
			return IMPURKAKAOFORM;		
		}
		address.setAddrNo(this.farm.getAddrNo(address).getAddrNo());
			
//		if(address == null) {
//			bindingResult.rejectValue("addrNo", "noaddressNo");
//			model.put("auction", auction);
//			return IMPURKAKAOFORM;		
//		}
//		
//		if(address.getUser().getUserNo() != user.getUserNo()) {
//			bindingResult.rejectValue("addrNo", "notMyAddress");
//			model.put("auction", auction);
//			return IMPURKAKAOFORM;		
//		}
			
		if(auction.getFinish()) {
			model.put("message", "경매가 종료되었습니다.");
			return IMPURFAIL;
		}
		
		String url = request.getRequestURL().toString();
					
		Payment payment = new Payment();
		payment.setMethod("카카오페이");
		payment.setTotalPrice(auction.getImPurPrice());
		
		Delivery delivery = new Delivery();
		delivery.setAddress(address);
		delivery.setPhone(imPurCommand.getPhone());
		
		ImPur imPur = new ImPur();
		imPur.setAuction(auction);
		imPur.setPayment(payment);
		imPur.setUser(user);
		imPur.setDelivery(delivery);
			
		this.farm.immePurchaseKakao(imPur);	

		model.put("imPur", imPur);

		return IMPURSUCCESS;
	}	
	
	//ImPur ... ImPur form
	@RequestMapping(value = "/auction/immePurchase.do",  method = RequestMethod.GET)
	public String imPurForm(
			@ModelAttribute("imPurCommand") ImPurCommand imPurCommand,
			@RequestParam("aNo") int aNo,
			ModelMap model) throws Exception {
		
		Auction auction = this.farm.getAuction(aNo);
		
		DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		auction.setsDeadline(sdFormat.format(auction.getDeadline()));
		
		model.put("auction", auction);

		return IMPURFORM;
	}
	
	//imPur ... imPur
	@RequestMapping(value = "/auction/immePurchase.do",  method = RequestMethod.POST)
	public ModelAndView imPur(
		@RequestParam("aNo") int aNo,
		@Valid @ModelAttribute("imPurCommand") ImPurCommand imPurCommand,
		BindingResult bindingResult,
		HttpServletRequest request) throws Exception {
			
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		
		Auction auction = this.farm.getAuction(aNo);
		
		DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		auction.setsDeadline(sdFormat.format(auction.getDeadline()));
		
		Card card = this.farm.getCard(imPurCommand.getCardNo());

		if(bindingResult.hasErrors()) {
			return new ModelAndView(IMPURFORM, "auction", auction);
		}
		
		if(card == null) {
			bindingResult.rejectValue("cardNo", "nocardNo");
			return new ModelAndView(IMPURFORM, "auction", auction);
		}
		
		if(card.getUser().getUserNo() != user.getUserNo()) {
			bindingResult.rejectValue("cardNo", "notMyCard");
			return new ModelAndView(IMPURFORM, "auction", auction);
		}
		
		//Address address = this.farm.getAddress(imPurCommand.getAddrNo());
		Address address = new Address();
		address.setZip(imPurCommand.getZip());
		address.setAddr(imPurCommand.getAddr());
		address.setDetail(imPurCommand.getDetail());	
		
		if(address.getZip() == 0 ) {
			bindingResult.rejectValue("zip", "noZip");
			return new ModelAndView(IMPURFORM, "auction", auction);			
		}
		
		if(address.getAddr().equals("")) {
			bindingResult.rejectValue("addr", "noAddr");
			return new ModelAndView(IMPURFORM, "auction", auction);		
		}
		
		if(address.getDetail().equals("")) {
			bindingResult.rejectValue("detail", "noDetail");
			return new ModelAndView(IMPURFORM, "auction", auction);			
		}
				
		if(this.farm.getAddrNo(address) == null) {
			bindingResult.rejectValue("zip", "noRegisteredAddr");
			return new ModelAndView(IMPURFORM, "auction", auction);	
		}
		address.setAddrNo(this.farm.getAddrNo(address).getAddrNo());		
		
//		if(address == null) {
//			bindingResult.rejectValue("addrNo", "noaddressNo");
//			return new ModelAndView(IMPURFORM, "auction", auction);
//		}
//		
//		if(address.getUser().getUserNo() != user.getUserNo()) {
//			bindingResult.rejectValue("addrNo", "notMyAddress");
//			return new ModelAndView(IMPURFORM, "auction", auction);
//		}
		
		if(auction.getFinish()) {
			return new ModelAndView(IMPURFAIL, "message", "경매가 종료되었습니다.");
		}
		
		Payment payment = new Payment();
		payment.setCard(card);
		payment.setTotalPrice(auction.getImPurPrice());
		
		Delivery delivery = new Delivery();
		delivery.setAddress(address);
		delivery.setPhone(imPurCommand.getPhone());
		
		ImPur imPur = new ImPur();
		imPur.setAuction(auction);
		imPur.setPayment(payment);
		imPur.setUser(user);
		imPur.setDelivery(delivery);
			
		this.farm.immePurchase(imPur);	

		return new ModelAndView(IMPURSUCCESS, "imPur", imPur);
	}
}
