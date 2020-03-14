package com.ductran.dochoioto.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ductran.dochoioto.model.ProductModel;

@Entity
@Table(name = "products")
public class Products {
	
	@Id
	@Column(name = "product_Id", length = 10)
	private String productId;
	@Column(name = "product_Code", length = 150)
	private String productCode;
	@Column(name = "product_Name", length = 150)
	private String productName;
	@Column(name = "product_InfoDetail")
	private String productInfo;
	@Column(name = "product_Price")
	private float productPrice;
	@Column(name = "product_Status")
	private boolean productStatus;
	@JoinColumn(name = "category_Id")
	@ManyToOne
	private Categories category;
	@JoinColumn(name = "product_Id")
	@OneToMany(fetch = FetchType.LAZY)
	private List<Comments> listComments;
	@JoinColumn(name = "product_Id")
	@OneToMany(fetch = FetchType.LAZY)
	private List<Images> listImages;
	@JoinColumn(name = "product_Id")
	@OneToMany(fetch = FetchType.LAZY)
	private List<OrderDetails> listOrderDetails;
	
	public Products() {}
	
	public Products(String id) {
		this.productId = id;
	}
	public Products(ProductModel product) {
		this.productId = product.getProductId();
		this.productCode = product.getProductCode();
		this.productName = product.getProductName();
		this.productInfo = product.getProductInfo();
		this.productPrice = product.getProductPrice();
		this.productStatus = product.isProductStatus();
		this.category = new Categories(product.getCategory());
	}
	
	public Products(String productId, String productCode, String productName, String productInfo, float productPrice,
			boolean productStatus) {
		super();
		this.productId = productId;
		this.productCode = productCode;
		this.productName = productName;
		this.productInfo = productInfo;
		this.productPrice = productPrice;
		this.productStatus = productStatus;
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
	
	
}
