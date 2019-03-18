package com.jk.mapper;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.Vip;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
public interface JinYanMapper {
 List<Vip> getJInYan(Vip vip);

 void updatejinYan(@RequestParam("id") int id);

 void updatejinYan2(int id);
}
