package com.ssg.dojangfarm.restclient;

import java.util.Iterator;
import java.util.Scanner;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


public class OrderClient2 {
	private static RestTemplate restTemplate = new RestTemplate();
	private static String host = "202.20.119.117";
	private static String port = "80";
	private static String orderSvcUrl = "http://" + host + ":" + port + "/dojangfarm/rest";				
/*
	public static void main(String[] args) {	
		
	    Scanner scanner = new Scanner(System.in);
		  
		while (true) { 
		    System.out.print("Select menu (1:getOrdersByUser, 2:getOrder, 3:deleteOrder, q:quit): "); 
		    String command = scanner.next(); 
		    if (command.equals("q")) {
		        System.out.println("quits..");
		        break;
		    }
    		switch (command) { 
    		case "1" :
    		    System.out.print("Enter username: "); 
    		    String username = scanner.next();
    		    getOrderInfo(username); 
    		    break; 
    		case "2" :
    		    System.out.print("Enter orderId: "); 
    		    int orderId = Integer.parseInt(scanner.next()); 
    		    getOrderInfo(orderId);
    		    break; 
    		case "3" :
    		    System.out.print("Enter orderId: "); 
    		    orderId = Integer.parseInt(scanner.next()); 
    		    deleteOrderInfo(orderId); 
    		} 
		}
		scanner.close();		 
	}

	private static void getOrderInfo(int orderId) {
		System.out.println("Calling getOrderInfo() with order ID " + orderId);
		
		Order order = null;
		try {
			order = restTemplate.getForObject(
					orderSvcUrl + "/order/{orderId}", Order.class, orderId);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {	// 404 Not Found	
				System.out.println("Order with ID " + orderId + " not found");
			}
		} catch (RestClientException e) {
			e.printStackTrace();
			return;
		}		
		if (order != null) printOrder(order);		
		
		System.out.println();
	}

	private static void getOrderInfo(String username) {
		System.out.println("Calling getOrderInfo() with user's name " + username);
		
		Order[] orders = null;
		try {
			orders = restTemplate.getForObject(
					orderSvcUrl + "/ordersBy/{username}", Order[].class, username);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {	// 404 Not Found	
				System.out.println("Orders by " + username + " not found");
			}
		} catch (RestClientException e) {
			e.printStackTrace();
			return;
		} 	
		if (orders != null) printOrders(orders, username);
		
		System.out.println();
	}

	private static void deleteOrderInfo(int orderId) {
		System.out.println("Calling deleteOrder() with order ID " + orderId);
		
		try {
			restTemplate.delete(orderSvcUrl + "/order/{orderId}", orderId);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {	// 404 Not Found	
				System.out.println("Order with ID " + orderId + " not found");
			}
			return;
		} catch (RestClientException e) {
			e.printStackTrace();
			return;
		}			
		
		System.out.println("order " + orderId + " has been deleted.");
		System.out.println();
	}
	
	private static void printOrder(Order order) {
		System.out.println("Got order with order ID " + order.getOrderId() +
				" and order date " + order.getOrderDate());
		System.out.println("User name: " + order.getUsername());
		System.out.println("Shipping address: " + order.getShipAddress1() + ", " + order.getShipAddress2() + ", " + order.getShipCity());
		for (Iterator<LineItem> lineItems = order.getLineItems().iterator(); lineItems.hasNext();) {
			LineItem lineItem = (LineItem) lineItems.next();
			System.out.println("LineItem " + lineItem.getLineNumber() + ": " + lineItem.getQuantity() +
					" piece(s) of item " + lineItem.getItemId());
		}
		System.out.println("Total prices: " + order.getTotalPrice());
	}
	
	private static void printOrders(Order[] orders, String username) {		
		System.out.println("Number of orders by " + username + ": "+ orders.length);
		for (int i = 0; i < orders.length; i++) {
			Order order = orders[i];
			System.out.println("-------------------------------");
			System.out.println("Order ID: " + order.getOrderId());
			System.out.println("Order Date: " + order.getOrderDate());
			System.out.println("Shipping address: " + order.getShipAddress1() + ", " + order.getShipAddress2() + ", " + order.getShipCity());
			System.out.println("Total prices: " + order.getTotalPrice());
		}
	}
	*/
}
