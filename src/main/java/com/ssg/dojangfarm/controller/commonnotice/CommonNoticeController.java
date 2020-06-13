package com.ssg.dojangfarm.controller.commonnotice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssg.dojangfarm.domain.CommonNotice;
import com.ssg.dojangfarm.service.FarmFacade;

//commonnotice controlelr
@Controller
public class CommonNoticeController {
	private static final String commonNoticeListView = "commonnotice/CommonNoticeListView";
	private static final String insertCNForm = "commonnotice/InsertFormView";
	@Autowired
	private FarmFacade farm;
	public void setFarm(FarmFacade farm) {
		this.farm = farm;
	}
	//CN Command
	@ModelAttribute("CNCommand")
	public CommonNoticeCommand formBacking(HttpServletRequest request) {
		return new CommonNoticeCommand();
	}

	//get CN List
	@RequestMapping("/commonNotice/list.do")
	public String getCNList(Model model ) {
		List<CommonNotice> cnList = this.farm.getAllNoticeList();
		model.addAttribute("cnList", cnList);
		return commonNoticeListView;
	}
	//get CN view
	@RequestMapping("/commonNotice/view.do")
	public String getCN(@PathVariable int CNNo, Model  model) {
		CommonNotice cn = this.farm.viewCommonNotice(CNNo);
		if(cn == null) {
			return "commonnotice/CnNotFound";
		}
		model.addAttribute("cn", cn);
		return "commonNotice/CommonNoticeView";
	}
	//insert CN Form
	@RequestMapping("/commonNotice/insertForm.do")
	public String insertForm(HttpServletRequest request,
			@ModelAttribute("CNCommand") CommonNoticeCommand CNCommand,
			ModelMap model) throws Exception {
		
		return insertCNForm;
	}
	
	//insert CN
	@ModelAttribute("commonnotice")
	@RequestMapping("/commonNotice/insertCN.do")
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
