package com.owen.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.owen.crm.pojo.Room;
import com.owen.crm.pojo.QueryVo;
import com.owen.crm.service.RoomService;
import com.owen.page.Page;

/**
 * 
 *酒店管理
 * @author linn2
 *
 */
@Controller
@RequestMapping(value = "/room")
public class RoomController {

	@Autowired
	private RoomService roomService;

	
	//根据用户名称和手机 条件查询相关客房
	@RequestMapping(value = "/list")
	public String list(QueryVo vo, Model model) {
		Page<Room> page = roomService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
//		model.addAttribute("name", vo.getName());
//		model.addAttribute("telephone", vo.getTelephone());
		return "room";

	}

	// 修改客房信息
	@RequestMapping(value = "/edit.action")
	public @ResponseBody Room edit(Integer id) {
		return roomService.selectRoomById(id);
	}

	// 提交修改
	@RequestMapping(value = "/update.action")
	public @ResponseBody String update(Room room) {
		roomService.updateRoomById(room);
		return "OK";
	}

	// 删除客房
	@RequestMapping(value = "/delete.action")
	public @ResponseBody String delete(Integer id) {
		roomService.deleteRoomById(id);
		return "OK";
	}

	// 添加客房
	@RequestMapping(value = "/add.action")
	public @ResponseBody String add(Room room) {
		roomService.addRoom(room);
		return "OK";
	}
}
