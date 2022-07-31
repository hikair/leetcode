package com.tree.middle;

import com.tree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxLevelSumTest {

    MaxLevelSum obj = new MaxLevelSum();

    @Test
    public void maxLevelSum() {
        TreeNode root = new TreeNode(1, new TreeNode(7, new TreeNode(7),  new TreeNode(-8)), new TreeNode(0));
        assertEquals(2, obj.maxLevelSum(root));
    }
}