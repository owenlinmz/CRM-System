package com.owen.crm.pojo;

import java.util.Date;

public class Customer {

	private Integer cust_id;
	private String cust_name;
	private String cust_phone;
	private Date cust_createtime;

	public Integer getCust_id() {
		return cust_id;
	}

	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_phone() {
		return cust_phone;
	}

	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}

	public Date getCust_createtime() {
		return cust_createtime;
	}

	public void setCust_createtime(Date cust_createtime) {
		this.cust_createtime = cust_createtime;
	}

}
