package com.ssg.dojangfarm.controller.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.dojangfarm.domain.Message;
import com.ssg.dojangfarm.domain.Normal;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;

@Controller
@SessionAttributes({"sendMessageList", "receiveMessageList", "findMessageList"})
public class MessageController { 
	private static final String FORMMESSAGE = "message/MessageFormView";
	private static final String VIEWMESSAGE = "message/MessageView";
	private static final String LISTRECEIVEMESSAGE = "message/ReceiveMessageListView";
	private static final String LISTSENDMESSAGE = "message/SendMessageListView";
	
	@Autowired
	private FarmFacade farm;

	public void setFarm(FarmFacade farm) {
		this.farm = farm;
	}
	
	//view SendMessageList
	@RequestMapping("/message/viewSendMessageList.do")
	public String listSendMsg(
			ModelMap model,
			HttpServletRequest request) throws Exception {
		
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");

		System.out.println("send message list " + user.getUserNo());

		PagedListHolder<Message> sendMessageList= new PagedListHolder<Message>(this.farm.sendMessageList(user.getUserNo()));

		sendMessageList.setPageSize(10);
		model.put("sendMessageList", sendMessageList);
		return LISTSENDMESSAGE;   
	}

	//view SendMessageList by page
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

	
	//view ReceiveMessageList 
	@RequestMapping("/message/viewReceiveMessageList.do")
	public String listReceiveMsg(
			ModelMap model,
			HttpServletRequest request) throws Exception {
		
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");

		PagedListHolder<Message> receiveMessageList = new PagedListHolder<Message>(this.farm.receiveMessageList(user.getUserNo()));

		receiveMessageList.setPageSize(10);
		model.put("receiveMessageList", receiveMessageList);
		return LISTRECEIVEMESSAGE;
	}

	//view ReceiveMessageList by page
	@RequestMapping("/message/viewReceiveMessageList2.do")
	public String listReceiveMsg2(
			@RequestParam("page") String page,
			@ModelAttribute("receiveMessageList") PagedListHolder<Message> receiveMessageList ,
			BindingResult result) throws Exception {
		
		if(receiveMessageList == null) {
			throw new IllegalStateException("Cannot find pre-loaded receive message list");
		}
		if("next".equals(page)) { 
			receiveMessageList.nextPage();
		}
		else if("previous".equals(page)) { 
			receiveMessageList.previousPage();
		}
		
		return LISTRECEIVEMESSAGE;
	}

	
	//view Message detail
	@RequestMapping("/message/viewMessage.do")
	public String messageView(
			@RequestParam("msgNo") int msgNo,
			@RequestParam("type") String type,
			ModelMap model) throws Exception {
		
		Message message;
		if(type.equals("receive")) {
			System.out.println("receive-");
			message  = this.farm.checkMsg(msgNo);
		}
		else {
			System.out.println("send-");
			message = this.farm.checkSMsg(msgNo);
		}
		model.put("message", message );
		model.put("type", type );
		
		return VIEWMESSAGE;
	}

	//find Message
	@RequestMapping("/message/findMessageList.do")
	public String findMsg(
			@RequestParam("title") String title,
			ModelMap model) throws Exception {
		
		PagedListHolder<Message> findMessageList = new PagedListHolder<Message>(this.farm.findMsg(title));
		findMessageList.setPageSize(10);
		
		model.put("title", title);
		model.put("find", "find");
		model.put("findMessageList", findMessageList);

		return LISTSENDMESSAGE;
	}
	


