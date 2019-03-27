package com.jk.service;

import com.jk.bean.vipStart;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

public interface VipStartService {
    SendPage getVipStart(ReceivePage rp, vipStart v);

    vipStart getVipStartById(Integer id);

    void addVipStart(vipStart v);

    String getUser(Integer userid);
}
