package com.ssg.dojangfarm.dao.mybatis.mapper;

import java.util.List;

import com.ssg.dojangfarm.domain.Message;
import com.ssg.dojangfarm.domain.User;

public interface MessageMapper {
	void sendMsg(Message msg);	//send Message
	void deleteMsg(int msgNo);	// just change deleteState
	List<Message> sendMessageList(int userNo);	
	List<Message> receiveMessageList(int userNo);	
	List<Message> findMsg(String title);  //find Message by title
	Message checkMsg(int msgNo);  //check Message == get

	int getRUserNo(int msgNo);
	int getSUserNo(int msgNo);
}
