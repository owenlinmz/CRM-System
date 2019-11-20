package com.owen.crm.service;

import com.owen.crm.pojo.Room;
import com.owen.crm.pojo.QueryVo;
import com.owen.page.Page;

public interface RoomService {

	Page<Room> selectPageByQueryVo(QueryVo vo);
	
	//通过ID查询客户
    Room selectRoomById(Integer id);
	
	//修改客户通过ID
    void updateRoomById(Room bill);
	
	//通过ID 删除客户
    void deleteRoomById(Integer id);
	
	//添加客户
    void addRoom(Room bill);

}
