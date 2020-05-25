package com.ssg.dojangfarm.controller.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssg.dojangfarm.service.FarmFacade;

public class LoginController {
	private static final String LOGINFORM = "user/LoignView";
	
	private FarmFacade farm;
	
	@Autowired
	public void setFarm(FarmFacade  farm) {
		this.farm = farm;
	}
	
	//login ... form
	//@RequestMapping(value="/user/login.do", method=RequestMethod.GET)

	
	//login
	//@RequestMapping(value="/user/login.do", method=RequestMethod.POST)

}
