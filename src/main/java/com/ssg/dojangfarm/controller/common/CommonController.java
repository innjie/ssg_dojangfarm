package com.ssg.dojangfarm.controller.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.dojangfarm.domain.Common;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.CommonService;

@Controller
public class CommonController {
	private CommonService commonService;
	
	@Autowired
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
	
	//insert form
	@RequestMapping(value="/common/insertForm.do", method = RequestMethod.GET)
	public String insertForm(
			@ModelAttribute("common") Common common) throws Exception {
		return "common/CommonInsertFormView";
	}
	
	//insert common
	@RequestMapping("/common/insertCommon.do")
	public String insertCommon(@ModelAttribute("common") Common common,
			BindingResult result, HttpServletRequest request) {
		//insert action
		//get session -> user id
		int userNo = (int) request.getSession().getAttribute("userNo");
		//insert normal
		int res = commonService.insertSale(userNo, common);
		if(res == 0) { //false
			return "common/CommonInsertFormView";
		}
		//insert -> list (or main)
		return "redirect:/common/list";
	}
	
	//search common
	@RequestMapping("/common/searchCommon.do")
	public ModelAndView searchCommon(HttpServletRequest request,
			@RequestParam(value="title", required = false) String title) throws Exception {
		//search action
		List<Common> commonList = null;
		if(title != null) {
			if(!StringUtils.hasLength(title)) {
				return new ModelAndView("Error", "message", "enter keword");
			}
			commonList = commonService.searchCommon(title.toLowerCase());
		}
		//search -> list
		return new ModelAndView("CommonListView", "commonList", commonList);
	}
	
	@RequestMapping(value="/common/updateForm.do", method = RequestMethod.GET)
	public String UpdateForm(
			@ModelAttribute("common") Common common) throws Exception {
		return "common/CommonUpdateFormView";
	}
	//update common
	@RequestMapping("/common/updateCommon.do")
	public ModelAndView updateCommon(@ModelAttribute("common")Common common,
			BindingResult result) {
		//update action
		int res = commonService.updateSale(common);
		
		if(res == 0) {//failed
			return new ModelAndView("Error", "message", "update Failed");
		} else { //success
			return new ModelAndView("Success", "message", "update success");
		}
	}
	
}
