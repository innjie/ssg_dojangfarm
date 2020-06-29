package com.ssg.dojangfarm.controller.auction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
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
import com.ssg.dojangfarm.domain.SBid;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;

@Controller
@SessionAttributes("[bidList, sBidList]")
public class BidController {
	private static final String LISTBID = "auction/MyBidListView";
	private static final String LISTSBID = "auction/MySBidListView";
	private static final String VIEWSBID = "auction/MySBidView";
	private static final String BIDFORM = "auction/BidAuctionFormView";
	private static final String BIDSUCCESS = "auction/BidSuccessView";

	@Autowired
	private FarmFacade farm;
	
	public void setFarm(FarmFacade  farm) {
		this.farm = farm;
	}
	
	//BidCommand
	@ModelAttribute("bidCommand")
	public BidCommand formBacking() {
		return new BidCommand();
	}
	
	//view myBidList
	@RequestMapping("/auction/viewMyBidList.do")
	public String listMyBid(
			ModelMap model,
			HttpServletRequest request) throws Exception {
		
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");

		PagedListHolder<Bid> bidList = new PagedListHolder<Bid>(this.farm.getMyBidList(user.getUserNo()));	//add dao

		bidList.setPageSize(10);
		model.put("bidList", bidList);
		
		return LISTBID;
	}
	

	//view myBidList by page
	@RequestMapping("/auction/viewMyBidList2.do")
	public String listMyBid2(
			@RequestParam("page") String page,
			@ModelAttribute("bidList") PagedListHolder<Bid> bidList,
			BindingResult result) throws Exception {
		if (bidList== null) {
			throw new IllegalStateException("Cannot find pre-loaded bidList");
		}
		if ("next".equals(page)) { 
			bidList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			bidList.previousPage(); 
		}
			
		return LISTBID;
	}

	
	//view mySBidList
	@RequestMapping("/auction/viewMySBidList.do")
	public String listMySBid(
			ModelMap model,
			HttpServletRequest request) throws Exception {
		
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");

		PagedListHolder<SBid> sBidList = new PagedListHolder<SBid>(this.farm.getMySBidList(user.getUserNo()));	//add dao

		sBidList.setPageSize(4);
		model.put("sBidList", sBidList);
		return LISTSBID;
	}
	

	//view mySBidList by page
	@RequestMapping("/auction/viewMySBidList2.do")
	public String listMySBid2(
			@RequestParam("page") String page,
			@ModelAttribute("sBidList") PagedListHolder<SBid> sBidList,
			BindingResult result) throws Exception {
		if (sBidList== null) {
			throw new IllegalStateException("Cannot find pre-loaded SBidList");
		}
		if ("next".equals(page)) { 
			sBidList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			sBidList.previousPage(); 
		}
			
		return LISTSBID;
	}

	
	//view sBid
	@RequestMapping("/auction/viewMySBid.do")
	public String viewMySBid(
			@RequestParam("sBidNo") int sBidNo,
			ModelMap model) throws Exception {
			
		SBid sBid = this.farm.getMySBid(sBidNo);	
		model.put("sBid", sBid);
			
		return VIEWSBID;
	}	
	
	//Bid ... bid form
	@RequestMapping(value = "/auction/bidAuction.do",  method = RequestMethod.GET)
	public String bidForm(
			@ModelAttribute("bidCommand") BidCommand bidCommand,
			@RequestParam("aNo") int aNo,
			ModelMap model) throws Exception {
		
		Auction auction = this.farm.getAuction(aNo);
		
		model.put("auction", auction);

		return BIDFORM;
	}
	
	//Bid ... insertBid
	@RequestMapping(value = "/auction/bidAuction.do",  method = RequestMethod.POST)
	public ModelAndView bid(
		@RequestParam("aNo") int aNo,
		@RequestParam("nowPrice") int nowPrice,
		@RequestParam("minPrice") int minPrice,
		@Valid @ModelAttribute("bidCommand") BidCommand bidCommand,
		BindingResult bindingResult,
		HttpServletRequest request) throws Exception {
			
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		
		Auction auction = this.farm.getAuction(aNo);
		
		if(bidCommand.getBidPrice() == 0) {
			bindingResult.rejectValue("bidPrice", "noBidPrice");
			return new ModelAndView(BIDFORM, "auction", auction);
		}
			
		if(bidCommand.getBidPrice() < minPrice) {
			bindingResult.rejectValue("bidPrice", "minThanMinPrice");
			return new ModelAndView(BIDFORM, "auction", auction);
		}
		
		if(bidCommand.getBidPrice() <= nowPrice) {
			bindingResult.rejectValue("bidPrice", "minThanBidPrice");
			return new ModelAndView(BIDFORM, "auction", auction);
		}
		
		Card card = this.farm.getCard(bidCommand.getCardNo());

		if(card == null) {
			bindingResult.rejectValue("cardNo", "nocardNo");
			return new ModelAndView(BIDFORM, "auction", auction);
		}
		
		Address address = this.farm.getAddress(bidCommand.getAddrNo());
		
		if(address == null) {
			bindingResult.rejectValue("addrNo", "noaddressNo");
			return new ModelAndView(BIDFORM, "auction", auction);
		
		}
		
		
		Bid bid = new Bid();
		bid.setUser(user);
		bid.setAuction(auction);
		bid.setBidPrice(bidCommand.getBidPrice());
		bid.setAddress(address);
		bid.setCard(card);
		bid.setPhone(bidCommand.getPhone());
			
		this.farm.bidAuction(bid);	

		return new ModelAndView(BIDSUCCESS, "bid", bid);
	}	
	
	
}
