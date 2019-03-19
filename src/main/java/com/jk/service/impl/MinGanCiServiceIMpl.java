package com.jk.service.impl;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.github.pagehelper.PageHelper;
import com.jk.bean.MInGanCi;
import com.jk.mapper.MinGanCiMapper;
import com.jk.service.MinGanCiService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */
@Service
public class MinGanCiServiceIMpl implements MinGanCiService {
    @Resource
    MinGanCiMapper minGanCiMapper;

    @Override
    public SendPage getMinGanCi(MInGanCi m, ReceivePage rp) {
        List<MInGanCi> count = minGanCiMapper.getMinGanCi(m);
        PageHelper.startPage(rp.getPage(), rp.getRows());
        List<MInGanCi> list = minGanCiMapper.getMinGanCi(m);
        SendPage sp = new SendPage(count.size(), list);
        return sp;
    }

    @Override
    public void addMinGanCi(MInGanCi m) {
        if (m.getId() == null) {
            minGanCiMapper.addMinGanCi(m);
        } else {
            minGanCiMapper.updateMinGanCi2(m);
        }

    }

    @Override
    public void delMinGanCi(String id) {
        minGanCiMapper.delMinGanCi(id);
    }

    @Override
    public MInGanCi updateMinGanCi(int id) {
        return minGanCiMapper.updateMinGanCi(id);
    }
}
