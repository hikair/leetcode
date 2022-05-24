package com.tree.simple;

import com.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;


public class IsUnivalTreeTest {

    IsUnivalTree obj = new IsUnivalTree();

    @Test
    public void isUnivalTree() {
        TreeNode left = new TreeNode(5, null, new TreeNode(0));
        TreeNode right = new TreeNode(5, null, new TreeNode(5));
        Assert.assertFalse(obj.isUnivalTree(new TreeNode(5, null, new TreeNode(5, left, right))));
        Assert.assertFalse(obj.isUnivalTree(new TreeNode(1,new TreeNode(2,new TreeNode(5),new TreeNode(6)),new TreeNode(3,new TreeNode(4),null))));
        Assert.assertTrue(obj.isUnivalTree(new TreeNode(1,new TreeNode(1,new TreeNode(1),new TreeNode(1)),new TreeNode(1,new TreeNode(1),null))));
    }
}