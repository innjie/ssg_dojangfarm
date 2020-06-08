package com.ssg.dojangfarm.controller.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.dojangfarm.domain.Common;
import com.ssg.dojangfarm.domain.CommonJoin;
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
	@RequestMapping("/common/insertForm.do")
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
		User user = new User();
		user.setUserNo(userNo);
		common.setUser(user);
		//insert common
		int res = commonService.insertSale(common);
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
	
	@RequestMapping("/common/updateForm.do")
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
	//common list
	@RequestMapping("/common/list.do")
	public String getCommonList(Model model) {
		//get list.do
		List<Common> commonList = commonService.getAllCommonList();
		model.addAttribute("commonList", commonList);
		return "common/CommonListView";
	}
	@RequestMapping("/common/{saleNo}.do")
	public String getCommon(@PathVariable int saleNo, Model model) {
		Common common = commonService.getCommonSale(saleNo);
		if(common == null) {
			return "common/CommonNotFound";
		}
		model.addAttribute("common", common);
		return "common/CommonView";
	}
	//insert CommonJoin
	@RequestMapping("/commonjoin/join.do")
	public ModelAndView insertCommonJoin(
			@RequestParam HttpServletRequest request,
			@ModelAttribute("CommonJoin") CommonJoin commonJoin,
			BindingResult result) {
		//insert join actioin
		int userNo = (int)request.getAttribute("userNo");
		User user = new User();
		user.setUserNo(userNo);
		commonJoin.setUser(user);
		int res = commonService.insertCommonjoin(commonJoin);
		
		if(res == 0) {//failed
			return new ModelAndView("Error", "message", "join Failed");
		} else { //success
			return new ModelAndView("Success", "message", "join success");
		}
	}
	//updateCommonJoin
	@RequestMapping("/commonJoin/update.do")
	public ModelAndView updateCommonJoin(
			@ModelAttribute("CommonJoin") CommonJoin cj, BindingResult result) {
		int res = commonService.updateCommonjoin( cj.getCjNo());
		
		if(res == 0) {//failed
			return new ModelAndView("Error", "message", "update join Failed");
		} else { //success
			return new ModelAndView("Success", "message", "update join success");
		}
	}
	
	//view CommonJoin
	@RequestMapping("/commonJoin/view.do")
	public String viewCommonJoin(@PathVariable int CJNo, Model model) {
		CommonJoin cj = commonService.getCommonJoin(CJNo);
		
		if(cj == null) {
			return "/commonJoin/CJNotFound";
		}
		model.addAttribute("commonJoin", cj);
		return "commonJoin/CommonJoinView";
	}
	//cancel CommonJoin
	@RequestMapping("/commonJoin/cancel.do")
	public ModelAndView cancelCommonJoin(@PathVariable int CJNo, BindingResult result) {
		//cancel action
		int res = commonService.cancelCommonjoin( CJNo);
		
		if(res == 0)  {//failed
			return new ModelAndView("Error", "message", "cancel failed");
		} else { //success
			return new ModelAndView("Success", "message", "cancel success");
		}
	}
	
}
