package com.owen.crm.service;

import com.owen.crm.pojo.Bill;
import com.owen.crm.pojo.QueryVo;
import com.owen.page.Page;

public interface BillService {

	public Page<Bill> selectPageByQueryVo(QueryVo vo);
	
	//通过ID查询客户
	public Bill selectBillById(Integer id);
	
	//修改客户通过ID
	public void updateBillById(Bill bill);
	
	//通过ID 删除客户
	public void deleteBillById(Integer id);
	
	//添加客户
	public void addBill(Bill bill);

}
