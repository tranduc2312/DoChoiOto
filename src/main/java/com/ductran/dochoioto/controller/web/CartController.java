package com.ductran.dochoioto.controller.web;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ductran.dochoioto.model.CustomerModel;
import com.ductran.dochoioto.model.OrderDetailModel;
import com.ductran.dochoioto.model.OrderModel;
import com.ductran.dochoioto.service.CustomerService;
import com.ductran.dochoioto.service.OrderDetailService;
import com.ductran.dochoioto.service.OrderService;

@Controller
public class CartController {
	public static final String CART_PAGE = "web/cart";
	public static final String CHECKOUT_PAGE = "web/checkout";
	
	@Autowired
	CustomerService customerService;
	@Autowired
	OrderService orderService;
	@Autowired
	OrderDetailService orderDetailService;
	
	@GetMapping("/carts")
	public String getPageCart(HttpSession session, HttpServletRequest req) {
		session = req.getSession();
		OrderModel order = (OrderModel) session.getAttribute("session_id");
		/*
		 * if(order == null) { UUID uuid = UUID.randomUUID(); OrderModel orderSession =
		 * new OrderModel(); orderSession.setOrderId(uuid.toString());
		 * session.setAttribute("session_id", orderSession); }
		 */
		
		req.setAttribute("myCart", order);
		return CART_PAGE;
	}
	@PostMapping("/carts")
	public String addOrder(HttpSession session, HttpServletRequest req, @ModelAttribute("orderDetail") OrderDetailModel orderDetailModel) {
		session = req.getSession();
		OrderModel order = new OrderModel();
		order = (OrderModel) session.getAttribute("session_id");
		System.out.println(orderDetailModel.getProductId());
		if(order==null) {
			UUID uuid = UUID.randomUUID();
			OrderModel orderSession = new OrderModel();
			orderSession.setOrderId(uuid.toString());
			List<OrderDetailModel> listOrder = new ArrayList<OrderDetailModel>();
			listOrder.add(orderDetailModel);
			orderSession.setListOrderDetails(listOrder);
			session.setAttribute("session_id", orderSession);
			System.out.println(uuid);
			req.setAttribute("myCart", order);
		}
		else {
			List<OrderDetailModel> listOrder = order.getListOrderDetails();
			int amount = 0;
			for (OrderDetailModel orderdetail : listOrder) {
				if(orderdetail.getProductId().equals(orderDetailModel.getProductId())) {
					
					amount = orderdetail.getProductAmount()+orderDetailModel.getProductAmount();
					System.out.println(amount);
					orderdetail.setProductAmount(amount);
					break;
				}
			}
			if(amount==0)
			{
				listOrder.add(orderDetailModel);
			}
			order.setListOrderDetails(listOrder);
			System.out.println(listOrder.size());
			req.setAttribute("myCart", order);
		}
		
		return CART_PAGE;
	}
	@GetMapping("/checkout")
	public String getPageCheckout(HttpSession session, HttpServletRequest req) {
		session = req.getSession();
		OrderModel order = (OrderModel) session.getAttribute("session_id");
		if(order==null) {
			return "redirect:carts";
		}
		
		req.setAttribute("myCart", order);
		return CHECKOUT_PAGE;
		
	}
	@PostMapping("/checkout")
	public String checkout(HttpSession session, HttpServletRequest req,@ModelAttribute("customerModel") CustomerModel customerModel) {
		String ctmId = customerService.autoID();
		customerModel.setCtmId(ctmId);
		if(customerService.add(customerModel)) {
			System.out.println("Add customer: "+ctmId);
			session = req.getSession();
			OrderModel order = (OrderModel) session.getAttribute("session_id");
			float orderCost = 0;
			for (OrderDetailModel orderDetail : order.getListOrderDetails()) {
				orderCost += orderDetail.getProductAmount()*orderDetail.getProduct().getProductPrice();
			}
			order.setCustomers(customerModel);
			order.setOrderCost(orderCost);
			String orderId = orderService.autoID();
			order.setOrderId(orderId);
			
			if(orderService.add(order)) {
				System.out.println("Add order success: "+orderId);
				for (OrderDetailModel orderDetail : order.getListOrderDetails()) {
					orderDetail.setOrderId(orderId);
					if(orderDetailService.add(orderDetail)) {
						System.out.println("add order detail: pdn: "+orderDetail.getProductId());
					}
				}
				
			}
			session.invalidate();
		}
		
		return "web/success";
		
	}
	
}
