package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.TuiJian;
import com.jk.mapper.TuiJianMapper;
import com.jk.service.TuiJianService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TuiJianServiceImpl implements TuiJianService {
    @Resource
    private TuiJianMapper tuiJianMapper;

    @Override
    public SendPage getTuiJianList(TuiJian tuiJian, ReceivePage receivePage) {
        List<TuiJian> count = tuiJianMapper.getTuiJianList(tuiJian); //计算数据库符合条件的总条数   条数是固定的
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<TuiJian> list = tuiJianMapper.getTuiJianList(tuiJian); //当前页面数据 其大小取决于 每页多少条
        SendPage sendPage = new SendPage(count.size(),list);
        return sendPage;
    }

    @Override
    public void updateToPass(Integer id) {
        tuiJianMapper.updateToPass(id);
    }

    @Override
    public void updateToNoPass(Integer id) {
        tuiJianMapper.updateToNoPass(id);
    }
}
