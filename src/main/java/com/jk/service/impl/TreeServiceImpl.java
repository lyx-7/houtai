package com.jk.service.impl;

import com.jk.bean.Tree;
import com.jk.mapper.TreeMapper;
import com.jk.service.TreeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TreeServiceImpl implements TreeService {
    @Resource
    TreeMapper treeMapper;
    @Override
    public List<Tree> getTree() {
        List<Tree> tree = treeMapper.getTree(0);
        queryTreeByPid(tree);
        return tree;
    }

    private void queryTreeByPid(List<Tree> tree) {
        for (Tree tree2 : tree) {
            List<Tree> tree3 = treeMapper.getTree(tree2.getId());
            queryTreeByPid(tree3);
            tree2.setChildren(tree3);
        }
    }
}
