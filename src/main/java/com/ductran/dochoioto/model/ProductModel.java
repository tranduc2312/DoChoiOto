package com.ductran.dochoioto.model;

import java.util.List;

import com.ductran.dochoioto.entity.Products;

public class ProductModel {
	private String productId;
	private String productCode;
	private String productName;
	private String productInfo;
	private float productPrice;
	private boolean productStatus;
	private CategoriesModel category;
	private List<CommentModel> listComments;
	private List<ImageModel> listImages;
	private List<OrderDetailModel> listOrderDetails;
	private String imageUrl;
	
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public ProductModel() {}
	
	public ProductModel(Products product) {
		this.productId = product.getProductId();
		this.productCode = product.getProductCode();
		this.productName = product.getProductName();
		this.productInfo = product.getProductInfo();
		this.productPrice = product.getProductPrice();
		this.productStatus = product.isProductStatus();
		this.category = new CategoriesModel(product.getCategory());
	}
	
	public ProductModel(String productId, String productCode, String productName, String productInfo,
			float productPrice, boolean productStatus) {
		super();
		this.productId = productId;
		this.productCode = productCode;
		this.productName = productName;
		this.productInfo = productInfo;
		this.productPrice = productPrice;
		this.productStatus = productStatus;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public boolean isProductStatus() {
		return productStatus;
	}
	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}
	public CategoriesModel getCategory() {
		return category;
	}
	public void setCategory(CategoriesModel category) {
		this.category = category;
	}
	public List<CommentModel> getListComments() {
		return listComments;
	}
	public void setListComments(List<CommentModel> listComments) {
		this.listComments = listComments;
	}
	public List<ImageModel> getListImages() {
		return listImages;
	}
	public void setListImages(List<ImageModel> listImages) {
		this.listImages = listImages;
	}
	public List<OrderDetailModel> getListOrderDetails() {
		return listOrderDetails;
	}
	public void setListOrderDetails(List<OrderDetailModel> listOrderDetails) {
		this.listOrderDetails = listOrderDetails;
	}
	
	
}
