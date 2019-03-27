package com.jk.service.impl;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.github.pagehelper.PageHelper;
import com.jk.bean.JiFen;
import com.jk.bean.JianYi;
import com.jk.mapper.JianYiMapper;
import com.jk.service.JianYiService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@Service
public class JianYiServiceImpl implements JianYiService {
 @Resource
 JianYiMapper jianYiMapper;

 @Override
 public SendPage getJIanYi(ReceivePage rp, JianYi jy) {
  List<JianYi> count=jianYiMapper.getJIanYi(jy);
  PageHelper.startPage(rp.getPage(),rp.getRows());
  List<JianYi> list=jianYiMapper.getJIanYi(jy);
  SendPage sp=new SendPage(count.size(),list);
  return sp;
 }

 @Override
 public void jieShou(JianYi jy) {
   jianYiMapper.jieShou(jy);
  jianYiMapper.addpinglunStart(jy);
  JiFen jf=jianYiMapper.getJiFen(jy.getUserid());
  if(jf==null){
   jianYiMapper.addjiFen2(jy.getUserid());
  }else{
   jianYiMapper.updatejiFen2(jy.getUserid());
  }
 }

 @Override
 public void juJue(JianYi jy) {
  jianYiMapper.juJue(jy);
 }
}
