package com.owen.crm.pojo;

public class QueryVo {

	// 客户信息
	private String custName;
	private String custPhone;

	// 账单信息
/*	private Integer custid;
	private Float billMoney;*/

	// 当前页
	private Integer page;
	// 每页数
	private Integer size = 10;
	// 开始行
	private Integer startRow = 0;

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

/*	public Integer getCustid() {
		return custid;
	}

	public void setCustid(Integer custid) {
		this.custid = custid;
	}

	public Float getBillMoney() {
		return billMoney;
	}

	public void setBillMoney(Float billMoney) {
		this.billMoney = billMoney;
	}*/

}
