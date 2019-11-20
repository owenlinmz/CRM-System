package com.owen.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.owen.page.Page;
import com.owen.crm.pojo.Customer;
import com.owen.crm.pojo.QueryVo;
import com.owen.crm.service.CustomerService;

/**
 * 客户管理
 * 
 * @author linn2
 *
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// 入口
	@RequestMapping(value = "/list")
	public String list(QueryVo vo, Model model) {

		// 通过两个条件查询分页对象
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		return "customer";
	}

	// 修改客户信息
	@RequestMapping(value = "/edit.action")
	public @ResponseBody Customer edit(Integer id) {
		return customerService.selectCustomerById(id);
	}

	// 提交修改
	@RequestMapping(value = "/update.action")
	public @ResponseBody String update(Customer customer) {
		customerService.updateCustomerById(customer);
		return "OK";
	}

	// 删除
	@RequestMapping(value = "/delete.action")
	public @ResponseBody String delete(Integer id) {
		customerService.deleteCustomerById(id);
		return "OK";
	}

	// 添加客户
	@RequestMapping(value = "/add.action")
	public @ResponseBody String add(Customer customer) {
		customerService.addCustomer(customer);
		return "OK";
	}

}
