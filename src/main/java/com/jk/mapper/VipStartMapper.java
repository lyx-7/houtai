package com.jk.mapper;

import com.jk.bean.vipStart;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VipStartMapper {

    List<vipStart> getVipStart(vipStart v);

    vipStart getVipStartById(Integer id);

    void addVipStart(vipStart v);
    @Select("select vipname from t_vip where id=#{userid}")
    String getUser(Integer userid);
}
