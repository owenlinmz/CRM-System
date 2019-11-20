package com.owen.crm.mapper;

import java.util.List;

import com.owen.crm.pojo.Room;
import com.owen.crm.pojo.QueryVo;

public interface RoomDao {
	// 总条数
	public Integer roomCountByQueryVo(QueryVo vo);

	// 结果集
	public List<Room> selectRoomListByQueryVo(QueryVo vo);

	// 通过ID查询客房
	public Room selectRoomById(Integer id);

	// 通过ID修改客房
	public void updateRoomById(Room room);

	// 通过ID删除客房
	public void deleteRoomById(Integer id);

	// 添加客房
	public void addRoom(Room room);
}
