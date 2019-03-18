package com.jk.service.impl;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.github.pagehelper.PageHelper;
import com.jk.bean.Vip;
import com.jk.mapper.JinYanMapper;
import com.jk.service.JinYanService;
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
public class JinYanServiceImpl implements JinYanService {
 @Resource
 JinYanMapper jinYanMapper;

 @Override
 public SendPage getJInYan(ReceivePage rp,Vip vip) {
  List<Vip> count=jinYanMapper.getJInYan(vip);
  PageHelper.startPage(rp.getPage(),rp.getRows());
  List<Vip> list=jinYanMapper.getJInYan(vip);
  SendPage sp=new SendPage(count.size(),list);
  return sp;
 }

 @Override
 public void updatejinYan(int id,int type) {
  if(type==1){
   jinYanMapper.updatejinYan(id);
  }else{
   jinYanMapper.updatejinYan2(id);
  }

 }
}
