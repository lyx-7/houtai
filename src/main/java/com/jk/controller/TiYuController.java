package com.jk.controller;

import com.jk.bean.LanMu;
import com.jk.bean.LanMuBiaoTi;
import com.jk.bean.Staff;
import com.jk.bean.TiYu;
import com.jk.service.TiYuService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("tiyu")
public class TiYuController {

    @Autowired
    private TiYuService tiYuService;

    @ResponseBody
    @RequestMapping("addTiYu")
    public String addTiYu(LanMuBiaoTi lanMuBiaoTi){
        LanMuBiaoTi lanMuBiaoTi1 = tiYuService.queryList(lanMuBiaoTi);
        if(lanMuBiaoTi1 != null){
            return "0";
        }else {
            tiYuService.addTiYu(lanMuBiaoTi);
            return "1";
        }
    }


    @RequestMapping("querybiaotiid")
    @ResponseBody
    public List<TiYu> querybiaotiid(String tablename){
        return tiYuService.querybiaotiid(tablename);
    }

    @RequestMapping("querylanmuid")
    @ResponseBody
    public List<LanMu> querylanmuid(String tablename){
        return tiYuService.querylanmuid(tablename);
    }

    @RequestMapping("getPageList")
    @ResponseBody
    public SendPage getPageList(LanMuBiaoTi lanMuBiaoTi, ReceivePage receivePage) {
        SendPage  sp = tiYuService.getPageList(lanMuBiaoTi, receivePage);
        return sp;
    }

}
