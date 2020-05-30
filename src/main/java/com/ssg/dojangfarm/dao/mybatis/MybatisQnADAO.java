package com.ssg.dojangfarm.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssg.dojangfarm.dao.QnADAO;
import com.ssg.dojangfarm.dao.mybatis.mapper.QnAMapper;
import com.ssg.dojangfarm.domain.QnA;

@Repository
public class MybatisQnADAO implements QnADAO{
	@Autowired
	private QnAMapper qnaMapper;
	
	public List<QnA> getQnAList(int saleNo) {
		return qnaMapper.getQnAList(saleNo);
	}
	public void questionQnA(QnA qna) {
		qnaMapper.questionQnA(qna);
	}		
	public void answerQnA(int qNo, String answer) {
		qnaMapper.answerQnA(qNo, answer);
	}		
	
	public QnA getQnA(int qNo) {
		return qnaMapper.getQnA(qNo);
	}
}
