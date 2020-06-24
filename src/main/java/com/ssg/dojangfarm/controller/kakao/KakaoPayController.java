package com.ssg.dojangfarm.controller.kakao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssg.dojangfarm.service.KakaoPay;
 
 
@Controller
@RequestMapping("/kakao")
public class KakaoPayController {
    
	@Autowired
    private KakaoPay kakaopay;
    
    
	@RequestMapping(value="/kakaoPay.do", method=RequestMethod.GET)
    public void kakaoPayGet() {
        
    }
    
	@RequestMapping(value="/kakaoPay.do", method=RequestMethod.POST)
    public String kakaoPay() {
    	System.out.println("kakaoPay post............................................");
        
        return "redirect:" + kakaopay.kakaoPayReady();
 
    }
    
	@RequestMapping("/kakaoPaySuccess.do")
    public void kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
        System.out.println("kakaoPaySuccess get............................................");
        System.out.println("kakaoPaySuccess pg_token : " + pg_token);
        
        model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token));
    }
	
	@RequestMapping("/kakaoPayCancel.do")
    public void kakaoPayCancel(@RequestParam("pg_token") String pg_token, Model model) {
        System.out.println("kakaoPayCancel get............................................");
        System.out.println("kakaoPayCancel pg_token : " + pg_token);
        
    }
	
	@RequestMapping("/kakaoPayFail.do")
    public void kakaoPayFail(@RequestParam("pg_token") String pg_token, Model model) {
        System.out.println("kakaoPayFail get............................................");
        System.out.println("kakaoPayFail pg_token : " + pg_token);
        
    }
    
}