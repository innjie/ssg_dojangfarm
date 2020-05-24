package com.ssg.dojangfarm.controller.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.dojangfarm.domain.Message;
import com.ssg.dojangfarm.domain.Normal;
import com.ssg.dojangfarm.service.FarmFacade;

@Controller
public class MessageController { 
	private static final String FORMMESSAGE = "message/MessageFormView";
	private static final String VIEWMESSAGE = "message/MessageView";
	private static final String LISTRECEIVEMESSAGE = "message/ReceiveMessageListView";
	private static final String LISTSENDMESSAGE = "message/SendMessageListView";
	
	private FarmFacade farm;

	@Autowired
	public void setFarm(FarmFacade farm) {
		this.farm = farm;
	}
	
	//view SendMessageList
	@RequestMapping("/message/viewSendMessageList.do")
	public String listSendMsg(
			ModelMap model,
			HttpServletRequest request) throws Exception {

		HttpSession httpSession = request.getSession();
		int userNo = (int) httpSession.getAttribute("userNo");
		
		PagedListHolder<Message> sendMessageList= new PagedListHolder<Message>(this.farm.sendMessageList(userNo));

		sendMessageList.setPageSize(4);
		model.put("sendMessageList", sendMessageList);
		return LISTSENDMESSAGE;   
	}

/*	//view SendMessageList by page
	@RequestMapping("/message/viewSendMessageList2.do")
	public String listSendMsg2(
			@RequestParam("page") String page,
			@ModelAttribute("sendMessageList") PagedListHolder<Message> sendMessageList,
			BindingResult result) throws Exception {
		
		if (sendMessageList== null) {
			throw new IllegalStateException("Cannot find pre-loaded sendMessage list");
		}
		if ("next".equals(page)) { 
			sendMessageList.nextPage(); 
		}
		else if ("previous".equals(page)) {
			sendMessageList.previousPage(); 
		}
		
		return LISTSENDMESSAGE;
	}
*/
	
	//view ReceiveMessageList 
	@RequestMapping("/message/viewReceiveMessageList.do")
	public String listReceiveMsg(
			ModelMap model,
			HttpServletRequest request) throws Exception {
		
		HttpSession httpSession = request.getSession();
		int userNo = (int) httpSession.getAttribute("userNo");

		PagedListHolder<Message> receiveMessageList = new PagedListHolder<Message>(this.farm.receiveMessageList(userNo));

		receiveMessageList.setPageSize(4);
		model.put("receiveMessageList ", receiveMessageList );
		return LISTRECEIVEMESSAGE;
	}

/*	//view ReceiveMessageList by page
	@RequestMapping("/message/viewReceiveMessageList2.do")
	public String listReceiveMsg2(
			@RequestParam("page") String page,
			@ModelAttribute("receiveMessageList ") PagedListHolder<Message> receiveMessageList ,
			BindingResult result) throws Exception {
		
		if (receiveMessageList == null) {
			throw new IllegalStateException("Cannot find pre-loaded receive message list");
		}
		if ("next".equals(page)) { 
			receiveMessageList .nextPage();
		}
		else if ("previous".equals(page)) { 
			receiveMessageList .previousPage();
		}
		
		return LISTRECEIVEMESSAGE;
	}
*/
	
	//view Message detail
	@RequestMapping("/message/viewMessage.do")
	public String messageView(
			@RequestParam("msgNo") int msgNo,
			@RequestParam("type") String type,
			ModelMap model) throws Exception {
		
		Message message = this.farm.checkMsg(msgNo);
		model.put("message", message );
		model.put("type", type );
		
		return VIEWMESSAGE;
	}

