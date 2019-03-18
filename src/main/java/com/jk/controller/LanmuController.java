package com.jk.controller;

import com.jk.bean.LanMu;
import com.jk.bean.Title;
import com.jk.service.LanmuService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("lanmu")
public class LanmuController {
    @Autowired
    private LanmuService lanmuService;

    @RequestMapping("getPageList")
    @ResponseBody
    public SendPage getPageList(LanMu lanMu, ReceivePage receivePage) {
        SendPage sp = lanmuService.getPageList(lanMu, receivePage);
        return sp;
    }

    @ResponseBody
    @RequestMapping("getTree")
    public List<Title> getTree() {
        List<Title> tree = lanmuService.getTree();
        return tree;
    }
    @RequiresPermissions(value = "add")
    @ResponseBody
    @RequestMapping("addLanmu")
    public String addLanmu(LanMu lanMu){
        if(lanMu.getId()==null){
            lanmuService.addLanmu(lanMu);
        }else{
            lanmuService.update(lanMu);
        }

        return "";
    }
    @ResponseBody
    @RequestMapping("Upstatus")
    public String Upstatus(String id,String status){
        if(status.equals("0")){
            lanmuService.Upstatus(id);
        }else{
            lanmuService.Upstatus2(id);
        }
        return "";
    }
    @RequiresPermissions(value = "add")
    @RequestMapping("queryLanmu")
    @ResponseBody
    public LanMu queryLanmu(Integer id) {
        LanMu lanMu =  lanmuService.queryLanmu(id);
        return lanMu;
    }
}
