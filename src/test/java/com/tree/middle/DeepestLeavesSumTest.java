package com.tree.middle;

import com.tree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeepestLeavesSumTest {

    DeepestLeavesSum obj = new DeepestLeavesSum();

    @Test
    public void deepestLeavesSum() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4, new TreeNode(7), null), new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(6, null, new TreeNode(8))));
        assertEquals(15, obj.deepestLeavesSum(root));
    }
}