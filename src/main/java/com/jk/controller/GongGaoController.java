package com.jk.controller;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.GongGao;
import com.jk.service.GongGaoService;
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
public class GongGaoController {
 @Resource
 GongGaoService gongGaoService;
 @RequestMapping("getGongGao")
 public SendPage getGongGao(ReceivePage rp, GongGao gg){
    return gongGaoService.getGongGao(rp,gg);
 }
 @RequestMapping("addputonggg")
 public String addputonggg(GongGao gg){
    return gongGaoService.addputonggg(gg);
 }
 @RequestMapping("getGGao")
 public SendPage getGGao(ReceivePage rp,GongGao gg){
    return gongGaoService.getGGao(rp,gg);
 }
 @RequestMapping("addGGao")
 public String addGGao(GongGao gg){
     gongGaoService.addGGao(gg);
  return "1";
 }
}
