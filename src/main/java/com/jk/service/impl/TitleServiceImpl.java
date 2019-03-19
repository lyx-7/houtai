package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.TitleInfo;
import com.jk.mapper.TitleMapper;
import com.jk.service.TitleService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TitleServiceImpl implements TitleService {

    @Resource
    TitleMapper titleMapper;

    @Override
    public SendPage queryTitleInfo(ReceivePage receivePage, TitleInfo titleInfo) {

        List<TitleInfo> count = titleMapper.queryTitleInfo(titleInfo);
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<TitleInfo> list = titleMapper.queryTitleInfo(titleInfo);
        SendPage sp= new SendPage(count.size(),list);
        return sp;

    }

    @Override
    public void addInfo(TitleInfo titleInfo) {
        if(titleInfo.getId() == null){
            titleMapper.addInfo(titleInfo);
        }else{
            titleMapper.updateInfo(titleInfo);
        }
    }

    @Override
    public TitleInfo getById(Integer id) {
        return titleMapper.getById(id);
    }

    @Override
    public void deletes(String ids) {
        titleMapper.deletes(ids);
    }


}
