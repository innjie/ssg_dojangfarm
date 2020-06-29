package com.ssg.dojangfarm.restclient;

import java.util.Scanner;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.ssg.dojangfarm.domain.CommonJoin;

public class CommonServiceClient_rest {

	private static RestTemplate restTemplate = new RestTemplate();
	private static String host = "localhost";
	private static String port = "8081";
	private static String commonSycUrl = "http://" + host + ":" + port + "/dojangfarm/rest";

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("유저번호를 입력하세요: "); 
		int userNo = scan.nextInt();
		System.out.print("공구참여번호를 입력하세요: ");
		int cjNo = scan.nextInt();
		
		getCommonJoinListByUserNo(userNo);
		getCommonJoin(cjNo);
	}

	private static void getCommonJoinListByUserNo(int userNo) {
		System.out.println("Calling getCommonJoinListByUserNo with userNo " + userNo);
		CommonJoin[] cjList = null;

		try {
			cjList = restTemplate.getForObject(commonSycUrl + "/commonjoinListBy/{userNo}", CommonJoin[].class, userNo);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				System.out.println("commonJoin by " + userNo + "not found");
			}
		} catch (RestClientException e) {
			e.printStackTrace();
			return;
		}
		if (cjList != null) {
			printCJList(cjList, userNo);
		}
		System.out.println();
	}

	private static void getCommonJoin(int cjNo) {
		System.out.println("Calling getCommonJoin with cjNo " + cjNo);

		CommonJoin cj = null;
		try {
			cj = restTemplate.getForObject(commonSycUrl + "/commonjoinBy/{cjNo}", CommonJoin.class, cjNo);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				System.out.println("CommonJoin with No " + cjNo + "not found");
			}
		} catch (RestClientException e) {
			e.printStackTrace();
			return;
		}
		if (cj != null) {
			printCommonJoin(cj);
		}
		System.out.println();

	}

	private static void printCommonJoin(CommonJoin cj) {
		System.out.println("Get CJ with cjNo : " + cj.getCjNo());
		System.out.println("saleNo : " + cj.getCommon().getSaleNo());
		System.out.println("count : " + cj.getCount());
	}

	private static void printCJList(CommonJoin[] cjList, int userNo) {
		System.out.println("CJList By " + userNo + ":" + cjList.length);
		for (int i = 0; i < cjList.length; i++) {
			CommonJoin cj = cjList[i];
			System.out.println("-------------------------");
			System.out.println("cjNo : " + cj.getCjNo());
			System.out.println("cj State : " + cj.getCjState());
		}
	}
}
