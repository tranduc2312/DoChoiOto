package com.ductran.dochoioto.model;

import com.ductran.dochoioto.entity.Images;

public class ImageModel {
	private String imageId;
	private String imageUrl;
	private String imageTitle;
	private boolean isBanner;
	private boolean isPrimary;
	private boolean imageStatus;
	private ProductModel product;
	public ImageModel() {}
	public ImageModel(Images image) {
		this.imageId = image.getImageId();
		this.imageUrl = image.getImageUrl();
		this.imageTitle = image.getImageTitle();
		this.isBanner = image.isBanner();
		this.isPrimary = image.isPrimary();
		this.imageStatus = image.isImageStatus();
		this.product = new ProductModel(image.getProduct());
	}
	public ImageModel(String imageId, String imageUrl, String imageTitle, boolean isBanner, boolean isPrimary,
			boolean imageStatus) {
		super();
		this.imageId = imageId;
		this.imageUrl = imageUrl;
		this.imageTitle = imageTitle;
		this.isBanner = isBanner;
		this.isPrimary = isPrimary;
		this.imageStatus = imageStatus;
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getImageTitle() {
		return imageTitle;
	}
	public void setImageTitle(String imageTitle) {
		this.imageTitle = imageTitle;
	}
	public boolean isBanner() {
		return isBanner;
	}
	public void setBanner(boolean isBanner) {
		this.isBanner = isBanner;
	}
	public boolean isPrimary() {
		return isPrimary;
	}
	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
	public boolean isImageStatus() {
		return imageStatus;
	}
	public void setImageStatus(boolean imageStatus) {
		this.imageStatus = imageStatus;
	}
	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
	}
	
	
}
