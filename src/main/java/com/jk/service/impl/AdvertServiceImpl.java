package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.Advert;
import com.jk.mapper.AdvertMapper;
import com.jk.service.AdvertService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdvertServiceImpl implements AdvertService {

   @Resource
    private AdvertMapper advertMapper;


    @Override
    public SendPage queryAdvert(ReceivePage receivePage, Advert advert) {
        List<Advert> count = advertMapper.queryAdvert(advert);
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<Advert> list = advertMapper.queryAdvert(advert);
        SendPage sp= new SendPage(count.size(),list);
        return sp;
    }

    @Override
    public void addInfo(Advert advert) {
        if(advert.getId()==null){
            advertMapper.addInfo(advert);
        }else{
            advertMapper.updateInfo(advert);
        }

    }

    @Override
    public Advert getById(Integer id) {
        return advertMapper.getById(id);
    }

    @Override
    public void deletes(String ids) {
        advertMapper.deletes(ids);
    }

    @Override
    public void upOrDown(Integer id, Integer flag) {
        advertMapper.upOrDown(id,flag);
    }
}
