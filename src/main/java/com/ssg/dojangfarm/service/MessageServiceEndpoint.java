package com.ssg.dojangfarm.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssg.dojangfarm.domain.Message;

@Component
@WebService(serviceName="MessageService") 
public class MessageServiceEndpoint {
	@Autowired
	MessageService messageService;		// inject MessageServiceImpl
	
	@WebMethod
	public void sendMsg(Message msg) {
		messageService.sendMsg(msg);
	}

	@WebMethod
	public void deleteMsg(int msgNo){
		messageService.deleteMsg(msgNo);
	}

	@WebMethod
	public List<Message> sendMessageList(int userNo) {
		return messageService.sendMessageList(userNo);
	}

	@WebMethod
	public List<Message> receiveMessageList(int userNo) {
		return messageService.receiveMessageList(userNo);
	}

	@WebMethod
	public List<Message> findMsg(String title){
		return messageService.findMsg(title);
	}

	@WebMethod
	public Message checkMsg(int msgNo){
		return messageService.checkMsg(msgNo);
	}
}
