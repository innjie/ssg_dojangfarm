package com.ssg.dojangfarm.controller.auction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.dojangfarm.domain.Auction;
import com.ssg.dojangfarm.domain.Bid;
import com.ssg.dojangfarm.domain.SBid;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;

@Controller
public class BidController {
	private static final String LISTBID = "auction/MyBidListView";
	private static final String LISTSBID = "auction/MySBidListView";
	private static final String VIEWSBID = "auction/MySBidView";
	private static final String BIDFORM = "auction/BidAuctionFormView.jsp";
	private static final String BIDSUCCESS = "auction/BidSuccessView.jsp";

	@Autowired
	private FarmFacade farm;
	
	public void setFarm(FarmFacade  farm) {
		this.farm = farm;
	}
	
//	//view myBidList
//	@RequestMapping("/auction/viewMyBidList.do")
//	public String listMyBid(
//			ModelMap model,
//			HttpServletRequest request) throws Exception {
//		
//		HttpSession httpSession = request.getSession();
//		User user = (User) httpSession.getAttribute("user");
//
//		PagedListHolder<Bid> bidList = new PagedListHolder<Bid>(this.farm.getMyBidList(user.getUserNo()));	//add dao
//
//		bidList.setPageSize(4);
//		model.put("bidList ", bidList );
//		return LISTBID;
//	}
	

/*	//view myBidList by page
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
*/	
	
//	//view mySBidList
//	@RequestMapping("/auction/viewMySBidList.do")
//	public String listMySBid(
//			ModelMap model,
//			HttpServletRequest request) throws Exception {
//		
//		HttpSession httpSession = request.getSession();
//		User user = (User) httpSession.getAttribute("user");
//
//		PagedListHolder<SBid> SBidList = new PagedListHolder<SBid>(this.farm.getMySBidList(user.getUserNo()));	//add dao
//
//		SBidList.setPageSize(4);
//		model.put("SBidList ", SBidList );
//		return LISTSBID;
//	}
	

/*	//view mySBidList by page
	@RequestMapping("/auction/viewMySBidList2.do")
	public String listMySBid2(
			@RequestParam("page") String page,
			@ModelAttribute("SBidList") PagedListHolder<SBid> SBidList,
			BindingResult result) throws Exception {
		if (SBidList== null) {
			throw new IllegalStateException("Cannot find pre-loaded SBidList");
		}
		if ("next".equals(page)) { 
			SBidList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			SBidList.previousPage(); 
		}
			
		return LISTSBID;
	}
*/
	
//	//view sBid
//	@RequestMapping("/auction/viewMySBid.do")
//	public String viewMySBid(
//			@RequestParam("sBidNo") int sBidNo,
//			ModelMap model) throws Exception {
//			
//		SBid sBid = this.farm.getMySBid(sBidNo);	
//		model.put("sBid", sBid);
//			
//		return VIEWSBID;
//	}	
	
	//Bid ... bid form
	@RequestMapping(value = "/auction/bidAuction.do",  method = RequestMethod.GET)
	public ModelAndView bidForm(
			@RequestParam("aNo") int aNo) throws Exception {
		
		Auction auction = this.farm.getAuction(aNo);

		return new ModelAndView(BIDFORM, "auction", auction);
	}

	
//	//Bid ... insertBid
//	@RequestMapping(value = "/auction/bidAuction.do",  method = RequestMethod.POST)
//	public ModelAndView bid(
//			@RequestParam("aNo") int aNo,
//			@RequestParam("bidPrice") int bidPrice,
//			HttpServletRequest request) throws Exception {
//		
//		HttpSession httpSession = request.getSession();
//		User user = (User) httpSession.getAttribute("user");
//		
//		//시간 비교 + 시간추가, 가격비교
//		Bid bid = new Bid(user.getUserNo(), aNo, bidPrice);
//		
//		this.farm.bidAuction(bid);	
//
//		return new ModelAndView(BIDSUCCESS, "bid", bid);
//	}
	
}
