package com.ductran.dochoioto.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ductran.dochoioto.model.ProductModel;
import com.ductran.dochoioto.service.CategoryService;
import com.ductran.dochoioto.service.ProductService;


@Controller
@RequestMapping("/admin")
public class ProductController {
	public static final String LIST_PAGE = "admin/product-list";
	public static final String ADD_PAGE = "admin/product-add";
	public static final String EDIT_PAGE = "admin/product-edit";
	public static final String REDIRECT_PAGE = "redirect:/admin/products";
	
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/products")
	public String getPageList(Model model) {
		model.addAttribute("listProduct", productService.findAll());
		return LIST_PAGE;
	}
	@GetMapping(value = "/products",params = "op=add")
	public String getPageAdd(Model model) {
		model.addAttribute("idProduct", productService.autoID());
		model.addAttribute("listCategory", categoryService.findAll());
		return ADD_PAGE;
	}
	@PostMapping(value = "/addProduct")
	public String addCategory(@ModelAttribute(name = "model") ProductModel model) {
		if(productService.add(model)) {
			System.out.println("Add success");
		}else {
			System.out.println("Add fail");
		}
		return REDIRECT_PAGE;
	}
	@GetMapping(value = "/products",params = "op=edit")
	public String getPageEdit(Model model, @RequestParam("id") String id) {
		model.addAttribute("product", productService.findOneById(id));
		model.addAttribute("listCategory", categoryService.findAll());
		return EDIT_PAGE;
	}
	@PostMapping(value = "/editProduct")
	public String editCategory(@ModelAttribute(name = "model") ProductModel model) {
		if(productService.edit(model)) {
			System.out.println("Edit success");
		}else {
			System.out.println("Edit fail");
		}
		return REDIRECT_PAGE;
	}
	@GetMapping(value = "/products",params = "op=del")
	public String delCategory(@RequestParam("id") String id) {
		if(productService.delete(id)) {
			System.out.println("Delete success");
		}else {
			System.out.println("Delete fail");
		}
		return REDIRECT_PAGE;
	}
	
}
