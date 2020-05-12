package com.ssg.dojangfarm.service;

import java.util.List;

import com.ssg.dojangfarm.domain.Message;

//@WebService(name = "MessageService") 
public interface MessageService{
	void sendMsg(Message msg);
	void deleteMsg(int msgNo);
	List<Message> sendMessageList(int userNo);
	List<Message> receiveMessageList(int userNo);
	List<Message> findMsg(String title);
	Message checkMsg(int msgNo);
}

