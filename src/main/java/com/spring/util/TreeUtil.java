package com.spring.util;

import java.util.ArrayList;
import java.util.List;

import com.spring.domain.TreeNode;

public class TreeUtil {
	/**
     * 两层循环实现建树
     * @param treeNodes 传入的树节点列表
     * @return
     */
    public static List<TreeNode> bulid(List<TreeNode> treeNodes) {
        List<TreeNode> trees = new ArrayList<TreeNode>();
        for (TreeNode treeNode : treeNodes) {
            if (ObjectUtil.isEmpty(treeNode.getParentValue())) {
                trees.add(treeNode);
            }
            for (TreeNode it : treeNodes) {
            	if(ObjectUtil.isEmpty(it.getParentValue())) {
            		continue;
            	}
                if (it.getParentValue().equals(treeNode.getValue()+"")) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<TreeNode>());
                    }
                    treeNode.getChildren().add(it);
                }
            }
        }
        return trees;
    }
}
