package com.ssg.dojangfarm.controller.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
import com.ssg.dojangfarm.domain.Product;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;

@Controller
public class CommonController {
	private static final String insertCommonForm = "common/CommonInsertFormView";
	private static final String errorPage = "common/Error";
	private static final String successPage = "common/Success";
	private static final String commonListView = "common/CommonListView";
	private static final String commonUserListView = "common/CommonUserListView";
	private static final String commonView = "common/CommonView";
	private static final String updateCommonForm = "common/CommonUpdateFormView";
	//-----commonjoin-----
	private static final String insertCJForm = "commonjoin/CommonJoinFormView";
	private static final String updateCJForm = "commonjoin/JoinUpdateView";
	private static final String commonJoinUserListView = "commonjoin/JoinUserListView";
	private static final String commonJoinView = "commonjoin/CommonJoinView";
	private static final String commonJoinedListView = "commonjoin/ListBySaleView";
	@Autowired
	private FarmFacade farm;
	public void setFarm(FarmFacade farm) {
		this.farm = farm;
	}

	@ModelAttribute("commonCommand")
	public CommonCommand formBacking(HttpServletRequest request) {
		return new CommonCommand();
	}
	
	@ModelAttribute("cjCommand")
	public CommonJoinCommand formBacking2(HttpServletRequest request) {
		return new CommonJoinCommand();
	}
	// insert form
	@RequestMapping("/common/insertForm.do")
	public String insertCommonForm(
			HttpServletRequest request, 
			@ModelAttribute("commonCommand") CommonCommand commonCommand, 
			ModelMap model) throws Exception {
		List<Product> pList = this.farm.getProductList();
		model.addAttribute("product", pList);

		return insertCommonForm;
	}

	// insert common
	@RequestMapping("/common/insertCommon.do")
	public ModelAndView insertCommon(@Valid @ModelAttribute("commonCommand") CommonCommand commonCommand,
			BindingResult result,  HttpServletRequest request, ModelMap model) throws Exception {
		//get session-> user id
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("user");
		
		//validate
		if(user == null) {
			return new ModelAndView(errorPage, "message", "Pleas LOGIN first");
		}
		System.out.println(user.getUserNo());
		if(result.hasErrors() ) {
			System.out.println(result.getErrorCount());
			List<Product> pList = this.farm.getProductList();
			model.addAttribute("product", pList);
			return new ModelAndView(insertCommonForm);
		}
		
		//insert common
		Common common = new Common();
		common.setUser(user);
		
		common.setPrice(commonCommand.getPrice());
		common.setTitle(commonCommand.getTitle());
		common.setSaleType("Common");
		common.setSaleState("OPEN");
		common.setState("0");
		common.setInfo(commonCommand.getInfo());
		java.util.Date utilDate = commonCommand.getDeadline();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		common.setDeadline(sqlDate);
		common.setMin(commonCommand.getMin());
		
		int res = this.farm.insertCommon(common);
		
		if(res == 0) {
			return new ModelAndView(errorPage, "message", "insert error");
		} 
		return new ModelAndView("redirect:/common/list.do");
	
	}

	// search common
	@RequestMapping("/common/searchCommon.do")
	public ModelAndView searchCommon(HttpServletRequest request,
			@RequestParam(value = "word", required = false) String word) throws Exception {
		// search action
		List<Common> commonList = null;
		System.out.println(word);
		if (word != null) {
			if (!StringUtils.hasLength(word)) {
				return new ModelAndView("Error", "message", "enter keword");
			}
			commonList = this.farm.searchCommon(word.toLowerCase());
		}
		// search -> list
		return new ModelAndView(commonListView, "commonList", commonList);
	}

	// update common Form
	@RequestMapping(value = "/common/updateCommon.do", method = RequestMethod.GET)
	public String updateCommon(@RequestParam("saleNo") int saleNo, 
			ModelMap model) throws Exception {
		Common common = this.farm.getCommonSale(saleNo);
		model.addAttribute(common);
		
		return updateCommonForm;
	}
	
	//update Common
	@RequestMapping(value = "/common/updateCommon.do", method = RequestMethod.POST)
	public ModelAndView updateCommon(@ModelAttribute("common") Common common,
			BindingResult result, HttpServletRequest request, ModelMap model) {
		//get user session
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		
		//validate
		if(user == null) {
			return new ModelAndView(errorPage, "message", "Please LOGIN first");
		}
		if(result.hasErrors()) {
			return new ModelAndView(updateCommonForm, "common", common);
		}
		
		int res = farm.updateCommon(common);
		if(res == 0) {
			return new ModelAndView(errorPage, "message", "update Failed");
		} else {
			return new ModelAndView(successPage, "message", "update success");
		}
	}

	// common list
	@RequestMapping("/common/list.do")
	public String getCommonList(Model model) {
		// get list.do
		List<Common> commonList = farm.getAllCommonList();
		model.addAttribute("commonList", commonList);
		return "common/CommonListView";
	}
	
	//get user CommonList
	@RequestMapping("/common/userList.do")
	public String getCommonListByUserNo(HttpServletRequest request, Model model) {
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("user");
		int userNo = user.getUserNo();
		
		//get list
		List<Common> commonList = farm.getCommonListByUserNo(userNo);
		model.addAttribute("commonList", commonList);
		return commonUserListView;
	}
	
