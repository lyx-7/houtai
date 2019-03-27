package com.jk.mapper;

import com.jk.bean.JiFen;
import com.jk.bean.JianYi;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * &lt;pre&gt;${enclosing_method}(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：${date} ${time}
 * ${tags}&lt;/pre&gt;
 */
public interface JianYiMapper {
 List<JianYi> getJIanYi(JianYi jy);

 void jieShou(JianYi jy);

 void juJue(JianYi jy);
 @Select("select * from t_jifen where userid=#{userid}")
 JiFen getJiFen(Integer userid);
 @Insert("insert into t_jifen(jifen,yue,userid) value(50,0,#{userid})")
 void addjiFen2(Integer userid);
@Update("update t_jifen set jifen=jifen+50 where userid=#{userid}")
 void updatejiFen2(Integer userid);
 @Insert("insert into t_pinglun_state(time,vipid,info,pluserid) value(sysdate(),#{userid},#{text},0)")
 void addpinglunStart(JianYi jy);
}
