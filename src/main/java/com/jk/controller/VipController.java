package com.jk.controller;

import com.jk.bean.Vip;
import com.jk.utils.FileUtil;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("vip")
public class VipController {
    @Resource
    private com.jk.service.VipService VipService;

    /**
     * 新增会员
     * @param vip
     * @return
     */
    @ResponseBody
    @RequestMapping("addVip")
    public String addStaff(Vip vip){
        if(vip.getId()==null){
            VipService.addVip(vip);
        }else if(vip.getId()!=null){
            VipService.updateVip(vip);
        }
        return "";
    }

    /**
     * 上传图片
     * @param file
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("upload")
    public String upload(MultipartFile file, HttpServletRequest request){

        return FileUtil.upload(file,request);
    }

    /**
     * 分页查询
     * @param vip
     * @param receivePage
     * @return
     */
    @RequestMapping("getPageList")
    @ResponseBody
    public SendPage getPageList(Vip vip, ReceivePage receivePage) {
        SendPage  sp = VipService.getPageList(vip, receivePage);
        return sp;
    }
    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("delVip")
    public String delVip(String id){

        return VipService.delVip(id);
    }

    /**
     * 回显
     * @param id
     * @return
     */
    @RequestMapping("queryVip")
    @ResponseBody
    public Vip queryVip(Integer id) {
        Vip imgList= VipService.queryVip(id);
        return imgList;
    }
}
