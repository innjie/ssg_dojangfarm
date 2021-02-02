package com.ssg.dojangfarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.dojangfarm.dao.QnADAO;
import com.ssg.dojangfarm.domain.QnA;

@Service("QnAServiceImpl")
public class QnAServiceImpl implements QnAService{

	@Autowired
	private QnADAO qnaDAO;

	public List<QnA> getQnAList(int saleNo) {
		return qnaDAO.getQnAList(saleNo);
	}

	public void questionQnA(QnA qna) {
		qnaDAO.questionQnA(qna);
	}

	public void answerQnA(int qNo, String answer){
		qnaDAO.answerQnA(qNo, answer);
	}
	public QnA getQnA(int qNo) {
		return qnaDAO.getQnA(qNo);
	}
}
