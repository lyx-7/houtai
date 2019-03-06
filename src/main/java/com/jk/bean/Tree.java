package com.jk.bean;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@Data
public class Tree implements Serializable {
 Integer id;
 String text;
 Integer pid;
 String url;
 List<Tree> children;
}
