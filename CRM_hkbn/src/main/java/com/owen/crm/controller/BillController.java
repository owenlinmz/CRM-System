package com.owen.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.owen.crm.pojo.Bill;
import com.owen.crm.pojo.QueryVo;
import com.owen.crm.service.BillService;
import com.owen.page.Page;

/**
 * 
 *酒店管理
 * @author linn2
 *
 */
@Controller
@RequestMapping(value = "/bill")
public class BillController {

	@Autowired
	private BillService billService;

	
	//根据用户名称和手机 条件查询相关账单
	@RequestMapping(value = "/list")
	public String list(QueryVo vo, Model model) {
		Page<Bill> page = billService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custPhone", vo.getCustPhone());
		return "bill";

	}

	// 修改账单信息
	@RequestMapping(value = "/edit.action")
	public @ResponseBody Bill edit(Integer id) {
		return billService.selectBillById(id);
	}

	// 提交修改
	@RequestMapping(value = "/update.action")
	public @ResponseBody String update(Bill bill) {
		billService.updateBillById(bill);
		return "OK";
	}

	// 删除账单
	@RequestMapping(value = "/delete.action")
	public @ResponseBody String delete(Integer id) {
		billService.deleteBillById(id);
		return "OK";
	}

	// 添加账单
	@RequestMapping(value = "/add.action")
	public @ResponseBody String add(Bill bill) {
		billService.addBill(bill);
		return "OK";
	}
}
