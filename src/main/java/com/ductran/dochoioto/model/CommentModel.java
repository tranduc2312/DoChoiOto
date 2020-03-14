package com.ductran.dochoioto.model;

import java.sql.Timestamp;

import com.ductran.dochoioto.entity.Comments;

public class CommentModel {
	
	private String cmtId;
	private String cmtContent;
	private Timestamp cmtDate;
	private String cmtFullName;
	private String cmtPhone;
	private boolean cmtStatus;
	private ProductModel product;
	
	public CommentModel() {}
	public CommentModel(Comments cmt) {
		this.cmtId = cmt.getCmtId();
		this.cmtContent = cmt.getCmtContent();
		this.cmtDate = cmt.getCmtDate();
		this.cmtFullName = cmt.getCmtFullName();
		this.cmtPhone = cmt.getCmtPhone();
		this.cmtStatus = cmt.isCmtStatus();
		this.product = new ProductModel(cmt.getProduct());
	}
	public CommentModel(String cmtId, String cmtContent, Timestamp cmtDate, String cmtFullName, String cmtPhone,
			boolean cmtStatus) {
		super();
		this.cmtId = cmtId;
		this.cmtContent = cmtContent;
		this.cmtDate = cmtDate;
		this.cmtFullName = cmtFullName;
		this.cmtPhone = cmtPhone;
		this.cmtStatus = cmtStatus;
	}
	public String getCmtId() {
		return cmtId;
	}
	public void setCmtId(String cmtId) {
		this.cmtId = cmtId;
	}
	public String getCmtContent() {
		return cmtContent;
	}
	public void setCmtContent(String cmtContent) {
		this.cmtContent = cmtContent;
	}
	public Timestamp getCmtDate() {
		return cmtDate;
	}
	public void setCmtDate(Timestamp cmtDate) {
		this.cmtDate = cmtDate;
	}
	public String getCmtFullName() {
		return cmtFullName;
	}
	public void setCmtFullName(String cmtFullName) {
		this.cmtFullName = cmtFullName;
	}
	public String getCmtPhone() {
		return cmtPhone;
	}
	public void setCmtPhone(String cmtPhone) {
		this.cmtPhone = cmtPhone;
	}
	public boolean isCmtStatus() {
		return cmtStatus;
	}
	public void setCmtStatus(boolean cmtStatus) {
		this.cmtStatus = cmtStatus;
	}
	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
	}
	
	
	
}
