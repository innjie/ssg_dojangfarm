package com.ssg.dojangfarm.controller.normal;

public class ViewAllNormalListController {

}

/*   이거 대충 참고하세요.. 제가 예전에 카테고리 컨트롤러 짠 거에요..
@Controller
@SessionAttributes({"category", "normalList"}) //모름
public class ViewCategoryController { 
	private FarmFacade farm;

	@Autowired
	public void setFarm(FarmFacade  farm) {
		this.farm = farm;
	}
	
	@RequestMapping("/farm/category/viewCategory.do")
	public String handleRequest(
			@RequestParam("cateNo") int cateNo,
			ModelMap model
			) throws Exception {
		Category category = this.farm.getCategory(cateNo);

		PagedListHolder<Normal> productList = new PagedListHolder<Normal>(this.farm.getCategory(cateNo));	//채소,과일로 일반판매 분류

		productList.setPageSize(4);
		model.put("category", category);
		model.put("normalList", normalList);
		return "Normal";   
	}

	@RequestMapping("/farm/category/viewCategory2.do")
	public String handleRequest2(
			@RequestParam("page") String page,
			@ModelAttribute("category") Category category,
			@ModelAttribute("normalList") PagedListHolder<Normal> normalList,
			BindingResult result) throws Exception {
		if (category == null || normalList == null) {
			throw new IllegalStateException("Cannot find pre-loaded category and normal list");
		}
		if ("next".equals(page)) { normalList.nextPage(); }
		else if ("previous".equals(page)) { normalList.previousPage(); }
		return "Normal";   
	}
}

*/