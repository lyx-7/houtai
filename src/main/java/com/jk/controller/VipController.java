package com.jk.controller;

import com.jk.bean.Vip;
import com.jk.utils.OssUpFileUtil;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

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
    @RequiresPermissions(value = "add")
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
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("upload")
    public String upload(MultipartFile file){
        Map<String, Object> stringObjectMap = OssUpFileUtil.uploadFile(file);
        String count = "";
        for(String key : stringObjectMap.keySet()){
            Object o = stringObjectMap.get(key);
            System.out.println("key: " + key + " value: " + o);
            if(key=="url"){
                count+=o;
            }
        }
        return count;
    }

    /**
     * 分页查询
     * @param vip
     * @param receivePage
     * @return
     */
    @RequiresPermissions(value = "query")
    @RequestMapping("getPageList")
    @ResponseBody
    public SendPage getPageList(Vip vip, ReceivePage receivePage) {
        SendPage  sp = VipService.getPageList(vip, receivePage);
        return sp;
    }
    /**
     * 删除
     */
    @RequiresPermissions(value = "del")
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
    @RequiresPermissions(value = "update")
    @RequestMapping("queryVip")
    @ResponseBody
    public Vip queryVip(Integer id) {
        Vip imgList= VipService.queryVip(id);
        return imgList;
    }

    /**
     * 解除账号异常
     */
    @RequestMapping("changeState")
    @ResponseBody
    public String changeState(Integer id){
        VipService.changeState(id);
        return "";
    }

}
