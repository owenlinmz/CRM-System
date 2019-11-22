package com.owen.crm.service;

import com.owen.page.Page;
import com.owen.crm.pojo.Customer;
import com.owen.crm.pojo.QueryVo;

import java.util.HashMap;

public interface CustomerService {
	
	// 通过四个条件 查询分页对象
    Page<Customer> selectPageByQueryVo(QueryVo vo);
	
	//通过ID查询客户
    Customer selectCustomerById(Integer id);
	
	//修改客户通过ID
    void updateCustomerById(Customer customer);
	
	//通过ID 删除客户
    void deleteCustomerById(Integer id);
	
	//添加客户
    void addCustomer(Customer customer);

    // 获取入住办理
    QueryVo getLiveIn(Integer id);

    // 更新办理信息
    boolean updateLiveIn(QueryVo vo);

    // 获取客户详情
    QueryVo getDetail(QueryVo vo);

    // 获取客户退房数据
    HashMap getOutInfo(Integer id);
}

