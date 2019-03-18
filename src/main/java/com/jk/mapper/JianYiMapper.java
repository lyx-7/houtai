package com.jk.mapper;

import com.jk.bean.JianYi;

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
}
