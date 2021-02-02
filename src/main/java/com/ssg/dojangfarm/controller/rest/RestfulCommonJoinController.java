package com.ssg.dojangfarm.controller.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssg.dojangfarm.domain.CommonJoin;
import com.ssg.dojangfarm.service.CommonService;


@Controller
public class RestfulCommonJoinController {

	private CommonService commonService;

	@Autowired
	public void setFarmSvc(CommonService commonService) {
		this.commonService = commonService;
	}
	
	@RequestMapping(value= "/commonjoinBy/{cjNo}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public CommonJoin getCommonJoin(@PathVariable("cjNo")int cjNo, HttpServletResponse response) throws IOException {
		System.out.println("/rest/commonjoinBy/{cjNo} request accepted = {cjNo} : " + cjNo);
		CommonJoin commonJoin = commonService.getCommonJoin(cjNo);
		
		if(commonJoin == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return commonJoin;
	}
	
	@RequestMapping(value = "/commonjoinListBy/{userNo}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<CommonJoin> getCommonJoinByUserNo(@PathVariable("userNo") int userNo, HttpServletResponse response) throws IOException {
		System.out.println("/rest/commonJoinListBy/{userNo} request accepted : {userNo} = " + userNo);
		List<CommonJoin> cjList = commonService.getCommonJoinListByUserNo(userNo);
		
		if(cjList == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return cjList;
	}
}
