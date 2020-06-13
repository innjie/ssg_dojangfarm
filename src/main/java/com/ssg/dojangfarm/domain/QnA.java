package com.ssg.dojangfarm.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class QnA implements Serializable{
	private int qNo;
	private User qUser;
	private User aUser;
	private Normal normal;
	private String question;
	private Date qDate;		//question
	private String answer;
	private Boolean secret;
	
	public QnA() {
		super();
	}
	public int getqNo() {
		return qNo;
	}
	public void setqNo(int qNo) {
		this.qNo = qNo;
	}
	public User getqUser() {
		return qUser;
	}
	public void setqUser(User qUser) {
		this.qUser = qUser;
	}
	public User getaUser() {
		return aUser;
	}
	public void setaUser(User aUser) {
		this.aUser = aUser;
	}
	public Normal getNormal() {
		return normal;
	}
	public void setNormal(Normal normal) {
		this.normal = normal;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Date getqDate() {
		return qDate;
	}
	public void setqDate(Date qDate) {
		this.qDate = qDate;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Boolean getSecret() {
		return secret;
	}
	public void setSecret(Boolean secret) {
		this.secret = secret;
	}
	
	
}
