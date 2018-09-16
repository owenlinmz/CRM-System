package com.owen.crm.mapper;

import java.util.List;

import com.owen.crm.pojo.Bill;
import com.owen.crm.pojo.QueryVo;

public interface BillDao {
	// 总条数
	public Integer billCountByQueryVo(QueryVo vo);

	// 结果集
	public List<Bill> selectBillListByQueryVo(QueryVo vo);

	// 通过ID查询账单
	public Bill selectBillById(Integer id);

	// 通过ID修改账单
	public void updateBillById(Bill bill);

	// 通过ID删除账单
	public void deleteBillById(Integer id);

	// 添加账单
	public void addBill(Bill bill);
}
