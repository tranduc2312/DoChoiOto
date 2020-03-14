package com.ductran.dochoioto.model;

import com.ductran.dochoioto.entity.OrderDetails;

public class OrderDetailModel {
	
	
	private String orderId;
	private String productId;
	private int productAmount;
	private boolean orderDStatus;
	private ProductModel product;
	private OrderModel order;
	
	public OrderDetailModel() {}
	
	public OrderDetailModel(OrderDetails detail) {
		this.orderId = detail.getOrderDetailId().getOrderId();
		this.productId = detail.getProduct().getProductId();
		this.productAmount = detail.getProductAmount();
		this.orderDStatus = detail.isOrderDStatus();
		this.product = new ProductModel(detail.getProduct());
		this.order = new OrderModel(detail.getOrder());
	}
	
	public OrderDetailModel(String orderId, String productId, int productAmount, boolean orderDStatus) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.productAmount = productAmount;
		this.orderDStatus = orderDStatus;
	}


	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public OrderModel getOrder() {
		return order;
	}

	public void setOrder(OrderModel order) {
		this.order = order;
	}
	
	
	
}
