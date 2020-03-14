package com.ductran.dochoioto.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ductran.dochoioto.model.OrderModel;
import com.ductran.dochoioto.service.OrderService;

@Controller
@RequestMapping("/admin")
public class OrderController {
	@Autowired
	OrderService service;
	
	@GetMapping("/orders")
	public String getListOrder(Model model) {
		List<OrderModel> list = service.listOrder();
		model.addAttribute("listOrder", list);
		System.out.println(list.size());
		return "admin/order-list";
	}
}
