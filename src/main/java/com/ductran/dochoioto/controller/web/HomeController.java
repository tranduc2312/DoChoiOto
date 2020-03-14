package com.ductran.dochoioto.controller.web;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ductran.dochoioto.model.CategoriesModel;
import com.ductran.dochoioto.model.ImageModel;
import com.ductran.dochoioto.model.ProductModel;
import com.ductran.dochoioto.service.CategoryService;
import com.ductran.dochoioto.service.ImageService;
import com.ductran.dochoioto.service.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static final String HOME_PAGE = "web/home";
	private static final String CATEGORY_PAGE = "web/category";
	private static final String DETAIL_PAGE = "web/product-detail";

	@Autowired
	ResourceBundleMessageSource messageSource;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
	ImageService imageService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		List<CategoriesModel> listCategory = categoryService.findAll();
		for (CategoriesModel categoriesModel : listCategory) {
			List<ProductModel> listProduct = productService.findById(categoriesModel.getCategoryId(), 3);
			categoriesModel.setListProducts(listProduct);
			for (ProductModel productModel : listProduct) {
				List<ImageModel> listImage = imageService.findById(productModel.getProductId(), 2);
				System.out.println("size: " + listImage.size());
				if (listImage.size() > 0) {
					productModel.setImageUrl(listImage.get(0).getImageUrl());
				}

			}
		}

		model.addAttribute("listCategory", listCategory);
		// System.out.println(messageSource.getMessage("user.name", null, null));
		return HOME_PAGE;
	}

	@GetMapping("/{category}")
	public String categoryPage(Model model, @PathVariable("category") String category) {
		System.out.println("Category: " + category);
		List<CategoriesModel> listCategory = categoryService.findAll();
		List<ProductModel> listProduct = productService.findAllByCode(category, 1, 3);
		for (ProductModel productModel : listProduct) {
			List<ImageModel> listImage = imageService.findById(productModel.getProductId(), 3);
			System.out.println("size: " + listImage.size());
			if (listImage.size() > 0) {
				productModel.setImageUrl(listImage.get(0).getImageUrl());
			}
		}
		model.addAttribute("listProduct", listProduct);
		model.addAttribute("listCategory", listCategory);
		return CATEGORY_PAGE;
	}

	@GetMapping("/{category}/{product}")
	public String detailPage(Model model, @PathVariable("category") String category,
			@PathVariable("product") String productCode) {
		System.out.println("Category: " + category + "\tProduct: " + productCode);
		List<CategoriesModel> listCategory = categoryService.findAll();
		
		ProductModel productModel = productService.findOneByCode(productCode);
		List<ImageModel> listImage = imageService.findById(productModel.getProductId(), 3);
		System.out.println("size: " + listImage.size());
		productModel.setListImages(listImage);
		
		model.addAttribute("product", productModel);
		model.addAttribute("listCategory", listCategory);
		return DETAIL_PAGE;
	}

}
