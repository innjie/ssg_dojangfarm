package com.ssg.dojangfarm.controller.normal;

public class ViewAllNormalListController {

}

/*   �̰� ���� �����ϼ���.. ���� ������ ī�װ� ��Ʈ�ѷ� § �ſ���..
@Controller
@SessionAttributes({"category", "normalList"}) //��
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

		PagedListHolder<Normal> productList = new PagedListHolder<Normal>(this.farm.getCategory(cateNo));	//ä��,���Ϸ� �Ϲ��Ǹ� �з�

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