package com.ssg.dojangfarm.controller.auction;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.ssg.dojangfarm.domain.Product;

public class AuctionCommand {
	private Product product;
	@NotBlank
	private String title;
	private String detail;
	@Min(1000)
	private int minPrice;
	@Future @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deadline;
	private Boolean imPurAva;		//imme Purchase Available
	private int imPurPrice;		//imme Purchase
	private MultipartFile image;
	
	
	
	public AuctionCommand() {
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public Boolean getImPurAva() {
		return imPurAva;
	}
	public void setImPurAva(Boolean imPurAva) {
		this.imPurAva = imPurAva;
	}
	public int getImPurPrice() {
		return imPurPrice;
	}
	public void setImPurPrice(int imPurPrice) {
		this.imPurPrice = imPurPrice;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
}
