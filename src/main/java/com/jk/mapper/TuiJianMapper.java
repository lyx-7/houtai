package com.jk.mapper;

import com.jk.bean.LanMuBiaoTi;
import com.jk.bean.TuiJian;
import com.jk.bean.Yule;

import java.util.List;

public interface TuiJianMapper {
    List<TuiJian> getTuiJianList(TuiJian tuiJian);


    void updateToNoPass(Integer id);


    TuiJian queryTuiJianById(Integer id);

    void addToYule(Yule yule);

    void addToLanmuBiaoti(LanMuBiaoTi lb);
}
