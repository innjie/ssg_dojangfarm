package com.ssg.dojangfarm.restclient;

import java.util.Iterator;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.ssg.dojangfarm.domain.SBid;

public class SBidServiceClient_rest {

	private static RestTemplate restTemplate = new RestTemplate();
	private static String host = "localhost";
	private static String port = "8081";
	private static String sBidSvcUrl = "http://" + host + ":" + port + "/dojangfarm/rest";				

	public static void main(String[] args) {		
		getMySBidList("im");
		getMySBid(9999);
	}

	private static void getMySBid(int sBidNo) {
		System.out.println("Calling getMySBid() with sBid No " + sBidNo);
		
		SBid sBid = null;
		try {
			sBid = restTemplate.getForObject(
					sBidSvcUrl + "/sBidBy/{sBidNo}", SBid.class, sBidNo);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {	// 404 Not Found	
				System.out.println("sBid with No " + sBidNo + " not found");
			}
		} catch (RestClientException e) {
			e.printStackTrace();
			return;
		}		
		if (sBid != null) 
			printSBid(sBid);		
		
		System.out.println();
	}

	private static void getMySBidList(String id) {
		System.out.println("Calling getMySBidList() with sBid list No " + id);
		
		SBid[] sBids = null;
		
		try {
			sBids = restTemplate.getForObject(
					sBidSvcUrl + "/sBidListBy/{id}", SBid[].class, id);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {	// 404 Not Found	
				System.out.println("auctions by " + id + " not found");
			}
		} catch (RestClientException e) {
			e.printStackTrace();
			return;
		} 	
		if (sBids != null) 
			printSBids(sBids, id);
		
		System.out.println();
	}

	
	private static void printSBid(SBid sBid) {
		System.out.println("Got sBid with sBid No " + sBid.getsBidNo());
		System.out.println("auction title " + sBid.getBid().getAuction().getTitle());
		System.out.println("bid prices: " + sBid.getBid().getBidPrice());
		//delivery + payment
	}
	
	private static void printSBids(SBid[] sBids, String id) {		
		System.out.println("Number of sBids by " + id + ": "+ sBids.length);
		for (int i = 0; i < sBids.length; i++) {
			SBid sBid = sBids[i];
			System.out.println("-------------------------------");
			System.out.println("sBid No: " + sBid.getsBidNo());
			System.out.println("auction title " + sBid.getBid().getAuction().getTitle());
			System.out.println("bid prices: " + sBid.getBid().getBidPrice());
		}
	}
}
