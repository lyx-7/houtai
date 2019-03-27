package com.jk.mapper;

import com.jk.bean.LanMu;
import com.jk.bean.LanMuBiaoTi;
import com.jk.bean.TiYu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TiYuMapper {


    void addTiYu(LanMuBiaoTi lanMuBiaoTi);

    List<TiYu> querybiaotiid(@Param("tablename") String tablename);

    List<LanMu> querylanmuid(String tablename);

    List<LanMuBiaoTi> getPageList(LanMuBiaoTi lanMuBiaoTi);

    LanMuBiaoTi queryList(LanMuBiaoTi lanMuBiaoTi);

    LanMuBiaoTi queryLanMu(Integer biaotiid);
}
