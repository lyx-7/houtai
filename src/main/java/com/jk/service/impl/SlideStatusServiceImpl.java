package com.jk.service.impl;

import com.jk.bean.SlideShow;
import com.jk.mapper.SlideStstusMapper;
import com.jk.service.SlideStatudeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 王杰
 * @create 2019/3/20
 * @since 1.0.0
 */
@Service
public class SlideStatusServiceImpl implements SlideStatudeService {

     @Resource
     SlideStstusMapper slideStstusMapper;

     @Override
     public List<SlideShow> getSlide() {

          return  slideStstusMapper.getSlide();
     }

     @Override
     public void updateSlide(Integer id, Integer status) {
          slideStstusMapper.updateSlide(id,status);
     }
}
