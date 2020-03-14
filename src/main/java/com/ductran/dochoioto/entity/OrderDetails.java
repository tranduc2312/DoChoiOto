package com.ductran.dochoioto.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ductran.dochoioto.model.OrderDetailModel;

@Entity
@Table(name = "order_details")
public class OrderDetails {
	//@Id //Moi set tam duoc 1 khoa chinh con productID nua
	@EmbeddedId
	private OrderDetailID orderDetailId;
	
	/*
	 * @Column(name = "order_Id",length = 10) private String orderId;
	 * 
	 * @Column(name = "product_Id") private String productId;
	 */
	@Column(name = "product_Amount")
	private int productAmount;
	@Column(name = "order_Detail_Status")
	private boolean orderDStatus;
	@JoinColumn(name = "product_Id",updatable = false,insertable = false)
	@ManyToOne
	private Products product;
	@JoinColumn(name = "order_Id",updatable = false,insertable = false)
	@ManyToOne
	private Orders order;
	
	public OrderDetails() {}
	public OrderDetails(OrderDetailModel model) {
		OrderDetailID id = new OrderDetailID(model.getOrderId(), model.getProductId());
		this.orderDetailId = id;
		this.productAmount = model.getProductAmount();
		this.orderDStatus = model.isOrderDStatus();
		//this.product = new Products(model.getProduct());
		//this.order = new Orders(model.getOrder());
	}
	public OrderDetails(OrderDetailID id, int productAmount, boolean orderDStatus) {
		super();
		this.orderDetailId = id;
		this.productAmount = productAmount;
		this.orderDStatus = orderDStatus;
	}
	
	public OrderDetailID getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(OrderDetailID orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	public boolean isOrderDStatus() {
		return orderDStatus;
	}
	public void setOrderDStatus(boolean orderDStatus) {
		this.orderDStatus = orderDStatus;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	
	
}
