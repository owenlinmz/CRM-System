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

import java.util.HashMap;

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

	// 获取入住办理信息
    @RequestMapping(value = "/getLiveIn.action" )
    public @ResponseBody QueryVo getLiveIn(Integer id) {
        return customerService.getLiveIn(id);
    }

    // 办理入住
	@RequestMapping(value = "/updateLiveIn.action")
	public @ResponseBody boolean updateLiveIn(QueryVo vo){
		return customerService.updateLiveIn(vo);
	}

	// 获取客户详情
    @RequestMapping(value = "/getDetail.action")
    public @ResponseBody QueryVo getDetail(QueryVo vo){
		QueryVo result = customerService.getDetail(vo);
		result.setRecordList(result.recordList);
		return result;
    }

    // 获取客户退房信息
	@RequestMapping(value = "/getOutInfo" )
	public @ResponseBody HashMap getOutInfo(Integer id){
		return  customerService.getOutInfo(id);
	}

}
