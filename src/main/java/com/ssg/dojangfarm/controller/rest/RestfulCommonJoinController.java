package com.ssg.dojangfarm.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ssg.dojangfarm.service.CommonService;


@Controller
public class RestfulCommonJoinController {

	private CommonService commonService;

	@Autowired
	public void setFarmSvc(CommonService commonService) {
		this.commonService = commonService;
	}
}
