package com.ssg.dojangfarm.controller.commonnotice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssg.dojangfarm.domain.CommonNotice;
import com.ssg.dojangfarm.service.CommonNoticeService;

//공동구매 공지 컨트롤러
@Controller
public class CommonNoticeController {
	@Autowired
	private CommonNoticeService commonNoticeService;
	
	//메인으로
	@RequestMapping("/index")
	public String goMain(Model model) {
		//확인 필요
		return "/index";
	}

	//리스트
	@RequestMapping("/farm/commonNotice/list")
	public String getCNList(Model model ) {
		List<CommonNotice> cnList = commonNoticeService.getAllNoticeList();
		model.addAttribute("cnList", cnList);
		return "commonnotice/CommonNoticeListView";
	}
	//각 페이지 불러오기
	@RequestMapping("/farm/commonNotice/{userId}")
	public String getCN(@PathVariable String userId, Model  model) {
		CommonNotice cn = commonNoticeService.getCN(userId);
		if(cn == null) {
			return "commonnotice/CnNotFound";
		}
		model.addAttribute("cn", cn);
		return "commonNotice/CommonNoticeView";
	}
	
	//공구공지 추가
	@ModelAttribute("commonnotice")
	@RequestMapping("/farm/commonNotice/insert")
	public String insertCN(@ModelAttribute("cn") CommonNotice commonnotice,
			BindingResult resut) {
		
		//insert 동작
		//insert 이후 리스트로 복귀
		return "redirect:/commonNotice/list";
	}
	//공구공지 수정
	@ModelAttribute("commonnotice")
	@RequestMapping("/farm/commonNotice/update")
	public String updateCN(@ModelAttribute("cn") CommonNotice commonnotice,
			BindingResult resut) {
		
		//update 동작
		//update 이후 리스트로 복귀
		return "redirect:/commonNotice/list";
	}
}
