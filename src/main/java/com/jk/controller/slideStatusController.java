package com.jk.controller;

import com.jk.bean.SlideShow;
import com.jk.service.SlideStatudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class slideStatusController {

  @Resource
  SlideStatudeService slideStatudeService;

  @RequestMapping("getSlide")
    public List<SlideShow> getSlide(){
      return slideStatudeService.getSlide();
  }

    @RequestMapping("updateSlide")
    public void updateSlide(Integer id,Integer status){
        slideStatudeService.updateSlide(id,status);
    }
}
