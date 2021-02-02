package com.ssg.dojangfarm.service;

import java.util.List;

import com.ssg.dojangfarm.domain.Message;
import com.ssg.dojangfarm.domain.User;

//@WebService(name = "MessageService") 
public interface MessageService{
	void sendMsg(Message msg);
	void sendCMsg(Message msg);
	void deleteMsg(int msgNo);
	List<Message> sendMessageList(int userNo);
	List<Message> receiveMessageList(int userNo);
	List<Message> findMsg(String title);
	Message checkMsg(int msgNo);
	
	int getRUserNo(int msgNo);
	int getSUserNo(int msgNo);
}

