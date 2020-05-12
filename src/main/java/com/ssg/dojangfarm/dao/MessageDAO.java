package com.ssg.dojangfarm.dao;

import java.util.List;

import com.ssg.dojangfarm.domain.Message;

public interface MessageDAO {
	void sendMsg(Message msg);	//send Message
	void deleteMsg(int msgNo);	// just change deleteState
	List<Message> sendMessageList(int userNo);	
	List<Message> receiveMessageList(int userNo);	
	List<Message> findMsg(String title);  //find Message by title
	Message checkMsg(int msgNo);  //check Message == get

}
