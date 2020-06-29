package com.ssg.dojangfarm.controller.normal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.dojangfarm.domain.Normal;
import com.ssg.dojangfarm.domain.QnA;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;

@Controller
@SessionAttributes("qnaList")
public class QnAController {
	private static final String LISTQNA = "normal/QnAListView";
	private static final String ANSWERQNA = "normal/AnswerQnAFormView";

	@Autowired
	private FarmFacade farm;

	public void setFarm(FarmFacade  farm) {
		this.farm = farm;
	}

	//view QnAList
	@RequestMapping("/normal/viewQnAList.do")
	public String handleRequest(
			@RequestParam("saleNo") int saleNo,
			ModelMap model) throws Exception {
		PagedListHolder<QnA> qnaList = new PagedListHolder<QnA>(this.farm.getQnAList(saleNo));
		
		qnaList.setPageSize(10);
		model.put("qnaList", qnaList);
		model.put("saleNo", saleNo);

		return LISTQNA;   
	}

	//view QnAList by page
	@RequestMapping("/normal/viewQnAList2.do")
	public String handleRequest2(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam("saleNo") int saleNo,
			@ModelAttribute("qnaList") PagedListHolder<QnA> qnaList,
			BindingResult result,
			@RequestParam(required = false) String ques,
			@RequestParam(required = false) String quesNo,
			ModelMap model) throws Exception {

		if (qnaList== null) {
			throw new IllegalStateException("Cannot find pre-loaded QnA list");
		}
		if ("next".equals(page)) {
			qnaList.nextPage(); 
		}
		else if ("previous".equals(page)) {
			qnaList.previousPage(); 
		}
		
		model.put("saleNo", saleNo);
		if(ques != null) {
			model.put("ques", ques);
			model.put("quesNo", Integer.parseInt(quesNo));
		}
		
		return LISTQNA;
	}

	//question ... insert QnA and view QnAList
	@RequestMapping("/normal/questionQnA.do")
	public String question(
			@RequestParam("saleNo") String saleNo,
			@RequestParam("question") String question,
			@RequestParam(required = false) Boolean secret,
			HttpServletRequest request,
			Model model) throws Exception {

		System.out.println("question!");
		System.out.println("saleNo! " + saleNo);
		System.out.println("question! " + question);
		System.out.println("secret! " + secret);
		
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");

		User saleUser = this.farm.getNormalSale(Integer.parseInt(saleNo)).getUser();
		
		if(user.getUserNo() == saleUser.getUserNo()) {
			System.out.println("can't question! ");

			return "redirect:/normal/viewQnAList.do?saleNo=" + saleNo + "&message=It is your sale";
		}
		
		if(secret == null) {
			secret = false;
		}
		
		if(question.equals("")) {
			System.out.println("no question! ");

			return "redirect:/normal/viewQnAList.do?saleNo=" + saleNo + "&message=No Question";
		}
		
		QnA qna = new QnA();
		qna.setqUser(user);
		Normal normal = new Normal();
		normal.setSaleNo(Integer.parseInt(saleNo));
		qna.setNormal(normal);
		qna.setQuestion(question);
		qna.setSecret(secret);
		
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
		User user = (User) httpSession.getAttribute("user");
		
		QnA qna = this.farm.getQnA(qNo);	
		model.put("qna", qna);
			
		return ANSWERQNA;
	}

	//answer ... update QnA
	@RequestMapping(value = "/normal/answerQnA.do", method = RequestMethod.POST)
	public String answer(
			@RequestParam("saleNo") int saleNo,
			@RequestParam("qNo") int qNo,
			@RequestParam("answer") String answer,
			ModelMap model) throws Exception {

		
		if(answer.equals("")) {
			System.out.println("no Anaswer! ");
			model.addAttribute("message", "No Anaswer");
			return "redirect:/normal/answerQnA.do?saleNo=" + saleNo + "&qNo=" + qNo + "&message=No Anaswer";
		}
		
		this.farm.answerQnA(qNo, answer);

		return "redirect:/normal/viewQnAList.do?saleNo=" + saleNo;
	}


}
