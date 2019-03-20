package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.LanMuBiaoTi;
import com.jk.bean.TuiJian;
import com.jk.bean.Yule;
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



        TuiJian tui = tuiJianMapper.queryTuiJianById(id);//根据id查询当前对象

        Yule yule = new Yule();
        yule.setTitle(tui.getTname());//文章标题
        yule.setTlink(tui.getTlink());//文章链接
        yule.setImgurl(tui.getBlogaddr());//图片链接
        yule.setVipid(tui.getUserid());//推荐人id
        yule.setVipname(tui.getTauthor());//推荐人
        yule.setStatus(tui.getState());//状态
        yule.setTime(tui.getTuitime());//推荐时间
        yule.setTablename("t_yule");//表名

        tuiJianMapper.addToYule(yule);//添加到  娱乐表

        LanMuBiaoTi lb = new LanMuBiaoTi();
        lb.setLanmuid(tui.getLanmu()); //栏目
        lb.setBiaotiid(yule.getId());//标题
        lb.setTablename(yule.getTablename());//表名
        tuiJianMapper.addToLanmuBiaoti(lb); //添加到 栏目标题 表


        tuiJianMapper.updateToNoPass(id); //删除掉这条信息
    }

    @Override
    public void updateToNoPass(Integer id) {
        tuiJianMapper.updateToNoPass(id);
    }
}
