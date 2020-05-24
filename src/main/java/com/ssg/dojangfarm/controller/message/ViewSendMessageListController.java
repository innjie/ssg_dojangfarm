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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.dojangfarm.domain.Message;
import com.ssg.dojangfarm.service.FarmFacade;

@Controller
public class ViewSendMessageListController { 
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
//	@RequestMapping("/message/sendMsg.do")
//	public ModelAndView messageForm(
//			@RequestParam("saleNo") int saleNo,
//			@RequestParam("msgNo") int msgNo) throws Exception {
//		
//		//첫 메세지
//		if(msgNo == null) {
//			
//		}
//		//연관 메세지 있음 (답장)
//		else {
//			
//		}
//	
//	
//		//이 메세지는 관련 메세지(답장 할)
//		Message message = this.farm.getMessageByMsgNo(msgNo);	//message 가져옴
//
//		return new ModelAndView(FORMMESSAGE, "message", message);
//	}
	
	//send message ... insert message 
	@RequestMapping("/message/sendMsg.do")
	public String sendMsg(
			@RequestParam("rUserNo") int rUserNo,
			@RequestParam("cMsg") Message cMsg,
			@RequestParam("saleNo") int saleNo,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			HttpServletRequest request) throws Exception {

		HttpSession httpSession = request.getSession();
		int userNo = (int) httpSession.getAttribute("userNo");

		Message msg = new Message(userNo, rUserNo, cMsg.getMsgNo(), saleNo, title, content);
		this.farm.sendMsg(msg);	

		return "redirect:/message/viewMessage.do?msgNo=" + msg.getMsgNo();
	
	}

}

