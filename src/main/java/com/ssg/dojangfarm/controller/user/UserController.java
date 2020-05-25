package com.ssg.dojangfarm.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssg.dojangfarm.service.FarmFacade;

public class UserController {
	private static final String VIEWUSER = "user/UserView.jsp";
	private static final String ADDUSERFORM = "user/CreateUserFormView";
	private static final String UPDATEUSERFORM = "user/ModifyUserFormView";
	
	private FarmFacade farm;
	
	@Autowired
	public void setFarm(FarmFacade  farm) {
		this.farm = farm;
	}
	
	//view user
	//@RequestMapping("/user/getUser.do")

	//create user ... form
	//@RequestMapping(method="/user/createUser.do", method="RequestMethod.GET")

	//create user ... insert
	//@RequestMapping(method="/user/createUser.do", method="RequestMethod.POST")

	//update user ... form
	//@RequestMapping(method="/user/modifyUser.do", method="RequestMethod.GET")

	//update user ... update
	//@RequestMapping(method="/user/modifyUser.do", method="RequestMethod.POST")

	//delete user
	//@RequestMapping("/user/deleteUser.do")

}
