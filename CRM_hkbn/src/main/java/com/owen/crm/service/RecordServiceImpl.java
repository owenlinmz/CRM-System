package com.owen.crm.service;

import com.owen.crm.mapper.RecordDao;
import com.owen.crm.pojo.QueryVo;
import com.owen.crm.pojo.Record;
import com.owen.crm.pojo.Room;
import com.owen.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordService{

    @Autowired
    private RecordDao recordDao;

    public Page<QueryVo> selectPageByQueryVo(QueryVo vo) {
        Page<QueryVo> page = new Page<QueryVo>();
        // 每页数
        page.setSize(10);
        vo.setSize(10);
        // 判断当前页
        if (vo.getPage() != null) {
            page.setPage(vo.getPage());
            vo.setStartRow((vo.getPage() - 1) * vo.getSize());
        }
        // 不为空且不为空串
        if (vo.getRoomNumber() != null && !"".equals(vo.getRoomNumber().trim())) {
            vo.setRoomNumber(vo.getRoomNumber().trim());
        }
        if (vo.getType() != null && !"".equals(vo.getType().trim())) {
            vo.setType(vo.getType().trim());
        }
        if (vo.getName() != null && !"".equals(vo.getName().trim())) {
            vo.setName(vo.getName().trim());
        }
        // 总条数
        page.setTotal(recordDao.recordCountByQueryVo(vo));
        page.setRows(recordDao.selectRecordListByQueryVo(vo));
        return page;
    }
}
