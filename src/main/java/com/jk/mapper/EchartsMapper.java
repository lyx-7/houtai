package com.jk.mapper;

import com.jk.bean.Count;

import java.util.List;

public interface EchartsMapper {

    List<Count> getYueGuanZhu();

    List<Count> getZongGuanZhu();

    List<Count> getRidj();

    List<Count> getZhoudj();

    List<Count> getYuedj();

    List<Count> getVip();

    List<String> getrzy();

    List<Count> getyonghujifen();

    List<Count> getyonghuyue();

    List<Count> getfangwenwenzhangcishu();
}