	//get commonView
	@RequestMapping("/common/viewCommon.do")
	public String getCommon(@RequestParam("saleNo") int saleNo, ModelMap model,
			HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession();
		User loginUser = (User) httpSession.getAttribute("user");

		Common common = this.farm.getCommonSale(saleNo);
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("common", common);
		
		System.out.println(common.getDeadline());
		return commonView;
	}
	
	//--------------------- common join ---------------------
	
	
	//commonJoin user List
	@RequestMapping("/commonJoin/userList.do")
	public String getCommonJoinUserList(HttpServletRequest request, Model model) {
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		int userNo = user.getUserNo();
		
		List<CommonJoin> cjList = this.farm.getCommonJoinListByUserNo(userNo);
		System.out.println(cjList.get(0).getCommon().getTitle());
		model.addAttribute("cjList", cjList);
		return commonJoinUserListView;
	}
	
	//commonJoin list by saleNo
	@RequestMapping("/commonJoin/viewList.do")
	public String getCommonJonListBySaleNo(@RequestParam("saleNo") int saleNo, HttpServletRequest request, Model model) {
		
		List<CommonJoin> cjList = this.farm.getCommonJoinListBySaleNo(saleNo);
		System.out.println(cjList.get(0).getUser().getName());
		model.addAttribute("cjList", cjList);
		return commonJoinedListView;
	}
	//insert CommonJoin Form
	@RequestMapping(value = "/commonjoin/join.do", method = RequestMethod.GET)
	public String insertCommonJoin(@RequestParam int saleNo, HttpServletRequest request,
			@ModelAttribute("cjCommand") CommonJoinCommand cjCommand, 
			ModelMap model) throws Exception {
		Common common = this.farm.getCommonSale(saleNo);
		model.addAttribute(common);
		
		return insertCJForm;
	}
	// insert CommonJoin
	@Transactional
	@RequestMapping(value = "/commonjoin/join.do", method = RequestMethod.POST)
	public ModelAndView insertCommonJoin(HttpServletRequest request,
			@ModelAttribute("cjCommand") CommonJoinCommand cjCommand, BindingResult result,
			ModelMap model) {
		// insert join actioin
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("user");
		Common common = this.farm.getCommonSale(cjCommand.getCommon().getSaleNo());
		
		//validate
		if(user == null) {
			return new ModelAndView(errorPage, "message", "Please LOGIN first");
		}
		if(result.hasErrors()) {
			model.addAttribute(common);
			return new ModelAndView(insertCJForm);
		}
		//if already exist
		
		CommonJoin existJoin = this.farm.ExistCommonJoin(user.getUserNo(), common.getSaleNo());
		if(existJoin != null) {
			model.addAttribute("common", common);
			return new ModelAndView(commonView, "message", "already exist");
		}
		//insert CommonJoin
		CommonJoin commonJoin = new CommonJoin();
		commonJoin.setUser(user);
		commonJoin.setCount(cjCommand.getCount());
		commonJoin.setCommon(common);
		commonJoin.setCjState("신청");
		
		int res = this.farm.insertCommonjoin(commonJoin);
		int memberSize = this.farm.getCommonJoinListBySaleNo(cjCommand.getCommon().getSaleNo()).size();
		//common state change	
		if(memberSize == cjCommand.getCommon().getMin()) {
			common.setSaleState("OK");
			res = this.farm.updateCommon(common);
		}
		
		if (res == 0) {// failed
			return new ModelAndView("Error", "message", "join Failed");
		} else { // success
			return new ModelAndView("Success", "message", "join success");
		}
	}

	//update CommonJoin Form
	@RequestMapping(value = "/commonJoin/update.do", method = RequestMethod.GET)
	public String updateCommonJoin(@RequestParam("cjNo") int cjNo, 
			ModelMap model) throws Exception {
		CommonJoin commonJoin = this.farm.getCommonJoin(cjNo);
		
		model.addAttribute(commonJoin);
		return updateCJForm;
	}
	// updateCommonJoin
	@RequestMapping(value = "/commonJoin/update.do", method = RequestMethod.POST)
	public ModelAndView updateCommonJoin(@ModelAttribute("commonJoin") CommonJoin commonJoin, BindingResult result) {
		int res = farm.updateCommonjoin(commonJoin);

		if (res == 0) {// failed
			return new ModelAndView("Error", "message", "update join Failed");
		} else { // success
			return new ModelAndView("Success", "message", "update join success");
		}
	}

	// view CommonJoin
	@RequestMapping("/commonJoin/view.do")
	public String viewCommonJoin(@RequestParam("cjNo")  int cjNo, ModelMap model,
			HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession();
		User loginUser = (User) httpSession.getAttribute("user");
		
		CommonJoin commonJoin = this.farm.getCommonJoin(cjNo);
		Common common = this.farm.getCommonSale(commonJoin.getCommon().getSaleNo());
		commonJoin.setCommon(common);
		
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("commonJoin", commonJoin);
		return commonJoinView;
	}

	// cancel CommonJoin
	@RequestMapping("/commonJoin/cancel.do")
	public ModelAndView cancelCommonJoin(@RequestParam("cjNo") int CJNo) {
		// cancel action
		int res = farm.cancelCommonjoin(CJNo);

		if (res == 0) {// failed
			return new ModelAndView("Error", "message", "cancel failed");
		} else { // success
			return new ModelAndView("Success", "message", "cancel success");
		}
	}

}
