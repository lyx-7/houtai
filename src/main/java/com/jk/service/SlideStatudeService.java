package com.jk.service;

import com.jk.bean.SlideShow;

import java.util.List;

public interface SlideStatudeService {
    List<SlideShow> getSlide();

    void updateSlide(Integer id, Integer status);
}
