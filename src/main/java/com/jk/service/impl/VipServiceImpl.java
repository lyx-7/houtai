package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.Vip;
import com.jk.mapper.VipMapper;
import com.jk.service.VipService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VipServiceImpl implements VipService {
    @Resource
    private VipMapper VipMapper;
    @Override
    public void addVip(Vip vip) {
        VipMapper.addVip(vip);
    }

    @Override
    public SendPage getPageList(Vip vip, ReceivePage receivePage) {
        List<Vip> count = VipMapper.getPageList(vip); //计算数据库符合条件的总条数   条数是固定的
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<Vip> list = VipMapper.getPageList(vip); //当前页面数据 其大小取决于 每页多少条
        SendPage sendPage = new SendPage(count.size(),list);
        return sendPage;
    }

    @Override
    public String delVip(String id) {
        VipMapper.delVip(id);
        return null;
    }


    @Override
    public void updateVip(Vip vip) {
        VipMapper.updateVip(vip);
    }

    @Override
    public Vip queryVip(Integer id) {

        return VipMapper.queryVip(id);
    }

    @Override
    public void changeState(Integer id) {
        VipMapper.changeState(id);
    }
}
