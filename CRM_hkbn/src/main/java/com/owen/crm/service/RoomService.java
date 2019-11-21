package com.owen.crm.service;

import com.owen.crm.pojo.Room;
import com.owen.crm.pojo.QueryVo;
import com.owen.page.Page;

public interface RoomService {

	Page<Room> selectPageByQueryVo(QueryVo vo);
	
	//通过ID查询客房
    Room selectRoomById(Integer id);
	
	//修改客房通过ID
    void updateRoomById(Room room);
	
	//通过ID 删除客房
    void deleteRoomById(Integer id);
	
	//添加客房
    void addRoom(Room room);

    // 变更状态
	boolean changeStatus(Integer id, String status);
}
