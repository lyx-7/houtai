package com.jk.service;

import com.jk.bean.MInGanCi;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

/**
 * &lt;pre&gt;${enclosing_method}(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：${date} ${time}
 * ${tags}&lt;/pre&gt;
 */
public interface MinGanCiService {
 SendPage getMinGanCi(MInGanCi m, ReceivePage rp);

 void addMinGanCi(MInGanCi m);

 void delMinGanCi(String id);

 MInGanCi updateMinGanCi(int id);
}
