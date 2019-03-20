package com.jk.mapper;

import com.jk.bean.SlideShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SlideStstusMapper {
    List<SlideShow> getSlide();

    void updateSlide(@Param("id") Integer id, @Param("status") Integer status);
}
