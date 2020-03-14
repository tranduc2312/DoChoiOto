package com.ductran.dochoioto.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ductran.dochoioto.model.CommentModel;

@Entity
@Table(name = "comments")
public class Comments {
	
	@Id
	@Column(name = "cmt_Id", length = 10)
	private String cmtId;
	@Column(name = "cmt_Content")
	private String cmtContent;
	@Column(name = "cmt_Date")
	private Timestamp cmtDate;
	@Column(name = "cmt_Fullname", length = 50)
	private String cmtFullName;
	@Column(name = "cmt_phoneUser", length = 10)
	private String cmtPhone;
	@Column(name = "cmt_Status")
	private boolean cmtStatus;
	@JoinColumn(name = "product_Id")
	@ManyToOne
	private Products product;
	
	public Comments() {}
	public Comments(CommentModel cmt) {
		this.cmtId = cmt.getCmtId();
		this.cmtContent = cmt.getCmtContent();
		this.cmtDate = cmt.getCmtDate();
		this.cmtFullName = cmt.getCmtFullName();
		this.cmtPhone = cmt.getCmtPhone();
		this.cmtStatus = cmt.isCmtStatus();
		this.product = new Products(cmt.getProduct());
	}
	public Comments(String cmtId, String cmtContent, Timestamp cmtDate, String cmtFullName, String cmtPhone,
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
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	
	
	
}
