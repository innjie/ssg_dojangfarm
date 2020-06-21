package com.ssg.dojangfarm.restclient;

import java.util.Iterator;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.ssg.dojangfarm.domain.ImPur;

public class ImPurServiceClient_rest {

	private static RestTemplate restTemplate = new RestTemplate();
	private static String host = "localhost";
	private static String port = "8080";
	private static String imPurSvcUrl = "http://" + host + ":" + port + "/dojangfarm/rest";				

	public static void main(String[] args) {		
		getImPurListByUser("im");
		getImPur(9999);
	}

	private static void getImPur(int imPurNo) {
		System.out.println("Calling getImPur() with imPur list No " + imPurNo);
		
		ImPur imPur = null;
		try {
			imPur = restTemplate.getForObject(
					imPurSvcUrl + "/imPurBy/{imPurNo}", ImPur.class, imPurNo);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {	// 404 Not Found	
				System.out.println("imPur with No " + imPurNo + " not found");
			}
		} catch (RestClientException e) {
			e.printStackTrace();
			return;
		}		
		if (imPur != null) 
			printImPur(imPur);		
		
		System.out.println();
	}

	private static void getImPurListByUser(String id) {
		System.out.println("Calling getImPurListByUser() with imPur No " + id);
		
		ImPur[] imPurs = null;
		
		try {
			imPurs = restTemplate.getForObject(
					imPurSvcUrl + "/imPurListBy/{userNo}", ImPur[].class, id);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {	// 404 Not Found	
				System.out.println("imPur by " + id + " not found");
			}
		} catch (RestClientException e) {
			e.printStackTrace();
			return;
		} 	
		if (imPurs != null) 
			printImPurs(imPurs, id);
		
		System.out.println();
	}

	
	private static void printImPur(ImPur imPur) {
		System.out.println("Got imPur with imPur No " + imPur.getImPurNo());
		System.out.println("auction title " + imPur.getAuction().getTitle());
		System.out.println("imPur prices: " + imPur.getAuction().getImPurPrice());
		//delivery + payment
	}
	
	private static void printImPurs(ImPur[] imPurs, String id) {		
		System.out.println("Number of imPurs by " + id + ": "+ imPurs.length);
		for (int i = 0; i < imPurs.length; i++) {
			ImPur imPur = imPurs[i];
			System.out.println("-------------------------------");
			System.out.println("auction title " + imPur.getAuction().getTitle());
			System.out.println("imPur prices: " + imPur.getAuction().getImPurPrice());
		}
	}
}
