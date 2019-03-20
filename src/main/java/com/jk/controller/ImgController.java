package com.jk.controller;

import com.jk.bean.ImgInfo;
import com.jk.service.ImgService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("lunbo")
public class ImgController {

    @Resource
    private ImgService imgService;
    //查询
    @RequestMapping("queryImgInfo")
    @ResponseBody
    public SendPage queryImgInfo(ReceivePage receivePage, ImgInfo imgInfo) {
        SendPage imgList = imgService.queryImgInfo(receivePage, imgInfo);
        return imgList;
    }
    // 新增
    @RequestMapping("addImgInfo")
    @ResponseBody
    public String addImgInfo(ImgInfo imgInfo) {
        imgService.addImgInfo(imgInfo);
        return "";
    }

    //根据id  回显
    @RequestMapping("getImgById")
    @ResponseBody
    public ImgInfo getImgById(Integer id) {
        ImgInfo img = imgService.getImgById(id);
        return img;
    }

    //删除
    @ResponseBody
    @RequestMapping("deleteImg")
    public String deleteImg(String ids) {
        imgService.deleteImg(ids);
        return "1";
    }
}
