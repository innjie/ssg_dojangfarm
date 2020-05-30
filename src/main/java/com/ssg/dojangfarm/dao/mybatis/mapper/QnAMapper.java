package com.ssg.dojangfarm.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssg.dojangfarm.domain.QnA;

public interface QnAMapper {
	List<QnA> getQnAList(int saleNo);
	void questionQnA(QnA qna);		//insert QnA - buyer
	void answerQnA(@Param("qNo") int qNo, @Param("answer") String answer);		//update QnA by answering - seller
	QnA getQnA(int qNo);
}
