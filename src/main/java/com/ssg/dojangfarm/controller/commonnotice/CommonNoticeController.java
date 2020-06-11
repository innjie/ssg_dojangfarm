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
	private CommonNoticeService commonNoticeService;
	
	@Autowired
	public void setCommonNoticeService(CommonNoticeService commonNoticeService) {
		this.commonNoticeService = commonNoticeService;
	}

	//get CN List
	@RequestMapping("/commonNotice/list.do")
	public String getCNList(Model model ) {
		List<CommonNotice> cnList = commonNoticeService.getAllNoticeList();
		model.addAttribute("cnList", cnList);
		return "commonnotice/CommonNoticeListView";
	}
	//get CN view
	@RequestMapping("/commonNotice/{userId}")
	public String getCN(@PathVariable int CNNo, Model  model) {
		CommonNotice cn = commonNoticeService.viewCommonNotice(CNNo);
		if(cn == null) {
			return "commonnotice/CnNotFound";
		}
		model.addAttribute("cn", cn);
		return "commonNotice/CommonNoticeView";
	}
	
	//insert CN
	@ModelAttribute("commonnotice")
	@RequestMapping("/commonNotice/insert.do")
	public String insertCN(@ModelAttribute("cn") CommonNotice commonnotice,
			BindingResult resut) {
		
		//insert function
		//insert -> list
		return "redirect:/commonNotice/list";
	}
	//update CN
	@ModelAttribute("commonnotice")
	@RequestMapping("/commonNotice/update.do")
	public String updateCN(@ModelAttribute("cn") CommonNotice commonnotice,
			BindingResult resut) {
		
		//update fuction
		//update -> list
		return "redirect:/commonNotice/list";
	}
	
	//delete CN
	@ModelAttribute("commonnotice")
	@RequestMapping("/commonNotice/delete.do")
	public String deleteCN(@ModelAttribute("cn") CommonNotice commonnotice,
			BindingResult result) {
		//delete function
		//after -> list
		return "redirect:/commonNotice/list";
	}
}
