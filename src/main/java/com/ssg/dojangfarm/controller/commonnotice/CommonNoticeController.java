package com.ssg.dojangfarm.controller.commonnotice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.dojangfarm.controller.user.AddressCommand;
import com.ssg.dojangfarm.domain.Common;
import com.ssg.dojangfarm.domain.CommonNotice;
import com.ssg.dojangfarm.domain.Normal;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;

//commonnotice controlelr
@SessionAttributes("cnList")
@Controller
public class CommonNoticeController {
	private static final String commonNoticeListView = "commonnotice/CommonNoticeListView";
	private static final String insertCNForm = "commonnotice/InsertFormView";
	private static final String errorPage = "/commonnotice/Error";
	private static final String successPage = "/commonnotice/Success";
	private static final String cnView = "commonnotice/CommonNoticeView";
	private static final String updateCNForm = "commonnotice/UpdateFormView";
	private static final String cnUserListView = "commonnotice/CNUserListView";
	@Autowired
	private FarmFacade farm;
	

	public void setFarm(FarmFacade farm) {
		this.farm = farm;
	}

	// CN Command
	@ModelAttribute("commonNoticeCommand")
	public CommonNoticeCommand formBacking(HttpServletRequest request) {
		CommonNotice commonNotice = null;
		
		if(request.getParameter("CNNO") != null) {
			int CNNO = Integer.parseInt(request.getParameter("CNNO"));
			commonNotice = this.farm.viewCommonNotice(CNNO);
		}
		
		// edit CommonNotice
		if (commonNotice != null) {	
			CommonNoticeCommand command = new CommonNoticeCommand();
			command.setTitle(commonNotice.getTitle());
			command.setInfo(commonNotice.getInfo());
			return command;
		}
		else {	// create new CommonNotice
			return new CommonNoticeCommand();
		}
		
	}

	// get CN List
	@RequestMapping("/commonNotice/list.do")
	public String getCNList(ModelMap model) {
		PagedListHolder<CommonNotice> cnList = new PagedListHolder<CommonNotice>(this.farm.getAllNoticeList());
		cnList.setPageSize(10);
		model.put("cnList", cnList);
		return commonNoticeListView;
	}
	@RequestMapping("/commonNotice/list2.do")
	public String getCNList2(@RequestParam("page") String page, 
			@ModelAttribute("cnList") PagedListHolder<CommonNotice> cnList,
			BindingResult result,
			ModelMap model) {
		if ("next".equals(page)) { 
			cnList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			cnList.previousPage(); 
		}
		
		return commonNoticeListView;
	}
	// get CN view
	@RequestMapping("/commonNotice/view.do")
	public String getCN(@RequestParam("CNNO") int CNNO, Model model, HttpServletRequest request) {
		CommonNotice cn = this.farm.viewCommonNotice(CNNO);

		HttpSession httpSession = request.getSession();
		User loginUser = (User) httpSession.getAttribute("user");

		model.addAttribute("loginUser", loginUser);
		model.addAttribute("cn", cn);
		return cnView;
	}

	// insert CN Form
	@RequestMapping("/commonNotice/insertForm.do")
	public String insertForm(HttpServletRequest request, @ModelAttribute("CNCommand") CommonNoticeCommand CNCommand,
			ModelMap model) throws Exception {

		return insertCNForm;
	}

	// insert CN
	@ModelAttribute("commonnotice")
	@RequestMapping("/commonNotice/insertCN.do")
	public ModelAndView insertCN(
			@Valid @ModelAttribute("commonNoticeCommand") 
			CommonNoticeCommand commonNoticeCommand, 
			BindingResult result,
			HttpServletRequest request, ModelMap model) {

		// insert action
		// get session -> user id
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");

		// validate
		if (user == null) {
			return new ModelAndView(errorPage, "message", "Please LOGIN first");
		}
		if (result.hasErrors()) {
			return new ModelAndView(insertCNForm);
		}
		
		// no errors, insert cn
		CommonNotice cn = new CommonNotice();
		cn.setTitle(commonNoticeCommand.getTitle());
		cn.setInfo(commonNoticeCommand.getInfo());
		cn.setUser(user);

		int res = this.farm.insertCommonNotice(cn);

		if (res == 0) { // false
			return new ModelAndView(errorPage, "message", "insert Error");
		}

		List<CommonNotice> cnList = this.farm.getAllNoticeList();
		model.addAttribute("cnList", cnList);
		// insert -> list
		return new ModelAndView("redirect:/commonNotice/list.do");
	}

	// update CN
	@RequestMapping(value = "/commonNotice/update.do", method = RequestMethod.GET)
	public String updateCN(
			@ModelAttribute("commonNoticeCommand") CommonNoticeCommand commonNoticeCommand,
			@RequestParam("CNNO") int CNNO, ModelMap model) throws Exception {
		CommonNotice cn = this.farm.viewCommonNotice(CNNO);
		model.addAttribute(cn);
		// update -> list
		return updateCNForm;
	}

	// update CN
	@RequestMapping(value = "/commonNotice/update.do", method = RequestMethod.POST)
	public ModelAndView updateCN(
			@Valid @ModelAttribute("commonNoticeCommand") CommonNoticeCommand commonNoticeCommand,
			BindingResult result, ModelMap model, 
			HttpServletRequest request) throws Exception {
		// get user session
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");

		// validate
		if (user == null) {
			return new ModelAndView(errorPage, "message", "Please LOGIN first");
		}
		if (result.hasErrors()) {
			return new ModelAndView(updateCNForm);
		}
		
		CommonNotice commonNotice = new CommonNotice();
		commonNotice.setTitle(commonNoticeCommand.getTitle());
		commonNotice.setInfo(commonNoticeCommand.getInfo());
		commonNotice.setUser(user);

		int res = farm.updateCommonNotice(commonNotice);

		if (res == 0) {
			return new ModelAndView(errorPage, "message", "update failed");
		} else {
			return new ModelAndView(successPage, "message", "update success");
		}
	}

	// commonNotice by userNo
	@RequestMapping("/commonNotice/userList.do")
	public String getCNListByUserNo(HttpServletRequest request, ModelMap model) {
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		int userNo = user.getUserNo();

		// get list by userNo
		PagedListHolder<CommonNotice> cnList = new PagedListHolder<CommonNotice>( farm.getCNoticeListByUserNo(userNo));
		cnList.setPageSize(10);
		model.put("cnList", cnList);
		return cnUserListView;
	}
	@RequestMapping("/commonNotice/userList2.do")
	public String getCNListByUserNo2(@RequestParam("page") String page,
			@ModelAttribute("cnList") PagedListHolder<CommonNotice> commonList,
			BindingResult result, ModelMap model) {
		if ("next".equals(page)) { 
			commonList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			commonList.previousPage(); 
		}
		
		return cnUserListView;
	}

	// search CommonNotice
	@RequestMapping("/commonNotice/searchCN.do")
	public ModelAndView searchCN(HttpServletRequest request,
			@RequestParam(value = "word", required = false) String word) throws Exception {
		// search action
		if (word != null) {
			if (!StringUtils.hasLength(word)) {
				return new ModelAndView(errorPage, "message", "enter keword");
			}
		}
		List<CommonNotice> cnList = this.farm.searchCommonNotice(word.toLowerCase());
		if (cnList == null) {
			System.out.println("0");
		} else {
			System.out.println(cnList.size());
		}
		
		return new ModelAndView(commonNoticeListView, "cnList", cnList);
	}
}
