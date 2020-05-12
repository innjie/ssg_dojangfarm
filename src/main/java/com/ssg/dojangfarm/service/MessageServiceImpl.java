package com.ssg.dojangfarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.dojangfarm.dao.MessageDAO;
import com.ssg.dojangfarm.domain.Message;

@Service("MessageServiceImpl")
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageDAO messageDAO;

	public void sendMsg(Message msg) {
		messageDAO.sendMsg(msg);
	}

	public void deleteMsg(int msgNo) {
		messageDAO.deleteMsg(msgNo);
	}

	public List<Message> sendMessageList(int userNo) {
		return messageDAO.sendMessageList(userNo);
	}

	public List<Message> receiveMessageList(int userNo) {
		return messageDAO.receiveMessageList(userNo);
	}

	public List<Message> findMsg(String title) {
		return messageDAO.findMsg(title);
	}

	public Message checkMsg(int msgNo) {
		return messageDAO.checkMsg(msgNo);
	}

}

