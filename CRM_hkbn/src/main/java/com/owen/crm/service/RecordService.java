package com.owen.crm.service;

import com.owen.crm.pojo.QueryVo;
import com.owen.crm.pojo.Record;
import com.owen.page.Page;

public interface RecordService {

    Page<QueryVo> selectPageByQueryVo(QueryVo vo);
}
