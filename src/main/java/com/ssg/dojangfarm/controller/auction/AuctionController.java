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
import org.springframework.web.servlet.ModelAndView;

import com.ssg.dojangfarm.domain.Auction;
import com.ssg.dojangfarm.domain.ImPur;
import com.ssg.dojangfarm.domain.SBid;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;

@Controller
public class AuctionController {
	private static final String LISTAUCTION = "auction/AuctionListView";
	private static final String VIEWAUCTION = "auction/AuctionView";
	private static final String LISTMYAUCTION = "auction/MyAuctionListView";
	private static final String AUCTIONFORM = "auction/RegisterAuctionFormView";
	private static final String CONFIRMAUCTION = "auction/RegisterAuctionConfirmView";
	
	private FarmFacade farm;
	
	@Autowired
	public void setFarm(FarmFacade farm) {
		this.farm = farm;
	}


	//AuctionCommand °´Ã¼ »ý¼º
	@ModelAttribute("auctionCommand")
	public AuctionCommand formBacking() {
		return new AuctionCommand();
	}
	
	//view auctionList
	@RequestMapping("/auction/viewAuctionList.do")
	public String listAuction(
			ModelMap model) throws Exception {

		PagedListHolder<Auction> auctionList = new PagedListHolder<Auction>(this.farm.getAuctionList());

		auctionList.setPageSize(4);
		model.put("auctionList ", auctionList.getSource() );
		return LISTAUCTION;
	}

/*	//view auctionList by page
	@RequestMapping("/auction/viewAuctionList2.do")
	public String listAuction2(
			@RequestParam("page") String page,
			@ModelAttribute("auctionList") PagedListHolder<Auction> auctionList,
			BindingResult result) throws Exception {
		if (auctionList== null) {
			throw new IllegalStateException("Cannot find pre-loaded auction list");
		}
		if ("next".equals(page)) { 
			auctionList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			auctionList.previousPage(); 
		}
		
		return LISTAUCTION;
	}
*/	
	
	//view  myAuctionList
	@RequestMapping("/auction/viewMyAuctionList.do")
	public String listMyAuction(
			ModelMap model,
			HttpServletRequest request) throws Exception {
		
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");

		PagedListHolder<Auction> auctionList = new PagedListHolder<Auction>(this.farm.getMyAuctionList(user.getUserNo()));

		auctionList.setPageSize(4);
		model.put("auctionList ", auctionList.getSource() );
		return LISTMYAUCTION;
	}	

/*	//view myAuctionList by page
	@RequestMapping("/auction/viewMyAuctionList2.do")
	public String listMyAuction2(
			@RequestParam("page") String page,
			@ModelAttribute("auctionList") PagedListHolder<Auction> auctionList,
			BindingResult result) throws Exception {
		if (auctionList== null) {
			throw new IllegalStateException("Cannot find pre-loaded auction list");
		}
		if ("next".equals(page)) { 
			auctionList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			auctionList.previousPage(); 
		}
		
		return LISTMYAUCTION;
	}	
*/
	//find auctionList
	@RequestMapping("/auction/findAuctionList.do")
	public String findAuction(
			@RequestParam("text") String text,
			@RequestParam("type") String type,
			ModelMap model) throws Exception {

		PagedListHolder<Auction> auctionList;
		
		if(type.equals("title")) {
			auctionList = new PagedListHolder<Auction>(this.farm.findAuctionByTitle(text));
		}
		else {
			auctionList = new PagedListHolder<Auction>(this.farm.findAuctionByProduct(text));
		}

		auctionList.setPageSize(4);
		model.put("auctionList", auctionList.getSource());
		return LISTAUCTION;
	}

/*	//find auctionList by page
	@RequestMapping("/auction/findAuctionList2.do")
	public String findAuction2(
			@RequestParam("page") String page,
			@ModelAttribute("auctionList") PagedListHolder<Auction> auctionList,
			BindingResult result) throws Exception {
		if (auctionList== null) {
			throw new IllegalStateException("Cannot find pre-loaded auctionList list");
		}
		if ("next".equals(page)) { 
			auctionList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			auctionList.previousPage(); 
		}
		return LISTAUCTION;
	}
*/
	//view auction
	@RequestMapping("/auction/viewAuction.do")
	public String viewAuction(
			@RequestParam("aNo") int aNo,
			ModelMap model,
			HttpServletRequest request) throws Exception {
		
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		int auctionUserNo = this.farm.getUserByAuction(aNo).getUserNo();	
		
		Auction auction = this.farm.getAuction(aNo);
		model.put("auction", auction);
		
		//check this user is auction's user
		if(user.getUserNo() == auctionUserNo) {
			SBid sBid = this.farm.getSBidByAuction(aNo);	
			ImPur imPur = this.farm.getImPurByAuction(aNo);	
			
			model.put("sBid", sBid);
			model.put("imPur", imPur);
		}
		
		return VIEWAUCTION;
	}

	//register auction ... auction form
	@RequestMapping(value = "/auction/registerAuction.do",  method = RequestMethod.GET)
	public String auctionForm(
			@ModelAttribute("auction") AuctionCommand auctionCommand) throws Exception {

		return AUCTIONFORM;
	}

	
	//register auction ... insert auction
	@RequestMapping(value = "/auction/registerAuction.do",  method = RequestMethod.POST)
	public ModelAndView register(
			@Valid @ModelAttribute("auctionCommand") AuctionCommand auctionCommand) throws Exception {
		
		//auctionCommand to auction
		Auction auction = new Auction();
		
		
		
		this.farm.registerAuction(auction);	

		return new ModelAndView(VIEWAUCTION, "auction", auction);
	}
	
	//confirm register auction
	@RequestMapping("/auction/registerAuctionConfirm.do")
	public String confirm(
			@ModelAttribute("auction") AuctionCommand auctionCommand,
			BindingResult result) throws Exception {

		if(result.hasErrors()) {
			return AUCTIONFORM;
		}		
			
		return CONFIRMAUCTION;
	}

}
