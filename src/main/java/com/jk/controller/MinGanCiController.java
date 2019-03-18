package com.jk.controller;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.MInGanCi;
import com.jk.service.MinGanCiService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@RestController
public class MinGanCiController {
 @Resource
 MinGanCiService minGanCiService;
 @RequestMapping("getMinGanCi")
 public SendPage getMinGanCi(MInGanCi m, ReceivePage rp){
  SendPage sp=minGanCiService.getMinGanCi(m,rp);
    return sp;
 }
 @RequestMapping("addMinGanCi")
 public String addMinGanCi(MInGanCi m){
  minGanCiService.addMinGanCi(m);
    return "1";
 }
 @RequestMapping("delMinGanCi")
 public String delMinGanCi(String id){
  minGanCiService.delMinGanCi(id);
    return "1";
 }
 @RequestMapping("updateMinGanCi")
 public MInGanCi updateMinGanCi(int id){
    return minGanCiService.updateMinGanCi(id);
 }
}
