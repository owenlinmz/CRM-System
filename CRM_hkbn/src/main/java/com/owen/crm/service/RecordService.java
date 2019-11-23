package com.owen.crm.service;

import com.owen.crm.pojo.QueryVo;
import com.owen.crm.pojo.Record;
import com.owen.page.Page;

import java.util.HashMap;

public interface RecordService {

    Page<QueryVo> selectPageByQueryVo(QueryVo vo);

    HashMap<String, String> getRecordDetail(Integer id, Integer roomNumber);
}
