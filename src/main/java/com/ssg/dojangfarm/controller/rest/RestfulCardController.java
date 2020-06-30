package com.ssg.dojangfarm.controller.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssg.dojangfarm.domain.Address;
import com.ssg.dojangfarm.domain.Auction;
import com.ssg.dojangfarm.domain.Card;
import com.ssg.dojangfarm.service.AddressService;
import com.ssg.dojangfarm.service.AuctionService;
import com.ssg.dojangfarm.service.CardService;

@Controller
public class RestfulCardController {
	private CardService cardService;

	@Autowired
	public void setFarmSvc(CardService cardService) {
		this.cardService = cardService;
	}
	
	
	@RequestMapping(value = "/cardListBy/{userNo}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody         
	public List<Card> findCard(@PathVariable("userNo") int userNo, HttpServletResponse response) throws IOException {
		System.out.println("/rest/cardListBy/{userNo} request accepted: {userNo} = " + userNo);
		List<Card> cardList = cardService.getCardList(userNo);
		if (cardList == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return cardList;  // convert list of orders to JSON text in response body
	}
	
}
