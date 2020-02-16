package com.ductran.dochoioto.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ductran.dochoioto.entity.Categories;
import com.ductran.dochoioto.entity.Comments;
import com.ductran.dochoioto.entity.Images;
import com.ductran.dochoioto.entity.OrderDetails;
import com.ductran.dochoioto.entity.Products;

public class ProductModel {
	private String productId;
	private String productCode;
	private String productName;
	private String productInfo;
	private float productPrice;
	private boolean productStatus;
	private Categories category;
	private List<Comments> listComments;
	private List<Images> listImages;
	private List<OrderDetails> listOrderDetails;
	
	public ProductModel() {}
	
	public ProductModel(Products product) {
		this.productId = product.getProductId();
		this.productCode = product.getProductCode();
		this.productName = product.getProductName();
		this.productInfo = product.getProductInfo();
		this.productPrice = product.getProductPrice();
		this.productStatus = product.isProductStatus();
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
	public Categories getCategory() {
		return category;
	}
	public void setCategory(Categories category) {
		this.category = category;
	}
	public List<Comments> getListComments() {
		return listComments;
	}
	public void setListComments(List<Comments> listComments) {
		this.listComments = listComments;
	}
	public List<Images> getListImages() {
		return listImages;
	}
	public void setListImages(List<Images> listImages) {
		this.listImages = listImages;
	}
	public List<OrderDetails> getListOrderDetails() {
		return listOrderDetails;
	}
	public void setListOrderDetails(List<OrderDetails> listOrderDetails) {
		this.listOrderDetails = listOrderDetails;
	}
	
	
}