	//find Message
	@RequestMapping("/message/viewFindMessageList.do")
	public String findMsg(
			@RequestParam("title") String title,
			@RequestParam("type") String type,
			ModelMap model) throws Exception {

		PagedListHolder<Message> findMessageList= new PagedListHolder<Message>(this.farm.findMsg(title));

		findMessageList.setPageSize(4);
		model.put("findMessageList", findMessageList);
		
		if(type.equals("receive")) {
			return LISTRECEIVEMESSAGE;
		}
		else {
			return LISTSENDMESSAGE;
		}
	}

/*	//find Message by page
	@RequestMapping("/message/viewFindMessageList2.do")
	public String findMsg2(
			@RequestParam("page") String page,
			@ModelAttribute("findMessageList") PagedListHolder<Message> findMessageList,
			BindingResult result) throws Exception {
		if (findMessageList == null) {
			throw new IllegalStateException("Cannot find pre-loaded message list");
		}
		if ("next".equals(page)) { 
			findMessageList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			findMessageList.previousPage(); 
		}
		
		return "FindMessageList";
	}
*/
	
	//delete message from list (update message's deleteState)
	@RequestMapping("/message/deleteMsg.do")
	public String deleteMsg(
			@RequestParam("msgNo") int msgNo,
			@RequestParam("type") String type,
			HttpServletRequest request) throws Exception {
		
		HttpSession httpSession = request.getSession();
		int userNo = (int) httpSession.getAttribute("userNo");
		int msgUserNo;
		
		if(type.equals("receive")) {
			//msgUserNo = this.farm.getRUserNo(msgNo);	//message.rUser.userNo 가져오는 dao
		}
		else {
			//msgUserNo = this.farm.getSUserNo(msgNo);		//message.sUser.userNo 가져오는 dao
		}
		
	//	if(userNo == msgUserNo) {
			this.farm.deleteMsg(msgNo);	
	//	}

		if(type.equals("receive")) {
			return "redirect:/message/viewReceiveMessageList.do";
		}
		else {
			return "redirect:/message/viewSendMessageList.do";
		}
	}

//	//send message ... view message form
//	@RequestMapping(value = "/message/sendMsg.do",  method = RequestMethod.GET)
//	public ModelAndView messageForm(
//			@RequestParam(value = "saleNo", defaultValue="-1") int saleNo,
//			@RequestParam(value = "msgNo", defaultValue="-1") int msgNo) throws Exception {
//		
//		//첫 메세지
//		if(msgNo == -1) {
//			Normal normal = this.farm.getNormalBySaleNo(saleNo)		//saleNo로 normal가져옴
//			
//			return new ModelAndView(FORMMESSAGE, "normal", normal);
//		}
//		//연관 메세지 있음 (답장)
//		else {
//			Message cMsg = this.farm.getMessageByMsgNo(msgNo);	//msgNo로 message가져옴
//			
//			return new ModelAndView(FORMMESSAGE, "cMsg", cMsg);
//		}
//	}
	
//	//send message ... insert message 
//	@RequestMapping(value = "/message/sendMsg.do",  method = RequestMethod.POST)
//	public String sendMsg(
//			@RequestParam(value = "cMsg", required = false) Message cMsg,
//			@RequestParam(value = "normal", required = false) Normal normal,
//			@RequestParam("title") String title,
//			@RequestParam("content") String content,
//			HttpServletRequest request) throws Exception {
//
//		HttpSession httpSession = request.getSession();
//		int userNo = (int) httpSession.getAttribute("userNo");
//		Message msg;
//		int rUserNo;
//		
//		if(cMsg != null) {
//			rUserNo = this.farm.getUserNoByMsgNo(cMsg.getMsgNo());	//add dao
//			msg = new Message(userNo, rUserNo, title, content);
//			msg.setcMsg(cMsg);
//			msg.setNormal(cMsg.getNormal());
//		}
//		else {
//			rUserNo = this.farm.getUserNoBySaleNo(normal.getSaleNo());	//add dao
//			msg = new Message(userNo, rUserNo, title, content);
//			msg.setNormal(normal);
//		}
//		
//		this.farm.sendMsg(msg);	
//
//		return "redirect:/message/viewMessage.do?msgNo=" + msg.getMsgNo();
//	
//	}

}

