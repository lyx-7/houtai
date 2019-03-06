package com.jk.controller;

import com.jk.bean.Tree;
import com.jk.service.TreeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/*import org.springframework.data.redis.core.RedisTemplate;*/
/*import java.util.concurrent.TimeUnit;*/


@Controller
@RequestMapping("tree")
public class TreeController {
 @Resource
 TreeService treeService;

/* @Resource
 private RedisTemplate<String, List<Tree>> redisTemplate;*/

 @RequestMapping("toView")
 public String toView(String url){
  return url;
 }
 @ResponseBody
 @RequestMapping("getTree")
 public List<Tree> getTree(){
 /* boolean tree_demo = redisTemplate.hasKey("tree_demo");
  if (tree_demo) {
   List<Tree> tree_demo1 = redisTemplate.opsForValue().get("tree_demo");
   return tree_demo1;
  }*/
  List<Tree> tree = treeService.getTree();
 // redisTemplate.opsForValue().set("tree_demo", tree, 30, TimeUnit.SECONDS);
  return tree;
 }
}
