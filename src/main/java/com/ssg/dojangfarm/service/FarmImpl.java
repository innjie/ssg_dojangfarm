package com.ssg.dojangfarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssg.dojangfarm.dao.*;
import com.ssg.dojangfarm.domain.*;

//This class defines a default transaction annotation for all methods.

@Service
@Transactional
public class FarmImpl implements FarmFacade{
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private MessageDAO messageDAO;
	@Autowired
	private QnADAO qnaDAO;
	@Autowired
	private AuctionDAO auctionDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private AddressDAO addressDAO;
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private DeliveryDAO deliveryDAO;
	@Autowired
	private CardDAO cardDAO;
	@Autowired
	private CommonDAO commonDAO;
	@Autowired
	private CommonNoticeDAO commonNoticeDAO;
	@Autowired
	private DiscountDAO discountDAO;
	@Autowired
	private NormalDAO normalDAO;
	@Autowired
	private PaymentDAO paymentDAO;
	@Autowired
	private RefundDAO refundDAO;
	
	
	
	//-------------------------------------------------------------------------
	// Operation methods, implementing the FarmFacade interface
	//-------------------------------------------------------------------------
	
	
	//-------------------------------------------------------------------------
	//Category
	//-------------------------------------------------------------------------
	
	@Override
	public Category getCategory(int cateNo) {
		return categoryDAO.getCategory(cateNo);
	}
	@Override
	public List<Category> getCategoryList() {
		return categoryDAO.getCategoryList();
	}
	
	
	//-------------------------------------------------------------------------
	//Message
	//-------------------------------------------------------------------------
	
	@Override
	public void sendMsg(Message msg) {
		messageDAO.sendMsg(msg);
	}
	@Override
	public void deleteMsg(int msgNo) {
		messageDAO.deleteMsg(msgNo);
	}
	@Override
	public List<Message> sendMessageList(int userNo) {
		return messageDAO.sendMessageList(userNo);
	}
	@Override
	public List<Message> receiveMessageList(int userNo) {
		return messageDAO.receiveMessageList(userNo);
	}
	@Override
	public List<Message> findMsg(String title) {
		return messageDAO.findMsg(title);
	}
	@Override
	public Message checkMsg(int msgNo) {
		return messageDAO.checkMsg(msgNo);
	}

	
	
	//-------------------------------------------------------------------------
	//QnA
	//-------------------------------------------------------------------------
	
	@Override
	public List<QnA> getQnAList(int saleNo) {
		return qnaDAO.getQnAList(saleNo);
	}
	@Override
	public void questionQnA(QnA qna) {
		qnaDAO.questionQnA(qna);
	}
	@Override
	public void answerQnA(int qNo, String answer){
		qnaDAO.answerQnA(qNo, answer);
	}
	
	
	//-------------------------------------------------------------------------
	//Auction
	//-------------------------------------------------------------------------

	@Override
	public List<Auction> getAuctionList() {
		return auctionDAO.getAuctionList();
	}
	@Override
	public List<Auction>findAuctionByTitle(String title) {
		return auctionDAO.findAuctionByTitle(title);
	}
	@Override
	public List<Auction>findAuctionByProduct(String pName) {
		return auctionDAO.findAuctionByProduct(pName);
	}
	@Override
	public Auction getAuction(int aNo) {
		return auctionDAO.getAuction(aNo);
	}
	@Override
	public void registerAuction(Auction auction) {
		auctionDAO.registerAuction(auction);
	}
	@Override
	public void bidAuction(Bid bid) {
		auctionDAO.bidAuction(bid);
	}
	@Override
	public void successBid(SBid sBid)  {
		auctionDAO.successBid(sBid);
	}
	@Override
	public void immePurchase(ImPur imPur) {
		auctionDAO.immePurchase(imPur);
	}

	
	//-------------------------------------------------------------------------
	//User
	//-------------------------------------------------------------------------
	
	@Override
	public void createUser(User user) {
		userDAO.createUser(user);
	}
	@Override
	public void modifyUser(int userNo, String id, String password, String name, String phone) {
		userDAO.modifyUser(userNo, id, password, name, phone);
	}
	@Override
	public void deleteUser(int userNo) {
		userDAO.deleteUser(userNo);
	}
	@Override
	public User getUser(int userNo) {
		return userDAO.getUser(userNo);
	}
	@Override
	public boolean existingId(String id) {
		return userDAO.existingId(id);
	}
	@Override
	public boolean existingPhone(String phone) {
		return userDAO.existingPhone(phone);
	}
	@Override
	public boolean checkIdPw(String id, String password) {
		return userDAO.checkIdPw(id, password);
	}
	@Override
	public void login() {
		userDAO.login();
	}
	@Override
	public void logout() {
		userDAO.logout();
	}
	
	
	//-------------------------------------------------------------------------
	//Address
	//-------------------------------------------------------------------------
	
	@Override
	public Address getAddress(int addrNo) {
		return addressDAO.getAddress(addrNo);
	}
	@Override
	public void createAddress(Address address) {
		addressDAO.createAddress(address);
	}
	@Override
	public void modifyAddress(int addrNo, String addr, int zip, String detail) {
		addressDAO.modifyAddress(addrNo, addr, zip, detail);
	}
	@Override
	public void deletAddress(int addrNo) {
		addressDAO.deletAddress(addrNo);
	}
	@Override
	public List<Address> getAddressList(int userNo) {
		return addressDAO.getAddressList(userNo);
	}
	
	
	//-------------------------------------------------------------------------
	//Delivery
	//-------------------------------------------------------------------------
		
