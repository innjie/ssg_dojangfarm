package com.ssg.dojangfarm.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;


public class LogoutController {

	//logout
	@RequestMapping("/user/logout.do")
	public String handleRequest(HttpSession session) throws Exception {
		session.removeAttribute("user");
		session.invalidate();
		return "Main";
	}
}
