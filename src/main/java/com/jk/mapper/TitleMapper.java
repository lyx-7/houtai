package com.jk.mapper;


import com.jk.bean.TitleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TitleMapper {

    List<TitleInfo> queryTitleInfo(TitleInfo titleInfo);

    void addInfo(TitleInfo titleInfo);

    void updateInfo(TitleInfo titleInfo);

    TitleInfo getById(Integer id);

    void deletes(@Param("ids") String ids);

}
