package com.owen.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owen.crm.mapper.BillDao;
import com.owen.crm.pojo.Bill;
import com.owen.crm.pojo.QueryVo;
import com.owen.page.Page;

@Service
public class BillServiceImpl implements BillService {
	@Autowired
	private BillDao billDao;

	// 通过Name 查询分页对象
	public Page<Bill> selectPageByQueryVo(QueryVo vo) {
		Page<Bill> page = new Page<Bill>();
		// 每页数
		page.setSize(10);
		vo.setSize(10);
		if (vo != null) {
			// 判断当前页
			if (vo.getPage() != null) {
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage() - 1) * vo.getSize());
			}
			// 不为空且不为空串
			if (vo.getCustName() != null && !"".equals(vo.getCustName().trim())) {
				vo.setCustName(vo.getCustName().trim());
			}
			if (vo.getCustPhone() != null && !"".equals(vo.getCustPhone().trim())) {
				vo.setCustPhone(vo.getCustPhone().trim());
			}
			// 总条数
			page.setTotal(billDao.billCountByQueryVo(vo));
			page.setRows(billDao.selectBillListByQueryVo(vo));
		}
		return page;

	}
	
	// 通过ID查询客户
	public Bill selectBillById(Integer id) {
		return billDao.selectBillById(id);
	}

	// 修改客户通过ID
	public void updateBillById(Bill bill) {
		billDao.updateBillById(bill);
	}

	// 通过ID 删除客户
	public void deleteBillById(Integer id) {
		billDao.deleteBillById(id);
	}

	// 添加客户
	public void addBill(Bill bill) {
		billDao.addBill(bill);
	}
}
