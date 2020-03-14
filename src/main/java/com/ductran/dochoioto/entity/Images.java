package com.ductran.dochoioto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ductran.dochoioto.model.ImageModel;

@Entity
@Table(name = "images")
public class Images {
	
	@Id
	@Column(name = "image_Id")
	private String imageId;
	@Column(name = "image_Url")
	private String imageUrl;
	@Column(name = "image_Title")
	private String imageTitle;
	@Column(name = "image_isBanner")
	private boolean isBanner;
	@Column(name = "image_isPrimary")
	private boolean isPrimary;
	@Column(name = "image_Status")
	private boolean imageStatus;
	@JoinColumn(name = "product_Id")
	@ManyToOne
	private Products product;
	
	public Images() {}
	public Images(ImageModel image) {
		this.imageId = image.getImageId();
		this.imageUrl = image.getImageUrl();
		this.imageTitle = image.getImageTitle();
		this.isBanner = image.isBanner();
		this.isPrimary = image.isPrimary();
		this.imageStatus = image.isImageStatus();
//		this.product = new Products(image.getProduct());
	}
	public Images(String imageId, String imageUrl, boolean isBanner, boolean isPrimary, boolean imageStatus) {
		super();
		this.imageId = imageId;
		this.imageUrl = imageUrl;
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

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}
	
	
}
