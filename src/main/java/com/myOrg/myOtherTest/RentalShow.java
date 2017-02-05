package com.myOrg.myOtherTest;

import java.util.Date;

public class RentalShow{
	
	private String id;
	private String bookuri;
	private String customeruri;
	private String start;
	private String end;
	private String _id;
	private String _rev;
	
	public RentalShow(){
	}
	public RentalShow(String id, String bookuri, String customeruri, Date start, Date end){
		this.id = id;
		this._id=id;
		this.bookuri = bookuri;
		this.customeruri = customeruri;
		this.start = start.toString();
		this.end = end.toString();
	}
	public RentalShow(String id, String _id, String _rev, String bookuri, String customeruri, Date start, Date end){
		this.id = id;
		this._id=_id;
		this._rev = _rev;
		this.bookuri = bookuri;
		this.customeruri = customeruri;
		this.start = start.toString();
		this.end = end.toString();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookuri() {
		return bookuri;
	}
	public void setBookuri(String bookuri) {
		this.bookuri = bookuri;
	}
	public String getCustomeruri() {
		return customeruri;
	}
	public void setCustomeruri(String customeruri) {
		this.customeruri = customeruri;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}

	
	
}