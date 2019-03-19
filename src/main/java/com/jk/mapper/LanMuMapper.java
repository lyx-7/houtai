package com.jk.mapper;

import com.jk.bean.LanMu;
import com.jk.bean.Title;

import java.util.List;

public interface LanMuMapper {
    List<LanMu> getPageList(LanMu lanMu);

    List<Title> getTree();

    void addLanmu(LanMu lanMu);

    void Upstatus(String id);

    void Upstatus2(String id);

    LanMu queryLanmu(Integer id);

    void update(LanMu lanMu);
}
