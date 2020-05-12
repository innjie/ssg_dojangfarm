package com.ssg.dojangfarm.dao;

import java.util.List;

import com.ssg.dojangfarm.domain.Card;

public interface CardDAO {
	Card getCard(int cardNo);
	List<Card> getCardList(int userNo);
	void insertCard(Card card);
	void deleteCard(int cardNo);
}
