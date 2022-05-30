package com.tree.simple;

import com.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;


public class SumRootToLeafTest {

    SumRootToLeaf obj = new SumRootToLeaf();

    @Test
    public void sumRootToLeaf() {
        TreeNode treeNode = new TreeNode(1, new TreeNode(0, new TreeNode(0), new TreeNode(1)), new TreeNode(1, new TreeNode(0), new TreeNode(1)));
        Assert.assertEquals(22, obj.sumRootToLeaf(treeNode));
    }
}