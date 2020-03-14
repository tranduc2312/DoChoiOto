package com.ductran.dochoioto.controller.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ductran.dochoioto.model.ImageModel;
import com.ductran.dochoioto.model.ProductModel;
import com.ductran.dochoioto.service.ImageService;
import com.ductran.dochoioto.service.ProductService;

@Controller
@RequestMapping("/admin")
public class ImageController {
	 private static final String UPLOAD_DIRECTORY ="/resources/img";  
	@Autowired
	ImageService imageService;
	@Autowired
	ProductService productService;
	
	@GetMapping("/images")
	public String getListImages(Model model) {
		model.addAttribute("listImage", imageService.findAll());
		return "admin/image-list";
	}
	@GetMapping(value = "/images",params = "op=add")
	public String getAddPage(Model model) {
		model.addAttribute("imageId", imageService.autoID());
		model.addAttribute("listProduct", productService.findAll());
		
		return "admin/image-add";
	}
	@PostMapping("/images")
	public String addImage( HttpSession session, @RequestParam(name="file") CommonsMultipartFile file,@RequestParam("imageId") String imageId,
			@RequestParam("imageTitle") String imageTitle//,@RequestParam("isBanner") String isBanner, @RequestParam("isPriamry") String isPrimary
			,@RequestParam("productId") String productId) {
			ServletContext context = session.getServletContext();  
		    String path = context.getRealPath(UPLOAD_DIRECTORY);  
		    String filename = file.getOriginalFilename();  
		  
		    System.out.println(path+" "+filename);        
		  
		    byte[] bytes = file.getBytes();  
		    BufferedOutputStream stream;
			try {
				stream = new BufferedOutputStream(new FileOutputStream(  
				     new File(path + File.separator + filename)));
				stream.write(bytes);  
			    stream.flush();  
			    stream.close();  
			    
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		    
		    ImageModel imageModel = new ImageModel();
		    imageModel.setImageId(imageId);
		    imageModel.setImageTitle(imageTitle);
		    imageModel.setImageUrl("/resources/img/"+filename);
		    ProductModel product = new ProductModel();
		    product.setProductId(productId);
		    imageModel.setProduct(product);
		    if (imageService.add(imageModel))
		    	System.out.println("Added image");
		    else
		    	System.out.println("Add image fail");
		    return "redirect:images";
		
	}
	@GetMapping(value = "/images",params = "op=edit")
	public String getEditImage(Model model,@RequestParam("id") String id) {
		model.addAttribute("listProduct", productService.findAll());
		model.addAttribute("image", imageService.findOneById(id));
		return "admin/image-edit";
	}
	@PostMapping(value="/editImage")
	public String editImage( HttpSession session, @RequestParam(name="file") CommonsMultipartFile file,@RequestParam("imageId") String imageId,
			@RequestParam("imageTitle") String imageTitle//,@RequestParam("isBanner") String isBanner, @RequestParam("isPriamry") String isPrimary
			,@RequestParam("productId") String productId) {
			ServletContext context = session.getServletContext();  
		    String path = context.getRealPath(UPLOAD_DIRECTORY);  
		    String filename = file.getOriginalFilename();  
		  
		    System.out.println(path+" "+filename);        
		  
		    byte[] bytes = file.getBytes();  
		    BufferedOutputStream stream;
			try {
				stream = new BufferedOutputStream(new FileOutputStream(  
				     new File(path + File.separator + filename)));
				stream.write(bytes);  
			    stream.flush();  
			    stream.close();  
			    
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		    
		    ImageModel imageModel = new ImageModel();
		    imageModel.setImageId(imageId);
		    imageModel.setImageTitle(imageTitle);
		    imageModel.setImageUrl("/resources/img/"+filename);
		    imageModel.setBanner(false);
		    imageModel.setPrimary(false);
		    ProductModel product = new ProductModel();
		    product.setProductId(productId);
		    imageModel.setProduct(product);
		    if (imageService.add(imageModel))
		    	System.out.println("Added image");
		    else
		    	System.out.println("Add image fail");
		    return "redirect:images";
	}
}
