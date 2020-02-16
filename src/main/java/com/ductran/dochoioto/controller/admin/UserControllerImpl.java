package com.ductran.dochoioto.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.ductran.dochoioto.model.UserModel;
import com.ductran.dochoioto.service.UserService;

@Controller
public class UserControllerImpl implements UserController {
	@Autowired
	private UserService userService;
	
	@Override
	public String showAll(Model model) {
		model.addAttribute("listUser",userService.findAll());
		return LIST_USER_PAGE;
	}

	@Override
	public String getAddPage(Model model) {
		model.addAttribute("idUser", userService.autoID());
		System.out.println(userService.autoID());
		model.addAttribute("listUser", userService.findAll());
		return ADD_USER_PAGE;
	}

	@Override
	public String addUser(UserModel model) {
		System.out.println("id: "+model.getUserId()+"\nName: "+model.getFullName());
		if(userService.add(model))
			return REDIRECT_PAGE;
		else{
			return REDIRECT_PAGE+"?op=add";
		}
	}

	@Override
	public String getEditPage(Model model, String userId) {
		model.addAttribute("user", userService.findOneById(userId));
		return EDIT_USER_PAGE;
	}

	@Override
	public String editUser(UserModel model) {
		System.out.println("id: "+model.getUserId()+"\nName: "+model.getFullName());
		if(userService.edit(model))
			System.out.println("Edit success");
		else{
			System.out.println("Edit fail");
		}
		return REDIRECT_PAGE;
	}

	@Override
	public String deleteUser(String id) {
		if(userService.delete(id)) {
			System.out.println("Xoa thanh cong");
		}else {
			System.out.println("Xoa khong thanh cong");
		}
		return REDIRECT_PAGE;
	}


}
