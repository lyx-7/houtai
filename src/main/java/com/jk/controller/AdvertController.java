package com.jk.controller;

import com.jk.bean.Advert;
import com.jk.service.AdvertService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("advert")
public class AdvertController {

    @Resource
    private AdvertService advertService;

    //查询
    @RequestMapping("queryAdvertList")
    @ResponseBody
    public SendPage queryAdvertList(ReceivePage receivePage, Advert advert) {
        SendPage list = advertService.queryAdvert(receivePage, advert);
        return list;
    }

    // 新增
    @RequestMapping("addInfo")
    @ResponseBody
    public String addInfo(Advert advert) {

        advertService.addInfo(advert);
        return "";
    }

    //根据id  回显
    @RequestMapping("getById")
    @ResponseBody
    public Advert getById(Integer id) {
        Advert advert = advertService.getById(id);
        return advert;
    }

    //删除
    @ResponseBody
    @RequestMapping("deletes")
    public String deletes(String ids) {
        advertService.deletes(ids);
        return "1";
    }
}
