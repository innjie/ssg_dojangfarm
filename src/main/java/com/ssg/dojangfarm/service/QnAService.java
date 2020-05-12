package com.ssg.dojangfarm.service;

import java.util.List;

import com.ssg.dojangfarm.domain.QnA;

//@WebService(name = "QnAService") 
public interface QnAService{
	List<QnA> getQnAList(int saleNo);
	void questionQnA(QnA qna);
	void answerQnA(int qNo, String answer);
}
