package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.LanMu;
import com.jk.bean.LanMuBiaoTi;
import com.jk.bean.TiYu;
import com.jk.mapper.StaffMapper;
import com.jk.mapper.TiYuMapper;
import com.jk.service.TiYuService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TiYuServiceImpl implements TiYuService {

    @Resource
    private TiYuMapper tiYuMapper;

    @Override
    public void addTiYu(LanMuBiaoTi lanMuBiaoTi) {
        LanMuBiaoTi l=tiYuMapper.queryLanMu(lanMuBiaoTi.getBiaotiid());
        tiYuMapper.addTiYu(lanMuBiaoTi);
    }

    @Override
    public List<TiYu> querybiaotiid(String tablename) {
        return tiYuMapper.querybiaotiid(tablename);
    }

    @Override
    public List<LanMu> querylanmuid(String tablename) {
        return tiYuMapper.querylanmuid(tablename);
    }

    @Override
    public SendPage getPageList(LanMuBiaoTi lanMuBiaoTi, ReceivePage receivePage) {
        List<LanMuBiaoTi> count = tiYuMapper.getPageList(lanMuBiaoTi); //计算数据库符合条件的总条数   条数是固定的
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<LanMuBiaoTi> list = tiYuMapper.getPageList(lanMuBiaoTi); //当前页面数据 其大小取决于 每页多少条
        SendPage sendPage = new SendPage(count.size(),list);
        return sendPage;
    }

    @Override
    public LanMuBiaoTi queryList(LanMuBiaoTi lanMuBiaoTi) {
        return tiYuMapper.queryList(lanMuBiaoTi);
    }
}
