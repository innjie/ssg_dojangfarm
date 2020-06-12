package com.ssg.dojangfarm.dao.mybatis.mapper;

import java.util.List;

import com.ssg.dojangfarm.domain.Card;

public interface CardMapper {
	Card getCard(int cardNo);
	List<Card> getCardList(int userNo);
	void insertCard(Card card);
	void deleteCard(int cardNo);
	Card checkCardPayNo(String cardPayNo);
}
