package com.ssg.dojangfarm.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssg.dojangfarm.dao.MessageDAO;
import com.ssg.dojangfarm.dao.mybatis.mapper.MessageMapper;
import com.ssg.dojangfarm.domain.Message;
import com.ssg.dojangfarm.domain.User;

@Repository
public class MybatisMessageDAO implements MessageDAO{
	@Autowired
	private MessageMapper messageMapper;
	
	public void sendMsg(Message msg) {
		messageMapper.sendMsg(msg);
	}	
	public void sendCMsg(Message msg) {
		messageMapper.sendCMsg(msg);
	}	
	public void deleteMsg(int msgNo) {
		messageMapper.deleteMsg(msgNo);
	}	
	public List<Message> sendMessageList(int userNo) {
		return messageMapper.sendMessageList(userNo);
	}	
	public List<Message> receiveMessageList(int userNo) {
		return messageMapper.receiveMessageList(userNo);
	}	
	public List<Message> findMsg(String title) {
		return messageMapper.findMsg("%" + title + "%");
	}  
	
	@Transactional
	public Message checkMsg(int msgNo) {
		messageMapper.changeReadState(msgNo);
		return messageMapper.checkMsg(msgNo);
	}
	public Message checkSMsg(int msgNo) {
		return messageMapper.checkMsg(msgNo);
	}
	public Message checkMsgWithCMsg(int msgNo) {
		return messageMapper.checkMsgWithCMsg(msgNo);
	}
	public int getRUserNo(int msgNo) {
		return messageMapper.getRUserNo(msgNo);
	}
	
	public int getSUserNo(int msgNo) {
		return messageMapper.getSUserNo(msgNo);
	}

}
