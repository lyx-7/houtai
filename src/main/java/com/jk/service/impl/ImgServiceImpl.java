package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.ImgInfo;
import com.jk.mapper.ImgMapper;
import com.jk.service.ImgService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ImgServiceImpl implements ImgService {

    @Resource
    private ImgMapper imgMapper;

    @Override
    public SendPage queryImgInfo(ReceivePage receivePage, ImgInfo imgInfo) {
        List<ImgInfo> count = imgMapper.queryImgInfo(imgInfo);
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<ImgInfo> list = imgMapper.queryImgInfo(imgInfo);
        SendPage sp= new SendPage(count.size(),list);
        return sp;
    }

    @Override
    public void addImgInfo(ImgInfo imgInfo) {
        if(imgInfo.getId() == null){
            imgMapper.addImgInfo(imgInfo);
        }else{
            imgMapper.updateImgInfo(imgInfo);
        }
    }

    @Override
    public ImgInfo getImgById(Integer id) {
        return imgMapper.getImgById(id);
    }

    @Override
    public void deleteImg(String ids) {
        imgMapper.deleteImg(ids);
    }
}
