package com.ductran.dochoioto.model;

import java.sql.Timestamp;
import java.util.List;

import com.ductran.dochoioto.entity.OrderDetails;
import com.ductran.dochoioto.entity.Orders;

public class OrderModel {
	private String orderId;
	private float orderCost;
	private Timestamp orderDate;
	private boolean orderStatus;
	private boolean orderConfirm;
	private CustomerModel customers;
	private List<OrderDetailModel> listOrderDetails;
	
	public OrderModel() {}
	public OrderModel(Orders order) {
		this.orderId = order.getOrderId();
		this.orderCost = order.getOrderCost();
		this.orderDate = order.getOrderDate();
		this.orderStatus = order.isOrderStatus();
		this.orderConfirm = order.isOrderConfirm();
		this.customers = new CustomerModel(order.getCustomers());
	}
	public OrderModel(String orderId, float orderCose, Timestamp orderDate, boolean orderStatus) {
		super();
		this.orderId = orderId;
		this.orderCost = orderCose;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}
	
	public boolean isOrderConfirm() {
		return orderConfirm;
	}

	public void setOrderConfirm(boolean orderConfirm) {
		this.orderConfirm = orderConfirm;
	}

	public List<OrderDetailModel> getListOrderDetails() {
		return listOrderDetails;
	}

	public void setListOrderDetails(List<OrderDetailModel> listOrderDetails) {
		this.listOrderDetails = listOrderDetails;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public float getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(float orderCose) {
		this.orderCost = orderCose;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public boolean isOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

	public CustomerModel getCustomers() {
		return customers;
	}

	public void setCustomers(CustomerModel customers) {
		this.customers = customers;
	}

}
