package com.ssg.dojangfarm.service;

import java.util.List;

import com.ssg.dojangfarm.domain.Card;


public interface CardService {
	public Card getCard(int cardNo);
	public List<Card> getCardList(int userNo);
	public void insertCard(Card card);
	public void deleteCard(int cardNo);
	
	
}
