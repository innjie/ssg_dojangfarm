package com.ssg.dojangfarm.controller.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.ssg.dojangfarm.domain.Card;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;

@Controller
public class CardController {
	private static final String LISTCARD = "user/CardListView";
	private static final String VIEWCARD = "user/CardView";
	private static final String CARDFORM = "user/InsertCardFormView";
	
	@Autowired
	private FarmFacade farm;
	
	public void setFarm(FarmFacade  farm) {
		this.farm = farm;
	}
	
	//cardCommand 
	@ModelAttribute("cardCommand")
	public CardCommand formBacking(HttpServletRequest request) {
		return new CardCommand();
	}	
	
	//type value
	@ModelAttribute("types")
	public List<String> referenceData() {
		List<String> types = new ArrayList<String>();
		types.add("Visa");
		types.add("MasterCard");
		types.add("American Express");
		
		return types;		
	}
	
	//view cardList
	@RequestMapping("/card/viewCardList.do")
	public ModelAndView listCard(
			HttpServletRequest request) throws Exception {
		
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");

		PagedListHolder<Card> cardList = new PagedListHolder<Card>(this.farm.getCardList(user.getUserNo()));
		cardList.setPageSize(4);

		return new ModelAndView(LISTCARD, "cardList", cardList.getSource());
	}	

/*	//view cardList by page
	@RequestMapping("/card/viewCardList2.do")
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
	
	//create card ... 
	@RequestMapping(value="/card/insertCard.do", method=RequestMethod.GET)
	public String insertForm(@ModelAttribute("cardCommand") CardCommand cardCommand) {
		return CARDFORM;
	}
	
	//create card ... insert
	@RequestMapping(value="/card/insertCard.do", method=RequestMethod.POST)
	public String insert(
			HttpServletRequest request,
			@Valid @ModelAttribute("cardCommand") CardCommand cardCommand,
			BindingResult result) throws Exception {

		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
				
		//validate
		if (result.hasErrors()) {
			return CARDFORM;
		}
		
		//cardPayNo is unique
		if(this.farm.checkCardPayNo(cardCommand.getCardPayNo()) != null) {
			result.rejectValue("cardPayNo", "invalidCardPayNo", new Object[] { request.getParameter("cardPayNo") }, null);

			return CARDFORM;
		}
		
		Card card = new Card();
		card.setUser(user);
		card.setBank(cardCommand.getBank());
		card.setCardPW(Integer.parseInt(cardCommand.getCardPW()));
		card.setPeriod(cardCommand.getPeriod());
		card.setCvc(Integer.parseInt(cardCommand.getCvc()));
		card.setType(cardCommand.getType());
		card.setCardPayNo(cardCommand.getCardPayNo());
		
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
