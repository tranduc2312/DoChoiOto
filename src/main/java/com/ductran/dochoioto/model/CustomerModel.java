package com.ductran.dochoioto.model;

import com.ductran.dochoioto.entity.Customers;
import com.ductran.dochoioto.entity.Orders;

public class CustomerModel{

	private String ctmId;
	private String ctmFullName;
	private String ctmEmail;
	private String ctmPhone;
	private String ctmAddress;
	private String ctmNotes;
	private boolean ctmStatus;
	private Orders order;
	
	public CustomerModel() {}
	public CustomerModel(Customers ctm) {
		this.ctmId = ctm.getCtmId();
		this.ctmFullName = ctm.getCtmFullName();
		this.ctmEmail = ctm.getCtmEmail();
		this.ctmPhone = ctm.getCtmPhone();
		this.ctmAddress = ctm.getCtmAddress();
		this.ctmNotes = ctm.getCtmNotes();
		this.ctmStatus = ctm.isCtmStatus();
	}
	public CustomerModel(String ctmId, String ctmFullName, String ctmEmail, String ctmPhone, String ctmAddress,
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
