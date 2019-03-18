package com.jk.mapper;

import com.jk.bean.Advert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdvertMapper {

    List<Advert> queryAdvert(Advert advert);

    void addInfo(Advert advert);

    Advert getById(Integer id);

    void updateInfo(Advert advert);

    void deletes(@Param("ids") String ids);
}
