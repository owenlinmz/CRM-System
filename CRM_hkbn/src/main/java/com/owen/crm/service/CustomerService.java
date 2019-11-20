package com.owen.crm.service;



import com.owen.page.Page;
import com.owen.crm.pojo.Customer;
import com.owen.crm.pojo.QueryVo;

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

}

