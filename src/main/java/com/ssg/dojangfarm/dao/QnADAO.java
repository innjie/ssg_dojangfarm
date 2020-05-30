package com.ssg.dojangfarm.dao;

import java.util.List;

import com.ssg.dojangfarm.domain.QnA;

public interface QnADAO {
	List<QnA> getQnAList(int saleNo);
	void questionQnA(QnA qna);		//insert QnA - buyer
	void answerQnA(int qNo, String answer);		//update QnA by answering - seller
	QnA getQnA(int qNo);
}
