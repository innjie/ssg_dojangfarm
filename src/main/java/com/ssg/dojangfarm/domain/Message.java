package com.ssg.dojangfarm.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Message implements Serializable{
	private int msgNo;
	private User sUser;	//send
	private User rUser;	//receive
	private Message cMsg;		//connected
	private Normal normal;
	private Boolean read;
	private String title;
	private String content;
	private Date sDate;		//send
	private Boolean deleteState;
	
	
	public Message(int sUserNo, int rUserNo, String title, String content) {
		this.sUser.setUserNo(sUserNo);
		this.rUser.setUserNo(rUserNo);
		this.title = title;
		this.content = content;
	}
	public int getMsgNo() {
		return msgNo;
	}
	public void setMsgNo(int msgNo) {
		this.msgNo = msgNo;
	}
	public User getsUser() {
		return sUser;
	}
	public void setsUser(User sUser) {
		this.sUser = sUser;
	}
	public User getrUser() {
		return rUser;
	}
	public void setrUser(User rUser) {
		this.rUser = rUser;
	}
	public Message getcMsg() {
		return cMsg;
	}
	public void setcMsg(Message cMsg) {
		this.cMsg = cMsg;
	}
	public Normal getNormal() {
		return normal;
	}
	public void setNormal(Normal narmal) {
		this.normal = narmal;
	}
	public Boolean getRead() {
		return read;
	}
	public void setRead(Boolean read) {
		this.read = read;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getsDate() {
		return sDate;
	}
	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}
	public Boolean getDeleteState() {
		return deleteState;
	}
	public void setDeleteState(Boolean deleteState) {
		this.deleteState = deleteState;
	}
	
	
}