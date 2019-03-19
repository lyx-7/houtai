package com.jk.service;

import com.jk.bean.LanMu;
import com.jk.bean.Title;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

import java.util.List;

public interface LanmuService {
    SendPage getPageList(LanMu lanMu, ReceivePage receivePage);

    List<Title> getTree();


    void addLanmu(LanMu lanMu);

    void Upstatus(String id);

    void Upstatus2(String id);

    LanMu queryLanmu(Integer id);

    void update(LanMu lanMu);
}
