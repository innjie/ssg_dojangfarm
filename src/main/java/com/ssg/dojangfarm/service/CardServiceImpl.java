package com.ssg.dojangfarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.dojangfarm.dao.CardDAO;
import com.ssg.dojangfarm.domain.Card;

@Service("CardServiceImpl")
public class CardServiceImpl implements CardService {

	@Autowired
	private CardDAO cardDAO;


	@Override
	public Card getCard(int cardNo) {
		return cardDAO.getCard(cardNo);
	}

	@Override
	public List<Card> getCardList(int userNo) {
		return cardDAO.getCardList(userNo);
	}

	@Override
	public void insertCard(Card card) {
		cardDAO.insertCard(card);
	}

	@Override
	public void deleteCard(int cardNo) {
		cardDAO.deleteCard(cardNo);
	}
}
