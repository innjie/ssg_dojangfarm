package com.ssg.dojangfarm.controller.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssg.dojangfarm.service.FarmFacade;

public class LogoutController {
	private static final String LOGINFORM = "user/LoignView";
	
	private FarmFacade farm;
	
	@Autowired
	public void setFarm(FarmFacade  farm) {
		this.farm = farm;
	}
	
	//logout
	//@RequestMapping("/user/logout.do")
}
