package com.jk.controller;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.JianYi;
import com.jk.service.JianYiService;
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
public class JianYiController {
 @Resource
 JianYiService jianYiService;
 @RequestMapping("getJIanYi")
 public SendPage getJIanYi(ReceivePage rp, JianYi jy){
  return jianYiService.getJIanYi(rp,jy);
 }
 @RequestMapping("jieShou")
 public String jieShou(JianYi jy){
   jianYiService.jieShou(jy);
   return "1";
 }
 @RequestMapping("juJue")
 public String juJue(JianYi jy){
   jianYiService.juJue(jy);
   return "1";
 }
}
