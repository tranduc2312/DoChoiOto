package com.ductran.dochoioto.model;

import java.util.List;

import com.ductran.dochoioto.entity.Categories;

public class CategoriesModel {
	private String categoryId;
	private String categoryCode;
	private String categoryName;
	private boolean categoryStatus;
	private String categoryParentId;
	private List<CategoriesModel> listChildCategory;
	private List<ProductModel> listProducts;
	
	public CategoriesModel() {}
	public CategoriesModel(Categories category) {
		this.categoryId = category.getCategoryId();
		this.categoryParentId = category.getCategoryParentId();
		this.categoryCode = category.getCategoryCode();
		this.categoryName = category.getCategoryName();
		this.categoryStatus = category.isCategoryStatus();
		
	}
	public CategoriesModel(String categoryId, String parentId, String categoryCode, String categoryName, boolean categoryStatus) {
		super();
		this.categoryParentId = parentId;
		this.categoryId = categoryId;
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
		this.categoryStatus = categoryStatus;
	}
	
	public String getCategoryParentId() {
		return categoryParentId;
	}
	public void setCategoryParentId(String categoryParentId) {
		this.categoryParentId = categoryParentId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public boolean isCategoryStatus() {
		return categoryStatus;
	}
	public void setCategoryStatus(boolean categoryStatus) {
		this.categoryStatus = categoryStatus;
	}
	public List<CategoriesModel> getListChildCategory() {
		return listChildCategory;
	}
	public void setListChildCategory(List<CategoriesModel> listChildCategory) {
		this.listChildCategory = listChildCategory;
	}
	public List<ProductModel> getListProducts() {
		return listProducts;
	}
	public void setListProducts(List<ProductModel> listProducts) {
		this.listProducts = listProducts;
	}
	
	
}
