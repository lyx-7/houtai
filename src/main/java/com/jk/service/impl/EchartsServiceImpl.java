package com.jk.service.impl;

import com.jk.bean.Count;
import com.jk.mapper.EchartsMapper;
import com.jk.service.EchartsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EchartsServiceImpl implements EchartsService {

    @Resource
    private EchartsMapper echartsMapper;

    @Override
    public List<Count> getYueGuanZhu() {
        List<Count> list = echartsMapper.getYueGuanZhu();
        return list;
    }

    @Override
    public List<Count> getZongGuanZhu() {
        List<Count> list = echartsMapper.getZongGuanZhu();
        return list;
    }

    @Override
    public List<Count> getRidj() {
        List<Count> list = echartsMapper.getRidj();
        return list;
    }

    @Override
    public List<Count> getZhoudj() {
        List<Count> list = echartsMapper.getZhoudj();
        return list;
    }

    @Override
    public List<Count> getYuedj() {
        List<Count> list = echartsMapper.getYuedj();
        return list;
    }

    @Override
    public List<Count> getVip() {
        return echartsMapper.getVip();
    }

    @Override
    public List<String> getrzy() {
        return echartsMapper.getrzy();
    }

    @Override
    public List<Count> getyonghujifen() {
        return echartsMapper.getyonghujifen();
    }

    @Override
    public List<Count> getyonghuyue() {
        return echartsMapper.getyonghuyue();
    }

    @Override
    public List<Count> getfangwenwenzhangcishu() {
        return echartsMapper.getfangwenwenzhangcishu();
    }
}