	@Override
	public Delivery getDelivery(int dNo) {
		return deliveryDAO.getDelivery(dNo);
	}
	@Override
	public void changeDeliveryStatus(int dNo, String status) {
		deliveryDAO.changeDeliveryStatus(dNo, status);
	}
	@Override
	public void addDelivery(Delivery delivery) {
		deliveryDAO.addDelivery(delivery);
	}
	
	
	//-------------------------------------------------------------------------
	//Order
	//-------------------------------------------------------------------------
		
	@Override
	public Order getOrder(int orderNo) {
		return orderDAO.getOrder(orderNo);
	}
	@Override
	public List<Order> getOrderList(int userNo) {
		return orderDAO.getOrderList(userNo);
	}
	@Override
	public void CancelOrder(int orderNo) {
		orderDAO.CancelOrder(orderNo);
	}
	
	//-------------------------------------------------------------------------
	//Card
	//-------------------------------------------------------------------------
		
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
	
	//-------------------------------------------------------------------------
	//Common
	//-------------------------------------------------------------------------
		
	@Override
	public int insertSale(Common common) {
		return commonDAO.insertSale(common);
	}

	@Override
	public int updateSale(Common common) {
		return commonDAO.updateSale(common);
	}

	@Override
	public Common getCommonSale(int saleNo) {
		return commonDAO.getCommonSale(saleNo);
	}

	@Override
	public List<Common> getAllCommonList() {
		return commonDAO.getAllCommonList();
	}

	@Override
	public List<Common> getCommonListByUserNo(int userNo) {
		return commonDAO.getCommonListByUserNo(userNo);
	}

	@Override
	public List<Common> searchCommon(String title) {
		return commonDAO.searchCommon(title);
	}

	@Override
	public int insertCommonjoin(int userNo, int saleNo) {
		return commonDAO.insertCommonjoin(userNo, saleNo);
	}

	@Override
	public int cancelCommonjoin(int userNo, int CJNo) {
		return commonDAO.cancelCommonjoin(userNo, CJNo);
	}

	@Override
	public int updateCommonjoin(int userNo, int CJNo) {
		return commonDAO.updateCommonjoin(userNo, CJNo);
	}
	
	//-------------------------------------------------------------------------
	//CommonNotice
	//-------------------------------------------------------------------------
		
	@Override
	public int insertCommonNotice(CommonNotice cn) {
		return commonNoticeDAO.insertCommonNotice(cn);
	}

	@Override
	public void updateCommonNotice(CommonNotice cn) {
		commonNoticeDAO.updateCommonNotice(cn);
	}

	@Override
	public void deleteCommonNotice(CommonNotice cn) {
		commonNoticeDAO.deleteCommonNotice(cn);
	}

	@Override
	public CommonNotice viewCommonNotice(CommonNotice cn) {
		return commonNoticeDAO.viewCommonNotice(cn);
	}

	@Override
	public List<CommonNotice> getAllNoticeList() {
		return commonNoticeDAO.getAllNoticeList();
	}

	@Override
	public List<CommonNotice> getCNoticeListByUserNo(int userNo) {
		return commonNoticeDAO.getCNoticeListByUserNo(userNo);
	}
	
	//-------------------------------------------------------------------------
	//Discount
	//-------------------------------------------------------------------------
		
	@Override
	public void newDiscount(Normal normal) {
		discountDAO.newDiscount(normal);
	}
	public void deleteDiscount(int saleNo) {
		discountDAO.deleteDiscount(saleNo);
	}
	
	//-------------------------------------------------------------------------
	//Normal
	//-------------------------------------------------------------------------
		
	@Override
	public int insertSale(int userNo, Normal normal) {
		return normalDAO.insertSale(userNo, normal);
	}

	@Override
	public int updateSale(Normal normal) {
		return normalDAO.updateSale(normal);
	}

	@Override
	public Normal getNormalSale(int saleNo) {
		return normalDAO.getNormalSale(saleNo);
	}

	@Override
	public List<Normal> getAllNormalList() {
		return normalDAO.getAllNormalList();
	}

	@Override
	public List<Normal> getNormalListByUserNo(int userNo) {
		return normalDAO.getNormalListByUserNo(userNo);
	}

	@Override
	public int turnSaleOpen(int saleNo) {
		return normalDAO.turnSaleOpen(saleNo);
	}

	@Override
	public int turnSaleClosed(int sale) {
		return normalDAO.turnSaleClosed(sale);
	}

	@Override
	public List<Normal> searchNormal(String title) {
		return normalDAO.searchNormal(title);
	}
	
	//-------------------------------------------------------------------------
	//Payment
	//-------------------------------------------------------------------------
		
	@Override
	public Payment getPayment(int payNo) {
		return paymentDAO.getPayment(payNo);
	}

	@Override
	public void insertPayment(Payment payment) {
		paymentDAO.insertPayment(payment);
	}
	
	//-------------------------------------------------------------------------
	//Refund
	//-------------------------------------------------------------------------
		
	@Override
	public int refundSale(int saleNo) {
		return refundDAO.refundSale(saleNo);
	}

	@Override
	public Refund getRefund(int refundNo) {
		return refundDAO.getRefund(refundNo);
	}

	@Override
	public List<Refund> getRefundList(int userNo) {
		return refundDAO.getRefundList(userNo);
	}
	
	
}