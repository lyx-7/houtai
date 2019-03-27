package com.jk.mapper;

import com.jk.bean.Vip;

import java.util.List;

public interface VipMapper {
    void addVip(Vip vip);

    List<Vip> getPageList(Vip vip);

    void delVip(String id);

    void updateVip(Vip vip);

    Vip queryVip(Integer id);

    void changeState(Integer id);
}
