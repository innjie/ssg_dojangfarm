package com.ssg.dojangfarm.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssg.dojangfarm.domain.Address;
import com.ssg.dojangfarm.domain.Card;

@Component
@WebService(serviceName="CardService")
public class CardServiceEndpoint {
	@Autowired
	CardService cardService; // inject cardServiceImpl

	@WebMethod
	public Card getCard(int cardNo) {
		return cardService.getCard(cardNo);
	}
	
	@WebMethod
	public List<Card> getCardList(int userNo) {
		return cardService.getCardList(userNo);
	}

	@WebMethod
	public void insertCard(Card card) {
		cardService.insertCard(card);
	}
	
	@WebMethod
	public void deleteCard(int cardNo) {
		cardService.deleteCard(cardNo);
	}

	@WebMethod
	public Card checkCardPayNo(String cardPayNo) {
		return cardService.checkCardPayNo(cardPayNo);
	}
}
