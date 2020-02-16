package com.ductran.dochoioto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customers {

	@Id
	@Column(name = "ctm_Id", length = 10)
	private String ctmId;
	@Column(name = "ctm_FullName",length = 50)
	private String ctmFullName;
	@Column(name = "ctm_Email", length = 40)
	private String ctmEmail;
	@Column(name = "ctm_Phone", length = 10)
	private String ctmPhone;
	@Column(name = "ctm_Address")
	private String ctmAddress;
	@Column(name = "ctm_Notes")
	private String ctmNotes;
	@Column(name = "ctm_Status")
	private boolean ctmStatus;
	@OneToOne(mappedBy = "customers")
	private Orders order;
	
	
	public Customers() {}
	public Customers(String ctmId, String ctmFullName, String ctmEmail, String ctmPhone, String ctmAddress,
			String ctmNotes, boolean ctmStatus) {
		super();
		this.ctmId = ctmId;
		this.ctmFullName = ctmFullName;
		this.ctmEmail = ctmEmail;
		this.ctmPhone = ctmPhone;
		this.ctmAddress = ctmAddress;
		this.ctmNotes = ctmNotes;
		this.ctmStatus = ctmStatus;
	}
	public String getCtmId() {
		return ctmId;
	}
	public void setCtmId(String ctmId) {
		this.ctmId = ctmId;
	}
	public String getCtmFullName() {
		return ctmFullName;
	}
	public void setCtmFullName(String ctmFullName) {
		this.ctmFullName = ctmFullName;
	}
	public String getCtmEmail() {
		return ctmEmail;
	}
	public void setCtmEmail(String ctmEmail) {
		this.ctmEmail = ctmEmail;
	}
	public String getCtmPhone() {
		return ctmPhone;
	}
	public void setCtmPhone(String ctmPhone) {
		this.ctmPhone = ctmPhone;
	}
	public String getCtmAddress() {
		return ctmAddress;
	}
	public void setCtmAddress(String ctmAddress) {
		this.ctmAddress = ctmAddress;
	}
	public String getCtmNotes() {
		return ctmNotes;
	}
	public void setCtmNotes(String ctmNotes) {
		this.ctmNotes = ctmNotes;
	}
	public boolean isCtmStatus() {
		return ctmStatus;
	}
	public void setCtmStatus(boolean ctmStatus) {
		this.ctmStatus = ctmStatus;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	
	
	
}
