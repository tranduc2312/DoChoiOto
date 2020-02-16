package com.ductran.dochoioto.model;

import java.util.List;

import com.ductran.dochoioto.entity.Categories;
import com.ductran.dochoioto.entity.Products;

public class CategoriesModel {
	private String categoryId;
	private String categoryCode;
	private String categoryName;
	private boolean categoryStatus;
	private List<Categories> listChildCategory;
	private List<Products> listProducts;
	
	public CategoriesModel() {}
	public CategoriesModel(Categories category) {
		this.categoryId = category.getCategoryId();
		this.categoryCode = category.getCategoryCode();
		this.categoryName = category.getCategoryName();
		this.categoryStatus = category.isCategoryStatus();
		
	}
	public CategoriesModel(String categoryId, String categoryCode, String categoryName, boolean categoryStatus) {
		super();
		this.categoryId = categoryId;
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
		this.categoryStatus = categoryStatus;
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
	public List<Categories> getListChildCategory() {
		return listChildCategory;
	}
	public void setListChildCategory(List<Categories> listChildCategory) {
		this.listChildCategory = listChildCategory;
	}
	public List<Products> getListProducts() {
		return listProducts;
	}
	public void setListProducts(List<Products> listProducts) {
		this.listProducts = listProducts;
	}
	
	
}
