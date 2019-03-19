package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.LanMu;
import com.jk.bean.Title;
import com.jk.mapper.LanMuMapper;
import com.jk.service.LanmuService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LanmuServiceImpl implements LanmuService {
    @Resource
    private LanMuMapper lanMuMapper;
    @Override
    public SendPage getPageList(LanMu lanMu, ReceivePage receivePage) {
        List<LanMu> count = lanMuMapper.getPageList(lanMu); //计算数据库符合条件的总条数   条数是固定的
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<LanMu> list = lanMuMapper.getPageList(lanMu); //当前页面数据 其大小取决于 每页多少条
        SendPage sendPage = new SendPage(count.size(),list);
        return sendPage;
    }
    @Override
    public List<Title> getTree() {
        List<Title> tree = lanMuMapper.getTree();
        return tree;
    }

    @Override
    public void addLanmu(LanMu lanMu) {
        lanMuMapper.addLanmu(lanMu);
    }

    @Override
    public void Upstatus(String id) {
        lanMuMapper.Upstatus(id);
    }

    @Override
    public void Upstatus2(String id) {
        lanMuMapper.Upstatus2(id);
    }

    @Override
    public LanMu queryLanmu(Integer id) {

        return lanMuMapper.queryLanmu(id);
    }

    @Override
    public void update(LanMu lanMu) {
        lanMuMapper.update(lanMu);
    }
}
