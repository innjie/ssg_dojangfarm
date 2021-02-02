package com.ssg.dojangfarm.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssg.dojangfarm.domain.QnA;

@Component
@WebService(serviceName="QnAService") 
public class QnAServiceEndpoint {
	@Autowired
	QnAService qnaService;		// inject QnAServiceImpl
	
	@WebMethod
	public List<QnA> getQnAList(int saleNo) {
		return qnaService.getQnAList(saleNo);
	}

	@WebMethod
	public void questionQnA(QnA qna) {
		qnaService.questionQnA(qna);
	}

	@WebMethod
	public void answerQnA(int qNo, String answer) {
		qnaService.answerQnA(qNo, answer);
	}

	@WebMethod
	public QnA getQnA(int qNo) {
		return qnaService.getQnA(qNo);
	}
}
