package com.ssg.dojangfarm.dao;

import java.util.List;

import com.ssg.dojangfarm.domain.Message;
import com.ssg.dojangfarm.domain.User;

public interface MessageDAO {
	void sendMsg(Message msg);	//send Message
	void sendCMsg(Message msg);	//send Message
	void deleteMsg(int msgNo);	// just change deleteState
	List<Message> sendMessageList(int userNo);	
	List<Message> receiveMessageList(int userNo);	
	List<Message> findMsg(String title);  //find Message by title
	Message checkMsg(int msgNo);  //check Message == get
	
	int getRUserNo(int msgNo);
	int getSUserNo(int msgNo);
	Message checkMsgWithCMsg(int msgNo);
	Message checkSMsg(int msgNo);
	
	List<Message> findReceiveMsg(String title);
	List<Message> findSendMsg(String title);
}
