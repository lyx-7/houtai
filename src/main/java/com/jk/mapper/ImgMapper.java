package com.jk.mapper;

import com.jk.bean.ImgInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImgMapper {
    List<ImgInfo> queryImgInfo(ImgInfo imgInfo);

    void addImgInfo(ImgInfo imgInfo);

    void updateImgInfo(ImgInfo imgInfo);

    ImgInfo getImgById(Integer id);

    void deleteImg(@Param("ids") String ids);
}
