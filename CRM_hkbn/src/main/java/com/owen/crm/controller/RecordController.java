package com.owen.crm.controller;
import java.util.ArrayList;
import	java.util.HashMap;


import com.owen.crm.pojo.QueryVo;
import com.owen.crm.pojo.Record;
import com.owen.crm.service.RecordService;
import com.owen.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    // 获取入住记录列表
    @RequestMapping(value = "/list")
    public String list(QueryVo vo, Model model) {
        Page<QueryVo> page = recordService.selectPageByQueryVo(vo);
        model.addAttribute("page", page);
        return "record";
    }

    // 获取入住记录详情
    @RequestMapping(value = "/getDetail.action")
    public @ResponseBody HashMap detail(Integer id, Integer roomNumber) {
        return recordService.getRecordDetail(id, roomNumber);
    }

}
