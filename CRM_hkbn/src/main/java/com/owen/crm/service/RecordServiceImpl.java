package com.owen.crm.service;
import	java.util.HashMap;

import com.owen.crm.mapper.RecordDao;
import com.owen.crm.pojo.QueryVo;
import com.owen.crm.pojo.Record;
import com.owen.crm.pojo.Room;
import com.owen.page.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

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

    public HashMap<String, String> getRecordDetail(Integer id, Integer roomNumber) {
        List<QueryVo> recordList = recordDao.getRecordByRoomNumber(roomNumber);
        Date realInTime = null;
        Date realOutTime = null;
        for (QueryVo vo : recordList) {
            if (vo.getId().equals(id)){
                realInTime = vo.getInTime();
                realOutTime = vo.getOutTime();
                break;
            }
        }
        HashMap<String, String> result = new HashMap<String, String> ();
        ArrayList<QueryVo> finalList = new ArrayList<QueryVo>();
        if (realInTime == null){
            return result;
        }
        Date finalInTime = null;
        Date finalOutTime = null;
        for (QueryVo vo : recordList) {
            if (vo.getOutTime() != null && vo.getOutTime().before(realInTime)){
                continue;
            } else if (realOutTime != null && vo.getInTime().after(realOutTime)){
                continue;
            }
            if (vo.getInTime() != null){
                finalInTime = vo.getInTime();
            }
            if (vo.getOutTime() != null){
                finalOutTime = vo.getOutTime();
            }
            finalList.add(vo);
        }
        if (finalList.isEmpty() || finalInTime == null){
            return result;
        }
        ArrayList<String > nameList = new ArrayList<String>();
        for(QueryVo vo: finalList){
            if(finalInTime.after(vo.getInTime())){
                finalInTime = vo.getInTime();
            }

            // 如果房间内仍有客户未离开，则离开时间为空
            if (vo.getOutTime() == null){
                finalOutTime = null;
            }
            if(finalOutTime != null &&  vo.getOutTime() != null &&vo.getOutTime().after(finalOutTime)){
                finalOutTime = vo.getOutTime();
            }

            nameList.add(vo.getName());
        }
        result.put("nameList", StringUtils.join(nameList, ", "));
        result.put("inTime", CustomerServiceImpl.getTimeString(realInTime));
        result.put("roomNumber", finalList.get(0).getRoomNumber());
        result.put("type", finalList.get(0).getType());
        if (finalOutTime != null){
            result.put("outTime", CustomerServiceImpl.getTimeString(realOutTime));
        }else {
            result.put("outTime" ,"空");
        }
        return result;
    }
}
