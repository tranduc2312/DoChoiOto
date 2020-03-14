package com.ductran.dochoioto.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.ductran.dochoioto.model.OrderModel;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@Column(name = "order_Id",length = 10)
	private String orderId;
	@Column(name = "order_Cost")
	private float orderCost;
	@Column(name = "order_Date")
	@CreationTimestamp
	private Timestamp orderDate;
	@Column(name = "order_Status")
	private boolean orderStatus;
	@Column(name = "order_isConfirm")
	private boolean orderConfirm;
	@JoinColumn(name = "ctm_Id")
	@OneToOne
	private Customers customers;
	@JoinColumn(name = "order_Id")
	@OneToMany(fetch = FetchType.LAZY)
	private List<OrderDetails> listOrderDetails;
	
	public Orders() {}
	public Orders(OrderModel order) {
		this.orderId = order.getOrderId();
		this.orderCost = order.getOrderCost();
		this.orderDate = order.getOrderDate();
		this.orderStatus = order.isOrderStatus();
		this.orderConfirm = order.isOrderConfirm();
		this.customers = new Customers(order.getCustomers());
	}
	public Orders(String orderId, float orderCose, Timestamp orderDate, boolean orderStatus) {
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

	public List<OrderDetails> getListOrderDetails() {
		return listOrderDetails;
	}

	public void setListOrderDetails(List<OrderDetails> listOrderDetails) {
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

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

}
