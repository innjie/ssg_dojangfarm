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

//commonnotice controlelr
@Controller
public class CommonNoticeController {
	@Autowired
	private CommonNoticeService commonNoticeService;
	
	//go main
	@RequestMapping("/index")
	public String goMain(Model model) {
		//확인 필요
		return "/index";
	}

	//get CN List
	@RequestMapping("/farm/commonNotice/list")
	public String getCNList(Model model ) {
		List<CommonNotice> cnList = commonNoticeService.getAllNoticeList();
		model.addAttribute("cnList", cnList);
		return "commonnotice/CommonNoticeListView";
	}
	//get CN view
	@RequestMapping("/farm/commonNotice/{userId}")
	public String getCN(@PathVariable String userId, Model  model) {
		CommonNotice cn = commonNoticeService.getCN(userId);
		if(cn == null) {
			return "commonnotice/CnNotFound";
		}
		model.addAttribute("cn", cn);
		return "commonNotice/CommonNoticeView";
	}
	
	//insert CN
	@ModelAttribute("commonnotice")
	@RequestMapping("/farm/commonNotice/insert")
	public String insertCN(@ModelAttribute("cn") CommonNotice commonnotice,
			BindingResult resut) {
		
		//insert function
		//insert -> list
		return "redirect:/commonNotice/list";
	}
	//update CN
	@ModelAttribute("commonnotice")
	@RequestMapping("/farm/commonNotice/update")
	public String updateCN(@ModelAttribute("cn") CommonNotice commonnotice,
			BindingResult resut) {
		
		//update fuction
		//update -> list
		return "redirect:/commonNotice/list";
	}
	
	//delete CN
	@ModelAttribute("commonnotice")
	@RequestMapping("/farm/commonNotice/delete")
	public String deleteCN(@ModelAttribute("cn") CommonNotice commonnotice,
			BindingResult result) {
		//delete function
		//after -> list
		return "redirect:/commonNotice/list";
	}
}
