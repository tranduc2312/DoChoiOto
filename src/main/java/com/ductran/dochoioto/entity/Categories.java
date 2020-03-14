package com.ductran.dochoioto.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ductran.dochoioto.model.CategoriesModel;

@Entity
@Table(name = "categories")
public class Categories {

	@Id
	@Column(name = "category_Id",length = 10)
	private String categoryId;
	@Column(name = "category_Code", length = 100)
	private String categoryCode;
	@Column(name = "category_Name", length = 100)
	private String categoryName;
	@Column(name = "category_Status")
	private boolean categoryStatus;
	@Column(name = "category_ParentId")
	private String categoryParentId;
	@JoinColumn(name = "category_ParentId")
	@OneToMany(fetch = FetchType.LAZY)
	private List<Categories> listChildCategory;
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Products> listProducts;
		
	public Categories() {}
	public Categories(CategoriesModel category) {
		this.categoryParentId = category.getCategoryParentId();
		this.categoryId = category.getCategoryId();
		this.categoryCode = category.getCategoryCode();
		this.categoryName = category.getCategoryName();
		this.categoryStatus = category.isCategoryStatus();
	}
	public Categories(String categoryId,String parentId, String categoryCode, String categoryName, boolean status) {
		super();
		this.categoryParentId = parentId;
		this.categoryId = categoryId;
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
		this.categoryStatus = status;
	}
	
	public String getCategoryParentId() {
		return categoryParentId;
	}
	public void setCategoryParentId(String categoryParentId) {
		this.categoryParentId = categoryParentId;
	}
	public List<Products> getListProducts() {
		return listProducts;
	}
	public void setListProducts(List<Products> listProducts) {
		this.listProducts = listProducts;
	}
	public List<Categories> getListChildCategory() {
		return listChildCategory;
	}
	public void setListChildCategory(List<Categories> listChildCategory) {
		this.listChildCategory = listChildCategory;
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
	
}
