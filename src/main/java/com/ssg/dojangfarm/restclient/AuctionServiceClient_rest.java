package com.ssg.dojangfarm.restclient;

import java.util.Iterator;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.ssg.dojangfarm.domain.Auction;

public class AuctionServiceClient_rest {

	private static RestTemplate restTemplate = new RestTemplate();
	private static String host = "localhost";
	private static String port = "8081";
	private static String auctionSvcUrl = "http://" + host + ":" + port + "/dojangfarm/rest";				

	public static void main(String[] args) {		
		getAuctionListByUser(99999);
		getAuction(9999);
		findAuctionByProduct("수박");
		findAuctionByTitle("수박");
	}

	private static void getAuction(int aNo) {
		System.out.println("Calling getAuction() with auction list No " + aNo);
		
		Auction auction = null;
		try {
			auction = restTemplate.getForObject(
					auctionSvcUrl + "/auctionBy/{aNo}", Auction.class, aNo);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {	// 404 Not Found	
				System.out.println("auction with No " + aNo + " not found");
			}
		} catch (RestClientException e) {
			e.printStackTrace();
			return;
		}		
		if (auction != null) 
			printAuction(auction);		
		
		System.out.println();
	}

	private static void getAuctionListByUser(int userNo) {
		System.out.println("Calling getAuctionListByUser() with auction No " + userNo);
		
		Auction[] auctions = null;
		
		try {
			auctions = restTemplate.getForObject(
					auctionSvcUrl + "/auctionListBy/{userNo}", Auction[].class, userNo);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {	// 404 Not Found	
				System.out.println("auctions by " + userNo + " not found");
			}
		} catch (RestClientException e) {
			e.printStackTrace();
			return;
		} 	
		if (auctions != null) 
			printAuctions(auctions, userNo);
		
		System.out.println();
	}
	
	private static void findAuctionByProduct(String pName) {
		System.out.println("Calling findAuctionByProduct() with pName " + pName);
		
		Auction[] auctions = null;
		
		try {
			auctions = restTemplate.getForObject(
					auctionSvcUrl + "/auctionListBy/product/{pName}", Auction[].class, pName);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {	// 404 Not Found	
				System.out.println("auctions by " + pName + " not found");
			}
		} catch (RestClientException e) {
			e.printStackTrace();
			return;
		} 	
		if (auctions != null) 
			printAuctionsByProduct(auctions, pName);
		
		System.out.println();
	}
	
	private static void findAuctionByTitle(String title) {
		System.out.println("Calling findAuctionByTitle() with title " + title);
		
		Auction[] auctions = null;
		
		try {
			auctions = restTemplate.getForObject(
					auctionSvcUrl + "/auctionListBy/title/{title}", Auction[].class, title);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {	// 404 Not Found	
				System.out.println("auctions by " + title + " not found");
			}
		} catch (RestClientException e) {
			e.printStackTrace();
			return;
		} 	
		if (auctions != null) 
			printAuctionsByTitle(auctions, title);
		
		System.out.println();
	}

	
	private static void printAuction(Auction auction) {
		System.out.println("Got auction with auction No " + auction.getaNo());
		System.out.println("auction title " + auction.getTitle());
		System.out.println("auction pname " + auction.getProduct().getpName());
		System.out.println("min prices: " + auction.getMinPrice());
	}
	
	private static void printAuctions(Auction[] auctions, int userNo) {		
		System.out.println("Number of auctions by " + userNo + ": "+ auctions.length);
		for (int i = 0; i < auctions.length; i++) {
			Auction auction = auctions[i];
			System.out.println("-------------------------------");
			System.out.println("auction No: " + auction.getaNo());
			System.out.println("auction title: " + auction.getTitle());
			System.out.println("min prices: " + auction.getMinPrice());
		}
	}
	
	private static void printAuctionsByProduct(Auction[] auctions, String pName) {		
		System.out.println("Number of auctions by " + pName + ": "+ auctions.length);
		for (int i = 0; i < auctions.length; i++) {
			Auction auction = auctions[i];
			System.out.println("-------------------------------");
			System.out.println("auction No: " + auction.getaNo());
			System.out.println("auction title: " + auction.getTitle());
			System.out.println("min prices: " + auction.getMinPrice());
		}
	}
	
	private static void printAuctionsByTitle(Auction[] auctions, String title) {		
		System.out.println("Number of auctions by " + title + ": "+ auctions.length);
		for (int i = 0; i < auctions.length; i++) {
			Auction auction = auctions[i];
			System.out.println("-------------------------------");
			System.out.println("auction No: " + auction.getaNo());
			System.out.println("auction title: " + auction.getTitle());
			System.out.println("min prices: " + auction.getMinPrice());
		}
	}
}
