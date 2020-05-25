package com.ssg.dojangfarm.controller.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssg.dojangfarm.service.FarmFacade;

public class CardController {
	private static final String LISTCARD = "card/CardListView";
	private static final String VIEWCARD = "card/CardView";
	private static final String CARDFORM = "card/InsertCardFormView";
	
	private FarmFacade farm;
	
	@Autowired
	public void setFarm(FarmFacade  farm) {
		this.farm = farm;
	}
	
	//view cardList
	//@RequestMapping("/card/viewCardList.do")

	//view card
	//@RequestMapping("/card/viewCard.do")

	//create card ... form
	//@RequestMapping(method="/card/insertCard.do", method=Request.GET)

	//create card ... insert
	//@RequestMapping(method="/card/insertCard.do", method=Request.POST)

	//delete card
	//@RequestMapping("/card/deleteCard.do")

}
