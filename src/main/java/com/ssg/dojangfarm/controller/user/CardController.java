package com.ssg.dojangfarm.controller.user;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.dojangfarm.domain.Auction;
import com.ssg.dojangfarm.domain.Card;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;

@Controller
public class CardController {
	private static final String LISTCARD = "card/CardListView";
	private static final String VIEWCARD = "card/CardView";
	private static final String CARDFORM = "card/InsertCardFormView";
	
	@Autowired
	private FarmFacade farm;
	
	public void setFarm(FarmFacade  farm) {
		this.farm = farm;
	}
	
	//view cardList
	//@RequestMapping("/card/viewCardList.do")
	public ModelAndView listCard(
			HttpServletRequest request) throws Exception {
		
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");

		PagedListHolder<Card> cardList = new PagedListHolder<Card>(this.farm.getCardList(user.getUserNo()));
		cardList.setPageSize(4);
		
		return new ModelAndView(LISTCARD, "cardList ", cardList);
	}	

/*	//view cardList by page
	@RequestMapping("/auction/viewMyAuctionList2.do")
	public String listCard2(
			@RequestParam("page") String page,
			@ModelAttribute("cardList") PagedListHolder<Card> cardList,
			BindingResult result) throws Exception {
		if (cardList== null) {
			throw new IllegalStateException("Cannot find pre-loaded cardList");
		}
		if ("next".equals(page)) { 
			cardList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			cardList.previousPage(); 
		}
		
		return LISTCARD;
	}	
*/
	//view card
	@RequestMapping("/card/viewCard.do")
	public ModelAndView viewCard(
			@RequestParam("cardNo") int cardNo) throws Exception {
		
		Card card = this.farm.getCard(cardNo);

		return new ModelAndView(VIEWCARD, "card", card);
	}
	
	//create card ... form - servlet.xml

	//create card ... insert
	@RequestMapping("/card/insertCard.do")
	public String insert(
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

	//delete card
	@RequestMapping("/card/deleteCard.do")
	public String delete(
			@RequestParam("cardNo") int cardNo) throws Exception {
	
		this.farm.deleteCard(cardNo);	

		return "redirect:/card/viewCardList.do";
	
	}
}
