package com.jk.controller;

import com.jk.bean.vipStart;
import com.jk.service.VipStartService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController

public class VipStartController {
    @Resource
    VipStartService vipStartService;
    @RequestMapping("getVipStart")
    public SendPage getVipStart(ReceivePage rp, vipStart v){
        return vipStartService.getVipStart(rp,v);
    }
    @RequestMapping("getVipStartById")
    public vipStart getVipStartById(Integer id){
        return vipStartService.getVipStartById(id);
    }
    @RequestMapping("addVipStart")
    public void addVipStart(vipStart v){
       vipStartService.addVipStart(v);
    }
}
