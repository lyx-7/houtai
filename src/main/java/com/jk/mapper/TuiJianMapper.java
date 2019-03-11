package com.jk.mapper;

import com.jk.bean.TuiJian;

import java.util.List;

public interface TuiJianMapper {
    List<TuiJian> getTuiJianList(TuiJian tuiJian);

    void updateToPass(Integer id);

    void updateToNoPass(Integer id);
}