	//find Message by page
	@RequestMapping("/message/viewFindMessageList2.do")
	public String findMsg2(
			@RequestParam("page") String page,
			@RequestParam("title") String title,
			@ModelAttribute("findMessageList") PagedListHolder<Message> findMessageList,
			BindingResult result,
			ModelMap model) throws Exception {
		if (findMessageList == null) {
			throw new IllegalStateException("Cannot find pre-loaded message list");
		}
		if ("next".equals(page)) { 
			findMessageList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			findMessageList.previousPage(); 
		}
		
		model.put("find", "find");
		model.put("title", title);
		model.put("findMessageList", findMessageList);
		
		return LISTSENDMESSAGE;
		
	}

	
	//delete message from list (update message's deleteState)
	@RequestMapping("/message/deleteMsg.do")
	public String deleteMsg(
			@RequestParam("msgNo") int msgNo,
			@RequestParam("type") String type,
			HttpServletRequest request) throws Exception {
		
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		int msgUserNo;
		
		if(type.equals("receive")) {
			msgUserNo = this.farm.getRUserNo(msgNo);	
		}
		else {
			msgUserNo = this.farm.getSUserNo(msgNo);		
		}
		
		if(user.getUserNo() == msgUserNo) {
			this.farm.deleteMsg(msgNo);	
		}

		if(type.equals("receive")) {
			return "redirect:/message/viewReceiveMessageList.do";
		}
		else {
			return "redirect:/message/viewSendMessageList.do";
		}
	}

	//send message ... view message form
	@RequestMapping(value = "/message/sendMsg.do",  method = RequestMethod.GET)
	public ModelAndView messageForm(
			@RequestParam(value = "saleNo", defaultValue="-1") int saleNo,
			@RequestParam(value = "msgNo", defaultValue="-1") int msgNo) throws Exception {
		
		//첫 문의
		if(msgNo == -1) {
			Normal normal = this.farm.getNormalSale(saleNo);	
			
			return new ModelAndView(FORMMESSAGE, "normal", normal);
		}
		//답장
		else {
			Message cMsg = this.farm.checkMsgWithCMsg(msgNo);	
			
			return new ModelAndView(FORMMESSAGE, "cMsg", cMsg);
		}
	}
	
	//send message ... insert message 
	@RequestMapping(value = "/message/sendMsg.do",  method = RequestMethod.POST)
	public String sendMsg(
			@RequestParam(value = "cMsgNo", required = false) String cMsgNo,
			@RequestParam(value = "saleNo", required = false) String saleNo,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			HttpServletRequest request,
			Model model) throws Exception {

		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		Message msg = new Message();
		int rUserNo;
		
		System.out.println("cMsgNo : " + cMsgNo);
		System.out.println("saleNo: " + saleNo);
		
		if(title.equals("")) {
			System.out.println("no title! ");
			
			if(!cMsgNo.equals(""))
				return "redirect:/message/sendMsg.do?msgNo=" + Integer.parseInt(cMsgNo) + "&message=No title";
			else
				return "redirect:/message/sendMsg.do?saleNo=" + Integer.parseInt(saleNo) + "&message=No title";
		}
		
		if(content.equals("")) {
			System.out.println("no title! ");
			
			if(!cMsgNo.equals(""))
				return "redirect:/message/sendMsg.do?msgNo=" + Integer.parseInt(cMsgNo) + "&message=No content";
			else
				return "redirect:/message/sendMsg.do?saleNo=" + Integer.parseInt(saleNo) + "&message=No content";
		}
		
		if(!cMsgNo.equals("")) {
			Message cMsg = this.farm.checkMsg(Integer.parseInt(cMsgNo));
			msg.setrUser(cMsg.getsUser());
			msg.setsUser(user);
			msg.setTitle(title);
			msg.setContent(content);			
			msg.setcMsg(cMsg);
			msg.setNormal(cMsg.getNormal());
			
			this.farm.sendCMsg(msg);	
		}
		else {
			Normal normal = this.farm.getNormalSale(Integer.parseInt(saleNo));
			rUserNo = this.farm.getUserByNormal(Integer.parseInt(saleNo));	//add dao
			User rUser = new User();
			rUser.setUserNo(rUserNo);
			msg.setsUser(user);
			msg.setrUser(rUser);
			msg.setTitle(title);
			msg.setContent(content);
			msg.setNormal(normal);
			
			this.farm.sendMsg(msg);	
		}

		return "redirect:/message/viewMessage.do?type=send&msgNo=" + msg.getMsgNo();
	
	}

}

