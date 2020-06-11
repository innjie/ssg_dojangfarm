package com.ssg.dojangfarm.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssg.dojangfarm.dao.AuctionDAO;
import com.ssg.dojangfarm.dao.CardDAO;
import com.ssg.dojangfarm.dao.mybatis.mapper.CardMapper;
import com.ssg.dojangfarm.domain.Auction;
import com.ssg.dojangfarm.domain.Bid;
import com.ssg.dojangfarm.domain.Card;
import com.ssg.dojangfarm.domain.ImPur;
import com.ssg.dojangfarm.domain.SBid;

@Repository
public class MybatisCardDAO implements CardDAO{
	@Autowired
	private CardMapper cardtMapper;
	
	public Card getCard(int cardNo) {
		return cardtMapper.getCard(cardNo);
	}
	public List<Card> getCardList(int userNo) {
		return cardtMapper.getCardList(userNo);
	}
	public void insertCard(Card card) {
		cardtMapper.insertCard(card);
	}
	public void deleteCard(int cardNo) {
		cardtMapper.deleteCard(cardNo);
	}

}
