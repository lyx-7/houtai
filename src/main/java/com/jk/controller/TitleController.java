package com.jk.controller;


import com.jk.bean.TitleInfo;
import com.jk.service.TitleService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("newsTitle")
public class TitleController {

    //导航栏


    @Resource
    private TitleService titleService;

    //查询
    @RequestMapping("queryTitleInfo")
    @ResponseBody
    public SendPage queryTitleInfo(ReceivePage receivePage, TitleInfo titleInfo) {
        SendPage titleList = titleService.queryTitleInfo(receivePage, titleInfo);
        return titleList;
    }

    // 新增
    @RequestMapping("addInfo")
    @ResponseBody
    public String addInfo(TitleInfo titleInfo) {

        titleService.addInfo(titleInfo);
        return "";
    }

    //根据id  回显
    @RequestMapping("getById")
    @ResponseBody
    public TitleInfo getById(Integer id) {
        TitleInfo title = titleService.getById(id);
        return title;
    }

    //删除
    @ResponseBody
    @RequestMapping("deletes")
    public String deletes(String ids) {
        titleService.deletes(ids);
        return "1";
    }




}
