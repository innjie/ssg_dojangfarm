package com.ssg.dojangfarm.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssg.dojangfarm.dao.*;
import com.ssg.dojangfarm.domain.*;

//This class defines a default transaction annotation for all methods.

@Service
@Transactional
public class FarmImpl implements FarmFacade{
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
//	@Autowired
	private DiscountDAO discountDAO;
	@Autowired
	private NormalDAO normalDAO;
	@Autowired
	private PaymentDAO paymentDAO;
	@Autowired
	private RefundDAO refundDAO;
	
	@Autowired		
	private ThreadPoolTaskScheduler scheduler;
	
	 
	
	//-------------------------------------------------------------------------
	// Operation methods, implementing the FarmFacade interface
	//-------------------------------------------------------------------------
	
	
	//-------------------------------------------------------------------------
	//Message
	//-------------------------------------------------------------------------
	
	@Override
	public void sendMsg(Message msg) {
		messageDAO.sendMsg(msg);
	}
	@Override
	public void sendCMsg(Message msg) {
		messageDAO.sendCMsg(msg);
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
	public Message checkMsgWithCMsg(int msgNo) {
		return messageDAO.checkMsgWithCMsg(msgNo);
	}
	@Override
	public Message checkSMsg(int msgNo) {
		return messageDAO.checkSMsg(msgNo);
	}
	@Override
	public int getRUserNo(int msgNo) {
		return messageDAO.getRUserNo(msgNo);
	}
	@Override
	public int getSUserNo(int msgNo) {
		return messageDAO.getSUserNo(msgNo);
	}
	@Override
	public List<Message> findReceiveMsg(String title) {
		return messageDAO.findReceiveMsg(title);
	}
	@Override
	public List<Message> findSendMsg(String title) {
		return messageDAO.findSendMsg(title);
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
	public QnA getQnA(int qNo) {
		return qnaDAO.getQnA(qNo);
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
		
		Runnable updateTableRunner = new Runnable() {	
			@Override
			public void run() {   
				Date curTime = new Date();
				auctionDAO.successBidAuction(auction);	
				System.out.println("updateTableRunner is executed at " + curTime);
			}
		};
		
		auctionDAO.registerAuction(auction);

		scheduler.schedule(updateTableRunner, auction.getDeadline());  
		
		System.out.println("updateTableRunner has been scheduled to execute at " + auction.getDeadline());		
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
	public Bid getBid(int bidNo) {
		return auctionDAO.getBid(bidNo);
	}

	public List<Auction> getMyAuctionList(int userNo) {
		return auctionDAO.getMyAuctionList(userNo);
	}

	public SBid getSBidByAuction(int aNo) {
		return auctionDAO.getSBidByAuction(aNo);
	}

	public ImPur getImPurByAuction(int aNo) {
		return auctionDAO.getImPurByAuction(aNo);
	}

	public List<Bid> getMyBidList(int userNo) {
		return auctionDAO.getMyBidList(userNo);
	}

	public List<SBid> getMySBidList(int userNo) {
		return auctionDAO.getMySBidList(userNo);
	}

	public SBid getMySBid(int sBidNo) {
		return auctionDAO.getMySBid(sBidNo);
	}

	public List<ImPur> getMyImPurList(int userNo) {
		return auctionDAO.getMyImPurList(userNo);
	}

	public ImPur getMyImPur(int imPurNo) {
		return auctionDAO.getMyImPur(imPurNo);
	}

	public User getUserByAuction(int aNo) {
		return auctionDAO.getUserNoByAuction(aNo);
	}
	public int getPNoByPName(String pName) {
		return auctionDAO.getPNoByPName(pName);
	}
	public int getLastANo() {
		return auctionDAO.getLastANo();
	}
	
	public void addImage(int aNo, String image) {
		auctionDAO.addImage(aNo, image);		
	}
	
	public void addImage(Auction auction, int aNo, String image) {
		auctionDAO.addImage(auction, aNo, image);	
	}
	
	public void immePurchaseKakao(ImPur imPur) {
		auctionDAO.immePurchaseKakao(imPur);
	}
	
	public ImPur getMyImPurKakao(int imPurNo) {
		return auctionDAO.getMyImPurKakao(imPurNo);
	}

	
	//-------------------------------------------------------------------------
	//User
	//-------------------------------------------------------------------------
	
	@Override
	public void createUser(User user) {
		userDAO.createUser(user);
	}
	@Override
	public void modifyUser(User user) {
		userDAO.modifyUser(user );
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
	public User existingId(String id) {
		return userDAO.existingId(id);
	}
	@Override
	public User existingPhone(String phone) {
		return userDAO.existingPhone(phone);
	}
	@Override
	public User checkIdPw(String id, String password) {
		return userDAO.checkIdPw(id, password);
	}
	@Override
	public boolean confirmPassword(String password, String cPassword) {
		return userDAO.confirmPassword(password, cPassword);
	}
	@Override
	public void addPoint(User user) {
		userDAO.addPoint(user);
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
	public void modifyAddress(Address address) {
		addressDAO.modifyAddress(address);
	}
	@Override
	public void deletAddress(int addrNo) {
		addressDAO.deletAddress(addrNo);
	}
	@Override
	public List<Address> getAddressList(int userNo) {
		return addressDAO.getAddressList(userNo);
	}
	@Override
	public Address getAddrNo(Address address) {
		return addressDAO.getAddrNo(address);
	}
	
	//-------------------------------------------------------------------------
	//Delivery
	//-------------------------------------------------------------------------
		
	@Override
	public Delivery getDelivery(int dNo) {
		return deliveryDAO.getDelivery(dNo);
	}
	@Override
	public void changeDeliveryStatus(int dNo) {
		deliveryDAO.changeDeliveryStatus(dNo);
	}
	@Override
	public void addDelivery(Delivery delivery) {
		deliveryDAO.addDelivery(delivery);
	}
	@Override
	public List<Delivery> getDeliveryListByUserNo(int userNo) {
		return deliveryDAO.getDeliveryListByUserNo(userNo);
	}
	@Override
	public void changeDeliveryFinish(int dNo) {
		deliveryDAO.changeDeliveryFinish(dNo);
	}
	@Override
	public int getLastDNo() {
		return deliveryDAO.getLastDNo();
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
	public int cancelOrder(int orderNo) {

		return orderDAO.cancelOrder(orderNo);
	}
	@Override
	public int insertOrder( Order order) {
		return orderDAO.insertOrder(order);
	}
	@Override
	public List<Order> getOrderUserList(int orderNo) {
		return orderDAO.getOrderUserList(orderNo);
	}
	@Override
	public int getLastOrderNo() {
		return orderDAO.getLastOrderNo();
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
	
	@Override
	public Card checkCardPayNo(String cardPayNo) {
		return cardDAO.checkCardPayNo(cardPayNo);
	}
	
	//-------------------------------------------------------------------------
	//Common
	//-------------------------------------------------------------------------
		
	@Override
	public int insertCommon(Common common) {
		return commonDAO.insertCommon( common);
	}

	@Override
	public int updateCommon(Common common) {
		return commonDAO.updateCommon(common);
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
	public void addCommonImage(int saleNo, String string) {
		commonDAO.addCommonImage(saleNo, string);
		
	}
	@Override
	public int getLastCommonSaleNo() {
		return commonDAO.getLastCommonSaleNo();
	}
	
	@Override
	public int insertCommonjoin(CommonJoin commonJoin) {
		return commonDAO.insertCommonjoin(commonJoin);
	}

	@Override
	public int cancelCommonjoin( int CJNo) {
		return commonDAO.cancelCommonjoin(CJNo);
	}

	@Override
	public int updateCommonjoin(CommonJoin commonJoin) {
		return commonDAO.updateCommonjoin( commonJoin);
	}
	@Override
	public CommonJoin getCommonJoin(int CJNo) {
		return commonDAO.getCommonJoin(CJNo);
	}
	@Override
	public List<CommonJoin> getCommonJoinListByUserNo(int userNo) {
		return commonDAO.getCommonJoinListByUserNo(userNo);
	}
	@Override
	public List<CommonJoin> getCommonJoinListBySaleNo(int saleNo) {
		return commonDAO.getCommonJoinListBySaleNo(saleNo);
	}
	@Override
	public CommonJoin ExistCommonJoin(int userNo, int saleNo) {
		return commonDAO.ExistCommonJoin(userNo, saleNo);
	}
	@Override
	public int getLastCJNo() {
		return commonDAO.getLastCJNo();
	}
	//-------------------------------------------------------------------------
	//CommonNotice
	//-------------------------------------------------------------------------
		
	@Override
	public int insertCommonNotice(CommonNotice cn) {
		return commonNoticeDAO.insertCommonNotice(cn);
	}

	@Override
	public int updateCommonNotice(CommonNotice cn) {
		return commonNoticeDAO.updateCommonNotice(cn);
	}

	@Override
	public int deleteCommonNotice(CommonNotice cn) {
		return commonNoticeDAO.deleteCommonNotice(cn);
	}

	@Override
	public CommonNotice viewCommonNotice(int CNNo) {
		return commonNoticeDAO.viewCommonNotice(CNNo);
	}

	@Override
	public List<CommonNotice> getAllNoticeList() {
		return commonNoticeDAO.getAllNoticeList();
	}

	@Override
	public List<CommonNotice> getCNoticeListByUserNo(int userNo) {
		return commonNoticeDAO.getCNoticeListByUserNo(userNo);
	}
	@Override
	public List<CommonNotice> searchCommonNotice(String word) {
		return commonNoticeDAO.searchCommonNotice(word);
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
	public int insertSale( Normal normal) {
		return normalDAO.insertSale(normal);
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
	public int turnSaleState(int saleNo, String saleState) {
		return normalDAO.turnSaleState(saleNo, saleState);
	}
	@Override
	public List<Normal> searchNormal(String title) {
		return normalDAO.searchNormal(title);
	}
	@Override
	public int getUserByNormal(int saleNo) {
		return normalDAO.getUserByNormal(saleNo);
	}
	@Override
	public String getSaleState(int saleNo) {
		return normalDAO.getSaleState(saleNo);
	}
	@Override
	public List<Product> getProductList() {
		return normalDAO.getProductList();
	}
	@Override
	public Product getProduct(int pNo) {
		return normalDAO.getProduct(pNo);
	}
	@Override
	public List<Category> getCategoryList() {
		return normalDAO.getCategoryList();
	}
	@Override
	public List<Normal> getNormalListByCateNo(int cateNo) {
		return normalDAO.getNormalListByCateNo(cateNo);
	}
	@Override
	public int getLastSaleNo() {
		return normalDAO.getLastSaleNo();
	}
	@Override
	public void addNormalImage(int saleNo, String string) {
		normalDAO.addNormalImage(saleNo, string);
		
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
	@Override
	public void normalPayment(Payment payment) {
		paymentDAO.normalPayment(payment);
	}
	@Override
	public int getLastPayNo() {
		return paymentDAO.getLastPayNo();
	}

	//-------------------------------------------------------------------------
	//Refund
	//-------------------------------------------------------------------------
		
	@Override
	public int refundSale(Refund refund) {
		return refundDAO.refundSale(refund);
	}

	@Override
	public Refund getRefund(int refundNo) {
		return refundDAO.getRefund(refundNo);
	}

	@Override
	public List<Refund> getRefundList(int userNo) {
		return refundDAO.getRefundList(userNo);
	}
	@Override
	public int getLastRefundNo() {
		return refundDAO.getLastRefundNo();
	}
	
}
