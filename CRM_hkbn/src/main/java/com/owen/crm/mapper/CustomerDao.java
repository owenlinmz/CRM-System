package com.owen.crm.mapper;

import java.util.List;

import com.owen.crm.pojo.Customer;
import com.owen.crm.pojo.QueryVo;

public interface CustomerDao {

	
	//总条数
	public Integer customerCountByQueryVo(QueryVo vo);
	//结果集
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
	
	//通过ID查询客户
	public Customer selectCustomerById(Integer id);
	//修改客户通过ID
	public void updateCustomerById(Customer customer);
	
	//通过ID 删除客户
	public void deleteCustomerById(Integer id);
	
	//添加用户
	public void addCustomer(Customer customer);

	// 获取入住办理
	public QueryVo getLiveIn(Integer id);

	// 更新入住信息
	public void updateLiveIn(QueryVo vo);

	// 插入入住信息
	public void insertLiveIn(QueryVo vo);

}

