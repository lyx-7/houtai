package com.jk.mapper;

import com.jk.bean.MInGanCi;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * &lt;pre&gt;${enclosing_method}(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：${date} ${time}
 * ${tags}&lt;/pre&gt;
 */
public interface MinGanCiMapper {
 List<MInGanCi> getMinGanCi(MInGanCi m);

 void addMinGanCi(MInGanCi m);

 void delMinGanCi(@RequestParam("id") String id);

 MInGanCi updateMinGanCi(int id);

 void updateMinGanCi2(MInGanCi m);
}
