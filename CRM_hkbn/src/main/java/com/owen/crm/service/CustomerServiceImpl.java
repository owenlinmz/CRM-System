package com.owen.crm.service;

import com.owen.crm.mapper.RoomDao;
import com.owen.crm.pojo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owen.page.Page;
import com.owen.crm.mapper.CustomerDao;
import com.owen.crm.pojo.Customer;
import com.owen.crm.pojo.QueryVo;

/**
 * 客户管理
 *
 * @author linn2
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private RoomDao roomDao;

    // 通过Name 查询分页对象
    public Page<Customer> selectPageByQueryVo(QueryVo vo) {
        Page<Customer> page = new Page<Customer>();
        // 每页数
        page.setSize(5);
        vo.setSize(5);
        // 判断当前页
        if (vo.getPage() != null) {
            page.setPage(vo.getPage());
            vo.setStartRow((vo.getPage() - 1) * vo.getSize());
        }
        // 不为空且不为空串
        if (vo.getName() != null && !"".equals(vo.getName().trim())) {
            vo.setName(vo.getName().trim());
        }
        if (vo.getTelephone() != null && !"".equals(vo.getTelephone().trim())) {
            vo.setTelephone(vo.getTelephone().trim());
        }

        // 总条数
        page.setTotal(customerDao.customerCountByQueryVo(vo));
        //结果集
        page.setRows(customerDao.selectCustomerListByQueryVo(vo));
        return page;

    }

    // 通过ID查询客户
    public Customer selectCustomerById(Integer id) {
        return customerDao.selectCustomerById(id);
    }

    // 修改客户通过ID
    public void updateCustomerById(Customer customer) {
        customerDao.updateCustomerById(customer);
    }

    // 通过ID 删除客户
    public void deleteCustomerById(Integer id) {
        customerDao.deleteCustomerById(id);
    }

    // 添加客户
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    // 获取入住办理
    public QueryVo getLiveIn(Integer id) {
        QueryVo result = customerDao.getLiveIn(id);
        if (result == null){
            QueryVo vo = new QueryVo();
            vo.setId(id);
            return vo;
        }
        return result;
    }

    // 入住办理
    public boolean updateLiveIn(QueryVo vo) {
    	Room room = roomDao.selectRoomByNum(vo.getRoomNumber());
    	if (!room.getStatus().equals("正常")){
    	    return false;
        }
    	vo.setRoomId(room.getId());
    	vo.setPrice(room.getPrice());
        if (vo.getRecordId() != null) {
			customerDao.updateLiveIn(vo);
        }else {
        	customerDao.insertLiveIn(vo);
		}
        Customer customer = new Customer();
        customer.setRoomId(room.getId());
        customer.setId(vo.getId());
		updateCustomerById(customer);
		return true;
    }
}
