package com.ssg.dojangfarm.controller.auction;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.dojangfarm.domain.Auction;
import com.ssg.dojangfarm.domain.ImPur;
import com.ssg.dojangfarm.domain.SBid;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;
 
@Controller
@SessionAttributes("auctionList")
public class AuctionController implements ServletContextAware{
	private static final String LISTAUCTION = "auction/AuctionListView";
	private static final String VIEWAUCTION = "auction/AuctionView";
	private static final String LISTMYAUCTION = "auction/MyAuctionListView";
	private static final String AUCTIONFORM = "auction/RegisterAuctionFormView";
	
	private ServletContext context;	

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}
	
	private FarmFacade farm;
	
	@Autowired
	public void setFarm(FarmFacade farm) {
		this.farm = farm;
	}

	//AuctionCommand
	@ModelAttribute("auctionCommand")
	public AuctionCommand formBacking() {
		return new AuctionCommand();
	}
	
	//type value
	@ModelAttribute("pName")
	public List<String> referenceData() {
		List<String> pName = new ArrayList<String>();
		pName.add("사과");
		pName.add("오렌지");
		pName.add("수박");
		pName.add("복숭아");
		pName.add("토마토");
		pName.add("배");
		pName.add("감");
		pName.add("포도");
		pName.add("딸기");
		pName.add("참외");
		pName.add("기타과일");
		pName.add("배추");
		pName.add("버섯");
		pName.add("당근");
		pName.add("오이");
		pName.add("양파");
		pName.add("마늘");
		pName.add("무");
		pName.add("고구마");
		pName.add("감자");
		pName.add("기타채소");

		return pName;		
	}
	
	//view auctionList
	@RequestMapping("/auction/viewAuctionList.do")
	public String listAuction(
			ModelMap model) throws Exception {

		List<Auction> list = this.farm.getAuctionList();
		
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String sDeadline;
		for(int i = 0; i <list.size(); i++) {
			sDeadline = dFormat.format(list.get(i).getDeadline());
			list.get(i).setsDeadline(sDeadline);
		}
		
		PagedListHolder<Auction> auctionList = new PagedListHolder<Auction>(list);
		
		auctionList.setPageSize(10);
		model.put("auctionList", auctionList);
		return LISTAUCTION;
	}

	//view auctionList by page
	@RequestMapping("/auction/viewAuctionList2.do")
	public String listAuction2(
			@RequestParam("page") String page,
			@ModelAttribute("auctionList") PagedListHolder<Auction> auctionList,
			BindingResult result) throws Exception {
		if (auctionList== null) {
			throw new IllegalStateException("Cannot find pre-loaded auction list");
		}
		if ("next".equals(page)) { 
			auctionList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			auctionList.previousPage(); 
		}
		
		return LISTAUCTION;
	}
	
	
	//view  myAuctionList
	@RequestMapping("/auction/viewMyAuctionList.do")
	public String listMyAuction(
			ModelMap model,
			HttpServletRequest request) throws Exception {
		
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");

		List<Auction> list = this.farm.getMyAuctionList(user.getUserNo());
		
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String sDeadline;
		for(int i = 0; i <list.size(); i++) {
			sDeadline = dFormat.format(list.get(i).getDeadline());
			list.get(i).setsDeadline(sDeadline);
		}
		
		PagedListHolder<Auction> auctionList = new PagedListHolder<Auction>(list);
		
		auctionList.setPageSize(10);
		model.put("auctionList", auctionList);
		
		return LISTMYAUCTION;
	}	

	//view myAuctionList by page
	@RequestMapping("/auction/viewMyAuctionList2.do")
	public String listMyAuction2(
			@RequestParam("page") String page,
			@ModelAttribute("auctionList") PagedListHolder<Auction> auctionList,
			BindingResult result) throws Exception {
		if (auctionList== null) {
			throw new IllegalStateException("Cannot find pre-loaded auction list");
		}
		if ("next".equals(page)) { 
			auctionList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			auctionList.previousPage(); 
		}
		
		
		return LISTMYAUCTION;
	}	

	//find auctionList
	@RequestMapping("/auction/findAuctionList.do")
	public String findAuction(
			@RequestParam("text") String text,
			@RequestParam("type") String type,
			ModelMap model) throws Exception {

		PagedListHolder<Auction> auctionList;
		
		if(type.equals("title")) {
			auctionList = new PagedListHolder<Auction>(this.farm.findAuctionByTitle(text));
		}
		else {
			auctionList = new PagedListHolder<Auction>(this.farm.findAuctionByProduct(text));
		}

		auctionList.setPageSize(10);
		model.put("auctionList", auctionList);
		model.put("find", "find");
		
		return LISTAUCTION;
	}

	//find auctionList by page
	@RequestMapping("/auction/findAuctionList2.do")
	public ModelAndView findAuction2(
			@RequestParam("page") String page,
			@ModelAttribute("auctionList") PagedListHolder<Auction> auctionList,
			BindingResult result) throws Exception {
		if (auctionList== null) {
			throw new IllegalStateException("Cannot find pre-loaded auctionList list");
		}
		if ("next".equals(page)) { 
			auctionList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			auctionList.previousPage(); 
		}
		return new ModelAndView(LISTAUCTION, "find", "find");
	}

	//view auction
	@RequestMapping("/auction/viewAuction.do")
	public String viewAuction(
			@RequestParam("aNo") int aNo,
			@RequestParam(value="my", required = false) String my,
			ModelMap model,
			HttpServletRequest request) throws Exception {
		
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		int auctionUserNo = this.farm.getUserByAuction(aNo).getUserNo();	
		
		Auction auction = this.farm.getAuction(aNo);
		
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String deadline = dFormat.format(auction.getDeadline());
		
		model.put("auction", auction);
		model.put("deadline", deadline);
		model.put("my", my);
		
		//check this user is auction's user
		if(user != null) {
			if(user.getUserNo() == auctionUserNo) {
				SBid sBid = this.farm.getSBidByAuction(aNo);	
				ImPur imPur = this.farm.getImPurByAuction(aNo);	
				
				DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				String pDate = null;
				if(sBid != null) {
					pDate = sdFormat.format(sBid.getPayment().getpDate());
				}
				else if(imPur != null) {
					pDate = sdFormat.format(imPur.getPayment().getpDate());
				}
				
				model.put("sBid", sBid);
				model.put("imPur", imPur);
				model.put("pDate", pDate);
			}
		}
		
		return VIEWAUCTION;
	}
	
	
	//delivery 
	@RequestMapping("/auction/auctionDeliveryStateChange.do")
	public String auctionDeliveryPayment(
		@RequestParam("dNo") int dNo,	
		@RequestParam("aNo") int aNo,
		@RequestParam("status") String status,
		ModelMap model) throws Exception {
		
		if(status.equals("배송전")) {
			this.farm.changeDeliveryStatus(dNo);
		}
		else if(status.equals("배송중")) {
			this.farm.changeDeliveryFinish(dNo);
		}
		model.put("aNo", aNo);
		
		return "redirect:/auction/viewAuction.do";
	}
	

	//register auction ... auction form
	@RequestMapping("/auction/registerAuctionForm.do")
	public String auctionForm(
			@ModelAttribute("auctionCommand") AuctionCommand auctionCommand) throws Exception {

		return AUCTIONFORM;
	}
	
	
	//register auction ... insert auction
	@RequestMapping("/auction/registerAuction.do")
	public String register(
			@Valid @ModelAttribute("auctionCommand") AuctionCommand auctionCommand,
			BindingResult bindingResult,
			HttpServletRequest request) throws Exception {
		
		System.out.println("register auction!!");
		
		//validate
		if (bindingResult.hasErrors()) {
			return AUCTIONFORM; 
		}
				
		if (auctionCommand.getProduct() == null) {
			bindingResult.rejectValue("product.pName", "NotNull");
			return AUCTIONFORM; 
		}
		
		if (auctionCommand.getImPurAva() == true && auctionCommand.getImPurPrice() != 0) {
			if(auctionCommand.getMinPrice() >= auctionCommand.getImPurPrice()) {
				bindingResult.rejectValue("imPurPrice", "hastoHighThanMinPrice");
				return AUCTIONFORM; 
			}
		}
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		auctionCommand.getProduct().setpNo(this.farm.getPNoByPName(auctionCommand.getProduct().getpName()));;
		
		//auctionCommand to auction
		Auction auction = new Auction();
		auction.setUser(user);
		auction.setProduct(auctionCommand.getProduct());
		auction.setTitle(auctionCommand.getTitle());	
		auction.setDetail(auctionCommand.getDetail());
		auction.setMinPrice(auctionCommand.getMinPrice());	
		auction.setDeadline(auctionCommand.getDeadline());
		auction.setImPurAva(auctionCommand.getImPurAva());
		auction.setImPurPrice(auctionCommand.getImPurPrice());
		
		MultipartFile image = auctionCommand.getImage();
		if(image != null) {
			uploadFile(image, auction);
		}
		else {
			this.farm.registerAuction(auction);	
		}
		
		return "redirect:/auction/viewAuction.do?aNo=" + auction.getaNo();
	}
	
	private void uploadFile(MultipartFile image, Auction auction) {
		this.farm.registerAuction(auction);	
		System.out.println(image.getOriginalFilename());
		int aNo = this.farm.getLastANo();
		String path = context.getRealPath("/images/auction");
		File file = new File(path, aNo + ".jpg");
		try {
			image.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// file name을 데이터베이스에 저장!
		System.out.println("path: " + path);
		System.out.println("path: " + file.getPath());
		this.farm.addImage(aNo, "images/auction/" + file.getName());
		//this.farm.addImage(auction, (lastANo+1), file.getPath());
	}
	
}
