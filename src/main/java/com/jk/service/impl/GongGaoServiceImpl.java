package com.jk.service.impl;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.github.pagehelper.PageHelper;
import com.jk.bean.GongGao;
import com.jk.mapper.GongGaoMapper;
import com.jk.service.GongGaoService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Service;
import sun.security.util.Length;

import javax.annotation.Resource;
import java.util.List;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@Service
public class GongGaoServiceImpl implements GongGaoService {
 @Resource
 GongGaoMapper gongGaoMapper;

 @Override
 public SendPage getGongGao(ReceivePage rp, GongGao gg) {
  List<GongGao> list=gongGaoMapper.getGongGao(gg);
  PageHelper.startPage(rp.getPage(),rp.getRows());
  List<GongGao> list2=gongGaoMapper.getGongGao(gg);
  SendPage sp=new SendPage(list.size(),list2);
  return sp;
 }

 @Override
 public String addputonggg(GongGao gg) {
  Integer id=gongGaoMapper.addputonggg(gg);
  gongGaoMapper.updategg(gg.getId());
  return "1";
 }

 @Override
 public SendPage getGGao(ReceivePage rp,GongGao gg) {
  List<GongGao> count=gongGaoMapper.getGGao();
  PageHelper.startPage(rp.getPage(),rp.getRows());
  List<GongGao> list=gongGaoMapper.getGGao();
  for (GongGao gongGao : list) {
   gongGao.setStarttime(gongGao.getStarttime().substring(0, gongGao.getStarttime().length()-2));
   gongGao.setEndtime(gongGao.getEndtime().substring(0, gongGao.getEndtime().length()-2));
  }
  SendPage sp=new SendPage(count.size(),list);
  return sp;
 }

 @Override
 public void addGGao(GongGao gg) {
  Integer id=gongGaoMapper.addGGao(gg);
  gongGaoMapper.updateaddGGao(gg.getId());
 }
}
