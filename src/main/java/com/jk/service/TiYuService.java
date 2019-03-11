package com.jk.service;

import com.jk.bean.LanMu;
import com.jk.bean.LanMuBiaoTi;
import com.jk.bean.TiYu;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

import java.util.List;

public interface TiYuService {

    void addTiYu(LanMuBiaoTi lanMuBiaoTi);

    List<TiYu> querybiaotiid(String tablename);

    List<LanMu> querylanmuid(String tablename);

    SendPage getPageList(LanMuBiaoTi lanMuBiaoTi, ReceivePage receivePage);

    LanMuBiaoTi queryList(LanMuBiaoTi lanMuBiaoTi);
}
