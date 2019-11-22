package com.owen.crm.controller;


import com.owen.crm.pojo.QueryVo;
import com.owen.crm.pojo.Record;
import com.owen.crm.service.RecordService;
import com.owen.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
