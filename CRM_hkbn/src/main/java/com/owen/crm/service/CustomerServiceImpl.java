package com.owen.crm.service;

import java.text.SimpleDateFormat;
import java.util.*;

import com.owen.crm.mapper.RecordDao;
import com.owen.crm.mapper.RoomDao;
import com.owen.crm.pojo.Record;
import com.owen.crm.pojo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owen.page.Page;
import com.owen.crm.mapper.CustomerDao;
import com.owen.crm.pojo.Customer;
import com.owen.crm.pojo.QueryVo;

import java.util.Dictionary;

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

    @Autowired
    private RecordDao recordDao;

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
        if (result == null) {
            QueryVo vo = new QueryVo();
            vo.setId(id);
            return vo;
        }
        return result;
    }

    // 入住办理
    public boolean updateLiveIn(QueryVo vo) {
        Room room = roomDao.selectRoomByNum(vo.getRoomNumber());
        if (!room.getStatus().equals("正常")) {
            return false;
        }
        Customer customer = new Customer();
        customer.setRoomId(room.getId());
        customer.setId(vo.getId());

        vo.setRoomId(room.getId());
        vo.setPrice(room.getPrice());
        if (vo.getRecordId() != null) {
            customerDao.updateLiveIn(vo);
        } else {
            customerDao.insertLiveIn(vo);
        }
        updateCustomerById(customer);
        return true;
    }

    // 获取客户详情
    public QueryVo getDetail(QueryVo vo) {
        Page<Record> page = new Page<Record>();
        page.setSize(5);
        vo.setSize(5);
        // 判断当前页
        if (vo.getPage() != null) {
            page.setPage(vo.getPage());
            vo.setStartRow((vo.getPage() - 1) * vo.getSize());
        }
        page.setTotal(recordDao.countRecordByCustomer(vo.getId()));
        page.setRows(recordDao.getRecordByCustomer(vo));
        Customer customer = customerDao.selectCustomerById(vo.getId());
        vo.setName(customer.getName());
        vo.setIdentity(customer.getIdentity());
        vo.setTelephone(customer.getTelephone());
        vo.setRecordList(page);
        return vo;
    }

    // 获取客户退房数据
    public HashMap getOutInfo(Integer id) {
        HashMap<String, String> result = new HashMap<String, String>();
        QueryVo liveResult = getLiveIn(id);
        if (liveResult.getRoomId() == null) {
            result.put("message", "退房失败：该用户没有入住，无法办理退房！");
            result.put("result", "false");
            return result;
        }
        boolean needUpdateOutTime = false;
        Date now = new Date();
        float days = 0;
        if (liveResult.getOutTime() != null) {
            days = (liveResult.getOutTime().getTime() - liveResult.getInTime().getTime()) / (float) (1000 * 60 * 60 * 24);
        } else {
            days = (now.getTime()- liveResult.getInTime().getTime()) / (float) (1000 * 60 * 60 * 24);
            needUpdateOutTime = true;
        }
        if (days <= 0) {
            result.put("message", "退房失败：出错！入住时间大于或等于离开时间！");
            result.put("result", "false");
            return result;
        }
        float money = 0;
        if (days > Math.floor(days)) {
            money = ++days * liveResult.getPrice();
        } else {
            money = days * liveResult.getPrice();
        }
        result.put("message", "退房成功：总消费：" + money + "元！");
        result.put("result", "true");
        // 若未填写离开时间则自动补充
        if (needUpdateOutTime) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            liveResult.setOutTime(simpleDateFormat.format(now));
            customerDao.updateLiveIn(liveResult);
        }

        // 退房客户房间ID设为0  无法使用updateCustomerById把roomId设为0 SQL报错
        customerDao.getOutRoom(id);
        return result;
    }
}
