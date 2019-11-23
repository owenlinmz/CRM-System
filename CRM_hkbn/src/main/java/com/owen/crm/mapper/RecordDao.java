package com.owen.crm.mapper;

import com.owen.crm.pojo.QueryVo;
import com.owen.crm.pojo.Record;

import java.util.ArrayList;
import java.util.List;


public interface RecordDao {
    // 通过客户ID获取入住记录
    public List<Record> getRecordByCustomer(QueryVo vo);

    // 通过客户ID获取入住记录总数
    public int countRecordByCustomer(Integer id);

    public Integer recordCountByQueryVo(QueryVo vo);

    List<QueryVo> selectRecordListByQueryVo(QueryVo vo);

    List<QueryVo> getRecordByRoomNumber(Integer roomNumber);

}
