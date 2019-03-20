package com.jk.mapper;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.GongGao;
import com.jk.utils.SendPage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
public interface GongGaoMapper {
 List<GongGao> getGongGao(GongGao gg);

 Integer addputonggg(GongGao gg);
 @Update("update t_putonggonfgao set status=0 where id !=(${id})")
 void updategg(@Param("id") Integer id);
 List<GongGao> getGGao();
 Integer addGGao(GongGao gg);
 @Update("update t_zhongdagonggao set status=0 where id !=(${id})")
 void updateaddGGao(@Param("id")Integer id);
}
