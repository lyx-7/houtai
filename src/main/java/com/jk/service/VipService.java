package com.jk.service;

import com.jk.bean.Vip;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

public interface VipService {

    void addVip(Vip vip);

    void updateVip(Vip vip);

    SendPage getPageList(Vip vip, ReceivePage receivePage);

    String delVip(String id);

    Vip queryVip(Integer id);

    void changeState(Integer id);
}
