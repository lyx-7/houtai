package com.jk.controller;

import com.jk.bean.TuiJian;
import com.jk.service.TuiJianService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("tuiJian")
public class TuiJianController {

    @Resource
    private TuiJianService tuiJianService;

    @RequiresPermissions(value = "query")
    @RequestMapping("getTuiJianList")
    @ResponseBody
    public SendPage getTuiJianList(TuiJian tuiJian, ReceivePage receivePage) {
        SendPage  sp = tuiJianService.getTuiJianList(tuiJian, receivePage);
        return sp;
    }

//通过
    @RequiresPermissions(value = "update")
    @RequestMapping("updateToPass")
    @ResponseBody
    public String updateToPass(Integer id){
        tuiJianService.updateToPass(id);
        return "";
    }
//拒绝
    @RequiresPermissions(value = "update")
    @RequestMapping("updateToNoPass")
    @ResponseBody
    public String updateToNoPass(Integer id){
        tuiJianService.updateToNoPass(id);
        return "";
    }

}
