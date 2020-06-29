package com.ssg.dojangfarm.service;
 
import java.net.URI;
import java.net.URISyntaxException;
 
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.ssg.dojangfarm.domain.Auction;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.kakao.KakaoPayApprovalVO;
import com.ssg.dojangfarm.kakao.KakaoPayReadyVO;
 
 
@Service
public class KakaoPay {
 
    private static final String HOST = "https://kapi.kakao.com";
    
    private KakaoPayReadyVO kakaoPayReadyVO;
    
    public String kakaoPayReady(Auction auction, User user, String url) {
 
    	System.out.println("kakaoPayReady");
        RestTemplate restTemplate = new RestTemplate();
 
        //서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "6778b196cc19c18ee539baad94ee376d");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        
        //서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("partner_order_id", "a" + auction.getaNo());
        params.add("partner_user_id", user.getId());
        params.add("item_name", auction.getTitle());
        params.add("quantity", "1");
        params.add("total_amount", String.valueOf(auction.getImPurPrice()));
        params.add("tax_free_amount", "100");
        params.add("approval_url", url + "/auction/immePurchaseKaKao.do?aNo="+auction.getaNo());
        params.add("cancel_url", url + "/auction/viewAuction.do?aNo="+auction.getaNo());
        params.add("fail_url", url + "/auction/viewAuction.do?aNo="+auction.getaNo());
 
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
 
        try {
            kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);
            
            System.out.println("" + kakaoPayReadyVO);
            
            return kakaoPayReadyVO.getNext_redirect_pc_url();
 
        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return "/";
    }
   

}
 
