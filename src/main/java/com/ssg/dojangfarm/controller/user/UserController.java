package com.ssg.dojangfarm.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.ssg.dojangfarm.domain.Address;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;

@Controller
public class UserController {
	private static final String VIEWUSER = "user/UserView";
	private static final String USERFORM = "user/CreateUserFormView";
	private static final String UPDATEUSERFORM = "user/ModifyUserFormView";
	
	@Autowired
	private FarmFacade farm;
	
	public void setFarm(FarmFacade  farm) {
		this.farm = farm;
	}
	
	//addressCommand 
	@ModelAttribute("userCommand")
	public UserCommand formBacking1(HttpServletRequest request) {
		
		User user = (User)WebUtils.getSessionAttribute(request, "user");

		// edit an existing user
		if (user != null) {	
			return new UserCommand(user.getId(), user.getName(), user.getPhone());
		}
		else {	// create new user
			return new UserCommand();
		}
	}

	
	//view user
	@RequestMapping("/user/getUser.do")
	public ModelAndView viewUser(
			HttpServletRequest request) throws Exception {
		
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");

		return new ModelAndView(VIEWUSER, "user", user);
	}
	
	//create user ... form
	@RequestMapping(value="/user/createUser.do", method=RequestMethod.GET)
	public String userForm(
			 @ModelAttribute("userCommand") UserCommand userCommand,
			 HttpServletRequest request) {				
		return USERFORM;
	}
	
	//create user ... insert
	@RequestMapping(value="/user/createUser.do", method=RequestMethod.POST)
	public String insert(
			@Valid @ModelAttribute("userCommand") UserCommand userCommand, 
			BindingResult result) throws Exception {
		
		//validate
		if (result.hasErrors()) {
			return USERFORM;
		}
		
		//check pw and confirmPw same
		if(!this.farm.confirmPassword(userCommand.getPassword(), userCommand.getConfirmPassword())) {  //add DAO
			result.rejectValue("confirmPassword", "notSame");
			return USERFORM;
		}
		
		//check id exist
		if(this.farm.existingId(userCommand.getId()) != null){
			result.rejectValue("id", "existUserId", new Object[] {userCommand.getId()}, null);
			return USERFORM;
		}
		
		//check phone exist
		if(this.farm.existingPhone(userCommand.getPhone()) != null){
			result.rejectValue("phone", "existingPhone", new Object[] {userCommand.getPhone()}, null);
			return USERFORM;
		}
		
		
		//command to user
		User user = new User();
		user.setId(userCommand.getId());
		user.setPassword(userCommand.getPassword());
		user.setName(userCommand.getName());
		user.setPhone(userCommand.getPhone());
		
		this.farm.createUser(user);		//in DAO, add user in session

		return "redirect:/user/login.do";
	}
	
	//update user ... form
	@RequestMapping(value="/user/modifyUser.do", method=RequestMethod.GET)
	public String updateUserForm(
			 @ModelAttribute("userCommand") UserCommand userCommand,
			 HttpServletRequest request) {				
		return UPDATEUSERFORM;
	}
	
	//update user ... update
	@RequestMapping(value="/user/modifyUser.do", method=RequestMethod.POST)
	public String update(
			@Valid @ModelAttribute("userCommand") UserCommand userCommand, 
			BindingResult result,
			HttpServletRequest request) throws Exception {
		
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		
		//validate
		if (result.hasErrors()) {
			return UPDATEUSERFORM;
		}
		
		//check pw and confirmPw same
		if(!this.farm.confirmPassword(userCommand.getPassword(), userCommand.getConfirmPassword())) {  //add DAO
			result.rejectValue("confirmPassword", "notSame");
			return UPDATEUSERFORM;
		}
		
		//check phone exist
		if(!user.getPhone().contentEquals(userCommand.getPhone())){
			if(this.farm.existingPhone(userCommand.getPhone()) != null){
				result.rejectValue("phone", "existingPhone", new Object[] {userCommand.getPhone()}, null);
				return UPDATEUSERFORM;
			}
		}
		
		//command to real user
		user.setId(userCommand.getId());
		user.setPassword(userCommand.getPassword());
		user.setName(userCommand.getName());
		user.setPhone(userCommand.getPhone());
		
		this.farm.modifyUser(user);

		return "redirect:/user/getUser.do";
	}
			
	//delete user
	@RequestMapping("/user/deleteUser.do")
	public String delete(
			HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		this.farm.deleteUser(user.getUserNo());		
		
		session.removeAttribute("user");
		session.invalidate();
		
		return "redirect:/index.do";
	}
}
