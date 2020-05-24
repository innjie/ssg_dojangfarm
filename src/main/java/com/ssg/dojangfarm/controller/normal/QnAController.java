package com.ssg.dojangfarm.controller.normal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.dojangfarm.domain.QnA;
import com.ssg.dojangfarm.service.FarmFacade;

@Controller
public class QnAController {
	private static final String LISTQNA = "normal/QnAListView";
	private static final String ANSWERQNA = "member/AnswerQnAFormView";
	
	private FarmFacade farm;
	
	@Autowired
	public void setFarm(FarmFacade  farm) {
		this.farm = farm;
	}

	//view QnAList
	@RequestMapping("/normal/viewQnAList.do")
	public String listQnA(
			@RequestParam("saleNo") int saleNo,
			@RequestParam("ques") int ques,
			@RequestParam("quesNo") int quesNo,
			ModelMap model) throws Exception {
		PagedListHolder<QnA> qnaList = new PagedListHolder<QnA>(this.farm.getQnAList(saleNo));

		qnaList.setPageSize(4);
		model.put("ques", ques );
		model.put("quesNo", quesNo );
		model.put("qnaList", qnaList );
		
		return LISTQNA;   
	}

	//view QnAList by page
	@RequestMapping("/normal/viewQnAList2.do")
	public String listQnA2(
			@RequestParam("page") String page,
			@ModelAttribute("qnaList") PagedListHolder<QnA> qnaList,
			BindingResult result) throws Exception {
		
		if (qnaList== null) {
			throw new IllegalStateException("Cannot find pre-loaded QnA list");
		}
		if ("next".equals(page)) {
			qnaList.nextPage(); 
		}
		else if ("previous".equals(page)) {
			qnaList.previousPage(); 
		}
		
		return LISTQNA;
	}

	//question ... insert QnA and view QnAList
	@RequestMapping("/normal/questionQnA.do")
	public String question(
			@RequestParam("saleNo") int saleNo,
			@RequestParam("question") String question,
			@RequestParam("secret") Boolean secret,
			HttpServletRequest request) throws Exception {
		
		HttpSession httpSession = request.getSession();
		String id = (String) httpSession.getAttribute("id");
		
		QnA qna = new QnA(id, saleNo, question, secret);
		this.farm.questionQnA(qna);

		return "redirect:/normal/viewQnAList.do?saleNo=" + saleNo;
	}

	//answer ... view answer form 
	@RequestMapping(value = "/normal/answerQnA.do", method = RequestMethod.GET)
	public String  answerForm(
			@RequestParam("saleNo") int saleNo,
			@RequestParam("qNo") int qNo,
			HttpServletRequest request, 
			ModelMap model) throws Exception {

		HttpSession httpSession = request.getSession();
		int userNo = (int) httpSession.getAttribute("userNo");
		//String id = (String) httpSession.getAttribute("id"); //No도 ok
//		int saleUserNo = this.farm.getUserNoBySale(saleNo);	//saleNo로 userNo알아내기
//		
//		//어차피 c:if로 주인만 수정 버튼 나오기는 함
//		if(saleUserNo == userNo) {  //판매번호로 판매 알아온다음 거기 저장된 번호 가져오기
//			QnA qna = this.farm.getQnA(qNo);	//qNo로 QnA객체 반환하는 dao 필요함
//			model.put("qna", qna);
//			
//			return ANSWERQNA;
//		}
		
		return "redirect:/normal/viewQnAList.do?saleNo=" + saleNo;
	}

	//answer ... update QnA
	@RequestMapping(value = "/normal/answerQnA.do", method = RequestMethod.POST)
	public String answer(
			@RequestParam("saleNo") int saleNo,
			@RequestParam("qNo") int qNo,
			@RequestParam("answer") String answer
			) throws Exception {
		
		//validation으로 널 걸러주기는 함
		if(answer != null) {
			this.farm.answerQnA(qNo, answer);
		}

		return "redirect:/normal/viewQnAList.do?saleNo=" + saleNo;
	}


}
