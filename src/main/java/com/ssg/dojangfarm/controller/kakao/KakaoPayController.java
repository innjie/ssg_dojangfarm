package com.ssg.dojangfarm.controller.kakao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssg.dojangfarm.domain.Auction;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;
import com.ssg.dojangfarm.service.KakaoPay;
 
 
@Controller
@RequestMapping("/kakao")
public class KakaoPayController {
    
	@Autowired
    private KakaoPay kakaopay;
    
	@Autowired
	private FarmFacade farm;
	
	public void setFarm(FarmFacade  farm) {
		this.farm = farm;
	}
	
	@RequestMapping("/kakaoPay.do")
    public String imPurkakaoPay(HttpServletRequest request) {
    	System.out.println("imPurkakaoPay post............................................");
        
    	HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
    	
		int aNo = Integer.parseInt(request.getParameter("aNo"));
		Auction auction = this.farm.getAuction(aNo);
    	String url = request.getRequestURL().toString();
    	String[] urls = url.split("/k");
    	
        return "redirect:" + kakaopay.kakaoPayReady(auction, user, urls[0]);
 
    }
    
    
}