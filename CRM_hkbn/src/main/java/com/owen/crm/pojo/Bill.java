package com.owen.crm.pojo;

import java.util.Date;

public class Bill {

	private Integer bill_id;
	private Integer cust_id;
	private Float bill_money;
	private Date bill_createtime;

	public Integer getBill_id() {
		return bill_id;
	}

	public void setBill_id(Integer bill_id) {
		this.bill_id = bill_id;
	}

	public Integer getCust_id() {
		return cust_id;
	}

	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}

	public Float getBill_money() {
		return bill_money;
	}

	public void setBill_money(Float bill_money) {
		this.bill_money = bill_money;
	}

	public Date getBill_createtime() {
		return bill_createtime;
	}

	public void setBill_createtime(Date bill_createtime) {
		this.bill_createtime = bill_createtime;
	}

}
