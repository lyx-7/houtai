package com.jk.controller;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.Vip;
import com.jk.service.JinYanService;
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
public class JinYanController {
 @Resource
 JinYanService jinYanService;
 @RequestMapping("getJInYan")
 public SendPage getJInYan(ReceivePage rp,Vip vip){
  return jinYanService.getJInYan(rp,vip);
 }
 @RequestMapping("updatejinYan")
 public void updatejinYan(int id,int type){
  jinYanService.updatejinYan(id,type);
 }
}
