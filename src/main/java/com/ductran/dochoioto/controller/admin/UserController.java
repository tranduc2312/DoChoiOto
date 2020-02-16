package com.ductran.dochoioto.controller.admin;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ductran.dochoioto.model.UserModel;

@RequestMapping("/admin")
public interface UserController {
	public static final String LIST_USER_PAGE = "admin/user-list";
	public static final String ADD_USER_PAGE = "admin/user-add";
	public static final String EDIT_USER_PAGE = "admin/user-edit";
	public static final String REDIRECT_PAGE = "redirect:/admin/users";
	
	  @GetMapping("/users") 
	  public String showAll(Model model);
	  
	  @GetMapping(value = "/users",params = "op=add") 
	  public String getAddPage(Model model);
	  
	  @PostMapping(value = "/addUser") 
	  public String addUser(@ModelAttribute(name = "userModel") UserModel model);
	  
	  @GetMapping(value = "/users", params = "op=edit") 
	  public String getEditPage(Model model, @RequestParam(name = "userId") String userId);
	  
	  @PostMapping(value = "/editUser")
	  public String editUser(@ModelAttribute(name = "userModel") UserModel model);
	 
	  @GetMapping(value = "/users", params = "op=del")
	  public String deleteUser(@RequestParam(name = "id") String id);
}
