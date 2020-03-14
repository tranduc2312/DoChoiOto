package com.ductran.dochoioto.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ductran.dochoioto.model.CategoriesModel;
import com.ductran.dochoioto.service.CategoryService;

@Controller
@RequestMapping("/admin")
public class CategoryController {
	public static final String LIST_CATE_PAGE = "admin/category-list";
	public static final String ADD_CATE_PAGE = "admin/category-add";
	public static final String EDIT_CATE_PAGE = "admin/category-edit";
	public static final String REDIRECT_PAGE = "redirect:/admin/categories";
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/categories")
	public String getPageList(Model model) {
		model.addAttribute("listCategory", categoryService.findAll());
		return LIST_CATE_PAGE;
	}
	@GetMapping(value = "/categories",params = "op=add")
	public String getPageAdd(Model model) {
		model.addAttribute("idCategory", categoryService.autoID());
		model.addAttribute("listCategory", categoryService.findAll());
		return ADD_CATE_PAGE;
	}
	@PostMapping(value = "/addCategory")
	public String addCategory(@ModelAttribute(name = "model") CategoriesModel model) {
		if(categoryService.add(model)) {
			System.out.println("Add success");
		}else {
			System.out.println("Add fail");
		}
		return REDIRECT_PAGE;
	}
	@GetMapping(value = "/categories",params = "op=edit")
	public String getPageEdit(Model model, @RequestParam("id") String id) {
		model.addAttribute("category", categoryService.findOneById(id));
		model.addAttribute("listCategory", categoryService.findAll());
		return EDIT_CATE_PAGE;
	}
	@PostMapping(value = "/editCategory")
	public String editCategory(@ModelAttribute(name = "model") CategoriesModel model) {
		if(categoryService.edit(model)) {
			System.out.println("Edit success");
		}else {
			System.out.println("Edit fail");
		}
		return REDIRECT_PAGE;
	}
	@GetMapping(value = "/categories",params = "op=del")
	public String delCategory(@RequestParam("id") String id) {
		if(categoryService.delete(id)) {
			System.out.println("Delete success");
		}else {
			System.out.println("Delete fail");
		}
		return REDIRECT_PAGE;
	}
	
}
