package com.owen.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owen.crm.mapper.RoomDao;
import com.owen.crm.pojo.Room;
import com.owen.crm.pojo.QueryVo;
import com.owen.page.Page;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomDao roomDao;

    // 通过Name 查询分页对象
    public Page<Room> selectPageByQueryVo(QueryVo vo) {
        Page<Room> page = new Page<Room>();
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
        if (vo.getStatus() != null && !"".equals(vo.getStatus().trim())) {
            vo.setStatus(vo.getStatus().trim());
        }
        // 总条数
        page.setTotal(roomDao.roomCountByQueryVo(vo));
        page.setRows(roomDao.selectRoomListByQueryVo(vo));
        return page;

    }

    // 通过ID查询客户
    public Room selectRoomById(Integer id) {
        return roomDao.selectRoomById(id);
    }

    // 修改客户通过ID
    public void updateRoomById(Room room) {
        roomDao.updateRoomById(room);
    }

    // 通过ID 删除客户
    public void deleteRoomById(Integer id) {
        roomDao.deleteRoomById(id);
    }

    // 添加客户
    public void addRoom(Room room) {
        roomDao.addRoom(room);
    }

    // 变更状态
    public boolean changeStatus(Integer id, String status) {
        if (status.equals("维修")) {
			if (roomDao.getRoomLive(id) > 0){
				return false;
			}
        }
        roomDao.changeStatus(id, status);
        return true;
    }
}
